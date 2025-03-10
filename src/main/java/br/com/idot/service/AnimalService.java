package br.com.idot.service;

import br.com.idot.model.Animal;
import br.com.idot.model.AnimalType;
import br.com.idot.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public Animal registerAnimal(Animal animal){
        if(animal.getType() == null || !isValidAnimalType(animal.getType())){
            throw new IllegalArgumentException("Tipo de animal inválido. Valores válidos: Gato e Cachoro");
        }
        return animalRepository.save(animal);
    }

    public List<Animal> getAllAnimals(){
        return animalRepository.findAll();
    }

    private boolean isValidAnimalType(AnimalType type){
        return type == AnimalType.CACHORRO || type == AnimalType.GATO;
    }
}
