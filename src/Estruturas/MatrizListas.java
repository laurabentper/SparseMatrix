package Estruturas;

public class MatrizListas implements MatrizEsparsa{
    private int tam;
    private Lista[] matriz;

    public MatrizListas(int tam){
        this.tam = tam;
        matriz = new Lista[tam];
    }

    @Override
    public boolean insereElem(int row, int col, int valor) {
    	if(row < tam && col < tam) {
            System.out.println("Erro ao inserir na matriz. Índice inválido.");
            return false;
    	}

        matriz[row].insere(col, valor);
        return true;
    }

    @Override
    public boolean removeElem(int row, int col) {
        if(row < tam && col < tam) {
            System.out.println("Erro ao remover na matriz. Índice inválido.");
            return false;
        }

        return matriz[row].remove(col);
    }

    @Override
    public boolean buscaElem(int elem) {
        for (int i = 0; i < tam; i++) {
            if(matriz[i].busca(elem))
                return true;
        }
        return false;
    }

    @Override
    public void imprime() {

    }

    @Override
    public void imprimeVazia() {
    }

    @Override
    public boolean ehVazia() {
        for (int i = 0; i < tam; i++) {
            if(!matriz[i].vazia())
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
