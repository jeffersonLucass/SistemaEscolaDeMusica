
package br.com.grupo.trabalho.main;

import java.util.Objects;
import java.util.Scanner;

import br.com.grupo.trabalho.Aluno;
import br.com.grupo.trabalho.Professor;
import br.com.grupo.trabalho.fact.*;
import br.com.grupo.trabalho.obser.*;
import br.com.grupo.trabalho.single.GerenciadorDeAulas;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		CursoFactory cursoFactory = new CursoFactory();
		IniciarCurso[] cursos = new IniciarCurso[3];
		
		GerenciadorDeAulas gerenciador = GerenciadorDeAulas.getInstance();

		Aluno[] alunos = new Aluno[5];
		alunos[0] = new Aluno("Daniela", 21, "Sudoeste", 23102478);
		alunos[1] = new Aluno("Jesus", 19, "Águas Claras", 12345678);
		alunos[2] = new Aluno("Júlia", 19, "Vicente Pires", 23456789);
		alunos[3] = new Aluno("Jefferson", 19, "Não Sei", 23456780);
		alunos[4] = new Aluno("Gustavo", 19, "Não Sei", 23456781);

		Professor[] professores = new Professor[3];

		Sujeito sujeito = new Sujeito();

		for (int i = 0; i < alunos.length; i++) {
			sujeito.addObserver(alunos[i]);
		}

		int op, contC = 0, contTM = 0, contP = 0, totalProf = -1;
		for(int i = 0; i < 5; i++) {
			do {
				op = alunos[i].inscreverCurso();
				switch(op) {
					case 1:
						if(contC == 0) {
							totalProf++;
							professores[totalProf] = new Professor("Beatriz", 35, "Taguatinga", "Canto");
							cursos[totalProf] = cursoFactory.criarCurso(1, null, 00, 00, 00);
							contC++;
						}
						break;
					case 2:
						if(contTM == 0) {
							totalProf++;
							professores[totalProf] = new Professor("Hially", 35, "Taguatinga", "Teoria Musical");
							cursos[totalProf] = cursoFactory.criarCurso(2, null, 00, 00, 00);
							contTM++;
						}
						break;
					case 3:
						if(contP == 0) {
							totalProf++;
							professores[totalProf] = new Professor("Júlio", 35, "Taguatinga", "Piano");
							cursos[totalProf] = cursoFactory.criarCurso(3, null, 00, 00, 00);
							contP++;
						}
						break;
				}
				if(cursos[totalProf] != null) {
					System.out.println("O(a) aluno(a) " + alunos[i].getNome() + " se inscreveu no curso de " + alunos[i].getCursoInscrito() + ".\n");
				}
			} while((op < 1) || (op > 3));
		}

		int sistema, categoria = 4, alteracao = 4, matricula;
		String aula;
		boolean validacao = false;
		do {
			System.out.println("\nBem-vindo(a)! Deseja utilizar o sistema? ");
			System.out.println("1 - Sim \n2 - Não ");
			System.out.print("Informe a opção desejada: ");
			sistema = scanner.nextInt();
			scanner.nextLine();
			switch(sistema) {
				case 1:
					do {
						System.out.println("\nInforme sua categoria:");
						System.out.println("1 - Professor \n2 - Aluno \n3 - Vizualizar informações sobre o(s) curso(s) \n4 - Voltar");
						System.out.print("Informe a opção desejada: ");
						categoria = scanner.nextInt();
						scanner.nextLine();
						switch(categoria) {
							case 1:
								do {
									System.out.println("\nProfessores: Possíveis Alterações:");
									System.out.println("1 - Agendar Aula \n2 - Cancelar Aula \n3 - Voltar");
									System.out.print("Informe a opção desejada: ");
									alteracao = scanner.nextInt();
									scanner.nextLine();
									switch(alteracao) {
										case 1:
											System.out.print("Informe a aula que leciona: ");
											aula = scanner.nextLine();
											for(int i = 0; i < totalProf + 1; i++) {
												if(professores[i].getCursoLecionado().equalsIgnoreCase(aula)) {
													System.out.print("\nOlá, Professor(a) " + professores[i].getNome() + ".");
													validacao = gerenciador.validarHorarioAula(totalProf, cursos, i, professores[i]);
													if(validacao) {
														sujeito.notifyObservers("A aula de " + aula + " foi agendada!");
													}
												}
											}
											if(!validacao) {
												System.out.println("\nVoltando ao menu anterior.");
											}
											break;
										case 2:
											System.out.print("Informe a aula que leciona: ");
											aula = scanner.nextLine();
											for(int i = 0; i < totalProf + 1; i++) {
												if(professores[i].getCursoLecionado().equalsIgnoreCase(aula)) {
													System.out.print("\nOlá, Professor(a) " + professores[i].getNome() + ".");
													validacao = professores[i].cancelarAula(cursos[i]);
													if(validacao) {
														sujeito.notifyObservers("A aula de " + aula + " foi cancelada.");
													}
												}
											}
											if(validacao == false) {
												System.out.println("\nVoltando ao menu anterior.");
											}
											break;
										case 3:
											break;
										default:
											System.out.println("Opção inválida.");
											break;
									}
								} while(alteracao != 3);
								break;
							case 2:
								do {
									System.out.println("\nAlunos: Possíveis Alterações:");
									System.out.println("1 - Agendar Aula \n2 - Cancelar Aula \n3 - Voltar");
									System.out.print("Informe a opção desejada: ");
									alteracao = scanner.nextInt();
									scanner.nextLine();
									switch(alteracao) {
										case 1:
											System.out.print("Informe sua matrícula: ");
											matricula = scanner.nextInt();
											for(int i = 0; i < 5; i++) {
												if(alunos[i].getMatricula() == matricula) {
													System.out.print("\nOlá, " + alunos[i].getNome() + ".");
													for(int j = 0; j < totalProf + 1; j++) {
														if(Objects.equals(alunos[i].getCursoInscrito(), professores[j].getCursoLecionado())) {
															if(cursos[j].getDiaAula() != null) {
																System.out.print(" O(a) professor(a) " + professores[j].getNome() + " marcou a aula para ");
																validacao = alunos[i].agendarAula(cursos[j]);
															} else {
																System.out.print(" O(a) professor(a) " + professores[j].getNome() + " ainda não marcou uma aula.");
															}
														}
													}
												}
											}
											if(validacao == false) {
												System.out.println("\nVoltando ao menu anterior.");
											}
											break;
										case 2:
											System.out.print("Informe sua matrícula: ");
											matricula = scanner.nextInt();
											for(int i = 0; i < 5; i++) {
												if(alunos[i].getMatricula() == matricula) {
													System.out.print("\nOlá, " + alunos[i].getNome() + ".");
													for(int j = 0; j < totalProf + 1; j++) {
														if(Objects.equals(alunos[i].getCursoInscrito(), professores[j].getCursoLecionado())) {
															if(cursos[j].getDiaAula() != null) {
																if(alunos[i].getPresenca() == false) {
																	System.out.println(" Sua aula já está desagendada.");
																} else {
																	System.out.print(" O(a) professor(a) " + professores[j].getNome() + " marcou uma aula para ");
																	validacao = alunos[i].cancelarAula(cursos[j]);
																}
															} else {
																System.out.print(" O(a) professor(a) " + professores[j].getNome() + " ainda não marcou uma aula.");
															}
														}
													}
												}
											}
											if(validacao == false) {
												System.out.println("\nVoltando ao menu anterior.");
											}
											break;
										case 3:
											break;
										default:
											System.out.println("Opção inválida.");
											break;
									}
								} while(alteracao != 3);
								break;
							case 3:
								System.out.println("\nCurso(s):\n");
								for(int i = 0; i < totalProf + 1; i++) {
									System.out.println("Nome: " + cursos[i].getNome());
									if(cursos[i].getDiaAula() == null) {
										System.out.println("Data: À marcar");
									} else {
										System.out.println("Data: " + cursos[i].getDiaAula() + " às " + cursos[i].getHorarioAula() + "h");
									}
									System.out.println("Professor: " + professores[i].getNome());
									System.out.println("Alunos inscritos: ");
									for(int j = 0; j < 5; j++) {
										if(Objects.equals(alunos[j].getCursoInscrito(),cursos[i].getNome())) {
											System.out.print("+ " + alunos[j].getNome() + " - ");
											if(alunos[j].getPresenca() == true) {
												System.out.println("Aula agendada.");
											} else {
												System.out.println("Aula desagendada.");
											}
										}
									}
									System.out.println("");
								}
								break;
							case 4:
								break;
							default:
								System.out.println("Opção inválida.");
								break;
						}
					} while(categoria != 4);
					break;
				case 2:
					System.out.println("\nEncerrando sistema. Até a próxima.\n");
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
		} while(sistema != 2);

		scanner.close();
	}
}