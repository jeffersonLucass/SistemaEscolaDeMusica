package br.com.grupo.trabalho.fact;

import br.com.grupo.trabalho.*;

//declaração da classe
public class CursoFactory {
    //método público que cria e retorna um objeto
	public IniciarCurso criarCurso(int tipo, String diaAula, int hora, int minuto, int segundo){
        //verifica se o tipo do curso é 1 (canto)
        if (tipo == 1){
            //retorna um novo objeto do tipo canto
            return new Canto("Canto", diaAula, hora, minuto, segundo);
        //verifica se o tipo do curso é 2 (teoria musical)
        } else if (tipo == 2) {
            //retorna um novo objeto do tipo teoria musical
            return new TeoriaMusical("Teoria Musical", diaAula, hora, minuto, segundo);
        // verifica se o tipo do curso é 3 (piano)
        } else if (tipo == 3) {
            //retorna um novo objeto do tipo piano
            return new Piano("Piano", diaAula, hora, minuto, segundo);
        }
        return null;
    }
}