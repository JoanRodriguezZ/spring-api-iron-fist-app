package net.xeill.elpuig.restservice.model;

import javax.persistence.*;

@Entity
@Table(name = "personaje")
public class Personaje {
    @Id
    @Column(name = "pj_name")
    @ManyToMany
    private String nombre;

    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public Personaje() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
