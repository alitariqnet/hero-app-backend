package com.tour.hero.service;

import com.tour.hero.entity.Hero;
import com.tour.hero.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public Optional<Hero> getHero(Long id){
        return heroRepository.findById(id);
    }
    public List<Hero> getHeros(){
        return heroRepository.findAll();
    }
    public void deleteHero(Long id){
        heroRepository.deleteById(id);
    }

    public void createHero(Hero hero){
        heroRepository.save(hero);
    }

    public void updateHero(Long id, String name){
        Hero hero = new Hero();
        hero.setId(id);
        hero.setName(name);
        heroRepository.save(hero);
    }
}
