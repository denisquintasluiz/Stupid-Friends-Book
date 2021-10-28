/**
 * 
 */
package com.stupidfriendsbook;
import java.util.Scanner;
import com.classes.Pessoa;
import com.classes.StupidFriendBook;
/**
 * @author Denis Quintas Luiz;
 *
 */
public class Main {
	// personalidades da Pessoa
	private static final  int INTELEGENTE=0;
	private static final  int ANJINHO=1;
	private static final  int BANDIDO=2;
	private static final int ESTUPIDO=3;
	//lista de comandos do Sistema.
	private static final String NOVO="NOVO";
	private static final String ADICIONA="ADICIONA";
	private static final String REMOVE="REMOVE";
	private static final String FAZ="FAZ";
	private static final String VOTA="VOTA";
	private static final String LISTA="LISTA";
	private static final String PERSONALIDADE="PERSONALIDADE";
	private static final String SAIR="SAIR";

	public static void main(String[] args) {
		StupidFriendBook fb=new StupidFriendBook();
		System.out.print(">");
		Scanner in=new Scanner(System.in);
		String opcao =lerOpcao(in);
		executarOpcaoIniciarRedeSocial(fb, opcao, in);
	}

	private static void executarOpcaoIniciarRedeSocial(StupidFriendBook fb, String opcao, Scanner in) {
		switch(opcao) {
		case NOVO:
			processarNovo(fb,opcao,in);
			System.out.print(">");
			String opcao1=lerOpcao(in);
			executarOpcaoIniciarRedeSocial(fb, opcao1, in);
			break;
		case ADICIONA:
			processarAdiciona(fb,opcao,in);
			System.out.print(">");
			String opcao2=lerOpcao(in);
			executarOpcaoIniciarRedeSocial(fb, opcao2, in);
			break;
		case REMOVE:
			processarRemove(fb,opcao,in);
			System.out.print(">");
			String opcao3=lerOpcao(in);
			executarOpcaoIniciarRedeSocial(fb, opcao3, in);
			break;
		case FAZ:
			processarFaz(fb,opcao,in);
			System.out.print(">");
			String opcao4=lerOpcao(in);
			executarOpcaoIniciarRedeSocial(fb, opcao4, in);
			break;
		case VOTA:
			processarVota(fb,opcao,in);
			System.out.print(">");
			String opcao5=lerOpcao(in);
			executarOpcaoIniciarRedeSocial(fb, opcao5, in);
			break;
		case LISTA:
			processandoLista(fb,opcao,in);
			System.out.print(">");
			String opcao6=lerOpcao(in);
			executarOpcaoIniciarRedeSocial(fb, opcao6, in);
			break;
		case PERSONALIDADE:
			processarPersonalidade(fb,opcao,in);
			System.out.print(">");
			String opcao7=lerOpcao(in);
			executarOpcaoIniciarRedeSocial(fb, opcao7, in);
			break;
		case SAIR:
			processarSair(fb,opcao,in);
			System.out.print(">");
			String opcao8=lerOpcao(in);
			executarOpcaoIniciarRedeSocial(fb, opcao8, in);
			break;
		default:
			System.out.println("Comando Invalido!");
			System.out.print(">");
			String opcao9=lerOpcao(in);
			executarOpcaoIniciarRedeSocial(fb, opcao9, in);
			break;
		}

	}

	private static void processarSair(StupidFriendBook fb, String opcao, Scanner in) {
		System.out.println("Adeus!");
		System.exit(0);
		
	}

	private static void processarPersonalidade(StupidFriendBook fb, String opcao, Scanner in) {
		String nome=in.next();
		if(nome!=null) {
			Pessoa pessoa=new Pessoa(nome);
			int personalidade=pessoa.getPersonalidade();
			if(personalidade==0)
				System.out.println("Inteligente.");
			else if(personalidade==1)
				System.out.println("Anjinho.");
			else if(personalidade==2)
				System.out.println("Bandido.");
			else if(personalidade==3)
				System.out.println("Estupido.");
			else
				System.out.println("Personalidade inválida!");
		}

	}

	private static void processandoLista(StupidFriendBook fb, String opcao, Scanner in){
		String aux=in.next();
		int tipo=0;
		if(aux.equalsIgnoreCase("Inteligente"))
			tipo=INTELEGENTE;
		else if(aux.equalsIgnoreCase("Anjinho"))
			tipo=ANJINHO;
		else if(aux.equalsIgnoreCase("Bandido"))
			tipo=BANDIDO;
		else if(aux.equalsIgnoreCase("Estupido"))
			tipo=ESTUPIDO;
		else
			System.out.println("Personalidade Inválida!");
		fb.inicializar(tipo);
		while(fb.temProximo()) {
			System.out.println(fb.proximo().getNome());
		}

	}

	private static void processarVota(StupidFriendBook fb, String opcao, Scanner in) {
		boolean pessoa=false;
		boolean outros=false;
		String nome=in.next();
		String descricao=in.next();
		String bompessoa=in.next();
		String bomoutros=in.next();
		if(bompessoa.equalsIgnoreCase("Bem"))
			pessoa=true;
		else if(bompessoa.equalsIgnoreCase("Mal"))
			pessoa=false;
		else
			System.out.println("voto inválido!");
		if(bomoutros.equalsIgnoreCase("Bem"))
			outros=true;
		else if(bomoutros.equalsIgnoreCase("Mal"))
			outros=false;
		else
			System.out.println("voto inválido!");
		if(fb.existeAcao(nome, descricao)) {
			fb.vota(nome, descricao, pessoa, outros);
			System.out.println("Ok.");
		}
		else
			System.out.println("A ação não existe!");
	}

	private static void processarFaz(StupidFriendBook fb, String opcao, Scanner in) {
		String nome=in.next();
		String descricao=in.next();
		if(nome!=null&&descricao!=null) {
			if(fb.existeAcao(nome, descricao)) {

				System.out.println("A acão já existe!");
			}
			else {
				fb.adAcao(nome, descricao);
				System.out.println("OK.");
			}
		}

	}

	private static void processarRemove(StupidFriendBook fb, String opcao, Scanner in) {
		String nome=in.next();
		if(nome!=null) {
			if(fb.existeAmigo(nome)) {
				fb.removAmigo(nome);
				System.out.println("Ok.");
			}
			else {
				System.out.println("O Amigo não existe!");
			}
		}

	}

	private static void processarAdiciona(StupidFriendBook fb, String opcao, Scanner in) {
		String nome=in.next();
		if(nome!=null) {
			if(fb.existeAmigo(nome)) {
				System.out.println("O Amigo já existe!");
			}
			else{
				fb.adAmigo(nome);
				System.out.println("Ok.");
			}
		}

	}

	private static void processarNovo(StupidFriendBook fb, String opcao, Scanner in) {
		fb.reset();
	}

	private static String lerOpcao(Scanner in) {
		return in.next().toUpperCase();
	}

}
