package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.WypisLineDate;

@Repository
public interface WypisLineDateRepository extends JpaRepository<WypisLineDate,Long> {
}
