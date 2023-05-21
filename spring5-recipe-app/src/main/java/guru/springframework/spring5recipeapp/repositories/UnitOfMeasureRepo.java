package guru.springframework.spring5recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5recipeapp.model.UnitOfMeasure;

public interface UnitOfMeasureRepo extends CrudRepository<UnitOfMeasure, Long> {

}
