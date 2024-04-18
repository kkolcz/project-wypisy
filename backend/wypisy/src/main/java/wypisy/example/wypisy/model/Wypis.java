package wypisy.example.wypisy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Wypis  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected LocalDateTime createDate;

    @OneToMany(mappedBy = "wypis")
    private Collection<WypisLine> wypisLines=new ArrayList<>();



}
