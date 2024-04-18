package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.Location;
import wypisy.example.wypisy.model.ManufacturingProcess;
import wypisy.example.wypisy.model.Material;
import wypisy.example.wypisy.model.ProcessCategory;
import wypisy.example.wypisy.repository.LocationRepository;
import wypisy.example.wypisy.repository.ManufacturingElementRepository;
import wypisy.example.wypisy.repository.ManufacturingProcessRepository;
import wypisy.example.wypisy.repository.ProcessCategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProcessService {

    private final ManufacturingProcessRepository processRepository;
    private final LocationRepository locationRepository;
    private final ManufacturingElementRepository manufacturingElementRepository;
    private final ProcessCategoryRepository categoryRepository;



    public ManufacturingProcess create(ManufacturingProcess process){


        ManufacturingProcess newProcess =new ManufacturingProcess(
                null,
                process.getName(),
                process.getCategory(),
                process.getTime(),
                process.getManufacturingElements(),
                process.getLocationList()

        );

        processRepository.save(newProcess);

        return newProcess;

    }




    public List<ManufacturingProcess> getAll(){return processRepository.findAll();}

    public ManufacturingProcess getById(Long id){return processRepository.findById(id).orElseThrow(()->new IllegalStateException("Process don't exist"));}

    public boolean deleteById(Long id){

        ManufacturingProcess process =processRepository.findById(id).orElseThrow(()->new IllegalStateException("Process don't exist"));

        process.getLocationList().forEach(p->p.getManufacturingProcesses().remove(process));
        locationRepository.saveAll(process.getLocationList());

        process.getManufacturingElements().forEach(p->p.getProcessesList().remove(process));
        manufacturingElementRepository.saveAll(process.getManufacturingElements());

        processRepository.deleteById(process.getId());

        return true;
    }


    public ManufacturingProcess changeById (ManufacturingProcess newProcess){

        ManufacturingProcess process =processRepository.findById(newProcess.getId()).orElseThrow(()->new IllegalStateException("Process don't exist"));


        process.setName(newProcess.getName());
        process.setTime(newProcess.getTime());

        processRepository.save(process);

        return process;
    }


    public boolean addNewLocation(Long locationId ,Long processid ){

        ManufacturingProcess process =processRepository.findById(processid).orElseThrow(()->new IllegalStateException("Process don't exist"));
        Location location =locationRepository.findById(locationId).orElseThrow(()->new IllegalStateException("Location don't exist"));

        process.getLocationList().add(location);
        location.getManufacturingProcesses().add(process);

        locationRepository.save(location);
        processRepository.save(process);

        return true;
    }
    public boolean deleteLocationFromProcess(Long locationId ,Long processid ){

        ManufacturingProcess process =processRepository.findById(processid).orElseThrow(()->new IllegalStateException("Process don't exist"));
        Location location =locationRepository.findById(locationId).orElseThrow(()->new IllegalStateException("Location don't exist"));


        process.getLocationList().remove(location);
        location.getManufacturingProcesses().remove(process);

        locationRepository.save(location);
        processRepository.save(process);

        return true;

    }

    public boolean deleteCategory( Long processid){//From process
        ManufacturingProcess process =processRepository.findById(processid).orElseThrow(()->new IllegalStateException("Process don't exist"));
        process.setCategory(null);
        processRepository.save(process);
        return true;
    }
    public boolean changeAddCategory(Long categoryId,Long processid){//From process
        ManufacturingProcess process =processRepository.findById(processid).orElseThrow(()->new IllegalStateException("Process don't exist"));
        ProcessCategory processCategory=categoryRepository.findById(categoryId).orElseThrow(()->new IllegalStateException("Process Category don't exist"));
        process.setCategory(processCategory);
        processRepository.save(process);
        return true;
    }











}
