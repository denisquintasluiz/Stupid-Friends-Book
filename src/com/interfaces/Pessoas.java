/**
 * 
 */
package com.interfaces;

/**
 * @author Denis Quintas Luiz
 *
 */
public interface Pessoas {
	
	public boolean existeAcao(String descricao);
	
	public void adAcao(String descricao);
	
	public void vota(String descricao,boolean bomparaPessoa, boolean bomParaOutros);
	
	public String getNome();
	
	public int getPersonalidade();
	
	public double getAborrecimento();

}
