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
			MachineProgramRepository machineProgramRepository

	) {


		return args -> {

			Tool tool=new Tool(null,"Q12-T6",null,null,null);
			toolRepository.save(tool);
			ManufacturingProcess manufacturingProcess= new ManufacturingProcess(null,"Frezowanie-CNC","CNC","",null);
			manufacturingProcessRepository.save(manufacturingProcess);
			MachineProgram machineProgram=new MachineProgram(null,"CNC1","D00000012","",null,null);
			machineProgramRepository.save(machineProgram);
			ManufacturingElement manufacturingElement=new ManufacturingElement(null,"Formatka 2",new BigDecimal("2"),"",null,null,null);
			manufacturingElementRepository.save(manufacturingElement);

			Material material= new Material(null,"Sklajka","1500x1500",null);
			materialRepository.save(material);

			Product newProduct = new Product(null, "222", "222", "222", "222",new ArrayList<>());
			productRepository.save(newProduct);

			Element newElement=new Element(null,"Element1",new BigDecimal("1.00"),"Opis",new ArrayList<>(),material);
			elementRepository.save(newElement);



		};
	}
}