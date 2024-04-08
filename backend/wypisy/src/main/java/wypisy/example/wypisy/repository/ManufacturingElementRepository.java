package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.ManufacturingElement;
@Repository
public interface ManufacturingElementRepository extends JpaRepository< ManufacturingElement,Long> {
}
