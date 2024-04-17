package wypisy.example.wypisy.model.DTO;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductMElementDTO {


    private Long productId;
    private Long mElementId;
    private BigDecimal unit;



}
