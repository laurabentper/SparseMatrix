import Estruturas.MatrizEsparsa;
import Estruturas.MatrizEstatica;
import Estruturas.MatrizListas;

public class Main {

		public static void main(String[] m3) {
		MatrizListas m2 = new MatrizListas(3);
		MatrizListas m33 = new MatrizListas(3);
		MatrizListas m4 = new MatrizListas(3);

			m2.insereElem(0, 0, 1);
			m2.insereElem(1, 0, 2);
			m2.insereElem(1, 1, 3);
			m2.insereElem(2, 0, 4);
			m2.insereElem(2, 1, 5);
			m2.insereElem(2, 2, 6);


			m33.insereElem(0, 0, 1);
			m33.insereElem(0, 1, 2);
			m33.insereElem(1, 0, 4);
			m33.insereElem(0, 2, 3);
			m33.insereElem(1, 1, 4);
			m33.insereElem(1, 2, 5);
			m33.insereElem(2, 2, 6);

			m4.insereElem(0, 0, 1);
			m4.insereElem(0, 1, 2);
			m4.insereElem(0, 2, 3);
			m4.insereElem(1, 0, 2);
			m4.insereElem(1, 1, 4);
			m4.insereElem(1, 2, 5);
			m4.insereElem(2, 0, 3);
			m4.insereElem(2, 1, 5);
			m4.insereElem(2, 2, 6);
			if(m4.ehSimetrica()){
				System.out.println("É simetricaa");
			}
			else
				System.out.println("naoooo");
		

		
	}

}
