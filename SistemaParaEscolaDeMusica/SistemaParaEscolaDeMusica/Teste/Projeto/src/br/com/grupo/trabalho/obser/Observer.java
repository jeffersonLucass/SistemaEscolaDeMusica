package br.com.grupo.trabalho.obser;

    //declaração da interface
    public interface Observer {
        //método abstrato que será implementado por todas as classes que quiserem ser observadores
            void update(String mensagem);
    }
