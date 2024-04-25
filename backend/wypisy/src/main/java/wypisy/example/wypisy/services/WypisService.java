package wypisy.example.wypisy.services;


import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import wypisy.example.wypisy.PDF.Generator;
import wypisy.example.wypisy.PDF.Pdf;
import wypisy.example.wypisy.model.*;
import wypisy.example.wypisy.model.DTO.WypisLineDTO;
import wypisy.example.wypisy.model.Line.WypisLine;
import wypisy.example.wypisy.model.Line.WypisLineDate;
import wypisy.example.wypisy.repository.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WypisService {

    private final WypisRepository wypisRepository;
    private final WypisLineRepository wypisLineRepository;
    private final WypisLineDateRepository wypisLineDateRepository;
    private final ProductRepository productRepository;

    private final LocationRepository locationRepository;




    public Wypis create(List<WypisLineDTO> wypisLineDTOList){

        Wypis newWypis=new Wypis(
                null ,
                LocalDateTime.now(),
                new ArrayList<>()

        );
        wypisRepository.save(newWypis);
        return addListofProducts(newWypis,wypisLineDTOList);

    }



    public List<Wypis> getAll(){return wypisRepository.findAll();}

    public Wypis getById(Long id){return wypisRepository.findById(id).orElseThrow(()->new IllegalStateException("Wypis don't exist"));}


    public Wypis addProducts (Long wypisID,List<WypisLineDTO> wypisLineDTOList){
        Wypis wypis=wypisRepository.findById(wypisID).orElseThrow(()->new IllegalStateException("WYPISY don't exist"));


        return addListofProducts(wypis,wypisLineDTOList);
    }









    public Wypis addListofProducts(Wypis wypis,List<WypisLineDTO> wypisLineDTOList){

        ArrayList<WypisLine> wypisLines=new ArrayList<>();
        if(wypis.getWypisLines().size()!=0){wypis.getWypisLines().forEach(w->wypisLines.add(w));}


            wypisLineDTOList.forEach(wl -> {

                Product product=productRepository.findById(wl.getProductId()).orElseThrow(()->new IllegalStateException("Product don't exist"));

                if(wypisLines.size()==0){
                    WypisLine wypisLine=new WypisLine(null,wypis,product,wl.getUnit(),new ArrayList<>());
                    wypisLine.getWypisLineDates().add(new WypisLineDate(null,wypisLine,wl.getUnit(),wl.getLocalDate()));
                    wypisLines.add(wypisLine);
                }
                else {

                  boolean f=wypisLines.stream().anyMatch(p->p.getProduct().equals(product)&&p.getWypis().equals(wypis));

                  if (f==false){

                      WypisLine wypisLine =new WypisLine(null, wypis, product, wl.getUnit(), new ArrayList<>());
                      wypisLine.getWypisLineDates().add(new WypisLineDate(null,wypisLine,wl.getUnit(),wl.getLocalDate()));
                      wypisLines.add(wypisLine);

                  }else {

                      wypisLines.forEach(p->{
                          if (p.getProduct().equals(product)&&p.getWypis().equals(wypis)){

                              p.setUnit(p.getUnit().add(wl.getUnit()));

                              //Sprawdzenie wy w wypis Line znajduje się taka data
                              boolean t= p.getWypisLineDates().stream().anyMatch(d->d.getLocalDate().equals(wl.getLocalDate()));

                              if (t==true){
                                  p.getWypisLineDates().forEach(d->{
                                      // TAK DODAJ DO DATY ILOSC
                                      if (d.getLocalDate().equals(wl.getLocalDate())){d.setUnit(d.getUnit().add(wl.getUnit()));}});
                              } else {
                                  //NIE DODAJ NOWA DATE
                                  WypisLineDate wypisLineDate=new WypisLineDate(null,p,wl.getUnit(),wl.getLocalDate());
                                  p.getWypisLineDates().add(wypisLineDate);

                              }

                          }
                      });
                  }
                }
            });

        wypis.setWypisLines(wypisLines);
        wypisLineRepository.saveAll(wypisLines);



        return wypis;
    }




















//    public Wypis addProductToWypis(WypisLineDTO wypisLineDTO){
//
//        //.orElseThrow(()->new IllegalStateException("Tool don't exist"));
//        Wypis wypis=wypisRepository.findById(wypisLineDTO.getWypisId()).orElseThrow(()->new IllegalStateException("WYPISY don't exist"));
//        Product product=productRepository.findById(wypisLineDTO.getProductId()).orElseThrow(()->new IllegalStateException("Product don't exist"));
//
//        boolean i=wypis.getWypisLines()
//                .stream()
//                .anyMatch(
//                        p->p.getProduct().equals(product)&&p.getWypis().equals(wypis)
//                );
//
//        if(i==false){
//            ArrayList data=new ArrayList();
//
//
//            WypisLine wypisLine =new WypisLine(
//                    null,
//                    wypis,
//                    product,
//                    wypisLineDTO.getUnit(),
//                    new ArrayList<>()
//
//            );
//            wypisLine.getWypisLineDates().add(new WypisLineDate(null,wypisLine,wypisLineDTO.getUnit(),wypisLineDTO.getLocalDate()));
//
//
//
//
//            wypis.getWypisLines().add(wypisLine);
//            wypisLineRepository.save(wypisLine);
//        }else {
//            wypis.getWypisLines().forEach(p->{
//                if (p.getProduct().equals(product)&&p.getWypis().equals(wypis)){
//
//                    p.setUnit(p.getUnit().add(wypisLineDTO.getUnit()));
//
//                    //Sprawdzenie wy w wypis Line znajduje się taka data
//                boolean t= p.getWypisLineDates().stream().anyMatch(d->d.getLocalDate().equals(wypisLineDTO.getLocalDate()));
//
//               if (t==true){
//                   p.getWypisLineDates().forEach(d->{
//                       // TAK DODAJ DO DATY ILOSC
//                       if (d.getLocalDate().equals(wypisLineDTO.getLocalDate())){d.setUnit(d.getUnit().add(wypisLineDTO.getUnit()));}});
//               } else {
//                   //NIE DODAJ NOWA DATE
//                   WypisLineDate wypisLineDate=new WypisLineDate(null,p,wypisLineDTO.getUnit(),wypisLineDTO.getLocalDate());
//                   wypisLineDateRepository.save(wypisLineDate);
//                   p.getWypisLineDates().add(wypisLineDate);
//
//               }
//
//
//                    wypisLineRepository.save(p);
//                }
//            });
//        }
//
//        return wypis;
//    }
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
        List<Location> locations=locationRepository.findAll();
//        List<ManufacturingElement> test=wypisRepository.getMelement();

        Document document = new Document(PageSize.A4);
        //document.setMargins(60F,60F,10F,10F);
        document.setMargins(36, 36, 110, 36);
        try {
            PdfWriter writer =PdfWriter.getInstance(document, response.getOutputStream());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            Generator generator=new Generator();
            generator.setNr(wypis.getId().toString());
            generator.setData(wypis.getCreateDate().format(formatter).toString());

            writer.setPageEvent(generator);
            document.open();

            Font fontTitle= FontFactory.getFont((FontFactory.HELVETICA));
            Font font8 = FontFactory.getFont(FontFactory.HELVETICA, 8);
            fontTitle.setSize(18);

            Pdf pdf=new Pdf();
            pdf.ProductList(wypis,document);
            pdf.categoryMelement(wypis,document,"all",locations,generator);







            document.close();
            writer.close();



        }catch (Exception e){
            System.out.println("Error");
        }




    }








}
