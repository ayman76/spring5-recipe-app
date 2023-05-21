package guru.springframework.spring5recipeapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5recipeapp.model.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);

}
