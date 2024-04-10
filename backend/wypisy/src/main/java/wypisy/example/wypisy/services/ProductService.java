package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.Element;
import wypisy.example.wypisy.model.Product;
import wypisy.example.wypisy.repository.ElementRepository;
import wypisy.example.wypisy.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ElementRepository elementRepository;

    public Product createProduct(Product product){

        Product newProduct=new Product(
                null,
                product.getName(),
                product.getNrM3(),
                product.getNameM3(),
                product.getDescription(),
                new ArrayList<>()
        );
//        Product newProduct=new Product(null,"222","222","222","222");
        productRepository.save(newProduct);

        return newProduct;
    }

    public List<Product>getAllProduct(){return productRepository.findAll();}

    public Product getProductById(Long id){return productRepository.findById(id).orElseThrow(()->new IllegalStateException("Product don't exist"));}

    public Product addElementToProduct(Long productId,Long elementId){

        Product product =productRepository.findById(productId).orElseThrow(()->new IllegalStateException("Product don't exist"));
        Element element= elementRepository.findById(elementId).orElseThrow(()->new IllegalStateException("Exist don't exist"));


        if (!product.getElementList().contains(element)){

            product.getElementList().add(element);
            productRepository.save(product);
        }
        return product;


    }


    //TODO
    // cheange basic string
    // Add / Delate element
    // Add / Delate Manufacturing element




















}
