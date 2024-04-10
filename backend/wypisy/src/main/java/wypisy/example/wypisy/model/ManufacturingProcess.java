package wypisy.example.wypisy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class ManufacturingProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String location;

    private String description;




    @ManyToMany(mappedBy = "processesList")
    @JsonIgnore
    private Collection<ManufacturingElement>manufacturingElements=new ArrayList<>();

}
