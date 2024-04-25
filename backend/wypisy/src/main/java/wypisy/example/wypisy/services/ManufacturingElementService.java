package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.*;
import wypisy.example.wypisy.model.Line.ProcessLineM;
import wypisy.example.wypisy.repository.*;

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


    public ManufacturingElement createMElement(ManufacturingElement element){

        ManufacturingElement newElement=new ManufacturingElement(

                null,
                element.getName(),
                element.getLength(),
                element.getWidth(),
                element.getHeight(),
                element.getDescription(),
                element.getProductLineMElements(),
                element.getProcessLineMS(),
                element.getElementMElementLines(),
                element.getMaterial()



        );

        elementRepository.save(newElement);


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




    public ManufacturingElement changeById (ManufacturingElement newElement){

        ManufacturingElement element=elementRepository.findById(newElement.getId()).orElseThrow(()->new IllegalStateException("M Element don't exist"));

        element.setName(newElement.getName());
        element.setLength(newElement.getLength());
        element.setWidth(newElement.getWidth());
        element.setHeight(newElement.getHeight());
        element.setDescription(newElement.getDescription());

        elementRepository.save(element);

        return element;
    }


    public boolean addProcess(Long processId,Long mElementId){

        ManufacturingElement element=elementRepository.findById(mElementId).orElseThrow(()->new IllegalStateException("M Element don't exist"));
        ManufacturingProcess process=processRepository.findById(processId).orElseThrow(()->new IllegalStateException("Process don't exist"));

        ProcessLineM processLineM =new ProcessLineM(null,element,process);
        processLineRepository.save(processLineM);


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














}
