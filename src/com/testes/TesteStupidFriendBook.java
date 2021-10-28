package com.testes;
import com.classes.*;
public class TesteStupidFriendBook {

	public static void main(String[] args) {
		StupidFriendBook whatsap=new StupidFriendBook();
		//testando o metodo AdAmigo(),funcional
		
        whatsap.adAmigo("Ednel");
        whatsap.adAmigo("Alif");
        whatsap.adAmigo("Yury");
        whatsap.adAmigo("chinha");
        whatsap.adAmigo("Denis");
               
        whatsap.mostrarPessoa();
        //testando meto existeAmigo().funcional
        //System.out.println(whatsap.existeAmigo("Ednel"));
        
        //testando o metodo adAcao().funcional
        whatsap.adAcao("Yury", "Assintindo series");
        whatsap.adAcao("Ednel", "vendo filmes");
        whatsap.adAcao("Alif", "pausado no cubico");
        whatsap.adAcao("chinha", "vendo novela");
        whatsap.adAcao("Denis", "wy mais louco");
         
        System.out.println(whatsap.existeAcao("Denis", "wy mais louco"));
        //testando metodo removAmigo().funcional
        whatsap.removAmigo("Ednel");
        System.out.println(" ");
        whatsap.mostrarPessoa();
        //testando metodo vota().funcional
        whatsap.vota("Denis", "wy mais louco", true, false);//0
        whatsap.vota("chinha", "vendo novela", true, false);//0
        whatsap.vota("Alif", "pausado no cubico", true, false);//0
        whatsap.vota("Yury", "Assintindo series", false, false);//1
        System.out.println(" ");
        whatsap.mostrarPessoa();
        System.out.println(" ");
        System.out.println("O amigo mais Aborecido é:"+whatsap.amigoMaisAborrecido());
        //testando metodo iterador().
        
        whatsap.reset();
        whatsap.inicializar(0);
        while(whatsap.temProximo()) {
        	System.out.println(whatsap.proximo().getNome());
        }
       
        
	}

}
