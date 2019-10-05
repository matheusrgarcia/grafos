package br.com.unifacs.basico;

import java.util.Scanner;

public class Grafo {
	private int matriz[][], matrizTemp[][], IN[], D[], S[];
	private int tipoGrafo;
	private int qtdVertices;
	boolean visitado;

	Scanner entradas = new Scanner(System.in);

	// Cria grafo
	public Grafo(int tipo, int qtdVertices) {

		this.tipoGrafo = tipo;
		this.qtdVertices = qtdVertices;
		this.matriz = new int[this.qtdVertices][this.qtdVertices];

		// cria grafo com 0 arestas
		for (int i = 0; i < this.qtdVertices; i++) {
			for (int j = 0; j < this.qtdVertices; j++) {
				this.matriz[i][j] = 0;
			}
		}

		if ((tipoGrafo != 4) && (tipoGrafo != 5)) {
			if (tipoGrafo == 1) {
				grafoNaoPonderado();
			}

			if (tipoGrafo == 2) {
				grafoPonderado();

			}

			if (tipoGrafo == 3) {
				grafoDirigido();
			}

			// Imprime grafo gerado
			imprime();
		} else {

			if (tipoGrafo == 4) {
				algoritmoWarshall();
			}

			if (tipoGrafo == 5) {
				caminhoMinimo();
			}

		}
	}

	public int getQtdVertices() {
		return this.qtdVertices;
	}

	// Tipo 1 - Gera grafo nao ponderado
	public void grafoNaoPonderado() {

		int temAresta = 0;

		for (int i = 0; i < this.qtdVertices; i++) {
			for (int j = 0; j < this.qtdVertices; j++) {

				System.out.println("Aresta entre vertices " + i + " e " + j);
				System.out.println("Digite se tem aresta: 1 - Sim ou 0 - Nao ");
				temAresta = entradas.nextInt();

				while (temAresta < 0 || temAresta > 1) {
					System.out.println("Valor Invalido. Digite se tem aresta: 1 - Sim ou 0 - Nao ");
					temAresta = entradas.nextInt();
				}

				this.matriz[i][j] = temAresta;
			}
		}
		System.out.println("-> GRAFO NAO PONDERADO GERADO");
	}

	// Tipo 2 - Gera Grafo Ponderado
	public void grafoPonderado() {

		int peso;

		for (int i = 0; i < this.qtdVertices; i++) {
			for (int j = 0; j < this.qtdVertices; j++) {

				System.out.println("Aresta entre vertices " + i + " e " + j);
				System.out.println("Digite o peso: ");
				peso = entradas.nextInt();

				// nao permite peso negativo
				while (peso < 0) {
					System.out.println("Valor Invalido. Digite o peso: ");
					peso = entradas.nextInt();
				}

				this.matriz[i][j] = peso;
			}
		}

		System.out.println("-> GRAFO PONDERADO GERADO");
	}

	// Tipo 3 - Gera Grafo Dirigido
	public void grafoDirigido() {

		int valor;

		for (int i = 0; i < this.qtdVertices; i++) {
			for (int j = 0; j < this.qtdVertices; j++) {

				System.out.println("Digite valor entre os vertices " + i + " e " + j);
				valor = entradas.nextInt();

				this.matriz[i][j] = valor;
			}
		}

		System.out.println("-> GRAFO PONDERADO GERADO");
	}

	// Opcao 1 - Retorna ordem do grafo
	public int ordemGrafo() {
		return this.qtdVertices;
	}

	// Opcao 2 - Verifica se aresta entre dois vertices existe
	public boolean existeAresta(int v1, int v2) {
		return (this.matriz[v1][v2] > 0);
	}

	// Opcao 3 (1) - Insere vertice
	public void insereVertice(int qtdV) {

		matrizTemp = new int[this.qtdVertices + qtdV][this.qtdVertices + qtdV];

		// Percorre linhas da matriz
		for (int i = 0; i < this.qtdVertices + qtdV; i++) {

			// Percorre colunas da matriz
			for (int j = 0; j < this.qtdVertices + qtdV; j++) {

				// se vertice existe na matriz
				if ((i < this.qtdVertices) && (j < this.qtdVertices)) {
					// salva valores na matriz temporaria
					matrizTemp[i][j] = this.matriz[i][j];
				} else {
					matrizTemp[i][j] = 0; // se vertice for novo atribui valor 0
				}
			}
		}

		// Atualiza quantidade de vertices
		this.qtdVertices = this.qtdVertices + qtdV;

		// Atualiza matriz com os novos vertices
		this.matriz = matrizTemp;

		System.out.println("-> Vertice(s) inserido(s) com sucesso!");

	}

	// Opcao 3 (2) - Remove vertice
	public void removeVertice(int v) {
		matrizTemp = new int[this.qtdVertices - 1][this.qtdVertices - 1];

		int linha = 0;

		// Percorre linhas da matriz
		for (int i = 0; i < this.qtdVertices; i++) {
			int coluna = 0;

			// se vertice a ser removido for igual a linha, passa para proximo linha(i)
			if (i != v) {
				// Percorre colunas da matriz
				for (int j = 0; j < this.qtdVertices; j++) {
					// se vertice a ser removido for igual a coluna, passa para proximo coluna(j)
					if (j != v) {
						// salva valores na nova matriz, menos no vertice escolhido para remocao
						matrizTemp[linha][coluna] = this.matriz[i][j];
						coluna++;
					}
				}
				linha++;
			}
		}

		// Atualiza a quantidade de vertices e a matriz com vertice removido
		this.qtdVertices--;
		this.matriz = matrizTemp;

		System.out.println("-> Vertice removido com sucesso!");

	}

	// Opcao 4 (1) - Insere aresta entre dois vertices
	public void insereAresta(int v1, int v2) {
		int peso;

		if (tipoGrafo == 1) {
			if (this.matriz[v1][v2] == 0) {
				this.matriz[v1][v2] = 1;
				System.out.println("-> Aresta inserida entre os vertices " + v1 + " e " + v2 + "!");
			} else {
				System.out.println("-> Já existe aresta entre os vertices " + v1 + " e " + v2 + "!");
			}
		} else {
			if (this.matriz[v1][v2] == 0) {

				if (tipoGrafo == 2) {
					System.out.println("Digite o peso da aresta: ");
					peso = entradas.nextInt();

					// nao permite negativo
					while (peso < 0) {
						System.out.println("Valor Invalido. Digite o peso da aresta: ");
						peso = entradas.nextInt();
					}

					this.matriz[v1][v2] = peso;

					System.out.println("-> Aresta com peso = " + peso + " inserida entre os v�rtices " + v1 + " e " + v2 + "!");
				} else {
					System.out.println("Digite o valor da aresta: ");
					peso = entradas.nextInt();

					System.out.println("-> Aresta com valor = " + peso + " inserida entre os vertices " + v1 + " e " + v2 + "!");
				}
			} else {
				System.out.println("-> Ja existe aresta entre os v�rtices " + v1 + " e " + v2 + "!");

				int alterar = 0;

				System.out.println("Deseja alterar valor? \n" + "1 - Sim \n" + "0 - Nao \n");
				alterar = entradas.nextInt();

				while (alterar < 0 || alterar > 1) {
					System.out.println("Op��o invalida. Deseja alterar valor? \n" + "1 - Sim \n" + "0 - Nao \n");
					alterar = entradas.nextInt();
				}

				if (alterar == 1) {
					if (tipoGrafo == 2) {

						System.out.println("Digite o novo peso da aresta: ");
						peso = entradas.nextInt();

						// nao permite negativo
						while (peso < 0) {
							System.out.println("Valor Invalido. Digite o peso da aresta: ");
							peso = entradas.nextInt();
						}

						this.matriz[v1][v2] = peso;

						System.out
								.println("-> Aresta com peso = " + peso + " atualizada entre os vertices " + v1 + " e " + v2 + "!");
					} else {
						System.out.println("Digite o novo valor da aresta: ");
						peso = entradas.nextInt();

						System.out
								.println("-> Aresta com valor = " + peso + " atualizada entre os vertices " + v1 + " e " + v2 + "!");
					}
				}
			}
		}
	}

	// Opcao 4 (2) - Remove aresta entre dois vertices
	public boolean removeAresta(int v1, int v2) {
		if (this.matriz[v1][v2] == 0) {
			return false; // Aresta nao existe
		} else {
			this.matriz[v1][v2] = 0;
			return true; // Removeu a aresta
		}
	}

	// Opcao 5 - Obtem os vertices adjacentes
	public void verticeAdjacente(int v) {
		boolean adj = false;
		for (int j = 0; j < this.qtdVertices; j++) {
			if ((this.matriz[v][j] > 0) && (v != j)) {
				if (adj == false) {
					System.out.print("-> Os vertices adjacentes de " + v + " sao: ");
					adj = true; // adj = true significa que existe pelo menos um adjacente
				}

				// Se o vertice tem vizinho - imprime vizinhos
				System.out.print(j + " ");
			}
		}

		System.out.println("");

		// adj comeca com false, se continua false ate aqui e porque nao tem adjacentes
		if (adj == false) {
			System.out.print("-> O vertice " + v + " nao tem adjacentes!\n");
		}
	}

	// Opcao 6 - Obtem grau de determinado vertice
	public int grauVertice(int v) {
		int grau = 0;
		for (int j = 0; j < qtdVertices; j++) {
			if (matriz[v][j] > 0) {
				grau++;
			}
		}
		return grau;
	}

	// Opcao 7 - Obtem grau minimo, medio e maximo da matriz
	public void grauM3() {
		int grauMinimo = 0, grauMaximo = 0;
		int cont = 1, soma = 0;
		int grauMedio = 0;

		grauMinimo = grauVertice(0);

		// Acha grau minimo
		for (int i = 1; i < this.qtdVertices; i++) {

			if (grauVertice(i) < grauMinimo) {
				grauMinimo = grauVertice(i);
			}

		}

		soma = grauVertice(0);

		// Acha grau medio
		for (int i = 1; i < this.qtdVertices; i++) {
			soma += grauVertice(i); // soma os graus dos vertices

		}

		grauMedio = soma / this.qtdVertices;

		grauMaximo = grauVertice(0);

		// Acha grau maximo
		for (int i = 1; i < this.qtdVertices; i++) {

			if (grauVertice(i) > grauMaximo) {
				grauMaximo = grauVertice(i);
			}

		}

		System.out.println("\nGrau minimo = " + grauMinimo);
		System.out.println("\nGrau medio = " + grauMedio);
		System.out.println("\nGrau maximo = " + grauMaximo);
	}

	// Opcao 8 - Verifica se o grafo e conexo
	public boolean grafoConexo() {

		boolean temAresta = false;
		for (int i = 0; i < this.qtdVertices; i++) {
			for (int j = 0; j < this.qtdVertices; j++) {
				if (this.matriz[i][j] > 0) {
					temAresta = true;
					recursivo(j, temAresta);
				}

				if (temAresta == true) {
					return true;
				}
			}
		}

		if (temAresta == true) {
			return true;
		} else {
			return false;
		}
	}

	public void recursivo(int j, boolean temAresta) {
		for (int prox = (j + 1); prox < this.qtdVertices; prox++) {
			if (this.matriz[j][prox] == 0) {
				temAresta = false;
			} else {
				recursivo(prox, temAresta);
			}
		}
	}

	// Opcao 9 - Imprime matriz de adjacencia
	public void imprime() {
		System.out.print("\n");

		for (int i = 0; i < this.qtdVertices; i++) {
			System.out.print((i) + " |"); // Imprime linhas (vertice na frente)

			for (int j = 0; j < this.qtdVertices; j++) {
				System.out.print(" " + this.matriz[i][j] + " |"); // Imprime colunas
			}
			System.out.print("\n");
		}
	}

	// Opcao 10 - Verificar se existe um caminho de Euler?
	public void caminhoEuler() {
		int qtdImpar = 0;

		for (int i = 0; i < this.qtdVertices; i++) {
			for (int j = 0; j < this.qtdVertices; j++) {
				if ((this.matriz[i][j] % 2) != 0) {
					qtdImpar++;
				}
			}
		}

		// verifica quantidade de grau impar.
		if ((qtdImpar == 2) || (qtdImpar == 0)) {
			System.out.println("-> Existe um caminho de Euler!");
		} else {
			System.out.println("-> Nao existe um caminho de Euler!");
		}
	}

	// Encontra matriz de acessibilidade R
	public void algoritmoWarshall() {

		grafoNaoPonderado();

		imprime();

		this.matrizTemp = new int[this.qtdVertices][this.qtdVertices];

		for (int k = 0; k < this.qtdVertices; k++) {
			for (int i = 0; i < this.qtdVertices; i++) {

				if (this.matriz[i][k] == 0) { // LINHA - se valor 0
					for (int j = 0; j < this.qtdVertices; j++) {
						matrizTemp[i][j] = this.matriz[i][j]; // copia valores da linha para matriz k+1
					}
				} else if (this.matriz[i][k] == 1) { // LINHA = se valor 1
					for (int j = 0; j < this.qtdVertices; j++) { // percorre colunas

						// operacao booleana OR
						if (this.matriz[i][j] == 1 || this.matriz[k][j] == 1) { // se um dos valores � 1
							matrizTemp[i][j] = 1;
						} else {
							matrizTemp[i][j] = 0;
						}
					}
				}
			}

			// matriz R
			this.matriz = matrizTemp;
		}

		System.out.println("\n");

		System.out.println("********** Matriz de Acessibilidade R **********");

		imprime();
	}

	// Cria matriz e Encontra caminho minimo
	public void caminhoMinimo() {
		int peso;
		int temAresta;
		int tipoAlgoritmo = 0;
		int escolherOutro = 0;

		do {

			// zera matriz
			for (int i = 0; i < this.qtdVertices; i++) {
				for (int j = 0; j < this.qtdVertices; j++) {
					this.matriz[i][j] = 0;
				}
			}

			System.out.println("\n");

			System.out.println("********** Escolha um dos algoritmos para encontrar o Caminho Minimo **********\n"
					+ "1 - Dijkstra\n" + "2 - Bellman-Ford\n" + "3 - Floyd\n");

			tipoAlgoritmo = entradas.nextInt();

			while ((tipoAlgoritmo < 1) || (tipoAlgoritmo > 3)) {
				System.out.println("Opcao invalida. Digite novamente: ");
				tipoAlgoritmo = entradas.nextInt();
			}

			System.out.println("\n");

			int tipoG;
			System.out.println("Tipo de Grafo:\n" + "1 - Dirigido\n" + "2 - Nao Dirigido\n");
			tipoG = entradas.nextInt();

			while ((tipoG < 1) || (tipoG > 2)) {
				System.out.println("Opcao invalida. Digite novamente: ");
				tipoG = entradas.nextInt();
			}

			if (tipoG == 1) {
				System.out.println("********** Gerar Grafo Dirigido **********");
			} else if (tipoG == 2) {
				System.out.println("********** Gerar Grafo Nao Dirigido **********");
			}

			// gerando matriz
			for (int i = 0; i < this.qtdVertices; i++) { // percorre LINHAS

				for (int j = 0; j < this.qtdVertices; j++) { // percorre COLUNAS

					// n�o entra na diagonal principal
					if (i != j) {

						// GRAFO NAO DIRIGIDO
						if (tipoG == 2) {

							if ((this.matriz[i][j] == 0)) {

								System.out.println(
										"Tem aresta entre vertices " + i + " e " + j + " ? \n" + "Digite: \n" + "1 - Sim\n" + "0 - N�o\n");
								temAresta = entradas.nextInt();

								while (temAresta < 0 || temAresta > 1) {
									System.out.println("Valor inv�lido. Digite: \n" + "1 - Sim\n" + "0 - N�o\n");
									temAresta = entradas.nextInt();
								}

								// se tem aresta
								if (temAresta == 1) {
									System.out.println("Digite o peso: ");
									peso = entradas.nextInt();

									// se for Dijkstra ou Floyd
									if ((tipoAlgoritmo == 1) || (tipoAlgoritmo == 3)) {
										// nao permite peso negativo
										while (peso <= 0) {
											System.out.println("Valor Invalido. Digite o peso: ");
											peso = entradas.nextInt();
										}
									} else if (tipoAlgoritmo == 2) { // se for Bellman-Ford
										while (peso == 0) {
											System.out.println("Valor Invalido. Digite o peso: ");
											peso = entradas.nextInt();
										}
									}

									this.matriz[i][j] = peso;
									this.matriz[j][i] = peso;
								}

								// se n�o tem aresta
								if (temAresta == 0) {
									this.matriz[i][j] = 99;
									this.matriz[j][i] = 99;
								}

							}
							// GRAFO DIRIGIDO
						} else if (tipoG == 1) {

							System.out.println(
									"Tem aresta entre vertices " + i + " e " + j + " ? \n" + "Digite: \n" + "1 - Sim\n" + "0 - N�o\n");
							temAresta = entradas.nextInt();

							while (temAresta < 0 || temAresta > 1) {
								System.out.println("Valor inv�lido. Digite: \n" + "1 - Sim\n" + "0 - N�o\n");
								temAresta = entradas.nextInt();
							}

							// se tem aresta
							if (temAresta == 1) {
								System.out.println("Digite o peso: ");
								peso = entradas.nextInt();

								// se for Dijkstra ou Floyd
								if ((tipoAlgoritmo == 1) || (tipoAlgoritmo == 3)) {
									// nao permite peso negativo
									while (peso <= 0) {
										System.out.println("Valor Invalido. Digite o peso: ");
										peso = entradas.nextInt();
									}
								} else if (tipoAlgoritmo == 2) { // se for Bellman-Ford
									while (peso == 0) {
										System.out.println("Valor Invalido. Digite o peso: ");
										peso = entradas.nextInt();
									}
								}

								this.matriz[i][j] = peso;
							}

							// se n�o tem aresta
							if (temAresta == 0) {
								this.matriz[i][j] = 99;
							}

						}
					}
				}
			}

			System.out.println("********** Grafo Gerado **********");

			imprime();

			System.out.println("");

			if (tipoAlgoritmo == 1) {
				algoritmoDijkstra();
			} else if (tipoAlgoritmo == 2) {
				algoritmoBellmanFord();
			} else if (tipoAlgoritmo == 3) {
				algoritmoFloyd();
			}

			System.out.println("Deseja escolher outro Algoritmo? \n" + "1 - Sim \n" + "0 - Nao \n");
			escolherOutro = entradas.nextInt();

			while ((escolherOutro < 0) || (escolherOutro > 1)) {
				System.out.println("Opcao invalida. Deseja escolher outro Algoritmo? \n" + "1 - Sim \n" + "0 - Nao \n");
				escolherOutro = entradas.nextInt();
			}

		} while (escolherOutro == 1);

		System.out.println("FIM");
	}

	// ALGORITMO DIJKSTRA
	public void algoritmoDijkstra() {
		System.out.println("********** Algoritmo de Dijkstra **********");

		IN = new int[this.qtdVertices];
		D = new int[this.qtdVertices];
		S = new int[this.qtdVertices];

		// PASSO 1
		for (int j = 0; j < this.qtdVertices; j++) {

			IN[j] = this.matriz[0][0];

			D[j] = this.matriz[0][j];

			S[j] = this.matriz[0][0];

		}

		for (int p = 1; p < this.qtdVertices; p++) {

			/*
			 * for(int n = 0; n < this.qtdVertices; n++) { System.out.print(IN[n] + " "); }
			 * System.out.println("\n"); for(int n = 0; n < this.qtdVertices; n++) {
			 * System.out.print(D[n] + " "); } System.out.println("\n"); for(int n = 0; n <
			 * this.qtdVertices; n++) { System.out.print(S[n] + " "); }
			 */

			System.out.println("\n");

			for (int i = 1; i < this.qtdVertices; i++) {

				boolean verticeExiste = false;
				boolean inseriuIN = false;

				// se y nao pertence a IN -> repetir passo 2,3,4
				if (IN[i] != (this.qtdVertices - 1)) {

					// PASSO 2
					// se existe aresta
					if (D[p] != 99) {
						for (int j = 1; j < this.qtdVertices; j++) { // percorre posicoes em IN
							if (IN[j] == p) { // verifica se vertice existe em IN
								verticeExiste = true;
							}
						}

						// PASSO 3
						// se vertice nao existe em IN
						if (verticeExiste == false) {
							for (int j = 1; j < this.qtdVertices; j++) {
								if (inseriuIN == false) {
									if (IN[j] == 0) { // procura posicao vazia em IN
										IN[j] = p; // insere vertice em IN

										inseriuIN = true; // insere vertice em IN
									}
								}
							}
						}

						// PASSO 4
						for (int j = p + 1; j < this.qtdVertices; j++) {
							D[j] = D[p] + this.matriz[p][j]; // recalcula valores de D para vertices restantes

							S[j] = p;
						}
					}
				}
			}
		}

		System.out.println("\n");

		int soma = 0;
		System.out.println("********** Caminho Minimo **********");
		for (int n = 0; n < this.qtdVertices; n++) {
			System.out.print(IN[n] + " ");
			soma += IN[n];
		}

		System.out.println("Dist�ncia: \n" + soma);

	}

	// ALGORITMO BELLMAN-FORD
	public void algoritmoBellmanFord() {
		System.out.println("********** Algoritmo de Bellman-Ford **********");

		IN = new int[this.qtdVertices];
		D = new int[this.qtdVertices];
		S = new int[this.qtdVertices];

		// PASSO 1
		for (int j = 0; j < this.qtdVertices; j++) {

			IN[j] = this.matriz[0][0];

			D[j] = this.matriz[0][j];

			S[j] = this.matriz[0][0];

		}

		for (int p = 1; p < this.qtdVertices; p++) {

			/*
			 * for(int n = 0; n < this.qtdVertices; n++) { System.out.print(IN[n] + " "); }
			 * System.out.println("\n"); for(int n = 0; n < this.qtdVertices; n++) {
			 * System.out.print(D[n] + " "); } System.out.println("\n"); for(int n = 0; n <
			 * this.qtdVertices; n++) { System.out.print(S[n] + " "); }
			 */

			System.out.println("\n");

			for (int i = 1; i < this.qtdVertices; i++) {

				boolean verticeExiste = false;
				boolean inseriuIN = false;

				// se y nao pertence a IN -> repetir passo 2,3,4
				if (IN[i] != (this.qtdVertices - 1)) {

					// PASSO 2
					// se existe aresta
					if (D[p] != 99) {
						for (int j = 1; j < this.qtdVertices; j++) { // percorre posicoes em IN
							if (IN[j] == p) { // verifica se vertice existe em IN
								verticeExiste = true;
							}
						}

						// PASSO 3
						// se vertice nao existe em IN
						if (verticeExiste == false) {
							for (int j = 1; j < this.qtdVertices; j++) {
								if (inseriuIN == false) {
									if (IN[j] == 0) { // procura posicao vazia em IN
										IN[j] = p; // insere vertice em IN

										inseriuIN = true; // insere vertice em IN
									}
								}
							}
						}

						// PASSO 4
						for (int j = p + 1; j < this.qtdVertices; j++) {
							D[j] = D[p] + this.matriz[p][j]; // recalcula valores de D para vertices restantes

							S[j] = p;
						}
					}
				}
			}
		}

		System.out.println("\n");

		int soma = 0;
		System.out.println("********** Caminho Minimo **********");
		for (int n = 0; n < this.qtdVertices; n++) {
			System.out.print(IN[n] + " ");
			soma += IN[n];
		}

		System.out.println("Dist�ncia: \n" + soma);

	}

	// ALGORITMO FLOYD
	public void algoritmoFloyd() {
		System.out.println("********** Algoritmo de Floyd **********");

		// grafoPonderado();

		imprime();

		this.matrizTemp = new int[this.qtdVertices][this.qtdVertices];

		for (int k = 0; k < this.qtdVertices; k++) {
			for (int i = 0; i < this.qtdVertices; i++) { // percorre linhas
				for (int j = 0; j < this.qtdVertices; j++) { // percorre colunas

					if (this.matriz[i][k] + this.matriz[k][j] < this.matriz[i][j]) {
						this.matrizTemp[i][j] = this.matriz[i][k] + this.matriz[k][j];
					}

				}
			}
		}

		// matriz R
		this.matriz = this.matrizTemp;

		System.out.println("\n");
		System.out.println("********** Caminho Minimo **********");
		imprime();

	}

	public void componentesConectados() {
		int temAresta = 0;
		for (int i = 0; i < this.qtdVertices; i++) {
			for (int j = 0; j < this.qtdVertices; j++) {
				if (this.matriz[i][j] > 0) {
					temAresta = 1;
					recursivo2(j, temAresta);
				}

				if (temAresta == 1) {
					// return true;
				}
			}
		}

		if (temAresta == 1) {
			// return true;
		} else {
			// return false;
		}

	}

	public void recursivo2(int j, int temAresta) {
		for (int prox = (j + 1); prox < this.qtdVertices; prox++) {
			if (this.matriz[j][prox] == 0) {
				temAresta = 0;
			} else {
				recursivo2(prox, temAresta);
			}
		}
	}

	public void maiorComponente() {
		int aux = 0;
		int maior = 0;
		int vertice = 0;
		for (int i = 0; i < this.qtdVertices; i++) {
			aux = grauVertice(i);
			if (aux > maior) {
				maior = aux;
				vertice = i;
			}
		}
		System.out.println("\n");
		System.out.println("Vertice " + vertice + " tem " + maior + " Componente(s)");
	}
}
