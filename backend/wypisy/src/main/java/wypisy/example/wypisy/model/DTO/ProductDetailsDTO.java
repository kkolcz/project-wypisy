package wypisy.example.wypisy.model.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductDetailsDTO {
    private Long id;
    private String name;
    private String nrM3;
    private String nameM3;
    private String description;
}
