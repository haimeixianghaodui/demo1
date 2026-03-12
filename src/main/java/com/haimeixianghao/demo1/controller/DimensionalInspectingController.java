package com.haimeixianghao.demo1.controller;

import com.haimeixianghao.demo1.dto.DimensionalInspectingDto;
import com.haimeixianghao.demo1.service.DimensionalInspectingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/dimensional-inspecting", produces = "application/json")
public class DimensionalInspectingController {

    private final DimensionalInspectingService service;

    public DimensionalInspectingController(DimensionalInspectingService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<DimensionalInspectingDto> create(@RequestBody DimensionalInspectingDto dto, UriComponentsBuilder uriBuilder) {
        DimensionalInspectingDto created = service.create(dto);
        URI location = uriBuilder.path("/api/dimensional-inspecting/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping(value = "/{id}", consumes = "*/*")
    public ResponseEntity<DimensionalInspectingDto> getById(@PathVariable Long id) {
        DimensionalInspectingDto d = service.getById(id);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(d);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<DimensionalInspectingDto> update(@PathVariable Long id, @RequestBody DimensionalInspectingDto dto) {
        DimensionalInspectingDto updated = service.update(id, dto);
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
    public ResponseEntity<List<DimensionalInspectingDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}

