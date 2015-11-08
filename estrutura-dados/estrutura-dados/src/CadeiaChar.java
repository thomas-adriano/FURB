public class CadeiaChar
{
   private char cadeia[];
   private int posicao;
   private int tamanho;
   
   
   public CadeiaChar(String cadeia)
   {
        this.tamanho = cadeia.length();
        this.cadeia = new char[tamanho];
        this.posicao = 0;       
        for (int i = 0; i < tamanho; i++)
           setProximoChar(cadeia.charAt(i));
       this.posicao = 0;
   }
   
   public void setPosicao(int i)
   {
      this.posicao = i;
   }
   public void setTamanho(int tamanho)
   {
      this.tamanho = tamanho;
   }
   
   public int getTamanho()
   {
       return this.tamanho;
   }
   public char getProximoChar()
   {
      return this.cadeia[posicao++];
   }
   
   public void setProximoChar(char c)
   {
      this.cadeia[posicao++] = c;
   }

}

