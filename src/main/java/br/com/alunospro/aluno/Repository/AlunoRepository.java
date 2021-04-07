package br.com.alunospro.aluno.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.alunospro.aluno.entities.Aluno;

@Repository
public class AlunoRepository {
    
    private final List<Aluno> alunos;

    public AlunoRepository(List<Aluno> alunos) {
        this.alunos = new ArrayList<>();
    }

    public List<Aluno> findAll(){
        return alunos;
    }

     //Lista os alunos da sala pelo nome implementado o CONTAIS 
    public List<Aluno> findAll(final String nome){
           return alunos.stream()
            .filter(alns -> alns.getNome().contains(nome))
            .collect(Collectors.toList());
        }
       
    //Buscando alunos pela idade
    public List<Aluno> findAll(final Integer idade){
           return alunos.stream()
            .filter(alns -> alns.getIdade().equals(idade))
            .collect(Collectors.toList());
            
    }
    //Retorna somente o ID na linha da URL
    public Aluno findById(Integer id){
        return this.alunos.stream()
        .filter(alns -> alns.getId().equals(id))
        .findFirst()
        .orElse(null);
    }

    public void update( Aluno aluno){
        alunos.stream()
            .filter(alns -> alns.getId().equals(aluno.getId()))
            .forEach (alns -> alns.setIdade(aluno.getIdade()));
            alunos.stream()
            .filter(alns -> alns.getId().equals(aluno.getId()))
            .forEach(alns -> alns.setNome(aluno.getNome())); 
    }    

    public void delete(@PathVariable("id") Integer id){
        alunos.removeIf(alns -> alns.getId().equals(id));
    }

    public int count(){
        return alunos.size();
    }

    public void add(Aluno aluno){
        this.alunos.add(aluno);
    }
 
}




    
