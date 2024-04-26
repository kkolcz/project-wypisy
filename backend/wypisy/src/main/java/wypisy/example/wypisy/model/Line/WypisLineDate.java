package wypisy.example.wypisy.model.Line;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import wypisy.example.wypisy.model.Line.WypisLine;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class WypisLineDate {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne()
    @JoinColumn(name = "WYPISLINE")
    @JsonIgnore
    @OrderBy("id")
    private WypisLine wypisLine;



    @NotNull
    @Column(name = "unit" ,columnDefinition = "DECIMAL(7,2)")
    @Digits(integer=9, fraction=2)
    private BigDecimal unit;


    @NotNull
    private LocalDate localDate;



}
