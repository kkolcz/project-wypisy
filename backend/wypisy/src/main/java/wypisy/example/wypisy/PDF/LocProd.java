package wypisy.example.wypisy.PDF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wypisy.example.wypisy.model.Line.WypisLineDate;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocProd {


    private BigDecimal UnitProd;
    private List<WypisLineDate> mapWypisDat;
}
