package Estruturas;

public class MatrizEstatica implements MatrizEsparsa {

    private int linhas;
    private int colunas;
    private int[][] matriz;

    public MatrizEstatica(int linhas, int colunas) {
        if(setLinhas(linhas) && setColunas(colunas)) {
        	matriz = new int[linhas][colunas];
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
        if(row >= linhas || col >= colunas){
            System.out.println("Erro ao inserir na matriz. Índice inválido.");
            return false;
        }
        matriz[row][col] = valor;
        return true;
    }

    
    public boolean removeElem(int row, int col) {
    	if(row >= linhas || col >= colunas) {
    		System.out.println("Erro ao remover elemento da matriz. Índice inválido.");
            return false;
    	}
    	matriz[row][col] = 0;
        return true;
    }
    
    public boolean removeElem(int valor) {
    	if(buscaElem(valor)) {
    		for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    if (matriz[i][j] == valor) {
                    	matriz[i][j] = 0;
                        return true;
                    }
                }
            }
    	}
    	
        return false;
    }

    @Override
    public boolean buscaElem(int elem) { 
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (matriz[i][j] == elem) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void imprime() {
    	for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.print('\n');
        }
    	 System.out.print('\n');
    }

    @Override
    public void imprimeVazia() {
    	for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                insereElem(i, j, 0);
            }
        }
    	imprime();
    }

    @Override
    public boolean ehVazia() {
    	for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if(matriz[i][j] != 0) {
                	return false;
                }
            }
        }
    	
        return true;
    }

    @Override
    public boolean ehDiagonal() {
    	for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
            	if(i != j) {
            		if(matriz[i][j] != 0) {
                    	return false;
                    }
            	}
            }
        }
    	
        return true;
    }

    @Override
    public boolean ehMatrizLinha() {
        if(linhas == 1) {
        	return true;
        }
        return false;
    }

    @Override
    public boolean ehMatrizColuna() {
    	if(colunas == 1) {
    		return true;
    	}
    	
        return false;
    }

    @Override
    public boolean ehMatrizTriangInf() {
    	for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
            	if(i < j) {
            		if(matriz[i][j] != 0) {
            			return false;
            		} 
                }
            }
        }	
        return true;
    	
    }

    @Override
    public boolean ehMatrizTriangSup() {
    	for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
            	if(i > j) {
            		if(matriz[i][j] != 0) {
            			return false;
            		} 
                }
            }
        }	
        return true;
    }

    @Override
    public boolean ehSimetrica(MatrizEsparsa e) {
    	MatrizEstatica matriz = (MatrizEstatica) e;
    	MatrizEstatica matrizTransposta = (MatrizEstatica) matriz.obtemTransposta(e);
    	for(int i = 0; i < matriz.linhas; i++) {
    		for(int j = 0; i < matriz.colunas; j++) {
    			if(matriz.matriz[i][j] != matrizTransposta.matriz[i][j]) {
    				return false;
    			}
    		}
    	}
    	
        return true;
    }

    @Override
    public MatrizEsparsa somaMatriz(MatrizEsparsa e) {
    	MatrizEstatica matriz = (MatrizEstatica) e;
    	if(this.getLinhas() != matriz.getLinhas() || this.getColunas() != matriz.getColunas()) {
    		System.out.print("Erro: Matrizes não possuem índices iguais, não é possível realizar a soma");
    		return null;
    	}
    	MatrizEstatica matrizSoma = new MatrizEstatica(matriz.getLinhas(), matriz.getColunas());
    	for(int i = 0; i < matriz.getLinhas(); i++) {
    		for(int j = 0; j < matriz.getColunas(); j++) {
    			matrizSoma.insereElem(i, j, matriz.matriz[i][j] + this.matriz[i][j]);
    		}
    	}
    	
    	return matrizSoma;
        
    }

    @Override
    public MatrizEsparsa multiplicaMatriz(MatrizEsparsa e) {
    	MatrizEstatica matriz = (MatrizEstatica) e;
    	if(this.getColunas() != matriz.getLinhas()) {
    		System.out.print("Erro: Não é possível realizar o produto das raízes, o número de colunas da primeira matriz não é igual ao número de linhas da segunda matriz");
    		return null;
    	}
    	MatrizEstatica matrizMult = new MatrizEstatica(this.getLinhas(), matriz.getColunas());
    	int valor;
    	for(int i = 0; i < matrizMult.getLinhas(); i++) {
    		for(int j = 0; j < matrizMult.getColunas(); j++) {
    			valor = 0;
    			for(int k = 0; k < this.getColunas(); k++) {
    				valor += this.matriz[i][k] * matriz.matriz[k][j]; 
    			}
    			matrizMult.insereElem(i, j, valor);
    		}
    	}
    	return matrizMult;
    }

    @Override
    public MatrizEsparsa obtemTransposta(MatrizEsparsa e) {
    	if (!(e instanceof MatrizEstatica)) {
            throw new IllegalArgumentException("Erro: a matriz fornecida não é do tipo MatrizEstatica.");
        }
    	
    	MatrizEstatica matriz = (MatrizEstatica) e;
    	MatrizEstatica matrizTransposta = new MatrizEstatica(matriz.getColunas(), matriz.getLinhas());
    	
    	for(int i = 0; i < matriz.getLinhas(); i++) {
    		for(int j = 0; j < matriz.getColunas(); j++) {
    			matrizTransposta.insereElem(j, i, matriz.matriz[i][j]);
    		}
    	}
    	
    	
    	
        return matrizTransposta;
    }
}
