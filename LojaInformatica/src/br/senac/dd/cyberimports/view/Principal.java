package br.senac.dd.cyberimports.view;

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
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;

import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import br.senac.dd.cyberimports.controller.ProdutoController;
import br.senac.dd.cyberimports.controller.ServicoController;
import br.senac.dd.cyberimports.controller.ValidaCPF;
import br.senac.dd.cyberimports.model.dao.ClienteDAO;
import br.senac.dd.cyberimports.model.dao.FuncionarioDAO;
import br.senac.dd.cyberimports.model.dao.OrcamentoDAO;
import br.senac.dd.cyberimports.model.dao.ProdutoDAO;
import br.senac.dd.cyberimports.model.dao.ServicoDAO;
import br.senac.dd.cyberimports.model.vo.ProdutoVO;
import br.senac.dd.cyberimports.model.vo.ServicoVO;
import ca.odell.glazedlists.matchers.Matcher;
import br.senac.dd.cyberimports.controller.ClienteController;
import br.senac.dd.cyberimports.model.vo.ClienteVO;
import br.senac.dd.cyberimports.model.vo.FuncionarioVO;
import br.senac.dd.cyberimports.model.vo.OrcamentoVO;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JFormattedTextField;

public class Principal extends JFrame {

	private static final String ClienteVO = null;
	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtEnderecoCliente;
	private JTextField txtTelefoneCliente;
	private JFormattedTextField txtCpfCliente;
	private JTextField txtNomeServico;
	private JTextField txtValorServico;
	private JTextField txtIdServico;
	private JTextField txtIdProduto;
	private JTextField txtNomeProduto;
	private JTextField txtPrecoCusto;
	private JTextField txtPrecoVenda;
	private JTextField txtQuantidade;
	private JTable tblProdutos;
	private JTextField txtIdOrcamento;
	private JTextField textField_3;
	private JTextField textField_4;
	private ArrayList<FuncionarioVO> funcionariosConsultados = new ArrayList<>();
	private ArrayList<ClienteVO> clientesListados = new ArrayList<>();
	private String[] nomesClientes = new String[0];
	private String[] nomesFuncionarios = new String[0];
	private ProdutoVO produto = new ProdutoVO();
	private ProdutoController controlador = new ProdutoController();
	private ClienteController controladorCliente = new ClienteController();

	// DECLARAÇÃO DE VARIÁVEIS
	ClienteVO cliente = new ClienteVO();
	ServicoVO servico = new ServicoVO();
	private JTextField txtIdCliente;
	private JTable tblClientes;
	private JTable tblServico;
	private JTable tblOrcamentos;

	Integer idProduto = null;
	String nomeProduto = "";
	Double custoProduto = null;
	Double precoProduto = null;
	Integer quantidateProduto = null;

	Integer idCliente = null;
	String nomeCliente = "";
	String clienteCPF = null;
	String telefoneCliente = null;
	String enderecoCliente = null;

	Integer idServico = null;
	String nomeServico = "";
	Double valorServico = null;

	public String[] getNomesClientes() {

		ClienteDAO cdao = new ClienteDAO();
		clientesListados = cdao.listarTodos();

		nomesClientes = new String[clientesListados.size()];

		for (int i = 1; i < clientesListados.size(); i++) {
			nomesClientes[i] = clientesListados.get(i).getNome();
		}

		return nomesClientes;
	}

	public String[] getNomesFuncionarios() {

		FuncionarioDAO fdao = new FuncionarioDAO();
		funcionariosConsultados = fdao.listarTodos();

		nomesFuncionarios = new String[funcionariosConsultados.size()];

		for (int i = 0; i < funcionariosConsultados.size(); i++) {
			nomesFuncionarios[i] = funcionariosConsultados.get(i).getNome() + " ("
					+ funcionariosConsultados.get(i).getId() + ")";
		}

		return nomesFuncionarios;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
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

	protected void limparTela() {
		produto = new ProdutoVO();
		cliente = new ClienteVO();
		servico = new ServicoVO();
		txtIdProduto.setText("");
		txtNomeProduto.setText("");
		txtPrecoCusto.setText("");
		txtPrecoVenda.setText("");
		txtQuantidade.setText("");
		txtIdCliente.setText("");
		txtNomeCliente.setText("");
		txtEnderecoCliente.setText("");
		txtTelefoneCliente.setText("");
		txtIdServico.setText("");
		txtNomeServico.setText("");
		txtValorServico.setText("");
	}

	// METODOS

	public ServicoVO construirServico() {
		servico.setNome(txtNomeServico.getText());
		servico.setValor(Double.parseDouble(txtValorServico.getText()));
		return servico;
	}

	public ProdutoVO construirProduto() {
		produto.setNome(txtNomeProduto.getText());
		produto.setCusto(Double.parseDouble(txtPrecoCusto.getText()));
		produto.setPreco(Double.parseDouble(txtPrecoVenda.getText()));
		produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));

		return produto;
	}

	public void viewJTableProdutos() {
		DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
		tblProdutos.setRowSorter(new TableRowSorter(modelo));
	}

	public void readJTableProdutos() {

		DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
		modelo.setNumRows(0);
		ProdutoDAO pdao = new ProdutoDAO();

		modelo.addRow(new Object[] { "ID", "Nome", "Custo", "Preco", "Quantidade" });

		for (ProdutoVO p : pdao.listarTodos()) {

			modelo.addRow(new Object[] {

			p.getId(), p.getNome(), p.getCusto(), p.getPreco(), p.getQuantidade() });
		}
	}

	public void readJtblServico() {

		DefaultTableModel modelo = (DefaultTableModel) tblServico.getModel();
		modelo.setNumRows(0);
		ServicoDAO sdao = new ServicoDAO();

		modelo.addRow(new Object[] { "ID", "Nome", "Valor",

		});

		for (ServicoVO p : sdao.listarTodos()) {

			modelo.addRow(new Object[] {

			p.getId(), p.getNome(), p.getValor(), });
		}
	}

	public void readJTableClientes() {

		DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
		modelo.setNumRows(0);
		ClienteDAO cdao = new ClienteDAO();

		modelo.addRow(new Object[] { "ID", "Nome", "CPF", "Endereço", "Telefone" });

		for (ClienteVO p : cdao.listarTodos()) {

			modelo.addRow(new Object[] {

			p.getId(), p.getNome(), p.getCpf(), p.getTelefone(), p.getEndereço(), });
		}
	}
	
	public void readJTableOrcamentos() {

		DefaultTableModel modelo = (DefaultTableModel) tblOrcamentos.getModel();
		modelo.setNumRows(0);
		OrcamentoDAO odao = new OrcamentoDAO();

		modelo.addRow(new Object[] { "ID", "Status Orçamento", "Vendedor", "Cliente", "Valor" });

		for (OrcamentoVO o : odao.listarTodos()) {

			modelo.addRow(new Object[] {

			o.getId(), o.getStatus_orcamento(), o.getVendedor(), o.getCliente(), o.getValor() });
		}
	}
	
	public void readJTableOrcamentosPorId(int id) {

		DefaultTableModel modelo = (DefaultTableModel) tblOrcamentos.getModel();
		modelo.setNumRows(0);
		OrcamentoDAO odao = new OrcamentoDAO();

		modelo.addRow(new Object[] { "ID", "Status Orçamento", "Vendedor", "Cliente", "Valor" });

		OrcamentoVO o = odao.obterPorId(id); {

			modelo.addRow(new Object[] {

			o.getId(), o.getStatus_orcamento(), o.getVendedor(), o.getCliente(), o.getValor() });
		}
	}

	/**
	 * Create the frame.
	 *
	 */
	public Principal() throws ParseException {

		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icons/icons8-ssd-48.png")));
		setTitle("Cyber Imports SI");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 707);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFuncionrios = new JMenu("Funcion\u00E1rios");
		menuBar.add(mnFuncionrios);

		JMenuItem mnCadastrar_2 = new JMenuItem("Cadastrar");
		mnCadastrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroFuncionario cadastroFunc = new CadastroFuncionario();
				cadastroFunc.getFrame().setVisible(true);
			}
		});
		mnCadastrar_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.SHIFT_MASK));
		mnFuncionrios.add(mnCadastrar_2);

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
		txtIdProduto.setEditable(false);
		txtIdProduto.setBounds(132, 8, 175, 20);
		pnProdutos.add(txtIdProduto);
		txtIdProduto.setColumns(10);

		txtNomeProduto = new JTextField();
		txtNomeProduto.setColumns(10);
		txtNomeProduto.setBounds(132, 42, 175, 20);
		pnProdutos.add(txtNomeProduto);

		txtPrecoCusto = new JTextField();
		txtPrecoCusto.setColumns(10);
		txtPrecoCusto.setBounds(132, 78, 175, 20);
		pnProdutos.add(txtPrecoCusto);
		txtPrecoCusto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input < '0' || input > '9') && input != '\b') {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent evt) {
				char tecla = evt.getKeyChar();
				if (tecla == KeyEvent.VK_ENTER) {
					txtPrecoCusto.requestFocus();
				} else {
					formatJTextNumber(txtPrecoCusto);
				}
			}

			private void formatJTextNumber(JTextField txtPrecoCusto) {
				String regex = "[0-9]";
				String valorAtual = txtPrecoCusto.getText();
				String CaracterDigitado = "0";
				try {
					CaracterDigitado = txtPrecoCusto.getText().substring(txtPrecoCusto.getText().length() - 1,
							txtPrecoCusto.getText().length() - 0);
				} catch (java.lang.StringIndexOutOfBoundsException e) {
					CaracterDigitado = txtPrecoCusto.getText().substring(txtPrecoCusto.getText().length() - 0,
							txtPrecoCusto.getText().length() - 0);
				}

				Pattern p = Pattern.compile(regex);
				java.util.regex.Matcher m = p.matcher(CaracterDigitado);
				boolean b = m.matches();
				if (b == false) {
					try {
						valorAtual = txtPrecoCusto.getText().substring(0, txtPrecoCusto.getText().length() - 1);
					} catch (java.lang.StringIndexOutOfBoundsException e) {
						valorAtual = txtPrecoCusto.getText().substring(0, txtPrecoCusto.getText().length() - 0);
					}
				}
				String valorAtualReplaced = valorAtual.replace(".", "");

				// separe os doois ultimos digitos
				String centavos = "";
				try {
					centavos = valorAtualReplaced.substring(valorAtualReplaced.length() - 1,
							valorAtualReplaced.length() - 0);
				} catch (java.lang.StringIndexOutOfBoundsException e) {
				}
				String decimal = "";
				try {
					decimal = valorAtualReplaced.substring(valorAtualReplaced.length() - 2,
							valorAtualReplaced.length() - 1);
				} catch (java.lang.StringIndexOutOfBoundsException e) {
				}
				// a parte restante é a parte inteira
				String inteira = "";
				try {
					inteira = valorAtualReplaced.substring(0, valorAtualReplaced.length() - 2);
				} catch (java.lang.StringIndexOutOfBoundsException e) {
					inteira = "0";
				}
				// reconfigure os jtext
				String separator = ".";
				String valorSaida = "";

				// configura a parte inteira
				if (inteira.equals("") == true) {
					inteira = "0";
				}
				int length = inteira.length();
				String subInteira = inteira.substring(0, 1);
				if (length == 2 && subInteira.equals("0") == true) {
					inteira = inteira.substring(1);
				}
				// configura o valor de saída
				valorSaida = inteira + separator + decimal + centavos;
				txtPrecoCusto.setText(valorSaida);

			}
		});

		txtPrecoVenda = new JTextField();
		txtPrecoVenda.setColumns(10);
		txtPrecoVenda.setBounds(132, 113, 175, 20);
		pnProdutos.add(txtPrecoVenda);
		txtPrecoVenda.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input < '0' || input > '9') && input != '\b') {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent evt) {
				char tecla = evt.getKeyChar();
				if (tecla == KeyEvent.VK_ENTER) {
					txtPrecoVenda.requestFocus();
				} else {
					formatJTextNumber(txtPrecoVenda);
				}
			}

			private void formatJTextNumber(JTextField txtPrecoVenda) {
				String regex = "[0-9]";
				String valorAtual = txtPrecoVenda.getText();
				String CaracterDigitado = "0";
				try {
					CaracterDigitado = txtPrecoVenda.getText().substring(txtPrecoVenda.getText().length() - 1,
							txtPrecoVenda.getText().length() - 0);
				} catch (java.lang.StringIndexOutOfBoundsException e) {
					CaracterDigitado = txtPrecoVenda.getText().substring(txtPrecoVenda.getText().length() - 0,
							txtPrecoVenda.getText().length() - 0);
				}

				Pattern p = Pattern.compile(regex);
				java.util.regex.Matcher m = p.matcher(CaracterDigitado);
				boolean b = m.matches();
				if (b == false) {
					try {
						valorAtual = txtPrecoVenda.getText().substring(0, txtPrecoVenda.getText().length() - 1);
					} catch (java.lang.StringIndexOutOfBoundsException e) {
						valorAtual = txtPrecoVenda.getText().substring(0, txtPrecoVenda.getText().length() - 0);
					}
				}
				String valorAtualReplaced = valorAtual.replace(".", "");

				// separe os doois ultimos digitos
				String centavos = "";
				try {
					centavos = valorAtualReplaced.substring(valorAtualReplaced.length() - 1,
							valorAtualReplaced.length() - 0);
				} catch (java.lang.StringIndexOutOfBoundsException e) {
				}
				String decimal = "";
				try {
					decimal = valorAtualReplaced.substring(valorAtualReplaced.length() - 2,
							valorAtualReplaced.length() - 1);
				} catch (java.lang.StringIndexOutOfBoundsException e) {
				}
				// a parte restante é a parte inteira
				String inteira = "";
				try {
					inteira = valorAtualReplaced.substring(0, valorAtualReplaced.length() - 2);
				} catch (java.lang.StringIndexOutOfBoundsException e) {
					inteira = "0";
				}
				// reconfigure os jtext
				String separator = ".";
				String valorSaida = "";

				// configura a parte inteira
				if (inteira.equals("") == true) {
					inteira = "0";
				}
				int length = inteira.length();
				String subInteira = inteira.substring(0, 1);
				if (length == 2 && subInteira.equals("0") == true) {
					inteira = inteira.substring(1);
				}
				// configura o valor de saída
				valorSaida = inteira + separator + decimal + centavos;
				txtPrecoVenda.setText(valorSaida);
			}
		});

		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(132, 146, 175, 20);
		pnProdutos.add(txtQuantidade);
		txtQuantidade.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input < '0' || input > '9') && input != '\b') {
					e.consume();
				}
			}
		});

		JButton btnProcurarProduto = new JButton("");
		btnProcurarProduto
				.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-google-web-search-24.png")));
		btnProcurarProduto.setBounds(104, 195, 37, 35);
		pnProdutos.add(btnProcurarProduto);

		JButton btnExcluirProduto = new JButton("");
		btnExcluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tblProdutos.getSelectedRow() != -1) {

					ProdutoDAO dao = new ProdutoDAO();

					int idSelecionado = (int) tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0);

					dao.remover(idSelecionado);

					limparTela();
					readJTableProdutos();

				} else {
					JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
				}
			}
		});
		btnExcluirProduto.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-cancel-26.png")));
		btnExcluirProduto.setBounds(151, 195, 37, 35);
		pnProdutos.add(btnExcluirProduto);

		JButton btnAdicionarProduto = new JButton("");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoVO produto = construirProduto();
				String mensagem = controlador.salvar(produto);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
				readJTableProdutos();
			}
		});
		btnAdicionarProduto.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-plus-26.png")));
		btnAdicionarProduto.setBounds(10, 195, 37, 35);
		pnProdutos.add(btnAdicionarProduto);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(334, 15, 451, 361);
		pnProdutos.add(scrollPane);

		tblProdutos = new JTable();
		tblProdutos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
				idProduto = (int) model.getValueAt(tblProdutos.getSelectedRow(), 0);
				nomeProduto = (String) model.getValueAt(tblProdutos.getSelectedRow(), 1);
				custoProduto = (Double) model.getValueAt(tblProdutos.getSelectedRow(), 2);
				precoProduto = (Double) model.getValueAt(tblProdutos.getSelectedRow(), 3);
				quantidateProduto = (int) model.getValueAt(tblProdutos.getSelectedRow(), 4);

				txtNomeProduto.setText(nomeProduto);
				txtIdProduto.setText(String.valueOf(idProduto));
				txtPrecoCusto.setText(String.valueOf(custoProduto));
				txtPrecoVenda.setText(String.valueOf(precoProduto));
				txtQuantidade.setText(String.valueOf(quantidateProduto));
			}
		});
		scrollPane.setRowHeaderView(tblProdutos);
		tblProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblProdutos.setModel(
				new DefaultTableModel(new Object[][] { { "ID", "Nome", "Custo", "Pre\u00E7o", "Quantidade", }, },
						new String[] { "ID", "Nome", "Custo", "Pre\u00E7o", "Quantidade", }));

		JButton btnAlterarProduto = new JButton("");
		btnAlterarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tblProdutos.getSelectedRow() != -1) {

					ProdutoVO produto = construirProduto();

					produto.setNome(txtNomeProduto.getText());
					produto.setCusto(Double.parseDouble(txtPrecoCusto.getText()));
					produto.setPreco(Double.parseDouble(txtPrecoVenda.getText()));
					produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));

					produto.setId((int) tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0));

					String mensagem = controlador.atualizar(produto);

					limparTela();

					readJTableProdutos();
				}
			}
		});
		btnAlterarProduto.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-save-as-26.png")));
		btnAlterarProduto.setBounds(57, 195, 37, 35);
		pnProdutos.add(btnAlterarProduto);

		JPanel pnOrcamento = new JPanel();
		tpAbas.addTab("Orçamentos", iconeOrcamento, pnOrcamento, null);
		pnOrcamento.setLayout(null);

		JLabel lblIdOrcamento = new JLabel("ID Or\u00E7amento:");
		lblIdOrcamento.setBounds(10, 11, 115, 14);
		pnOrcamento.add(lblIdOrcamento);

		txtIdOrcamento = new JTextField();
		txtIdOrcamento.setBounds(10, 36, 115, 20);
		pnOrcamento.add(txtIdOrcamento);
		txtIdOrcamento.setColumns(10);

		JLabel lblNomeClienteOrcamento = new JLabel("Nome do Cliente:");
		lblNomeClienteOrcamento.setBounds(10, 67, 115, 14);
		pnOrcamento.add(lblNomeClienteOrcamento);

		JComboBox comboBoxStatus = new JComboBox();
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] { "", "Aguardando", "Em Andamento",
				"Aguardando Pe\u00E7as", "Or\u00E7amento conclu\u00EDdo", "Finalizado" }));
		comboBoxStatus.setBounds(172, 36, 135, 20);
		pnOrcamento.add(comboBoxStatus);

		JLabel lblStatusDoOramento = new JLabel("Status do Or\u00E7amento:");
		lblStatusDoOramento.setBounds(172, 11, 123, 14);
		pnOrcamento.add(lblStatusDoOramento);

		JButton btnProcurar_1 = new JButton("");
		btnProcurar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readJTableOrcamentosPorId(Integer.parseInt(txtIdOrcamento.getText()));
			}
		});
		btnProcurar_1.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-google-web-search-24.png")));
		btnProcurar_1.setBounds(59, 135, 39, 35);
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

		JButton btnNovoOramento = new JButton("");
		btnNovoOramento.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				OrcamentoCriar orcamento = new OrcamentoCriar();
				orcamento.getFrame().setVisible(true);
			}
		});
		btnNovoOramento.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-plus-26.png")));
		btnNovoOramento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNovoOramento.setBounds(10, 135, 39, 35);
		pnOrcamento.add(btnNovoOramento);

		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-compose-24.png")));
		btnEditar.setBounds(108, 135, 39, 35);
		pnOrcamento.add(btnEditar);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 181, 831, 354);
		pnOrcamento.add(scrollPane_3);

		tblOrcamentos = new JTable();
		tblOrcamentos.setModel(
				new DefaultTableModel(
			new Object[][] {
				{"ID", "Status Or\u00E7amento", "Vendedor", "Cliente", "Valor"},
			},
			new String[] {
				"ID", "Status Or\u00E7amento", "Vendedor", "Cliente", "Valor"
			}
		));
		readJTableOrcamentos();
		scrollPane_3.setColumnHeaderView(tblOrcamentos);

		JComboBox comboBoxNomeClientes = new JComboBox();
		comboBoxNomeClientes.setBounds(10, 92, 115, 20);
		pnOrcamento.add(comboBoxNomeClientes);
		comboBoxNomeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getNomesClientes();
			}
		});
		comboBoxNomeClientes.setModel(new DefaultComboBoxModel(getNomesClientes()));

		JPanel pnServico = new JPanel();
		tpAbas.addTab("Serviços", iconeServicos, pnServico, null);
		pnServico.setLayout(null);

		JLabel lblNomeDoServio = new JLabel("Nome do Servi\u00E7o:");
		lblNomeDoServio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeDoServio.setBounds(10, 54, 130, 14);
		pnServico.add(lblNomeDoServio);

		txtNomeServico = new JTextField();
		txtNomeServico.setBounds(140, 51, 226, 20);
		pnServico.add(txtNomeServico);
		txtNomeServico.setColumns(10);

		JButton btnAdicionarServico = new JButton("");
		btnAdicionarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				construirServico();
				ServicoController controladora = new ServicoController();
				controladora.salvar(servico);
				readJtblServico();
			}
		});
		btnAdicionarServico.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-plus-26.png")));
		btnAdicionarServico.setBounds(10, 126, 38, 34);
		pnServico.add(btnAdicionarServico);

		JButton btnPesquisarServico = new JButton("");
		btnPesquisarServico.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (tblServico.getSelectedRow() != -1) {
					btnPesquisarServico.setIcon(
							new ImageIcon(Principal.class.getResource("/icons/icons8-google-web-search-24.png")));
					btnPesquisarServico.setBounds(58, 126, 38, 34);
					pnServico.add(btnPesquisarServico);

					ServicoVO servico = new ServicoVO();
					construirServico();

					servico.setNome(txtNomeServico.getText());
					servico.setValor(Double.parseDouble(txtValorServico.getText()));

					servico.setId((int) tblServico.getValueAt(tblServico.getSelectedRow(), 0));

					String mensagem = "";
					ServicoController controladora = new ServicoController();
					controladora.atualizar(servico);

					limparTela();

					readJtblServico();
				}
			}
		});
		btnPesquisarServico.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-save-as-26.png")));
		btnPesquisarServico.setBounds(58, 126, 38, 34);
		pnServico.add(btnPesquisarServico);

		JButton btnExcluirServico = new JButton("");
		btnExcluirServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tblServico.getSelectedRow() != -1) {

					ServicoDAO dao = new ServicoDAO();

					int idSelecionado = (int) tblServico.getValueAt(tblServico.getSelectedRow(), 0);

					dao.remover(idSelecionado);

					limparTela();
					readJtblServico();

				} else {
					JOptionPane.showMessageDialog(null, "Selecione um serviço para excluir.");
				}
			}
		});
		btnExcluirServico.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-cancel-26.png")));
		btnExcluirServico.setBounds(106, 126, 38, 34);
		pnServico.add(btnExcluirServico);

		txtValorServico = new JTextField();
		txtValorServico.setColumns(10);
		txtValorServico.setBounds(140, 80, 114, 20);
		pnServico.add(txtValorServico);
		txtValorServico.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input < '0' || input > '9') && input != '\b') {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent evt) {
				char tecla = evt.getKeyChar();
				if (tecla == KeyEvent.VK_ENTER) {
					txtPrecoVenda.requestFocus();
				} else {
					formatJTextNumber(txtValorServico);
				}
			}

			private void formatJTextNumber(JTextField txtValorServico) {
				String regex = "[0-9]";
				String valorAtual = txtValorServico.getText();
				String CaracterDigitado = "0";
				try {
					CaracterDigitado = txtValorServico.getText().substring(txtValorServico.getText().length() - 1,
							txtValorServico.getText().length() - 0);
				} catch (java.lang.StringIndexOutOfBoundsException e) {
					CaracterDigitado = txtValorServico.getText().substring(txtValorServico.getText().length() - 0,
							txtValorServico.getText().length() - 0);
				}

				Pattern p = Pattern.compile(regex);
				java.util.regex.Matcher m = p.matcher(CaracterDigitado);
				boolean b = m.matches();
				if (b == false) {
					try {
						valorAtual = txtValorServico.getText().substring(0, txtValorServico.getText().length() - 1);
					} catch (java.lang.StringIndexOutOfBoundsException e) {
						valorAtual = txtValorServico.getText().substring(0, txtValorServico.getText().length() - 0);
					}
				}
				String valorAtualReplaced = valorAtual.replace(".", "");

				// separe os doois ultimos digitos
				String centavos = "";
				try {
					centavos = valorAtualReplaced.substring(valorAtualReplaced.length() - 1,
							valorAtualReplaced.length() - 0);
				} catch (java.lang.StringIndexOutOfBoundsException e) {
				}
				String decimal = "";
				try {
					decimal = valorAtualReplaced.substring(valorAtualReplaced.length() - 2,
							valorAtualReplaced.length() - 1);
				} catch (java.lang.StringIndexOutOfBoundsException e) {
				}
				// a parte restante é a parte inteira
				String inteira = "";
				try {
					inteira = valorAtualReplaced.substring(0, valorAtualReplaced.length() - 2);
				} catch (java.lang.StringIndexOutOfBoundsException e) {
					inteira = "0";
				}
				// reconfigure os jtext
				String separator = ".";
				String valorSaida = "";

				// configura a parte inteira
				if (inteira.equals("") == true) {
					inteira = "0";
				}
				int length = inteira.length();
				String subInteira = inteira.substring(0, 1);
				if (length == 2 && subInteira.equals("0") == true) {
					inteira = inteira.substring(1);
				}
				// configura o valor de saída
				valorSaida = inteira + separator + decimal + centavos;
				txtValorServico.setText(valorSaida);
			}
		});

		JLabel label = new JLabel("Valor do Servi\u00E7o:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 83, 130, 14);
		pnServico.add(label);

		txtIdServico = new JTextField();
		txtIdServico.setEditable(false);
		txtIdServico.setColumns(10);
		txtIdServico.setBounds(140, 23, 114, 20);
		pnServico.add(txtIdServico);

		JLabel lblIdDoServio = new JLabel("ID do Servi\u00E7o:");
		lblIdDoServio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdDoServio.setBounds(10, 26, 130, 14);
		pnServico.add(lblIdDoServio);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 171, 826, 364);
		pnServico.add(scrollPane_2);

		tblServico = new JTable();
		tblServico.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel modelClientes = (DefaultTableModel) tblServico.getModel();
				idServico = (int) modelClientes.getValueAt(tblServico.getSelectedRow(), 0);
				nomeServico = (String) modelClientes.getValueAt(tblServico.getSelectedRow(), 1);
				valorServico = (Double) modelClientes.getValueAt(tblServico.getSelectedRow(), 2);

				txtNomeServico.setText(nomeServico);
				txtValorServico.setText(String.valueOf(valorServico));
				txtIdServico.setText(String.valueOf(idServico));

			}
		});
		tblServico.setModel(new DefaultTableModel(new Object[][] { { "ID", "Nome", "Valor" }, },
				new String[] { "ID", "Nome", "Valor" }));
		scrollPane_2.setColumnHeaderView(tblServico);
		tpAbas.addTab("Clientes", iconeClientes, pnClientes, null);
		pnClientes.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1154, 535);
		pnClientes.add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(10, 37, 83, 14);
		panel.add(lblNome);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(103, 37, 277, 20);
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(10, 68, 83, 14);
		panel.add(lblCpf);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndereo.setBounds(10, 105, 83, 14);
		panel.add(lblEndereo);

		txtEnderecoCliente = new JTextField();
		txtEnderecoCliente.setColumns(10);
		txtEnderecoCliente.setBounds(103, 105, 277, 20);
		panel.add(txtEnderecoCliente);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setBounds(10, 141, 83, 14);
		panel.add(lblTelefone);

		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setColumns(10);
		txtTelefoneCliente.setBounds(103, 141, 277, 20);
		panel.add(txtTelefoneCliente);
		txtTelefoneCliente.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input < '0' || input > '9') && input != '\b') {
					e.consume();
				}
			}
		});

		JButton btnAdicionarCliente = new JButton("");
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAdicionarCliente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				construirCliente();
				ClienteController controladoraCliente = new ClienteController();
				controladoraCliente.salvar(cliente);
				readJTableClientes();
				getNomesClientes();
				comboBoxNomeClientes.setModel(new DefaultComboBoxModel(getNomesClientes()));
			}
		});

		btnAdicionarCliente.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-plus-26.png")));
		btnAdicionarCliente.setBounds(10, 190, 41, 35);
		panel.add(btnAdicionarCliente);

		JButton btnExcluirCliente = new JButton("");
		btnExcluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tblClientes.getSelectedRow() != -1) {

					ClienteDAO dao = new ClienteDAO();

					int idSelecionado = (int) tblClientes.getValueAt(tblClientes.getSelectedRow(), 0);

					dao.remover(idSelecionado);

					limparTela();
					readJTableClientes();

				}
			}
		});
		btnExcluirCliente.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-cancel-26.png")));
		btnExcluirCliente.setBounds(154, 190, 41, 35);
		panel.add(btnExcluirCliente);

		JButton btnProcurarCliente = new JButton("");
		btnProcurarCliente
				.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-google-web-search-24.png")));
		btnProcurarCliente.setBounds(103, 190, 41, 35);
		panel.add(btnProcurarCliente);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(10, 12, 46, 14);
		panel.add(lblId);

		txtIdCliente = new JTextField();
		txtIdCliente.setEditable(false);
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(103, 6, 277, 20);
		panel.add(txtIdCliente);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(407, 12, 425, 512);
		panel.add(scrollPane_1);

		tblClientes = new JTable();
		tblClientes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel modelClientes = (DefaultTableModel) tblClientes.getModel();
				idCliente = (int) modelClientes.getValueAt(tblClientes.getSelectedRow(), 0);
				nomeCliente = (String) modelClientes.getValueAt(tblClientes.getSelectedRow(), 1);
				clienteCPF = (String) modelClientes.getValueAt(tblClientes.getSelectedRow(), 2);
				telefoneCliente = (String) modelClientes.getValueAt(tblClientes.getSelectedRow(), 4);
				enderecoCliente = (String) modelClientes.getValueAt(tblClientes.getSelectedRow(), 3);

				txtNomeCliente.setText(nomeCliente);
				txtIdCliente.setText(String.valueOf(idCliente));
				txtCpfCliente.setText(String.valueOf(clienteCPF));
				txtTelefoneCliente.setText(String.valueOf(telefoneCliente));
				txtEnderecoCliente.setText(String.valueOf(enderecoCliente));
			}
		});
		tblClientes.setModel(new DefaultTableModel(new Object[][] { { "ID", "Nome", "CPF", "Telefone", "Endereço" } },
				new String[] { "ID", "Nome", "CPF", "Telefone", "Endereço" }));
		scrollPane_1.setColumnHeaderView(tblClientes);

		JButton btnAlterarCliente = new JButton("");
		btnAlterarCliente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (tblClientes.getSelectedRow() != -1) {

					ClienteVO c = new ClienteVO();

					c = construirCliente();

					c.setNome(txtNomeCliente.getText());
					c.setCpf(txtCpfCliente.getText());
					c.setEndereço(txtEnderecoCliente.getText());
					c.setTelefone(txtTelefoneCliente.getText());

					c.setId((int) tblClientes.getValueAt(tblClientes.getSelectedRow(), 0));

					String mensagem = controladorCliente.atualizar(c);

					limparTela();

					readJTableClientes();
				}
			}
		});
		btnAlterarCliente.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-save-as-26.png")));
		btnAlterarCliente.setBounds(56, 190, 37, 35);
		panel.add(btnAlterarCliente);

		MaskFormatter formatter = new MaskFormatter("###.###.###-##");
		txtCpfCliente = new JFormattedTextField(formatter);
		txtCpfCliente.setBounds(103, 74, 277, 20);
		panel.add(txtCpfCliente);
		ImageIcon iconeAddCliente = new ImageIcon(Principal.class.getResource("/icons/icons8-add-48.png"));

		// MÉTODOS DE ATUALIZAÇÃO DE UI

		readJTableProdutos();
		readJtblServico();
		readJTableClientes();
		getNomesClientes();
		getNomesFuncionarios();

	}

	protected br.senac.dd.cyberimports.model.vo.ClienteVO construirCliente() {
		String CPF = txtCpfCliente.getText();
		CPF = CPF.replace(".", "");
		CPF = CPF.replace("-", "");
		ValidaCPF valida = new ValidaCPF();
		if (valida.isCPF(CPF) == true) {
			cliente.setNome(txtNomeCliente.getText());
			cliente.setCpf(txtCpfCliente.getText());
			cliente.setEndereço(txtEnderecoCliente.getText());
			cliente.setTelefone(txtTelefoneCliente.getText());
			return cliente;
		}else {
			 JOptionPane.showMessageDialog(null, "CPF inválido", "ERRO", JOptionPane.ERROR_MESSAGE);
			return null;
			
		}
         
		

	}
}
