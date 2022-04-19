package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	Peca tab[][];
	
	public Tabuleiro() {
		tab = new Peca[7][7];
	}

	public void insere(char[][] tabuleiro) {
		for(int i = 0; i < tabuleiro.length; i++) {
			for(int j = 0; j < tabuleiro[i].length; j++) {
				tab[i][j] = new Peca();
			}
		}
		for(int i = 0; i < tabuleiro.length; i++) {
			for(int j = 0; j < tabuleiro[i].length; j++) {
				if ((0 <= i && i < tab.length) && (2 <= j && j <= 4) || (2 <= i && i <= 4) && (0 <= j && j < tab[i].length)) {
					tab[i][j].insere_peca(tab, j, i, tabuleiro[i][j]);
				}
			}
		}
	}
	
	public void move_peca(String comando) {
		String com_sep[], linha_ini = "", linha_fim = "";
		Peca removida;
		
		int coluna_ini, coluna_fim, linha_ini_aux, linha_fim_aux;
		com_sep = comando.split(":");
		coluna_ini = com_sep[0].charAt(0) - 97;
		linha_ini = linha_ini + com_sep[0].charAt(1);
		linha_ini_aux = Integer.parseInt(linha_ini) - 1;
		coluna_fim = com_sep[1].charAt(0) - 97;
		linha_fim = linha_fim + com_sep[1].charAt(1);
		linha_fim_aux = Integer.parseInt(linha_fim) - 1;
		
		if (((0 <= linha_ini_aux && linha_ini_aux < 7 && 2 <= coluna_ini && coluna_ini <= 4) || (0 <= coluna_ini && coluna_ini < 7 && 2 <= linha_ini_aux && linha_ini_aux <= 4)) 
				&& ((0 <= linha_fim_aux && linha_fim_aux < 7 && 2 <= coluna_fim && coluna_fim <= 4) || (0 <= coluna_fim && coluna_fim < 7 && 2 <= linha_fim_aux && linha_fim_aux <= 4))) {
			removida = tab[linha_ini_aux][coluna_ini].move(coluna_fim, linha_fim_aux);
			if (removida != null) {
				tab[linha_ini_aux][coluna_ini].existe = false;
				tab[linha_fim_aux][coluna_fim].existe = true;
				removida.existe = false;
			}
		}
	}
}