package wypisy.example.wypisy.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wypisy.example.wypisy.model.DTO.ProductDetailsDTO;
import wypisy.example.wypisy.model.DTO.ProductLineElementDTO;
import wypisy.example.wypisy.model.DTO.ProductMElementDTO;
import wypisy.example.wypisy.model.Product;
import wypisy.example.wypisy.model.Response;
import wypisy.example.wypisy.services.ProductService;

import java.math.BigDecimal;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/product")
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping("/element")
    public ResponseEntity<Response> addElement(@Valid @NotNull @RequestParam Long id_product,
                                               @RequestBody List<ProductLineElementDTO> productLineElementDTOS){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addElementsToProduct",productService.addElements(id_product,productLineElementDTOS)))
                            .message("addition Element to product was successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addElementsToProduct", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }

    @DeleteMapping("/element")
    public ResponseEntity<Response> addElement(@Valid @NotNull @RequestParam Long id_product,
                                               @Valid @NotNull @RequestParam Long elementLineId){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteElementsFromProduct",productService.deleteElement(id_product,elementLineId)))
                            .message("deleteElementsFromProduct")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteElementsFromProduct", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }

    @PostMapping("/add")
    public ResponseEntity<Response> addProduct(@RequestBody  Product product){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addProduct",productService.createProduct(product)))
                            .message("addition Product was successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addProduct", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }

    @GetMapping("/all")
    public ResponseEntity<Response>getAllProducts(){
        try {

            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("Products",productService.getAllProduct()))
                            .message("Returned all Products")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("all Products", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }


    }
        @GetMapping("/")
        public ResponseEntity<Response>getProductsById(@RequestParam Long productId) {
            try {

                return ResponseEntity.ok(
                        Response.builder()
                                .timeStamp(now())
                                .data(of("Products", productService.getProductById(productId)))
                                .message("Returned Products")
                                .status(HttpStatus.OK)
                                .statusCode(HttpStatus.OK.value())
                                .build()
                );
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(
                        Response.builder()
                                .timeStamp(now())
                                .data(of(" Product", false))
                                .message(e.getMessage())
                                .status(HttpStatus.BAD_REQUEST)
                                .statusCode(HttpStatus.BAD_REQUEST.value())
                                .build());
            }

        }
    @PostMapping("/melement/")
    public ResponseEntity<Response> addMElement(@RequestBody ProductMElementDTO productMElementDTO){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addMElementToProduct",productService.addMElementToProduct(productMElementDTO)))
                            .message("addition MElement was successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addMElement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }
    @DeleteMapping("/melement/")
    public ResponseEntity<Response> delateMElement(@RequestParam Long lineId){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteLine",productService.deleteMElementFromProduct(lineId)))
                            .message("deleteLine")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteLine", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }
    @PatchMapping("/melement/")
    public ResponseEntity<Response> changeLineUnit(@RequestParam Long lineId, @RequestParam BigDecimal newUnit){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("changeLineUnit",productService.changeProductMLineUnit(lineId,newUnit)))
                            .message("changeLineUnit")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("changeLineUnit", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }
    @DeleteMapping("/")
    public ResponseEntity<Response> delateProduct(@RequestParam Long productId){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteProduct",productService.delateProduct(productId)))
                            .message("delate Product")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteProduct", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }
    @PatchMapping("/")
    public ResponseEntity<Response> changeProductDetails(@RequestBody ProductDetailsDTO productDetailsDTO){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("changeProductDetails",productService.changeDetailsProduct(productDetailsDTO)))
                            .message("changeProductDetails")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("changeProductDetails", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }








}
