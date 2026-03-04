package com.haimeixianghao.demo1.store;

import com.haimeixianghao.demo1.Device;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Placeholder stub for an iDMA-backed DeviceStore. When iDMA integration is implemented,
 * replace method bodies with calls to iDMA SDK. This bean is only created when idma.enabled=true.
 */
@Component
@ConditionalOnProperty(prefix = "idma", name = "enabled", havingValue = "true")
public class IDMADeviceStore implements DeviceStore {

    public IDMADeviceStore() {
        // TODO: initialize iDMA client via configuration
    }

    @Override
    public Device save(Device device) {
        throw new UnsupportedOperationException("iDMA integration not yet implemented");
    }

    @Override
    public Optional<Device> findById(Long id) {
        throw new UnsupportedOperationException("iDMA integration not yet implemented");
    }

    @Override
    public List<Device> findByDeviceCodeContainingIgnoreCase(String deviceCode) {
        throw new UnsupportedOperationException("iDMA integration not yet implemented");
    }

    @Override
    public List<Device> findByDeviceNameContainingIgnoreCase(String deviceName) {
        throw new UnsupportedOperationException("iDMA integration not yet implemented");
    }

    @Override
    public List<Device> findByManufacturerContainingIgnoreCase(String manufacturer) {
        throw new UnsupportedOperationException("iDMA integration not yet implemented");
    }

    @Override
    public boolean existsById(Long id) {
        throw new UnsupportedOperationException("iDMA integration not yet implemented");
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("iDMA integration not yet implemented");
    }
}

