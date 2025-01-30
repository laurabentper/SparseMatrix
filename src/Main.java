import Estruturas.MatrizEsparsa;
import Estruturas.MatrizEstatica;
import Estruturas.MatrizListas;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) {

		//testarEstatica(10000);
		testarDinamica(1000);

	}

	public static void gerarMatrizListas(MatrizListas matrizListas){

		int tamanho = matrizListas.getTam();

		//define quantos elementos devem ser diferentes de zero
		long esparsidade = Math.round(tamanho * tamanho * 0.4);

		while(esparsidade > 0){
			int row = ThreadLocalRandom.current().nextInt(0, tamanho);
			int col = ThreadLocalRandom.current().nextInt(0, tamanho);
			int dado = ThreadLocalRandom.current().nextInt(1, 10);

			if(matrizListas.insereElem(row, col, dado)){
				esparsidade--;
			}
		}
	}

	public static void gerarMatrizEstatica(MatrizEstatica matrizEstatica){

		int tamanho = matrizEstatica.getTam();

		//define quantos elementos devem ser diferentes de zero
		long esparsidade = Math.round(tamanho * tamanho * 0.4);

		while (esparsidade > 0){

			int row = ThreadLocalRandom.current().nextInt(0, tamanho);
			int col = ThreadLocalRandom.current().nextInt(0, tamanho);
			int dado = ThreadLocalRandom.current().nextInt(1, 10);

			if(matrizEstatica.insereElem(row,col,dado)){
				esparsidade--;
			}
		}
	}

	public static void testarEstatica(int tamanho){

		MatrizEstatica matrizEstatica = new MatrizEstatica(tamanho);

		int testes = 10;
		long t1, t0, somaTempos = 0;

		for (int i = 0; i < testes; i++) {
			matrizEstatica.esvazia();
			t0 = System.currentTimeMillis();
			gerarMatrizEstatica(matrizEstatica);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoGerar = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.obtemTransposta();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoTransposta = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.ehSimetrica();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoVerificaSimetria = (double) somaTempos / testes;
		//subtrair no relatorio o tempo para gerar a transposta.

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.imprime();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoImprimir = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			int elem = ThreadLocalRandom.current().nextInt(1, 10);
			t0 = System.currentTimeMillis();
			matrizEstatica.buscaElem(elem);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoBuscar = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.ehVazia();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoVerificaVazia = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.ehDiagonal();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoVerificaDiagonal = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.ehMatrizColuna();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoVerificaColuna = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.ehMatrizLinha();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoVerificaLinha = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.ehMatrizTriangSup();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoTriangSup = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.ehMatrizTriangInf();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoTriangInf = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			int row = ThreadLocalRandom.current().nextInt(0, tamanho);
			int col = ThreadLocalRandom.current().nextInt(0, tamanho);
			t0 = System.currentTimeMillis();
			matrizEstatica.getElem(row, col);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoAcessarPosicao = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			int row = ThreadLocalRandom.current().nextInt(0, tamanho);
			int col = ThreadLocalRandom.current().nextInt(0, tamanho);
			t0 = System.currentTimeMillis();
			matrizEstatica.insereElem(row, col,1);
			t1 = System.currentTimeMillis();
			matrizEstatica.removeElem(row, col);
			somaTempos += (t1 - t0);
		}
		double tempoInserir = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			int row = ThreadLocalRandom.current().nextInt(0, tamanho);
			int col = ThreadLocalRandom.current().nextInt(0, tamanho);
			t0 = System.currentTimeMillis();
			matrizEstatica.removeElem(row, col);
			t1 = System.currentTimeMillis();
			matrizEstatica.insereElem(row, col, 1);
			somaTempos += (t1 - t0);
		}
		double tempoRemover = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.somaMatriz(matrizEstatica);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoSoma = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.multiplicaMatriz(matrizEstatica);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoMultiplicacao = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.esvazia();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoImprimeVazia = (double) somaTempos / testes;

		System.out.printf("MATRIZ ESTATICA TAM=%d%n", matrizEstatica.getTam());
		System.out.printf("Tempo gerar: %.5f%n", tempoGerar);
		System.out.printf("Tempo remove: %.5f%n", tempoRemover);
		System.out.printf("Tempo insere: %.5f%n", tempoInserir);
		System.out.printf("Tempo buscar elemento: %.5f%n", tempoBuscar);
		System.out.printf("Tempo confereVazia: %.5f%n", tempoVerificaVazia);
		System.out.printf("Tempo confereDiagonal: %.5f%n", tempoVerificaDiagonal);
		System.out.printf("Tempo confereColuna: %.5f%n", tempoVerificaColuna);
		System.out.printf("Tempo confereLinha: %.5f%n", tempoVerificaLinha);
		System.out.printf("Tempo confereTrianguloSuperior: %.5f%n", tempoTriangSup);
		System.out.printf("Tempo confereTrianguloInferior: %.5f%n", tempoTriangInf);
		System.out.printf("Tempo verificarSimetria: %.5f%n", tempoVerificaSimetria);
		System.out.printf("Tempo soma: %.5f%n", tempoSoma);
		System.out.printf("Tempo multiplicação: %.5f%n", tempoMultiplicacao);
		System.out.printf("Tempo transposta: %.5f%n", tempoTransposta);
		System.out.printf("Tempo acessar posicao: %.5f%n", tempoAcessarPosicao);
		System.out.printf("Tempo imprimir: %.5f%n", tempoImprimir);
		System.out.printf("Tempo esvaziar: %.5f%n", tempoImprimeVazia);

	}

	public static void testarDinamica(int tamanho){

		MatrizListas matrizListas = new MatrizListas(tamanho);

		int testes = 10;
		long t1, t0, somaTempos = 0;

		for (int i = 0; i < testes; i++) {
			matrizListas.esvazia();
			t0 = System.currentTimeMillis();
			gerarMatrizListas(matrizListas);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoGerar = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizListas.obtemTransposta();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoTransposta = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizListas.ehSimetrica();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoVerificaSimetria = (double) somaTempos / testes;
		//subtrair no relatorio o tempo para gerar a transposta.

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizListas.imprime();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoImprimir = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			int elem = ThreadLocalRandom.current().nextInt(1, 10);
			t0 = System.currentTimeMillis();
			matrizListas.buscaElem(elem);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoBuscar = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizListas.ehVazia();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoVerificaVazia = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizListas.ehDiagonal();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoVerificaDiagonal = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizListas.ehMatrizColuna();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoVerificaColuna = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizListas.ehMatrizLinha();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoVerificaLinha = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizListas.ehMatrizTriangSup();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoTriangSup = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizListas.ehMatrizTriangInf();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoTriangInf = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			int row = ThreadLocalRandom.current().nextInt(0, tamanho);
			int col = ThreadLocalRandom.current().nextInt(0, tamanho);
			t0 = System.currentTimeMillis();
			matrizListas.getElem(row, col);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoAcessarPosicao = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			int row = ThreadLocalRandom.current().nextInt(0, tamanho);
			int col = ThreadLocalRandom.current().nextInt(0, tamanho);
			t0 = System.currentTimeMillis();
			matrizListas.insereElem(row, col,1);
			t1 = System.currentTimeMillis();
			matrizListas.removeElem(row, col);
			somaTempos += (t1 - t0);
		}
		double tempoInserir = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			int row = ThreadLocalRandom.current().nextInt(0, tamanho);
			int col = ThreadLocalRandom.current().nextInt(0, tamanho);
			t0 = System.currentTimeMillis();
			matrizListas.removeElem(row, col);
			t1 = System.currentTimeMillis();
			matrizListas.insereElem(row, col, 1);
			somaTempos += (t1 - t0);
		}
		double tempoRemover = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizListas.somaMatriz(matrizListas);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoSoma = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizListas.multiplicaMatriz(matrizListas);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoMultiplicacao = (double) somaTempos / testes;

		somaTempos = 0;
		for (int i = 0; i < testes; i++) {
			t0 = System.currentTimeMillis();
			matrizListas.esvazia();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		double tempoImprimeVazia = (double) somaTempos / testes;

		System.out.printf("MATRIZ DINAMICA TAM=%d%n", matrizListas.getTam());
		System.out.printf("Tempo gerar: %.5f%n", tempoGerar);
		System.out.printf("Tempo remove: %.5f%n", tempoRemover);
		System.out.printf("Tempo insere: %.5f%n", tempoInserir);
		System.out.printf("Tempo buscar elemento: %.5f%n", tempoBuscar);
		System.out.printf("Tempo confereVazia: %.5f%n", tempoVerificaVazia);
		System.out.printf("Tempo confereDiagonal: %.5f%n", tempoVerificaDiagonal);
		System.out.printf("Tempo confereColuna: %.5f%n", tempoVerificaColuna);
		System.out.printf("Tempo confereLinha: %.5f%n", tempoVerificaLinha);
		System.out.printf("Tempo confereTrianguloSuperior: %.5f%n", tempoTriangSup);
		System.out.printf("Tempo confereTrianguloInferior: %.5f%n", tempoTriangInf);
		System.out.printf("Tempo verificarSimetria: %.5f%n", tempoVerificaSimetria);
		System.out.printf("Tempo soma: %.5f%n", tempoSoma);
		System.out.printf("Tempo multiplicação: %.5f%n", tempoMultiplicacao);
		System.out.printf("Tempo transposta: %.5f%n", tempoTransposta);
		System.out.printf("Tempo acessar posicao: %.5f%n", tempoAcessarPosicao);
		System.out.printf("Tempo imprimir: %.5f%n", tempoImprimir);
		System.out.printf("Tempo esvaziar: %.5f%n", tempoImprimeVazia);
	}
}


		

