package guru.springframework.spring5recipeapp.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import guru.springframework.spring5recipeapp.model.UnitOfMeasure;

@DataJpaTest
public class UnitOfMeasureRepoTest {

    @Autowired
    UnitOfMeasureRepo unitOfMeasureRepo;

    @BeforeEach
    void setUp() {
        
    }

    @Test
    @DirtiesContext
    void testFindByDescription() {

        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepo.findByDescription("Teaspoon");
        assertEquals("Teaspoon", uomOptional.get().getDescription());
    }

    @Test
    void testFindByDescriptionCup() {

        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepo.findByDescription("Cup");
        assertEquals("Cup", uomOptional.get().getDescription());
    }
}
