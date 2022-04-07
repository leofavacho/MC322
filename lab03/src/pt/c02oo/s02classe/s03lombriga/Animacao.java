package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	String animacao;
	AquarioLombriga aquario;
	
	Animacao(String animacao) {
		this.animacao = animacao;
	}
	
	void apresenta() {
		aquario.apresenta();
	}
	
	void conecta(AquarioLombriga aquario) {
		this.aquario = aquario;
	}
	
	void passo(char acao) {
		if (acao == 'M') {
			aquario.mover();
		}
		else if (acao == 'C') {
			aquario.crescer();
		}
		else {
			aquario.virar();
		}
	}
}