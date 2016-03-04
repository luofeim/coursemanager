package org.rooinaction.coursemanager.db;
import org.rooinaction.coursemanager.model.Tag;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

@RooJpaRepository(domainType = Tag.class)
public interface TagRepository {
}
