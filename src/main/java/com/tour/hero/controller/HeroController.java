package com.tour.hero.controller;

import com.tour.hero.entity.Hero;
import com.tour.hero.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hero")
public class HeroController {
    @Autowired
    private HeroService heroService;

    @GetMapping
    public ResponseEntity<List<Hero>> getHeros() {
         return new ResponseEntity<List<Hero>>(heroService.getHeros(), HttpStatus.OK);
    }
    
    @GetMapping("/")
    public ResponseEntity<Hero> getHero(@RequestParam Long id) {
        ResponseEntity<Hero> responseEntity = new ResponseEntity<Hero>((Hero) null, HttpStatus.OK);
        Optional<Hero> hero;
        hero = heroService.getHero(id);
        if (hero.isPresent()) {
            responseEntity = new ResponseEntity<Hero>(hero.get(), HttpStatus.OK);
            System.out.println("Hero retrieved...");
        }

        return responseEntity;
    }

    @DeleteMapping
    public void deleteHero(@RequestParam Long id){
        heroService.deleteHero(id);
        System.out.println("Hero deleted...");
    }

    @PostMapping
    public void createHero(@RequestParam String name){
        Hero hero = new Hero();
        hero.setName(name);
        heroService.createHero(hero);
        System.out.println("Hero created...");

    }

    @PutMapping
    public void updateHero(@RequestParam String name, @RequestParam Long id){
        heroService.updateHero(id,name);
        System.out.println("Hero updated...");
    }

}
