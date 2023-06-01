package com.example.colegioelite.controladores;

import com.example.colegioelite.entidades.Estudiante;
import com.example.colegioelite.servicios.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/estudiantes")
public class EstudianteControlador {

    @Autowired
    protected EstudianteServicio estudianteServicio;


    @PostMapping
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
