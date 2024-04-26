package wypisy.example.wypisy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wypisy.example.wypisy.model.DTO.ElementDTO;
import wypisy.example.wypisy.model.DTO.ElemetnToMElementDTO;
import wypisy.example.wypisy.model.DTO.MelemetnToMElementDTO;
import wypisy.example.wypisy.model.DTO.ProcessLineDTO;
import wypisy.example.wypisy.model.Line.MelementMelemntLine;
import wypisy.example.wypisy.model.ManufacturingElement;
import wypisy.example.wypisy.model.Response;
import wypisy.example.wypisy.services.ManufacturingElementService;

import java.util.ArrayList;

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

    @PostMapping("/create")
    public ResponseEntity<Response> addMElement(@RequestBody ElementDTO elementDTO){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("createMElement",elementService.create(elementDTO)))
                            .message("createMElement Success")
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
    public ResponseEntity<Response> changeElement(@RequestBody ElementDTO elementDTO){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("ChangeElement",elementService.changeById(elementDTO)))
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


    @PatchMapping("/process/add")
    public ResponseEntity<Response> addProcessToElement(@RequestParam Long elementId, @RequestBody ArrayList<ProcessLineDTO>proceses){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("AddProcessesToElement",elementService.addProcesses(elementId,proceses)))
                            .message("AddProcessesToElement successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("AddProcessesToElement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }
    @PatchMapping("/process/delete")
    public ResponseEntity<Response> deleteProcessFromElement(@RequestParam Long processLineId,@RequestParam Long elementId){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteProcessFromElement",elementService.deleteProcess(processLineId,elementId)))
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

    @PostMapping("/element/")
    public ResponseEntity<Response> addElement(@RequestParam Long melementId,@RequestBody ArrayList<ElemetnToMElementDTO> mElementDTOs){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addElementToMelement",elementService.addElement(melementId,mElementDTOs)))
                            .message("addElementToMelement successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addElementToMelement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }
    @DeleteMapping("/element/")
    public ResponseEntity<Response> addElement(@RequestParam Long lineId){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteElementToMelement",elementService.deleteElement(lineId)))
                            .message("deleteElementToMelement successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteElementToMelement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }

    @PostMapping("/melement/")
    public ResponseEntity<Response> addMElement(@RequestParam Long melementId,@RequestBody ArrayList<MelemetnToMElementDTO> mElementDTOs){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addMElementToMelement",elementService.addMElementIN(melementId,mElementDTOs)))
                            .message("addMElementToMelement successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addMElementToMelement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }
    @DeleteMapping("/melement/")
    public ResponseEntity<Response> deleteElement(@RequestParam Long lineId){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteMElementToMelement",elementService.deleteMElementIN(lineId)))
                            .message("deleteMElementToMelement successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteMElementToMelement", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }




}
