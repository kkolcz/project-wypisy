package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.*;
import wypisy.example.wypisy.repository.*;

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
    private final ProcessLineRepository processLineRepository;

    private final ToolRepository toolRepository;
    private final MachineProgramRepository programRepository;



    public ManufacturingProcess create(ManufacturingProcess process){


        ManufacturingProcess newProcess =new ManufacturingProcess(
                null,
                process.getName(),
                process.getCategory(),
                process.getTime(),
                process.getToolList(),
                process.getMachinePrograms(),
                process.getProcessLines(),
                process.getLocation()


        );

        processRepository.save(newProcess);

        return newProcess;

    }




    public List<ManufacturingProcess> getAll(){return processRepository.findAll();}

    public ManufacturingProcess getById(Long id){return processRepository.findById(id).orElseThrow(()->new IllegalStateException("Process don't exist"));}

    public boolean deleteById(Long id){

        ManufacturingProcess process =processRepository.findById(id).orElseThrow(()->new IllegalStateException("Process don't exist"));

        Location location=process.getLocation();
        location.getProcess().remove(process);
        process.getMachinePrograms().forEach(program -> program.getProcessList().remove(process));
        process.getToolList().forEach(tool -> tool.getProcessList().remove(process));

        toolRepository.saveAll( process.getToolList());
        programRepository.saveAll(process.getMachinePrograms());
        locationRepository.save(location);

        processLineRepository.deleteAll(process.getProcessLines());
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

        process.setLocation(location);
        location.getProcess().add(process);

        locationRepository.save(location);
        processRepository.save(process);

        return true;
    }
    public boolean deleteLocationFromProcess(Long locationId ,Long processid ){

        ManufacturingProcess process =processRepository.findById(processid).orElseThrow(()->new IllegalStateException("Process don't exist"));
        Location location =locationRepository.findById(locationId).orElseThrow(()->new IllegalStateException("Location don't exist"));


        process.setLocation(null);
        location.getProcess().remove(process);

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
    public boolean addTool(Long toolId,Long processid){
        ManufacturingProcess process =processRepository.findById(processid).orElseThrow(()->new IllegalStateException("Process don't exist"));
        Tool tool=toolRepository.findById(toolId).orElseThrow(()->new IllegalStateException("Tool don't exist"));

        process.getToolList().add(tool);
        tool.getProcessList().add(process);

        processRepository.save(process);
        toolRepository.save(tool);

        return true;
    }
    public boolean deleteTool(Long toolId,Long processid){
        ManufacturingProcess process =processRepository.findById(processid).orElseThrow(()->new IllegalStateException("Process don't exist"));
        Tool tool=toolRepository.findById(toolId).orElseThrow(()->new IllegalStateException("Tool don't exist"));

        process.getToolList().remove(tool);
        tool.getProcessList().remove(process);

        processRepository.save(process);
        toolRepository.save(tool);

        return true;
    }
    public boolean addProgram(Long programId,Long processid){
        ManufacturingProcess process =processRepository.findById(processid).orElseThrow(()->new IllegalStateException("Process don't exist"));
        MachineProgram program=programRepository.findById(programId).orElseThrow(()->new IllegalStateException("Program don't exist"));


        process.getMachinePrograms().add(program);
        program.getProcessList().add(process);

        processRepository.save(process);
        programRepository.save(program);

        return true;
    }
    public boolean deleteProgram(Long programId,Long processid){
        ManufacturingProcess process =processRepository.findById(processid).orElseThrow(()->new IllegalStateException("Process don't exist"));
        MachineProgram program=programRepository.findById(programId).orElseThrow(()->new IllegalStateException("Program don't exist"));


        process.getMachinePrograms().remove(program);
        program.getProcessList().remove(process);

        processRepository.save(process);
        programRepository.save(program);

        return true;
    }









}
