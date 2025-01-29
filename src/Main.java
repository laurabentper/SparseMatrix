import Estruturas.MatrizEsparsa;
import Estruturas.MatrizEstatica;
import Estruturas.MatrizListas;

public class Main {

	public static void main(String[] args) {
		MatrizEstatica m = new MatrizEstatica(2);
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


	}

}





		

