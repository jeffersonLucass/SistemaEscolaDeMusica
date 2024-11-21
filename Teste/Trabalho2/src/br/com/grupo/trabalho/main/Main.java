
package br.com.grupo.trabalho.main;

//importações necessárias para o funcionamento do programa
import java.util.Objects;//usado para comparar objetos
import java.util.Scanner;//usado para capturar entradas do usuário

//importação das classes
import br.com.grupo.trabalho.Aluno;
import br.com.grupo.trabalho.Professor;
import br.com.grupo.trabalho.fact.*;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);//cria um objeto Scanner para capturar entradas

		//criação do factory para instanciar cursos
		CursoFactory cursoFactory = new CursoFactory();
		//array para armazenar os cursos disponíveis
		IniciarCurso[] cursos = new IniciarCurso[3];
		//instância única do gerenciador de aulas (singleton)
		GerenciadorDeAulas gerenciador = GerenciadorDeAulas.getInstance();

		//array para armazenar alunos cadastrados
		Aluno[] alunos = new Aluno[5];
		alunos[0] = new Aluno("Daniela", 21, "Sudoeste", 23102478);
		alunos[1] = new Aluno("Jesus", 19, "Águas Claras", 12345678);
		alunos[2] = new Aluno("Júlia", 19, "Vicente Pires", 23456789);
		alunos[3] = new Aluno("Jefferson", 19, "Não Sei", 23456780);
		alunos[4] = new Aluno("Gustavo", 19, "Não Sei", 23456781);

		//array para armazenar os professores
		Professor[] professores = new Professor[3];

		//instância do sujeito para gerenciar notificações (observer pattern)
		Sujeito sujeito = new Sujeito();

		//adiciona todos os alunos como observadores
		for (int i = 0; i < alunos.length; i++) {
			sujeito.addObserver(alunos[i]);
		}

		//inicializa contadores e variáveis para controle de fluxo
		int op, contC = 0, contTM = 0, contP = 0, totalProf = -1;
		//loop para os alunos se inscreverem em cursos
		for(int i = 0; i < 5; i++) {
			do {
				op = alunos[i].inscreverCurso();//aluno escolhe um curso
				switch(op) {
					case 1: //curso de canto
						if (contC == 0) { //verifica se o curso já foi criado
							totalProf++;
							professores[totalProf] = new Professor("Beatriz", 35, "Taguatinga", "Canto");
							cursos[totalProf] = cursoFactory.criarCurso(1, null, 00, 00, 00);
							contC++;
						}
						professores[0].adicionarAlunoInscrito(alunos[i], "Canto"); // Inscreve aluno no curso de Canto
						break;

					case 2: //curso de teoria musical
						if (contTM == 0) {
							totalProf++;
							professores[totalProf] = new Professor("Hially", 35, "Taguatinga", "Teoria Musical");
							cursos[totalProf] = cursoFactory.criarCurso(2, null, 00, 00, 00);
							contTM++;
						}
						professores[1].adicionarAlunoInscrito(alunos[i], "Teoria Musical"); // Inscreve aluno no curso de Teoria Musical
						break;

					case 3: //curso de piano
						if (contP == 0) {
							totalProf++;
							professores[totalProf] = new Professor("Júlio", 35, "Taguatinga", "Piano");
							cursos[totalProf] = cursoFactory.criarCurso(3, null, 00, 00, 00);
							contP++;
						}
						professores[2].adicionarAlunoInscrito(alunos[i], "Piano"); // Inscreve aluno no curso de Piano
						break;
				}
				if(cursos[totalProf] != null) {
					System.out.println("O(a) aluno(a) " + alunos[i].getNome() + " se inscreveu no curso de " + alunos[i].getCursoInscrito() + ".\n");
				}
			} while((op < 1) || (op > 3)); //repete enquanto a opção for inválida
		}
//variáveis de controle do menu principal
		int sistema, categoria = 4, alteracao = 4, matricula;
		String aula;
		boolean validacao = false;
		//menu principal
		do {
			System.out.println("\nBem-vindo(a)! Deseja utilizar o sistema? ");
			System.out.println("1 - Sim \n2 - Não ");
			System.out.print("Informe a opção desejada: ");
			sistema = scanner.nextInt();
			scanner.nextLine();
			switch(sistema) {
				case 1://usuário decide utilizar o sistema
					do {
						System.out.println("\nInforme sua categoria:");
						System.out.println("1 - Professor \n2 - Aluno \n3 - Vizualizar informações sobre o(s) curso(s) \n4 - Voltar");
						System.out.print("Informe a opção desejada: ");
						categoria = scanner.nextInt();
						scanner.nextLine();
						switch(categoria) {
							case 1://menu do professor
								do {
									System.out.println("\nProfessores: Possíveis Alterações:");
									System.out.println("1 - Agendar Aula \n2 - Cancelar Aula \n3 - Voltar");
									System.out.print("Informe a opção desejada: ");
									alteracao = scanner.nextInt();
									scanner.nextLine();
									switch(alteracao) {
										case 1://agendar aula
											System.out.print("Informe a aula que leciona: ");
											aula = scanner.nextLine();
											for(int i = 0; i < totalProf + 1; i++) {
											public static void main(String[] args) {
													System.out.println("\nVoltando ao menu anterior.");
												}
												break;
												case 2://cancelar aula (professor)
													System.out.print("Informe a aula que leciona: ");
													aula = scanner.nextLine();
													for(int i = 0; i < totalProf + 1; i++) {
													public static void main(String[] args) {
														}
													}
											}
											//se nenhuma aula for cancelada
											if(validacao == false) {
												System.out.println("\nVoltando ao menu anterior.");
											}
											public static void main(String[] args) {
											System.out.println("Opção inválida.");
											break;
										}
									} while(alteracao != 3);//continua o loop até que o usuário escolha a opção 3
									break;
									case 2://menu para alunos
										do {
											//exibe as opções disponíveis para os alunos
											System.out.println("\nAlunos: Possíveis Alterações:");
											System.out.println("1 - Agendar Aula \n2 - Cancelar Aula \n3 - Voltar");
											System.out.print("Informe a opção desejada: ");
											alteracao = scanner.nextInt();//captura a opção escolhida pelo aluno
											scanner.nextLine();//limpa o buffer do scanner
											switch(alteracao) {
												case 1://agendar aula
													System.out.print("Informe sua matrícula: ");
													matricula = scanner.nextInt();
													//itera por todos os alunos cadastrados
													for(int i = 0; i < 5; i++) {
														if(alunos[i].getMatricula() == matricula) {
															System.out.print("\nOlá, " + alunos[i].getNome() + ".");
															//itera pelos professores para verificar o curso inscrito pelo aluno
															for(int j = 0; j < totalProf + 1; j++) {
																if(Objects.equals(alunos[i].getCursoInscrito(), professores[j].getCursoLecionado())) {
																	if(cursos[j].getDiaAula() != null) {
																	public static void main(String[] args) {
																		}
																	}
																}
																//se o agendamento falhou
																if(validacao == false) {
																	System.out.println("\nVoltando ao menu anterior.");
																}
																break;
																case 2://cancelar aula
																	System.out.print("Informe sua matrícula: ");
																	matricula = scanner.nextInt();
																	for(int i = 0; i < 5; i++) {
																	public static void main(String[] args) {
																		}
																	}
															}
															//se o cancelamento falhou
															if(validacao == false) {
																System.out.println("\nVoltando ao menu anterior.");
															}
														public static void main(String[] args) {
																System.out.println("Opção inválida.");
																break;
															}
														} while(alteracao != 3);//continua o loop até que o usuário escolha a opção 3
														break;
														case 3://informações sobre os cursos
															System.out.println("\nCurso(s):\n");
															for(int i = 0; i < totalProf + 1; i++) {
																System.out.println("Nome: " + cursos[i].getNome());
															public static void main(String[] args) {
																}
															} while(categoria != 4);
															break;
														case 2://encerrar sistema
															System.out.println("\nEncerrando sistema. Até a próxima.\n");
															break;
														default:
														public static void main(String[] args) {
														}
													} while(sistema != 2);

													scanner.close();//fecha o scanner para liberar recursos
											}
										}