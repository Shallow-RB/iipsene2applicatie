package nl.hsleiden.model;

import nl.hsleiden.observer.Observer;
import nl.hsleiden.observer.VideoObserver;
import nl.hsleiden.subject.VideoSubject;

import java.util.ArrayList;

public class Video implements Content, VideoSubject {
    private final ArrayList<Observer<VideoSubject>> observers = new ArrayList<>();

    private int id;
    private String value;
    private Answer answer;

    public Video(int id, String value, Answer answer) {
        this.id = id;
        this.value = value;
        this.answer = answer;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public Answer getAnswer() {
        return null;
    }

    @Override
    public void registerObserver(Observer<VideoSubject> observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer<VideoSubject> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}
