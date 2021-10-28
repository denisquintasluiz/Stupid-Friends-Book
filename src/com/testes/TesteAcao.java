/**
 * 
 */
package com.testes;
import com.classes.Accao;
/**
 * @author Denis Quintas Luiz
 *
 */
public class TesteAcao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Accao acao=new Accao("Criando software");
		
		System.out.println("A acção criada é:"+acao.getDescricao());
		//testando metodo vota.
		acao.vota(true, true);
		System.out.println(acao.getBeneficioProprio());
		System.out.println(acao.getBenefiocioParaOutros());
		//cao.vota(false, true);
		System.out.println(acao.getBeneficioProprio());
		
		

	}

}
