package br.com.fiap.java.view;

import java.util.Scanner;

import br.com.fiap.java.usuario.Email;
import br.com.fiap.java.usuario.Endereco;
import br.com.fiap.java.usuario.Informacoes;
import br.com.fiap.java.usuario.Rastreador;
import br.com.fiap.java.usuario.Telefone;
import br.com.fiap.java.usuario.Usuario;

/**
 * Classe main que faz a chamada das outras duas classes apresentando informa��es
 * gerais do usu�rio e permitindo-lhe altera-las
 * @author lambdateam
 *
 */
public class TesteHealthTrack {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Usuario us = new Usuario();
		Informacoes in = new Informacoes();
		Email em = new Email();
		Endereco end = new Endereco();
		Rastreador ras = new Rastreador();
		Telefone tel = new Telefone();
		int resp;
		
		/**
		 * Chamada dos m�todos das outras classes
		 */
		us.setNome("Jos� de Albuquerque");
		us.setId(599121);
		em.setEnderecoEmail("jose@gmail.com");
		end.setCep("08214-000");
		ras.setAtividadeSemanal(1000);
		tel.setNumeroTelefone(999995555);
		
		in.setPeso(95.1);
		in.setAltura(1.80);
		in.setImc(29.4);
		in.setGenero("Masculino");
		
		/**
		 * Apresenta��o das informa��es
		 */
		System.out.println("Essas s�o suas informa��es de usu�rio");
		System.out.println("Nome: " + us.getNome());
		System.out.println("ID de usu�rio: " + us.getId());
		System.out.println("Peso: " + in.getPeso() + " KG");
		System.out.printf("Altura: %.2f %n", in.getAltura(), " Metros");
		System.out.println("IMC: " + in.getImc());
		System.out.println("Genero: " + in.getGenero());

		
		/**
		 * Apresenta��o da possibilidade de atualiza��o
		 */
		System.out.printf("Deseja alterar as informa��es?: %n1 = Sim %n2 = N�o %n");
		resp = sc.nextInt();
		if (resp == 1) {
			System.out.println("Insira o nome desejado: ");
			us.setNome(sc.next());
			// ID � unico e pessoal, impossivel de ser alterado
			System.out.println("Insira o novo peso em kg: ");
			in.setPeso(sc.nextDouble());
			System.out.println("Insira a nova altura em metros: ");
			in.setAltura(sc.nextDouble());
			System.out.println("Insira o novo genero: ");
			in.setGenero(sc.next());
			in.setImc(in.getPeso() / (in.getAltura() * in.getAltura()) );
			System.out.printf("Deseja exibir as novas altera��es?: %n1 = Sim %n2 = N�o %n");
			resp = sc.nextInt();
			if (resp == 1) {
				System.out.println("Nome: " + us.getNome());
				System.out.println("ID de usu�rio: " + us.getId());
				System.out.println("Peso: " + in.getPeso() + " KG");
				System.out.printf("Altura: %.2f %n", in.getAltura());
				System.out.printf("IMC: %.2f %n", in.getImc());
				System.out.println("Genero: " + in.getGenero());
			} else {
				System.out.println("Encerrado");

			}
		}

		else {
			System.out.println("Encerrado");
		}
		
		
		sc.close();
	}

}
