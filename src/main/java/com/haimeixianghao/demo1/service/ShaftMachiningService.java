package com.haimeixianghao.demo1.service;

import com.haimeixianghao.demo1.dto.ShaftMachiningDto;
import com.haimeixianghao.demo1.entity.ShaftMachining;
import com.haimeixianghao.demo1.repository.ShaftMachiningRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShaftMachiningService {

    private final ShaftMachiningRepository repository;

    public ShaftMachiningService(ShaftMachiningRepository repository) {
        this.repository = repository;
    }

    public ShaftMachiningDto create(ShaftMachiningDto dto) {
        ShaftMachining e = new ShaftMachining();
        e.setFqcDimensionalInspectingId(dto.getFqcDimensionalInspectingId());
        e.setCreateTime(LocalDateTime.now());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public ShaftMachiningDto getById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<ShaftMachiningDto> findAll() {
        List<ShaftMachiningDto> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(toDto(e)));
        return list;
    }

    public ShaftMachiningDto update(Long id, ShaftMachiningDto dto) {
        Optional<ShaftMachining> o = repository.findById(id);
        if (o.isEmpty()) return null;
        ShaftMachining e = o.get();
        e.setFqcDimensionalInspectingId(dto.getFqcDimensionalInspectingId());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    private ShaftMachiningDto toDto(ShaftMachining e) {
        ShaftMachiningDto dto = new ShaftMachiningDto();
        dto.setId(e.getId());
        dto.setFqcDimensionalInspectingId(e.getFqcDimensionalInspectingId());
        dto.setCreateTime(e.getCreateTime() != null ? e.getCreateTime().toString() : null);
        dto.setLastUpdateTime(e.getLastUpdateTime() != null ? e.getLastUpdateTime().toString() : null);
        return dto;
    }
}

