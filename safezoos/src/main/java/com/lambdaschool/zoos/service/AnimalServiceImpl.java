package com.lambdaschool.zoos.service;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.repository.AnimalRepository;
import com.lambdaschool.zoos.view.AnimalZooCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService
{
    @Autowired
    private AnimalRepository animalrepos;

    @Override
    public ArrayList<Animal> findAll()
    {
        ArrayList<Animal> list = new ArrayList<>();
        animalrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Animal findAnimalByType(String type) throws EntityNotFoundException
    {
        Animal animal = animalrepos.findByAnimaltype(type);

        if (animal == null)
        {
            throw new EntityNotFoundException("Animal " + type + " not found!");
        }
        return animal;
    }

    @Override
    public List<AnimalZooCount> animalCounts()
    {
        return animalrepos.animalCounts();
    }


}
