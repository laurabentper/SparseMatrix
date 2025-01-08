import Estruturas.MatrizEsparsa;
import Estruturas.MatrizEstatica;

public class Main {

	public static void main(String[] args) {
		MatrizEstatica m = new MatrizEstatica(3);
		m.insereElem(0, 0, 1);
		m.insereElem(0, 1, 2);
		m.insereElem(1, 0, 3);
		m.insereElem(1, 1, 4);
		m.imprime();
		
		m.insereElem(0, 0, 1);
		m.removeElem(0, 1);
		m.imprime();
		m.insereElem(0, 1, 2);
		
		m.imprime();
		
		MatrizEstatica m2 = new MatrizEstatica(3);
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
		MatrizEsparsa transp = m.obtemTransposta();
		transp.imprime();

		System.out.println("Matriz m");
		m.imprime();
		System.out.println("Segunda Matriz");
		m2.imprime();
		
		System.out.println("Soma entre as matrizes");
		MatrizEstatica soma = m.somaMatriz(m2);
		soma.imprime();
		
		
		System.out.println("Multiplicação entre as matrizes");
		MatrizEstatica mult = m.multiplicaMatriz(m2);
		mult.imprime();
		
	}

}
