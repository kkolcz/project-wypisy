package wypisy.example.wypisy.services;


import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import wypisy.example.wypisy.PDF.Generator;
import wypisy.example.wypisy.PDF.Pdf;
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

    public void export(HttpServletResponse response, long wypisId)  {
        Wypis wypis=wypisRepository.findById(wypisId).orElseThrow(()->new IllegalStateException("WYPISY don't exist"));

        Document document = new Document(PageSize.A4);
        //document.setMargins(60F,60F,10F,10F);
        document.setMargins(36, 36, 110, 36);
        try {
            PdfWriter writer =PdfWriter.getInstance(document, response.getOutputStream());

            Generator generator=new Generator();
            generator.setNr(wypis.getId().toString());

            writer.setPageEvent(generator);
            document.open();

            Font fontTitle= FontFactory.getFont((FontFactory.HELVETICA));
            Font font8 = FontFactory.getFont(FontFactory.HELVETICA, 8);
            fontTitle.setSize(18);

            Pdf pdf=new Pdf();
            pdf.ProductList(wypis,document);







            document.close();
            writer.close();



        }catch (Exception e){
            System.out.println("Error");
        }




    }








}
