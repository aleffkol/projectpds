package view;

import modelo.Cenario_Builder;
import modelo.Cenario_Product;
import modelo.Sensor;
import modelo.Sensor_Movimento;

public class Testes {

	public static void main(String[] args) {
		Sensor sm = new Sensor_Movimento();
		System.out.println(sm.getSinal().getDescricao());
		
		Cenario_Builder cb = new Cenario_Builder();
		String nome = "Nome";
		cb.nomeCenario(nome);
		Cenario_Product c = cb.gerarCenario();
		System.out.println(c.getNome());

	}

}
