/**
 * 
 */
package com.classes;
import com.interfaces.Acao;
/**
 * @author Denis Quintas Luiz
 *
 */
public class Accao implements Acao{

	private String descricao;
	private int selfBenefitScore;//variavel que controla o beneficio proprio.
	private int otherBenefitScore;//variavel que controla o beneficio para os outros.

	public Accao(String descricao) {
		if(descricao!=null) {
			this.descricao=descricao;
		}
		this.selfBenefitScore=0;
		this.otherBenefitScore=0;
	}
	public Accao() {
		this.selfBenefitScore=0;
		this.otherBenefitScore=0;
	}
	//metodo responsavel pelos votos.
	@Override
	public void vota(boolean bomPraPessoa, boolean bomParaOutros) {
		if(bomPraPessoa)
			this.selfBenefitScore++;
		else
			selfBenefitScore--;
		if(bomParaOutros)
			otherBenefitScore++;
		else
			otherBenefitScore--;
	}

	@Override
	public String getDescricao() {
		return this.descricao;
	}

	@Override
	public int getBeneficioProprio() {
		return this.selfBenefitScore;
	}

	@Override
	public int getBenefiocioParaOutros() {
		return this.otherBenefitScore;
	}
	@Override
	public String toString() {
		return "Accao [descricao=" + descricao + ", selfBenefitScore=" + selfBenefitScore + ", otherBenefitScore="
				+ otherBenefitScore + "]";
	}

     

}
