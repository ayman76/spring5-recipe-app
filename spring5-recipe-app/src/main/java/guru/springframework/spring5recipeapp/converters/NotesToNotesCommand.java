package guru.springframework.spring5recipeapp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import guru.springframework.spring5recipeapp.commands.NotesCommand;
import guru.springframework.spring5recipeapp.model.Notes;
import lombok.Synchronized;

public class NotesToNotesCommand implements Converter<Notes, NotesCommand>{

    @Synchronized
    @Override
    @Nullable
    public NotesCommand convert(Notes source) {
        if(source == null)
            return null;

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNote(source.getRecipeNote());
        return notesCommand;
    }
    
    
}
