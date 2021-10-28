/**
 * 
 */
package com.interfaces;

/**
 * @author Denis Quintas Luiz
 *
 */
public interface StupidFriendBooks {

	public  int INTELEGENTE=0,ANJINHO=1,BANDIDO=2,ESTUPIDO=3;

	public void reset();
	public boolean existeAmigo(String nome);
	public void adAmigo(String nome);
	public void removAmigo(String nome);
	public boolean existeAcao(String nome, String descricao);
	public void adAcao(String nome, String descricao);
	public void vota(String nome, String descricao,boolean bomParaPessoa,boolean bomParaOutros);
	public int numDeAmigos();
	public String amigoMaisAborrecido();
	public void inicializar(int tipo);
	public boolean temProximo();
	public Pessoas proximo();
}
