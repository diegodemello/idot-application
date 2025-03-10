package br.com.idot.controller;

import br.com.idot.model.Animal;
import br.com.idot.model.User;
import br.com.idot.service.AnimalService;
import br.com.idot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {
    @Autowired
    private AnimalService animalService;
    @Autowired
    private UserService userService;

    @PostMapping("register_animal")
    public Animal addAnimal(@RequestBody Animal animal){
        User user = userService.findUserById(animal.getUser().getId());
        animal.setUser(user);

        return animalService.registerAnimal(animal);
    }

    @GetMapping("animals")
    public List<Animal> getAllAnimals(){
        return animalService.getAllAnimals();
    }
}
