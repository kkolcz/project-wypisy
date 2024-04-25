package wypisy.example.wypisy.model.Line;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import wypisy.example.wypisy.model.Product;
import wypisy.example.wypisy.model.Wypis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class WypisLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "WYPIS")
    @JsonIgnore
    private Wypis wypis;

    @ManyToOne()
    @JoinColumn(name = "PRODUCT")
    private Product product;


    @NotNull
    @Column(name = "unit" ,columnDefinition = "DECIMAL(7,2)")
    @Digits(integer=9, fraction=2)
    private BigDecimal unit;

    @OneToMany(mappedBy = "wypisLine",cascade = CascadeType.ALL)

    private List<WypisLineDate> wypisLineDates=new ArrayList<>();


}
