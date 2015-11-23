
public class NodoArvore 
{
     private int info;
     private boolean marca;
     private NodoArvore esquerda;
     private NodoArvore direita;
     
     
     public NodoArvore(int info)
     {
    	 this.info = info;
    	 this.esquerda = null;
    	 this.direita = null;
     }

     public void setMarca(boolean marca)
     {
    	 this.marca = marca;
     }
     
     public boolean getMarca()
     {
    	 return marca;
     }
     
	public NodoArvore getEsquerda() 
	{
		return esquerda;
	}


	public void setEsquerda(NodoArvore esquerda) 
	{
		this.esquerda = esquerda;
	}


	public NodoArvore getDireita() 
	{
		return direita;
	}


	public void setDireita(NodoArvore direita) 
	{
		this.direita = direita;
	}


	public int getInfo() 
	{
		return info;
	}
     
}
