package br.senac.dd.cyberimports.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import br.senac.dd.cyberimports.controller.ClienteController;
import br.senac.dd.cyberimports.controller.FuncionarioController;
import br.senac.dd.cyberimports.model.dao.ClienteDAO;
import br.senac.dd.cyberimports.model.dao.FuncionarioDAO;
import br.senac.dd.cyberimports.model.vo.ClienteVO;
import br.senac.dd.cyberimports.model.vo.FuncionarioVO;
import br.senac.dd.cyberimports.model.vo.ProdutoVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CadastroFuncionario {

	private JFrame frmCadastrarFuncionrio;
	private JTextField txtNomeFuncionario;
	private JTextField txtCpfFuncionario;
	private JLabel lblId;
	private JLabel lblSalrio;
	private JTextField txtSalario;
	private JButton btnExcluirFuncionario;
	private JTable tblFuncionarios;
	private JTextField txtIdFuncionario;


	public JFrame getFrame() {
		return frmCadastrarFuncionrio;
	}

	public void setFrame(JFrame frame) {
		this.frmCadastrarFuncionrio = frame;
	}

	public CadastroFuncionario() {
		initialize();
	}
	
	protected void limparTela() {
		funcionario = new FuncionarioVO();
		txtNomeFuncionario.setText("");
		txtCpfFuncionario.setText("");
		txtSalario.setText("");
	}
	
	FuncionarioVO funcionario = new FuncionarioVO();
	FuncionarioController controladorFuncionario = new FuncionarioController();
	
	public FuncionarioVO construirFuncionario() {
		funcionario.setNome(txtNomeFuncionario.getText());
		funcionario.setCpf(txtCpfFuncionario.getText());
		funcionario.setSalario(Double.parseDouble(txtSalario.getText()));
		return funcionario;
	}
	
	public void readJTableFuncionario() {

		DefaultTableModel modelo = (DefaultTableModel) tblFuncionarios.getModel();
		modelo.setNumRows(0);
		FuncionarioDAO fdao = new FuncionarioDAO();

		modelo.addRow(new Object[]{
				"ID",
				"Nome",
				"CPF",
				"Sal�rio",
		});

		for (FuncionarioVO p : fdao.listarTodos()) {

			modelo.addRow(new Object[]{

					p.getId(),
					p.getNome(),
					p.getCpf(),
					p.getSalario(),
			});
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FuncionarioVO funcionario = new FuncionarioVO();
		
		frmCadastrarFuncionrio = new JFrame();
		frmCadastrarFuncionrio.setTitle("Funcion\u00E1rios");
		frmCadastrarFuncionrio.setBounds(100, 100, 792, 455);
		frmCadastrarFuncionrio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		txtCpfFuncionario.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if((input <'0' || input >'9') && input != '\b') {
					e.consume();
				}
			}
		});
		txtCpfFuncionario.setColumns(10);
		txtCpfFuncionario.setBounds(79, 92, 199, 20);
		frmCadastrarFuncionrio.getContentPane().add(txtCpfFuncionario);
		
		JButton btnAlterarFuncionario = new JButton("");
		btnAlterarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tblFuncionarios.getSelectedRow() != -1) {

					FuncionarioVO f = new FuncionarioVO();
					
					f = construirFuncionario();

					f.setNome(txtNomeFuncionario.getText());
					f.setCpf(txtCpfFuncionario.getText());
					f.setSalario(Double.parseDouble(txtSalario.getText()));

					f.setId((int) tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 0));

					String mensagem = controladorFuncionario.atualizar(f);

					limparTela();

					readJTableFuncionario();
				}
			}
		});
		btnAlterarFuncionario.setIcon(new ImageIcon(CadastroFuncionario.class.getResource("/icons/icons8-save-as-26.png")));
		btnAlterarFuncionario.setBounds(131, 150, 37, 28);
		frmCadastrarFuncionrio.getContentPane().add(btnAlterarFuncionario);
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(10, 45, 59, 14);
		frmCadastrarFuncionrio.getContentPane().add(lblId);
		
		lblSalrio = new JLabel("Sal\u00E1rio:");
		lblSalrio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSalrio.setBounds(10, 120, 59, 14);
		frmCadastrarFuncionrio.getContentPane().add(lblSalrio);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(79, 117, 199, 20);
		frmCadastrarFuncionrio.getContentPane().add(txtSalario);
		txtSalario.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if((input <'0' || input >'9') && input != '\b') {
					e.consume();
				}
			}
		});
		
		btnExcluirFuncionario = new JButton("");
		btnExcluirFuncionario.setIcon(new ImageIcon(CadastroFuncionario.class.getResource("/icons/icons8-cancel-26.png")));
		btnExcluirFuncionario.setBounds(193, 150, 37, 28);
		frmCadastrarFuncionrio.getContentPane().add(btnExcluirFuncionario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(291, 11, 475, 394);
		frmCadastrarFuncionrio.getContentPane().add(scrollPane);
		
		tblFuncionarios = new JTable();
		tblFuncionarios.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Nome", "CPF", "Sal�rio"}
			},
			new String[] {
				"ID", "Nome", "CPF", "Sal�rio"
			}
		));
		scrollPane.setColumnHeaderView(tblFuncionarios);
		
		txtIdFuncionario = new JTextField();
		txtIdFuncionario.setEditable(false);
		txtIdFuncionario.setColumns(10);
		txtIdFuncionario.setBounds(79, 40, 199, 20);
		frmCadastrarFuncionrio.getContentPane().add(txtIdFuncionario);
		
		JButton btnAdicionarFuncionario = new JButton("");
		btnAdicionarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioVO funcionario = construirFuncionario();
				String mensagem = controladorFuncionario.salvar(funcionario);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
				readJTableFuncionario();
			}
		});
		btnAdicionarFuncionario.setIcon(new ImageIcon(CadastroFuncionario.class.getResource("/icons/icons8-plus-26.png")));
		btnAdicionarFuncionario.setBounds(64, 149, 37, 28);
		frmCadastrarFuncionrio.getContentPane().add(btnAdicionarFuncionario);
		readJTableFuncionario();
	}
}
