package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.WypisLine;

@Repository
public interface WypisLineRepository extends JpaRepository<WypisLine,Long> {
}
