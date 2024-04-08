package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.Element;

@Repository
public interface ElementRepository extends JpaRepository< Element,Long> {
}
