package wypisy.example.wypisy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import wypisy.example.wypisy.model.*;
import wypisy.example.wypisy.repository.*;
import wypisy.example.wypisy.services.ProductService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
			LocationRepository locationRepository,
			ProcessCategoryRepository categoryRepository,
			ProductLineMElementRepository productLineMElementRepository,
			WypisLineRepository wypisLineRepository,
			WypisRepository wypisRepository,
			ProcessLineRepository processLineRepository

	) {


		return args -> {

			Wypis wypis=new Wypis(null, LocalDateTime.now(),new ArrayList<>());


			Tool tool=new Tool(null,"Q12-T6","",new ArrayList<>());

			Location location=new Location(null,"CNC","MaszynaCNC",new ArrayList<>());
			ProcessCategory category=new ProcessCategory(null,"CNC","CNC",new ArrayList<>());



			ManufacturingProcess manufacturingProcess= new ManufacturingProcess(null,"Frezowanie-CNC",category,new BigDecimal("15.3"),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),location);
			ManufacturingProcess manufacturingProcess1= new ManufacturingProcess(null,"Frezowanie-CNC",category,new BigDecimal("15.3"),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),location);
			ManufacturingProcess manufacturingProcess2= new ManufacturingProcess(null,"Frezowanie-CNC",category,new BigDecimal("15.3"),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),location);
			ManufacturingProcess manufacturingProcess3= new ManufacturingProcess(null,"Frezowanie-CNC",category,new BigDecimal("15.3"),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),location);


			MachineProgram machineProgram=new MachineProgram(null,"CNC1","D00000012","",new BigDecimal("0"),new ArrayList<>());






			Material material= new Material(null,"Sklajka","1500x1500",new BigDecimal("1500"),new BigDecimal("1500"),new BigDecimal("15"),new ArrayList<>(),new ArrayList<>());






			ManufacturingElement manufacturingElement=new ManufacturingElement(null,"Formatka 2",new BigDecimal("1000"),new BigDecimal("500"),new BigDecimal("15"),"",new ArrayList<>(),new ArrayList<>(),material);




			Product newProduct = new Product(null, "222", "222", "222", "222",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());


			Element newElement=new Element(null,"Element1",new BigDecimal("1000"),new BigDecimal("500"),new BigDecimal("15"),new BigDecimal("1.00"),"Opis",new ArrayList<>(),material);


			ProductLineMElement productLineMElement=new ProductLineMElement(null,newProduct,manufacturingElement,new BigDecimal("10"));

			ProcessLine processLine=new ProcessLine(null,manufacturingElement,manufacturingProcess);
			ProcessLine processLine1=new ProcessLine(null,manufacturingElement,manufacturingProcess1);
			ProcessLine processLine2=new ProcessLine(null,manufacturingElement,manufacturingProcess2);
			ProcessLine processLine3=new ProcessLine(null,manufacturingElement,manufacturingProcess3);



//
//		manufacturingElement.getProcessesList().add(manufacturingProcess);
//		manufacturingProcess.getManufacturingElements().add(manufacturingElement);
//
//		manufacturingElement.getToolList().add(tool);
//		tool.getManufacturingElements().add(manufacturingElement);
//
//		manufacturingElement.getMachinePrograms().add(machineProgram);
//		machineProgram.getManufacturingElements().add(manufacturingElement);

		WypisLine wypisLine=new WypisLine(null,wypis,newProduct,new BigDecimal("50"));


			categoryRepository.save(category);

			manufacturingProcess.getMachinePrograms().add(machineProgram);
			manufacturingProcess.getToolList().add(tool);



			manufacturingProcess.setLocation(location);
			location.getProcess().add(manufacturingProcess);

			manufacturingElement.getProductLineMElements();



			newProduct.getProductLineMElements().add(productLineMElement);




			wypisRepository.save(wypis);
			toolRepository.save(tool);
			locationRepository.save(location);
			materialRepository.save(material);

			machineProgramRepository.save(machineProgram);


			elementRepository.save(newElement);
			manufacturingProcessRepository.save(manufacturingProcess);
			manufacturingProcessRepository.save(manufacturingProcess1);
			manufacturingProcessRepository.save(manufacturingProcess2);
			manufacturingProcessRepository.save(manufacturingProcess3);





			manufacturingElementRepository.save(manufacturingElement);

			productRepository.save(newProduct);
			productLineMElementRepository.save(productLineMElement);
			wypisLineRepository.save(wypisLine);



			processLineRepository.save(processLine);
			processLineRepository.save(processLine1);
			processLineRepository.save(processLine2);
			processLineRepository.save(processLine3);

		};
	}
}