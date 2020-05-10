package com.word_games.words.primary;

import com.word_games.utilities.PartOfSpeech;
import com.word_games.words.Word;
import com.word_games.words.attributes.Comparative;
import com.word_games.words.attributes.Gender;
import com.word_games.words.attributes.Plural;
import com.word_games.words.attributes.Type;
import com.word_games.words.attributes.WordCase;

import javax.persistence.*;
import java.util.List;

/**
 * Прилагательное
 */
@Entity
@DiscriminatorValue(PartOfSpeech.ADJECTIVE)
public class Adjective extends Word {

    @Column(name = "short")
    private String shortF;

    @Column(name = "plural")
    private String plural;

    @Column(name = "gender")
    private String gender;

    @Column(name = "type")
    private String type;

    @Column(name = "word_case")
    private String wordCase;

    @Column(name = "comparative")
    private String comparative;

    public Adjective() {
        partOfSpeech = PartOfSpeech.ADJECTIVE;
    }

    public String getShortF() {
        return shortF;
    }

    public String getPlural() {
        return plural;
    }

    public String getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }

    public String getWordCase() {
        return wordCase;
    }

    public String getComparative() {
        return comparative;
    }

    public Adjective setShortF(Short shortF) {
        this.shortF = shortF.toString();
        return this;
    }

    public Adjective setPlural(Plural plural) {
        this.plural = plural.toString();
        return this;
    }

    public Adjective setGender(Gender gender) {
        if (gender == Gender.N_A) {
            this.gender = gender.toString();
            this.plural = Plural.PLURAL.toString();
        } else {
            this.gender = gender.toString();
            this.plural = Plural.SINGULAR.toString();
        }
        return this;
    }

    public Adjective setType(Type.Adjective type) {
        if (type == Type.Adjective.IMMUTABLE) {
            this.gender = "n/a";
            this.plural = "n/a";
            this.wordCase = "n/a";
            this.comparative = "n/a";
            this.shortF = "not_short";
        } else {
            this.type = type.toString();
        }
        return this;
    }

    public Adjective setWordCase(WordCase wordCase) {
        this.wordCase = wordCase.toString();
        return this;
    }

    public Adjective setComparative(Comparative comparative) {
        this.comparative = comparative.toString();
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Adjective (прилагательное) {" +
                "shortF=" + shortF +
                ", plural=" + plural +
                ", gender='" + gender + '\'' +
                ", subType='" + type + '\'' +
                ", wCase='" + wordCase + '\'' +
                ", comp='" + comparative + '\'' +
                '}';
    }
}
