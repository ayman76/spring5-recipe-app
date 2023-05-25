package guru.springframework.spring5recipeapp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import guru.springframework.spring5recipeapp.commands.NotesCommand;
import guru.springframework.spring5recipeapp.model.Notes;
import lombok.Synchronized;

public class NotesCommandToNotes implements Converter<NotesCommand, Notes>{

    @Synchronized
    @Override
    @Nullable
    public Notes convert(NotesCommand source) {
        if(source == null)
            return null;

        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNote(source.getRecipeNote());
        return notes;
    }
    
    
}
