package com.word_games.words.secondary;

import com.word_games.utilities.PartOfSpeech;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Местоимение-прилагательное
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PRON_NOUN)
public class PronNoun extends Pronoun {

    public PronNoun() {
        partOfSpeech = PartOfSpeech.PRON_NOUN;
        changeable = false;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Pronoun-noun(Местоимение-сущ)";
    }
}

