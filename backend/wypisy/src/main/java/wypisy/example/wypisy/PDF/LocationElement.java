package wypisy.example.wypisy.PDF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wypisy.example.wypisy.model.ManufacturingElement;
import wypisy.example.wypisy.model.ManufacturingProcess;
import wypisy.example.wypisy.model.Product;
import wypisy.example.wypisy.model.Wypis;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationElement {

    private Product product;
    private ManufacturingElement element;
    private ManufacturingProcess process;
    private BigDecimal Unit;
    private String before;
    private String after;

}
