package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.Element;
import wypisy.example.wypisy.model.ManufacturingElement;
import wypisy.example.wypisy.repository.ManufacturingElementRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManufacturingElementService {

    private final ManufacturingElementRepository elementRepository;

    public ManufacturingElement createMElement(ManufacturingElement element){

        ManufacturingElement newElement=new ManufacturingElement(

                null,
                element.getName(),
                element.getUnit(),
                element.getDescription(),
                null,
                null,
                null

        );

        elementRepository.save(newElement);


        return newElement;


    }





    public List<ManufacturingElement> getAll(){return elementRepository.findAll();}

    public ManufacturingElement getElementById(Long id){return elementRepository.findById(id).orElseThrow(()->new IllegalStateException("Element don't exist"));}





}
