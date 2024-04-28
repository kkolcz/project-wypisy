package wypisy.example.wypisy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderBy("id")
    private Long id;
    @NotEmpty
    private String name;
    private String description;

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


    @OneToMany(mappedBy = "material")
    @JsonIgnore
    @OrderBy("id")
    private Collection<Element> elementList=new ArrayList<>();

    @OneToMany(mappedBy = "material")
    @JsonIgnore
    @OrderBy("id")
    private Collection<ManufacturingElement> mElementList=new ArrayList<>();


}
