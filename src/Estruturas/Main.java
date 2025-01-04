package Estruturas;

public class Main {

	public static void main(String[] args) {
		MatrizEstatica m = new MatrizEstatica(2, 2);
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
		
		
		
		
		System.out.println("Matriz");
		m.imprime();
		
		if(m.ehDiagonal()) {
			System.out.println("Matriz Diagonal");
		}
		else {
			System.out.println("A Matriz não é diagonal\n");
		}
		
		
		System.out.println("Matriz Transposta");
		MatrizEstatica transp = (MatrizEstatica) m.obtemTransposta(m);
		transp.imprime();
		

		System.out.println("Segunda Matriz");
		m2.imprime();
		
		System.out.println("Soma entre as matrizes");
		MatrizEstatica soma = (MatrizEstatica) m.somaMatriz(m2);
		soma.imprime();
		
		
		System.out.println("Multiplicação entre as matrizes");
		MatrizEstatica mult = (MatrizEstatica) m.multiplicaMatriz(m2);
		mult.imprime();
		
		
		
	}

}
