package br.com.grupo.trabalho.single;

import java.time.LocalTime;
import java.util.Objects;
import java.util.Scanner;

import br.com.grupo.trabalho.Professor;
import br.com.grupo.trabalho.fact.IniciarCurso;

public class GerenciadorDeAulas {
	Scanner scanner = new Scanner(System.in);

    private static GerenciadorDeAulas instancia;

    private GerenciadorDeAulas() {
        
    }

    public static synchronized GerenciadorDeAulas getInstance() {
        if (instancia == null) {
            instancia = new GerenciadorDeAulas();
        }
        return instancia;
    }

    public boolean validarHorarioAula(int totalProf, IniciarCurso[] cursos, int indice, Professor professores) {
    	boolean validacao;
    	String diaAula;
    	LocalTime horarioTemp;
    	int contConflitos, hora, minuto, segundo;
		do {
			System.out.print("\nInforme o dia da semana que deseja marcar a aula(Ex: Segunda-feira): ");
			diaAula = scanner.nextLine();
			validacao = cursos[indice].setDiaAula(diaAula);
		} while(validacao == false);
		do {
			contConflitos = 0;
			do {
				System.out.print("Informe o horário da aula(Ex: hh mm ss): ");
				hora = scanner.nextInt();
		        minuto = scanner.nextInt(); 
		        segundo = scanner.nextInt();
		        scanner.nextLine();
		        if((hora < 0) || (hora > 23) || (minuto < 0) || (minuto > 59) || (segundo < 0) || (segundo > 59)) {
					System.out.println("Horário inválido.");
					horarioTemp = LocalTime.of(00, 00, 00);
					validacao = false;
				} else {
					horarioTemp = LocalTime.of(hora, minuto, segundo);
					validacao = true;
				}
			} while(validacao == false);
			
			for(int i = 0; i < totalProf + 1; i++) {
				if(Objects.equals(diaAula, cursos[i].getDiaAula())) {
					if(cursos[i].getHorarioAula().equals(horarioTemp)) {
						contConflitos++;
					}
				}
			}
			
			if(contConflitos != 0) {
				System.out.println("\nConflito: Já existe uma aula agendada para " + diaAula + " às " + horarioTemp + "h.\n");
			} 
		} while(contConflitos != 0);
		
		cursos[indice].setHorarioAula(hora, minuto, segundo);
		validacao = professores.agendarAula(cursos[indice]);
		
		return validacao;
    }
    
}