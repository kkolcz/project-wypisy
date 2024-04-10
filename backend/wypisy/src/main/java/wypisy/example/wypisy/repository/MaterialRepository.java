package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.Material;
@Repository
public interface MaterialRepository extends JpaRepository<Material,Long> {
}
