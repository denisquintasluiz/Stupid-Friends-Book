/**
 * 
 */
package com.interfaces;

/**
 * @author Denis Quintas Luiz
 *
 */
public interface Acao {

	public void vota(boolean bomPraPessoa, boolean bomParaOutros);

	public String getDescricao();

	public int getBeneficioProprio();

	public int getBenefiocioParaOutros();
}
