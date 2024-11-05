package com.quarkus.resource;

import com.quarkus.model.Policy;
import com.quarkus.service.PolicyService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationScoped
@Path("/policy")
@RequiredArgsConstructor
public class PolicyResource {

    private final PolicyService policyService;

    @POST
    public Response save(Policy policy) {
        var policyCreated = policyService.save(policy);

        return Response.ok(policyCreated).build();
    }

    @PUT
    public Response update(Policy policy) {
        var policyCreated = policyService.update(policy);

        return Response.ok(policyCreated).build();
    }

    @GET
    @Path("/all")
    public List<Policy> findAll() {
        return policyService.findAll();
    }
}
