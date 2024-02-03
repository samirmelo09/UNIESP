package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repository;

    public void create(Disciplina disciplina) {
        repository.save(disciplina);
    }

    public List<Disciplina> findAll() {
        return repository.findAll();
    }

    public Optional<Disciplina> findById(long id) {
        return repository.findById(id);

    }

    public void  update( Long id, Disciplina disciplina) {
        Optional<Disciplina> disciplinaFromDB = findById(id);

        if (disciplinaFromDB.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada!");
        }

        Disciplina disciplinaUpdated = disciplinaFromDB.get();

        disciplinaUpdated.setNome(disciplina.getNome());
        disciplinaUpdated.setProfessor(disciplina.getProfessor());

        repository.save(disciplinaUpdated);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}

