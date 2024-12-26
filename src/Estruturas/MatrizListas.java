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
        return false;
    }

    @Override
    public boolean removeElem() {
        return false;
    }

    @Override
    public boolean buscaElem(int elem) {
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
