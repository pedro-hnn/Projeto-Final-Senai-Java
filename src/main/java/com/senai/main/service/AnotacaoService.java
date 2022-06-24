package com.senai.main.service;
import com.senai.main.domain.Anotacao;
import com.senai.main.repository.AnotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnotacaoService {

    @Autowired
    private AnotacaoRepository repo;

    public List<Anotacao> listAll(){
        return repo.findAll();
    }

    public void save(Anotacao a){
        repo.save(a);
    }

    public Anotacao get(long id){
        return repo.findById(id).get();
    }

    public void delete(long id){
        repo.deleteById(id);
    }
}
