package br.com.grupo.trabalho;

import java.util.Scanner;//utilizado para capturar entradas do usuário

import br.com.grupo.trabalho.fact.IniciarCurso;//interface para cursos
import br.com.grupo.trabalho.inter.Agendavel;//interface para agendamento de aulas
import br.com.grupo.trabalho.obser.Observer;//interface para implementação do padrão Observer

//classe Aluno
//representa um aluno no sistema e implementa as interfaces Observer e Agendavel
public class Aluno extends Pessoa implements Observer, Agendavel {
	//scanner para capturar entradas do usuário
	Scanner scanner = new Scanner(System.in);

	//atributos específicos do aluno
	private int matricula;
	private String cursoInscrito;
	private boolean presenca = false;

	//construtor da classe Aluno
	public Aluno(String nome, int idade, String endereco, int matricula) {
		super(nome, idade, endereco);
		this.matricula = matricula;
	}

	//implementação do método update da interface Observer
	@Override
	public void update(String mensagem) {
		// Verifica se a mensagem contém o curso no qual o aluno está inscrito
		if (mensagem.contains(cursoInscrito)) {
			System.out.println(getNome() + " foi notificado pois: " + mensagem);
		} //notifica o aluno sobre um evento ou mudança no sistema
	}


	//métodos getters e setters
	public int getMatricula() {
		return matricula;
	}
	@@ -43,16 +50,20 @@ public boolean getPresenca() {
		return presenca;
	}

	//método para inscrever o aluno em um curso
	public int inscreverCurso() {
		int op;//armazena a opção escolhida pelo aluno
		do {
			//exibe as opções de cursos disponíveis
			System.out.println("\nOlá, " + getNome() + ". Em qual curso deseja se inscrever: ");
			System.out.println("1 - Canto");
			System.out.println("2 - Teoria Musical");
			System.out.println("3 - Piano");
			System.out.print("Informe a opção desejada: ");
			op = scanner.nextInt();//lê a opção escolhida
			scanner.nextLine();//limpa o buffer do scanner
			// Define o curso com base na escolha
			switch (op) {
				case 1:
					cursoInscrito = "Canto";
					@ @ -70, 58 + 81, 61 @@public int inscreverCurso () {
				}
				while ((op < 1) && (op > 3)) ;
				return op;
			}
			//implementação do método agendarAula da interface Agendavel
			@Override
			public boolean agendarAula (IniciarCurso cursos){
				int op;//armazena a opção escolhida
				//exibe as informações da aula
				System.out.print(cursos.getDiaAula() + " às " + cursos.getHorarioAula() + "h. ");
				do {
					//solicita a confirmação do agendamento
					System.out.println("Deseja agendar aula para esse dia? ");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					System.out.print("Informe a opção desejada: ");
					op = scanner.nextInt();
					switch (op) {
						case 1://marca a presença do aluno
							presenca = true;
							System.out.println("\nAula agendada.");
							break;
						case 2://não marca a presença do aluno
							presenca = false;
							System.out.println("\nAula não agendada.");
							break;
						default:
							System.out.println("\nOpção inválida.");
							break;
					}
				} while ((op < 1) || (op > 2));//repete enquanto a opção for inválida
				return true;
			}
			//implementação do método cancelarAula da interface Agendavel
			@Override
			public boolean cancelarAula (IniciarCurso cursos){
				int op;
				System.out.println(cursos.getDiaAula() + " às " + cursos.getHorarioAula() + "h e o(a) senhor(a) agendou uma aula para esse dia.");
				do {
					//solicita a confirmação do cancelamento
					System.out.println("Deseja desagendar a aula desse dia? ");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					System.out.print("Informe a opção desejada: ");
					op = scanner.nextInt();
					switch (op) {
						case 1://remove a presença do aluno
							presenca = true;
							System.out.println("\nAula desagendada.");
							break;
						case 2://mantém a presença do aluno
							presenca = false;
							System.out.println("\nAula não desagendada.");
							break;
						default:
							System.out.println("\nOpção inválida.");
							break;
					}
				} while ((op < 1) || (op > 2));//repete enquanto a opção for inválida
				return true;
			}