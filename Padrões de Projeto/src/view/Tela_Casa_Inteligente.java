package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import modelo.Cenario_Builder;
import modelo.Cenario_Product;
import modelo.Fachada;
import modelo.Usuario;

import javax.swing.AbstractListModel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Tela_Casa_Inteligente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Tela_Cadastro tc = new Tela_Cadastro();
	Tela_Cenario tcenario = new Tela_Cenario();
	public static Tela_Casa_Inteligente frame;
	public Fachada casa = new Fachada();
	public JMenu cenarios;
	public DefaultListModel listarCenarios = new DefaultListModel();
	public DefaultListModel listarUsuarios = new DefaultListModel();
	public JList<String> list = new JList();
	public JLabel subtitulo;

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
	public void atualizarListaCenario(String nome) {
		listarCenarios.addElement(nome);
	}

	public void atualizarListaUsuarios(Usuario u) {
		listarUsuarios.addElement(u.getNome());
	}

	public void adicionandoCenario(Cenario_Product c) {
		JMenuItem cenario = new JMenuItem(c.getNome());
		cenario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Indo ao cenário "+c.getNome());
				tcenario = new Tela_Cenario();
				tcenario.titulo.setText(c.getNome());
				tcenario.setVisible(true);
				tcenario.pegarIntent(frame);
			}
		});
		cenarios.add(cenario);
	}



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
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				list.removeAll();
				list.setBounds(128, 101, 178, 136);
				getContentPane().add(list);
				list.setModel(listarUsuarios);
				list.setEnabled(false);
				subtitulo.setText("Listando Usuários: ");

			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenu cenario = new JMenu("Cenário");
		menuBar.add(cenario);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Criar Cenário");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] lugares = {"Banheiro", "Cozinha", "Sala", "Quarto"};
				Arrays.sort(lugares);
				String lugar = (String) JOptionPane.showInputDialog(null, "Escolha o cenário: ", "Escolhendo cenário", JOptionPane.QUESTION_MESSAGE, null, lugares, lugares[0]);
				String nome = (String) JOptionPane.showInputDialog("Informe o nome do cenário: ");
				String nomeLugar = lugar+"_"+nome;
				try {
					Cenario_Builder cb = new Cenario_Builder();
					cb.nomeCenario(nomeLugar);
					Cenario_Product c = cb.gerarCenario();
					casa.adicionarCenario(c);
					adicionandoCenario(c);
					atualizarListaCenario(nomeLugar);
					//					list.setModel(listarCenarios);
					JOptionPane.showMessageDialog(null, "O cenário "+c.getNome()+" foi criado!");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Opa");
				}
			}
		});
		cenario.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listar Cenários");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				list.removeAll();
				list.setBounds(128, 101, 178, 136);
				getContentPane().add(list);
				list.setModel(listarCenarios);
				list.setEnabled(false);
				subtitulo.setText("Listando Cenários: ");

			}
		});
		cenario.add(mntmNewMenuItem_4);

		cenarios = new JMenu("Ir para");
		menuBar.add(cenarios);

		JMenu mnModo = new JMenu("Modo");
		menuBar.add(mnModo);

		JMenuItem mntmFesta = new JMenuItem("Festa");
		mnModo.add(mntmFesta);
		getContentPane().setLayout(null);

		JLabel lblCasaInteligente = new JLabel("Casa Inteligente");
		lblCasaInteligente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCasaInteligente.setFont(new Font("Dyuthi", Font.BOLD, 27));
		lblCasaInteligente.setBounds(12, 12, 416, 40);
		getContentPane().add(lblCasaInteligente);

		subtitulo = new JLabel("");
		subtitulo.setBackground(Color.RED);
		subtitulo.setForeground(Color.RED);
		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subtitulo.setBounds(12, 40, 426, 40);
		getContentPane().add(subtitulo);


	}
}
