package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Fachada;
import modelo.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Principal extends JFrame {

	private JPanel contentPane;
	public Fachada casa = new Fachada();
	Tela_Cadastro tc = new Tela_Cadastro();
	public static Tela_Principal frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Tela_Principal();
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
	public String getUsuario(Usuario u) {
		casa.adicionarUsuario(u);
		return ""+u;
		
	}
	public Tela_Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Usuario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tc = new Tela_Cadastro();
				tc.setVisible(true);
				tc.Intent(frame);
			}
		});
		mntmNewMenuItem.setBounds(12, 12, 127, 19);
		contentPane.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("listar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, ""+ casa.listarUsuarios());
			}
		});
		mntmNewMenuItem_1.setBounds(143, 12, 127, 19);
		contentPane.add(mntmNewMenuItem_1);
	}
}
