package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.Location;
@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
}
