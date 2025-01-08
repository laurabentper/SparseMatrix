package Estruturas;

public class Lista {

	protected Elo prim;
	
	protected class Elo
	{
		protected int col;
		protected int dado;
		protected Elo prox;
		
		public Elo()
		{
			prox = null;
		}
		
		public Elo(int col, int elem)
		{
			this.col = col;
			dado = elem;
			prox = null;
		}
		
		public Elo(int col, int elem, Elo proxElem)
		{
			this.col = col;
			dado = elem;
			prox = proxElem;
		}
	}
	
	public Lista()
	{
		prim = null;
	}

	public boolean vazia()
	{
		return prim == null;
	}

	public void insere(int col, int elem)
	{
		Elo p, q;
		Elo ant = null;

		q = new Elo(col, elem);

		for (p = prim; ((p != null) && (p.col < col)); p = p.prox)
			ant = p;

		if (ant == null)
			prim = q;
		else
			ant.prox = q;

		q.prox = p;
	}

	public boolean remove(int col)
	{
		Elo p;
		Elo ant = null;

		for(p = prim; ((p != null) && (p.col < col)); p = p.prox)
			ant = p;

		if ((p == null) || (p.col != col))
			return false;

		if (p == prim)
			prim = prim.prox;
		else
			ant.prox = p.prox;

		p = null;

		return true;
	}

	public boolean busca(int elem) {
		Elo p;
		
		for(p = prim; p != null; p = p.prox)
		{
			if(p.dado == elem)
				return true;
		}
		
		return false;
	}

	/*
	 public boolean remove(int col) {
		Elo p;
		Elo ant = null;
		
		for(p = prim; ((p != null) && (p.col != col)); p = p.prox)
			ant = p;

		if (p == null)
			return false;
		
		if (p == prim)
			prim = prim.prox;
		else
			ant.prox = p.prox;

		p = null;
		
		return true;
	}
	*/

	public void imprime()
	{
		Elo p;

		for(p = prim; p != null; p = p.prox)
		{
			System.out.print(p.dado + " ");
		}
		
		System.out.println();
	}

	public boolean contemApenas(int col){
		if (this.vazia()) return true;
        return prim.col == col && prim.prox == null;
    }

	public boolean contemMaiorQue(int row){
		if(this.vazia()) return false;

		Elo p;
		for(p = prim; p != null; p = p.prox) {
			if(p.col > row) return true;
		}
		return false;
	}

	public boolean contemMenorQue(int row){
		if(this.vazia()) return false;
		return prim.col < row;
	}

}
