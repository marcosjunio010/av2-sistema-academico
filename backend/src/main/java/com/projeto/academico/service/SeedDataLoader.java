package com.projeto.academico.service;

import com.projeto.academico.entity.Aluno;
import com.projeto.academico.entity.Curso;
import com.projeto.academico.repository.AlunoRepository;
import com.projeto.academico.repository.CursoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedDataLoader implements CommandLineRunner {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public SeedDataLoader(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(cursoRepository.count() == 0){
            Curso c1 = new Curso();
            c1.setNome("Análise e Desenvolvimento");
            c1.setCargaHoraria(480);
            cursoRepository.save(c1);

            Curso c2 = new Curso();
            c2.setNome("Banco de Dados");
            c2.setCargaHoraria(60);
            cursoRepository.save(c2);

            Aluno a1 = new Aluno();
            a1.setNome("João Silva");
            a1.setEmail("joao@example.com");
            a1.setMatricula("2025001");
            alunoRepository.save(a1);
        }
    }
}