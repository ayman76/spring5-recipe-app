package guru.springframework.spring5recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5recipeapp.service.RecipeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;

    

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }



    @RequestMapping({ "", "/", "/index" })
    public String getIndexPage(Model model) {
        log.debug("Getting index Page");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }

}
