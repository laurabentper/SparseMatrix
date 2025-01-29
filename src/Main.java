import Estruturas.MatrizEstatica;
import Estruturas.MatrizListas;

import java.util.concurrent.ThreadLocalRandom;

public class Main {


	public static void main(String[] args) {

		testarEstatica(10);

		//testarLista(10);

	}

	/*
	public static void gerarMatrizListas(MatrizListas matrizLista){

		int tamanho = matrizLista.getTam();

		//define quantos elementos devem ser diferentes de zero
		long esparsidade = Math.round(tamanho * tamanho * 0.4);

		while(esparsidade > 0){
			int row = ThreadLocalRandom.current().nextInt(0, tamanho);
			int col = ThreadLocalRandom.current().nextInt(0, tamanho);
			int dado = ThreadLocalRandom.current().nextInt(1, 10);

			if(matrizLista.insereElem(row, col, dado)){
				esparsidade--;
			}
		}

	}

	 */

	public static void gerarMatrizEstatica(MatrizEstatica matrizEstatica){

		int tamanho = matrizEstatica.getTam();

		//define quantos elementos devem ser diferentes de zero
		long esparsidade = Math.round(tamanho * tamanho * 0.4);

		while (esparsidade > 0){

			int row = ThreadLocalRandom.current().nextInt(0, tamanho);
			int col = ThreadLocalRandom.current().nextInt(0, tamanho);
			int dado = ThreadLocalRandom.current().nextInt(1, 10);

			// confere se ainda não foi preenchido e insere o dado, adiciona no contador;
			if(matrizEstatica.getElem(row,col) == 0){
				matrizEstatica.insereElem(row,col,dado);
				esparsidade--;
			}
		}
	}

	public static void testarEstatica(int tamanho){

		MatrizEstatica matrizEstatica = new MatrizEstatica(tamanho);

		long t0, t1, somaTempos = 0;

		for (int i = 0; i < 10; i++) {
			matrizEstatica = new MatrizEstatica(tamanho);
			t0 = System.currentTimeMillis();
			gerarMatrizEstatica(matrizEstatica);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoGerar = somaTempos / 10;

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.imprime();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoImprimir = somaTempos / 10;

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			int elem = ThreadLocalRandom.current().nextInt(1, 10);
			t0 = System.currentTimeMillis();
			matrizEstatica.buscaElem(elem);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoBuscar = somaTempos / 10;

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.ehVazia();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoVerificaVazia = somaTempos / 10;

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.ehDiagonal();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoVerificaDiagonal = somaTempos / 10;

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.ehMatrizColuna();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoVerificaColuna = somaTempos / 10;

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.ehMatrizLinha();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoVerificaLinha = somaTempos / 10;

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.ehMatrizTriangSup();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoTriangSup = somaTempos / 10;

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.ehMatrizTriangInf();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoTriangInf = somaTempos / 10;

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			int row = ThreadLocalRandom.current().nextInt(0, tamanho);
			int col = ThreadLocalRandom.current().nextInt(0, tamanho);
			t0 = System.currentTimeMillis();
			matrizEstatica.getElem(row, col);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoAcessarPosicao = somaTempos / 10;

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.obtemTransposta();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoTransposta = somaTempos / 10;

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.ehSimetrica();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoVerificaSimetria = somaTempos / 10;
		//subtrair no relatorio o tempo para gerar a transposta.

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			int row = ThreadLocalRandom.current().nextInt(0, tamanho);
			int col = ThreadLocalRandom.current().nextInt(0, tamanho);
			t0 = System.currentTimeMillis();
			matrizEstatica.insereElem(row, col,1);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoInserir = somaTempos / 10;

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			int row = ThreadLocalRandom.current().nextInt(0, tamanho);
			int col = ThreadLocalRandom.current().nextInt(0, tamanho);
			t0 = System.currentTimeMillis();
			matrizEstatica.removeElem(row, col);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoRemover = somaTempos / 10;

		MatrizEstatica aux = new MatrizEstatica(tamanho);
		gerarMatrizEstatica(aux);

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.somaMatriz(aux);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoSoma = somaTempos / 10;

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.multiplicaMatriz(aux);
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoMultiplicacao = somaTempos / 10;

		aux = null;

		somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			t0 = System.currentTimeMillis();
			matrizEstatica.imprimeVazia();
			t1 = System.currentTimeMillis();
			somaTempos += (t1 - t0);
		}
		long tempoEsvazia = somaTempos / 10;

		System.out.println("MATRIZ ESTATICA TAM=" + matrizEstatica.getTam());
		System.out.println("Tempo gerar:" + tempoGerar);
		System.out.println("Tempo remove: " + tempoRemover);
		System.out.println("Tempo insere: " + tempoInserir);
		System.out.println("Tempo get: " + tempoBuscar);
		System.out.println("Tempo confereVazia: " + tempoVerificaVazia);
		System.out.println("Tempo confereDiagonal: " + tempoVerificaDiagonal);
		System.out.println("Tempo confereColuna: " + tempoVerificaColuna);
		System.out.println("Tempo confereLinha: " + tempoVerificaLinha);
		System.out.println("Tempo confereTrianguloSuperior: " + tempoTriangSup);
		System.out.println("Tempo confereTrianguloInferior: " + tempoTriangInf);
		System.out.println("Tempo verificarSimetria: " + tempoVerificaSimetria);
		System.out.println("Tempo soma: " + tempoSoma);
		System.out.println("Tempo multiplicação: " + tempoMultiplicacao);
		System.out.println("Tempo transposta: " + tempoTransposta);
		System.out.println("Tempo acessar posicao: " + tempoAcessarPosicao);
		System.out.println("Tempo imprimir: " + tempoImprimir);
		System.out.println("Tempo esvaziar: " + tempoEsvazia);
	}

/*
	public static void testarLista(int tamanho){
		MatrizListas matriz = new MatrizListas(tamanho);
		long t0;
		long t1;
		long tempoProcessamento = 0;

		t0 = System.currentTimeMillis();
		gerarMatrizListas(matriz);
		t1 = System.currentTimeMillis();
		long tempo = t1-t0;


		int i;
		int x = 0;

		long tempoProcessamento14 = 0;

		t0 = System.currentTimeMillis();
		matriz.imprime();
		t1 = System.currentTimeMillis();
		tempoProcessamento14 += t1-t0;



		long tempoProcessamento0 = 0;

		t0 = System.currentTimeMillis();
		matriz.removeElem(tamanho-1,tamanho - 1);
		t1  = System.currentTimeMillis();
		tempoProcessamento0 += t1 - t0;




		long tempoProcessamento1 = 0;

		t0 = System.currentTimeMillis();
		matriz.insereElem(tamanho-1,tamanho - 1,1);
		t1  = System.currentTimeMillis();
		tempoProcessamento1 += t1 - t0;




		long tempoProcessamento2 = 0;

		t0 = System.currentTimeMillis();
		x += matriz.getElemento(tamanho-1,tamanho-1);
		t1  = System.currentTimeMillis();
		tempoProcessamento2 += t1 - t0;




        long tempoProcessamento3 = 0;

		t0 = System.currentTimeMillis();
		if(matriz.confereVazia()){
			x++;
		}
		t1  = System.currentTimeMillis();
		tempoProcessamento3 += t1 - t0;




        long tempoProcessamento4 = 0;

            t0 = System.currentTimeMillis();
            if(matriz.confereDiagonal()){
               x++;
            }
            t1  = System.currentTimeMillis();
            tempoProcessamento4 += t1 - t0;




        long tempoProcessamento5 = 0;

            t0 = System.currentTimeMillis();
            if(matriz.confereColuna()){
                x++;
            }
            t1  = System.currentTimeMillis();
            tempoProcessamento5 += t1 - t0;




        long tempoProcessamento6 = 0;

           t0 = System.currentTimeMillis();
            if(matriz.confereLinha()){
                x++;
            }
            t1  = System.currentTimeMillis();
            tempoProcessamento6 = t1 - t0;



        long tempoProcessamento7 = 0;
            t0 = System.currentTimeMillis();
            if(matriz.confereTrianguloSuperior()){
                x++;
            }
            t1  = System.currentTimeMillis();
            tempoProcessamento7 += t1 - t0;



       long tempoProcessamento8 = 0;

            t0 = System.currentTimeMillis();
            if(matriz.confereTrianguloInferior()){
                x++;
            }
            t1  = System.currentTimeMillis();
            tempoProcessamento8 += t1 - t0;


        long tempoProcessamento9 = 0;

            t0 = System.currentTimeMillis();
            if(matriz.verificarSimetria()){
                x++;
            }
            t1  = System.currentTimeMillis();
            tempoProcessamento9 += t1 - t0;


        long tempoProcessamento10 = 0;

            t0 = System.currentTimeMillis();
            matriz.somarMatriz(matriz);
            t1  = System.currentTimeMillis();
            tempoProcessamento10 += t1 - t0;


		long tempoProcessamento11 = 0;
		MatrizLista matrizmulti;

		matrizmulti = matriz;
		t0 = System.currentTimeMillis();
		matrizmulti.multiplicarMatriz(matriz);
		t1  = System.currentTimeMillis();
		tempoProcessamento11 += t1 - t0;


        long tempoProcessamento12 = 0;

            t0 = System.currentTimeMillis();
            matriz = matriz.matrizTransposta();
            t1  = System.currentTimeMillis();
            tempoProcessamento12 += t1 - t0;



        long tempoProcessamento13 = 0;
        t0 = System.currentTimeMillis();
        matriz.esvaziarMatriz();
        t1  = System.currentTimeMillis();
        tempoProcessamento13 = t1 - t0;

		System.out.println();
        System.out.println("Tempo gerar:" + tempo);
        System.out.println("Tempo remove: " + tempoProcessamento0);
        System.out.println("Tempo insere: " + tempoProcessamento1);
        System.out.println("Tempo get: " + tempoProcessamento2);
        System.out.println("Tempo confereVazia: " + tempoProcessamento3);
        System.out.println("Tempo confereDiagonal: " + tempoProcessamento4);
        System.out.println("Tempo confereColuna: " + tempoProcessamento5);
        System.out.println("Tempo confereLinha: " + tempoProcessamento6);
        System.out.println("Tempo confereTrianguloSuperior: " + tempoProcessamento7);
        System.out.println("Tempo confereTrianguloInferior: " + tempoProcessamento8);
        System.out.println("Tempo verificarSimetria: " + tempoProcessamento9);
        System.out.println("Tempo soma: " + tempoProcessamento10);
		System.out.println("Tempo multiplicação: " + tempoProcessamento11);
        System.out.println("Tempo transposta: " + tempoProcessamento12);
        System.out.println("Tempo esvaziar: " + tempoProcessamento13);
        System.out.println("Tempo imprimir: " + tempoProcessamento14);
	}

 */
}


		

