package com.example.colegioelite.controladores;

import com.example.colegioelite.dto.EstudianteDTO;
import com.example.colegioelite.dto.EstudianteDTOError;
import com.example.colegioelite.entidades.Estudiante;
import com.example.colegioelite.servicios.EstudianteServicioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/estudiantesdto")
public class EstudianteControladorDTO {

    @Autowired
    protected EstudianteServicioDTO estudianteServicioDTO;

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> buscarTodos(){
        try{
            List<EstudianteDTO> estudiantes = estudianteServicioDTO.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(estudiantes);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> registrar(@RequestBody Estudiante datosARegistrar){
        try{
            EstudianteDTO estudianteRegistrado=estudianteServicioDTO.registrar(datosARegistrar);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(estudianteRegistrado);

        }catch(Exception error){
            EstudianteDTOError estudianteDTOError= new EstudianteDTOError();
            estudianteDTOError.setMensajeError(error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(estudianteDTOError);
        }
    }


}
