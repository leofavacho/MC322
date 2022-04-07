package pt.c02oo.s02classe.s03lombriga;

/*import lombriga.Animacao;
import lombriga.AquarioLombriga;*/

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int l = 0; l < lombrigas.length; l++)
         System.out.println(lombrigas[l]);
      
      for(int l = 0; l < lombrigas.length; l++) {
    	  String animacao = lombrigas[l];
          String str1 = "", str2 = "", str3 = "";
    		
          str1 = str1 + animacao.charAt(0) + animacao.charAt(1);
          str2 = str2 + animacao.charAt(2) + animacao.charAt(3);
          str3 = str3 + animacao.charAt(4) + animacao.charAt(5);
    		
          int tam_aquario = Integer.parseInt(str1);
          int tam_lombriga = Integer.parseInt(str2);
          int pos_inicial = Integer.parseInt(str3);
    		
          AquarioLombriga aq1 = new AquarioLombriga(tam_aquario, tam_lombriga, pos_inicial);
          Animacao animacao1 = new Animacao(animacao);
    		
          animacao1.conecta(aq1);
          
          tk.gravaPasso("=====");
          tk.gravaPasso(aq1.apresenta());
          
          for (int i = 6; i < animacao.length(); i++) {
        	  animacao1.passo(animacao.charAt(i));
        	  tk.gravaPasso(aq1.apresenta());
          }
      }
      
      tk.stop();
   }

}