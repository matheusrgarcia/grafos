package br.com.unifacs.basico;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("*************** MENU ***************");

		Scanner entradas = new Scanner(System.in);

		int tipo = 0;

		System.out.println("1 - Grafo Nao Ponderado \n" + "2 - Grafo Ponderado \n" + "3 - Grafo Dirigido \n"
				+ "4 - Criar grafo e Gerar Matriz de Acessibiidade R \n" + "5 - Criar grafo e Encontrar Caminho Minimo \n"
				+ "0 - Sair \n");

		System.out.println("Digite a opcao desejada: ");
		tipo = entradas.nextInt();

		while (tipo < 0 || tipo > 5) {
			System.out.println("Opcao invalida. Digite a opcao desejada: ");
			tipo = entradas.nextInt();
		}

		if (tipo != 0) {

			int qtdVertices = 0, peso = 0;

			// Pega a quantidade de vertices

			System.out.println("Digite a quantidade de vertices: ");
			qtdVertices = entradas.nextInt();

			// tem que ter pelo menos um vertice para gerar o grafo
			while (qtdVertices < 1) {
				System.out.println("Valor invalido. Digite a quantidade de vertices: ");
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

						System.out
								.println("1 - Verificar Ordem do grafo \n" + "2 - Verificar existencia de Aresta entre dois vertices \n"
										+ "3 - Inserir/Remover vertice \n" + "4 - Inserir/Remover aresta \n"
										+ "5 - Obter vertices adjacentes \n" + "6 - Obter grau de determinado vertice \n"
										+ "7 - Obter grau minimo, medio ou maximo \n" + "8 - Verificar se o grafo e Conexo \n"
										+ "9 - Obter matriz de adjacencia \n" + "10 - Verificar se existe um Caminho de Euler no grafo\n"
										+ "11 - Verificar vertice com maior componente\n" + "12 - Verificar componentes conectados\n"
										+ "0 - Sair");

						System.out.println("\n");

						if (opcao < 0 || opcao > 12) {
							System.out.println("Opcao invalida. Digite a opcao desejada: ");
							opcao = entradas.nextInt();
						} else {
							System.out.println("Digite a opcao desejada: ");
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
							System.out.println("Valor invalido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}

						break;

					case 2:
						System.out.println("\n");

						System.out.println("********** Verificar existencia de Aresta entre dois vertices **********");

						// Pega valor do 1� vertice
						System.out.println("Digite o 1� v�rtice: ");
						v1 = entradas.nextInt();

						// Testa se 1� vertice existe
						while (v1 < 0 || v1 > (qtdVertices - 1)) {
							System.out.println("Valor invalido. Digite o 1� vertice: ");
							v1 = entradas.nextInt();
						}

						// Pega valor do 2� vertice
						System.out.println("Digite o 2� vertice: ");
						v2 = entradas.nextInt();

						// Testa se 2� vertice existe
						while (v2 < 0 || v2 > (qtdVertices - 1)) {
							System.out.println("Valor invalido. Digite o 2� vertice: ");
							v2 = entradas.nextInt();
						}

						if (Grafo.existeAresta(v1, v2)) {
							System.out.println("-> Existe aresta entre os vertices!");
						} else {
							System.out.println("-> Nao existe aresta entre os vertices!");
						}

						// visualizar grafo
						// Grafo.imprime();

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor invalido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}

						break;

					case 3:
						int opcaoCase = 0;
						// v = 0;

						System.out.println("\n");

						System.out.println("********** Inserir/Remover Vertice **********");

						System.out.println("1 - Inserir vertice");
						System.out.println("2 - Remover vertice");
						System.out.println("0 - Sair");

						System.out.println("Digite a opcao desejada: ");
						opcaoCase = entradas.nextInt();

						while (opcaoCase < 0 || opcaoCase > 2) {
							System.out.println("Opcao invalida. Digite a opcao desejada: ");
							opcaoCase = entradas.nextInt();
						}

						switch (opcaoCase) {
						case 1:
							System.out.println("********** INSERIR vertice **********");
							System.out.println("Digite quantidade de vertice a ser inserido: ");
							v = entradas.nextInt();

							while (v < 1) {
								System.out.println("Valor invalido. Digite quantidade de vertice a ser inserido: ");
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
								System.out.println("Valor invalido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
								menu = entradas.nextInt();
							}

							break;

						case 2:
							System.out.println("********** REMOVER vertice **********");
							System.out.println("Digite o vertice a ser removido:");
							v = entradas.nextInt();

							while ((v < 0) || (v > (qtdVertices - 1))) {
								System.out.println("Valor invalido. Digite o vertice a ser removido:");
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
								System.out.println("Valor invalido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
								menu = entradas.nextInt();
							}

							break;

						case 0:
							// sair
							menu = 0;
							break;
						}

						break;

					case 4:
						System.out.println("\n");

						System.out.println("********** Inserir/Remover Aresta **********");

						System.out.println("1 - Inserir aresta");
						System.out.println("2 - Remover aresta");
						System.out.println("0 - Sair");

						System.out.println("Digite a opcao desejada: ");
						opcaoCase = entradas.nextInt();

						// Testa se opcao e valida
						while (opcaoCase < 0 || opcaoCase > 2) {
							System.out.println("Opcao invalida. Digite a opcao desejada: ");
							opcaoCase = entradas.nextInt();
						}

						switch (opcaoCase) {
						case 1:
							System.out.println("********** INSERIR aresta **********");

							// Obtendo 1� vertice
							System.out.println("Digite o 1� vertice: ");
							v1 = entradas.nextInt();

							// Verifica se 1� vertice existe
							while (v1 < 0 || v1 > (qtdVertices - 1)) {
								System.out.println("Valor Invalido. Digite o 1� vertice: ");
								v1 = entradas.nextInt();
							}

							// Obtendo 2� vertice
							System.out.println("Digite o 2� vertice: ");
							v2 = entradas.nextInt();

							// Verifica se 2� vertice existe
							while (v2 < 0 || v2 > (qtdVertices - 1)) {
								System.out.println("Valor Invalido. Digite o 2� vertice: ");
								v2 = entradas.nextInt();
							}

							System.out.println("\n");

							Grafo.insereAresta(v1, v2);

							// visualiza grafo
							Grafo.imprime();

							System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();

							while (menu < 0 || menu > 1) {
								System.out.println("Valor invalido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
								menu = entradas.nextInt();
							}

							break;

						case 2:
							System.out.println("********** REMOVER aresta **********");

							// Obtendo 1� vertice
							System.out.println("Digite o 1� vertice: ");
							v1 = entradas.nextInt();

							// Verifica se 1� vertice existe
							while (v1 < 0 || v1 > (qtdVertices - 1)) {
								System.out.println("Valor Invalido. Digite o 1� vertice: ");
								v1 = entradas.nextInt();
							}

							// Obtendo 2� vertice
							System.out.println("Digite o 2� vertice: ");
							v2 = entradas.nextInt();

							// Verifica se 2� vertice existe
							while (v2 < 0 || v2 > (qtdVertices - 1)) {
								System.out.println("Valor Invalido. Digite o 2� vertice: ");
								v2 = entradas.nextInt();
							}

							if (Grafo.removeAresta(v1, v2) == true) {
								System.out.println("-> Aresta removida entre os vertices " + v1 + " e " + v2);
							} else {
								System.out.println("-> Nao existe aresta entre os vertices!");
							}

							// visualiza grafo
							Grafo.imprime();

							System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();

							while (menu < 0 || menu > 1) {
								System.out.println("Valor invalido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
								menu = entradas.nextInt();
							}
							break;

						case 0:
							// sair
							menu = 0;
							break;
						}

						break;

					case 5:
						// v = 0;

						System.out.println("\n");

						System.out.println("********** Obter Vertices Adjacentes **********");

						// visualiza grafo
						// Grafo.imprime();

						System.out.println("Digite o vertice:");
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

						System.out.println("********** Obter Grau de Determinado Vertice **********");

						System.out.println("Digite o vertice:");
						v = entradas.nextInt();

						while (v < 0 || v > (qtdVertices - 1)) {
							System.out.println("Valor Invalido. Digite o vertice:");
							v = entradas.nextInt();
						}

						System.out.println("-> Grau do vertice " + v + " = " + Grafo.grauVertice(v));

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor invalido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}

						break;

					case 7:
						// v = 0;

						System.out.println("\n");

						System.out.println("********** Obter Grau Minimo, Medio e Maximo do Grafo **********");

						Grafo.grauM3();

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor invalido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
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
							System.out.println("-> O grafo e conexo!");
						} else {
							System.out.println("-> O grafo nao e conexo!");
						}

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor invalido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
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
							System.out.println("Valor invalido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
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
							System.out.println("Valor invalido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}
						break;

					case 11:
						System.out.println("\n");
						System.out.println("********** Verificar vertice de maior componente **********");

						Grafo.maiorComponente();

						System.out.println("\nDigite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
						menu = entradas.nextInt();

						while (menu < 0 || menu > 1) {
							System.out.println("Valor invalido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
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
							System.out.println("Valor invalido. Digite: \n" + "1 - Para voltar ao menu \n" + "0 - Sair");
							menu = entradas.nextInt();
						}
						break;
					case 0:
						menu = 0;
						break;
					}
				}

				System.out.println("\nFIM!");

			}
		} else {

			System.out.println("\nFIM!");
		}
	}
}
