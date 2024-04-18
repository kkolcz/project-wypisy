package wypisy.example.wypisy.model.DTO;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class WypisLineDTO {


    private Long productId;
    private Long wypisId;
    private BigDecimal unit;



}
