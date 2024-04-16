package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.ManufacturingProcess;
import wypisy.example.wypisy.model.ProcessCategory;
import wypisy.example.wypisy.repository.ProcessCategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProcessCategoryService {


    private final ProcessCategoryRepository categoryRepository;


    public ProcessCategory create(ProcessCategory processCategory){

        ProcessCategory newCategory=new ProcessCategory(
                null,
                processCategory.getName(),
                processCategory.getDescription(),
                new ArrayList<>()
        );

        categoryRepository.save(newCategory);

        return newCategory;



    }

    public List<ProcessCategory> getAll(){return categoryRepository.findAll();}

    public ProcessCategory getById(Long id){return categoryRepository.findById(id).orElseThrow(()->new IllegalStateException("Process Category don't exist"));}

    public boolean deleteById(Long id){

        ProcessCategory processCategory=categoryRepository.findById(id).orElseThrow(()->new IllegalStateException("Process Category don't exist"));

        processCategory.getProcesses().forEach(p->p.setCategory(null));
        categoryRepository.deleteById(id);

        return true;
    }

    public ProcessCategory changeById (ProcessCategory processCategory){
        ProcessCategory category=categoryRepository.findById(processCategory.getId()).orElseThrow(()->new IllegalStateException("Process Category don't exist"));

        category.setName(processCategory.getName());
        category.setDescription(processCategory.getDescription());
        categoryRepository.save(category);
        return category;
    }







}
