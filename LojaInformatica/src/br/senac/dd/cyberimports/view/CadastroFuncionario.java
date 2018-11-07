package br.senac.dd.cyberimports.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class CadastroFuncionario {

	private JFrame frmCadastrarFuncionrio;
	private JTextField txtNomeFuncionario;
	private JTextField txtCpfFuncionario;
	private JTable table;
	private JLabel lblId;
	private JLabel lblIdFuncionario;
	private JLabel lblSalrio;
	private JTextField textField;
	private JButton button;


	public JFrame getFrame() {
		return frmCadastrarFuncionrio;
	}

	public void setFrame(JFrame frame) {
		this.frmCadastrarFuncionrio = frame;
	}

	public CadastroFuncionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastrarFuncionrio = new JFrame();
		frmCadastrarFuncionrio.setTitle("Funcion\u00E1rios");
		frmCadastrarFuncionrio.setBounds(100, 100, 792, 455);
		frmCadastrarFuncionrio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarFuncionrio.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(10, 70, 59, 14);
		frmCadastrarFuncionrio.getContentPane().add(lblNome);
		
		txtNomeFuncionario = new JTextField();
		txtNomeFuncionario.setBounds(79, 67, 199, 20);
		frmCadastrarFuncionrio.getContentPane().add(txtNomeFuncionario);
		txtNomeFuncionario.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(10, 95, 59, 14);
		frmCadastrarFuncionrio.getContentPane().add(lblCpf);
		
		txtCpfFuncionario = new JTextField();
		txtCpfFuncionario.setColumns(10);
		txtCpfFuncionario.setBounds(79, 92, 199, 20);
		frmCadastrarFuncionrio.getContentPane().add(txtCpfFuncionario);
		
		JButton btnAdicionarFuncionario = new JButton("");
		btnAdicionarFuncionario.setIcon(new ImageIcon(CadastroFuncionario.class.getResource("/icons/icons8-save-as-26.png")));
		btnAdicionarFuncionario.setBounds(241, 149, 37, 28);
		frmCadastrarFuncionrio.getContentPane().add(btnAdicionarFuncionario);
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(10, 45, 59, 14);
		frmCadastrarFuncionrio.getContentPane().add(lblId);
		
		lblIdFuncionario = new JLabel("");
		lblIdFuncionario.setBounds(79, 45, 46, 14);
		frmCadastrarFuncionrio.getContentPane().add(lblIdFuncionario);
		
		lblSalrio = new JLabel("Sal\u00E1rio:");
		lblSalrio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSalrio.setBounds(10, 120, 59, 14);
		frmCadastrarFuncionrio.getContentPane().add(lblSalrio);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(79, 117, 199, 20);
		frmCadastrarFuncionrio.getContentPane().add(textField);
		
		button = new JButton("");
		button.setIcon(new ImageIcon(CadastroFuncionario.class.getResource("/icons/icons8-cancel-26.png")));
		button.setBounds(194, 149, 37, 28);
		frmCadastrarFuncionrio.getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(297, 23, 469, 382);
		frmCadastrarFuncionrio.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"nome"
			}
		));
		scrollPane.setViewportView(table);
	}
}
