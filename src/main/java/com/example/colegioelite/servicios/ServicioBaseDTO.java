package com.example.colegioelite.servicios;

import java.util.List;

public interface ServicioBaseDTO <E,DTO>{

    public List<DTO> buscarTodos() throws Exception;
    public DTO buscarPorId(Integer id) throws  Exception;
    public DTO  registrar(E datosARegistrar) throws Exception;
    public DTO actualizar(Integer id, E datosNuevos) throws Exception;
    public boolean eliminar(Integer id) throws Exception;

}
