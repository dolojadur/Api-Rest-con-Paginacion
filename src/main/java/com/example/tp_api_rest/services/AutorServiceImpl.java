package com.example.tp_api_rest.services;

import com.example.tp_api_rest.entities.Autor;
import com.example.tp_api_rest.repositories.AutorRepository;
import com.example.tp_api_rest.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService{

    @Autowired
    private AutorRepository autorRepository;
    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }

}
