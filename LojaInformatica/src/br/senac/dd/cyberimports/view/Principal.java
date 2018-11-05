package br.senac.dd.cyberimports.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SpringLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTable tableClientes;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtIdProduto;
	private JTextField txtNomeProduto;
	private JTextField txtPrecoCusto;
	private JTextField txtPrecoVenda;
	private JTextField txtQuantidade;
	private JTable table_1;
	private JTable tableOrcamento;
	private JTextField txtIdOrcamento;
	private JTextField txtNomeClienteOrcamento;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public Principal() {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 707);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnProdutos = new JMenu("Produtos");
		menuBar.add(mnProdutos);

		JMenuItem mnCadastrar = new JMenuItem("Cadastrar");
		mnCadastrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnProdutos.add(mnCadastrar);

		JMenuItem mnListar = new JMenuItem("Listar");
		mnListar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mnProdutos.add(mnListar);

		JMenuItem mnRelatrio = new JMenuItem("Relat\u00F3rio");
		mnRelatrio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mnProdutos.add(mnRelatrio);

		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);

		JMenuItem mnCadastrar_1 = new JMenuItem("Cadastrar");
		mnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new CadastroCliente();
				setContentPane(contentPane);
				revalidate();

			}
		});
		mnCadastrar_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK));
		mnClientes.add(mnCadastrar_1);

		JMenuItem mnListar_1 = new JMenuItem("Listar");
		mnListar_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_MASK));
		mnClientes.add(mnListar_1);

		JMenuItem mnRelatrio_1 = new JMenuItem("Relat\u00F3rio");
		mnRelatrio_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.CTRL_MASK));
		mnClientes.add(mnRelatrio_1);

		JMenu mnFuncionrios = new JMenu("Funcion\u00E1rios");
		menuBar.add(mnFuncionrios);

		JMenuItem mnCadastrar_2 = new JMenuItem("Cadastrar");
		mnCadastrar_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.SHIFT_MASK));
		mnFuncionrios.add(mnCadastrar_2);

		JMenuItem mnListar_2 = new JMenuItem("Listar");
		mnListar_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.SHIFT_MASK));
		mnFuncionrios.add(mnListar_2);

		JMenuItem mnRelatrio_2 = new JMenuItem("Relat\u00F3rio");
		mnRelatrio_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.SHIFT_MASK));
		mnFuncionrios.add(mnRelatrio_2);

		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);

		JMenuItem mnAjuda = new JMenuItem("Ajuda");
		mnAjuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnSobre.add(mnAjuda);

		JMenuItem mnVerso = new JMenuItem("Vers\u00E3o");
		mnVerso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new Sobre();
				setContentPane(contentPane);
				revalidate();
			}
		});
		mnVerso.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
		mnSobre.add(mnVerso);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JTabbedPane tpAbas = new JTabbedPane(JTabbedPane.TOP);
		sl_contentPane.putConstraint(SpringLayout.NORTH, tpAbas, 11, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, tpAbas, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tpAbas, 635, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, tpAbas, 1179, SpringLayout.WEST, contentPane);
		contentPane.add(tpAbas);

		// DEFINIÇÃO DOS ICONES DO SISTEMA.

		ImageIcon iconeProdutos = new ImageIcon(Principal.class.getResource("/icons/icons8-laptop-48.png"));
		ImageIcon iconeClientes = new ImageIcon(Principal.class.getResource("/icons/icons8-client-management-48.png"));
		ImageIcon iconeClienteLista = new ImageIcon(Principal.class.getResource("/icons/icons8-contacts-64.png"));
		ImageIcon iconeServicos = new ImageIcon(Principal.class.getResource("/icons/icons8-support-50.png"));
		ImageIcon iconeOrcamento = new ImageIcon(Principal.class.getResource("/icons/icons8-file-64.png"));

		// CRIAÇÃO DAS ABAS DO SISTEMA.

		JPanel pnClientes = new JPanel();
		
				JPanel pnProdutos = new JPanel();
				tpAbas.addTab("Produtos", iconeProdutos, pnProdutos, null);
				pnProdutos.setLayout(null);
				
				JLabel lblNomeDoProduto = new JLabel("Nome do Produto:");
				lblNomeDoProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNomeDoProduto.setBounds(10, 45, 123, 14);
				pnProdutos.add(lblNomeDoProduto);
				
				JLabel lblPreoDeCusto = new JLabel("Pre\u00E7o de custo:");
				lblPreoDeCusto.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblPreoDeCusto.setBounds(10, 81, 123, 14);
				pnProdutos.add(lblPreoDeCusto);
				
				JLabel lblPreoDeVenda = new JLabel("Pre\u00E7o de venda:");
				lblPreoDeVenda.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblPreoDeVenda.setBounds(10, 116, 123, 14);
				pnProdutos.add(lblPreoDeVenda);
				
				JLabel lblIdDoProduto = new JLabel("ID do Produto:");
				lblIdDoProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblIdDoProduto.setBounds(10, 11, 123, 14);
				pnProdutos.add(lblIdDoProduto);
				
				JLabel lblQuantidade = new JLabel("Quantidade:");
				lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblQuantidade.setBounds(10, 149, 123, 14);
				pnProdutos.add(lblQuantidade);
				
				txtIdProduto = new JTextField();
				txtIdProduto.setBounds(132, 8, 86, 20);
				pnProdutos.add(txtIdProduto);
				txtIdProduto.setColumns(10);
				
				txtNomeProduto = new JTextField();
				txtNomeProduto.setColumns(10);
				txtNomeProduto.setBounds(132, 42, 175, 20);
				pnProdutos.add(txtNomeProduto);
				
				txtPrecoCusto = new JTextField();
				txtPrecoCusto.setColumns(10);
				txtPrecoCusto.setBounds(132, 78, 86, 20);
				pnProdutos.add(txtPrecoCusto);
				
				txtPrecoVenda = new JTextField();
				txtPrecoVenda.setColumns(10);
				txtPrecoVenda.setBounds(132, 113, 86, 20);
				pnProdutos.add(txtPrecoVenda);
				
				txtQuantidade = new JTextField();
				txtQuantidade.setColumns(10);
				txtQuantidade.setBounds(132, 146, 86, 20);
				pnProdutos.add(txtQuantidade);
				
				table_1 = new JTable();
				table_1.setBounds(320, 11, 522, 524);
				pnProdutos.add(table_1);
				
				JButton btnSalvarProduto = new JButton("Salvar");
				btnSalvarProduto.setBounds(10, 223, 89, 23);
				pnProdutos.add(btnSalvarProduto);
				
				JButton btnExcluirProduto = new JButton("Excluir");
				btnExcluirProduto.setBounds(218, 223, 89, 23);
				pnProdutos.add(btnExcluirProduto);
				
				JCheckBox chckbxRemover = new JCheckBox("Remover");
				chckbxRemover.setFont(new Font("Tahoma", Font.BOLD, 11));
				chckbxRemover.setBounds(10, 193, 89, 23);
				pnProdutos.add(chckbxRemover);
				
				JCheckBox chckbxAdicionar = new JCheckBox("Adicionar");
				chckbxAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
				chckbxAdicionar.setBounds(10, 170, 123, 23);
				pnProdutos.add(chckbxAdicionar);

		JPanel pnOrcamento = new JPanel();
		tpAbas.addTab("Orçamentos", iconeOrcamento, pnOrcamento, null);
		pnOrcamento.setLayout(null);
		
		JLabel lblIdOrcamento = new JLabel("ID Or\u00E7amento:");
		lblIdOrcamento.setBounds(10, 11, 115, 14);
		pnOrcamento.add(lblIdOrcamento);
		
		tableOrcamento = new JTable();
		tableOrcamento.setBounds(10, 181, 830, 354);
		pnOrcamento.add(tableOrcamento);
		
		txtIdOrcamento = new JTextField();
		txtIdOrcamento.setBounds(10, 36, 115, 20);
		pnOrcamento.add(txtIdOrcamento);
		txtIdOrcamento.setColumns(10);
		
		txtNomeClienteOrcamento = new JTextField();
		txtNomeClienteOrcamento.setColumns(10);
		txtNomeClienteOrcamento.setBounds(10, 92, 115, 20);
		pnOrcamento.add(txtNomeClienteOrcamento);
		
		JLabel lblNomeClienteOrcamento = new JLabel("Nome do Cliente:");
		lblNomeClienteOrcamento.setBounds(10, 67, 115, 14);
		pnOrcamento.add(lblNomeClienteOrcamento);
		
		JComboBox comboBoxStatus = new JComboBox();
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"", "Aguardando", "Em Andamento", "Aguardando Pe\u00E7as", "Or\u00E7amento conclu\u00EDdo", "Finalizado"}));
		comboBoxStatus.setBounds(172, 36, 135, 20);
		pnOrcamento.add(comboBoxStatus);
		
		JLabel lblStatusDoOramento = new JLabel("Status do Or\u00E7amento:");
		lblStatusDoOramento.setBounds(172, 11, 123, 14);
		pnOrcamento.add(lblStatusDoOramento);
		
		JButton btnProcurar_1 = new JButton("Procurar");
		btnProcurar_1.setBounds(333, 147, 89, 23);
		pnOrcamento.add(btnProcurar_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(172, 92, 56, 20);
		pnOrcamento.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(251, 92, 56, 20);
		pnOrcamento.add(textField_4);
		
		JLabel lblIntervaloDeValores = new JLabel("Intervalo de valores:");
		lblIntervaloDeValores.setBounds(172, 67, 135, 14);
		pnOrcamento.add(lblIntervaloDeValores);
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(238, 95, 7, 14);
		pnOrcamento.add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(333, 36, 115, 20);
		pnOrcamento.add(comboBox);
		
		JLabel lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setBounds(333, 11, 115, 14);
		pnOrcamento.add(lblVendedor);
		
		JButton btnNovoOramento = new JButton("NOVO OR\u00C7AMENTO");
		btnNovoOramento.setBounds(10, 147, 135, 23);
		pnOrcamento.add(btnNovoOramento);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(751, 147, 89, 23);
		pnOrcamento.add(btnEditar);
		
				JPanel pnServico = new JPanel();
				tpAbas.addTab("Serviços", iconeServicos, pnServico, null);
				pnServico.setLayout(null);
				
				JLabel lblNomeDoServio = new JLabel("Nome do Servi\u00E7o:");
				lblNomeDoServio.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNomeDoServio.setBounds(25, 54, 130, 14);
				pnServico.add(lblNomeDoServio);
				
				textField = new JTextField();
				textField.setBounds(155, 51, 226, 20);
				pnServico.add(textField);
				textField.setColumns(10);
				
				table = new JTable();
				table.setBounds(25, 171, 818, 364);
				pnServico.add(table);
				
				JButton btnAdicionar = new JButton("Adicionar");
				btnAdicionar.setBounds(25, 126, 89, 23);
				pnServico.add(btnAdicionar);
				
				JButton btnSalvar_1 = new JButton("Salvar");
				btnSalvar_1.setBounds(155, 126, 89, 23);
				pnServico.add(btnSalvar_1);
				
				JButton btnExcluir_1 = new JButton("Excluir");
				btnExcluir_1.setBounds(279, 126, 89, 23);
				pnServico.add(btnExcluir_1);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(155, 80, 114, 20);
				pnServico.add(textField_1);
				
				JLabel label = new JLabel("Valor do Servi\u00E7o:");
				label.setFont(new Font("Tahoma", Font.BOLD, 11));
				label.setBounds(25, 83, 130, 14);
				pnServico.add(label);
				
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(155, 23, 114, 20);
				pnServico.add(textField_2);
				
				JLabel lblIdDoServio = new JLabel("ID do Servi\u00E7o:");
				lblIdDoServio.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblIdDoServio.setBounds(25, 26, 130, 14);
				pnServico.add(lblIdDoServio);
		tpAbas.addTab("Clientes", iconeClientes, pnClientes, null);
		pnClientes.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1154, 535);
		pnClientes.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(22, 93, 83, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(115, 93, 277, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(22, 124, 83, 14);
		panel.add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(115, 124, 277, 20);
		panel.add(txtCPF);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndereo.setBounds(22, 161, 83, 14);
		panel.add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(115, 161, 277, 20);
		panel.add(txtEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setBounds(22, 197, 83, 14);
		panel.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(115, 197, 277, 20);
		panel.add(txtTelefone);
		
		tableClientes = new JTable();
		tableClientes.setBounds(402, 37, 435, 487);
		panel.add(tableClientes);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(22, 299, 107, 23);
		panel.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(303, 299, 89, 23);
		panel.add(btnExcluir);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(170, 299, 89, 23);
		panel.add(btnProcurar);
		ImageIcon iconeAddCliente = new ImageIcon(Principal.class.getResource("/icons/icons8-add-48.png"));

	}
}
