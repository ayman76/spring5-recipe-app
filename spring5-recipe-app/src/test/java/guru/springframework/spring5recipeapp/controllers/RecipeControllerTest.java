package guru.springframework.spring5recipeapp.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.spring5recipeapp.model.Recipe;
import guru.springframework.spring5recipeapp.service.RecipeService;

public class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    RecipeController recipeController;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        recipeController = new RecipeController(recipeService);

    }

    @Test
    void testShowById() throws Exception {

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        when(recipeService.findById(anyLong())).thenReturn(recipe);

        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/show/1")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("recipe/show"));
    }
}
