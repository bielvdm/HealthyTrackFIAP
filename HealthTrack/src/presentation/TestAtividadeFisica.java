package presentation;

import BO.AtividadeFisica;

public class TestAtividadeFisica {

	public static void main(String[] args) {
		// Chame aqui qual dos metodos abaixo voce quer testar
		// ex:
		TestaSelect();
	}

	public static void TestaInsert() {
		AtividadeFisica af = new AtividadeFisica();
		af.setIdAtividade(1);
		af.setIdIntensidade(1);
		af.setIdUsuario(1);
		af.setNome("Corrida");
		af.setTempo(30);
		af.setData(null);
		System.out.println("Registros afetados: "+ af.AdicionaAtividade(af));
	}
	
	public static void TestaUpdate() {
		AtividadeFisica af = new AtividadeFisica();
		af.setNome("Caminhada");
		af.setTempo(60);
		if (af.AtualizaAtividade() > 0) {
			System.out.println("Atividade: " + af.getNome() + " Tempo: " + af.getTempo() +" alterada.");
		} else {
			System.out.println("Nenhum registro foi alterado");
		}
	}

	public static void TestaDelete() {
		AtividadeFisica af = new AtividadeFisica();
		if (af.RemoveAtividade(1) > 0) {
			System.out.println("Atividade removida!");
		} else {
			System.out.println("Nenhum registro foi excluido");
		}
	}
	
	public static void TestaSelectPorId() {
		AtividadeFisica af = new AtividadeFisica();
		System.out.println(af.SelecionaAtividade(2));
	}
	
	public static void TestaSelect() {
		AtividadeFisica af = new AtividadeFisica();
		System.out.println(af.VisualizaAtividade());
	}
}
