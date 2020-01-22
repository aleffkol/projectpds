package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Dispositivo;

public class Tela_Cenario extends JFrame {

	private JPanel contentPane;
	public static Tela_Casa_Inteligente tci;
	public JLabel titulo = new JLabel("");
	public ArrayList<Dispositivo> dispositivosLista = new ArrayList<Dispositivo>();
	public  DefaultListModel listarDispositivos = new DefaultListModel();
	public  DefaultListModel listarDispositivosOn = new DefaultListModel();
	public  JList listDispositivo = new JList();
	public  JList listDispositivoOn = new JList();
	public static int valorLampada = 0;
	public static int valorSom = 0;
	public static int valorAr = 0;
	public String nome = "a";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cenario frame = new Tela_Cenario();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void pegarIntent(Tela_Casa_Inteligente tci) {
		this.tci = tci; 
	}
	
	public Tela_Cenario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Dialog", Font.BOLD, 20));
		titulo.setBounds(0, 0, 438, 27);
		contentPane.add(titulo);
		
		JButton btnNewButton = new JButton("voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(461, 294, 114, 27);
		contentPane.add(btnNewButton);
		listDispositivo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listDispositivo.setBounds(26, 143, 133, 149);
		contentPane.add(listDispositivo);
		
		JLabel lblNewLabel = new JLabel("Dispositivos");
		lblNewLabel.setBounds(54, 104, 105, 27);
		contentPane.add(lblNewLabel);
		listDispositivoOn.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listDispositivoOn.setBounds(261, 143, 133, 149);
		contentPane.add(listDispositivoOn);
		
		JLabel lblDispositivosOn = new JLabel("Dispositivos ON");
		lblDispositivosOn.setBounds(269, 104, 139, 27);
		contentPane.add(lblDispositivosOn);
		
		JButton btnNewButton_1 = new JButton("ON");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listDispositivo.getSelectedValue()!=null) {
					System.out.println(nome);
					String nomeDisp = listDispositivo.getSelectedValue().toString();
					tci.casa.ligarDispositivo(nomeDisp, titulo.getText());
					listarDispositivosOn.addElement(listDispositivo.getSelectedValue());
					listDispositivoOn.setModel(listarDispositivosOn);
					JOptionPane.showMessageDialog(null, "O dispositivo "+listDispositivo.getSelectedValue()+" foi ligado.");}
				else {
					JOptionPane.showMessageDialog(null, "Nenhum dispositivo selecionado");
				}
			}
		});
		btnNewButton_1.setBounds(61, 295, 60, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnOff = new JButton("OFF");
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listDispositivoOn.getSelectedValue();
				JOptionPane.showMessageDialog(null, "O dispositivo "+listDispositivoOn.getSelectedValue()+" foi desligado.");
				listarDispositivosOn.removeElement(listDispositivoOn.getSelectedValue());
				listDispositivoOn.setModel(listarDispositivosOn);
				
			}
		});
		btnOff.setBounds(302, 295, 60, 25);
		contentPane.add(btnOff);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				String[] dispositivos = {"Ar-Condicionado", "Lampada", "Som"};
				Arrays.sort(dispositivos);
				Dispositivo d = null;
				String dispositivo = (String) JOptionPane.showInputDialog(null, "Escolha o dispositivo: ", "Escolhendo dispositivo", JOptionPane.QUESTION_MESSAGE, null, dispositivos, dispositivos[0]);
				if(dispositivo.equals("Lampada")) {
					valorLampada++;
					String valorString = Integer.toString(valorLampada);
					d = tci.casa.criarLampada(dispositivo + valorString);
					dispositivosLista.add(d);
					listarDispositivos.addElement(d.getNome());
				}
				else if(dispositivo.equals("Ar-Condicionado")) {
					valorAr++;
					String valorString = Integer.toString(valorAr);
					d = tci.casa.criarAr(dispositivo + valorString);
					dispositivosLista.add(d);
					listarDispositivos.addElement(d.getNome());
				}
				else if(dispositivo.equals("Som")) {
					valorSom++;
					String valorString = Integer.toString(valorSom);
					d = tci.casa.criarSom(dispositivo + valorString);
					dispositivosLista.add(d);
					listarDispositivos.addElement(d.getNome());
				}
				listDispositivo.setModel(listarDispositivos);
				//System.out.println(tci.casa.adicionarDispositivoCenario(titulo.getName(), d));
			}
		});
		btnAdicionar.setBounds(461, 257, 114, 25);
		contentPane.add(btnAdicionar);
	}
}
