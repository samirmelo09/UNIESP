package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Aluno aluno) {
        service.create(aluno);

    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno buscarPorEmail(@PathVariable String email){
        return service.buscarPorEmail(email);
    }
    @GetMapping("/email/jpql/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno buscarPorEmailJPQL(String email){
        return service.buscarPorEmailJPQL(email);
    }
    @GetMapping("all/nome/asc")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listarAlunoOrdenadoPorNome(){
        return service.listarTodosOrdenadoPorNome();
    }
    @GetMapping("/nome/{nome}/email/{email}")
    @ResponseStatus(HttpStatus.OK)
        public Aluno buscarPorNomeEmail(@PathVariable String nome, @PathVariable String email){
        return service.buscarPorNomeEmail(nome, email);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Aluno aluno) {
        service.update(id, aluno);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
