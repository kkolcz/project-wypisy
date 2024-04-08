package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.ManufacturingProcess;

@Repository
public interface ManufacturingProcessRepository extends JpaRepository<ManufacturingProcess,Long> {
}
