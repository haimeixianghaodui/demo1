package com.haimeixianghao.demo1.controller;

import com.haimeixianghao.demo1.dto.DeviceCreateDto;
import com.haimeixianghao.demo1.dto.DeviceDto;
import com.haimeixianghao.demo1.dto.DeviceUpdateDto;
import com.haimeixianghao.demo1.service.DeviceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/devices", produces = "application/json", consumes = "application/json")
public class DeviceController {

    private final DeviceService service;

    public DeviceController(DeviceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeviceDto> create(@Valid @RequestBody DeviceCreateDto dto, UriComponentsBuilder uriBuilder) {
        DeviceDto created = service.create(dto);
        URI location = uriBuilder.path("/api/devices/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping(value = "/{id}", consumes = "*/*")
    public ResponseEntity<DeviceDto> getById(@PathVariable Long id) {
        DeviceDto d = service.getById(id);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(d);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceDto> update(@PathVariable Long id, @Valid @RequestBody DeviceUpdateDto dto) {
        DeviceDto updated = service.update(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping(value = "/{id}", consumes = "*/*")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean ok = service.delete(id);
        if (!ok) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "", consumes = "*/*")
    public ResponseEntity<List<DeviceDto>> search(@RequestParam(value = "q", required = false) String q) {
        if (q == null || q.isBlank()) {
            return ResponseEntity.ok(service.findAll());
        }
        List<DeviceDto> list = service.searchByCodeOrName(q);
        return ResponseEntity.ok(list);
    }
}

