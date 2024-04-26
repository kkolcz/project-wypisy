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
import wypisy.example.wypisy.model.Line.ElementMElementLine;
import wypisy.example.wypisy.model.Line.ProcessLineE;
import wypisy.example.wypisy.model.Line.ProductLineElement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Element {

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


    private String description;


    @OneToMany(mappedBy = "element")
    @JsonIgnore
    @OrderBy("id")
    private List<ProductLineElement> productLineElements=new ArrayList<>();

    @OneToMany(mappedBy = "element")
    @OrderBy("id")
    private List<ProcessLineE> processLineES=new ArrayList<>();

    @OneToMany(mappedBy = "element")
    @OrderBy("id")
    @JsonIgnore
    private List<ElementMElementLine> elementMElementLines=new ArrayList<>();




    @ManyToOne()
    @JoinColumn(name = "MATERIAL")
    private Material material;




}
