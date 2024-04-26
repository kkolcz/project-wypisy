package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.internal.InheritanceState;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.*;
import wypisy.example.wypisy.model.DTO.ElementDTO;
import wypisy.example.wypisy.model.DTO.ElemetnToMElementDTO;
import wypisy.example.wypisy.model.DTO.MelemetnToMElementDTO;
import wypisy.example.wypisy.model.DTO.ProcessLineDTO;
import wypisy.example.wypisy.model.Line.ElementMElementLine;
import wypisy.example.wypisy.model.Line.MelementMelemntLine;
import wypisy.example.wypisy.model.Line.ProcessLineM;
import wypisy.example.wypisy.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManufacturingElementService {

    private final ManufacturingElementRepository elementRepository;
    private final ManufacturingProcessRepository processRepository;
    private final MaterialRepository materialRepository;
    private final ProcessLineRepository processLineRepository;
    private final ProductLineMElementRepository productLineMElementRepository;
    private final ElementMElementLineRepository elementMElementLineRepository;
    private final MelementMelementRepository melementMelementRepository;

    private final ElementRepository elementERepository;


    public ManufacturingElement create(ElementDTO elementDTO){
        Material material =materialRepository.findById(elementDTO.getMaterialId()).orElseThrow(()->new IllegalStateException("Material don't exist"));
        ManufacturingElement newElement=new ManufacturingElement(

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

        newElement.setMaterial(material);

        ArrayList<ProcessLineM> processLineMS=new ArrayList<>();

        if (elementDTO.getProcessLineDTOS().size()!=0){
            elementDTO.getProcessLineDTOS().forEach(p -> {
                ManufacturingProcess process =processRepository.findById(p.getProcessId()).orElseThrow(()->new IllegalStateException("Process don't exist"));
                processLineMS.add(new ProcessLineM(null,newElement,process));

            });

            newElement.setProcessLineMS(processLineMS);
        }



        elementRepository.save(newElement);
        processLineRepository.saveAll(processLineMS);

        return newElement;


    }





    public List<ManufacturingElement> getAll(){return elementRepository.findAll();}

    public ManufacturingElement getElementById(Long id){return elementRepository.findById(id).orElseThrow(()->new IllegalStateException("M Element don't exist"));}

    public boolean deleteById(Long mElementId){

        ManufacturingElement element=elementRepository.findById(mElementId).orElseThrow(()->new IllegalStateException("M Element don't exist"));


        productLineMElementRepository.deleteAll(element.getProductLineMElements());
        processLineRepository.deleteAll(element.getProcessLineMS());

        element.setMaterial(null);

        elementRepository.deleteById(mElementId);


        return true;
    }




    public ManufacturingElement changeById (ElementDTO elementDTO){

        ManufacturingElement element=elementRepository.findById(elementDTO.getId()).orElseThrow(()->new IllegalStateException("M Element don't exist"));
        Material material =materialRepository.findById(elementDTO.getMaterialId()).orElseThrow(()->new IllegalStateException("Material don't exist"));
        element.setName(elementDTO.getName());
        element.setLength(elementDTO.getLength());
        element.setWidth(elementDTO.getWidth());
        element.setHeight(elementDTO.getHeight());
        element.setDescription(elementDTO.getDescription());
        element.setMaterial(material);

        elementRepository.save(element);

        return element;
    }


    public boolean addProcesses(Long mElementId, ArrayList<ProcessLineDTO>proceses){

        ManufacturingElement element=elementRepository.findById(mElementId).orElseThrow(()->new IllegalStateException("M Element don't exist"));


        ArrayList<ProcessLineM> processLineMS=new ArrayList<>();
        if (proceses.size()!=0) {
            proceses.forEach(p -> {
                ManufacturingProcess process = processRepository.findById(p.getProcessId()).orElseThrow(() -> new IllegalStateException("Process don't exist"));
                processLineMS.add(new ProcessLineM(null, element, process));

            });
            element.setProcessLineMS(processLineMS);
        }



        processLineRepository.saveAll(processLineMS);


        return true;
    }

    public boolean deleteProcess(Long processLineId,Long mElementId){


        ManufacturingElement element=elementRepository.findById(mElementId).orElseThrow(()->new IllegalStateException("M Element don't exist"));
        ProcessLineM processLineM =processLineRepository.findById(processLineId).orElseThrow(()->new IllegalStateException("Process Line don't exist"));
        processLineRepository.deleteById(processLineId);


        return true;
    }

    public boolean delateMaterial(Long mElementId){

        ManufacturingElement element=elementRepository.findById(mElementId).orElseThrow(()->new IllegalStateException("M Element don't exist"));

        element.setMaterial(null);
        elementRepository.save(element);

        return true;
    }

    public boolean changeAddMaterial(Long materialId,Long mElementId){

        ManufacturingElement element=elementRepository.findById(mElementId).orElseThrow(()->new IllegalStateException("M Element don't exist"));
        Material material=materialRepository.findById(materialId).orElseThrow(()->new IllegalStateException("Material don't exist"));

        element.setMaterial(material);
        elementRepository.save(element);

        return true;
    }

    public boolean addElement(Long mElemntId,ArrayList<ElemetnToMElementDTO> mElementDTOs){
        ManufacturingElement mElement=elementRepository.findById(mElemntId).orElseThrow(()->new IllegalStateException("M Element don't exist"));


        ArrayList<ElementMElementLine>elements=new ArrayList<>();

        if (mElementDTOs.size()==0){
            throw new IllegalStateException("List Element is empty");
        }else{

            mElementDTOs.forEach(me->{

                Element element=elementERepository.findById(me.getElementId()).orElseThrow(()->new IllegalStateException("M Element don't exist"));

               boolean i=mElement.getElementMElementLines().stream().anyMatch(e->e.getElement().equals(element));

               if (i==true){
                   mElement.getElementMElementLines().forEach(e->{

                       if (e.getElement().equals(element)){
                           e.setUnit(e.getUnit().add(me.getUnit()));
                       }
                   });

               }else {elements.add(new ElementMElementLine(null,element,mElement,me.getUnit()));}

            });


        }

        elementRepository.save(mElement);
        elementMElementLineRepository.saveAll(elements);

        return true;
    }

    public boolean deleteElement(Long lineId){

        ElementMElementLine element=elementMElementLineRepository.findById(lineId).orElseThrow(()->new IllegalStateException("elementMElementLine don't exist"));

        elementMElementLineRepository.deleteById(lineId);

        return true;
    }
    public boolean addMElementIN(Long mElemntId,ArrayList<MelemetnToMElementDTO> dtos){
        ManufacturingElement mElement=elementRepository.findById(mElemntId).orElseThrow(()->new IllegalStateException("M Element don't exist"));

        dtos.forEach(me->{
            ManufacturingElement mElementIN=elementRepository.findById(me.getElementInId()).orElseThrow(()->new IllegalStateException("M Element don't exist"));

            boolean i=mElement.getMelemntLinesIN().stream().anyMatch(e->e.getMElementIN().equals(mElementIN));
            boolean j=mElement.getMelemntLines().stream().anyMatch(e->e.getMElement().equals(mElementIN));


            if (i!=true&&j!=true&&!mElement.equals(mElementIN)){
                melementMelementRepository.save(new MelementMelemntLine(null,mElement,mElementIN));

            }


        });

        return true;
    }

    public boolean deleteMElementIN(Long lineId){
        MelementMelemntLine melementMelemntLine=melementMelementRepository.findById(lineId).orElseThrow(()->new IllegalStateException("MelementMElementLine don't exist"));

        melementMelementRepository.deleteById(lineId);


        return true;
    }





}
