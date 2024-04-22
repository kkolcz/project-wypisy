package wypisy.example.wypisy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wypisy.example.wypisy.model.*;

import java.util.List;

public interface WypisRepository extends JpaRepository<Wypis,Long> {


//    @Query(value = "Select Wypis from WypisLine WL join  ProductLineMElement PL on WL.product=PL.product where WL.wypis=:wypis ")
//   public List<ManufacturingElement> getMelement(Wypis wypis);
////      +"join  ManufacturingProcess EP on PL.manufacturingElement=EP.manufacturingElements"





//    @Query(value = "Select manuelement_id from public.wypis_line as WL join  public.product_linemelement as PL on WL.product=PL.product join  public.melement_process as EP on PL.melement=EP.manuelement_id " ,nativeQuery = true)
//   public List<ManufacturingElement> getMelement();



}

