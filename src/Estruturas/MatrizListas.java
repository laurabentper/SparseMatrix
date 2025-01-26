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

    @Override
    public void imprime() {
        Elo p;
        for(int i=0; i<tam; i++) {
            for(p = matriz[i]; p != null; p = p.prox)
            {
                System.out.print(p.dado + " ");
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
            if(!matriz[i].contemApenas(i))
                return false;
        }
        return true;
    }

    @Override
    public boolean ehMatrizLinha() {
        int countLinhas = 0;
        for (int i = 0; i < tam; i++) {
            if(!matriz[i].vazia())
                countLinhas++;
            if (countLinhas > 1) return false;
        }
        return countLinhas == 1;
    }

    @Override
    public boolean ehMatrizColuna() {
       return false;
    }

    @Override
    public boolean ehMatrizTriangInf() {
        for (int i = 0; i < tam; i++) {
            if(matriz[i].contemMaiorQue(i)) return false;
        }
        return true;
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
