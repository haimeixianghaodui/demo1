package com.haimeixianghao.demo1.controller;

import com.haimeixianghao.demo1.dto.MachiningDto;
import com.haimeixianghao.demo1.service.MachiningService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/machining", produces = "application/json")
public class MachiningController {

    private final MachiningService service;

    public MachiningController(MachiningService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<MachiningDto> create(@RequestBody MachiningDto dto, UriComponentsBuilder uriBuilder) {
        MachiningDto created = service.create(dto);
        URI location = uriBuilder.path("/api/machining/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping(value = "/{id}", consumes = "*/*")
    public ResponseEntity<MachiningDto> getById(@PathVariable Long id) {
        MachiningDto d = service.getById(id);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(d);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<MachiningDto> update(@PathVariable Long id, @RequestBody MachiningDto dto) {
        MachiningDto updated = service.update(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping(value = "/{id}", consumes = "*/*")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean ok = service.delete(id);
        if (!ok) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @GetMapping(consumes = "*/*")
    public ResponseEntity<List<MachiningDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}

