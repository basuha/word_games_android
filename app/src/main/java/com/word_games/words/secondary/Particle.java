package com.word_games.words.secondary;

import com.word_games.utilities.PartOfSpeech;
import com.word_games.words.Word;

import javax.persistence.*;


/**
 * Частица
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PARTICLE)
public class Particle extends Word {

    public Particle() {
        partOfSpeech = PartOfSpeech.PARTICLE;
        changeable = false;
        super.codeParent = 0;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Particle (Частица)";
    }
}
