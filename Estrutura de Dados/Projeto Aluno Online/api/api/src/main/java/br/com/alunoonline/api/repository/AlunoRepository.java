package br.com.alunoonline.api.repository;

//interface é um modelo de contrato de metodos a serem implementados em uma classe

import br.com.alunoonline.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
