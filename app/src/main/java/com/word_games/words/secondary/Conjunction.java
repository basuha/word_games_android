package com.word_games.words.secondary;
import com.word_games.utilities.PartOfSpeech;
import com.word_games.words.Word;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Союз
 * Примеры: а, и, но, или, также
 */
@Entity
@DiscriminatorValue(PartOfSpeech.CONJUNCTION)
public class Conjunction extends Word {

    public Conjunction() {
        partOfSpeech = PartOfSpeech.CONJUNCTION;
        changeable = false;
        super.codeParent = 0;
    }

    @Override
    public String getInfo() {
        return super.getInfo()
                + " Conjunction (Союз)";
    }
}
