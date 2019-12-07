package view;

import modelo.Sensor;
import modelo.Sensor_Movimento;

public class Testes {

	public static void main(String[] args) {
		Sensor sm = new Sensor_Movimento();
		System.out.println(sm.getSinal().getDescricao());

	}

}
