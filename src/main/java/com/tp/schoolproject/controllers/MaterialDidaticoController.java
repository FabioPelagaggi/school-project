package com.tp.schoolproject.controllers;

import com.tp.schoolproject.entity.MaterialDidatico;
import com.tp.schoolproject.service.MaterialDidaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materiais")
public class MaterialDidaticoController {

    @Autowired
    private MaterialDidaticoService materialDidaticoService;

    @GetMapping
    public List<MaterialDidatico> getAllMateriais() {
        return materialDidaticoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDidatico> getMaterialById(@PathVariable String id) {
        Optional<MaterialDidatico> material = materialDidaticoService.findById(id);
        return material.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MaterialDidatico createMaterial(@RequestBody MaterialDidatico materialDidatico) {
        return materialDidaticoService.save(materialDidatico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialDidatico> updateMaterial(@PathVariable String id, @RequestBody MaterialDidatico materialDetails) {
        Optional<MaterialDidatico> material = materialDidaticoService.findById(id);
        if (material.isPresent()) {
            MaterialDidatico updatedMaterial = material.get();
            updatedMaterial.setTitulo(materialDetails.getTitulo());
            updatedMaterial.setDescricao(materialDetails.getDescricao());
            return ResponseEntity.ok(materialDidaticoService.save(updatedMaterial));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable String id) {
        if (materialDidaticoService.findById(id).isPresent()) {
            materialDidaticoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}