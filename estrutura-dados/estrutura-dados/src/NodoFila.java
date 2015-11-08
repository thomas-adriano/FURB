
public class NodoFila <Tipo> 
{
	private Tipo elemento;
	private NodoFila<Tipo> proximo;
		
	public NodoFila(Tipo elemento) 
	{
		this.elemento = elemento;
	}

	public NodoFila<Tipo> getProximo() 
	{
		return proximo;
	}
	
	public void setProximo(NodoFila<Tipo> proximo) 
	{
		this.proximo = proximo;
	}
	
	public Tipo getElemento() 
	{
		return elemento;
	}
}
