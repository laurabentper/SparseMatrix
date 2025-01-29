package Estruturas;

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

        public int getCol() {
            return col;
        }

        public int getElem() {
            return elem;
        }

        public Elo getProx() {
            return prox;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public void setElem(int elem) {
            this.elem = elem;
        }

        public void setProx(Elo prox) {
            this.prox = prox;
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


    @Override
    public boolean ehMatrizTriangInf() {
        for (int i = 0; i < tam; i++) {
            Elo p = matriz[i];

            while (p != null) {
                if (p.col > i) {
                    return false;
                }
                p = p.prox;
            }
        }
        return true;
    }


    @Override
    public boolean ehMatrizTriangSup() {
        for (int i = 0; i < tam; i++) {
            Elo p = matriz[i];

            while (p != null) {
                if (p.col < i) {
                    return false;
                }
                p = p.prox;
            }
        }
        return true;
    }

    @Override
    public boolean ehSimetrica() {
        for (int i = 0; i < tam; i++) {
            Elo p = matriz[i];

            while (p != null) {
                int j = p.col;

                if (!existeElemento(j, i, p.elem)) {
                    return false;
                }
                p = p.prox;
            }
        }
        return true;
    }

    private boolean existeElemento(int row, int col, int elem) {
        Elo p = matriz[row];
        while (p != null) {
            if (p.col == col && p.elem == elem) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    @Override
    public MatrizEsparsa somaMatriz(MatrizEsparsa e) {
        return null;
    }

    @Override
    public MatrizEsparsa multiplicaMatriz(MatrizEsparsa e) {
        return null;
    }

    @Override
    public MatrizEsparsa obtemTransposta() {
        return null;
    }

}
