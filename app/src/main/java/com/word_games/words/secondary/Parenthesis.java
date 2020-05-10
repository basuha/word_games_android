package com.word_games.words.secondary;

import com.word_games.utilities.PartOfSpeech;
import com.word_games.words.Word;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Вводное слово
 * Примеры: безусловно, видно, наверное, конечно, к удивлению
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PARENTHESIS)
public class Parenthesis extends Word {

    public Parenthesis() {
        partOfSpeech = PartOfSpeech.PARENTHESIS;
        changeable = false;
        super.codeParent = 0;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Parenthesis (Вводное слово)";
    }
}
