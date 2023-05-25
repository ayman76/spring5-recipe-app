package guru.springframework.spring5recipeapp.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.spring5recipeapp.model.Recipe;
import guru.springframework.spring5recipeapp.repositories.RecipeRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepo recipeRepo;

    public RecipeServiceImpl(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");

        Set<Recipe> recipes = new HashSet<>();

        recipeRepo.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepo.findById(id);

        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe Not Found!");
        }

        return recipeOptional.get();
    }

}
