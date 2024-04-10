package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypisy.example.wypisy.model.MachineProgram;
@Repository
public interface MachineProgramRepository extends JpaRepository<MachineProgram,Long> {
}
