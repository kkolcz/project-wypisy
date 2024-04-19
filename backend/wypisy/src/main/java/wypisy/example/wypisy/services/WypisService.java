package wypisy.example.wypisy.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import wypisy.example.wypisy.model.DTO.WypisLineDTO;
import wypisy.example.wypisy.model.Product;
import wypisy.example.wypisy.model.Tool;
import wypisy.example.wypisy.model.Wypis;
import wypisy.example.wypisy.model.WypisLine;
import wypisy.example.wypisy.repository.ProductRepository;
import wypisy.example.wypisy.repository.WypisLineRepository;
import wypisy.example.wypisy.repository.WypisRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WypisService {

    private final WypisRepository wypisRepository;
    private final WypisLineRepository wypisLineRepository;
    private final ProductRepository productRepository;




    public Wypis create(Wypis wypis){

        Wypis newWypis=new Wypis(
                null ,
                LocalDateTime.now(),
                new ArrayList<>()

        );
        wypisRepository.save(wypis);
        return wypis;

    }



    public List<Wypis> getAll(){return wypisRepository.findAll();}

    public Wypis getById(Long id){return wypisRepository.findById(id).orElseThrow(()->new IllegalStateException("Wypis don't exist"));}

    public Wypis addProductToWypis(WypisLineDTO wypisLineDTO){

        //.orElseThrow(()->new IllegalStateException("Tool don't exist"));
        Wypis wypis=wypisRepository.findById(wypisLineDTO.getWypisId()).orElseThrow(()->new IllegalStateException("WYPISY don't exist"));
        Product product=productRepository.findById(wypisLineDTO.getProductId()).orElseThrow(()->new IllegalStateException("Product don't exist"));

        boolean i=wypis.getWypisLines()
                .stream()
                .anyMatch(
                        p->p.getProduct().equals(product)&&p.getWypis().equals(wypis)
                );

        if(i==false){
            WypisLine wypisLine =new WypisLine(
                    null,
                    wypis,
                    product,
                    wypisLineDTO.getUnit()
            );
            wypis.getWypisLines().add(wypisLine);
            wypisLineRepository.save(wypisLine);
        }else {
            wypis.getWypisLines().forEach(p->{
                if (p.getProduct().equals(product)&&p.getWypis().equals(wypis)){

                    p.setUnit(p.getUnit().add(wypisLineDTO.getUnit()));
                    wypisLineRepository.save(p);
                }
            });
        }

        return wypis;
    }
    public boolean delateProductFromWypis(Long wypisLineId){
        WypisLine wypisLine=wypisLineRepository.findById(wypisLineId).orElseThrow(()->new IllegalStateException("Wypis Line don't exist"));
        wypisLineRepository.deleteById(wypisLineId);
        return true;
    }

    public boolean changeWypisLineUnit(Long wypisLineId, BigDecimal newUnit){
        WypisLine wypisLine=wypisLineRepository.findById(wypisLineId).orElseThrow(()->new IllegalStateException("Wypis Line don't exist"));
        wypisLine.setUnit(newUnit);
        wypisLineRepository.save(wypisLine);
        return true;
    }

//    public Context setData() {
//
//        Context context = new Context();
//
////        Map<String, Object> data = new HashMap<>();
////
////        data.put("employees", empolyeeList);
////
////        context.setVariables(data);
//
//        return context;
//    }






}
