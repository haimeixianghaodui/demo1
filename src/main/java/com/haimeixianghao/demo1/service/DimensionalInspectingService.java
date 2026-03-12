package com.haimeixianghao.demo1.service;

import com.haimeixianghao.demo1.dto.DimensionalInspectingDto;
import com.haimeixianghao.demo1.entity.DimensionalInspecting;
import com.haimeixianghao.demo1.repository.DimensionalInspectingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DimensionalInspectingService {

    private final DimensionalInspectingRepository repository;

    public DimensionalInspectingService(DimensionalInspectingRepository repository) {
        this.repository = repository;
    }

    public DimensionalInspectingDto create(DimensionalInspectingDto dto) {
        DimensionalInspecting e = new DimensionalInspecting();
        e.setIqcWarehousingId(dto.getIqcWarehousingId());
        e.setCreateTime(LocalDateTime.now());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public DimensionalInspectingDto getById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<DimensionalInspectingDto> findAll() {
        List<DimensionalInspectingDto> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(toDto(e)));
        return list;
    }

    public DimensionalInspectingDto update(Long id, DimensionalInspectingDto dto) {
        Optional<DimensionalInspecting> o = repository.findById(id);
        if (o.isEmpty()) return null;
        DimensionalInspecting e = o.get();
        e.setIqcWarehousingId(dto.getIqcWarehousingId());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    private DimensionalInspectingDto toDto(DimensionalInspecting e) {
        DimensionalInspectingDto dto = new DimensionalInspectingDto();
        dto.setId(e.getId());
        dto.setIqcWarehousingId(e.getIqcWarehousingId());
        dto.setCreateTime(e.getCreateTime() != null ? e.getCreateTime().toString() : null);
        dto.setLastUpdateTime(e.getLastUpdateTime() != null ? e.getLastUpdateTime().toString() : null);
        return dto;
    }
}

