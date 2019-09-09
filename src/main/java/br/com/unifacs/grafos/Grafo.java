package br.com.unifacs.grafos;

import java.util.Scanner;

public class Grafo {
  private int matriz[][], matrizTemp[][];
  private int tipoGrafo;
  private int qtdVertices;
  boolean visitado;

  // Grafo Padrão constructor
  public Grafo(int tipo, int qtdVertices) {

    this.tipoGrafo = tipo;
    this.qtdVertices = qtdVertices;
    this.matriz = new int[this.qtdVertices][this.qtdVertices];

    for (int i = 0; i < this.qtdVertices; i++) {
      for (int j = 0; j < this.qtdVertices; j++) {
        this.matriz[i][j] = 0;
      }
    }

    if (tipoGrafo == 2) {
      grafoPonderado();
    } else if (tipoGrafo == 3) {
      grafoDirigido();
    } else {
      System.out.println("\t\tGRAFO NÃO DIRIGIDO GERADO");
    }

    // Impressão
    imprime();

  }

  // Tipo 2 - Gera Grafo Ponderado
  public void grafoPonderado() {
    Scanner entradas = new Scanner(System.in);

    int peso;

    for (int i = 0; i < this.qtdVertices; i++) {
      for (int j = 0; j < this.qtdVertices; j++) {

        System.out.println("Aresta entre vértices " + i + " e " + j);
        System.out.println("Digite o peso: ");
        peso = entradas.nextInt();

        // não permite peso negativo
        while (peso < 0) {
          System.out.println("Valor Inválido. Digite o peso: ");
          peso = entradas.nextInt();
        }

        this.matriz[i][j] = peso;
      }
    }
    System.out.println("\t\tUM GRAFO PONDERADO FOI GERADO");
    entradas.close();
  }

  // Tipo 3 - Gera Grafo Dirigido
  public void grafoDirigido() {

    Scanner entradas = new Scanner(System.in);

    int valor;

    for (int i = 0; i < this.qtdVertices; i++) {
      for (int j = 0; j < this.qtdVertices; j++) {

        System.out.println("Digite valor entre os vértices " + i + " e " + j);
        valor = entradas.nextInt();

        this.matriz[i][j] = valor;
      }
    }

    System.out.println("\t\t GRAFO PONDERADO GERADO");
    entradas.close();
  }

  // Retorna ordem do grafo
  public int ordemGrafo() {
    return this.qtdVertices;
  }

  // Verifica se uma aresta entre dois vértices existe.
  public boolean existeAresta(int v1, int v2) {
    return (this.matriz[v1][v2] > 0);
  }

  // Insere vértice
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
          matrizTemp[i][j] = 0; // se vertice é novo atribui valor 0
        }
      }
    }

    // Atualiza quantidade de vertices
    this.qtdVertices = this.qtdVertices + qtdV;

    // Atualiza matriz com os novos vértices
    this.matriz = matrizTemp;

    System.out.println("\t\t\tVértice(s) inserido(s) com sucesso!");

  }

  // Remove vértice
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
            // salva valores na nova matriz, menos no vertice escolhido para remoção
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

    System.out.println("\t\tVértice removido com sucesso!");

  }

  // Opcao 4 (1) - Insere aresta entre dois vértices
  public void insereAresta(int v1, int v2, int peso) {
    if (tipoGrafo == 1) {
      this.matriz[v1][v2] = 1;
      System.out.println("\t\tAresta inserida entre os vértices " + v1 + " e " + v2 + "!");
    } else {
      this.matriz[v1][v2] = peso;

      if (tipoGrafo == 2) {
        System.out.println("\t\tAresta com peso = " + peso + " inserida entre os vértices " + v1 + " e " + v2 + "!");
      } else {
        System.out.println("\t\tAresta com valor = " + peso + " inserida entre os vértices " + v1 + " e " + v2 + "!");
      }
    }
  }

  // Remove aresta entre dois vértices
  public boolean removeAresta(int v1, int v2) {
    if (this.matriz[v1][v2] == 0) {
      return false; // Aresta não existe
    } else {
      this.matriz[v1][v2] = 0;
      return true; // Removeu a aresta
    }
  }

  // Obtém os vértices adjacentes
  public void verticeAdjacente(int v) {
    boolean adj = false;
    for (int j = 0; j < this.qtdVertices; j++) {
      if ((this.matriz[v][j] > 0) && (v != j)) {
        if (adj == false) {
          System.out.print("\t\t Os vértices adjacentes de " + v + " são: ");
          adj = true; // adj = true significa que existe pelo menos um adjacente
        }

        // Se o vértice tem vizinho - imprime vizinhos
        System.out.print(j + " ");
      }
    }

    // Teste para saber se há vértices adjacentes
    if (adj == false) {
      System.out.print("\t\t O vértice " + v + " não tem adjacentes!");
    }
  }

  // Obtém grau de determinado vértice
  public int grauVertice(int v) {
    int grau = 0;
    for (int j = 0; j < qtdVertices; j++) {
      if (matriz[v][j] > 0) {
        grau++;
      }
    }
    return grau;
  }

  // Obtém grau mínimo, médio e máximo da matriz
  public void grauM3() {
    int grauMinimo = this.matriz[0][0], grauMaximo = this.matriz[0][0];
    int cont = 0, soma = 0, grauMedio = 0;

    // Acha grau mínimo
    for (int i = 0; i < this.qtdVertices; i++) {
      for (int j = 0; j < this.qtdVertices; j++) {
        if (this.matriz[i][j] < grauMinimo) {
          grauMinimo = matriz[i][j];
        }
      }
    }

    // Acha grau médio
    for (int i = 0; i < this.qtdVertices; i++) {
      for (int j = 0; j < this.qtdVertices; j++) {
        if (this.matriz[i][j] != 0) {
          soma += this.matriz[i][j]; // soma os graus diferentes de 0
          cont++; // conta quantos graus são diferentes de 0
        }
      }
    }
    if (cont != 0) {
      grauMedio = soma / cont;
    }

    // Acha grau máximo
    for (int i = 0; i < this.qtdVertices; i++) {
      for (int j = 0; j < this.qtdVertices; j++) {
        if (this.matriz[i][j] > grauMaximo) {
          grauMaximo = matriz[i][j];
        }
      }
    }
    System.out.println("\nGrau mínimo = " + grauMinimo);
    System.out.println("\nGrau médio = " + grauMedio);
    System.out.println("\nGrau máximo = " + grauMaximo);
  }

  // Verifica se o grafo é conexo
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

  // Imprime matriz de adjacência
  public void imprime() {
    System.out.print("\n");

    for (int i = 0; i < this.qtdVertices; i++) {
      System.out.print((i) + " "); // Imprime linhas (vértice na frente)

      for (int j = 0; j < this.qtdVertices; j++) {
        System.out.print(this.matriz[i][j] + " "); // Imprime colunas
      }
      System.out.print("\n");
    }
  }

  // Verificar se existe um caminho de Euler?
  public void caminhoEuler() {
    int qtdImpar = 0;

    for (int i = 0; i < this.qtdVertices; i++) {
      for (int j = 0; j < this.qtdVertices; j++) {
        if ((this.matriz[i][j] % 2) != 0) {
          qtdImpar++;
        }
      }
    }

    // Verifica quantidade de grau impar.
    if ((qtdImpar == 2) || (qtdImpar == 0)) {
      System.out.println("\t\t Existe um caminho de Euler!");
    } else {
      System.out.println("\t\t Não existe um caminho de Euler!");
    }
  }

}
