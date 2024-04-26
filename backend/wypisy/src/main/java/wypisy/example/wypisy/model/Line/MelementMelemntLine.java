package wypisy.example.wypisy.model.Line;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import wypisy.example.wypisy.model.ManufacturingElement;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class MelementMelemntLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne()
    @JoinColumn(name = "MELEMENT")
    @JsonIgnore
    @OrderBy("id")
    private ManufacturingElement mElement;

    @ManyToOne()
    @JoinColumn(name = "MELEMENTIN")
    @OrderBy("id")
    private ManufacturingElement mElementIN;
}
