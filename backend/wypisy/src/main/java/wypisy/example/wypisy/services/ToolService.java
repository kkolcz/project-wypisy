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
import wypisy.example.wypisy.repository.ManufacturingProcessRepository;
import wypisy.example.wypisy.repository.ToolRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ToolService {
    private final ToolRepository toolRepository;
    private final ManufacturingProcessRepository processRepository;

    public Tool createTool(Tool tool){
            Tool newTool=new Tool(
                    null,
                    tool.getName(),
                    tool.getDescription(),
                    new ArrayList<>()
            );

            toolRepository.save(newTool);

            return newTool;
    }

    public List<Tool> getAll(){return toolRepository.findAll();}

    public Tool getById(Long id){return toolRepository.findById(id).orElseThrow(()->new IllegalStateException("Tool don't exist"));}

    public boolean deleteById(Long id){

        Tool tool =toolRepository.findById(id).orElseThrow(()->new IllegalStateException("Tool don't exist"));
        tool.getProcessList().forEach(p ->p.getToolList().remove(tool) );
        processRepository.saveAll(tool.getProcessList());
        toolRepository.deleteById(id)

        ;return true;}

    public Tool changeById(Tool newtool){

        Tool tool =toolRepository.findById(newtool.getId()).orElseThrow(()->new IllegalStateException("Tool don't exist"));
        tool.setName(newtool.getName());
        tool.setDescription(newtool.getDescription());
        toolRepository.save(tool);
        return tool;

    }



}
