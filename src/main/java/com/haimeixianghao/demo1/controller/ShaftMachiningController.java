package com.haimeixianghao.demo1.controller;

import com.haimeixianghao.demo1.dto.ShaftMachiningDto;
import com.haimeixianghao.demo1.service.ShaftMachiningService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/shaft-machining", produces = "application/json")
public class ShaftMachiningController {

    private final ShaftMachiningService service;

    public ShaftMachiningController(ShaftMachiningService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<ShaftMachiningDto> create(@RequestBody ShaftMachiningDto dto, UriComponentsBuilder uriBuilder) {
        ShaftMachiningDto created = service.create(dto);
        URI location = uriBuilder.path("/api/shaft-machining/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping(value = "/{id}", consumes = "*/*")
    public ResponseEntity<ShaftMachiningDto> getById(@PathVariable Long id) {
        ShaftMachiningDto d = service.getById(id);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(d);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<ShaftMachiningDto> update(@PathVariable Long id, @RequestBody ShaftMachiningDto dto) {
        ShaftMachiningDto updated = service.update(id, dto);
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
    public ResponseEntity<List<ShaftMachiningDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}

