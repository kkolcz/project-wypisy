package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.Line.ProcessLineE;

@Repository
public interface ProcessLineERepository extends JpaRepository<ProcessLineE,Long> {
}
