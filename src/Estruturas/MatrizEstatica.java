package Estruturas;

public class MatrizEstatica implements MatrizEsparsa {

    private int tam;
    private int[][] matriz;

    public MatrizEstatica(int tam) {
        this.tam = tam;
        matriz = new int[tam][tam];
    }

    @Override
    public boolean insereElem(int row, int col, int valor) {
        if(row >= tam || col >= tam){
            System.out.println("Erro ao inserir na matriz. Índice inválido.");
            return false;
        }
        matriz[row][col] = valor;
        return true;
    }

    @Override
    public boolean removeElem() {
        return false;
    }

    @Override
    public boolean buscaElem(int elem) {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (matriz[i][j] == elem) {
                    return true;
                }
            }
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
        return false;
    }

    @Override
    public boolean ehDiagonal() {
        return false;
    }

    @Override
    public boolean ehMatrizLinha() {
        return false;
    }

    @Override
    public boolean ehMatrizColuna() {
        return false;
    }

    @Override
    public boolean ehMatrizTriangInf() {
        return false;
    }

    @Override
    public boolean ehMatrizTriangSup() {
        return false;
    }

    @Override
    public boolean ehSimetrica(MatrizEsparsa e) {
        return false;
    }

    @Override
    public MatrizEsparsa somaMatriz(MatrizEsparsa e) {
        return null;
    }

    @Override
    public int multiplicaMatriz(MatrizEsparsa e) {
        return 0;
    }

    @Override
    public MatrizEsparsa obtemTransposta(MatrizEsparsa e) {
        return null;
    }
}
