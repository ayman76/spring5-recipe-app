package guru.springframework.spring5recipeapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import guru.springframework.spring5recipeapp.commands.IngredientCommand;
import guru.springframework.spring5recipeapp.converters.IngredientToIngredientCommand;
import guru.springframework.spring5recipeapp.model.Recipe;
import guru.springframework.spring5recipeapp.repositories.RecipeRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepo recipeRepo;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepo recipeRepo) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepo = recipeRepo;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepo.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            log.debug("recipe id not found. id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if (!ingredientCommandOptional.isPresent()) {
            log.debug("Ingredient id not found: " + ingredientId);
        }

        return ingredientCommandOptional.get();
    }

}
