package com.word_games.words.attributes;

public enum Plural {

    PLURAL ("plural"),
    SINGULAR ("singular"),
    N_A ("n/a");

    private final String value;

    Plural(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
