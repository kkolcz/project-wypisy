package wypisy.example.wypisy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
@Data
@Entity
@NoArgsConstructor
@Slf4j
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;

    @Column(name = "unit" ,columnDefinition = "DECIMAL(7,2)")
    @NotEmpty
    private BigDecimal unit;


    private String description;



}
