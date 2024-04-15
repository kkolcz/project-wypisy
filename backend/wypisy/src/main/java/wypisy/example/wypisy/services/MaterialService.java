package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.ManufacturingElement;
import wypisy.example.wypisy.model.Material;
import wypisy.example.wypisy.model.Tool;
import wypisy.example.wypisy.repository.ElementRepository;
import wypisy.example.wypisy.repository.ManufacturingElementRepository;
import wypisy.example.wypisy.repository.MaterialRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final ElementRepository elementRepository;
    private final ManufacturingElementRepository manufacturingElementRepository;


    public Material create(Material material){

        Material newMaterial=new Material(
                null,
                material.getName(),
                material.getDescription(),
                material.getLength(),
                material.getWidth(),
                material.getHeight(),
                new ArrayList<>(),
                new ArrayList<>()

        );
        materialRepository.save(newMaterial);
        return newMaterial;
    }

    public List<Material> getAll(){return materialRepository.findAll();}

    public Material getById(Long id){return materialRepository.findById(id).orElseThrow(()->new IllegalStateException("Material don't exist"));}

    public boolean deleteById(Long id){

        Material material =materialRepository.findById(id).orElseThrow(()->new IllegalStateException("Material don't exist"));
        material.getElementList().forEach(e->e.setMaterial(null));
        elementRepository.saveAll(material.getElementList());

        material.getMElementList().forEach(e->e.setMaterial(null));
        manufacturingElementRepository.saveAll(material.getMElementList());

        materialRepository.deleteById(material.getId());

        return true;
    }

    public Material changeById(Material newMaterial){

        Material material =materialRepository.findById(newMaterial.getId()).orElseThrow(()->new IllegalStateException("Material don't exist"));

        material.setName(newMaterial.getName());
        material.setDescription(newMaterial.getDescription());

        material.setLength(newMaterial.getLength());
        material.setHeight(newMaterial.getHeight());
        material.setWidth(newMaterial.getWidth());

        materialRepository.save(material);
        return material;

    }


















}
