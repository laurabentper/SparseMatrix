package Estruturas;

public interface MatrizEsparsa {
    boolean insereElem(int row, int col, int valor);
    boolean removeElem(int elem); // remove pela posição ou pelo valor?
    boolean buscaElem(int elem);
    void imprime();
    void imprimeVazia();
    boolean ehVazia();
    boolean ehDiagonal();
    boolean ehMatrizLinha();
    boolean ehMatrizColuna();
    boolean ehMatrizTriangInf();
    boolean ehMatrizTriangSup();
    boolean ehSimetrica(MatrizEsparsa e);
    MatrizEsparsa somaMatriz(MatrizEsparsa e);
    MatrizEsparsa multiplicaMatriz(MatrizEsparsa e);
    MatrizEsparsa obtemTransposta(MatrizEsparsa e);
}

