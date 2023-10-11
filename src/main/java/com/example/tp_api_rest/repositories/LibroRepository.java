package com.example.tp_api_rest.repositories;

import com.example.tp_api_rest.entities.Libro;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends BaseRepository<Libro,Long> {
}
