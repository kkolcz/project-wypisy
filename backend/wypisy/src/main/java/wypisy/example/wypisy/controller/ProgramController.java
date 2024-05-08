package wypisy.example.wypisy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wypisy.example.wypisy.model.MachineProgram;
import wypisy.example.wypisy.model.Material;
import wypisy.example.wypisy.model.Response;
import wypisy.example.wypisy.services.ProgramService;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/program")
@Slf4j
public class ProgramController {

    private final ProgramService programService ;

    @GetMapping("/all")
    public ResponseEntity<Response> getAll(){
        try {

            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("MachinePrograms",programService.getAll()))
                            .message("Returned all Machine programs")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("all Programs", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }


    }
    @GetMapping("/")
    public ResponseEntity<Response> get(@RequestParam Long programId){
        try {

            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("machineProgram",programService.getProductById(programId)))
                            .message("machineProgram")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("machineProgram", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }


    }


    @PostMapping("/add")
    public ResponseEntity<Response> addProgram(@RequestBody MachineProgram program){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("addMachineProgram",programService.create(program) ))
                            .message("addition Program was successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("add Program", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }

    @DeleteMapping("/")
    public ResponseEntity<Response>delateProgram(@RequestParam Long programId){

        try {

            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteMachineProgram",programService.deleteById(programId)))
                            .message("Program was deleted")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("deleteProgram", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }

    @PutMapping("/")
    public ResponseEntity<Response> putProgram(@RequestBody MachineProgram program){

        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("ChangeMachineProgram",programService.changeById(program)))
                            .message("changed Program was successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("Change Program", false))
                            .message(e.getMessage())
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

    }




}
