package wypisy.example.wypisy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import wypisy.example.wypisy.model.*;
import wypisy.example.wypisy.repository.*;
import wypisy.example.wypisy.services.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootApplication
public class WypisyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WypisyApplication.class, args);
	}


	@Bean
	CommandLineRunner run(
			ProductRepository productRepository,
			ElementRepository elementRepository,
			MaterialRepository materialRepository,
			ToolRepository toolRepository,
			ManufacturingProcessRepository manufacturingProcessRepository,
			ManufacturingElementRepository manufacturingElementRepository,
			MachineProgramRepository machineProgramRepository,
			LocationRepository locationRepository

	) {


		return args -> {

			Tool tool=new Tool(null,"Q12-T6","",new ArrayList<>(),new ArrayList<>());

			ManufacturingProcess manufacturingProcess= new ManufacturingProcess(null,"Frezowanie-CNC","CNC",new BigDecimal("15.3"),new ArrayList<>(),new ArrayList<>());

			MachineProgram machineProgram=new MachineProgram(null,"CNC1","D00000012","",new ArrayList<>(),new ArrayList<>());


			Location location=new Location(null,"CNC","MaszynaCNC",new ArrayList<>());



			Material material= new Material(null,"Sklajka","1500x1500",new BigDecimal("1500"),new BigDecimal("1500"),new BigDecimal("15"),new ArrayList<>(),new ArrayList<>());






			ManufacturingElement manufacturingElement=new ManufacturingElement(null,"Formatka 2",new BigDecimal("1000"),new BigDecimal("500"),new BigDecimal("15"),new BigDecimal("2"),"",new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),material);




			Product newProduct = new Product(null, "222", "222", "222", "222",new ArrayList<>());


			Element newElement=new Element(null,"Element1",new BigDecimal("1000"),new BigDecimal("500"),new BigDecimal("15"),new BigDecimal("1.00"),"Opis",new ArrayList<>(),material);














			tool.getMachinePrograms().add(machineProgram);
			machineProgram.getToolList().add(tool);

			manufacturingProcess.getLocationList().add(location);
			location.getManufacturingProcesses().add(manufacturingProcess);







			toolRepository.save(tool);
			locationRepository.save(location);
			materialRepository.save(material);

			machineProgramRepository.save(machineProgram);


			manufacturingProcessRepository.save(manufacturingProcess);
			manufacturingElementRepository.save(manufacturingElement);
			productRepository.save(newProduct);
			elementRepository.save(newElement);



		};
	}
}