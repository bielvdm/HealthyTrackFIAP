package presentation;

import BO.PressaoUsuario;

public class TestPressaoUsuario {

	public static void main(String[] args) {
		// Chame aqui qual dos metodos abaixo voce quer testar
		// ex:
		TestaSelect();
	}

	public static void TestaInsert() {
		PressaoUsuario p = new PressaoUsuario();
		p.setIdPressao(1);
		p.setIdUsuario(1);
		p.setPressaoArterial("12/10");
		p.setData(null);
		System.out.println("Registros afetados: "+ p.AdicionaPressao(p));
	}
	
	public static void TestaUpdate() {
		PressaoUsuario p = new PressaoUsuario();
		p.setPressaoArterial("12/10");
		if (p.AtualizaPressaoUsuario() > 0) {
			System.out.println("Pressão: " + p.getPressaoArterial() + "alterada.");
		} else {
			System.out.println("Nenhum registro foi alterado");
		}
	}

	public static void TestaDelete() {
		PressaoUsuario p = new PressaoUsuario();
		if (p.RemovePressaoUsuario(1) > 0) {
			System.out.println("Pressão removida!");
		} else {
			System.out.println("Nenhum registro foi excluido");
		}
	}
	
	public static void TestaSelectPorId() {
		PressaoUsuario p = new PressaoUsuario();
		System.out.println(p.SelecionaPressao(2));
	}
	
	public static void TestaSelect() {
		PressaoUsuario p = new PressaoUsuario();
		System.out.println(p.VisualizaPressaoUsuario());
	}
}
