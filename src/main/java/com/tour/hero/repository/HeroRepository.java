package com.tour.hero.repository;

import com.tour.hero.entity.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends MongoRepository<Hero, Long> {
    @Query("{name:'?0'}")
    Hero findItemByName(String name);

    @Query(value="{name:'?0'}", fields="{'name' : 1, 'id' : 1}")
    List<Hero> findAll(String name);

    public long count();
}
