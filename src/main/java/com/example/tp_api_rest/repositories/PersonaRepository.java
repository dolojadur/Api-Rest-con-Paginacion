package com.example.tp_api_rest.repositories;

import com.example.tp_api_rest.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    // anotacion metodo de query
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    //metodo con paginacin
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

/*    boolean existsByDni(int dni);

    //anotaciones con metodo JPQL con parametros indexados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?1%'") //?indexado y 1 le pasamos un parametro
    List<Persona> search(String filtro);*/

    //anotaciones con metodo JPQL con parametros nombrados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%") //?indexado y 1 le pasamos un parametro
    List<Persona> search(@Param("filtro") String filtro);

    //metodo con paginacion
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%") //?indexado y 1 le pasamos un parametro
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    //anotacion query nativo
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",//?indexado y 1 le pasamos un parametro
            nativeQuery = true
    )
    List<Persona> searchNative(@Param("filtro") String filtro);

    //metodo con paginacion
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",//?indexado y 1 le pasamos un parametro
            countQuery = "SELECT count (*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNative(@Param("filtro") String filtro, Pageable pageable);


}
