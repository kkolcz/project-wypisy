package wypisy.example.wypisy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class MachineProgram {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nameMachine;
    @NotEmpty
    private String nrProgram;
    private String description;



    @ManyToMany
    @JoinTable(name="PROGRAM_TOOL",
            joinColumns={@JoinColumn(name="PROGRAM_ID")},
            inverseJoinColumns={@JoinColumn(name="TOOL_ID")}
    )
    private Collection<Tool> toolList=new ArrayList<>();

    @ManyToMany(mappedBy = "machinePrograms")
    @JsonIgnore
    private Collection<ManufacturingElement>manufacturingElements=new ArrayList<>();








}
