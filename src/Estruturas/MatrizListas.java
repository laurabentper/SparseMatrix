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
    	if((valor != 0) && (row >= 0 && row < this.getLinhas() && col >= 0 && col < this.getColunas())) {
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
    	for(int i = 0; i < this.getLinhas(); i++) {
    		for(int j = 0; j < this.getColunas(); j++) {
    			if(elem == matriz[i].obterValor(j)) {
    				matriz[i].remove(elem);
    			}
    		}
    		
    	}
    	return false;
    	
       
    }
    
    public boolean removeElem(int row, int col) {
    	if(row >= 0 && row < this.getLinhas() && col >=0 && col < this.getColunas()) {
    		if(matriz[row] == null) {
    			matriz[row] = new Lista();
    		}
    		/*for(int i = 0; i < matriz[row].tamanho(); i+=2) {
    			
    			if(col == matriz[row].prim.prox.dado) {
    				matriz[row].remove(i);
    	    		matriz[row].remove(i);
    	    		return true;
    			}
    			
    		}
    		*/
    		/*int valor;
        	if(valor == matriz[row].obterValor(col)) {
        		matriz[row].remove(valor);
        		return true;
        	}
        
        		
        	}

    	*/
    	}
        return false;
    	
    }

    @Override
    public boolean buscaElem(int elem) {
        return false;
    }

    @Override
    public void imprime() {
    	for(int i = 0; i < this.getLinhas(); i++) {
    		int[] linha = new int[this.getColunas()];
    		
    		if(matriz[i] != null) {
    			matriz[i].preencherLinha(linha);
    		}
    		for (int j = 0; j < linha.length; j++) {
	            System.out.print(linha[j] + " ");
	        }
    		System.out.println();
    	}
    }

    @Override
    public void imprimeVazia() {
    	for(int i = 0; i < this.getLinhas(); i++) {
    		for(int j = 0; i < this.getColunas(); j++) {
    			
    		}
    	}
    }

    @Override
    public boolean ehVazia() {
    	for(int i = 0; i < this.getLinhas(); i++) {
    		for(int j = 0; i < this.getColunas(); j++) {
    				if(this.matriz[i].obterValor(j) != 0) {
    					return false;
    				}
    		}
    	}
    	
        return true;
    }

    @Override
    public boolean ehDiagonal() {
    	for(int i = 0; i < this.getLinhas(); i++) {
    		for(int j = 0; i < this.getColunas(); j++) {
    			if(i != j){
    				if(this.matriz[i].obterValor(j) != 0) {
    					return false;
    				}
    				
    			}
    		}
    	}
    	
        return true;
    }

    @Override
    public boolean ehMatrizLinha() {
    	if(this.getLinhas() == 1) {
    		return true;
    	}
        return false;
    }

    @Override
    public boolean ehMatrizColuna() {
    	if(this.getColunas() == 1) {
    		return true;
    	}
        return false;
    }

    @Override
    public boolean ehMatrizTriangInf() {
    	for(int i = 0; i < this.getLinhas(); i++) {
    		for(int j = 0; i < this.getColunas(); j++) {
    			if(i < j){
    				if(this.matriz[i].obterValor(j) != 0) {
    					return false;
    				}
    				
    			}
    		}
    	}
    	
        return true;
    }

    @Override
    public boolean ehMatrizTriangSup() {
    	for(int i = 0; i < this.getLinhas(); i++) {
    		for(int j = 0; i < this.getColunas(); j++) {
    			if(i > j){
    				if(this.matriz[i].obterValor(j) != 0) {
    					return false;
    				}
    				
    			}
    		}
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

    @Override
    public MatrizEsparsa somaMatriz(MatrizEsparsa e) {
    	MatrizListas segundaMatriz = (MatrizListas) e;
    	
    	if(this.getLinhas() != segundaMatriz.getLinhas() && this.getColunas() != segundaMatriz.getColunas()) {
    		System.out.println("Erro: índices diferentes");
    	}
    	else {
    		MatrizListas soma = new MatrizListas(this.getLinhas(), this.getColunas());
    		for(int i = 0; i < soma.getLinhas(); i++) {
        		for(int j = 0; j < soma.getColunas(); j++) {
        			soma.insereElem(i, j, this.matriz[i].obterValor(j) + segundaMatriz.matriz[i].obterValor(j));
        		}
        	}
    		return soma;
    	}
    	
        return null;
    }

    @Override
    public MatrizEsparsa multiplicaMatriz(MatrizEsparsa e) {
    	MatrizListas segundaMatriz = (MatrizListas) e;
    	
    	if(this.getColunas() != segundaMatriz.getLinhas()) {
    		System.out.println("Erro: índices diferentes");
    	}
    	else {
    		int valor;
    		MatrizListas produto = new MatrizListas(this.getLinhas(), segundaMatriz.getColunas());
    		for(int i = 0; i < produto.getLinhas(); i++) {
        		for(int j = 0; j < produto.getColunas(); j++) {
        			valor = 0;
        			for(int k = 0; k < this.getColunas(); k++) {
        				valor += this.matriz[i].obterValor(k) * segundaMatriz.matriz[k].obterValor(j);
        			}
        			produto.insereElem(i, j, valor);
        		}
        	}
    		return produto;
    	}
    	
        return null;
    }

    @Override
    public MatrizEsparsa obtemTransposta() {
    	
    	MatrizListas matrizTransposta = new MatrizListas(this.getColunas(), this.getLinhas());
    	
    	for(int i = 0; i < this.getLinhas(); i++) {
    		for(int j = 0; j < this.getColunas(); j++) {
    			matrizTransposta.insereElem(j, i, this.matriz[i].obterValor(j));
    		}
    	}
    	
    	
    	
        return matrizTransposta;
    	
    }
}
