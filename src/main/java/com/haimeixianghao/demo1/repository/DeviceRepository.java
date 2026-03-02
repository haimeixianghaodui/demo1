package com.haimeixianghao.demo1.repository;

import com.haimeixianghao.demo1.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {
    List<Device> findByDeviceCodeContainingIgnoreCase(String deviceCode);
    List<Device> findByDeviceNameContainingIgnoreCase(String deviceName);
    List<Device> findByManufacturerContainingIgnoreCase(String manufacturer);
}

