package br.com.alunospro.aluno.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.alunospro.aluno.entities.Aluno;
import br.com.alunospro.aluno.service.AlunoServices;


@RestController
@RequestMapping("/salaDeAula")
public class AlunoControler {

    private final List<Aluno> alunos;

    @Autowired
    private AlunoServices alunoServices;

    public AlunoControler(){
        this.alunos = new ArrayList<>();
    }
    
      //Lista os alunos da sala pelo nome implementado o CONTAIS 
    @GetMapping
    public List<Aluno>findAll(@RequestParam(required = false) String nome){
       return alunoServices.findAll(nome);
    }

    //Buscando alunos pela idade
    @GetMapping("/")
    public List<Aluno> findAll(@RequestParam(required = false) Integer idade){
        return alunoServices.findAll(idade);
    }

    //Retorna somente o ID na linha da URL
    @GetMapping("/{id}")
    public Aluno findBy(@PathVariable("id") Integer id){
        return alunoServices.findById(id);
    }
       
    //Adicionando ddos no postman retorna codido 201
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final Aluno aluno){
        Integer id = alunoServices.add(aluno);
        return new ResponseEntity<>(aluno.getId(), HttpStatus.CREATED);
    }

    //Alterando dados no postman retorna codido 204
    @PutMapping
    public ResponseEntity update(@RequestBody Aluno aluno){
        alunoServices.update(aluno);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }    

    //Apagando dados no postaman retorna codido 204
    //com ("/{id}") -> indica qual ID da url deseja alterar
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        alunoServices.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
