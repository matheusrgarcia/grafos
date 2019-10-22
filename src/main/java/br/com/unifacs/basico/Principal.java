package br.com.unifacs.basico;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("*************** MENU ***************");

		Scanner entradas = new Scanner(System.in);

		int tipo = 0;

		System.out.println("1 - Grafo Não Ponderado \n" + "2 - Grafo Ponderado \n" + "3 - Grafo Dirigido \n"
				+ "4 - Criar grafo e Gerar Matriz de Acessibiidade R \n" + "5 - Criar grafo e Encontrar Caminho Mínimo \n"
				+ "0 - Sair \n");

		System.out.println("Digite a opção desejada: ");
		tipo = entradas.nextInt();

		while (tipo < 0 || tipo > 5) {
			System.out.println("Opção invalida. Digite a opção desejada: ");
			tipo = entradas.nextInt();
		}

		if (tipo != 0) {

			int qtdVertices = 0;

			// Pega a quantidade de vértices

			System.out.println("Digite a quantidade de vértices: ");
			qtdVertices = entradas.nextInt();

			// tem que ter pelo menos um vertice para gerar o grafo
			while (qtdVertices < 1) {
				System.out.println("Valor inválido. Digite a quantidade de vértices: ");
				qtdVertices = entradas.nextInt();
			}

			System.out.println();

			Grafo Grafo = new Grafo(tipo, qtdVertices);

			if ((tipo != 4) && (tipo != 5)) {

				int menu = 1;

				while (menu == 1) {
					int opcao = 0;

					// Escolhe e testa a opcao desejada
					do {
						System.out.println("\n");

						System.out.println("********** MENU **********");

						System.out.println(
								"1 - Verificar Ordem do grafo \n" + "2 - Verificar a existência de uma Aresta entre dois vértices \n"
										+ "3 - Inserir/Remover Vértice \n" + "4 - Inserir/Remover Aresta \n"
										+ "5 - Obter Vértices adjacentes \n" + "6 - Obter grau de determinado vértice \n"
										+ "7 - Obter grau Mínimo, Médio ou Máximo \n" + "8 - Verificar se o grafo e Conexo \n"
										+ "9 - Obter matriz de adjacência \n" + "10 - Verificar se existe um Caminho de Euler no grafo\n"
										+ "11 - Verificar Vértice com maior componente\n" + "12 - Verificar componentes conectados\n"
										+ "0 - Sair");

						System.out.println("\n");

						if (opcao < 0 || opcao > 12) {
							System.out.println("Opção inválida. Digite a opção desejada: ");
							opcao = entradas.nextInt();
						} else {
							System.out.println("Digite a opção desejada: ");
							opcao = entradas.nextInt();
						}

					} while (opcao < 0 || opcao > 12);

					int v = 0, v1 = 0, v2 = 0;

					switch (opcao) {
					case 1:
						System.out.println("\n");

						System.out.println("********** Ordem do Grafo **********");

						System.out.println("-> " + Grafo.ordemGrafo());

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor inválido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}

						break;

					case 2:
						System.out.println("\n");

						System.out.println("********** Verificar existencia de Aresta entre dois vertices **********");

						// Pega valor do 1ª Vértice
						System.out.println("Digite o 1ª Vértice: ");
						v1 = entradas.nextInt();

						// Testa se 1ª Vértice existe
						while (v1 < 0 || v1 > (qtdVertices - 1)) {
							System.out.println("Valor inválido. Digite o 1ª Vértice: ");
							v1 = entradas.nextInt();
						}

						// Pega valor do 2ª vertice
						System.out.println("Digite o 2ª Vértice: ");
						v2 = entradas.nextInt();

						// Testa se 2ª vertice existe
						while (v2 < 0 || v2 > (qtdVertices - 1)) {
							System.out.println("Valor inválido. Digite o 2º Vértice: ");
							v2 = entradas.nextInt();
						}

						if (Grafo.existeAresta(v1, v2)) {
							System.out.println("-> Existe aresta entre os vértices!");
						} else {
							System.out.println("-> Não existe aresta entre os vértices!");
						}

						// visualizar grafo
						// Grafo.imprime();

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor inválido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}

						break;

					case 3:
						int opcaoCase = 0;
						// v = 0;

						System.out.println("\n");

						System.out.println("********** Inserir/Remover Vértice **********");

						System.out.println("1 - Inserir Vértice");
						System.out.println("2 - Remover Vértice");
						System.out.println("0 - Sair");

						System.out.println("Digite a opção desejada: ");
						opcaoCase = entradas.nextInt();

						while (opcaoCase < 0 || opcaoCase > 2) {
							System.out.println("Opção inválida. Digite a opção desejada: ");
							opcaoCase = entradas.nextInt();
						}

						switch (opcaoCase) {
						case 1:
							System.out.println("********** Inserir Vértice **********");
							System.out.println("Digite quantidade de vértices a ser inserido: ");
							v = entradas.nextInt();

							while (v < 1) {
								System.out.println("Valor inválido. Digite quantidade de vértice(s) a ser inserido: ");
								v = entradas.nextInt();
							}

							// imprime grafo anterior
							/*
							 * System.out.println("Grafo anterior: "); Grafo.imprime();
							 */

							System.out.println("\n");
							Grafo.insereVertice(v);

							// atualiza quantidade de vertices
							qtdVertices = Grafo.getQtdVertices();

							// imprime novo grafo
							System.out.println("Grafo atual: ");
							Grafo.imprime();

							System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();

							while (menu < 0 || menu > 1) {
								System.out.println("Valor inválido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
								menu = entradas.nextInt();
							}

							break;

						case 2:
							System.out.println("********** REMOVER Vértice **********");
							System.out.println("Digite o Vértice a ser removido:");
							v = entradas.nextInt();

							while ((v < 0) || (v > (qtdVertices - 1))) {
								System.out.println("Valor inválido. Digite o vértice a ser removido:");
								v = entradas.nextInt();
							}

							// imprime grafo anterior
							/*
							 * System.out.println("Grafo anterior: "); Grafo.imprime();
							 */

							Grafo.removeVertice(v);

							// atualiza quantidade de vertices
							qtdVertices = Grafo.getQtdVertices();

							// imprime novo grafo
							System.out.println("Grafo atual: ");
							Grafo.imprime();

							System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();

							while (menu < 0 || menu > 1) {
								System.out.println("Valor inválido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
								menu = entradas.nextInt();
							}

							break;

						case 0:
							// Sair
							menu = 0;
							System.out.println("\nPrograma Encerrado!");
							entradas.close();
							System.console().flush();
							System.exit(0);
							break;
						}

						break;

					case 4:
						System.out.println("\n");

						System.out.println("********** Inserir/Remover Aresta **********");

						System.out.println("1 - Inserir aresta");
						System.out.println("2 - Remover aresta");
						System.out.println("0 - Sair");

						System.out.println("Digite a opção desejada: ");
						opcaoCase = entradas.nextInt();

						// Testa se opcao e valida
						while (opcaoCase < 0 || opcaoCase > 2) {
							System.out.println("Opção invalida. Digite a opção desejada: ");
							opcaoCase = entradas.nextInt();
						}

						switch (opcaoCase) {
						case 1:
							System.out.println("********** INSERIR aresta **********");

							// Obtendo 1º vertice
							System.out.println("Digite o 1º vértice: ");
							v1 = entradas.nextInt();

							// Verifica se 1º vertice existe
							while (v1 < 0 || v1 > (qtdVertices - 1)) {
								System.out.println("Valor Inválido. Digite o 1º vértice: ");
								v1 = entradas.nextInt();
							}

							// Obtendo 2º vertice
							System.out.println("Digite o 2º vertice: ");
							v2 = entradas.nextInt();

							// Verifica se 2º vertice existe
							while (v2 < 0 || v2 > (qtdVertices - 1)) {
								System.out.println("Valor Inválido. Digite o 2º vértice: ");
								v2 = entradas.nextInt();
							}

							System.out.println("\n");

							Grafo.insereAresta(v1, v2);

							// visualiza grafo
							Grafo.imprime();

							System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();

							while (menu < 0 || menu > 1) {
								System.out.println("Valor inválido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
								menu = entradas.nextInt();
							}

							break;

						case 2:
							System.out.println("********** REMOVER aresta **********");

							// Obtendo 1º vertice
							System.out.println("Digite o 1º vértice: ");
							v1 = entradas.nextInt();

							// Verifica se 1º vertice existe
							while (v1 < 0 || v1 > (qtdVertices - 1)) {
								System.out.println("Valor Inválido. Digite o 1º vértice: ");
								v1 = entradas.nextInt();
							}

							// Obtendo 2º vertice
							System.out.println("Digite o 2º vértice: ");
							v2 = entradas.nextInt();

							// Verifica se 2º vertice existe
							while (v2 < 0 || v2 > (qtdVertices - 1)) {
								System.out.println("Valor Inválido. Digite o 2º vértice: ");
								v2 = entradas.nextInt();
							}

							if (Grafo.removeAresta(v1, v2) == true) {
								System.out.println("-> Aresta removida entre os vértices " + v1 + " e " + v2);
							} else {
								System.out.println("-> Não existe aresta entre os vértices!");
							}

							// visualiza grafo
							Grafo.imprime();

							System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();

							while (menu < 0 || menu > 1) {
								System.out.println("Valor inválido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
								menu = entradas.nextInt();
							}
							break;

						case 0:
							// Sair
							menu = 0;
							System.out.println("\nPrograma Encerrado!");
							entradas.close();
							System.exit(0);
							break;
						}

						break;

					case 5:
						// v = 0;

						System.out.println("\n");

						System.out.println("********** Obter Vértices Adjacentes **********");

						// visualiza grafo
						// Grafo.imprime();

						System.out.println("Digite o vértice:");
						v = entradas.nextInt();

						Grafo.verticeAdjacente(v);

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor invalido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}

						break;

					case 6:
						System.out.println("\n");

						System.out.println("********** Obter Grau de Determinado Vértice **********");

						System.out.println("Digite o vértice:");
						v = entradas.nextInt();

						while (v < 0 || v > (qtdVertices - 1)) {
							System.out.println("Valor Inválido. Digite o vértice:");
							v = entradas.nextInt();
						}

						System.out.println("-> Grau do vértice " + v + " = " + Grafo.grauVertice(v));

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor inválido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}

						break;

					case 7:
						// v = 0;

						System.out.println("\n");

						System.out.println("********** Obter Grau Mínimo, Médio e Máximo do Grafo **********");

						Grafo.grauM3();

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor inválido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}

						break;

					case 8:
						System.out.println("\n");

						System.out.println("********** Verificar se o Grafo e Conexo **********");

						// visualiza grafo
						// Grafo.imprime();

						System.out.println("\n");

						if (Grafo.grafoConexo() == true) {
							System.out.println("-> O grafo é conexo!");
						} else {
							System.out.println("-> O grafo não é conexo!");
						}

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor inválido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}

						break;

					case 9:
						System.out.println("\n");

						System.out.println("********** Matriz de Adjacencia **********");

						System.out.println("-> " + qtdVertices + " x " + qtdVertices);

						Grafo.imprime();

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor inválido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}

						break;

					case 10:
						System.out.println("\n");

						System.out.println("********** Verificar se Existe um Caminho de Euler **********");

						Grafo.caminhoEuler();

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor inválido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}
						break;

					case 11:
						System.out.println("\n");
						System.out.println("********** Verificar vértice de maior componente **********");

						Grafo.maiorComponente();

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor inválido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}
						break;
					case 12:
						System.out.println("\n");
						System.out.println("********** Verificar componentes conectados **********");

						Grafo.componentesConectados();

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor inválido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}
						break;
					case 0:
						// Sair
						menu = 0;
						System.out.println("\nPrograma Encerrado!");
						entradas.close();
						System.exit(0);
						break;
					}
				}
				System.out.println("\nFim de execução!");
			}
		} else {
			System.out.println("\nFim de execução!");
		}
	}

}
