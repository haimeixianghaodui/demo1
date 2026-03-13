package com.haimeixianghao.demo1.service;

import com.haimeixianghao.demo1.dto.MachiningDto;
import com.haimeixianghao.demo1.entity.Machining;
import com.haimeixianghao.demo1.repository.MachiningRepository;
import com.haimeixianghao.demo1.xdm.service.XdmMachiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MachiningService {

    private final MachiningRepository repository;

    @Value("${idma.enabled:false}")
    private boolean idmaEnabled;

    @Autowired(required = false)
    private XdmMachiningService xdmService;

    public MachiningService(MachiningRepository repository) {
        this.repository = repository;
    }

    public MachiningDto create(MachiningDto dto) {
        if (idmaEnabled && xdmService != null) return xdmService.create(dto);
        Machining e = new Machining();
        e.setMachiningShaftMachiningId(dto.getMachiningShaftMachiningId());
        e.setCreateTime(LocalDateTime.now());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public MachiningDto getById(Long id) {
        if (idmaEnabled && xdmService != null) return xdmService.getById(id);
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<MachiningDto> findAll() {
        if (idmaEnabled && xdmService != null) return xdmService.findAll();
        List<MachiningDto> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(toDto(e)));
        return list;
    }

    public MachiningDto update(Long id, MachiningDto dto) {
        if (idmaEnabled && xdmService != null) return xdmService.update(id, dto);
        Optional<Machining> o = repository.findById(id);
        if (o.isEmpty()) return null;
        Machining e = o.get();
        e.setMachiningShaftMachiningId(dto.getMachiningShaftMachiningId());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public boolean delete(Long id) {
        if (idmaEnabled && xdmService != null) return xdmService.delete(id);
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    private MachiningDto toDto(Machining e) {
        MachiningDto dto = new MachiningDto();
        dto.setId(e.getId());
        dto.setMachiningShaftMachiningId(e.getMachiningShaftMachiningId());
        dto.setCreateTime(e.getCreateTime() != null ? e.getCreateTime().toString() : null);
        dto.setLastUpdateTime(e.getLastUpdateTime() != null ? e.getLastUpdateTime().toString() : null);
        return dto;
    }
}

