package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.Product;
import wypisy.example.wypisy.model.Tool;
import wypisy.example.wypisy.repository.ToolRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ToolService {
    private final ToolRepository toolRepository;

    public Tool createTool(Tool tool){
            Tool newTool=new Tool(
                    null,
                    tool.getName(),
                    tool.getDescription(),
                    null,
                    null
            );

            toolRepository.save(newTool);

            return newTool;
    }






    public List<Tool> getAll(){return toolRepository.findAll();}

    public Tool getProductById(Long id){return toolRepository.findById(id).orElseThrow(()->new IllegalStateException("Tool don't exist"));}





}
