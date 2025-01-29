package Estruturas;

public interface MatrizEsparsa {
    boolean insereElem(int row, int col, int valor);
    boolean removeElem(int row, int col);
    boolean buscaElem(int elem);
    void imprime();
    void imprimeVazia();
    boolean ehVazia();
    boolean ehDiagonal();
    boolean ehMatrizLinha();
    boolean ehMatrizColuna();
    boolean ehMatrizTriangInf();
    boolean ehMatrizTriangSup();
    boolean ehSimetrica();
    MatrizEsparsa somaMatriz(MatrizEsparsa e);
    MatrizEsparsa multiplicaMatriz(MatrizEsparsa e);
    MatrizEsparsa obtemTransposta();
    int getElem(int row, int col);
    void esvazia();
}

