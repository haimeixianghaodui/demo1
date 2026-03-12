package com.haimeixianghao.demo1.controller;

import com.haimeixianghao.demo1.dto.PartDto;
import com.haimeixianghao.demo1.service.PartService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/parts", produces = "application/json")
public class PartController {

    private final PartService service;

    public PartController(PartService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<PartDto> create(@Valid @RequestBody PartDto dto, UriComponentsBuilder uriBuilder) {
        PartDto created = service.create(dto);
        URI location = uriBuilder.path("/api/parts/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping(value = "/{id}", consumes = "*/*")
    public ResponseEntity<PartDto> getById(@PathVariable Long id) {
        PartDto d = service.getById(id);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(d);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<PartDto> update(@PathVariable Long id, @Valid @RequestBody PartDto dto) {
        PartDto updated = service.update(id, dto);
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
    public ResponseEntity<List<PartDto>> search(@RequestParam(value = "q", required = false) String q) {
        if (q == null || q.isBlank()) return ResponseEntity.ok(service.findAll());
        return ResponseEntity.ok(service.search(q));
    }
}

