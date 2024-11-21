package br.com.grupo.trabalho.single;
//importações necessárias
import java.time.LocalTime;//representa horários (hora, minuto, segundo)
import java.util.Objects;//utilizado para comparações seguras de objetos
import java.util.Scanner;//captura entradas do usuário

import br.com.grupo.trabalho.Professor;
import br.com.grupo.trabalho.fact.IniciarCurso;

//classe GerenciadorDeAulas
//implementa o padrão Singleton para garantir que apenas uma instância gerencie aulas
public class GerenciadorDeAulas {
	//scanner para capturar entradas do usuário
	Scanner scanner = new Scanner(System.in);

	//atributo estático para armazenar a única instância da classe
    private static GerenciadorDeAulas instancia;

	//construtor privado
	//impede que outras classes criem instâncias diretamente
    private GerenciadorDeAulas() {
        
    }
	//método público estático para obter a única instância da classe
    public static synchronized GerenciadorDeAulas getInstance() {
		//cria a instância apenas se ela não existir
        if (instancia == null) {
            instancia = new GerenciadorDeAulas();
        }
        return instancia;//retorna a instância
    }
	//método para validar e agendar o horário de uma aula
    public boolean validarHorarioAula(int totalProf, IniciarCurso[] cursos, int indice, Professor professores) {
    	boolean validacao;
    	String diaAula;
    	LocalTime horarioTemp;
    	int contConflitos, hora, minuto, segundo;
		//loop para capturar e validar o dia da semana
		do {
			System.out.print("\nInforme o dia da semana que deseja marcar a aula(Ex: Segunda-feira): ");
			diaAula = scanner.nextLine();//captura o dia informado pelo usuário
			validacao = cursos[indice].setDiaAula(diaAula);//define o dia no curso e verifica a validade
		} while(validacao == false);//repete até que o dia seja válido
		//loop para capturar e validar o horário
		do {
			contConflitos = 0;//reseta o contador de conflitos
			do {
				System.out.print("Informe o horário da aula(Ex: hh mm ss): ");
				hora = scanner.nextInt();//captura a hora
		        minuto = scanner.nextInt();//captura o minuto
		        segundo = scanner.nextInt();//captura o segundo
		        scanner.nextLine();//limpa o buffer do scanner

				//valida se o horário está dentro do intervalo permitido
		        if((hora < 0) || (hora > 23) || (minuto < 0) || (minuto > 59) || (segundo < 0) || (segundo > 59)) {
					System.out.println("Horário inválido.");
					horarioTemp = LocalTime.of(00, 00, 00);//define um horário padrão inválido
					validacao = false;
				} else {
					horarioTemp = LocalTime.of(hora, minuto, segundo);//cria o horário válido
					validacao = true;
				}
			} while(validacao == false);//repete até que o horário seja válido

			// Verifica conflitos com outros cursos no mesmo horário e dia
			for(int i = 0; i < totalProf + 1; i++) {
				if(Objects.equals(diaAula, cursos[i].getDiaAula())) {//compara o dia da aula
					if(cursos[i].getHorarioAula().equals(horarioTemp)) {//compara o horário
						contConflitos++;//incrementa o contador de conflitos
					}
				}
			}
			//exibe mensagem de conflito, se houver
			if(contConflitos != 0) {
				System.out.println("\nConflito: Já existe uma aula agendada para " + diaAula + " às " + horarioTemp + "h.\n");
			} 
		} while(contConflitos != 0);//repete até que não haja conflitos

		//define o horário no curso e tenta agendar a aula com o professor
		cursos[indice].setHorarioAula(hora, minuto, segundo);//define o horário da aula no curso
		validacao = professores.agendarAula(cursos[indice]);//tenta agendar a aula com o professor
		
		return validacao;//retorna o resultado da validação
    }
    
}