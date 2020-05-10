package com.word_games.words.primary;

import com.word_games.utilities.PartOfSpeech;
import com.word_games.words.Word;
import com.word_games.words.attributes.Gender;
import com.word_games.words.attributes.Plural;
import com.word_games.words.attributes.Type;
import com.word_games.words.attributes.WordCase;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Числительные
 */
@Entity
@DiscriminatorValue(PartOfSpeech.NUMERAL)
public class Numeral extends Word {

    @Column(name = "type")
    private String type;

    @Column(name = "plural")
    private String plural;

    @Column(name = "gender")
    private String gender;

    @Column(name = "word_case")
    private String wordCase;

    public Numeral() {
        partOfSpeech = PartOfSpeech.NUMERAL;
        changeable = true;
    }

    public String getType() {
        return type;
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


    public Numeral setType(Type.Numeral type) {
        this.type = type.toString();
        return this;
    }

    public Numeral setPlural(Plural plural) {
        this.plural = plural.toString();
        return this;
    }

    public Numeral setGender(Gender gender) {
        if (gender == Gender.N_A) {
            this.gender = gender.toString();
            this.plural = Plural.PLURAL.toString();
        } else {
            this.gender = gender.toString();
            this.plural = Plural.SINGULAR.toString();
        }
        return this;
    }

    public Numeral setWordCase(WordCase wordCase) {
        this.wordCase = wordCase.toString();
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Numeral (Числительное) {" +
                "type='" + type + '\'' +
                ", plural=" + plural +
                ", gender='" + gender + '\'' +
                ", wCase='" + wordCase + '\'' +
                '}';
    }
}
