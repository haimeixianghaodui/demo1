package com.haimeixianghao.demo1.controller;

import com.haimeixianghao.demo1.dto.WarehousingDto;
import com.haimeixianghao.demo1.service.WarehousingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/warehousing", produces = "application/json")
public class WarehousingController {

    private final WarehousingService service;

    public WarehousingController(WarehousingService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<WarehousingDto> create(@RequestBody WarehousingDto dto, UriComponentsBuilder uriBuilder) {
        WarehousingDto created = service.create(dto);
        URI location = uriBuilder.path("/api/warehousing/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping(value = "/{id}", consumes = "*/*")
    public ResponseEntity<WarehousingDto> getById(@PathVariable Long id) {
        WarehousingDto d = service.getById(id);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(d);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<WarehousingDto> update(@PathVariable Long id, @RequestBody WarehousingDto dto) {
        WarehousingDto updated = service.update(id, dto);
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
    public ResponseEntity<List<WarehousingDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}

