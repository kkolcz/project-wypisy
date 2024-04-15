package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wypisy.example.wypisy.model.Location;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
