package com.word_games.words.primary;

import com.word_games.utilities.PartOfSpeech;
import com.word_games.words.Word;
import com.word_games.words.attributes.Perfect;
import com.word_games.words.attributes.Reflexive;
import com.word_games.words.attributes.Time;
import com.word_games.words.attributes.Transitive;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Деепричастие
 * Примеры: решив, передав, прочитав
 */
@Entity
@DiscriminatorValue(PartOfSpeech.EXTRA_PARTICIPLE)
public class

ExtraParticiple extends Word {

    @Column(name = "transitive")
    private String transitive;

    @Column(name = "perfect")
    private String perfect;

    @Column(name = "time")
    private String time;

    @Column(name = "reflexive")
    private String reflexive;

    public ExtraParticiple() {
        partOfSpeech = PartOfSpeech.EXTRA_PARTICIPLE;
        changeable = true;
    }

    public String getTransitive() {
        return transitive;
    }

    public String getPerfect() {
        return perfect;
    }

    public String getTime() {
        return time;
    }

    public String getReflexive() {
        return reflexive;
    }

    public ExtraParticiple setTransitive(Transitive transitive) {
        this.transitive = transitive.toString();
        return this;
    }

    public ExtraParticiple setPerfect(Perfect perfect) {
        this.perfect = perfect.toString();
        return this;
    }

    public ExtraParticiple setTime(Time.Participle time) {
        this.time = time.toString();
        return this;
    }

    public ExtraParticiple setReflexive(Reflexive reflexive) {
        this.reflexive = reflexive.toString();
        return this;
    }


    @Override
    public String getInfo() {
        return super.getInfo()
                + " ExtraParticiple (Деепричастие) {" +
                "transit='" + transitive + '\'' +
                ", perfect=" + perfect +
                ", time='" + time + '\'' +
                ", reflexive=" + reflexive +
                '}';
    }
}
