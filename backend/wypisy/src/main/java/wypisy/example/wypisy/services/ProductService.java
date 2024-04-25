package wypisy.example.wypisy.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.DTO.ProductDetailsDTO;
import wypisy.example.wypisy.model.DTO.ProductLineElementDTO;
import wypisy.example.wypisy.model.DTO.ProductMElementDTO;
import wypisy.example.wypisy.model.Element;
import wypisy.example.wypisy.model.Line.ProductLineElement;
import wypisy.example.wypisy.model.ManufacturingElement;
import wypisy.example.wypisy.model.Product;
import wypisy.example.wypisy.model.Line.ProductLineMElement;
import wypisy.example.wypisy.repository.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ElementRepository elementRepository;
    private final ManufacturingElementRepository mElementRepository;
    private final ProductLineMElementRepository productLineMElementRepository;
    private final ProductLineElementRepository productLineElementRepository;

    public Product createProduct(Product product){

        Product newProduct=new Product(
                null,
                product.getName(),
                product.getNrM3(),
                product.getNameM3(),
                product.getDescription(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
//        Product newProduct=new Product(null,"222","222","222","222");
        productRepository.save(newProduct);

        return newProduct;
    }

    public List<Product>getAllProduct(){return productRepository.findAll();}

    public Product getProductById(Long id){return productRepository.findById(id).orElseThrow(()->new IllegalStateException("Product don't exist"));}

    public Product addElements(Long productId, List<ProductLineElementDTO>elements){

        Product product =productRepository.findById(productId).orElseThrow(()->new IllegalStateException("Product don't exist"));
        ArrayList<ProductLineElement>productLineElements=new ArrayList<>();

            elements.forEach(e->{

                Element element= elementRepository.findById(e.getElementId()).orElseThrow(()->new IllegalStateException("Element don't exist"));
                productLineElements.add(new ProductLineElement(null,product,element,e.getUnit()));

            });
            productLineElementRepository.saveAll(productLineElements);

        return product;


    }

    public boolean deleteElement(Long productId,Long elementLineId){

        Product product =productRepository.findById(productId).orElseThrow(()->new IllegalStateException("Product don't exist"));
        ProductLineElement line =productLineElementRepository.findById(elementLineId).orElseThrow(()->new IllegalStateException("Element line don't exist"));



        productLineElementRepository.deleteById(elementLineId);

        return true;


    }







    public Product addMElementToProduct(ProductMElementDTO productMElementDTO){

        Product product =productRepository.findById(productMElementDTO.getProductId()).orElseThrow(()->new IllegalStateException("Product don't exist"));
        ManufacturingElement mElement=mElementRepository.findById(productMElementDTO.getMElementId()).orElseThrow(()->new IllegalStateException("M Element don't exist"));


        boolean i=product.getProductLineMElements()
                .stream()
                .anyMatch(
                        n->n.getProduct().equals(product)&&n.getManufacturingElement().equals(mElement)
                );

        
        if (i==false){
            ProductLineMElement productLineMElement=new ProductLineMElement(
                null,
                product,
                mElement,
                productMElementDTO.getUnit()
        );
            product.getProductLineMElements().add(productLineMElement);
            productLineMElementRepository.save(productLineMElement);
        }else {
            product.getProductLineMElements().forEach(n->{
                if(n.getProduct().equals(product)&&n.getManufacturingElement().equals(mElement)){
                    n.setUnit(n.getUnit().add(productMElementDTO.getUnit()));
                    productLineMElementRepository.save(n);
                }

            });
        }
        




        return product;
    }
    public boolean deleteMElementFromProduct(Long productLineID){
        ProductLineMElement productLineMElement=productLineMElementRepository.findById(productLineID).orElseThrow(()->new IllegalStateException("Product Line don't exist"));
        productLineMElementRepository.deleteById(productLineID);

        return true;
    }
    public boolean changeProductMLineUnit(Long productLineID, BigDecimal newUnit){
        ProductLineMElement productLineMElement=productLineMElementRepository.findById(productLineID).orElseThrow(()->new IllegalStateException("Product Line don't exist"));
        productLineMElement.setUnit(newUnit);
        productLineMElementRepository.save(productLineMElement);

        return true;
    }


    public Product changeDetailsProduct (ProductDetailsDTO productDetailsDTO){
        Product product =productRepository.findById(productDetailsDTO.getId()).orElseThrow(()->new IllegalStateException("Product don't exist"));

        product.setName(productDetailsDTO.getName());
        product.setNrM3(productDetailsDTO.getNrM3());
        product.setNameM3(productDetailsDTO.getNameM3());
        product.setDescription(productDetailsDTO.getDescription());

        productRepository.save(product);
        return product;

    }
    public boolean delateProduct(Long productID){
        Product product =productRepository.findById(productID).orElseThrow(()->new IllegalStateException("Product don't exist"));
        productLineMElementRepository.deleteAll(product.getProductLineMElements());
        productRepository.delete(product);

        return true;
    }



















    //TODO
    // cheange basic string
    // Add / Delate element
    // Add / Delate Manufacturing element




















}
