package wypisy.example.wypisy.model.DTO;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ElemetnToMElementDTO {


    private Long melemetId;
    private Long elementId;
    private BigDecimal unit;
}



