package Estruturas;

public class Main {

	public static void main(String[] args) {
		/*MatrizEstatica m = new MatrizEstatica(2, 2);
		m.insereElem(0, 0, 1);
		m.insereElem(0, 1, 2);
		m.insereElem(1, 0, 3);
		m.insereElem(1, 1, 4);
		m.imprime();
		
		m.removeElem(1);
		m.imprime();
		
		m.insereElem(0, 0, 1);
		m.removeElem(0, 1);
		m.imprime();
		m.insereElem(0, 1, 2);
		
		m.imprime();
		
		MatrizEstatica m2 = new MatrizEstatica(2, 2);
		m2.insereElem(0, 0, 2);
		m2.insereElem(0, 1, 5);
		m2.insereElem(1, 0, 6);
		m2.insereElem(1, 1, 3);
		
		MatrizEstatica m3 = new MatrizEstatica(3, 3);
		m3.insereElem(0, 0, 4);
		m3.insereElem(0, 1, 3);
		m3.insereElem(0, 2, 1);
		m3.insereElem(1, 0, 0);
		m3.insereElem(1, 1, 2);
		m3.insereElem(1, 2, 5);
		m3.insereElem(2, 0, 0);
		m3.insereElem(2, 1, 0);
		m3.insereElem(2, 2, 1);
		
		System.out.println("Matriz 3x3");
		m3.imprime();
		
		if(m3.ehMatrizTriangSup()) {
			System.out.println("É uma matriz Triangular Superior");
		}
		else {
			System.out.println("Não é uma matriz Triangular Superior\n");
		}
		
		
		
		System.out.println("Matriz");
		m.imprime();
		
		if(m.ehDiagonal()) {
			System.out.println("Matriz Diagonal");
		}
		else {
			System.out.println("A Matriz não é diagonal\n");
		}
		
		
		System.out.println("Matriz Transposta");
		MatrizEstatica transp = (MatrizEstatica) m.obtemTransposta();
		transp.imprime();
		

		System.out.println("Segunda Matriz");
		m2.imprime();
		
		System.out.println("Soma entre as matrizes");
		MatrizEstatica soma = (MatrizEstatica) m.somaMatriz(m2);
		soma.imprime();
		
		
		System.out.println("Multiplicação entre as matrizes");
		MatrizEstatica mult = (MatrizEstatica) m.multiplicaMatriz(m2);
		mult.imprime();
		
		MatrizListas matrizLista = new MatrizListas(2,2);
		matrizLista.insereElem(0, 0, 1);
		matrizLista.insereElem(0, 1, 2);
		matrizLista.insereElem(1, 0, 3);
		matrizLista.insereElem(1, 1, 4);
		
		
		matrizLista.imprime();
		
		System.out.println("Multiplicação de Matrizes com Listas Encadeadas");
		MatrizListas p = (MatrizListas) matrizLista.multiplicaMatriz(matrizLista);
		p.imprime();
		
		MatrizListas transposta = new MatrizListas(2,2);
		transposta = (MatrizListas) matrizLista.obtemTransposta();
		transposta.imprime();
		
		/*matrizLista.removeElem(0, 1);
		matrizLista.imprime();
		
		MatrizListas matrizLista2 = new MatrizListas(2,2);
		matrizLista2.imprimeVazia();
		*/
		System.out.println("Primeira Matriz com Listas Encadeadas");
		MatrizListas ex1 = new MatrizListas(2);
		ex1.insereElem(0, 0, 1);
		ex1.insereElem(0, 1, 2);
		ex1.insereElem(1, 0, 3);
		ex1.insereElem(1, 1, 4);
		
		ex1.imprime();
		
		System.out.println("Segunda Matriz com Listas Encadeadas");
		MatrizListas ex2 = new MatrizListas(2);
		ex2.insereElem(0, 0, 15);
		ex2.insereElem(0, 1, 8);
		ex2.insereElem(1, 0, 5);
		ex2.insereElem(1, 1, 6);
		
		
		ex2.imprime();
		
		System.out.println("Soma das Matrizes com Listas Encadeadas");
		MatrizListas s = (MatrizListas) ex1.somaMatriz(ex2);
		s.imprime();
		
		System.out.println("Multiplicação das Matrizes com Listas Encadeadas");
		MatrizListas mult = (MatrizListas) ex1.multiplicaMatriz(ex2);
		mult.imprime();
		
		MatrizListas transposta = (MatrizListas) ex2.obtemTransposta();
		transposta.imprime();
		
		
		
	}

}
