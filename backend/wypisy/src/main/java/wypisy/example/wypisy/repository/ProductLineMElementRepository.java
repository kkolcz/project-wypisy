package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.ProductLineMElement;
@Repository
public interface ProductLineMElementRepository extends JpaRepository<ProductLineMElement,Long> {
}
