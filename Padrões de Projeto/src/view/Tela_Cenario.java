package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.List;

public class Tela_Cenario extends JFrame {

	private JPanel contentPane;
	public static Tela_Casa_Inteligente tci;
	public JLabel titulo;
	public DefaultListModel listarDispositivos = new DefaultListModel();
	public DefaultListModel listarDispositivosOn = new DefaultListModel();
	public JList listDispositivo;
	public JList listDispositivoOn;

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
		
		titulo = new JLabel("");
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
		btnNewButton.setBounds(482, 294, 83, 27);
		contentPane.add(btnNewButton);
		
		listDispositivo = new JList();
		listDispositivo.setBounds(26, 143, 133, 149);
		contentPane.add(listDispositivo);
		
		JLabel lblNewLabel = new JLabel("Dispositivos");
		lblNewLabel.setBounds(54, 104, 105, 27);
		contentPane.add(lblNewLabel);
		
		listDispositivoOn = new JList();
		listDispositivoOn.setBounds(261, 143, 133, 149);
		contentPane.add(listDispositivoOn);
		
		JLabel lblDispositivosOn = new JLabel("Dispositivos ON");
		lblDispositivosOn.setBounds(269, 104, 139, 27);
		contentPane.add(lblDispositivosOn);
		
		JButton btnNewButton_1 = new JButton("ON");
		btnNewButton_1.setBounds(61, 295, 60, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnOff = new JButton("OFF");
		btnOff.setBounds(302, 295, 60, 25);
		contentPane.add(btnOff);
	}
}
