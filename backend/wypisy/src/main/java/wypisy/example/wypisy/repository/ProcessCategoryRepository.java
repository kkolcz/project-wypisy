package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wypisy.example.wypisy.model.ProcessCategory;

public interface ProcessCategoryRepository extends JpaRepository<ProcessCategory,Long> {
}
