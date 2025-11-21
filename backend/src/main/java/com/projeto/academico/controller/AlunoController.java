package com.projeto.academico.controller;

import com.projeto.academico.entity.Aluno;
import com.projeto.academico.entity.Curso;
import com.projeto.academico.repository.AlunoRepository;
import com.projeto.academico.repository.CursoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoController(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    @GetMapping
    public List<Aluno> listar() { return alunoRepository.findAll(); }

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
        Aluno salvo = alunoRepository.save(aluno);
        return ResponseEntity.status(201).body(salvo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno a) {
        return alunoRepository.findById(id)
          .map(existing -> {
            existing.setNome(a.getNome());
            existing.setEmail(a.getEmail());
            existing.setMatricula(a.getMatricula());
            Aluno s = alunoRepository.save(existing);
            return ResponseEntity.ok(s);
          }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("{alunoId}/cursos/{cursoId}")
    public ResponseEntity<?> vincularCurso(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        var aluno = alunoRepository.findById(alunoId).orElseThrow();
        var curso = cursoRepository.findById(cursoId).orElseThrow();
        aluno.getCursos().add(curso);
        alunoRepository.save(aluno);
        return ResponseEntity.ok(aluno);
    }
}