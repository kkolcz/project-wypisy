package wypisy.example.wypisy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wypisy.example.wypisy.model.ManufacturingElement;
import wypisy.example.wypisy.model.ManufacturingProcess;
import wypisy.example.wypisy.model.Response;
import wypisy.example.wypisy.services.ManufacturingElementService;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/melement")
@Slf4j
public class ManufacturingElementController {

 private final ManufacturingElementService elementService;

    @GetMapping("/all")
    public ResponseEntity<Response> getAllElement(){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("ManufacturingElement",elementService.getAll()))
                            .message("Returned all mElement")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("ManufacturingElement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }
    @GetMapping("/")
    public ResponseEntity<Response>getProductsById(@RequestParam Long elementId) {
        try {

            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("mElement", elementService.getElementById(elementId)))
                            .message("Returned Products")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("mElement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }

    @PostMapping("/add")
    public ResponseEntity<Response> addMElement(@RequestBody ManufacturingElement element){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addElement",elementService.createMElement(element)))
                            .message("addition Element was successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addElement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }

    @DeleteMapping("/")
    public ResponseEntity<Response>delateMElement(@RequestParam Long elementId){

        try {

            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("delete mElement",elementService.deleteById(elementId)))
                            .message("Process was mElement")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("delete mElement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }
    @PutMapping("/")
    public ResponseEntity<Response> changeElement(@RequestBody ManufacturingElement element){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("ChangeElement",elementService.changeById(element)))
                            .message("changed Element was successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("Change Elemen", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }

    @PatchMapping("/tool/add")
    public ResponseEntity<Response> addToolToElement(@RequestParam Long toolId,@RequestParam Long elementId){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("AddToolToElement",elementService.addTool(toolId,elementId)))
                            .message("AddToolToElement successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("AddToolToElement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }

    @PatchMapping("/tool/delete")
    public ResponseEntity<Response> deleteToolFromElement(@RequestParam Long toolId,@RequestParam Long elementId){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteToolFromElement",elementService.deleteTool(toolId,elementId)))
                            .message("deleteToolFromElement successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteToolFromElement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }

    @PatchMapping("/process/add")
    public ResponseEntity<Response> addProcessToElement(@RequestParam Long processId,@RequestParam Long elementId){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("AddProcessToElement",elementService.addProcess(processId,elementId)))
                            .message("AddProcessToElement successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("AddProcessToElement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }
    @PatchMapping("/process/delete")
    public ResponseEntity<Response> deleteProcessFromElement(@RequestParam Long processId,@RequestParam Long elementId){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteProcessFromElement",elementService.deleteProcess(processId,elementId)))
                            .message("deleteProcessFromElement successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteProcessFromElement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }
    @PatchMapping("/program/add")
    public ResponseEntity<Response> addProgramToElement(@RequestParam Long programId,@RequestParam Long elementId){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addProgramToElement",elementService.addProgram(programId,elementId)))
                            .message("addProgramToElement successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addProgramToElement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }
    @PatchMapping("/program/delete")
    public ResponseEntity<Response> deleteProgramFromElement(@RequestParam Long programId,@RequestParam Long elementId){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteProgramFromElement",elementService.deleteProgram(programId,elementId)))
                            .message("deleteProgramFromElement successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteProgramFromElement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }
    @PatchMapping("/material/add")
    public ResponseEntity<Response> setMaterialOfElement(@RequestParam Long materialId,@RequestParam Long elementId){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("setMaterialOfElement",elementService.changeAddMaterial(materialId,elementId)))
                            .message("setMaterialOfElement successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("setMaterialOfElement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }
    @PatchMapping("/material/delete")
    public ResponseEntity<Response> dropMaterialFromElement(@RequestParam Long elementId){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("dropMaterialFromElement",elementService.delateMaterial(elementId)))
                            .message("dropMaterialFromElement successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("dropMaterialFromElement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }






}
