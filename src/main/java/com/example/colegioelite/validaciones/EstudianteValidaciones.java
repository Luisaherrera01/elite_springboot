package com.example.colegioelite.validaciones;

import org.springframework.stereotype.Component;

@Component
public class EstudianteValidaciones {

    public boolean verificarCorreo(String correo){
        if(correo.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

}
