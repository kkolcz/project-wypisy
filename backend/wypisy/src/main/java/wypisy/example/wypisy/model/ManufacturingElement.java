package wypisy.example.wypisy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@Slf4j
public class ManufacturingElement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;

    @Column(name = "unit" ,columnDefinition = "DECIMAL(7,2)")
    @NotEmpty
    private BigDecimal unit;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id",name = "manufacturingElementId")
    private Collection<ManufacturingProcess> processes;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id",name = "manufacturingElementId")
    private Collection<Tool> tools;

    private String description;




}
