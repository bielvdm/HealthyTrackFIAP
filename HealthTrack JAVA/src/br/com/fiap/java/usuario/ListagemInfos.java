package br.com.fiap.java.usuario;
import java.util.ArrayList;

public class ListagemInfos {
	
	public static void main(String[] args) {
		
		ArrayList<Informacoes> infos = new ArrayList<>();
		infos.add( new Informacoes(80.0,165.0,"Feminino"));
		infos.add( new Informacoes(82.2,165.0,"Feminino"));
		infos.add( new Informacoes(84.0,165.0,"Feminino"));
		infos.add( new Informacoes(85.5,165.0,"Feminino"));
		infos.add( new Informacoes(83.0,165.0,"Feminino"));
		infos.add( new Informacoes(82.0,165.0,"Feminino"));
		infos.add( new Informacoes(81.8,165.0,"Feminino"));
		infos.add( new Informacoes(78.3,165.0,"Feminino"));
		infos.add( new Informacoes(79.0,165.0,"Feminino"));
		infos.add( new Informacoes(77.2,165.0,"Feminino"));
		infos.add( new Informacoes(76.6,165.0,"Feminino"));
		infos.add( new Informacoes(75.4 ,165.0,"Feminino"));
		/* adicionar infos.add */
		
		for(Informacoes info : infos) {
			System.out.println(info);
		}
	}
	
}
