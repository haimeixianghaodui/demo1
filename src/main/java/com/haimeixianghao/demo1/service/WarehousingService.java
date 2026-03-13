package com.haimeixianghao.demo1.service;

import com.haimeixianghao.demo1.dto.WarehousingDto;
import com.haimeixianghao.demo1.entity.Warehousing;
import com.haimeixianghao.demo1.repository.WarehousingRepository;
import com.haimeixianghao.demo1.xdm.service.XdmWarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WarehousingService {

    private final WarehousingRepository repository;

    @Value("${idma.enabled:false}")
    private boolean idmaEnabled;

    @Autowired(required = false)
    private XdmWarehousingService xdmService;

    public WarehousingService(WarehousingRepository repository) {
        this.repository = repository;
    }

    public WarehousingDto create(WarehousingDto dto) {
        if (idmaEnabled && xdmService != null) return xdmService.create(dto);
        Warehousing e = new Warehousing();
        e.setInPartId(dto.getInPartId());
        e.setCreateTime(LocalDateTime.now());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public WarehousingDto getById(Long id) {
        if (idmaEnabled && xdmService != null) return xdmService.getById(id);
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<WarehousingDto> findAll() {
        if (idmaEnabled && xdmService != null) return xdmService.findAll();
        List<WarehousingDto> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(toDto(e)));
        return list;
    }

    public WarehousingDto update(Long id, WarehousingDto dto) {
        if (idmaEnabled && xdmService != null) return xdmService.update(id, dto);
        Optional<Warehousing> o = repository.findById(id);
        if (o.isEmpty()) return null;
        Warehousing e = o.get();
        e.setInPartId(dto.getInPartId());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public boolean delete(Long id) {
        if (idmaEnabled && xdmService != null) return xdmService.delete(id);
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    private WarehousingDto toDto(Warehousing e) {
        WarehousingDto dto = new WarehousingDto();
        dto.setId(e.getId());
        dto.setInPartId(e.getInPartId());
        dto.setCreateTime(e.getCreateTime() != null ? e.getCreateTime().toString() : null);
        dto.setLastUpdateTime(e.getLastUpdateTime() != null ? e.getLastUpdateTime().toString() : null);
        return dto;
    }
}

