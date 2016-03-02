package org.rooinaction.coursemanager.db;
import org.rooinaction.coursemanager.model.Registration;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

@RooJpaRepository(domainType = Registration.class)
public interface RegistrationRepository {
}
