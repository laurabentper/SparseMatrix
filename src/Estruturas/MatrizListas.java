package Estruturas;

public class MatrizListas implements MatrizEsparsa{
	private int linhas;
    private int colunas;
    private Lista[] matriz;
   
    

    public MatrizListas(int linhas, int colunas){
        if(setLinhas(linhas) && setColunas(colunas)){
        	 matriz = new Lista[linhas];
        }
    }
    
    
    public boolean setLinhas(int linhas) {
    	if(linhas > 0) {
    		this.linhas = linhas;
    		return true;
    	}
    	return false;
    }
    public boolean setColunas(int colunas) {
    	if(colunas > 0) {
    		this.colunas = colunas;
    		return true;
    	}
    	return false;
    }
    
    public int getLinhas(){
    	return linhas;
    }
    
    public int getColunas() {
    	return colunas;
    }
    
    @Override
    public boolean insereElem(int row, int col, int valor) {
    	if((valor != 0) && (row > 0 && row < this.getLinhas() && col < this.getColunas())) {
    		if(matriz[row] == null) {
    			matriz[row] = new Lista();
    		}
    		matriz[row].insere(col);
    		matriz[row].insere(valor);
    		return true;
    		
    	}
        return false;
    }

    @Override
    public boolean removeElem(int elem) {
    	
        return false;
    }
    
    public boolean removeElem(int row, int col) {
    	
        return true;
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
    public MatrizEsparsa multiplicaMatriz(MatrizEsparsa e) {
        return null;
    }

    @Override
    public MatrizEsparsa obtemTransposta(MatrizEsparsa e) {
        return null;
    }
}
