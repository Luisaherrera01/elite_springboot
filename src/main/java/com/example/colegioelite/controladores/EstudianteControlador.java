package com.example.colegioelite.controladores;

import com.example.colegioelite.entidades.Estudiante;
import com.example.colegioelite.servicios.EstudianteServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/estudiantes")
@Tag(name="Servicio Estudiantes", description = "Servicios que ofrecen CRUD en la entidad estudiante")
public class EstudianteControlador {

    @Autowired
    protected EstudianteServicio estudianteServicio;


    @PostMapping
    @Operation(summary = "Registra un estudiante en la BD")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "Estudiante fue creado con exito"),
            @ApiResponse(responseCode = "400", description = "Fallamos en el registro, revise su peticion")
    })
    public ResponseEntity<Estudiante> registrar(@RequestBody Estudiante datosARegistrar){
        try{
            Estudiante estudianteRegistrado=estudianteServicio.registrar(datosARegistrar);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(estudianteRegistrado);

        }catch(Exception error){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>>buscarTodos(){
        try{
            List<Estudiante> estudiantes = estudianteServicio.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(estudiantes);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }



}
