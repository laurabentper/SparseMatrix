import Estruturas.MatrizEstatica;
import Estruturas.MatrizListas;

import java.util.concurrent.ThreadLocalRandom;

public class Main {


	public static void main(String[] args) {

		testarEstatica(10000);

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

			// confere se ainda não foi preenchido e insere o dado
			if(matrizEstatica.getElem(row,col) == 0){
				matrizEstatica.insereElem(row,col,dado);
				esparsidade--;
			}
		}
	}

	public static void testarEstatica(int tamanho){

		MatrizEstatica matrizEstatica = new MatrizEstatica(tamanho);

		int testes = 1;
		long t1, t0, somaTempos = 0;

		/*for (int i = 0; i < testes; i++) {

			matrizEstatica.esvazia();

			long t0, t1;

			t0 = System.currentTimeMillis();
			gerarMatrizEstatica(matrizEstatica);
			t1 = System.currentTimeMillis();
			tempos[0] += (t1 - t0);

			t0 = System.currentTimeMillis();
			matrizEstatica.imprime();
			t1 = System.currentTimeMillis();
			tempos[1] += (t1 - t0);

			int elem = ThreadLocalRandom.current().nextInt(1, 10);
			t0 = System.currentTimeMillis();
			matrizEstatica.buscaElem(elem);
			t1 = System.currentTimeMillis();
			tempos[2] += (t1 - t0);

			t0 = System.currentTimeMillis();
			matrizEstatica.ehVazia();
			t1 = System.currentTimeMillis();
			tempos[3] += (t1 - t0);

			t0 = System.currentTimeMillis();
			matrizEstatica.ehDiagonal();
			t1 = System.currentTimeMillis();
			tempos[4] += (t1 - t0);

			t0 = System.currentTimeMillis();
			matrizEstatica.ehMatrizColuna();
			t1 = System.currentTimeMillis();
			tempos[5] += (t1 - t0);

			t0 = System.currentTimeMillis();
			matrizEstatica.ehMatrizLinha();
			t1 = System.currentTimeMillis();
			tempos[6] += (t1 - t0);

			t0 = System.currentTimeMillis();
			matrizEstatica.ehMatrizTriangSup();
			t1 = System.currentTimeMillis();
			tempos[7] += (t1 - t0);

			t0 = System.currentTimeMillis();
			matrizEstatica.ehMatrizTriangInf();
			t1 = System.currentTimeMillis();
			tempos[8] += (t1 - t0);

			int row = ThreadLocalRandom.current().nextInt(0, tamanho);
			int col = ThreadLocalRandom.current().nextInt(0, tamanho);
			t0 = System.currentTimeMillis();
			matrizEstatica.getElem(row, col);
			t1 = System.currentTimeMillis();
			tempos[9] += (t1 - t0);

			row = ThreadLocalRandom.current().nextInt(0, tamanho);
			col = ThreadLocalRandom.current().nextInt(0, tamanho);
			t0 = System.currentTimeMillis();
			matrizEstatica.insereElem(row, col, 1);
			t1 = System.currentTimeMillis();
			tempos[12] += (t1 - t0);

			row = ThreadLocalRandom.current().nextInt(0, tamanho);
			col = ThreadLocalRandom.current().nextInt(0, tamanho);


			t0 = System.currentTimeMillis();
			matrizEstatica.obtemTransposta();
			t1 = System.currentTimeMillis();
			tempos[10] += (t1 - t0);

			t0 = System.currentTimeMillis();
			matrizEstatica.ehSimetrica();
			t1 = System.currentTimeMillis();
			tempos[11] += (t1 - t0);



			t0 = System.currentTimeMillis();
			matrizEstatica.removeElem(row, col);
			t1 = System.currentTimeMillis();
			tempos[13] += (t1 - t0);

			t0 = System.currentTimeMillis();
			matrizEstatica.somaMatriz(matrizEstatica);
			t1 = System.currentTimeMillis();
			tempos[14] += (t1 - t0);

			t0 = System.currentTimeMillis();
			matrizEstatica.multiplicaMatriz(matrizEstatica);
			t1 = System.currentTimeMillis();
			tempos[15] += (t1 - t0);

			t0 = System.currentTimeMillis();
			matrizEstatica.imprimeVazia();
			t1 = System.currentTimeMillis();
			tempos[16] += (t1 - t0);
		}

		System.out.printf("MATRIZ ESTATICA TAM=%d%n", matrizEstatica.getTam());
		System.out.printf("Tempo gerar: %.5f%n", tempos[0] / 10);
		System.out.printf("Tempo imprimir: %.5f%n", tempos[1] / 10);
		System.out.printf("Tempo buscar elemento: %.5f%n", tempos[2] / 10);
		System.out.printf("Tempo confereVazia: %.5f%n", tempos[3] / 10);
		System.out.printf("Tempo confereDiagonal: %.5f%n", tempos[4] / 10);
		System.out.printf("Tempo confereColuna: %.5f%n", tempos[5] / 10);
		System.out.printf("Tempo confereLinha: %.5f%n", tempos[6] / 10);
		System.out.printf("Tempo confereTrianguloSuperior: %.5f%n", tempos[7] / 10);
		System.out.printf("Tempo confereTrianguloInferior: %.5f%n", tempos[8] / 10);
		System.out.printf("Tempo acessar posicao: %.5f%n", tempos[9] / 10);
		System.out.printf("Tempo transposta: %.5f%n", tempos[10] / 10);
		System.out.printf("Tempo verificarSimetria: %.5f%n", tempos[11] / 10);
		System.out.printf("Tempo inserir: %.5f%n", tempos[12] / 10);
		System.out.printf("Tempo remover: %.5f%n", tempos[13] / 10);
		System.out.printf("Tempo soma: %.5f%n", tempos[14] / 10);
		System.out.printf("Tempo multiplicação: %.5f%n", tempos[15] / 10);
		System.out.printf("Tempo esvaziar: %.5f%n", tempos[16] / 10);
		 */

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


		

