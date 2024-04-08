package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.Product;
import wypisy.example.wypisy.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(){

//        Product newProduct=new Product(null,product.getName(),product.getNrM3(),product.getNameM3(),product.getDescription());
        Product newProduct=new Product(null,"222","222","222","222");
        productRepository.save(newProduct);

        return newProduct;
    }

public List<Product>getAllProduct(){return productRepository.findAll();}


}
