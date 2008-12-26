package dominio;

import java.util.LinkedList;

/**
 * Classe que representa o tabuleiro de um jogo de domino.
 * 
 * @author Gustavo Farias
 */
public class Tabuleiro {

	private LinkedList<Peca> pecasJogadas;

	private static Tabuleiro tabuleiro = null;
	
	public static Tabuleiro getInstance(){
		if(tabuleiro == null)
			return new Tabuleiro();
		
		return tabuleiro;
	}
	
	public Tabuleiro(){
		this.pecasJogadas = new LinkedList<Peca>();
	}
	
	public LinkedList<Peca> getPecasJogadas() {
		return pecasJogadas;
	}
	
	public boolean adicionaPecaEsquerdaTabuleiro(Peca peca){
		if(podeAddEsquerda(peca)){
			pecasJogadas.addFirst(peca);
			return true;
		} else
			return false;

	}

	public boolean adicionaPecaDireitaTabuleiro(Peca peca){
		if(podeAddDireita(peca)){
			pecasJogadas.addLast(peca);
			return true;
		} else
			return false;

	}

	private boolean podeAddEsquerda(Peca peca) {
		
		if(tabuleiroVazio() || pecasJogadas.getFirst().getLadoEsquerdo() == peca.getLadoDireito())
			return true;
		
		if(pecasJogadas.getFirst().getLadoEsquerdo() == peca.getLadoEsquerdo()){
			invertePeca(peca);
			return true;
		}
		
		return false;
	}
	
	private boolean podeAddDireita(Peca peca) {
		
		if(tabuleiroVazio() || pecasJogadas.getFirst().getLadoDireito() == peca.getLadoEsquerdo())
			return true;
		
		if(pecasJogadas.getFirst().getLadoDireito() == peca.getLadoDireito()){
			invertePeca(peca);
			return true;
		}
		
		return false;
	}

	public void reset() {
		this.pecasJogadas.clear();
	}
	
	private boolean tabuleiroVazio(){
		return this.pecasJogadas.size() == 0;
	}
	
	private void invertePeca(Peca peca) {
		int aux = peca.getLadoEsquerdo();
		peca.setLadoEsquerdo(peca.getLadoDireito());
		peca.setLadoDireito(aux);
	}
	
	public String toString(){
		String out = "";
		
		for (int i = 0; i < pecasJogadas.size(); i++) {
			out += pecasJogadas.get(i).toString() + " ";
		}
		
		return out;
	}
	
}
