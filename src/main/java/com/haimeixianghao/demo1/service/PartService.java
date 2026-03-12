package com.haimeixianghao.demo1.service;

import com.haimeixianghao.demo1.dto.PartDto;
import com.haimeixianghao.demo1.entity.Part;
import com.haimeixianghao.demo1.repository.PartRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PartService {

    private final PartRepository repository;

    public PartService(PartRepository repository) {
        this.repository = repository;
    }

    public PartDto create(PartDto dto) {
        Part e = toEntity(dto);
        e.setCreateTime(LocalDateTime.now());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public PartDto getById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<PartDto> findAll() {
        List<PartDto> list = new ArrayList<>();
        repository.findAll().forEach(p -> list.add(toDto(p)));
        return list;
    }

    public List<PartDto> search(String q) {
        List<Part> byCode = repository.findByPartCodeContainingIgnoreCase(q);
        List<Part> byName = repository.findByPartNameContainingIgnoreCase(q);
        List<PartDto> result = new ArrayList<>();
        byCode.forEach(p -> result.add(toDto(p)));
        byName.stream().filter(p -> byCode.stream().noneMatch(c -> c.getId().equals(p.getId())))
                .forEach(p -> result.add(toDto(p)));
        return result;
    }

    public PartDto update(Long id, PartDto dto) {
        Optional<Part> o = repository.findById(id);
        if (o.isEmpty()) return null;
        Part e = o.get();
        e.setPartCode(dto.getPartCode());
        e.setPartName(dto.getPartName());
        e.setSpecModel(dto.getSpecModel());
        e.setSupplier(dto.getSupplier());
        e.setStockQuantity(dto.getStockQuantity());
        e.setUsedEquipmentId(dto.getUsedEquipmentId());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    private Part toEntity(PartDto dto) {
        Part e = new Part();
        e.setPartCode(dto.getPartCode());
        e.setPartName(dto.getPartName());
        e.setSpecModel(dto.getSpecModel());
        e.setSupplier(dto.getSupplier());
        e.setStockQuantity(dto.getStockQuantity());
        e.setUsedEquipmentId(dto.getUsedEquipmentId());
        return e;
    }

    private PartDto toDto(Part e) {
        PartDto dto = new PartDto();
        dto.setId(e.getId());
        dto.setPartCode(e.getPartCode());
        dto.setPartName(e.getPartName());
        dto.setSpecModel(e.getSpecModel());
        dto.setSupplier(e.getSupplier());
        dto.setStockQuantity(e.getStockQuantity());
        dto.setUsedEquipmentId(e.getUsedEquipmentId());
        dto.setCreateTime(e.getCreateTime() != null ? e.getCreateTime().toString() : null);
        dto.setLastUpdateTime(e.getLastUpdateTime() != null ? e.getLastUpdateTime().toString() : null);
        return dto;
    }
}

