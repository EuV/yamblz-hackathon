package ru.yandex.yamblz.euv.hackathon.model;

public class Word {
    public final int id;
    public final String word;
    public final Lang lang;
    public int progress;

    public Word(int id, String word, Lang lang, int progress) {
        this.id = id;
        this.word = word;
        this.lang = lang;
        this.progress = progress;
    }


    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", lang=" + lang +
                ", progress=" + progress +
                '}';
    }
}
