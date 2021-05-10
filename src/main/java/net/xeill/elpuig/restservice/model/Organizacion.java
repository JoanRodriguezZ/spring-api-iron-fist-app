package net.xeill.elpuig.restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organizacion")
public class Organizacion {
    @Id
    @Column(name = "org_name")
    private String nombre;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organizacion")
//    private List<Jugador> jugadores;

    public Organizacion(String nombre) {
        this.nombre = nombre;
//        this.jugadores = jugadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public List<Jugador> getJugadores() {
//        return jugadores;
//    }
//
//    public void setJugadores(List<Jugador> jugadores) {
//        this.jugadores = jugadores;
//    }
}
