package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.Tool;

@Repository
public interface ToolRepository extends JpaRepository<Tool,Long> {
}
