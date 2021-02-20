package com.vetApplication.program.services;

import com.vetApplication.program.models.Turn;
import com.vetApplication.program.repositories.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnService {

    @Autowired private TurnRepository turnRepository;

    public List<Turn> getTurns(){
        return turnRepository.findAll();
    }

    public Optional<Turn> getTurn(int id){
        return turnRepository.findById(id);
    }

    public void save(Turn turn){
        turnRepository.save(turn);
    }

    public void delete(int id){
        turnRepository.deleteById(id);
    }
}
