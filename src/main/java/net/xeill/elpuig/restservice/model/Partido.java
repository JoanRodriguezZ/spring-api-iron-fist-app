package net.xeill.elpuig.restservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;


@Table(name = "partido")
public class Partido {
    @Id
    @Column(name = "id_partido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPartido;

    private LocalDateTime fecha;

    @NotBlank
    private int resultadoLocal, resultadoVisitante, puntuacionLocal, puntuacionVisitante;

    @NotBlank
    @OneToOne
    @JoinColumn(name="nickname")
    private Jugador jugadorLocal;

    @NotBlank
    @OneToOne
    @JoinColumn(name="nickname")
    private Jugador jugadorVisitante;

    @NotBlank
    @OneToOne
    @JoinColumn(name="id_organizador")
    private Organizador organizador;

    public Partido(int resultadoLocal, int resultadoVisitante, Jugador jugadorLocal, Jugador jugadorVisitante, Organizador organizador) {
        this.resultadoLocal = resultadoLocal;
        this.resultadoVisitante = resultadoVisitante;
        this.jugadorLocal = jugadorLocal;
        this.jugadorVisitante = jugadorVisitante;
        this.organizador = organizador;
        fecha = LocalDateTime.now();
    }


    public Partido() {
    }

    public void play() {
        int puntuacionResultante = (int) (Math.random() * 50);

        if (resultadoLocal > resultadoVisitante) {
            puntuacionLocal = (jugadorLocal.getPuntuacion() + puntuacionResultante);
            jugadorLocal.setPuntuacion(puntuacionLocal);

            puntuacionVisitante = (jugadorVisitante.getPuntuacion() - puntuacionResultante);
            jugadorVisitante.setPuntuacion(puntuacionVisitante);

        } else if (resultadoLocal < resultadoVisitante){
            puntuacionLocal = (jugadorLocal.getPuntuacion() - puntuacionResultante);
            jugadorLocal.setPuntuacion(puntuacionLocal);

            puntuacionVisitante = (jugadorVisitante.getPuntuacion() + puntuacionResultante);
            jugadorVisitante.setPuntuacion(puntuacionVisitante);

        } else  {
            System.out.println("No puede haber un empate.");
        }
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getResultadoLocal() {
        return resultadoLocal;
    }

    public void setResultadoLocal(int resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    public int getResultadoVisitante() {
        return resultadoVisitante;
    }

    public void setResultadoVisitante(int resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
    }

    public int getPuntuacionLocal() {
        return puntuacionLocal;
    }

    public void setPuntuacionLocal(int puntuacionLocal) {
        this.puntuacionLocal = puntuacionLocal;
    }

    public int getPuntuacionVisitante() {
        return puntuacionVisitante;
    }

    public void setPuntuacionVisitante(int puntuacionVisitante) {
        this.puntuacionVisitante = puntuacionVisitante;
    }

    public Jugador getJugadorLocal() {
        return jugadorLocal;
    }

    public void setJugadorLocal(Jugador jugadorLocal) {
        this.jugadorLocal = jugadorLocal;
    }

    public Jugador getJugadorVisitante() {
        return jugadorVisitante;
    }

    public void setJugadorVisitante(Jugador jugadorVisitante) {
        this.jugadorVisitante = jugadorVisitante;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }
}
