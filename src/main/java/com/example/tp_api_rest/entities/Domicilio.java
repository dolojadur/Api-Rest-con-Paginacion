package com.example.tp_api_rest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Domicilio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Domicilio extends Base{
    @Column(name = "Calle")
    private String calle;
    @Column(name = "Número")
    private int numero;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;
}