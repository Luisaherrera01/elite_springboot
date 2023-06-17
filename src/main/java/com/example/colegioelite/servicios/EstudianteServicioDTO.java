package com.example.colegioelite.servicios;

import com.example.colegioelite.dto.EstudianteDTO;
import com.example.colegioelite.entidades.Estudiante;
import com.example.colegioelite.mapas.EstudianteMapa;
import com.example.colegioelite.repositorios.EstudianteRepositorio;
import com.example.colegioelite.validaciones.EstudianteValidaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServicioDTO implements ServicioBaseDTO<Estudiante, EstudianteDTO>{

    @Autowired
    protected EstudianteRepositorio estudianteRepositorio;

    @Autowired
    protected EstudianteMapa estudianteMapa;

    @Autowired
    protected EstudianteValidaciones validacion;


    @Override
    public List<EstudianteDTO> buscarTodos() throws Exception {
        try{
            List<EstudianteDTO> estudiantes=estudianteMapa.mapearListaEstudiante(estudianteRepositorio.findAll());
            return estudiantes;

        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public EstudianteDTO buscarPorId(Integer id) throws Exception {
        return null;
    }

    @Override
    public EstudianteDTO registrar(Estudiante datosARegistrar) throws Exception {
        try{

            if(validacion.verificarCorreo(datosARegistrar.getCorreo())){
                throw new Exception("Revisar el correo");
            }else{
                EstudianteDTO estudianteGuardo=estudianteMapa.mapearUnEstudiante(estudianteRepositorio.save(datosARegistrar));
                return estudianteGuardo;
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public EstudianteDTO actualizar(Integer id, Estudiante datosNuevos) throws Exception {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        return false;
    }
}
