public class NodoPilha <Tipo>
{
      private Tipo elemento;
      private NodoPilha<Tipo> anterior;
                
     public NodoPilha(Tipo elemento) 
     {
		this.elemento = elemento;
		this.anterior = null;
	 }

	 public Tipo getElemento() 
     {
		return elemento;
     }

	public NodoPilha<Tipo> getAnterior() 
	{
		return anterior;
	}

	public void setAnterior(NodoPilha<Tipo> anterior) 
	{
		this.anterior = anterior;
	}
                 
}
