package wypisy.example.wypisy.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

import java.util.Collection;

public class MachineProgram {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nameMachine;
    @NotEmpty
    private String nrProgram;
//    private Collection<Tool> tool;

    private String description;






}
