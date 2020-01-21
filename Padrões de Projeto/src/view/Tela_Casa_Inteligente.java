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
import javax.swing.JTextField;
import javax.swing.JButton;

public class Tela_Casa_Inteligente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Tela_Cadastro tc = new Tela_Cadastro();
	static Tela_Cenario tcenario = new Tela_Cenario();
	public static Tela_Casa_Inteligente frame;
	public static Fachada casa = new Fachada();
	public JMenu cenarios;
	public DefaultListModel listarCenarios = new DefaultListModel();
	public DefaultListModel listarUsuarios = new DefaultListModel();
	public static JList<String> list = new JList();
	public JLabel subtitulo;
	public JMenu mnNewMenu;
	public JMenu cenario;
	public JMenu mnModo;
	public JTextField tfUsuario;
	public JButton btLogout;
	public JLabel lbTitulo;
	public JButton btLogin;
	public JLabel lbUsurio;
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
	public void login(boolean tf) {

		if(tf==true) {
			lbTitulo.setText("Casa Inteligente");
			tfUsuario.setText("");
			lbUsurio.setVisible(false);
			list.setVisible(true);
			tfUsuario.setVisible(false);
			mnNewMenu.setEnabled(true);
			cenario.setEnabled(true);
			cenarios.setEnabled(true);
			mnModo.setEnabled(true);
			btLogin.setVisible(false);
			btLogout.setVisible(true);



		}
		else {
			lbTitulo.setText("Login");
			mnNewMenu.setEnabled(false);
			lbUsurio.setVisible(true);
			cenario.setEnabled(false);
			cenarios.setEnabled(false);
			mnModo.setEnabled(false);
			btLogout.setVisible(false);
			btLogin.setVisible(true);
			tfUsuario.setVisible(true);
			list.setVisible(false);

		}


	}

	public void adicionandoCenario(Cenario_Product c) {
		Tela_Cenario telacenario = new Tela_Cenario();
		JMenuItem cenario = new JMenuItem(c.getNome());
		cenario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Indo ao cenário "+c.getNome());		
				telacenario.titulo.setText(c.getNome());
				telacenario.setVisible(true);
				telacenario.pegarIntent(frame);
			}
		});
		cenarios.add(cenario);
	}



	public Tela_Casa_Inteligente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Usuario");
		mnNewMenu.setEnabled(false);
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

		cenario = new JMenu("Cenário");
		cenario.setEnabled(false);
		menuBar.add(cenario);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Criar Cenário");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] lugares = {"Banheiro", "Cozinha", "Sala", "Quarto"};
				Arrays.sort(lugares);
				String lugar = (String) JOptionPane.showInputDialog(null, "Escolha o cenário: ", "Escolhendo cenário", JOptionPane.QUESTION_MESSAGE, null, lugares, lugares[0]);
				String nome = (String) JOptionPane.showInputDialog("Informe o nome do cenário: ");
				if(nome.equals("")==false) {
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
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "O nome não pode ser nulo");
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
		cenarios.setEnabled(false);
		menuBar.add(cenarios);

		mnModo = new JMenu("Modo");
		mnModo.setEnabled(false);
		menuBar.add(mnModo);

		JMenuItem mntmFesta = new JMenuItem("Festa");
		mntmFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Ainda não foi desenvolvido o modo festa para o aplicativo");
			}
		});
		mnModo.add(mntmFesta);
		getContentPane().setLayout(null);

		lbTitulo = new JLabel("Login");
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setFont(new Font("Dyuthi", Font.BOLD, 27));
		lbTitulo.setBounds(12, 12, 416, 40);
		getContentPane().add(lbTitulo);

		subtitulo = new JLabel("");
		subtitulo.setBackground(Color.RED);
		subtitulo.setForeground(Color.RED);
		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subtitulo.setBounds(12, 40, 426, 40);
		getContentPane().add(subtitulo);

		tfUsuario = new JTextField();
		tfUsuario.setBounds(168, 92, 124, 19);
		getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);

		btLogin = new JButton("Fazer Login");
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(casa.realizarLogin(tfUsuario.getText())==true) {
					JOptionPane.showMessageDialog(null, "Usuário logado com sucesso!");
					login(true);

				}
				else {
					JOptionPane.showMessageDialog(null, "Não existe este usuário cadastrado.");
				}
			}
		});
		btLogin.setBounds(172, 137, 114, 25);
		getContentPane().add(btLogin);

		btLogout = new JButton("Sair");
		btLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login(false);

			}
		});
		btLogout.setBounds(12, 212, 69, 25);
		getContentPane().add(btLogout);
		
		lbUsurio = new JLabel("Usuário:");
		lbUsurio.setBounds(101, 92, 66, 15);
		getContentPane().add(lbUsurio);
		btLogout.setVisible(false);



	}
}
