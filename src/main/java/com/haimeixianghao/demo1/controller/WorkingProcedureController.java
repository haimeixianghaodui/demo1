package com.haimeixianghao.demo1.controller;

import com.haimeixianghao.demo1.dto.WorkingProcedureDto;
import com.haimeixianghao.demo1.service.WorkingProcedureService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/working-procedures", produces = "application/json")
public class WorkingProcedureController {

    private final WorkingProcedureService service;

    public WorkingProcedureController(WorkingProcedureService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<WorkingProcedureDto> create(@Valid @RequestBody WorkingProcedureDto dto, UriComponentsBuilder uriBuilder) {
        WorkingProcedureDto created = service.create(dto);
        URI location = uriBuilder.path("/api/working-procedures/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping(value = "/{id}", consumes = "*/*")
    public ResponseEntity<WorkingProcedureDto> getById(@PathVariable Long id) {
        WorkingProcedureDto d = service.getById(id);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(d);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<WorkingProcedureDto> update(@PathVariable Long id, @Valid @RequestBody WorkingProcedureDto dto) {
        WorkingProcedureDto updated = service.update(id, dto);
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
    public ResponseEntity<List<WorkingProcedureDto>> search(@RequestParam(value = "q", required = false) String q) {
        if (q == null || q.isBlank()) return ResponseEntity.ok(service.findAll());
        return ResponseEntity.ok(service.search(q));
    }
}

