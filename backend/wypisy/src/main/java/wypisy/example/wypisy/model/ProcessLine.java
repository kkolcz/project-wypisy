package wypisy.example.wypisy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class ProcessLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne()
    @JoinColumn(name = "MELEMENT")
    @JsonIgnore
    private ManufacturingElement manufacturingElement;

    @ManyToOne()
    @JoinColumn(name = "PROCESS")
    private ManufacturingProcess process;



}
