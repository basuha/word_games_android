package com.word_games.words.secondary;

import com.sun.istack.Nullable;
import com.word_games.utilities.PartOfSpeech;
import com.word_games.words.Word;
import com.word_games.words.attributes.Gender;
import com.word_games.words.attributes.Plural;
import com.word_games.words.attributes.WordCase;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Местоимение
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PRONOUN)
public class Pronoun extends Word {

    @Nullable
    @Column(name = "plural")
    private String plural;

    @Nullable
    @Column(name = "gender")
    private String gender;

    @Nullable
    @Column(name = "word_case")
    private String wordCase;

    public Pronoun() {
        partOfSpeech = PartOfSpeech.PRONOUN;
        changeable = false;
    }

    public String getWordCase() {
        return wordCase;
    }

    public String getPlural() {
        return plural;
    }

    public String getGender() {
        return gender;
    }

    public Pronoun setPlural(Plural plural) {
        this.plural = plural.toString();
        return this;
    }

    public Pronoun setGender(Gender gender) {
        this.gender = gender.toString();
        return this;
    }

    public Pronoun setWordCase(WordCase wordCase) {
        this.wordCase = wordCase.toString();
        return this;
    }


    @Override
    public String getInfo() {
        return super.getInfo() +
                " Pronoun (Местоимение){" +
                "plural=" + plural +
                ", gender='" + gender + '\'' +
                ", wCase='" + wordCase + '\'' +
                '}';
    }

}
