package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.ProcessLine;

@Repository
public interface ProcessLineRepository extends JpaRepository<ProcessLine,Long> {
}
