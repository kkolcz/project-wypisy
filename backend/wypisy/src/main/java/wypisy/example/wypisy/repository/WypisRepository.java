package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wypisy.example.wypisy.model.Wypis;

public interface WypisRepository extends JpaRepository<Wypis,Long> {
}
