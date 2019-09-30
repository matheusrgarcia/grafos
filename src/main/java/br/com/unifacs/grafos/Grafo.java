package br.com.unifacs.grafos;

public class Grafo {

  int qtdVertices = 0;
  int tipoSelecionado = -1;
  Vertice vertice;

  private int[][] matriz;

  public Grafo(int tipo, int qtdVertices) {

    this.tipoSelecionado = tipo;
    this.qtdVertices = qtdVertices;

    if (tipoSelecionado == 1) {
      grafoNaoDirigido(qtdVertices);
    } else if (tipoSelecionado == 2) {
      grafoPonderado(qtdVertices);
    } else if (tipoSelecionado == 3) {
      grafoDirigido(qtdVertices);
    } else {
      System.out.println("Tipo errôneo selecionado");
    }

  }

  // Gravo Não Dirigido
  public void grafoNaoDirigido(int qtdVertices) {

    vertice = new Vertice(qtdVertices);

    this.matriz = new int[vertice.length()][vertice.length()];

    for (int linha = 0; linha < vertice.length(); linha++) {
      for (int coluna = 0; coluna < vertice.length(); coluna++) {
        this.matriz[linha][coluna] = 0;
      }
    }

  }

  public void grafoPonderado(int qtdVertices) {

  }

  public void grafoDirigido(int qtdVertices) {

  }

  public void removeVertice(int index) {
    vertice.removeVertice(index);
  }

  public void adicionaVertice(int qtdVertices) {
    vertice.addVertice(qtdVertices);
  }

  public int length() {
    return vertice.length();
  }

  public void imprime() {
    System.out.print("\n");

    for (int i = 0; i < vertice.length(); i++) {
      System.out.print((i) + " "); // Imprime linhas (vértice na frente)
      for (int j = 0; j < vertice.length(); j++) {
        System.out.print(this.matriz[i][j] + " "); // Imprime colunas
      }

      System.out.print("\n");
    }
  }

}
