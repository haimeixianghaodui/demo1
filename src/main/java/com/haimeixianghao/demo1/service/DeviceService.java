package com.haimeixianghao.demo1.service;

import com.haimeixianghao.demo1.Device;
import com.haimeixianghao.demo1.dto.DeviceCreateDto;
import com.haimeixianghao.demo1.dto.DeviceDto;
import com.haimeixianghao.demo1.dto.DeviceUpdateDto;
import com.haimeixianghao.demo1.mapper.DeviceMapper;
import com.haimeixianghao.demo1.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DeviceService {

    private final DeviceRepository repository;

    public DeviceService(DeviceRepository repository) {
        this.repository = repository;
    }

    public DeviceDto create(DeviceCreateDto dto) {
        Device entity = DeviceMapper.toEntity(dto);
        Device saved = repository.save(entity);
        return DeviceMapper.toDto(saved);
    }

    public DeviceDto getById(Long id) {
        Optional<Device> o = repository.findById(id);
        return o.map(DeviceMapper::toDto).orElse(null);
    }

    public List<DeviceDto> searchByCodeOrName(String q) {
        List<Device> byCode = repository.findByDeviceCodeContainingIgnoreCase(q);
        List<Device> byName = repository.findByDeviceNameContainingIgnoreCase(q);
        // merge deduplicating by id
        return Stream.concat(byCode.stream(), byName.stream())
                .distinct()
                .map(DeviceMapper::toDto)
                .collect(Collectors.toList());
    }

    public DeviceDto update(Long id, DeviceUpdateDto dto) {
        Optional<Device> o = repository.findById(id);
        if (o.isEmpty()) return null;
        Device e = o.get();
        DeviceMapper.updateEntity(dto, e);
        Device saved = repository.save(e);
        return DeviceMapper.toDto(saved);
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
