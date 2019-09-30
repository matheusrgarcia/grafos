package br.com.unifacs.grafos;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner implements CommandLineRunner {

  Scanner entries = new Scanner(System.in);

  // Gera um grafo Não dirigido por padrão.
  Grafo grafo = new Grafo(1, 0);

  @Override
  public void run(String... args) {

    menu();

  }

  public void menu() {
    System.out.println("*************** MENU ***************");

    int selection = 0;

    do {
      System.out.println("1) Gerar Grafo \n" + "2) Opções \n" + "0) Sair");

      if (selection < 0 || selection > 2) {
        System.out.println("Opção Inválida. Digite a opção desejada: ");
        selection = entries.nextInt();
      } else {
        System.out.println("Digite a opção desejada: ");
        selection = entries.nextInt();
      }

    } while (selection < 0 || selection > 2);

    if (selection == 1) {
      menuGerarGrafo();
    } else if (selection == 2) {
      opcoes();
    } else if (selection == 3) {
      exit();
    }

  }

  public void menuGerarGrafo() {
    System.out.println("*************** ESCOLHA O TIPO DE GRAFO ***************");

    int selection = 0;

    do {
      System.out.println("1) Não Dirigido \n" + "2) Ponderado \n" + "3) Dirigido \n" + "0) Sair");

      if (selection < 0 || selection > 3) {
        System.out.println("Opção Inválida. Digite a opção desejada: ");
        selection = entries.nextInt();
      } else {
        System.out.println("Digite a opção desejada: ");
        selection = entries.nextInt();
      }

    } while (selection < 0 || selection > 3);

    if (selection == 1) {
      gerarGrafoNaoDirigido();
    } else if (selection == 2) {
      // gerarGrafoPonderado();
    } else if (selection == 3) {
      // gerarGrafoDirigido();
    } else if (selection == 0) {
      exit();
    }
  }

  public void opcoes() {
    int selection = 1;

    System.out.println("********** ESCOLHA UMA OPÇÃO **********");

    do {
      System.out.println("1 - Verificar Ordem do grafo \n" + "2 - Verificar existência de Aresta entre dois Vértices \n"
          + "3 -" + "Inserir/Remover Vértice \n" + "4 - Inserir/Remover aresta \n" + "5 - Obter Vértices adjacentes \n"
          + "6 - Obter grau de determinado Vertice \n" + "7 - Obter grau mínimo, médio ou máximo \n"
          + "8 - Verificar se o grafo é Conexo \n" + "9 - Obter matriz de adjacência\n"
          + "10 - Verificar se existe um Caminho de Euler no grafo\n" + "0 - Sair");

      System.out.println("\n");

      if (selection < 0 || selection > 10) {
        System.out.println("Opção inválida. Digite a opção desejada corretamente: ");
        selection = entries.nextInt();
      } else {
        System.out.println("Digite a opção desejada: ");
        selection = entries.nextInt();
      }

    } while (selection < 0 || selection > 10);

    switch (selection) {
    case 1:

      break;
    case 2:

      break;
    case 3:
      int opcaoCase = -1;
      int v = -1;
      System.out.println("********** Inserir/Remover Vértice **********");

      System.out.println("1 - Inserir vértice");
      System.out.println("2 - Remover vértice");
      System.out.println("0 - Sair");

      System.out.println("Digite a opção desejada: ");
      opcaoCase = entries.nextInt();

      while (opcaoCase < 0 || opcaoCase > 2) {
        System.out.println("Opção inválida. Digite a opção desejada: ");
        opcaoCase = entries.nextInt();
      }

      switch (opcaoCase) {
      case 1:
        System.out.println("********** INSERIR Vértice **********");
        System.out.println("Digite a quantidade de vértice(s) a ser inserido: ");
        v = entries.nextInt();
        this.grafo.adicionaVertice(v);
        this.grafo.imprime();
        menu();
        break;
      case 2:
        System.out.println("********** REMOVER Vértice **********");
        System.out.println("Digite o vértice a ser removido:");
        v = entries.nextInt();
        this.grafo.removeVertice(v);
        this.grafo.imprime();
        menu();
        while ((v < 0) || (v > (grafo.length() - 1))) {
          System.out.println("Valor inválido. Digite o vértice a ser removido:");
          v = entries.nextInt();
        }
        break;
      }
      while (v < 1) {
        System.out.println("Valor inválido. Digite quantidade de vértice a ser inserido: ");
        v = entries.nextInt();
      }

      break;
    case 4:

      break;
    case 5:

      break;
    case 6:

      break;
    case 7:

      break;
    case 8:

      break;
    case 9:

      break;
    case 10:

      break;

    }

  }

  public void gerarGrafoNaoDirigido() {
    int qtdVertices = 0;

    do {
      if (qtdVertices < 0) {
        System.out.println("Valor inválido. Digite a quantidade de Vértices: ");
        qtdVertices = entries.nextInt();
      } else {
        System.out.println("Digite a quantidade de Vértices: ");
        qtdVertices = entries.nextInt();
      }
    } while (qtdVertices < 0);

    grafo = new Grafo(1, qtdVertices);

    grafo.imprime();

    menu();
  }

  public void exit() {
    System.out.print("Exit");
    entries.close();
    System.exit(0);
  }

}