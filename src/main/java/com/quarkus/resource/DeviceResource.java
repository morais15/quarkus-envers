package com.quarkus.resource;

import com.quarkus.model.Device;
import com.quarkus.service.DeviceService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationScoped
@Path("/device")
@RequiredArgsConstructor
public class DeviceResource {

    private final DeviceService deviceService;

    @POST
    public Response save(Device device) {
        var deviceCreated = deviceService.save(device);

        return Response.ok(deviceCreated).build();
    }

    @PUT
    public Response update(Device device) {
        var deviceCreated = deviceService.update(device);

        return Response.ok(deviceCreated).build();
    }

    @GET
    @Path("/all")
    public List<Device> findAll() {
        return deviceService.findAll();
    }
}
