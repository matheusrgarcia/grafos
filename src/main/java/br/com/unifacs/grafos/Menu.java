// package br.com.unifacs.grafos;

// import java.util.Scanner;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class Menu implements CommandLineRunner {

// @Override
// public void run(String... args) {

// System.out.println("*************** ESCOLHA O TIPO DE GRAFO
// ***************");

// Scanner entries = new Scanner(System.in);

// int tipo = 0;

// // Determina tipo de grafo
// do {
// System.out.println("1) Não Dirigido \n" + "2) Ponderado \n" + "3) Dirigido
// \n" + "0) Sair");

// if (tipo < 0 || tipo > 3) {
// System.out.println("Opção Inválida. Digite a opção desejada: ");
// tipo = entries.nextInt();
// } else {
// System.out.println("Digite a opção desejada: ");
// tipo = entries.nextInt();
// }

// } while (tipo < 0 || tipo > 3);

// if (tipo != 0) {

// int qtdVertices = 0, peso = 0;

// do {
// if (qtdVertices < 0) {
// System.out.println("Valor inválido. Digite a quantidade de Vértices: ");
// qtdVertices = entries.nextInt();
// } else {
// System.out.println("Digite a quantidade de Vértices: ");
// qtdVertices = entries.nextInt();
// }
// } while (qtdVertices < 0);

// System.out.println();

// GrafoOriginal Grafo = new GrafoOriginal(tipo, qtdVertices);

// int opcao = 0;

// do {
// System.out.println("\n");

// System.out.println("********** ESCOLHA UMA OPÇÃO **********");

// System.out.println("1 - Verificar Ordem do grafo \n"
// + "2 - Verificar existência de Aresta entre dois Vértices \n" + "3 -
// Inserir/Remover Vértice \n"
// + "4 - Inserir/Remover aresta \n" + "5 - Obter Vértices adjacentes \n"
// + "6 - Obter grau de determinado Vertice \n" + "7 - Obter grau mínimo, médio
// ou máximo \n"
// + "8 - Verificar se o grafo é Conexo \n" + "9 - Obter matriz de adjacência
// \n"
// + "10 - Verificar se existe um Caminho de Euler no grafo\n" + "0 - Sair");

// System.out.println("\n");

// if (opcao < 0 || opcao > 10) {
// System.out.println("Opção inválida. Digite a opção desejada corretamente: ");
// opcao = entries.nextInt();
// } else {
// System.out.println("Digite a opção desejada: ");
// opcao = entries.nextInt();
// }

// } while (opcao < 0 || opcao > 10);

// int v = 0, v1 = 0, v2 = 0;

// switch (opcao) {
// case 1:
// System.out.println("\n");

// System.out.println("********** Ordem do Grafo **********");

// System.out.println("\t " + Grafo.ordemGrafo());
// break;

// case 2:
// System.out.println("\n");

// System.out.println("********** Verificar existência de Aresta entre dois
// v�rtices **********");

// System.out.println("Digite o 1ª Vértice: ");
// v1 = entries.nextInt();

// while (v1 < 0 || v1 > (qtdVertices - 1)) {
// System.out.println("Valor inválido. Digite o 1ª vértice: ");
// v1 = entries.nextInt();
// }

// System.out.println("Digite o 2ª Vértice: ");
// v2 = entries.nextInt();

// while (v2 < 0 || v2 > (qtdVertices - 1)) {
// System.out.println("Valor inválido. Digite o 2ª vértice: ");
// v2 = entries.nextInt();
// }

// if (Grafo.existeAresta(v1, v2)) {
// System.out.println("\t Existe aresta entre os vértices!");
// } else {
// System.out.println("\t Não existe aresta entre os vértices!");
// }

// // visualizar grafo
// Grafo.imprime();

// break;

// case 3:
// int opcaoCase = 0;
// // v = 0;

// System.out.println("\n");

// System.out.println("********** Inserir/Remover Vértice **********");

// System.out.println("1 - Inserir vértice");
// System.out.println("2 - Remover vértice");
// System.out.println("0 - Sair");

// System.out.println("Digite a opção desejada: ");
// opcaoCase = entries.nextInt();

// while (opcaoCase < 0 || opcaoCase > 2) {
// System.out.println("Opção inválida. Digite a opção desejada: ");
// opcaoCase = entries.nextInt();
// }

// switch (opcaoCase) {
// case 1:
// System.out.println("********** INSERIR vértice **********");
// System.out.println("Digite a quantidade de vértice(s) a ser inserido: ");
// v = entries.nextInt();

// while (v < 1) {
// System.out.println("Valor inválido. Digite quantidade de vértice a ser
// inserido: ");
// v = entries.nextInt();
// }

// // imprime grafo anterior
// /*
// * System.out.println("Grafo anterior: "); Grafo.imprime();
// */

// System.out.println("\n");
// Grafo.insereVertice(v);

// // imprime novo grafo

// System.out.println("Grafo atual: ");
// Grafo.imprime();

// break;

// case 2:
// System.out.println("********** REMOVER vértice **********");
// System.out.println("Digite o v�rtice a ser removido:");
// v = entries.nextInt();

// while ((v < 0) || (v > (qtdVertices - 1))) {
// System.out.println("Valor inválido. Digite o vértice a ser removido:");
// v = entries.nextInt();
// }

// // Imprime grafo anterior
// /*
// * System.out.println("Grafo anterior: "); Grafo.imprime();
// */

// Grafo.removeVertice(v);

// // Imprime novo grafo
// /*
// * System.out.println("Grafo atual: "); Grafo.imprime();
// */

// break;

// case 0:
// // sair
// break;
// }

// break;

// case 4:
// System.out.println("\n");

// System.out.println("********** Inserir/Remover Aresta **********");

// System.out.println("1 - Inserir aresta");
// System.out.println("2 - Remover aresta");
// System.out.println("0 - Sair");

// System.out.println("Digite a opção desejada: ");
// opcaoCase = entries.nextInt();

// while (opcaoCase < 0 || opcaoCase > 2) {
// System.out.println("Opção inválida. Digite a opção desejada: ");
// opcaoCase = entries.nextInt();
// }

// switch (opcaoCase) {
// case 1:
// System.out.println("********** INSERIR Aresta **********");

// // Obtendo 1ª vértice
// System.out.println("Digite o 1ª vértice: ");
// v1 = entries.nextInt();

// // Verifica se 1ª vértice existe
// while (v1 < 0 || v1 > (qtdVertices - 1)) {
// System.out.println("Valor Inválido. Digite o 1ª vértice: ");
// v1 = entries.nextInt();
// }

// // Obtendo 2ª vértice
// System.out.println("Digite o 2ª vértice: ");
// v2 = entries.nextInt();

// // Verifica se 2ª vértice existe
// while (v2 < 0 || v2 > (qtdVertices - 1)) {
// System.out.println("Valor Inválido. Digite o 2ª vértice: ");
// v2 = entries.nextInt();
// }

// System.out.println("\n");

// // Se for grafo ponderado, pega o peso da aresta
// if (tipo == 2) {
// System.out.println("Digite o peso da aresta: ");
// peso = entries.nextInt();

// // Não permitir peso negativo
// while (peso < 0) {
// System.out.println("Valor Inválido. Digite o peso da aresta: ");
// peso = entries.nextInt();
// }
// }

// // Caso seja um grafo dirigido, pegar o valor da aresta
// if (tipo == 3) {
// System.out.println("Digite o valor da aresta: ");
// peso = entries.nextInt();
// }

// System.out.println("Peso: " + peso);
// Grafo.insereAresta(v1, v2, peso);

// // Visualiza grafo
// Grafo.imprime();
// break;

// case 2:
// System.out.println("********** REMOVER aresta **********");

// // Obtendo 1º vértice
// System.out.println("Digite o 1º vértice: ");
// v1 = entries.nextInt();

// // Verifica se 1º vértice existe
// while (v1 < 0 || v1 > (qtdVertices - 1)) {
// System.out.println("Valor Inválido. Digite o 1ª vértice: ");
// v1 = entries.nextInt();
// }

// // Obtendo 2º vértice
// System.out.println("Digite o 2ª vértice: ");
// v2 = entries.nextInt();

// // Verifica se 2º vértice existe
// while (v2 < 0 || v2 > (qtdVertices - 1)) {
// System.out.println("Valor Inválido. Digite o 2ª vértice: ");
// v2 = entries.nextInt();
// }

// if (Grafo.removeAresta(v1, v2) == true) {
// System.out.println("\t Aresta removida entre os vértices " + v1 + " e " +
// v2);
// } else {
// System.out.println("\t Não existe aresta entre os vértices!");
// }

// // Visualiza grafo
// Grafo.imprime();
// break;

// case 0:
// // sair
// break;
// }

// break;

// case 5:
// // v = 0;

// System.out.println("\n");

// System.out.println("********** Obter Vértices Adjacentes **********");

// // visualiza grafo
// // Grafo.imprime();

// System.out.println("Digite o Vértice:");
// v = entries.nextInt();

// Grafo.verticeAdjacente(v);

// break;

// case 6:

// System.out.println("\n");

// System.out.println("********** Obter Grau de Determinado Vértice
// **********");

// System.out.println("Digite o vértice:");
// v = entries.nextInt();

// while (v < 0 || v > (qtdVertices - 1)) {
// System.out.println("Valor Inválido. Digite o vértice:");
// v = entries.nextInt();
// }

// System.out.println("\t Grau do vértice " + v + " = " + Grafo.grauVertice(v));

// break;

// case 7:

// System.out.println("\n");

// System.out.println("********** Obter Grau Mínimo, Médio e Máximo do Grafo
// **********");

// Grafo.grauM3();

// break;

// case 8:
// System.out.println("\n");

// System.out.println("********** Verificar se o Grafo é Conexo **********");

// // visualiza grafo
// // Grafo.imprime();

// System.out.println("\n");

// if (Grafo.grafoConexo() == true) {
// System.out.println("\t O grafo é conexo!");
// } else {
// System.out.println("\t O grafo não é conexo!");
// }

// break;

// case 9:
// System.out.println("\n");

// System.out.println("********** Matriz de Adjacência **********");

// System.out.println("\t " + qtdVertices + " x " + qtdVertices);

// Grafo.imprime();

// break;

// case 10:
// System.out.println("\n");

// System.out.println("********** Verificar se Existe um Caminho de Euler
// **********");

// Grafo.caminhoEuler();
// break;

// case 0:
// // sair
// System.out.println("Saindo...");
// entries.close();
// break;
// }
// }
// }

// }
