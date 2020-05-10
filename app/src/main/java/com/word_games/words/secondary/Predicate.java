package com.word_games.words.secondary;

import com.word_games.utilities.PartOfSpeech;
import com.word_games.words.Word;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Предикатив
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PREDICATE)
public class Predicate extends Word {

    public Predicate() {
        partOfSpeech = PartOfSpeech.PREDICATE;
        changeable = false;
        super.codeParent = 0;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Predicate (Предикатив)";
    }
}
