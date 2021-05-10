package net.xeill.elpuig.restservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "jugador")
public class Jugador {
    @Id
    private String nickname;
    @NotBlank
    @Column(name = "user_name")
    private String name;
    @NotBlank
    private String apellidos;

    private int puntuacion;

    @NotBlank
//    @OneToMany(fetch = FetchType.LAZY)
//    @Column(name = "pj_name1")
//    @JoinColumn(name = "pj_name")
    private String personaje1;

//    @OneToMany(fetch = FetchType.LAZY)
//    @Column(name = "pj_name2")
//    @JoinColumn(name = "nombre")
//    private Personaje personaje2;

//    @OneToMany(fetch = FetchType.LAZY)
//    @Column(name = "org_name")
//    @JoinColumn(name = "org_name")
//    private Organizacion organizacion;
    private String organizacion;

    public Jugador(String nickname, String name, String apellidos, int puntuacion, String personaje1, String organizacion) {
        this.nickname = nickname;
        this.puntuacion = puntuacion;
        this.name = name;
        this.apellidos = apellidos;
        this.personaje1 = personaje1;
        this.organizacion = organizacion;
    }

    public Jugador(String nickname, String name, String apellidos, int puntuacion, String personaje1) {
        this.nickname = nickname;
        this.puntuacion = puntuacion;
        this.name = name;
        this.apellidos = apellidos;
        this.personaje1 = personaje1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

//    public Personaje getPersonaje1() {
//        return personaje1;
//    }
//
//    public void setPersonaje1(Personaje personaje1) {
//        this.personaje1 = personaje1;
//    }
//
//    public Personaje getPersonaje2() {
//        return personaje2;
//    }
//
//    public void setPersonaje2(Personaje personaje2) {
//        this.personaje2 = personaje2;
//    }
//
//    public Organizacion getOrganizacion() {
//        return organizacion;
//    }
//
//    public void setOrganizacion(Organizacion organizacion) {
//        this.organizacion = organizacion;
//    }


}
