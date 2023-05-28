package guru.springframework.spring5recipeapp.service;

import java.util.Set;

import guru.springframework.spring5recipeapp.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
