package guru.springframework.spring5recipeapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.spring5recipeapp.model.Recipe;
import guru.springframework.spring5recipeapp.repositories.RecipeRepo;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepo recipeRepo;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepo);
    }

    @Test
    void testGetRecipeByID() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepo.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull(recipeReturned, "Null recipe returned");
        verify(recipeRepo, times(1)).findById(anyLong());
        verify(recipeRepo, never()).findAll();
    }

    @Test
    void testGetRecipes() throws Exception {

        Recipe recipe = new Recipe();
        HashSet<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipesData);
        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);
        verify(recipeRepo, times(1)).findAll();
        verify(recipeRepo, never()).findById(anyLong());
    }
}
