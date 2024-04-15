package wypisy.example.wypisy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class ManufacturingElement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;


    @NotNull
    @Column(name = "length" ,columnDefinition = "DECIMAL(7,2)")
    @Digits(integer=9, fraction=2)
    private BigDecimal length;

    @NotNull
    @Column(name = "width" ,columnDefinition = "DECIMAL(7,2)")
    @Digits(integer=9, fraction=2)
    private BigDecimal width;


    @NotNull
    @Column(name = "height" ,columnDefinition = "DECIMAL(7,2)")
    @Digits(integer=9, fraction=2)
    private BigDecimal height;



    @Column(name = "unit" ,columnDefinition = "DECIMAL(7,2)")
    @Digits(integer=9, fraction=2)
    @NotNull
    private BigDecimal unit;

    private String description;

    @ManyToMany
    @JoinTable(name="MELEMENT_TOOL",
            joinColumns={@JoinColumn(name="MANUELEMENT_ID")},
            inverseJoinColumns={@JoinColumn(name="TOOL_ID")}
    )
    private Collection<Tool> toolList=new ArrayList<>();

    @ManyToMany
    @JoinTable(name="MELEMENT_PROCESS",
            joinColumns={@JoinColumn(name="MANUELEMENT_ID")},
            inverseJoinColumns={@JoinColumn(name="PROCESS_ID")}
    )
    private Collection<ManufacturingProcess> processesList=new ArrayList<>();

    @ManyToMany
    @JoinTable(name="MELEMENT_PROGRAM",
            joinColumns={@JoinColumn(name="MANUELEMENT_ID")},
            inverseJoinColumns={@JoinColumn(name="PROGRAM_ID")}
    )
    private Collection<MachineProgram> machinePrograms=new ArrayList<>();


    @ManyToOne()
    @JoinColumn(name = "MATERIAL")
    private Material material;














}
