package wypisy.example.wypisy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import wypisy.example.wypisy.model.Product;
import wypisy.example.wypisy.repository.ProductRepository;
import wypisy.example.wypisy.services.ProductService;

@SpringBootApplication
public class WypisyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WypisyApplication.class, args);
	}


	@Bean
	CommandLineRunner run(ProductRepository productRepository) {
		return args -> {
			Product newProduct = new Product(null, "222", "222", "222", "222");
			productRepository.save(newProduct);


		};
	}
}