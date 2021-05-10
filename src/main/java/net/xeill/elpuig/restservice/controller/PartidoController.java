package net.xeill.elpuig.restservice.controller;

import net.xeill.elpuig.restservice.exception.ResourceNotFoundException;
import net.xeill.elpuig.restservice.model.Partido;
import net.xeill.elpuig.restservice.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost"})
@RequestMapping("/api")
public class PartidoController {


    @Autowired
    PartidoRepository partidoRepository;

    @GetMapping("/partidos")
    public List<Partido> getAllPartidos() {
        return partidoRepository.findAll();
    }

    @PostMapping("/partidos")
    //public Note createNote(@Valid @RequestBody Note note) {
    //https://stackoverflow.com/questions/51337489/content-type-multipart-form-databoundary-webkitformboundary-not-suppor
    public Partido createPartido(@Valid @RequestBody Partido partido) {
        return partidoRepository.save(partido);
    }

    @GetMapping("/partidos/{id}")
    public Partido getPartidoById(@PathVariable(value = "id") Integer partidoId) {
        return partidoRepository.findById(partidoId)
                .orElseThrow(() -> new ResourceNotFoundException("Partido", "id", partidoId));
    }

    @PutMapping("/partidos/{id}")
    public Partido updatePartido(@PathVariable(value = "id") Integer partidoId,
                           @Valid @RequestBody Partido partidoDetails) {

        Partido partido = partidoRepository.findById(partidoId)
                .orElseThrow(() -> new ResourceNotFoundException("Partido", "id", partidoId));

        partido.setJugadorLocal(partidoDetails.getJugadorLocal());
        partido.setJugadorVisitante(partidoDetails.getJugadorVisitante());
        partido.setResultadoLocal(partidoDetails.getResultadoLocal());
        partido.setResultadoVisitante(partidoDetails.getResultadoVisitante());
        partido.setPuntuacionLocal(partidoDetails.getPuntuacionLocal());
        partido.setPuntuacionVisitante(partidoDetails.getPuntuacionVisitante());

        Partido updatedPartido = partidoRepository.save(partido);
        return updatedPartido;
    }

    @DeleteMapping("/partidos/{id}")
    public ResponseEntity<?> deletePartido(@PathVariable(value = "id") Integer partidoId) {
        Partido partido = partidoRepository.findById(partidoId)
                .orElseThrow(() -> new ResourceNotFoundException("Partido", "id", partidoId));

        partidoRepository.delete(partido);

        return ResponseEntity.ok().build();
    }

}
