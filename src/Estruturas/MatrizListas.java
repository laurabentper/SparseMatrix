package Estruturas;

import java.awt.PopupMenu;

public class MatrizListas implements MatrizEsparsa{
    private int tam;
    private Elo[] matriz;

    protected class Elo
    {
        protected int col;
        protected int elem;
        protected Elo prox;

        public Elo(int col, int elem)
        {
            this.col = col;
            this.elem = elem;
            prox = null;
        }

    }

    public MatrizListas(int tam){
        this.tam = tam;
        matriz = new Elo[tam];
    }

    @Override
    public boolean insereElem(int row, int col, int elem) {

    	if(row > tam || col > tam) {
            System.out.println("Erro ao inserir na matriz. Índice inválido.");
            return false;
    	}

        if (elem == 0){
            removeElem(row, col);
            return true;
        }

        Elo p, q;
        Elo ant = null;

        q = new Elo(col, elem);

        for (p = matriz[row]; ((p != null) && (p.col < col)); p = p.prox)
            ant = p;

        if (ant == null)
            matriz[row] = q;
        else
            ant.prox = q;

        q.prox = p;
        return true;
    }

    @Override
    public boolean removeElem(int row, int col) {
        if(row > tam || col > tam) {
            System.out.println("Erro ao remover na matriz. Índice inválido.");
            return false;
        }

        Elo p;
        Elo ant = null;

        for(p = matriz[row]; ((p != null) && (p.col < col)); p = p.prox)
            ant = p;

        if ((p == null) || (p.col != col))
            return false;

        if (p == matriz[row])
            matriz[row] = matriz[row].prox;
        else
            ant.prox = p.prox;

        p = null;

        return true;
    }

    @Override
    public boolean buscaElem(int elem) {
        Elo p;

        for(int i=0; i<tam; i++) {
            for(p = matriz[i]; p != null; p = p.prox) {
                if(p.elem == elem)
                    return true;
            }
        }
        return false;
    }

    //tem que imprimir igual a estatica ou pode ser de outro jeito?
    @Override
    public void imprime() {
        Elo p;
        for(int i=0; i<tam; i++) {
            for(p = matriz[i]; p != null; p = p.prox)
            {
                System.out.print(p.elem + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    @Override
    public void imprimeVazia() {
        Elo p;
        for(int i=0; i<tam; i++) {
            matriz[i] = null;
            System.out.println(matriz[i]);
            System.out.println();
        }
    }

    @Override
    public boolean ehVazia() {
        for (int i = 0; i < tam; i++) {
            if(matriz[i] != null)
                return false;
        }
        return true;
    }

    @Override
    public boolean ehDiagonal() {
        for (int i = 0; i < tam; i++) {
            if(matriz[i] != null && (matriz[i].col != i || matriz[i].prox != null))
                return false;
        }
        return true;
    }

    @Override
    public boolean ehMatrizLinha() {
        int countLinhas = 0;
        for (int i = 0; i < tam; i++) {
            if(matriz[i] != null)
                countLinhas++;
            if (countLinhas > 1) return false;
        }
        return countLinhas == 1;
    }

    @Override
    public boolean ehMatrizColuna() {
        int col = -1, colunaAtual;

    	for (int i = 0; i < tam; i++) {
            if(matriz[i] != null){
                if(matriz[i].prox != null)
                    return false;

                colunaAtual = matriz[i].col;
                if (col == -1) {
                    col = colunaAtual;
                } else if (col != colunaAtual) {
                    return false;
                }
            }
        }
        return !(col == -1);
    }
    /*
    @Override
    public boolean ehMatrizTriangInf() {
        for (int i = 0; i < tam; i++) {
            if(matriz[i].contemMaiorQue(i)) return false;
        }
        return true;

        if(this.vazia()) return false;

        Lista.Elo p;
        for(p = prim; p != null; p = p.prox) {
            if(p.col > row) return true;
        }
        return false;

    }

    @Override
    public boolean ehMatrizTriangSup() {
        for (int i = 0; i < tam; i++) {
            if(matriz[i].contemMenorQue(i)) return false;
        }
        return true;
    }

    @Override
    public boolean ehSimetrica() {
    	MatrizListas transposta = (MatrizListas) this.obtemTransposta();
    	for(int i = 0; i < this.getLinhas(); i++) {
    		for(int j = 0; i < this.getColunas(); j++) {
    			if(this.matriz[i].obterValor(j) != transposta.matriz[i].obterValor(j)) {
    				return false;
    			}
    		}
    	}

        return true;
    }
*/
    @Override
    public MatrizEsparsa somaMatriz(MatrizEsparsa e) {
    	MatrizListas m = (MatrizListas) e;
    	MatrizListas soma = new MatrizListas(this.tam);
    	
    	if(this.tam != m.tam) {
    		System.out.println("Erro: índices diferentes");
    	}
    	
    	for(int i = 0; i < tam; i++) {
    		Elo p = this.matriz[i];
    		Elo p2 = m.matriz[i];
    		
    		while(p != null || p2 != null) {
    			if(p != null && (p2 == null || p.col < p2.col)) {
    				soma.insereElem(i, p.col, p.elem);
    				p = p.prox;
    			}
    			else if(p2 != null && (p == null || p2.col < p.col)) {
    				soma.insereElem(i, p2.col, p2.elem);
    				p2 = p2.prox;
    			}
    			else {
    				soma.insereElem(i, p.col, p.elem+ p2.elem);
    				p = p.prox;
    				p2 = p2.prox;
    				
    			}
    		}
    		
    	}
    	
        return soma;
    }
    

    @Override
    public MatrizEsparsa multiplicaMatriz(MatrizEsparsa e) {
    	MatrizListas segundaMatriz = (MatrizListas) e;

    	if(this.tam != segundaMatriz.tam) {
    		System.out.println("Erro: índices diferentes");
    	}
    	
    	MatrizListas produto = new MatrizListas(tam);
    	for(int i = 0; i < tam; i++) {
        	for(int j = 0; j < tam; j++) {
        		int valor = 0;
        		Elo p = this.matriz[i];
        		for (int k = 0; k < tam; k++) {
                    Elo p2 = segundaMatriz.matriz[k];
                    while (p2 != null && p2.col < j) {
                        p2 = p2.prox; 
                    }
                    if (p2 != null && p2.col == j) {
                        Elo p1 = this.matriz[i];
                        while (p1 != null && p1.col < k) {
                            p1 = p1.prox; 
                        }
                        if (p1 != null && p1.col == k) {
                            valor += p1.elem * p2.elem;
                        }
                    }
                }
        			
               if(valor != 0) {
        		produto.insereElem(i, j, valor);
        	    }
        			
        	}
        }
    		
    	return produto;
    }
    

    @Override
    public MatrizEsparsa obtemTransposta() {

    	MatrizListas matrizTransposta = new MatrizListas(tam);

    	for(int i = 0; i < tam; i++) {
    		Elo p = this.matriz[i];
    		while(p != null) {
    			matrizTransposta.insereElem(p.col, i, p.elem);
    			p = p.prox;
    		}

    	}

        return matrizTransposta;

    }

    /* METODOS IMPROVISADOS DA ANTIGA CLASSE LISTA
    public boolean contemApenas(int col){
		if (this.vazia()) return true;
        return prim.col == col && prim.prox == null;
    }

	public boolean contemMaiorQue(int row){
		if(this.vazia()) return false;

		Elo p;
		for(p = prim; p != null; p = p.prox) {
			if(p.col > row) return true;
		}
		return false;
	}

	public boolean contemMenorQue(int row){
		if(this.vazia()) return false;
		return prim.col < row;
	}

	public void preencherLinha(int[] linha) {
		Elo p = prim;
		while(p != null && p.prox != null) {
			int valor = p.dado;
			int coluna = p.prox.dado;
			if(coluna >= 0 && coluna < linha.length) {
				linha[coluna] = valor;
			}

			p = p.prox.prox;
		}
	}

	public int obterValor(int col) {
		Elo p = prim;
		while(p != null && p.prox != null) {
			int valor = p.dado;
			int coluna = p.prox.dado;
			if(coluna == col) {
				return valor;
			}

			p = p.prox.prox;
		}
		return 0;
	}
     */
}
