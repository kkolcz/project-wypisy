package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.*;
import wypisy.example.wypisy.repository.MachineProgramRepository;
import wypisy.example.wypisy.repository.ManufacturingElementRepository;
import wypisy.example.wypisy.repository.ManufacturingProcessRepository;
import wypisy.example.wypisy.repository.ToolRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProgramService {

    private final MachineProgramRepository machineProgramRepository;
    private final ManufacturingProcessRepository processRepository;

    public MachineProgram create(MachineProgram program){

        MachineProgram newProgram=new MachineProgram(

                null,
                program.getNameMachine(),
                program.getNrProgram(),
                program.getDescription(),
                program.getQtyForProgram(),
                new ArrayList<>()
        );

        machineProgramRepository.save(newProgram);

        return newProgram;
    }





    public List<MachineProgram> getAll(){return machineProgramRepository.findAll();}

    public MachineProgram getProductById(Long id){return machineProgramRepository.findById(id).orElseThrow(()->new IllegalStateException("Program don't exist"));}


    public boolean deleteById(Long id){

        MachineProgram program=machineProgramRepository.findById(id).orElseThrow(()->new IllegalStateException("Program don't exist"));



        program.getProcessList().forEach(p -> p.getMachinePrograms().remove(program));

        processRepository.saveAll(program.getProcessList());
        machineProgramRepository.deleteById(program.getId());

        return true;
    }


    public MachineProgram changeById(MachineProgram newProgram){

        MachineProgram program=machineProgramRepository.findById(newProgram.getId()).orElseThrow(()->new IllegalStateException("Program don't exist"));

        program.setNameMachine(newProgram.getNameMachine());
        program.setNrProgram(newProgram.getNrProgram());
        program.setDescription(newProgram.getDescription());
        program.setQtyForProgram(newProgram.getQtyForProgram());

        machineProgramRepository.save(program);

        return program;
    }






}
