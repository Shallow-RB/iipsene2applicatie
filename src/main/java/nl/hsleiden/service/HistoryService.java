package nl.hsleiden.service;

import javafx.util.Pair;
import nl.hsleiden.model.Answer;
import nl.hsleiden.model.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HistoryService {
    private final ArrayList<Pair<Content, Answer>> history = new ArrayList<>();

    public HistoryService(){

    }

    public void add(Content content, Answer answer) {
        Pair<Content, Answer> history = new Pair<>(content, answer);
        this.history.add(history);
    }

    public void remove(int id) {
        history.remove(id);
    }

    public void removeLast() {
        history.remove(history.size() - 1);
    }

    public Pair<Content, Answer> get(int id) {
        return history.get(id);
    }

    public ArrayList<Pair<Content, Answer>> getHistory() {
        return history;
    }

    public Pair<Content, Answer> getLast() {
        return history.get(history.size() - 1);
    }
}
