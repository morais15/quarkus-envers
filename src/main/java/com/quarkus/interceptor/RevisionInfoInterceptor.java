package com.quarkus.interceptor;

import com.quarkus.model.RevisionInfo;
import org.hibernate.envers.RevisionListener;

import java.util.UUID;

public class RevisionInfoInterceptor implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        RevisionInfo revisionInfo = (RevisionInfo) revisionEntity;

        revisionInfo.setUserName("user-name-" + UUID.randomUUID()); // get from AuthContext
    }
}
