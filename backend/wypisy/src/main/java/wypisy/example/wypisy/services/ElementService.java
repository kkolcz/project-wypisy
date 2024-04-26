package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.DTO.ElementDTO;
import wypisy.example.wypisy.model.DTO.ProcessLineDTO;
import wypisy.example.wypisy.model.Element;
import wypisy.example.wypisy.model.Line.ElementMElementLine;
import wypisy.example.wypisy.model.Line.ProcessLineE;
import wypisy.example.wypisy.model.Line.ProcessLineM;
import wypisy.example.wypisy.model.Line.ProductLineElement;
import wypisy.example.wypisy.model.ManufacturingElement;
import wypisy.example.wypisy.model.ManufacturingProcess;
import wypisy.example.wypisy.model.Material;
import wypisy.example.wypisy.repository.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ElementService {
    private final ElementRepository elementRepository;
    private final ManufacturingElementRepository manufacturingElementRepository;
    private final MaterialRepository materialRepository;
    private final ProductLineElementRepository productLineElementRepository;
    private final ManufacturingProcessRepository processRepository;
    private final ProcessLineERepository processLineERepository;
    private final ProcessLineRepository processLineRepository;

    private final ElementMElementLineRepository elementMElementLineRepository;

    public Element createElement(ElementDTO elementDTO, Boolean manufElement){

        Material material =materialRepository.findById(elementDTO.getMaterialId()).orElseThrow(()->new IllegalStateException("Material don't exist"));

        Element newElement=new Element(
                null,
                elementDTO.getName(),
                elementDTO.getLength(),
                elementDTO.getWidth(),
                elementDTO.getHeight(),
                elementDTO.getDescription(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                null

        );

       ArrayList<ProcessLineE > processLineE=new ArrayList<>();


        if (elementDTO.getProcessLineDTOS().size()!=0){
            elementDTO.getProcessLineDTOS().forEach(p -> {
              ManufacturingProcess process =processRepository.findById(p.getProcessId()).orElseThrow(()->new IllegalStateException("Process don't exist"));
              processLineE.add(new ProcessLineE(null,newElement,process));

            });




            newElement.setProcessLineES(processLineE);
        }

        newElement.setMaterial(material);

        elementRepository.save(newElement);
        processLineERepository.saveAll(processLineE);

        if (manufElement == true) {

            ManufacturingElement manufacturingElement=new ManufacturingElement(
                    null,
                    elementDTO.getName(),
                    elementDTO.getLength(),
                    elementDTO.getWidth(),
                    elementDTO.getHeight(),
                    elementDTO.getDescription(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    null

            );


            manufacturingElement.setMaterial(material);

            ArrayList<ProcessLineM> processLineMS=new ArrayList<>();

            if (elementDTO.getProcessLineDTOS().size()!=0){
                elementDTO.getProcessLineDTOS().forEach(p -> {
                    ManufacturingProcess process =processRepository.findById(p.getProcessId()).orElseThrow(()->new IllegalStateException("Process don't exist"));
                    processLineMS.add(new ProcessLineM(null,manufacturingElement,process));

                });

                manufacturingElement.setProcessLineMS(processLineMS);
            }



            manufacturingElementRepository.save(manufacturingElement);
            processLineRepository.saveAll(processLineMS);
            elementMElementLineRepository.save(new ElementMElementLine(null,newElement,manufacturingElement,new BigDecimal("1")));

        }


        return newElement;
    }


    public List<Element> getAllElement(){return elementRepository.findAll();}

    public Element getElementById(Long id){return elementRepository.findById(id).orElseThrow(()->new IllegalStateException("Element don't exist"));}

    public boolean deleteElement(Long elementId){
        Element element =elementRepository.findById(elementId).orElseThrow(()->new IllegalStateException("Element don't exist"));

        elementMElementLineRepository.deleteAll(element.getElementMElementLines());
        productLineElementRepository.deleteAll(element.getProductLineElements());
        processLineERepository.deleteAll(element.getProcessLineES());
        elementRepository.deleteById(elementId);

        return true;
    }

    public Element addProcess(Long id, ArrayList<ProcessLineDTO> process){
        Element element =elementRepository.findById(id).orElseThrow(()->new IllegalStateException("Element don't exist"));

        ArrayList<ProcessLineE> processes=new ArrayList<>();
        if (process.size()==0){
            throw new IllegalStateException("ProcesList is empty");
        }
        else {
            process.forEach(p->{
                ManufacturingProcess process1 =processRepository.findById(p.getProcessId()).orElseThrow(()->new IllegalStateException("Process don't exist"));
                processes.add(new ProcessLineE(null,element,process1));
            });
            processLineERepository.saveAll(processes);
        }


        return element;
    }

    public boolean deleteProcess(Long procesLineId){
      ProcessLineE processLineE=processLineERepository.findById(procesLineId).orElseThrow(()->new IllegalStateException("Process don't exist"));


      processLineERepository.delete(processLineE);



        return true;
    }







}
