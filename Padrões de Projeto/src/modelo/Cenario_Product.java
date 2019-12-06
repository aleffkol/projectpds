package modelo;

import java.util.ArrayList;

public class Cenario_Product {
	
	//Atributos
	private String nome;
	private ArrayList<Dispositivo> dispositivos;
	private ArrayList<Sensor> sensores;
	
	
	//Constutores
	public Cenario_Product() {
		this.dispositivos = new ArrayList<Dispositivo>();
	}
	
	public Cenario_Product(String nome) {
		this.nome = nome;
		this.dispositivos = new ArrayList<Dispositivo>();
	}
	
	//Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Dispositivo> getDispositivos() {
		return dispositivos;
	}
	
	public void addDispositivo(Dispositivo d) {
		dispositivos.add(d);
	}
	
	public void addSensor(Sensor s) {
		sensores.add(s);
	}
	
	
	
	
}
