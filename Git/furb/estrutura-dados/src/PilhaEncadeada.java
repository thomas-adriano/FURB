public class PilhaEncadeada <Tipo>
{
     private NodoPilha<Tipo> topo;
     private NodoPilha<Tipo> base;
	
    public PilhaEncadeada() 
	{
		this.topo = null;
		this.base = null;
	}
    
    public void empilha(Tipo elemento)
    {
    	NodoPilha<Tipo> nodo = new NodoPilha<Tipo>(elemento);
    	if( topo == null)
    		base = nodo;
    	else
    		nodo.setAnterior(topo);
    	topo = nodo;
    }
     
    public Tipo desempilha()
    {
    	if( topo == null)
    		return null;
    	else
    	{
    		NodoPilha<Tipo> nodo = topo;
    		if( topo == base )       /* tem apenas um elemento */
    		{
    			topo = null;
    			base = null;
    		}
    		else
    		    topo = topo.getAnterior();
    		return nodo.getElemento();
    	}
    }
    public boolean vazia()
    {
    	return topo == null;
    }
}
