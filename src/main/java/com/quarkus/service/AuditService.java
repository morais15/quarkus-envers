package com.quarkus.service;

import com.quarkus.model.Device;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@ApplicationScoped
public class AuditService {

    private final EntityManager entityManager;

    public List<?> find(UUID id) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        AuditQuery auditQuery = auditReader.createQuery()
                .forRevisionsOfEntityWithChanges(Device.class, true)
                .add(AuditEntity.property("id").eq(id));

        return auditQuery.getResultList();
    }
}
