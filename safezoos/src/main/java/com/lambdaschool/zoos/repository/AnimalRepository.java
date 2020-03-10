package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.view.AnimalZooCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    Animal findByAnimaltype(String type);

    @Query(value = "SELECT a.animaltype AS animalname, COUNT(z.zooid) as zoos FROM animal a LEFT JOIN zooanimals z ON a.animalid = z.animalid GROUP BY animaltype ORDER BY zoos DESC", nativeQuery = true)
    List<AnimalZooCount> animalCounts();

}


