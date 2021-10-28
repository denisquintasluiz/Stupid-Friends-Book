package com.testes;
import com.classes.Pessoa;
public class TestePessoa {

	public static void main(String[] args) {
		Pessoa pessoa=new Pessoa("Ednel");
		
		System.out.println("O nome da pessoa é:"+pessoa.getNome());
		
	    pessoa.adAcao("jogando free fire");
	    pessoa.adAcao("playing football");
	    pessoa.adAcao("rooling code");
	    
	    boolean existe= pessoa.existeAcao("eu sou fodido");
	    if(existe)
	    	//System.out.println("A acção existe!");
	    //else
	    	//System.err.println("A ação não existe!");
	    
	    // testando metodo vota
	    pessoa.vota("jogando free fire", false, false);
	    int personalidade=pessoa.getPersonalidade();
	    if(personalidade==0)
	    	System.out.println("A pessoa é INTELIGENTE:"+personalidade);
	    else if(personalidade==1)
	    	System.out.println("A pessoa é ANGINHA:"+personalidade);
	    else if(personalidade==2)
	    	System.out.println("A pessoa é BANDIDA:"+personalidade);
	    else if(personalidade==3)
	    	System.out.println("A pessoa é ESTUPIDA:"+personalidade);
	    else
	    	System.out.println("Personalidade Invalida!");
	    
	   //testando metodo getaborrecimento
	    double distancia=pessoa.getAborrecimento();
	    System.out.println("A distância é:"+distancia);
	    	

	}

}
