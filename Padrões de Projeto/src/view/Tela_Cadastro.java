package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import modelo.Sexo;
import modelo.Usuario;
import modelo.Usuario_Feminino;
import modelo.Usuario_Masculino;


public class Tela_Cadastro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField tfNome;
	public JLabel lblNewLabel;
	public JLabel lblSenha;
	public JLabel lblNewLabel_1;
	public JSpinner spIdade;
	public JComboBox cmSexo;
	public JLabel lblCadastro;
	public JButton okButton;
	
	public Tela_Principal tp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Tela_Cadastro dialog = new Tela_Cadastro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public void Intent(Tela_Principal tp) {
		this.tp = tp;
	}

	public Tela_Cadastro() {
		setBounds(100, 100, 299, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 450, 235);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		tfNome = new JTextField();
		tfNome.setHorizontalAlignment(SwingConstants.LEFT);
		tfNome.setToolTipText("");
		tfNome.setBounds(106, 69, 124, 19);
		contentPanel.add(tfNome);
		tfNome.setColumns(1);

		lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(22, 71, 66, 15);
		contentPanel.add(lblNewLabel);

		lblSenha = new JLabel("Idade:");
		lblSenha.setBounds(22, 112, 66, 15);
		contentPanel.add(lblSenha);

		lblNewLabel_1 = new JLabel("Sexo:");
		lblNewLabel_1.setBounds(22, 151, 66, 15);
		contentPanel.add(lblNewLabel_1);

		spIdade = new JSpinner();
		spIdade.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spIdade.setBounds(106, 110, 48, 20);
		contentPanel.add(spIdade);

		cmSexo = new JComboBox();
		cmSexo.setToolTipText("");
		cmSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		cmSexo.setBounds(106, 146, 124, 24);
		contentPanel.add(cmSexo);

		lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCadastro.setBounds(100, 12, 130, 24);
		contentPanel.add(lblCadastro);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 235, 450, 35);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				okButton = new JButton("Cadastrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//Parâmetros
						String nome = tfNome.getText();
						int idade = (Integer) spIdade.getValue();
						String sexo = (String)cmSexo.getSelectedItem();
						//Cadastrando
						try{
							if(tp !=null) {
							Usuario u = tp.casa.cadastrarUsuario(nome, idade, sexo);
							JOptionPane.showMessageDialog(null, "Usuário foi cadastrado!\n"+u);
							tp.getUsuario(u);
							dispose();
							}
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}

					}
				});
				okButton.setBounds(22, 5, 119, 25);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setBounds(163, 5, 103, 25);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
