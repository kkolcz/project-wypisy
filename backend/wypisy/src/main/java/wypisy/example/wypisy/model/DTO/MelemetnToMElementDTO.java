package wypisy.example.wypisy.model.DTO;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class MelemetnToMElementDTO {

    private Long elemenId;
    private Long elementInId;
    private BigDecimal unit;
}



