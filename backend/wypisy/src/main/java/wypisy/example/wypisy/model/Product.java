package wypisy.example.wypisy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
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

    @ManyToMany
    @JoinTable(name="PRODUCT_ELEMENT",
            joinColumns={@JoinColumn(name="PRODUCT_ID")},
            inverseJoinColumns={@JoinColumn(name="ELEMENT_ID")}
    )

    private Collection<Element> elementList=new ArrayList<>();


    @OneToMany(mappedBy = "product")

    private Collection<ProductLineMElement> productLineMElements=new ArrayList<>();

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Collection<WypisLine> wypisLines=new ArrayList<>();

}
