package com.haimeixianghao.demo1.controller;

import com.haimeixianghao.demo1.dto.BlankManufacturingDto;
import com.haimeixianghao.demo1.service.BlankManufacturingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/blank-manufacturing", produces = "application/json")
public class BlankManufacturingController {

    private final BlankManufacturingService service;

    public BlankManufacturingController(BlankManufacturingService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<BlankManufacturingDto> create(@RequestBody BlankManufacturingDto dto, UriComponentsBuilder uriBuilder) {
        BlankManufacturingDto created = service.create(dto);
        URI location = uriBuilder.path("/api/blank-manufacturing/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping(value = "/{id}", consumes = "*/*")
    public ResponseEntity<BlankManufacturingDto> getById(@PathVariable Long id) {
        BlankManufacturingDto d = service.getById(id);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(d);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<BlankManufacturingDto> update(@PathVariable Long id, @RequestBody BlankManufacturingDto dto) {
        BlankManufacturingDto updated = service.update(id, dto);
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
    public ResponseEntity<List<BlankManufacturingDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}

