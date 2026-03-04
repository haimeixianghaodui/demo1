package com.haimeixianghao.demo1.store;

import com.haimeixianghao.demo1.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceStore {
    Device save(Device device);
    Optional<Device> findById(Long id);
    List<Device> findAll();
    List<Device> findByDeviceCodeContainingIgnoreCase(String deviceCode);
    List<Device> findByDeviceNameContainingIgnoreCase(String deviceName);
    List<Device> findByManufacturerContainingIgnoreCase(String manufacturer);
    boolean existsById(Long id);
    void deleteById(Long id);
}

