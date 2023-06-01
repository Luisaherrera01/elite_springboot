package com.example.colegioelite.controladores;

import com.example.colegioelite.entidades.Acudiente;
import com.example.colegioelite.servicios.AcudienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/acudientes")
public class AcudienteControlador {
    @Autowired
    protected AcudienteServicio acudienteServicio;

    @PostMapping
    public ResponseEntity<Acudiente> registrar(@RequestBody Acudiente datosAGuardar){
        try{
            Acudiente acudienteRegistrado=acudienteServicio.registrar(datosAGuardar);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(acudienteRegistrado);
        }catch(Exception error){
            String mensaje="Tenemos un error al registrar "+error.getMessage();
            Acudiente acudienteConError= new Acudiente();
            acudienteConError.setMensjeError(mensaje);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(acudienteConError);

        }
    }

    @GetMapping
    public ResponseEntity<List<Acudiente>>buscarTodos(){
        try{

            List<Acudiente> acudientes=acudienteServicio.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(acudientes);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acudiente>buscarPorId(@PathVariable Integer id){
        try{
            Acudiente acudienteEncontrado=acudienteServicio.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(acudienteEncontrado);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }
    }

}
