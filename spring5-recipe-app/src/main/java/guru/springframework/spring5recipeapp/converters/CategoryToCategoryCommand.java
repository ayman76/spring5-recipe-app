package guru.springframework.spring5recipeapp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import guru.springframework.spring5recipeapp.commands.CategoryCommand;
import guru.springframework.spring5recipeapp.model.Category;
import lombok.Synchronized;

public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized
    @Override
    @Nullable
    public CategoryCommand convert(Category source) {

        if (source == null)
            return null;

        final CategoryCommand categoryCommand = new CategoryCommand();

        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());
        return categoryCommand;
    }

}
