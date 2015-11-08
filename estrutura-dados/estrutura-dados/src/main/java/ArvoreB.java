import java.io.IOException;

public class ArvoreB {
	private int raiz;
	private Arquivo arquivoArvore;
	private int ordem;
	
	public void setRaiz(int r)
	{
		this.raiz = r;
	}
    public ArvoreB(int ordem, String nome) throws IOException
    {
    	arquivoArvore = new Arquivo(nome);
    	raiz = -1;
    	this.ordem = ordem;
    }

	private NodoAuxiliar localizaNodoR(int r, int chave) throws IOException 
    {
        if ( r > -1)     
        {//  lendo o nodo
        	NodoAuxiliar nAux = arquivoArvore.leitura(r, ordem);
        	NodoArvoreB nodoB = nAux.getR();
        	if(nodoB.getnSubArvores() == 0)   // não tem filhos
            
                return nAux;        
            else
            {
        	    for(int i=nodoB.getnChaves()-1; i >= 0; i--)
        	    {
        		    if(chave >= nodoB.getChaveI(i))       // maior que a chave i está no i+1
        		    {
        		    	        		      
        			    return localizaNodoR(nodoB.getFilhoI(i+1), chave);
        		    }
        			
             	}
        	  
        	    return localizaNodoR(nodoB.getFilhoI(0), chave);
            }
        }
        return null;
	}

	private NodoAuxiliar leNodo(int i) throws IOException
	{
		return arquivoArvore.leitura(i, ordem);
	}
	
	public boolean insereArvoreB(int chave) throws IOException
	{
		if( raiz == -1)
		{
			System.out.println("Pasou\n");
			NodoArvoreB nodo = new NodoArvoreB(ordem*2);
			nodo.insereChave(chave);
			NodoAuxiliar nAux = new NodoAuxiliar(0, nodo);
			arquivoArvore.gravaArquivo(nAux, 3);
			raiz = 0;
			return true;
		}
		else
		{
			if( pesquisaArvoreB(chave) == null)
			{
				System.out.println("nao existe");
				//  lendo nodo raiz  ??
				NodoAuxiliar nAux = localizaNodoR(raiz, chave);
				NodoArvoreB nodo = nAux.getR();
				if( nodo.getnChaves() == ordem*2)  // tem que particionar
				{
					 //????????  gerar um novo array com a nova chave
					// a posicão de nAux fica a raiz e gera dois novos
					System.out.println("tem que particionar");
				}
					
				else
				{
				   if( nodo.insereChave(chave))
				   {
					   arquivoArvore.gravaArquivo(nAux, ordem);
					   System.out.println("Inseriu\n");
					   return true;
				   }
				   else
				   {					   
				       System.out.println("Não inseriu\n");
					   return false;
				   }
				} 
			
			}
			else
			{
				System.out.println("ja existe");			    
			}
		}
		return false;
	}
	
	public NodoArvoreB pesquisaArvoreB(int chave) throws IOException 
	{
		NodoArvoreB r = pesquisaArvoreBR(raiz, chave);
		return r;
	}

	private NodoArvoreB pesquisaArvoreBR(int r, int chave) throws IOException 
	{  System.out.println("Pesquisa\n");
		if (r > -1) 
		{
			NodoAuxiliar nAux = arquivoArvore.leitura(r, 3);
			NodoArvoreB nodo = nAux.getR();
			for (int i = 0; i < nodo.getnChaves(); i++) 
			{
				if (chave == nodo.getChaveI(i))
					return nodo;
				else {
					if (chave < nodo.getChaveI(i))   // verificar se tem filhos.
					{
						if( nodo.getnSubArvores() > 0)
						    return pesquisaArvoreBR(nodo.getFilhoI(i), chave);
						else
							return null;
					}
				}
			}
			if( nodo.getnSubArvores() == 0)
				return null;
			else
			    return pesquisaArvoreBR(nodo.getFilhoI(nodo.getnChaves()+1), chave);
		} else
			return null;
	}
	public void imprime(NodoArvoreB r)
	{
		if( r != null )
			for(int i=0; i < 4; i++)
				System.out.println(r.getChaveI(i));
		
	}
	public static void main(String[] args) throws IOException
	{
		ArvoreB a = new ArvoreB(3, "c:\\ArvoreNova.bin");
    	a.insereArvoreB(65);
		a.insereArvoreB(95);
		a.insereArvoreB(68);
		a.insereArvoreB(97);
		a.insereArvoreB(66);
		a.insereArvoreB(110);
		a.insereArvoreB(111);
	//	a.imprime(a.raiz);
		
	}
}
