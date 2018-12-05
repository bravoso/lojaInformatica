package br.senac.dd.cyberimports.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import br.senac.dd.cyberimports.controller.OrcamentoController;
import br.senac.dd.cyberimports.model.dao.ClienteDAO;
import br.senac.dd.cyberimports.model.dao.FuncionarioDAO;
import br.senac.dd.cyberimports.model.dao.ProdutoDAO;
import br.senac.dd.cyberimports.model.dao.ServicoDAO;
import br.senac.dd.cyberimports.model.vo.ClienteVO;
import br.senac.dd.cyberimports.model.vo.FuncionarioVO;
import br.senac.dd.cyberimports.model.vo.OrcamentoVO;
import br.senac.dd.cyberimports.model.vo.ProdutoVO;
import br.senac.dd.cyberimports.model.vo.ServicoVO;
import br.senac.dd.cyberimports.view.Principal;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class OrcamentoCriar {

	private JFrame frmNovoOramento;
	private JTextField txtDataCriacao;
	private JTextField txtProblemaDeclarado;
	private ArrayList<ClienteVO> clientesListados = new ArrayList<>();
	private String[] nomesClientes = new String[0];
	private ArrayList<FuncionarioVO> funcionariosConsultados = new ArrayList<>();
	private String[] nomesFuncionarios = new String[0];
	private JTable tblServicosProdutos;
	private String nome;
	private Double valor;
	 
	 JFrame frame;
	 JTable tblProdutos;
	 JTable tblServico;
	JFormattedTextField ftxtValorTotal;

	private ArrayList<Object> itensDoOrcamento = new ArrayList<>();

	JFrame frame;
	JTable tblProdutos;
	JTable tblServico;
	JFormattedTextField ftxtValorTotal;

	private ArrayList<Object> itensDoOrcamento = new ArrayList<>();

	JFrame frame;
	JTable tblProdutos;
	JTable tblServico;

	JFrame frame;
	JTable tblProdutos;
	JTable tblServico;

	private ArrayList<ProdutoVO> produtos;
	private ArrayList<ServicoVO> servicos;
	private ArrayList<ProdutoVO> produtos;
	private ArrayList<ServicoVO> servicos;
	private ArrayList<ProdutoVO> produtos;
	private ArrayList<ServicoVO> servicos;

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

	public static String getCurrentTimeUsingCalendar() {
		LocalDate today = LocalDate.now();

		String hoje = String.valueOf(today);

		return hoje;
	}

	public String[] getNomesClientes() {

		ClienteDAO cdao = new ClienteDAO();
		clientesListados = cdao.listarTodos();

		nomesClientes = new String[clientesListados.size()];

		for (int i = 0; i < clientesListados.size(); i++) {
			nomesClientes[i] = clientesListados.get(i).getNome();
		}

		return nomesClientes;
	}

	public String[] getNomesFuncionarios() {

		FuncionarioDAO fdao = new FuncionarioDAO();
		funcionariosConsultados = fdao.listarTodos();

		nomesFuncionarios = new String[funcionariosConsultados.size()];

		for (int i = 0; i < funcionariosConsultados.size(); i++) {
			nomesFuncionarios[i] = funcionariosConsultados.get(i).getNome();
		}

		return nomesFuncionarios;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNovoOramento = new JFrame();
		frmNovoOramento.setIconImage(
				Toolkit.getDefaultToolkit().getImage(OrcamentoCriar.class.getResource("/icons/icons8-add-48.png")));
		frmNovoOramento.setTitle("Novo Or\u00E7amento");
		frmNovoOramento.setBounds(100, 100, 680, 419);
		frmNovoOramento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNovoOramento.getContentPane().setLayout(null);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCliente.setBounds(10, 11, 63, 14);
		frmNovoOramento.getContentPane().add(lblCliente);

		txtDataCriacao = new JTextField();
		txtDataCriacao.setBounds(123, 39, 135, 20);
		frmNovoOramento.getContentPane().add(txtDataCriacao);
		txtDataCriacao.setColumns(10);
		txtDataCriacao.setText(getCurrentTimeUsingCalendar());

		JLabel lblData = new JLabel("Data de Cria\u00E7\u00E3o:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setBounds(10, 45, 103, 14);
		frmNovoOramento.getContentPane().add(lblData);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setBounds(330, 11, 46, 14);
		frmNovoOramento.getContentPane().add(lblStatus);

		JComboBox comboBoxStatus = new JComboBox();
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] { "Aguardando", "Em Andamento",
				"Aguardando Pe\u00E7as", "Or\u00E7amento conclu\u00EDdo", "Finalizado" }));
		comboBoxStatus.setBounds(401, 8, 185, 20);
		frmNovoOramento.getContentPane().add(comboBoxStatus);

		JLabel lblVendedoratendente = new JLabel("Vendedor:");
		lblVendedoratendente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVendedoratendente.setBounds(330, 45, 129, 14);
		frmNovoOramento.getContentPane().add(lblVendedoratendente);

		JLabel lblProcurarProdutoOu = new JLabel("Procurar produto ou Servi\u00E7o:");
		lblProcurarProdutoOu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProcurarProdutoOu.setBounds(10, 142, 175, 14);
		frmNovoOramento.getContentPane().add(lblProcurarProdutoOu);

		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameCriar();
			}
		});
		btnNewButton.setIcon(new ImageIcon(OrcamentoCriar.class.getResource("/icons/icons8-google-web-search-24.png")));
		btnNewButton.setBounds(183, 138, 113, 23);
		frmNovoOramento.getContentPane().add(btnNewButton);

		JLabel lblProblemaDeclarado = new JLabel("Problema declarado:");
		lblProblemaDeclarado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProblemaDeclarado.setBounds(10, 93, 129, 14);
		frmNovoOramento.getContentPane().add(lblProblemaDeclarado);

		txtProblemaDeclarado = new JTextField();
		txtProblemaDeclarado.setBounds(173, 70, 413, 61);
		frmNovoOramento.getContentPane().add(txtProblemaDeclarado);
		txtProblemaDeclarado.setColumns(10);

		JComboBox comboBoxVendedor = new JComboBox();
		comboBoxVendedor.setModel(new DefaultComboBoxModel(getNomesFuncionarios()));
		comboBoxVendedor.setBounds(401, 39, 185, 20);
		frmNovoOramento.getContentPane().add(comboBoxVendedor);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 167, 639, 158);
		frmNovoOramento.getContentPane().add(scrollPane);

		tblServicosProdutos = new JTable();
		scrollPane.setColumnHeaderView(tblServicosProdutos);
		tblServicosProdutos.setModel(new DefaultTableModel(new Object[][] { { "Nome", "Pre\u00E7o" }, },
				new String[] { "Nome", "Pre\u00E7o" }));

		JComboBox comboBoxClientes = new JComboBox();
		comboBoxClientes.setBounds(65, 8, 193, 20);
		frmNovoOramento.getContentPane().add(comboBoxClientes);
		comboBoxClientes.setModel(new DefaultComboBoxModel(getNomesClientes()));

		JButton btnCriar = new JButton("Criar");
		btnCriar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				OrcamentoController cont = new OrcamentoController();
				cont.salvar(construirOrcamento());
			}

			private OrcamentoVO construirOrcamento() {
				String valorTemp = ftxtValorTotal.getText();
				valorTemp = valorTemp.replace(".", "");
				OrcamentoVO o = new OrcamentoVO();
				o.setCliente((comboBoxClientes.getSelectedItem().toString()));
				o.setDt_orcamento(txtDataCriacao.getText());
				o.setStatus_orcamento(comboBoxStatus.getSelectedItem().toString());
				o.setVendedor(comboBoxVendedor.getSelectedItem().toString());
				o.setValor(Double.parseDouble(valorTemp));
				o.setDescricao(txtProblemaDeclarado.getText());
				o.setVendedor(comboBoxVendedor.getSelectedItem().toString());
				o.setCliente(comboBoxClientes.getSelectedItem().toString());

				return o;
			}
		});
		btnCriar.setBounds(287, 336, 89, 23);
		frmNovoOramento.getContentPane().add(btnCriar);
		
		JLabel lblValorTotal = new JLabel("Valor Total: ");
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorTotal.setBounds(328, 142, 81, 14);
		frmNovoOramento.getContentPane().add(lblValorTotal);
		
		 ftxtValorTotal = new JFormattedTextField();
		ftxtValorTotal.setEditable(false);
		ftxtValorTotal.setBounds(401, 139, 81, 20);
		frmNovoOramento.getContentPane().add(ftxtValorTotal);
	}
	// .
	// .
	// .
	// .
	// .
	// .
	// .
	// .
	// .
	// .
	// .
	// .
	// .
	// .

	protected void frameCriar() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1010, 518);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JScrollPane scrollPaneProdutos = new JScrollPane();
		scrollPaneProdutos.setBounds(10, 11, 476, 403);
		frame.getContentPane().add(scrollPaneProdutos);

		tblProdutos = new JTable();
		tblProdutos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				int linhaSelecionada = tblProdutos.getSelectedRow();
				if (linhaSelecionada > 0) {
					DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
					ProdutoVO produtoSelecionado = produtos.get(linhaSelecionada - 1);
					itensDoOrcamento.add(produtoSelecionado);

					readJTableItens();
				}

			}
		});
		scrollPaneProdutos.setRowHeaderView(tblProdutos);
		tblProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblProdutos.setModel(
				new DefaultTableModel(new Object[][] { { "ID", "Nome", "Custo", "Pre\u00E7o", "Quantidade", }, },
						new String[] { "ID", "Nome", "Custo", "Pre\u00E7o", "Quantidade", }));
		scrollPaneProdutos.setColumnHeaderView(tblProdutos);

		JScrollPane scrollPaneServicos = new JScrollPane();
		scrollPaneServicos.setBounds(508, 11, 476, 403);
		frame.getContentPane().add(scrollPaneServicos);

		tblServico = new JTable();
		tblServico.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int linhaSelecionada = tblServico.getSelectedRow();
				if (linhaSelecionada > 0) {
					DefaultTableModel model = (DefaultTableModel) tblServico.getModel();
					
					ServicoVO servicoSelecionado = servicos.get(linhaSelecionada - 1);
					itensDoOrcamento.add(servicoSelecionado);

					readJTableItens();

				}
			}
		});
		tblServico.setModel(new DefaultTableModel(new Object[][] { { "ID", "Nome", "Valor" }, },
				new String[] { "ID", "Nome", "Valor" }));
		scrollPaneServicos.setColumnHeaderView(tblServico);

		readJtblServico();
		readJTableProdutos();
	}

	public void readJTableItens() {
		
		Double valorTotalOrcamento = 0.00;

		tblServicosProdutos.setModel(new DefaultTableModel(new Object[][] { { "Nome", "Pre\u00E7o" }, },
				new String[] { "Nome", "Pre\u00E7o" }));

		DefaultTableModel modelo = (DefaultTableModel) tblServicosProdutos.getModel();
		modelo.setNumRows(0);
		modelo.addRow(new Object[] { "Nome", "Preço" });

		for (Object produtoOuServico : itensDoOrcamento) {

			if (produtoOuServico instanceof ProdutoVO) {
				modelo.addRow(new Object[] { ((ProdutoVO) produtoOuServico).getNome(),
						((ProdutoVO) produtoOuServico).getPreco() });
			} else if (produtoOuServico instanceof ServicoVO) {
				modelo.addRow(new Object[] { ((ServicoVO) produtoOuServico).getNome(),
						((ServicoVO) produtoOuServico).getValor() });
			}
			if (produtoOuServico instanceof ProdutoVO) {
				valorTotalOrcamento = valorTotalOrcamento +((ProdutoVO) produtoOuServico).getPreco();
			} else if (produtoOuServico instanceof ServicoVO) {
				valorTotalOrcamento = valorTotalOrcamento +((ServicoVO) produtoOuServico).getValor();
			}
		}
		ftxtValorTotal.setValue(valorTotalOrcamento);
	}

	public void readJTableProdutos() {

		DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
		modelo.setNumRows(0);
		ProdutoDAO pdao = new ProdutoDAO();

		produtos = pdao.listarTodos();

		modelo.addRow(new Object[] { "ID", "Nome", "Custo", "Preco", "Quantidade" });

		for (ProdutoVO p : produtos) {

			modelo.addRow(new Object[] { p.getId(), p.getNome(), p.getCusto(), p.getPreco(), p.getQuantidade() });
		}
	}

	public void readJtblServico() {

		DefaultTableModel modelo = (DefaultTableModel) tblServico.getModel();
		modelo.setNumRows(0);
		ServicoDAO sdao = new ServicoDAO();
		
		servicos = sdao.listarTodos();

		modelo.addRow(new Object[] { "ID", "Nome", "Valor",

		});

		for (ServicoVO p : servicos) {

			modelo.addRow(new Object[] {

					p.getId(), p.getNome(), p.getValor(), });
		}
	}
	
}
