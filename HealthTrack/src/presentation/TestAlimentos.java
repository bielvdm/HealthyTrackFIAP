package presentation;

import BO.Alimentos;

public class TestAlimentos {
	
	public static void main(String[] args) {
		// Chame aqui qual dos metodos abaixo voce quer testar
		// ex:
		TestaSelect();
	}

	public static void TestaInsert() {
		Alimentos a = new Alimentos();
		a.setIdUsuario(1);
		a.setIdAlimentos(7);
		a.setNome("Maça");
		a.setQntAlimentos(9);
		System.out.println("Registros afetados: "+ a.AdicionaAlimentos(a));
	}
	
	public static void TestaUpdate() {
		Alimentos a = new Alimentos();
		a.setNome("Pera");
		a.setQntAlimentos(2);
		a.setIdAlimentos(7);
		if (a.AtualizaAlimentos() > 0) {
			System.out.println("Categoria: " + a.getNome() + " Quantidade: " + a.getQntAlimentos() +" alterada.");
		} else {
			System.out.println("Nenhum registro foi alterado");
		}
	}

	public static void TestaDelete() {
		Alimentos a = new Alimentos();
		if (a.RemoveAlimentos(1) > 0) {
			System.out.println("Alimento removido!");
		} else {
			System.out.println("Nenhum registro foi excluido");
		}
	}
	
	public static void TestaSelectPorId() {
		Alimentos a = new Alimentos();
		System.out.println(a.SelecionaAlimentos(2));
	}
	
	public static void TestaSelect() {
		Alimentos a = new Alimentos();
		System.out.println(a.VisualizaAlimentos());
	}
}
