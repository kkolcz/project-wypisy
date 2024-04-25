package wypisy.example.wypisy.model.DTO;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ElementDTO {

    private Long id;
    private String name;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal unit;
    private String description;
    private List<ProcessLineDTO> processLineDTOS;
    private Long materialId;

}
