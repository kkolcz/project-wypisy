package wypisy.example.wypisy.PDF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wypisy.example.wypisy.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationElement {


    private ManufacturingElement element;
    private ManufacturingProcess process;
    private BigDecimal Unit;
    private String before;
    private String after;
    private HashMap<String, LocProd> mapWypisDat;






}
