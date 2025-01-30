package Estruturas;


public class Main {

	public static void main(String[] args) {
		//Criação da primeira matriz estática
				MatrizEstatica m = new MatrizEstatica(10);
				for (int i = 0; i < 10; i++) {
				    for (int j = 0; j < 10; j++) {
				        m.insereElem(i, j, i * 10 + j + 1);//inserção de elementos na matriz
				    }
				}
				System.out.println("Primeira matriz");
				m.imprime();//Resultado da matriz
				
				m.removeElem(0, 9); // Primeira Linha Décima Coluna (remove 10)
				m.removeElem(5, 4); // Sexta linha Quinta Coluna (remove 55)
				
				
				System.out.println("Primeira matriz com elementos removidos");
				m.imprime();
				
				
				System.out.println("Primeira matriz é vazia?");
				if(m.ehVazia()) {//verifica se ela está vazia
					System.out.println("Matriz vazia");
				}
				else {
					System.out.println("Não é uma matriz vazia");
				}
				
				System.out.println("Primeira matriz é simétrica?");
				if(m.ehSimetrica()) {
					System.out.println("Matriz simétrica");
				}
				else {
					System.out.println("Não é uma matriz simétrica");
				}
				
				System.out.println();
				System.out.println("Segunda Matriz");
				MatrizEstatica matriz = new MatrizEstatica(10); //matriz vazia
				matriz.imprime();
				System.out.println("Segunda Matriz está vazia?");
				if(matriz.ehVazia()) {
					System.out.println("Matriz vazia");
				}
				else {
					System.out.println("Não é uma matriz vazia");
				}
				
				System.out.println();
				System.out.println("Inserindo elementos na matriz que estava vazia");
				matriz.insereElem(0, 0, 1);
				matriz.insereElem(1, 1, 2);
				matriz.insereElem(3, 3, 3);
				matriz.insereElem(5, 5, 4);
				matriz.insereElem(7, 7, 5);
				matriz.imprime();
				System.out.println("Representando a matriz vazia");
				matriz.imprimeVazia();
				
				System.out.println("Segunda matriz é uma matriz diagonal?");
				if(matriz.ehDiagonal()) {
					System.out.println("Matriz diagonal");
				}
				else {
					System.out.println("Não é uma matriz diagonal");
				}
				
				
				
				System.out.println("Primeira matriz é uma matriz diagonal?");
				if(m.ehDiagonal()) {
					System.out.println("Matriz diagonal");
				}
				else {
					System.out.println("Não é uma matriz diagonal");
				}
				System.out.println();
				
				System.out.println("Terceira matriz");
			
				
				MatrizEstatica matrizLinha = new MatrizEstatica(10);
				matrizLinha.insereElem(6, 0, 40);
				matrizLinha.insereElem(6, 1, 23);
				matrizLinha.insereElem(6, 4, 3);
				matrizLinha.insereElem(6, 7, 123);
				matrizLinha.insereElem(6, 8, 5);
				matrizLinha.imprime();
				
				System.out.println("Terceira matriz é uma matriz linha?");
				if(matrizLinha.ehMatrizLinha()) {
					System.out.println("Matriz linha");
				}
				else {
					System.out.println("Não é uma matriz linha");
				}
				
				System.out.println("Terceira matriz é uma matriz coluna?");
				if(matrizLinha.ehMatrizColuna()) {
					System.out.println("Matriz coluna");
				}
				else {
					System.out.println("Não é uma matriz coluna");
				}
				
				System.out.println();
				System.out.println("Outro exemplo");
				MatrizEstatica matrizColuna = new MatrizEstatica(10);
				matrizColuna.insereElem(1, 0, 40);
				matrizColuna.insereElem(2, 0, 23);
				matrizColuna.insereElem(3, 0, 12);
				matrizColuna.insereElem(5, 0, 3);
				matrizColuna.insereElem(6, 0, 123);
				matrizColuna.insereElem(8, 0, 5);
				matrizColuna.imprime();
				if(matrizColuna.ehMatrizColuna()) {
					System.out.println("Matriz coluna");
				}
				else {
					System.out.println("Não é uma matriz coluna");
				}
				
				
				System.out.println("Quarta matriz");
				MatrizEstatica m2 = new MatrizEstatica(10);
				for (int i = 0; i < 10; i++) {
				    for (int j = 0; j <= i; j++) { 
				        m2.insereElem(i, j, i * 10 + j + 1); // Exemplo de valores
				    }
				}
				m2.imprime();
				
				System.out.println("Quarta matriz é uma matriz triangular inferior?");
				if(m2.ehMatrizTriangInf()) {
					System.out.println("É uma Matriz triangular inferior");
				}
				else {
					System.out.println("Não é uma matriz triangular inferior");
				}
				
				System.out.println("Quarta matriz é uma matriz triangular superior?");
				if(m2.ehMatrizTriangSup()) {
					System.out.println("É uma Matriz triangular superior");
				}
				else {
					System.out.println("Não é uma matriz triangular superior");
				}
				
				System.out.println();
				System.out.println("Quinta matriz");
				MatrizEstatica m3 = new MatrizEstatica(10);
				for (int i = 0; i < 10; i++) {
				    for (int j = i; j < 10; j++) { 
				        m3.insereElem(i, j, i * 10 + j + 1); 
				    }
				}
				
				System.out.println("Quinta matriz é uma matriz triangular inferior?");
				if(m3.ehMatrizTriangInf()) {
					System.out.println("É uma Matriz triangular inferior");
				}
				else {
					System.out.println("Não é uma matriz triangular inferior");
				}
				
				System.out.println("Quinta matriz é uma matriz triangular superior?");
				if(m3.ehMatrizTriangSup()) {
					System.out.println("É uma Matriz triangular superior");
				}
				else {
					System.out.println("Não é uma matriz triangular superior");
				}
				System.out.println();
				MatrizEstatica m4 = new MatrizEstatica(4);
				System.out.println("Matriz 4x4");
				m4.insereElem(0, 0, 1);
				m4.insereElem(0, 1, 2);
				m4.insereElem(0, 2, 3);
				m4.insereElem(0, 3, 4);

				m4.insereElem(1, 0, 2);
				m4.insereElem(1, 1, 5);
				m4.insereElem(1, 2, 6);
				m4.insereElem(1, 3, 7);

				m4.insereElem(2, 0, 3);
				m4.insereElem(2, 1, 6);
				m4.insereElem(2, 2, 8);
				m4.insereElem(2, 3, 9);

				m4.insereElem(3, 0, 4);
				m4.insereElem(3, 1, 7);
				m4.insereElem(3, 2, 9);
				m4.insereElem(3, 3, 10);
				m4.imprime();
				
				MatrizEstatica transp = m4.obtemTransposta();
				System.out.println("Matriz transposta: ");
				transp.imprime();
				if(m4.ehSimetrica()) {
					System.out.println("É uma Matriz simétrica");
				}
				
				
				//System.out.println("Tamanho da matriz: " + m.getTamanho() + "X" + m.getTamanho());
				//System.out.println("Elemento na posição (1, 1): " + m.getElemento(1, 1));

				int elementoProcurado1 = 2;
				boolean resultado1 = m.buscaElem(elementoProcurado1);
				System.out.println("\nElemento " + elementoProcurado1 + " encontrado? " + resultado1);

				int elementoProcurado2 = 9;
				boolean resultado2 = m.buscaElem(elementoProcurado2);
				System.out.println("\nElemento " + elementoProcurado2 + " encontrado? " + resultado2);


			
				System.out.println("Soma da primeira matriz com ela mesma");
				MatrizEstatica soma = m.somaMatriz(m);
				soma.imprime();


				System.out.println("\nMultiplicação da matriz 4x4 por ela mesma");
				MatrizEstatica mult = m4.multiplicaMatriz(m4);
				mult.imprime();

				
				
				System.out.println("Matriz lista ");
				MatrizListas matrizLista = new MatrizListas(10);
				for (int i = 0; i < 10; i++) {
				    for (int j = 0; j < 10; j++) {
				        matrizLista.insereElem(i, j, i * 10 + j + 1);
				    }
				}
				matrizLista.imprime();
				
				matrizLista.removeElem(0, 0);
				matrizLista.removeElem(0, 1);
				matrizLista.removeElem(0, 2);
				matrizLista.removeElem(0, 3);

				matrizLista.removeElem(1, 0);
				matrizLista.removeElem(1, 1);
				matrizLista.removeElem(1, 2);
				matrizLista.removeElem(1, 3);

				matrizLista.removeElem(2, 0);
				matrizLista.removeElem(2, 1);
				matrizLista.removeElem(2, 2);
				matrizLista.removeElem(2, 3);

				matrizLista.removeElem(3, 0);
				matrizLista.removeElem(3, 1);
				matrizLista.removeElem(3, 2);
				matrizLista.removeElem(3, 3);
				matrizLista.imprime();
				if(matrizLista.ehVazia()) {//verifica se ela está vazia
					System.out.println("Matriz vazia");
				}
				else {
					System.out.println("Não é uma matriz vazia");
				}
				if(matrizLista.ehSimetrica()) {
					System.out.println("Matriz simétrica");
				}
				else {
					System.out.println("Não é uma matriz simétrica");
				}
				
				elementoProcurado1 = 2;
				resultado1 = matrizLista.buscaElem(elementoProcurado1);
				System.out.println("\nElemento " + elementoProcurado1 + " encontrado? " + resultado1);

				elementoProcurado2 = 9;
				resultado2 = matrizLista.buscaElem(elementoProcurado2);
				System.out.println("\nElemento " + elementoProcurado2 + " encontrado? " + resultado2);
				System.out.println();
				
				System.out.println("Representando a matriz lista vazia");
				matrizLista.imprimeVazia();
				
				if(matrizLista.ehVazia()) {//verifica se ela está vazia
					System.out.println("Matriz vazia");
				}
				else {
					System.out.println("Não é uma matriz vazia");
				}
				System.out.println();
				
				for (int i = 0; i < 10; i++) {
				    for (int j = 0; j < 10; j++) {
				        matrizLista.insereElem(i, j, i * 10 + j + 1);
				    }
				}
				
				
				
				MatrizListas matrizTeste = new MatrizListas(10);
				System.out.println("Exemplo de outra matriz lista");
				matrizTeste.insereElem(0, 0, 11);
				matrizTeste.insereElem(1, 1, 2);
				matrizTeste.insereElem(2, 2, 45);
				matrizTeste.insereElem(4, 4, 10);
				matrizTeste.insereElem(3, 3, 9);
				matrizTeste.insereElem(5, 5, 4);
				matrizTeste.insereElem(7, 7, 25);
				matrizTeste.imprime();
				if(matrizTeste.ehDiagonal()) {
					System.out.println("Matriz diagonal");
				}
				else {
					System.out.println("Não é uma matriz diagonal");
				}
				if(matrizTeste.ehMatrizLinha()) {
					System.out.println("Matriz linha");
				}
				else {
					System.out.println("Não é uma matriz linha");
				}
				if(matrizTeste.ehMatrizColuna()) {
					System.out.println("Matriz coluna");
				}
				else {
					System.out.println("Não é uma matriz coluna");
				}
				
				System.out.println();
				System.out.println("Esa matriz é uma matriz linha?");
				MatrizListas matriz2 = new MatrizListas(10);
				matriz2.insereElem(7, 0, 1);
				matriz2.insereElem(7, 1, 10);
				matriz2.insereElem(7, 2, 21);
				matriz2.insereElem(7, 3, 19);
				matriz2.insereElem(7, 4, 6);
				matriz2.insereElem(7, 5, 5);
				matriz2.imprime();
				if(matriz2.ehMatrizLinha()) {
					System.out.println("Matriz linha");
				}
				else {
					System.out.println("Não é uma matriz linha");
				}
				
				System.out.println();
				System.out.println("Esa matriz é uma matriz coluna?");
				MatrizListas matriz3 = new MatrizListas(10);
				matriz3.insereElem(0, 2, 6);
				matriz3.insereElem(1, 2, 14);
				matriz3.insereElem(2, 2, 26);
				matriz3.insereElem(7, 2, 28);
				matriz3.imprime();
				if(matriz3.ehMatrizColuna()) {
					System.out.println("Matriz coluna");
				}
				else {
					System.out.println("Não é uma matriz coluna");
				}
				
				System.out.println();
				System.out.println("Quarta matriz");
				MatrizListas matriz4 = new MatrizListas(10);
				matriz4.insereElem(0, 0, 1);
				matriz4.insereElem(0, 1, 2);
				matriz4.insereElem(0, 2, 3);
				matriz4.insereElem(0, 3, 4);

				matriz4.insereElem(1, 1, 5);
				matriz4.insereElem(1, 2, 6);
				matriz4.insereElem(1, 3, 7);

				matriz4.insereElem(2, 2, 8);
				matriz4.insereElem(2, 3, 9);

				matriz4.insereElem(3, 3, 10);
				matriz4.imprime();
				
				System.out.println("Quarta matriz é uma matriz triangular inferior?");
				if(matriz4.ehMatrizTriangInf()) {
					System.out.println("É uma Matriz triangular inferior");
				}
				else {
					System.out.println("Não é uma matriz triangular inferior");
				}
				
				System.out.println("Quarta matriz é uma matriz triangular superior?");
				if(matriz4.ehMatrizTriangSup()) {
					System.out.println("É uma Matriz triangular superior");
				}
				else {
					System.out.println("Não é uma matriz triangular superior");
				}
				
				System.out.println();
				System.out.println("Quinta matriz");
				MatrizListas matriz5 = new MatrizListas(10);
				matriz5.insereElem(0, 0, 1);

				matriz5.insereElem(1, 0, 2);
				matriz5.insereElem(1, 1, 5);

				matriz5.insereElem(2, 0, 3);
				matriz5.insereElem(2, 1, 6);
				matriz5.insereElem(2, 2, 8);

				matriz5.insereElem(3, 0, 4);
				matriz5.insereElem(3, 1, 7);
				matriz5.insereElem(3, 2, 9);
				matriz5.insereElem(3, 3, 10);
				matriz5.imprime();
				System.out.println("Quinta matriz é uma matriz triangular inferior?");
				if(matriz5.ehMatrizTriangInf()) {
					System.out.println("É uma Matriz triangular inferior");
				}
				else {
					System.out.println("Não é uma matriz triangular inferior");
				}
				
				System.out.println("Quinta matriz é uma matriz triangular superior?");
				if(matriz5.ehMatrizTriangSup()) {
					System.out.println("É uma Matriz triangular superior");
				}
				else {
					System.out.println("Não é uma matriz triangular superior");
				}
				System.out.println();
				System.out.println("Sexta matriz");
				MatrizListas matriz6 = new MatrizListas(10);
				
				matriz6.insereElem(0, 0, 1);
				matriz6.insereElem(0, 1, 2);
				matriz6.insereElem(0, 2, 3);
				matriz6.insereElem(0, 3, 4);

				matriz6.insereElem(1, 0, 2);
				matriz6.insereElem(1, 1, 5);
				matriz6.insereElem(1, 2, 6);
				matriz6.insereElem(1, 3, 7);

				matriz6.insereElem(2, 0, 3);
				matriz6.insereElem(2, 1, 6);
				matriz6.insereElem(2, 2, 8);
				matriz6.insereElem(2, 3, 9);

				matriz6.insereElem(3, 0, 4);
				matriz6.insereElem(3, 1, 7);
				matriz6.insereElem(3, 2, 9);
				matriz6.insereElem(3, 3, 10);
				matriz6.imprime();
				if(matriz6.ehSimetrica()) {
					System.out.println("É uma Matriz Simétrica");
				}
				else {
					System.out.println("Não é uma Matriz Simétrica");
				}
				
			
				System.out.println("Matriz transposta");
				MatrizListas matrizt = (MatrizListas) matriz6.obtemTransposta();
				matrizt.imprime();
				System.out.println("Matriz transposta");
				
				System.out.println();
				System.out.println("Soma da primeira matriz lista com a lista testes");
				MatrizListas soma2 = (MatrizListas) matrizLista.somaMatriz(matrizTeste);
				soma2.imprime();
				System.out.println("Multiplicação da primeira matriz lista com a lista testes");
				MatrizListas mult2 = (MatrizListas) matrizLista.multiplicaMatriz(matrizTeste);
				mult2.imprime();

		
		
		
		/*MatrizEstatica m = new MatrizEstatica(2);
		m.insereElem(0, 0, 1);
		m.insereElem(0, 1, 2);
		m.insereElem(1, 0, 3);
		m.insereElem(1, 1, 4);
		m.imprime();

		MatrizEstatica m2 = new MatrizEstatica(2);
		m2.insereElem(0, 0, 2);
		m2.insereElem(0, 1, 5);
		m2.insereElem(1, 0, 6);
		m2.insereElem(1, 1, 3);

		MatrizEstatica m3 = new MatrizEstatica(3);
		m3.insereElem(0, 0, 4);
		m3.insereElem(0, 1, 3);
		m3.insereElem(0, 2, 1);
		m3.insereElem(1, 0, 0);
		m3.insereElem(1, 1, 2);
		m3.insereElem(1, 2, 5);
		m3.insereElem(2, 0, 0);
		m3.insereElem(2, 1, 0);
		m3.insereElem(2, 2, 1);


		System.out.println("Matriz");
		m.imprime();

		//System.out.println("Tamanho da matriz: " + m.getTamanho() + "X" + m.getTamanho());
		//System.out.println("Elemento na posição (1, 1): " + m.getElemento(1, 1));

		m.removeElem(1,1);
		m.imprime();

		m.insereElem(1,1,7);
		m.imprime();

		System.out.println("Matriz 3\n");
		m3.imprimeVazia();

		if(m.ehVazia()) {
			System.out.println("Matriz 1 e vazia");
		}
		else {
			System.out.println("A Matriz não é vazia\n");
		}

		if(m3.ehVazia()) {
			System.out.println("Matriz 3 e vazia");
		}
		else {
			System.out.println("A Matriz não é vazia\n");
		}

		int elementoProcurado1 = 2;
		boolean resultado1 = m.buscaElem(elementoProcurado1);
		System.out.println("\nElemento " + elementoProcurado1 + " encontrado? " + resultado1);

		int elementoProcurado2 = 9;
		boolean resultado2 = m.buscaElem(elementoProcurado2);
		System.out.println("\nElemento " + elementoProcurado2 + " encontrado? " + resultado2);


		if(m.ehDiagonal()) {
			System.out.println("Matriz Diagonal");
		}
		else {
			System.out.println("A Matriz não é diagonal\n");
		}

		if(m.ehMatrizLinha()) {
			System.out.println("Matriz Linha\n");
		}
		else {
			System.out.println("A Matriz não é matriz linha\n");
		}

		if(m.ehMatrizColuna()) {
			System.out.println("Matriz Coluna\n");
		}
		else {
			System.out.println("A Matriz não é matriz coluna\n");
		}

		if(m.ehMatrizTriangInf()) {
			System.out.println("Matriz triangular inferior\n");
		}
		else {
			System.out.println("A Matriz não é triangular inferior\n");
		}

		if(m.ehMatrizTriangSup()) {
			System.out.println("Matriz triangular superior\n");
		}
		else {
			System.out.println("A Matriz não é triangular superior\n");
		}

		if(m.ehSimetrica()) {
			System.out.println("Matriz Simetrica\n");
		}
		else {
			System.out.println("A Matriz não é simetrica\n");
		}

		System.out.println("Segunda Matriz\n");
		m2.imprime();

		System.out.println("Soma entre as matrizes:");
		MatrizEstatica soma = m.somaMatriz(m2);
		soma.imprime();


		System.out.println("\nMultiplicação entre as matrizes");
		MatrizEstatica mult = m.multiplicaMatriz(m2);
		mult.imprime();

		System.out.println("\nMatriz Transposta");
		MatrizEstatica transp = m.obtemTransposta();
		transp.imprime();
		*/

	}

}
