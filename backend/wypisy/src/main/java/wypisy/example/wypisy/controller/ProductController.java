package wypisy.example.wypisy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wypisy.example.wypisy.model.Product;
import wypisy.example.wypisy.model.Response;
import wypisy.example.wypisy.services.ProductService;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/Product")
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Response> addProduct(@RequestBody  Product product){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addProduct",productService.createProduct()))
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







}
