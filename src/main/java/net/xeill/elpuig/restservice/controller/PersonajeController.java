//package net.xeill.elpuig.restservice.controller;
//
//import net.xeill.elpuig.restservice.exception.ResourceNotFoundException;
//import net.xeill.elpuig.restservice.model.Personaje;
//import net.xeill.elpuig.restservice.repository.PersonajeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost"})
//@RequestMapping("/api")
//public class PersonajeController {
//
//    @Autowired
//    PersonajeRepository personajeRepository;
//
//
//    @GetMapping("/personajes")
//    public List<Personaje> getAllPersonajes() {
//        return personajeRepository.findAll();
//    }
//
//    @PostMapping("/personajes")
//    //public Note createNote(@Valid @RequestBody Note note) {
//    //https://stackoverflow.com/questions/51337489/content-type-multipart-form-databoundary-webkitformboundary-not-suppor
//    public Personaje createPersonaje(@Valid @RequestBody Personaje personaje) {
//        return personajeRepository.save(personaje);
//    }
//
//    @GetMapping("/personajes/{pj_name}")
//    public Personaje getPersonajeByName(@PathVariable(value = "pj_name") String personajeName) {
//        return personajeRepository.findById(personajeName)
//                .orElseThrow(() -> new ResourceNotFoundException("Personaje", "name", personajeName));
//    }
//
//    @PutMapping("/personajes/{pj_name}")
//    public Personaje updatePersonaje(@PathVariable(value = "pj_name") String personajeName,
//                           @Valid @RequestBody Personaje personajeDetails) {
//
//        Personaje personaje = this.personajeRepository.findById(personajeName)
//                .orElseThrow(() -> new ResourceNotFoundException("Personaje", "name", personajeName));
//
//        personaje.setNombre(personajeDetails.getNombre());
//
//        Personaje updatedPersonaje = this.personajeRepository.save(personaje);
//        return updatedPersonaje;
//    }
//
//    @DeleteMapping("/personajes/{pj_name}")
//    public ResponseEntity<?> deletePersonaje(@PathVariable(value = "pj_name") String personajeName) {
//        Personaje personaje = personajeRepository.findById(personajeName)
//                .orElseThrow(() -> new ResourceNotFoundException("Personaje", "name", personajeName));
//
//        personajeRepository.delete(personaje);
//
//        return ResponseEntity.ok().build();
//    }
//}
