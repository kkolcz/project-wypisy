package wypisy.example.wypisy.model.DTO;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductLineElementDTO {

    private Long productId;
    private Long elementId;
    private BigDecimal unit;
}
