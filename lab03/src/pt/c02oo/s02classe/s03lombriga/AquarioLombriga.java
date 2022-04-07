package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	int tam_aquario;
    int tam_lombriga;
    int pos_inicial;
    String aquario = "";
    
    AquarioLombriga(int tam_aquario, int tam_lombriga, int pos_inicial) {
        this.tam_aquario = tam_aquario;
        if (tam_lombriga > tam_aquario) {
        	tam_lombriga = tam_aquario;
        }
        this.tam_lombriga = tam_lombriga;
        if (pos_inicial < 0 || pos_inicial + tam_lombriga - 1 > tam_aquario) {
        	pos_inicial = 1;
        }
        this.pos_inicial = pos_inicial;
        iniciar();
    }
    
    void iniciar() {
        for (int i = 1; i <= tam_aquario; i++) {
            if (i == pos_inicial) {
                aquario += "O";
            }
            else if (pos_inicial < i && i < pos_inicial + tam_lombriga) {
                aquario += "@";
            }
            else {
                aquario += "#";
            }
        }
    }
    
    void virar() {
    	String novo = "";
    	int i, j;
    	for (i = 0; i < aquario.length(); i++) {
    		if (aquario.charAt(i) == 'O') {
    			for (j = i; j < i + tam_lombriga - 1; j++) {
    				novo += '@';
    			}
    			novo += 'O';
    			i = j;
    		}
    		else if (aquario.charAt(i) == '@') {
    			novo += 'O';
    			for (j = i+1; j < i + tam_lombriga; j++) {
    				novo += '@';
    			}
    			i = j-1;
    		}
    		else {
    			novo += aquario.charAt(i);
    		}
    	}
    	aquario = novo;
    }
    
    void crescer() {
    	String novo = "";
        int cresceu = 0;
        int fim = aquario.length();
        if (aquario.charAt(0) != '@' && aquario.charAt(aquario.length() - 1) != '@') {
        	for (int i = 0; i < aquario.length(); i++) {
            	if (aquario.charAt(i) == 'O' && cresceu == 0) {
                    novo += aquario.charAt(i);
                    fim = i + tam_lombriga;
                    if (fim >= aquario.length()) {
                    	fim = aquario.length();
                    }
                    cresceu = 1;
                }
                else if (i+1 < aquario.length() && aquario.charAt(i+1) == '@' && i >= 0 && cresceu == 0) {
                	novo += '@';
                    cresceu = 1;
                }
                else {
                	if (i == fim) {
                		novo += '@';
                	}
                	else {
                		novo += aquario.charAt(i);
                	}
                }
            }
        	tam_lombriga++;
        	aquario = novo;
        }
    }
    
    void mover() {
    	String novo = "";
    	int i, j, moveu = 0;
    	if (aquario.charAt(0) != 'O' && aquario.charAt(aquario.length() - 1) != 'O') {
    		for (i = 0; i < aquario.length(); i++) {
    			if (aquario.charAt(i) == '@' && moveu == 0) {
    				novo += '#';
    				for (j = i+1; j < i + tam_lombriga; j++) {
        				novo += '@';
        			}
    				novo += 'O';
    				moveu = 1;
    				i = j;
    			}
    			else if (i+1 < aquario.length() && aquario.charAt(i+1) == 'O' && moveu == 0) {
        			novo += 'O';
        			for (j = i+1; j < i + tam_lombriga; j++) {
        				novo += '@';
        			}
        			moveu = 1;
        			i = j-1;
        		}
    			else {
    				novo += "#";
    			}
        	}
    		aquario = novo;
    	}
    	else {
    		virar();
    	}
    }

    String apresenta() {
    	return aquario;
    }
}