package com.quarkus.service;

import com.quarkus.model.Device;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@ApplicationScoped
public class DeviceService {

    @Transactional
    public Device save(Device device) {
        Device.persist(device);

        return device;
    }

    @Transactional
    public Device update(Device device) {

        Device deviceSaved = Device.<Device>findByIdOptional(device.getId())
                .orElseThrow(() -> new NotFoundException("Device not found"));

        deviceSaved.setName(device.getName());
        deviceSaved.setModel(device.getModel());
        deviceSaved.setManufacturer(device.getManufacturer());

        Device.persist(deviceSaved);

        return device;
    }

    public List<Device> findAll() {
        return Device.listAll();
    }
}
