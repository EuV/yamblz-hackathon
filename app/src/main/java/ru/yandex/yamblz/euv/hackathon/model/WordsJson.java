package ru.yandex.yamblz.euv.hackathon.model;

import java.util.ArrayList;
import java.util.List;

public class WordsJson {
    private List<String> en = new ArrayList<>();
    private List<String> ru = new ArrayList<>();

    public List<String> getRu() {
        return ru;
    }

    public void setRu(List<String> ru) {
        this.ru = ru;
    }

    public List<String> getEn() {
        return en;
    }

    public void setEn(List<String> en) {
        this.en = en;
    }
}
