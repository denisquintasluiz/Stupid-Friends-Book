/**
 * 
 */
package com.classes;

import com.interfaces.Pessoas;
import com.interfaces.StupidFriendBooks;
import com.classes.Pessoa;

/**
 * @author Denis Quintas Luiz
 *
 */
public class StupidFriendBook implements StupidFriendBooks  {

	private static final int DEFAULT =10;
	private Pessoa[] amigo; 
	private int contador; 
	private int actual; 
	private int tipo;
	private Pessoa manager;

	public StupidFriendBook() {
		amigo= new Pessoa[DEFAULT];
		contador=0;
		actual=0;
		tipo= -1;
		manager=new Pessoa();
	}
	@Override
	public void reset() {
		Pessoa[] aux= new Pessoa[1*this.amigo.length];
		this.amigo=aux;
		this.contador=0;
	}
	@Override
	public boolean existeAmigo(String nome) {
		for(int i=0;i<contador;i++) {
			if(nome.equals(amigo[i].getNome())) {
				return true;
			}
		}
		return false;
	}
	@Override
	public void adAmigo(String nome) {
		Pessoa person=new Pessoa(nome);
		if(existeAmigo(nome)) {
			//não faz nada
		}
		else {
			if(estCheio()) {
				redimensionar();
			}
			else {
				this.amigo[this.contador]=person;
				this.contador++;
			}
		}
	}
	@Override
	public void removAmigo(String nome){
		if(existeAmigo(nome)){
			int posicao=indice(nome);
			for(int i=posicao;i<=contador-1;i++) {
				this.amigo[i]=this.amigo[i+1];
			}
			contador--;
		}
	}
	@Override
	public boolean existeAcao(String nome, String descricao) {
		if(existeAmigo(nome) && manager.existeAcao(descricao)) {
			return true;
		}
		return false;
	}
	@Override
	public void adAcao(String nome, String descricao) {
		if(existeAmigo(nome)&& (!(existeAcao(nome, descricao)))) {
			manager.adAcao(descricao);
		}
	}
	@Override
	public void vota(String nome, String descricao, boolean bomParaPessoa, boolean bomParaOutros) {
		if(existeAmigo(nome) && existeAcao(nome, descricao)) {
			manager.vota(descricao, bomParaPessoa, bomParaOutros);
		}
	}
	@Override
	public int numDeAmigos() {
		return this.contador;
	}
	@Override
	public String amigoMaisAborrecido() {
		String mAborecido=null;
		int j=0;
		if(numDeAmigos()>0) {
			for(int i=1;i<contador;i++) {
				if(this.amigo[j].getAborrecimento()<this.amigo[i].getAborrecimento()) {
					j=i;
					mAborecido=this.amigo[i].getNome();
				}
				else {
					mAborecido=this.amigo[j].getNome();
				}
			}
			
		}
		return mAborecido;
	}
	@Override
	public void inicializar(int tipo) {
		this.actual=0;
		this.tipo=tipo;
		searchNext();
	}
	private void searchNext() {
		while (this.actual<this.contador && amigo[actual].getPersonalidade()!=this.tipo)
			actual++;
	}
	@Override
	public boolean temProximo() {
		return actual<contador;
	}
	@Override
	public Pessoas proximo() {
		Pessoa res=amigo[actual++];
		searchNext();
		return res;
	}
	// Métodos auxiliares
	public int indice(String nome){
		for(int i=0;i<contador;i++) {
			if(nome.equals(amigo[i].getNome())){
				return i;
			}
		}
		return -1;
	}
	private void redimensionar(){
		Pessoa[] aux=new Pessoa[2*amigo.length];
		if(contador==this.amigo.length) {
			for(int i=0;i<contador;i++) {
				aux[i]=this.amigo[i];
			}
			this.amigo=aux;
		}
	}
	public boolean estCheio() {
		return contador>=this.amigo.length;
	}
	//metodo criado para testes.
	public void mostrarPessoa() {
		for(int i=0;i<contador;i++ ) {
			System.out.println(this.amigo[i].getNome());
		}
	}

}
