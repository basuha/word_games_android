package com.word_games.words.primary;

import com.sun.istack.Nullable;
import com.word_games.utilities.PartOfSpeech;
import com.word_games.words.Word;
import com.word_games.words.attributes.AdverbType;
import com.word_games.words.attributes.Comparative;
import com.word_games.words.attributes.Type;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Наречие
 */
@Entity
@DiscriminatorValue(PartOfSpeech.ADVERB)
public class Adverb extends Word {

    @Nullable
    @Column(name = "type")
    private String type;

    @Nullable
    @Column(name = "adverb_type")
    private String adverbType;

    @Nullable
    @Column(name = "comparative")
    private String comparative;

    public Adverb() {
        partOfSpeech = PartOfSpeech.ADVERB;
        changeable = true;
    }

    public String getType() {
        return type;
    }

    public String getAdverbType() {
        return adverbType;
    }

    public String getComparative() {
        return comparative;
    }

    public Adverb setType(Type.Adverb type) {
        this.type = type.toString();
        return this;
    }

    public Adverb setComparative(Comparative comparative) {
        this.comparative = comparative.toString();
        return this;
    }

    public Adverb setAdverbType(AdverbType adverbType) {
        this.adverbType = adverbType.toString();
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Adverb (Наречие){" +
                "subType='" + type + '\'' +
                ", advSubType='" + adverbType + '\'' +
                ", comp='" + comparative + '\'' +
                '}';
    }
}

