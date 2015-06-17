public class FilaEncadeada <Tipo> 
{
      private NodoFila <Tipo> inicio;
      private NodoFila <Tipo> fim;
      
      public FilaEncadeada()
      {
    	  inicio = null; 
    	  fim = null;
      }
      
      public void insereElemento(Tipo elemento)
      {
    	  NodoFila <Tipo> nodo = new NodoFila<Tipo>(elemento);
    	  if(inicio == null)
    		  inicio = nodo;
    	  else
    	  {
    		  fim.setProximo(nodo);
    	  }
    	  fim = nodo;    	  
      }
      
      public Tipo retiraElemento() 
      {
              if( inicio == null )         // está vazia
                      return null;
              else
              {
                    NodoFila<Tipo> nodo = inicio;               
                    if (inicio == fim)    // tem apenas um elemento
                    {
                           inicio = null;
                           fim = null;
                    }
                    else 
                    {
                           inicio = inicio.getProximo();
                           
                     } 
                    return nodo.getElemento();
              }
              

      }
      
      public boolean vazia()
      {
    	  return inicio==null;
      }
}
