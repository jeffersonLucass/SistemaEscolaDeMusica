package br.com.grupo.trabalho.obser;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.grupo.trabalho.Professor;

public class Sujeito {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String mensagem) {
    	for (Observer observer : observers) {
            observer.update(mensagem);
        }
    }
}
