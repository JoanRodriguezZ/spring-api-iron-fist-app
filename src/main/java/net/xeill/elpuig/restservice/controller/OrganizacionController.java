package net.xeill.elpuig.restservice.controller;

import net.xeill.elpuig.restservice.exception.ResourceNotFoundException;
import net.xeill.elpuig.restservice.model.Organizacion;
import net.xeill.elpuig.restservice.repository.OrganizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost"})
@RequestMapping("/api")
public class OrganizacionController {

    @Autowired
    OrganizacionRepository organizacionRepository;


    @GetMapping("/organizaciones")
    public List<Organizacion> getAllOrganizacion() {
        return organizacionRepository.findAll();
    }

    @PostMapping("/organizaciones")
    //public Note createNote(@Valid @RequestBody Note note) {
    //https://stackoverflow.com/questions/51337489/content-type-multipart-form-databoundary-webkitformboundary-not-suppor
    public Organizacion createOrganizacion(@Valid @RequestBody Organizacion organizacion) {
        return organizacionRepository.save(organizacion);
    }

    @GetMapping("/organizaciones/{org_name}")
    public Organizacion getOrganizacionByName(@PathVariable(value = "org_name") String organizacionName) {
        return organizacionRepository.findById(organizacionName)
                .orElseThrow(() -> new ResourceNotFoundException("Organizacion", "name", organizacionName));
    }

    @PutMapping("/organizaciones/{org_name}")
    public Organizacion updateOrganizacion(@PathVariable(value = "org_name") String organizacionName,
                           @Valid @RequestBody Organizacion organizacionDetails) {

        Organizacion organizacion = this.organizacionRepository.findById(organizacionName)
                .orElseThrow(() -> new ResourceNotFoundException("Organizacion", "name", organizacionName));

        organizacion.setNombre(organizacionDetails.getNombre());
//        organizacion.setJugadores(organizacionDetails.getJugadores());

        Organizacion updatedOrganizacion = this.organizacionRepository.save(organizacion);
        return updatedOrganizacion;
    }

    @DeleteMapping("/organizaciones/{org_name}")
    public ResponseEntity<?> deleteOrganizacion(@PathVariable(value = "org_name") String organizacionName) {
        Organizacion organizacion = organizacionRepository.findById(organizacionName)
                .orElseThrow(() -> new ResourceNotFoundException("Organizacion", "name", organizacionName));

        organizacionRepository.delete(organizacion);

        return ResponseEntity.ok().build();
    }
}
