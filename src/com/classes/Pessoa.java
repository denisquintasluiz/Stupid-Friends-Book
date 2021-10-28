/**
 * 
 */
package com.classes;
import com.interfaces.Pessoas;

import java.util.Arrays;

import com.classes.Accao;;
/**
 * @author Denis Quintas Luiz
 *
 */
public class Pessoa implements Pessoas{

	private static final int DEFAULT = 20;
	private Accao[] myAcao;
	private int contador;
	private String nome;
	private Accao controler;
	private Accao auxiliar;
	
	

	public Pessoa(String nome) {
		if(nome!=null) {
		this.nome=nome;
		}
		myAcao=new Accao[DEFAULT];
		contador=0;
		auxiliar=new Accao();
	}
	//construtor sem parametro.
	public Pessoa() {
		myAcao=new Accao[DEFAULT];
		contador=0;
	}
	@Override
	public boolean existeAcao(String descricao) {
		for(int i=0;i<this.contador;i++) {
			if(descricao.equals(this.myAcao[i].getDescricao()))
				return true;
		}
		return false;
	}
	
	@Override
	public void adAcao(String descricao) {
		Accao acao=new Accao(descricao);
		if(existeAcao(descricao)) {
			//não faz nada.
		}
		else {
			if(contador<this.myAcao.length) {
				myAcao[this.contador]=acao;
				this.contador++;
			}
		}
	}
	@Override
	public void vota(String descricao, boolean bomParaPessoa, boolean bomParaOutros) {
		controler=new Accao(descricao);
		if(existeAcao(descricao)) {
			controler.vota( bomParaPessoa, bomParaOutros);
		}

	}
	@Override
	public String getNome() {

		return  this.nome;
	}
	//metodo com falhas de funcionamento.
	@Override
	public int getPersonalidade() {
		int personalidadePessoa=(auxiliar.getBeneficioProprio()+auxiliar.getBenefiocioParaOutros())/2;
		return personalidadePessoa;
	}
	//metodo com falha de funcionamento.
	@Override
	public double getAborrecimento() {
		double distancia=Math.sqrt((Math.pow(auxiliar.getBeneficioProprio(), 2))+
				(Math.pow(auxiliar.getBenefiocioParaOutros(), 2)));
		return distancia;
	}
	@Override
	public String toString() {
		return "Pessoa [myAcao=" + Arrays.toString(myAcao) + ", contador=" + contador + ", nome=" + nome
				+ ", controler=" + controler + "]";
	}
	

}
