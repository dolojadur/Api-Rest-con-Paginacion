package com.example.tp_api_rest.services;

import com.example.tp_api_rest.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long>{

    List<Persona> search(String filtro) throws Exception;

    //con paginacion
    Page<Persona> search(String filtro, Pageable pageable) throws Exception;
}
