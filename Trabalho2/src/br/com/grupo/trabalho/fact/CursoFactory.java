package br.com.grupo.trabalho.fact;

import br.com.grupo.trabalho.*;

public class CursoFactory {
	public IniciarCurso criarCurso(int tipo, String diaAula, int hora, int minuto, int segundo){
        if (tipo == 1){
            return new Canto("Canto", diaAula, hora, minuto, segundo);
        } else if (tipo == 2) {
            return new TeoriaMusical("Teoria Musical", diaAula, hora, minuto, segundo);
        } else if (tipo == 3) {
            return new Piano("Piano", diaAula, hora, minuto, segundo);
        }
        return null;
    }
}