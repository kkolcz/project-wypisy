package wypisy.example.wypisy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Entity
@NoArgsConstructor
@Slf4j
public class ManufacturingProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String location;
    @NotEmpty
    private String description;

    @ManyToOne()
    @JoinColumn(name = "manufacturingElementId")
    @NotNull
    private ManufacturingElement manufacturingElementId;

}
