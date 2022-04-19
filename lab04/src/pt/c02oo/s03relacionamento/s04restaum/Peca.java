package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	int coluna;
	int linha;
	boolean existe;
	Peca esq;
	Peca dir;
	Peca cima;
	Peca baixo;
	
	public void insere_peca(Peca tab[][], int coluna, int linha, char caractere) {
		tab[linha][coluna].linha = linha;
		tab[linha][coluna].coluna = coluna;
		if (caractere == 'P') {
			tab[linha][coluna].existe = true;
		}
		if (coluna - 1 > 0)
			tab[linha][coluna].esq = tab[linha][coluna-1];
		if (coluna + 1 < tab[linha].length)
			tab[linha][coluna].dir = tab[linha][coluna+1];
		if (linha - 1 > 0)
			tab[linha][coluna].cima = tab[linha-1][coluna];
		if (linha + 1 < tab.length)
			tab[linha][coluna].baixo = tab[linha+1][coluna];
	}
	
	public Peca move(int coluna_fim, int linha_fim) {
		Peca removida = null;
		
		if (linha == linha_fim && (coluna_fim == coluna - 2 || coluna_fim == coluna + 2)) {
			if (coluna_fim == coluna - 2) {
				if (esq != null && esq.existe == true && esq.esq.existe == false) {
					removida = esq;
				}
			}
			else {
				if (dir != null && dir.existe == true && dir.dir.existe == false) {
					removida = dir;
				}
			}
		}
		else if (coluna == coluna_fim && (linha_fim == linha - 2 || linha_fim == linha + 2)) {
			if (linha_fim == linha - 2) {
				if (cima != null && cima.existe == true && cima.cima.existe == false) {
					removida = cima;
				}
			}
			else {
				if (baixo != null && baixo.existe == true && baixo.baixo.existe == false) {
					removida = baixo;
				}
			}
		}
		return removida;
	}
	
}
