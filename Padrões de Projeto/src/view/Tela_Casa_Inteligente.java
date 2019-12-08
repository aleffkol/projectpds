package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Fachada;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Tela_Casa_Inteligente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Tela_Cadastro tc = new Tela_Cadastro();
	public static Tela_Casa_Inteligente frame;
	public Fachada casa = new Fachada();
	public JLabel TituloApp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					frame = new Tela_Casa_Inteligente();
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
	public Tela_Casa_Inteligente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Usuario");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Criar Usuário");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tc = new Tela_Cadastro();
				tc.setVisible(true);
				tc.pegarIntent(frame);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listar Usuário");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Cenário");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Criar Cenário");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listar Cenários");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Ir para");
		menuBar.add(mnNewMenu_2);
		getContentPane().setLayout(null);
		
		TituloApp = new JLabel("Casa Inteligente");
		TituloApp.setFont(new Font("Dialog", Font.BOLD, 28));
		TituloApp.setBounds(89, 12, 299, 33);
		getContentPane().add(TituloApp);
	}
}
