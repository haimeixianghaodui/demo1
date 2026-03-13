package com.haimeixianghao.demo1.service;

import com.haimeixianghao.demo1.dto.BlankManufacturingDto;
import com.haimeixianghao.demo1.entity.BlankManufacturing;
import com.haimeixianghao.demo1.repository.BlankManufacturingRepository;
import com.haimeixianghao.demo1.xdm.service.XdmBlankmanuFacturingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlankManufacturingService {

    private final BlankManufacturingRepository repository;

    @Value("${idma.enabled:false}")
    private boolean idmaEnabled;

    @Autowired(required = false)
    private XdmBlankmanuFacturingService xdmService;

    public BlankManufacturingService(BlankManufacturingRepository repository) {
        this.repository = repository;
    }

    public BlankManufacturingDto create(BlankManufacturingDto dto) {
        if (idmaEnabled && xdmService != null) return xdmService.create(dto);
        BlankManufacturing e = new BlankManufacturing();
        e.setMachiningId(dto.getMachiningId());
        e.setCreateTime(LocalDateTime.now());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public BlankManufacturingDto getById(Long id) {
        if (idmaEnabled && xdmService != null) return xdmService.getById(id);
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<BlankManufacturingDto> findAll() {
        if (idmaEnabled && xdmService != null) return xdmService.findAll();
        List<BlankManufacturingDto> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(toDto(e)));
        return list;
    }

    public BlankManufacturingDto update(Long id, BlankManufacturingDto dto) {
        if (idmaEnabled && xdmService != null) return xdmService.update(id, dto);
        Optional<BlankManufacturing> o = repository.findById(id);
        if (o.isEmpty()) return null;
        BlankManufacturing e = o.get();
        e.setMachiningId(dto.getMachiningId());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public boolean delete(Long id) {
        if (idmaEnabled && xdmService != null) return xdmService.delete(id);
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    private BlankManufacturingDto toDto(BlankManufacturing e) {
        BlankManufacturingDto dto = new BlankManufacturingDto();
        dto.setId(e.getId());
        dto.setMachiningId(e.getMachiningId());
        dto.setCreateTime(e.getCreateTime() != null ? e.getCreateTime().toString() : null);
        dto.setLastUpdateTime(e.getLastUpdateTime() != null ? e.getLastUpdateTime().toString() : null);
        return dto;
    }
}

