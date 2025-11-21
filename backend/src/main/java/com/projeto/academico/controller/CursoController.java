package com.projeto.academico.controller;

import com.projeto.academico.entity.Curso;
import com.projeto.academico.repository.CursoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping
    public List<Curso> listar() { return cursoRepository.findAll(); }

    @PostMapping
    public ResponseEntity<Curso> criar(@RequestBody Curso curso) {
        Curso salvo = cursoRepository.save(curso);
        return ResponseEntity.status(201).body(salvo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable Long id, @RequestBody Curso c) {
        return cursoRepository.findById(id)
          .map(existing -> {
            existing.setNome(c.getNome());
            existing.setCargaHoraria(c.getCargaHoraria());
            Curso s = cursoRepository.save(existing);
            return ResponseEntity.ok(s);
          }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cursoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}