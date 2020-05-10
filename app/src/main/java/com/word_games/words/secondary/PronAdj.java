package com.word_games.words.secondary;

import com.word_games.utilities.PartOfSpeech;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Местоимение-существительное
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PRON_ADJ)
public class PronAdj extends Pronoun {

    public PronAdj() {
        partOfSpeech = PartOfSpeech.PRON_ADJ;
        changeable = false;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Pronoun-adjective(Местоимение-прл)";
    }
}