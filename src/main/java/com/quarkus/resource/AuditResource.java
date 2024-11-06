package com.quarkus.resource;

import com.quarkus.service.AuditService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Path("/audit")
@RequiredArgsConstructor
public class AuditResource {

    private final AuditService auditService;

    @GET
    @Path("/{id}")
    public List<?> find(@QueryParam("id") UUID id) {
        return auditService.find(id);
    }
}
