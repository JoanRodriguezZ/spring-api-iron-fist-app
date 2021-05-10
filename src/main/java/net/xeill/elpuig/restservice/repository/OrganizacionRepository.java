package net.xeill.elpuig.restservice.repository;

import net.xeill.elpuig.restservice.model.Organizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizacionRepository extends JpaRepository<Organizacion, String> {
}
