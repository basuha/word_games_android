package com.word_games.words.primary;

import com.word_games.utilities.PartOfSpeech;
import com.word_games.words.Word;
import com.word_games.words.attributes.Face;
import com.word_games.words.attributes.Gender;
import com.word_games.words.attributes.Infinitive;
import com.word_games.words.attributes.Kind;
import com.word_games.words.attributes.Perfect;
import com.word_games.words.attributes.Plural;
import com.word_games.words.attributes.Reflexive;
import com.word_games.words.attributes.Time;
import com.word_games.words.attributes.Transitive;
import com.word_games.words.attributes.Voice;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(PartOfSpeech.VERB)
public class Verb extends Word {

    @Column (name = "infinitive")
    private String infinitive;

    @Column (name = "reflexive")
    private String reflexive;

    @Column (name = "transitive")
    private String transitive;

    @Column (name = "plural")
    private String plural;

    @Column (name = "gender")
    private String gender;

    @Column (name = "perfect")
    private String perfect;

    @Column (name = "face")
    private String face;

    @Column (name = "kind")
    private String kind;

    @Column (name = "time")
    private String time;

    @Column (name = "voice")
    private String voice;

    public Verb() {
        partOfSpeech = PartOfSpeech.PARTICIPLE;
        changeable = true;
    }

    public String getPlural() {
        return plural;
    }

    public String getGender() {
        return gender;
    }

    public String getTransitive() {
        return transitive;
    }

    public String getPerfect() {
        return perfect;
    }

    public String getFace() {
        return face;
    }

    public String getKind() {
        return kind;
    }

    public String getTime() {
        return time;
    }

    public String getInfinitive() {
        return infinitive;
    }

    public String getReflexive() {
        return reflexive;
    }

    public String getVoice() {
        return voice;
    }


    public Verb setPlural(Plural plural) {
        this.plural = plural.toString();
        return this;
    }

    public Verb setGender(Gender gender) {
        this.gender = gender.toString();
        return this;
    }

    public Verb setTransitive(Transitive transitive) {
        this.transitive = transitive.toString();
        return this;
    }

    public Verb setPerfect(Perfect perfect) {
        this.perfect = perfect.toString();
        return this;
    }

    public Verb setFace(Face face) {
        this.face = face.toString();
        return this;
    }

    public Verb setKind(Kind kind) {
        this.kind = kind.toString();
        return this;
    }

    public Verb setTime(Time time) {
        this.time = time.toString();
        return this;
    }

    public Verb setInfinitive(Infinitive infinitive) {
        this.infinitive = infinitive.toString();
        return this;
    }

    public Verb setReflexive(Reflexive reflexive) {
        this.reflexive = reflexive.toString();
        return this;
    }

    public Verb setVoice(Voice voice) {
        this.voice = voice.toString();
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo()
                + " Verb(Глагол){" +
                "infinitive='" + infinitive + '\'' +
                ", reflexive='" + reflexive + '\'' +
                ", transitive='" + transitive + '\'' +
                ", plural='" + plural + '\'' +
                ", gender='" + gender + '\'' +
                ", perfect='" + perfect + '\'' +
                ", face='" + face + '\'' +
                ", kind='" + kind + '\'' +
                ", time='" + time + '\'' +
                ", voice='" + voice + '\'' +
                '}';
    }
}
