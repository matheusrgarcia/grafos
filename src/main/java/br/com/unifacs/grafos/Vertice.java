// Fazer um ArrayList da vida aqui
package br.com.unifacs.grafos;

import java.util.ArrayList;

public class Vertice {

  ArrayList<String> vertices = new ArrayList<>();

  public Vertice() {
    vertices = null;
  }

  public Vertice(int qtdVertices) {
    if (qtdVertices > 0) {
      for (int i = 0; i < qtdVertices; i++) {
        vertices.add(Integer.toString(i));
      }

    }
  }

  public int length() {
    return this.vertices.size();
  }

  public void addVertice(int qtdVertices) {
    for (int i = vertices.size(); i <= qtdVertices; i++) {
      vertices.add(Integer.toString(i));
    }
  }

  public void removeVertice(int index) {
    vertices.remove(index);
  }

}