package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
      
      System.out.println("=== Primeira Saída");
      char board[][] = {
    		  {' ', ' ', 'P', 'P', 'P', ' ', ' '},
    	      {' ', ' ', 'P', 'P', 'P', ' ', ' '},
    	      {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
    	      {'P', 'P', 'P', '-', 'P', 'P', 'P'},
    	      {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
    	      {' ', ' ', 'P', 'P', 'P', ' ', ' '},
    	      {' ', ' ', 'P', 'P', 'P', ' ', ' '}
      };
      
      Tabuleiro tab1 = new Tabuleiro();
      tab1.insere(board);
      String com_sep[];
      
      tk.writeBoard("Tabuleiro inicial", board);
      
      System.out.println("=== Entrada");
      for (int l = 0; l < commands.length; l++)
         System.out.println(commands[l]);
      
      for (int l = 0; l < commands.length; l++) {
    	  tab1.move_peca(commands[l]);
    	  for(int i = 0; i < tab1.tab.length; i++) {
        	  for(int j = 0; j < tab1.tab[i].length; j++) {
        		  if (tab1.tab[i][j].existe == true) {
        			  board[i][j] = 'P';
        		  }
        		  else if ((0 <= i && i < tab1.tab.length) && (2 <= j && j <= 4) || (2 <= i && i <= 4) && (0 <= j && j < tab1.tab[i].length)) {
        			  board[i][j] = '-';
        		  }
        	  }
          }
    	  com_sep = commands[l].split(":");
    	  tk.writeBoard("source: " + com_sep[0] +"; target: " + com_sep[1], board);
      }
      
      tk.stop();
   }

}
