package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.MachineProgram;
import wypisy.example.wypisy.model.ManufacturingElement;
import wypisy.example.wypisy.model.Product;
import wypisy.example.wypisy.model.Tool;
import wypisy.example.wypisy.repository.MachineProgramRepository;
import wypisy.example.wypisy.repository.ManufacturingElementRepository;
import wypisy.example.wypisy.repository.ToolRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProgramService {

    private final MachineProgramRepository machineProgramRepository;
    private final ToolRepository toolRepository;
    private final ManufacturingElementRepository elementRepository;

    public MachineProgram create(MachineProgram program){

        MachineProgram newProgram=new MachineProgram(

                null,
                program.getNameMachine(),
                program.getNrProgram(),
                program.getDescription(),
                program.getToolList(),
                new ArrayList<>()
        );

        machineProgramRepository.save(newProgram);

        return newProgram;
    }





    public List<MachineProgram> getAll(){return machineProgramRepository.findAll();}

    public MachineProgram getProductById(Long id){return machineProgramRepository.findById(id).orElseThrow(()->new IllegalStateException("Program don't exist"));}


    public boolean deleteById(Long id){

        MachineProgram program=machineProgramRepository.findById(id).orElseThrow(()->new IllegalStateException("Program don't exist"));
        program.getToolList().forEach(t->t.getMachinePrograms().remove(program));
        toolRepository.saveAll(program.getToolList());

        program.getManufacturingElements().forEach(e->e.getMachinePrograms().remove(program));
        elementRepository.saveAll(program.getManufacturingElements());

        machineProgramRepository.deleteById(program.getId());

        return true;
    }

    public MachineProgram addToolToProgram(Long toolId,Long programID){

        MachineProgram program=machineProgramRepository.findById(programID).orElseThrow(()->new IllegalStateException("Program don't exist"));
        Tool tool =toolRepository.findById(toolId).orElseThrow(()->new IllegalStateException("Tool don't exist"));

        if (!program.getToolList().contains(tool)){
            program.getToolList().add(tool);
            tool.getMachinePrograms().add(program);
        }

        toolRepository.save(tool);
        machineProgramRepository.save(program);

        return program;
    }
    public MachineProgram delateToolToProgram(Long toolId,Long programID){

        MachineProgram program=machineProgramRepository.findById(programID).orElseThrow(()->new IllegalStateException("Program don't exist"));
        Tool tool =toolRepository.findById(toolId).orElseThrow(()->new IllegalStateException("Tool don't exist"));

        if (program.getToolList().contains(tool)){
            program.getToolList().remove(tool);
            tool.getMachinePrograms().remove(program);
        }

        toolRepository.save(tool);
        machineProgramRepository.save(program);

        return program;
    }


    public MachineProgram changeById(MachineProgram newProgram){

        MachineProgram program=machineProgramRepository.findById(newProgram.getId()).orElseThrow(()->new IllegalStateException("Program don't exist"));

        program.setNameMachine(newProgram.getNameMachine());
        program.setNrProgram(newProgram.getNrProgram());
        program.setDescription(newProgram.getDescription());



        return program;
    }






}
