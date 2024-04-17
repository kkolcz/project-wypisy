package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.ProcessCategory;
@Repository
public interface ProcessCategoryRepository extends JpaRepository<ProcessCategory,Long> {
}
