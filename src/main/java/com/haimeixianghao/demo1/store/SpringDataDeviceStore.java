package com.haimeixianghao.demo1.store;

import com.haimeixianghao.demo1.Device;
import com.haimeixianghao.demo1.repository.DeviceRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SpringDataDeviceStore implements DeviceStore {

    private final DeviceRepository repository;

    public SpringDataDeviceStore(DeviceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Device save(Device device) {
        return repository.save(device);
    }

    @Override
    public Optional<Device> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Device> findByDeviceCodeContainingIgnoreCase(String deviceCode) {
        return repository.findByDeviceCodeContainingIgnoreCase(deviceCode);
    }

    @Override
    public List<Device> findByDeviceNameContainingIgnoreCase(String deviceName) {
        return repository.findByDeviceNameContainingIgnoreCase(deviceName);
    }

    @Override
    public List<Device> findByManufacturerContainingIgnoreCase(String manufacturer) {
        return repository.findByManufacturerContainingIgnoreCase(manufacturer);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

