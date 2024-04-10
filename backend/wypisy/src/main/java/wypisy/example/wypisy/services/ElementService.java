package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.Element;
import wypisy.example.wypisy.model.ManufacturingElement;
import wypisy.example.wypisy.model.Material;
import wypisy.example.wypisy.repository.ElementRepository;
import wypisy.example.wypisy.repository.ManufacturingElementRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ElementService {
    private final ElementRepository elementRepository;
    private final ManufacturingElementRepository manufacturingElementRepository;

    public Element createElement(Element element,Boolean manufElement){

        Element newElement=new Element(
                null,
                element.getName(),
                element.getUnit(),
                element.getDescription(),
                null,
                null
        );
        elementRepository.save(newElement);

        if (manufElement == true) {

            ManufacturingElement manufacturingElement=new ManufacturingElement(
                    null,
                    element.getName(),
                    element.getUnit(),
                    element.getDescription(),
                    new ArrayList<>(),
                    null,
                    null


            );

            manufacturingElementRepository.save(manufacturingElement);

        }


        return newElement;
    }


    public List<Element> getAllElement(){return elementRepository.findAll();}

    public Element getElementById(Long id){return elementRepository.findById(id).orElseThrow(()->new IllegalStateException("Element don't exist"));}










}
