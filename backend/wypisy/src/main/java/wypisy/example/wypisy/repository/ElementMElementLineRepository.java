package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.Line.ElementMElementLine;

@Repository
public interface ElementMElementLineRepository extends JpaRepository<ElementMElementLine,Long> {
}
