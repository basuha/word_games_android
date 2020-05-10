package com.word_games.words;

import com.word_games.utilities.HibernateUtil;
import com.word_games.words.primary.Adjective;
import com.word_games.words.primary.Adverb;
import com.word_games.words.primary.ExtraParticiple;
import com.word_games.words.primary.Noun;
import com.word_games.words.primary.Numeral;
import com.word_games.words.primary.Participle;
import com.word_games.words.primary.Verb;
import com.word_games.words.secondary.Conjunction;
import com.word_games.words.secondary.Interjection;
import com.word_games.words.secondary.Parenthesis;
import com.word_games.words.secondary.Particle;
import com.word_games.words.secondary.Predicate;
import com.word_games.words.secondary.Pretext;
import com.word_games.words.secondary.Pronoun;

import org.hibernate.Session;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Родительский класс всех частей речи
 * @see Adjective
 * @see Verb
 * @see Noun
 * @see Adverb
 * @see Participle
 * @see Particle
 * @see Parenthesis
 * @see Numeral
 * @see Interjection
 * @see ExtraParticiple
 * @see Pronoun
 * @see Pretext
 * @see Predicate
 * @see Conjunction
 */
@Entity
@Table(name = "words_test")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "part_of_speech")
public class Word {

    @Transient
    protected boolean changeable;

    @Id
    @Column(name = "IID", nullable = false)
    protected Integer IID;

    @Column(name = "word", nullable = false)
    protected String word;

    @Column(name = "code", nullable = false)
    protected Integer code;

    @Column(name = "part_of_speech", insertable = false, updatable = false, nullable = false)
    protected String partOfSpeech;

    @Column(name = "code_parent", nullable = false)
    protected Integer codeParent;

    @Transient
    @OneToMany(targetEntity = Word.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    protected List<Word> cognates = new ArrayList<>();

    public Integer getIID() {
        return IID;
    }

    public void setIID(Integer IID) {
        this.IID = IID;
    }

    public String getWord() {
        return word;
    }

    public Word setWord(String word) {
        this.word = word;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public Integer getCodeParent() {
        return codeParent;
    }

    public void setCodeParent(Integer codeParent) {
        this.codeParent = codeParent;
    }

    public boolean isChangeable() {
        return changeable;
    }

    public String getInfo() {
        return "Word{" +
                "IID=" + IID +
                ", word='" + word + '\'' +
                ", code=" + code +
                ", codeParent=" + codeParent +
                '}';
    }

    public List<Word> getCognates() {
        findCognates();
        return cognates;
    }

    private void findCognates() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Word w = session.createQuery("FROM ")
//        session.close();

        if (cognates.isEmpty() && IID != null) {
            for (int i = 1; ; i++) {
                Word word = Word.findById(this.IID + i);
                if (word.getCodeParent() == 0) {
                    break;
                }
                cognates.add(word);
            }

            if (this.codeParent != 0) {
                for (int j = 1; ; j++) {
                    Word word = Word.findById(this.IID - j);
                    cognates.add(word);
                    if (word.getCodeParent() == 0) {
                        break;
                    }
                }
            }
        }
    }

    public static Word findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Word word = session.get(Word.class, id);
        session.close();
        return word;
    }

    public static List<Word> find(String word) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Word.class);
        Root<Word> root = cq.from(Word.class);
        cq.select(root).where(cb.like(root.<String>get("word"), word));
        Query query = session.createQuery(cq);
        List<Word> wordList = query.getResultList();

        session.close();
        return wordList;
    }

    @Override
    public String toString() {
         return this.word;
    }
}
