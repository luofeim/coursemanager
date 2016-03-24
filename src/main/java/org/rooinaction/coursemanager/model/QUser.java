package org.rooinaction.coursemanager.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;

import org.springframework.data.repository.NoRepositoryBean;

import com.mysema.query.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@NoRepositoryBean
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -764028937L;

    public static final QUser user = new QUser("user");

    public final StringPath emailAddress = createString("emailAddress");

    public final StringPath firstname = createString("firstname");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastname = createString("lastname");

    public final StringPath role = createString("role");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata<?> metadata) {
        super(User.class, metadata);
    }

}

