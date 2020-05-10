package com.word_games.words.secondary;

import com.word_games.utilities.PartOfSpeech;
import com.word_games.words.Word;
import com.word_games.words.attributes.WordCase;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Предлог
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PRETEXT)
public class Pretext extends Word {

    public Pretext() {
        partOfSpeech = PartOfSpeech.PRETEXT;
        changeable = false;
    }

    @Column(name = "word_case")
    private String wordCase;

    public String getWordCase() {
        return wordCase;
    }

    public Pretext setWordCase(WordCase wordCase) {
        this.wordCase = wordCase.toString();
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " Pretext (Предлог){" +
                "wCase='" + wordCase + '\'' +
                '}';
    }
}
