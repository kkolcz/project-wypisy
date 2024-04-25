package wypisy.example.wypisy.model.Line;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import wypisy.example.wypisy.model.Element;
import wypisy.example.wypisy.model.ManufacturingElement;
import wypisy.example.wypisy.model.Product;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class ProductLineElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne()
    @JoinColumn(name = "PRODUCT")
    @JsonIgnore
    private Product product;


    @ManyToOne()
    @JoinColumn(name = "ELEMENT")
    private Element element;

    @NotNull
    @Column(name = "unit" ,columnDefinition = "DECIMAL(7,2)")
    @Digits(integer=9, fraction=2)
    private BigDecimal unit;



}
