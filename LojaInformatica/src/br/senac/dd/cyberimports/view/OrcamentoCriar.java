package br.senac.dd.cyberimports.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import br.senac.dd.cyberimports.model.dao.FuncionarioDAO;
import br.senac.dd.cyberimports.model.vo.FuncionarioVO;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class OrcamentoCriar {

	private JFrame frmNovoOramento;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private ArrayList<FuncionarioVO> funcionariosConsultados = new ArrayList<>();
	private String[] nomesFuncionarios = new String[0];

	public JFrame getFrame() {
		return frmNovoOramento;
	}

	public void setFrame(JFrame frame) {
		this.frmNovoOramento = frame;
	}

	/**
	 * Create the application.
	 */
	public OrcamentoCriar() {
		initialize();
	}


	public String[]  getNomesFuncionarios() {

		FuncionarioDAO fdao = new FuncionarioDAO();
		funcionariosConsultados = fdao.listarTodos();

		nomesFuncionarios = new String[funcionariosConsultados.size()];

		for (int i = 0;  i < funcionariosConsultados.size(); i++) {
			nomesFuncionarios[i] = funcionariosConsultados.get(i).getNome() + " (" + funcionariosConsultados.get(i).getId() + ")";
		}
		
		return nomesFuncionarios;
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNovoOramento = new JFrame();
		frmNovoOramento.setIconImage(Toolkit.getDefaultToolkit().getImage(OrcamentoCriar.class.getResource("/icons/icons8-add-48.png")));
		frmNovoOramento.setTitle("Novo Or\u00E7amento");
		frmNovoOramento.setBounds(100, 100, 675, 375);
		frmNovoOramento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNovoOramento.getContentPane().setLayout(null);

		table = new JTable();
		table.setBorder(UIManager.getBorder("ComboBox.Aborder"));
		table.setBounds(10, 167, 639, 158);
		frmNovoOramento.getContentPane().add(table);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCliente.setBounds(10, 11, 63, 14);
		frmNovoOramento.getContentPane().add(lblCliente);

		textField = new JTextField();
		textField.setBounds(83, 8, 175, 20);
		frmNovoOramento.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(123, 39, 135, 20);
		frmNovoOramento.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblData = new JLabel("Data de Cria\u00E7\u00E3o:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setBounds(10, 45, 103, 14);
		frmNovoOramento.getContentPane().add(lblData);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setBounds(330, 11, 46, 14);
		frmNovoOramento.getContentPane().add(lblStatus);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aguardando", "Em Andamento", "Aguardando Pe\u00E7as", "Or\u00E7amento conclu\u00EDdo", "Finalizado"}));
		comboBox.setBounds(401, 8, 185, 20);
		frmNovoOramento.getContentPane().add(comboBox);

		JLabel lblVendedoratendente = new JLabel("Vendedor:");
		lblVendedoratendente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVendedoratendente.setBounds(330, 45, 129, 14);
		frmNovoOramento.getContentPane().add(lblVendedoratendente);

		JLabel lblProcurarProdutoOu = new JLabel("Procurar produto ou Servi\u00E7o:");
		lblProcurarProdutoOu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProcurarProdutoOu.setBounds(10, 142, 175, 14);
		frmNovoOramento.getContentPane().add(lblProcurarProdutoOu);

		textField_3 = new JTextField();
		textField_3.setBounds(172, 139, 287, 20);
		frmNovoOramento.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.setIcon(new ImageIcon(OrcamentoCriar.class.getResource("/icons/icons8-google-web-search-24.png")));
		btnNewButton.setBounds(473, 138, 113, 23);
		frmNovoOramento.getContentPane().add(btnNewButton);

		JLabel lblProblemaDeclarado = new JLabel("Problema declarado:");
		lblProblemaDeclarado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProblemaDeclarado.setBounds(10, 93, 129, 14);
		frmNovoOramento.getContentPane().add(lblProblemaDeclarado);

		textField_4 = new JTextField();
		textField_4.setBounds(173, 70, 413, 61);
		frmNovoOramento.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(getNomesFuncionarios()));
		comboBox_1.setBounds(401, 39, 185, 20);
		frmNovoOramento.getContentPane().add(comboBox_1);
	}
}
