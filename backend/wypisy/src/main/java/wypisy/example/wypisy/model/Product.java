package wypisy.example.wypisy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import wypisy.example.wypisy.model.Line.ProductLineElement;
import wypisy.example.wypisy.model.Line.ProductLineMElement;
import wypisy.example.wypisy.model.Line.WypisLine;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    private String nrM3;
    private String nameM3;
    private String description;



    @OneToMany(mappedBy = "product")

    private List<ProductLineMElement> productLineMElements=new ArrayList<>();

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<WypisLine> wypisLines=new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<ProductLineElement> productLineElements=new ArrayList<>();







}
