package guru.springframework.spring5recipeapp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import guru.springframework.spring5recipeapp.commands.UnitOfMeasureCommand;
import guru.springframework.spring5recipeapp.model.UnitOfMeasure;
import lombok.Synchronized;

public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand>{

    @Synchronized
    @Override
    @Nullable
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if(source == null)
            return null;
        
        final UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(source.getId());
        unitOfMeasureCommand.setDescription(source.getDescription());
        return unitOfMeasureCommand;
    }

    
    
}