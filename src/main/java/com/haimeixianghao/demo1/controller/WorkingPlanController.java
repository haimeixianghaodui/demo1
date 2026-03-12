package com.haimeixianghao.demo1.controller;

import com.haimeixianghao.demo1.dto.WorkingPlanDto;
import com.haimeixianghao.demo1.service.WorkingPlanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/working-plans", produces = "application/json")
public class WorkingPlanController {

    private final WorkingPlanService service;

    public WorkingPlanController(WorkingPlanService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<WorkingPlanDto> create(@Valid @RequestBody WorkingPlanDto dto, UriComponentsBuilder uriBuilder) {
        WorkingPlanDto created = service.create(dto);
        URI location = uriBuilder.path("/api/working-plans/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping(value = "/{id}", consumes = "*/*")
    public ResponseEntity<WorkingPlanDto> getById(@PathVariable Long id) {
        WorkingPlanDto d = service.getById(id);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(d);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<WorkingPlanDto> update(@PathVariable Long id, @Valid @RequestBody WorkingPlanDto dto) {
        WorkingPlanDto updated = service.update(id, dto);
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
    public ResponseEntity<List<WorkingPlanDto>> search(@RequestParam(value = "q", required = false) String q) {
        if (q == null || q.isBlank()) return ResponseEntity.ok(service.findAll());
        return ResponseEntity.ok(service.search(q));
    }
}

