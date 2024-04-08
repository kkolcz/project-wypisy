package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.AppUser;
import wypisy.example.wypisy.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
