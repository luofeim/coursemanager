package org.rooinaction.coursemanager.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;

import org.springframework.data.repository.NoRepositoryBean;

import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QOffering is a Querydsl query type for Offering
 */
@NoRepositoryBean
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOffering extends EntityPathBase<Offering> {

    private static final long serialVersionUID = 1434846770L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOffering offering = new QOffering("offering");

    public final SimplePath<Course> course = createSimple("course", Course.class);

    public final SimplePath<Instructor> instructor = createSimple("instructor", Instructor.class);

    public final StringPath locationName = createString("locationName");

    public final DateTimePath<java.util.Date> offerDate = createDateTime("offerDate", java.util.Date.class);

    public final QUser user;

    public QOffering(String variable) {
        this(Offering.class, forVariable(variable), INITS);
    }

    public QOffering(Path<? extends Offering> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOffering(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOffering(PathMetadata<?> metadata, PathInits inits) {
        this(Offering.class, metadata, inits);
    }

    public QOffering(Class<? extends Offering> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

