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

	String nome1 = "";
	Double valor1 = null;
	
	Vector <String> retornoProdutos = new Vector<String>();

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
			nomesClientes[i] = clientesListados.get(i).getNome() + " (" + clientesListados.get(i).getId() + ")";
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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNovoOramento = new JFrame();
		frmNovoOramento.setIconImage(
				Toolkit.getDefaultToolkit().getImage(OrcamentoCriar.class.getResource("/icons/icons8-add-48.png")));
		frmNovoOramento.setTitle("Novo Or\u00E7amento");
		frmNovoOramento.setBounds(100, 100, 675, 400);
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
				OrcamentoVO o = new OrcamentoVO();
				o.setCliente((comboBoxClientes.getSelectedItem().toString()));
				o.setDt_orcamento(txtDataCriacao.getText());
				o.setStatus_orcamento(comboBoxStatus.getSelectedItem().toString());
				o.setVendedor(comboBoxVendedor.getSelectedItem().toString());
				o.setValor(Double.parseDouble((String) tblServicosProdutos.getValueAt(1, 1)));
				o.setDescricao(txtProblemaDeclarado.getText());
				
				return o;
			}
		});
		btnCriar.setBounds(287, 336, 89, 23);
		frmNovoOramento.getContentPane().add(btnCriar);
	}
//.
//	.
//	.
//	.
//	.
//	.
//	.
//	.
//	.
//	.
//	.
//	.
//	.
//	.
	
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
				DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
				nome1 = (String) model.getValueAt(tblProdutos.getSelectedRow(), 1);
				valor1 = (Double) model.getValueAt(tblProdutos.getSelectedRow(), 3);

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
				DefaultTableModel modelClientes = (DefaultTableModel) tblServico.getModel();
				nome1 = (String) modelClientes.getValueAt(tblServico.getSelectedRow(), 1);
				valor1 = (Double) modelClientes.getValueAt(tblServico.getSelectedRow(), 2);

			}
		});
		tblServico.setModel(new DefaultTableModel(new Object[][] { { "ID", "Nome", "Valor" }, },
				new String[] { "ID", "Nome", "Valor" }));
		scrollPaneServicos.setColumnHeaderView(tblServico);

		JButton btnImportarProduto = new JButton("Importar");
		btnImportarProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preencherItemProdutos();
				DefaultTableModel modelo = (DefaultTableModel) tblServicosProdutos.getModel();

				
				modelo.insertRow(tblServicosProdutos.getRowCount(), retornoProdutos);
				
				
				
			}
		});
		btnImportarProduto.setBounds(10, 425, 89, 23);
		frame.getContentPane().add(btnImportarProduto);
		
		JButton brnImportarServico = new JButton("Importar");
		brnImportarServico.setBounds(508, 425, 89, 23);
		frame.getContentPane().add(brnImportarServico);
		readJTableProdutos1();
	}

	protected Vector<String> preencherItemProdutos() {
		retornoProdutos.clear();
		
		retornoProdutos.add(nome1);
		retornoProdutos.add(String.valueOf(valor1));
		
		return retornoProdutos;
		
	}		
	public void readJTableProdutos1() {

		DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
		modelo.setNumRows(0);
		ProdutoDAO pdao = new ProdutoDAO();

		modelo.addRow(new Object[] { "ID", "Nome", "Custo", "Preco", "Quantidade" });

		for (ProdutoVO p : pdao.listarTodos()) {

			modelo.addRow(new Object[] {

					p.getId(), p.getNome(), p.getCusto(), p.getPreco(), p.getQuantidade() });
		}
	}
	
	public void readJtblServico1() {

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
	
}
