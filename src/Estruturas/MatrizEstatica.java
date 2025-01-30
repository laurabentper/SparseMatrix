package Estruturas;

public class MatrizEstatica implements MatrizEsparsa {

    private int tam;
    private int[][] matriz;

    public MatrizEstatica(int n) {
            tam = n;
            matriz = new int[tam][tam];
    }

    @Override
    public int getTam() {
        return tam;
    }

    @Override
    public boolean insereElem(int row, int col, int valor) {
        if(row >= tam || col >= tam){
            System.out.println("Erro ao inserir na matriz. Índice inválido.");
            return false;
        }

        if(matriz[row][col] != 0){
            if(valor != 0) {
                return false;
            }
        }
        matriz[row][col] = valor;
        return true;
    }

    @Override
    public boolean removeElem(int row, int col) {
    	if(row >= tam || col >= tam) {
    		System.out.println("Erro ao remover elemento da matriz. Índice inválido.");
            return false;
    	}

        if(matriz[row][col] == 0)
            return false;
        else  matriz[row][col] = 0;
        return true;
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
    	for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }

    @Override
    public void imprimeVazia() {
    	for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                removeElem(i, j);
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public boolean ehVazia() {
    	for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if(matriz[i][j] != 0) {
                	return false;
                }
            }
        }
    	
        return true;
    }

    @Override
    public boolean ehDiagonal() {
    	for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
            	if(i != j) {
            		if(matriz[i][j] != 0) {
                    	return false;
                    }
            	}
            }
        }
        return true;
    }

    //verificar se so tem elementos em uma linha
    @Override
    public boolean ehMatrizLinha() {
        int countLinhas = 0;

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if(matriz[i][j] != 0) {
                    countLinhas++;
                    break;
                }
            }
            if(countLinhas > 1) return false;
        }
        return countLinhas == 1;
    }

    @Override
    public boolean ehMatrizColuna() {
        int countColunas = 0;

        for (int j = 0; j < tam; j++) {
            for (int i = 0; i < tam; i++) {
                if (matriz[i][j] != 0) {
                    countColunas++;
                    break;
                }
            }
            if (countColunas > 1) return false;
        }
        return countColunas == 1;
    }

    @Override
    public boolean ehMatrizTriangInf() {
    	for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
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
    	for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
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
    public boolean ehSimetrica() {
    	MatrizEstatica matrizTransposta = this.obtemTransposta();

    	for(int i = 0; i < tam; i++) {
    		for(int j = 0; j < tam; j++) {
    			if(matriz[i][j] != matrizTransposta.matriz[i][j]) {
    				return false;
    			}
    		}
    	}
        return true;
    }

    @Override
    public MatrizEstatica somaMatriz(MatrizEsparsa e) {
        if (!(e instanceof MatrizEstatica m2)) throw new IllegalArgumentException("Só é possível somar com outra MatrizEstatica.");

        if(this.tam != m2.tam) {
    		System.out.print("Erro: Matrizes não são da mesma ordem, não é possível realizar a soma");
    		return null;
    	}

    	MatrizEstatica matrizSoma = new MatrizEstatica(tam);

    	for(int i = 0; i < tam; i++) {
    		for(int j = 0; j < tam; j++) {
    			matrizSoma.insereElem(i, j, m2.matriz[i][j] + this.matriz[i][j]);
    		}
    	}

    	return matrizSoma;
    }

    @Override
    public MatrizEstatica multiplicaMatriz(MatrizEsparsa e) {
        if (!(e instanceof MatrizEstatica m2)) throw new IllegalArgumentException("Só é possível multiplicar com outra MatrizEstatica.");

        if(this.tam != m2.tam) {
    		System.out.print("Erro: Não é possível realizar o produto das matrizes, o número de colunas da primeira matriz não é igual ao número de linhas da segunda matriz");
    		return null;
    	}

    	MatrizEstatica matrizMult = new MatrizEstatica(tam);
    	int valor;
    	for(int i = 0; i < tam; i++) {
    		for(int j = 0; j < tam; j++) {
    			valor = 0;
    			for(int k = 0; k < tam; k++) {
    				valor += this.matriz[i][k] * m2.matriz[k][j];
    			}
    			matrizMult.insereElem(i, j, valor);
    		}
    	}
    	return matrizMult;
    }

    @Override
    public MatrizEstatica obtemTransposta() {
    	MatrizEstatica matrizTransposta = new MatrizEstatica(tam);

    	for(int i = 0; i < tam; i++) {
    		for(int j = 0; j < tam; j++) {
                matrizTransposta.matriz[j][i] = matriz[i][j];
    		}
    	}
        return matrizTransposta;
    }

    @Override
    public int getElem(int row, int col) {
        return matriz[row][col];
    }

    @Override
    public void esvazia() {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                matriz[i][j] = 0;
            }
        }
    }

}
