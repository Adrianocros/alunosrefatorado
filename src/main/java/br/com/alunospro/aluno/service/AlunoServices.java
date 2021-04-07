package br.com.alunospro.aluno.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.alunospro.aluno.Repository.AlunoRepository;
import br.com.alunospro.aluno.entities.Aluno;

@Service
public class AlunoServices {

    @Autowired
   private AlunoRepository alunoRepository;

    //Listando os nomes
    public List<Aluno> findAll(String nome){
        if(nome != null){
            return alunoRepository.findAll(nome);
        }
            return alunoRepository.findAll();
    }

      //Listando por idade
    public List<Aluno> findAll(Integer idade){
        if(idade != null){
            return alunoRepository.findAll(idade);
        }
            return alunoRepository.findAll();
    }

    //Retorna somente o ID
    public Aluno findById(Integer id){
        return alunoRepository.findById(id);
    }
     //Adicionando mensagem no postman retorna codido 201
    public Integer add(final Aluno aluno){
        if(aluno.getId() == null){
            aluno.setId(alunoRepository.count() + 1);
        }
        alunoRepository.add(aluno);
        return aluno.getId();
    }
    //Update 
    public void update(final Aluno aluno){
        alunoRepository.update(aluno);
    }
    //delete
    public void delete(@PathVariable("id") Integer id) {
        alunoRepository.delete(id);
    }
    
}
