package br.com.grupo.trabalho.obser;
import java.util.ArrayList;//utilizado para criar uma lista dinâmica de observadores
import java.util.List;//interface para trabalhar com coleções genéricas
import java.util.Objects;//utilitário para comparações seguras de objetos

import br.com.grupo.trabalho.Professor;//importa a classe Professor, mesmo que não seja usada neste código

//classe Sujeito
//representa o "sujeito" no padrão observer, essa classe gerencia os observadores e notifica-os quando um evento ocorre
public class Sujeito {
    //lista que contém todos os observadores inscritos
    private final List<Observer> observers = new ArrayList<>();

    //método para adicionar um observador à lista
    //parâmetro observer: um objeto que implementa a interface Observer
    public void addObserver(Observer observer) {
        observers.add(observer);//adiciona o observador à lista
    }

    //método para remover um observador da lista
    //parâmetro observer: o observador que deseja ser removido
    public void removeObserver(Observer observer) {
        observers.remove(observer);//remove o observador da lista
    }

    //método para notificar todos os observadores sobre um evento ou mudança
    //parâmetro mensagem: uma string que descreve o evento ou mudança
    public void notifyObservers(String mensagem) {
        //itera por todos os observadores na lista
    	for (Observer observer : observers) {
            observer.update(mensagem);//chama o método update de cada observador
        }
    }
}
