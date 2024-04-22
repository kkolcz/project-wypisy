package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.Location;
import wypisy.example.wypisy.model.ManufacturingElement;
import wypisy.example.wypisy.model.Material;
import wypisy.example.wypisy.model.Tool;
import wypisy.example.wypisy.repository.LocationRepository;
import wypisy.example.wypisy.repository.ManufacturingProcessRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationService {

    public final LocationRepository locationRepository;
    public final ManufacturingProcessRepository manufacturingProcessRepository;


    public Location create(Location location){

        Location newLocation=new Location(
                null,
                location.getName(),
                location.getDescription(),
                location.getProcess()
        );

        locationRepository.save(newLocation);
        return location;

    }

    public List<Location> getAll(){return locationRepository.findAll();}

    public Location getById(Long id){return locationRepository.findById(id).orElseThrow(()->new IllegalStateException("Location don't exist"));}

    public boolean deleteById(Long id){

        Location location =locationRepository.findById(id).orElseThrow(()->new IllegalStateException("Location don't exist"));

        location.getProcess().forEach(l->l.setLocation(null));
        manufacturingProcessRepository.saveAll(location.getProcess());

        locationRepository.deleteById(location.getId());
        return true;
    }

    public Location changeById(Location newLocation){

        Location location= locationRepository.findById(newLocation.getId()).orElseThrow(()->new IllegalStateException("Location don't exist"));

        location.setName(newLocation.getName());
        location.setDescription(newLocation.getDescription());

        locationRepository.save(location);
        return  location;

    }












}
