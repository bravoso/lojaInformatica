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

public class Principal extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 1200, 700);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-produto-50.png"));
		menuBar.add(mnProdutos);

		JMenuItem mnCadastrar = new JMenuItem("Cadastrar");
		mnCadastrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnCadastrar.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-adicionar-o-carrinho-de-compras-50.png"));
		mnProdutos.add(mnCadastrar);

		JMenuItem mnListar = new JMenuItem("Listar");
		mnListar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mnListar.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-no-invent\u00E1rio-50.png"));
		mnProdutos.add(mnListar);

		JMenuItem mnRelatrio = new JMenuItem("Relat\u00F3rio");
		mnRelatrio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mnRelatrio.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-contabilidade-50.png"));
		mnProdutos.add(mnRelatrio);

		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-grupo-de-usu\u00E1rio-homem-homem-50.png"));
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
		mnCadastrar_1.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-adicionar-usu\u00E1rio-masculino-50.png"));
		mnClientes.add(mnCadastrar_1);

		JMenuItem mnListar_1 = new JMenuItem("Listar");
		mnListar_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_MASK));
		mnListar_1.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-procurar-usu\u00E1rio-masculino-50.png.png"));
		mnClientes.add(mnListar_1);

		JMenuItem mnRelatrio_1 = new JMenuItem("Relat\u00F3rio");
		mnRelatrio_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.CTRL_MASK));
		mnRelatrio_1.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-boletim-50.png"));
		mnClientes.add(mnRelatrio_1);

		JMenu mnFuncionrios = new JMenu("Funcion\u00E1rios");
		mnFuncionrios.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-funcion\u00E1rio-homem-50.png"));
		menuBar.add(mnFuncionrios);

		JMenuItem mnCadastrar_2 = new JMenuItem("Cadastrar");
		mnCadastrar_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.SHIFT_MASK));
		mnCadastrar_2.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-adicionar-usu\u00E1rio-masculino-50.png"));
		mnFuncionrios.add(mnCadastrar_2);

		JMenuItem mnListar_2 = new JMenuItem("Listar");
		mnListar_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.SHIFT_MASK));
		mnListar_2.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-procurar-usu\u00E1rio-masculino-50.png.png"));
		mnFuncionrios.add(mnListar_2);

		JMenuItem mnRelatrio_2 = new JMenuItem("Relat\u00F3rio");
		mnRelatrio_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.SHIFT_MASK));
		mnRelatrio_2.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-boletim-50.png"));
		mnFuncionrios.add(mnRelatrio_2);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-informa\u00E7\u00F5es-50.png"));
		menuBar.add(mnSobre);

		JMenuItem mnAjuda = new JMenuItem("Ajuda");
		mnAjuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnAjuda.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-ajuda-50.png"));
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
		mnVerso.setIcon(new ImageIcon(
				"C:\\Users\\Guilherme Corr\u00EAa\\git\\senac-dd-20182-atividades-guilhermecorrea\\src\\br\\sc\\senac\\dd\\aula10\\icones\\icons8-vers\u00F5es-50.png"));
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

		JPanel servico = new JPanel();
		tpAbas.addTab("Orçamentos", iconeOrcamento, servico, null);

		JPanel pnProdutos = new JPanel();
		tpAbas.addTab("Produtos", iconeProdutos, pnProdutos, null);

		JPanel pnServico = new JPanel();
		tpAbas.addTab("Serviços", iconeServicos, pnServico, null);
		tpAbas.addTab("Clientes", iconeClientes, pnClientes, null);
		pnClientes.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1144, 538);
		pnClientes.add(tabbedPane);

		JPanel pnClientesCadastro = new JPanel();
		ImageIcon iconeAddCliente = new ImageIcon(Principal.class.getResource("/icons/icons8-add-48.png"));
		tabbedPane.addTab("Cadastrar", iconeAddCliente, pnClientesCadastro, null);

		JPanel pnClienteLista = new JPanel();
		tabbedPane.addTab("Listar Clientes", iconeClienteLista, pnClienteLista, null);

	}
}
