package VIEW;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DTO.cadastroDTO;
import DTO.produtoDTO;
import connection.ClienteDAO;
import connection.ProdutoDAO;
import connection.RelatorioDAO;
import VIEW.Estoque1;
import DTO.relatorioDTO;
import connection.ConexaoDAO2;
import connection.ConexaoDAO1;

import javax.swing.JTextPane;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.Component;

public class Compras1 extends JInternalFrame {
	private JTable tableProduto1;
	private JTextField txtTotal;
	private JTextField txtQuant;
	private JTable tableCliente1;
	private JTextField txtTotal1;
	private JTextField txtDesconto;
	private JTextField txtNomeCliente;
	private JTextField txtProdutoNome;
	private JTextField txtCPFNome;
	private JTextField txtDataNome;
	private JTextField txtIDCliente;
	private JTextField txtCodigoProduto;
	private JTextField txtEstoque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compras1 frame = new Compras1();
					frame.setVisible(true);
					frame.setLocation(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Compras1() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("REGISTRO DE COMPRAS");
		setBounds(100, 100, 833, 558);
		getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(10, 11, 817, 528);
		getContentPane().add(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(10, 135, 770, 102);
		contentPane.add(scrollPane);
		
		tableProduto1 = new JTable();
		scrollPane.setViewportView(tableProduto1);
		tableProduto1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "PRODUTO", "REGISTRO/MS", "DATA FABR.", "DATA VENC.", "PRE\u00C7O", "PRE\u00C7O DESC.", "QUANT."
			}
		));
		tableProduto1.getColumnModel().getColumn(0).setPreferredWidth(56);
		tableProduto1.getColumnModel().getColumn(1).setPreferredWidth(124);
		tableProduto1.getColumnModel().getColumn(2).setPreferredWidth(92);
		tableProduto1.getColumnModel().getColumn(3).setPreferredWidth(70);
		tableProduto1.getColumnModel().getColumn(4).setPreferredWidth(72);
		tableProduto1.getColumnModel().getColumn(7).setPreferredWidth(54);
		tableProduto1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JTextPane txtpnQuantidade = new JTextPane();
		txtpnQuantidade.setEditable(false);
		txtpnQuantidade.setText("QUANTIDADE");
		txtpnQuantidade.setBounds(155, 282, 78, 20);
		contentPane.add(txtpnQuantidade);
		
		JButton btnNewButton = new JButton("REGISTRAR COMPRA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerarRelatorio();
			}
		});
		btnNewButton.setBounds(614, 282, 157, 32);
		contentPane.add(btnNewButton);
		
		txtTotal = new JTextField();
		txtTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(80, 267, 65, 20);
		contentPane.add(txtTotal);
		
		JTextPane txtpnTotal = new JTextPane();
		txtpnTotal.setEditable(false);
		txtpnTotal.setText("TOTAL");
		txtpnTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnTotal.setBounds(420, 294, 47, 20);
		contentPane.add(txtpnTotal);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				somarIntegral();
				somarDesconto();
			}
		});
		btnCalcular.setBounds(283, 267, 125, 20);
		contentPane.add(btnCalcular);
		
		txtQuant = new JTextField();
		txtQuant.setEditable(false);
		txtQuant.setBounds(237, 282, 32, 23);
		contentPane.add(txtQuant);
		txtQuant.setColumns(10);
		
		JButton btnPesquisar = new JButton("BUSCAR CLIENTE");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarCliente();
				MostrarProduto();
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPesquisar.setBounds(10, 11, 139, 23);
		contentPane.add(btnPesquisar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane_1.setBounds(10, 33, 770, 69);
		contentPane.add(scrollPane_1);
		
		tableCliente1 = new JTable();
		tableCliente1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		tableCliente1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "CPF", "EMAIL", "TELEFONE"
			}
		));
		tableCliente1.getColumnModel().getColumn(0).setPreferredWidth(38);
		tableCliente1.getColumnModel().getColumn(1).setPreferredWidth(216);
		tableCliente1.getColumnModel().getColumn(2).setPreferredWidth(86);
		tableCliente1.getColumnModel().getColumn(3).setPreferredWidth(184);
		tableCliente1.getColumnModel().getColumn(4).setPreferredWidth(87);
		scrollPane_1.setViewportView(tableCliente1);
		
		JButton btnSelecionarCliente = new JButton("SELECIONAR");
		btnSelecionarCliente.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSelecionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setarCamposCliente();
			}
		});
		btnSelecionarCliente.setBounds(10, 105, 101, 19);
		contentPane.add(btnSelecionarCliente);
		
		JButton btnSelecionarProduto = new JButton("SELECIONAR");
		btnSelecionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setarCamposProduto();
				setarPrecoProduto();
				setarPrecoProdutoDesconto();
				
			}
		});
		btnSelecionarProduto.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSelecionarProduto.setBounds(10, 237, 101, 19);
		contentPane.add(btnSelecionarProduto);
		
		txtTotal1 = new JTextField();
		txtTotal1.setEditable(false);
		txtTotal1.setBounds(474, 282, 130, 32);
		contentPane.add(txtTotal1);
		txtTotal1.setColumns(10);
		
		txtDesconto = new JTextField();
		txtDesconto.setEditable(false);
		txtDesconto.setColumns(10);
		txtDesconto.setBounds(80, 298, 65, 20);
		contentPane.add(txtDesconto);
		
		JButton btnCalcular_1 = new JButton("APLICAR DESC.");
		btnCalcular_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCalcular_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				somarDesconto();
			}
		});
		btnCalcular_1.setBounds(283, 300, 127, 20);
		contentPane.add(btnCalcular_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setBounds(10, 321, 607, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnDataDaCompra_1_2 = new JTextPane();
		txtpnDataDaCompra_1_2.setText("RESUMO DA COMPRA");
		txtpnDataDaCompra_1_2.setEditable(false);
		txtpnDataDaCompra_1_2.setBounds(0, 0, 138, 20);
		panel.add(txtpnDataDaCompra_1_2);
		
		JTextPane txtpnCliente = new JTextPane();
		txtpnCliente.setText("CLIENTE");
		txtpnCliente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnCliente.setEditable(false);
		txtpnCliente.setBounds(0, 31, 61, 20);
		panel.add(txtpnCliente);
		
		JTextPane txtpnProduto = new JTextPane();
		txtpnProduto.setText("PRODUTO");
		txtpnProduto.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnProduto.setEditable(false);
		txtpnProduto.setBounds(0, 52, 61, 20);
		panel.add(txtpnProduto);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setEditable(false);
		txtNomeCliente.setBounds(71, 31, 214, 20);
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		txtProdutoNome = new JTextField();
		txtProdutoNome.setEditable(false);
		txtProdutoNome.setColumns(10);
		txtProdutoNome.setBounds(71, 52, 214, 20);
		panel.add(txtProdutoNome);
		
		JTextPane txtpnCpf = new JTextPane();
		txtpnCpf.setText("CPF");
		txtpnCpf.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnCpf.setEditable(false);
		txtpnCpf.setBounds(295, 31, 71, 20);
		panel.add(txtpnCpf);
		
		JTextPane txtpnCliente_1_1 = new JTextPane();
		txtpnCliente_1_1.setText("DATA");
		txtpnCliente_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnCliente_1_1.setEditable(false);
		txtpnCliente_1_1.setBounds(295, 52, 71, 20);
		panel.add(txtpnCliente_1_1);
		
		txtCPFNome = new JTextField();
		txtCPFNome.setEditable(false);
		txtCPFNome.setColumns(10);
		txtCPFNome.setBounds(351, 31, 138, 20);
		panel.add(txtCPFNome);
		
		txtDataNome = new JTextField();
		txtDataNome.setColumns(10);
		txtDataNome.setBounds(361, 52, 128, 20);
		panel.add(txtDataNome);
		
		txtEstoque = new JTextField();
		txtEstoque.setEditable(false);
		txtEstoque.setBounds(508, 11, 89, 40);
		panel.add(txtEstoque);
		txtEstoque.setColumns(10);
		
		JTextPane txtpnDataDaCompra_1_2_1 = new JTextPane();
		txtpnDataDaCompra_1_2_1.setEditable(false);
		txtpnDataDaCompra_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnDataDaCompra_1_2_1.setText("ESTOQUE");
		txtpnDataDaCompra_1_2_1.setBounds(528, 52, 54, 20);
		panel.add(txtpnDataDaCompra_1_2_1);
		
		JTextPane txtpnIntegral = new JTextPane();
		txtpnIntegral.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtpnIntegral.setText("INTEGRAL");
		txtpnIntegral.setEditable(false);
		txtpnIntegral.setBounds(10, 267, 71, 20);
		contentPane.add(txtpnIntegral);
		
		JTextPane txtpnDesconto = new JTextPane();
		txtpnDesconto.setText("DESCONTO");
		txtpnDesconto.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtpnDesconto.setEditable(false);
		txtpnDesconto.setBounds(10, 298, 70, 20);
		contentPane.add(txtpnDesconto);
		
		JButton btnFinalizarCompra = new JButton("FINALIZAR COMPRA");
		btnFinalizarCompra.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCompra();
			}
		});
		btnFinalizarCompra.setBounds(624, 325, 139, 57);
		contentPane.add(btnFinalizarCompra);
		
		txtIDCliente = new JTextField();
		txtIDCliente.setEditable(false);
		txtIDCliente.setBounds(748, 12, 32, 20);
		contentPane.add(txtIDCliente);
		txtIDCliente.setColumns(10);
		
		txtCodigoProduto = new JTextField();
		txtCodigoProduto.setEditable(false);
		txtCodigoProduto.setColumns(10);
		txtCodigoProduto.setBounds(748, 115, 32, 20);
		contentPane.add(txtCodigoProduto);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setText("ID");
		txtpnId.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnId.setEditable(false);
		txtpnId.setBounds(676, 14, 71, 20);
		contentPane.add(txtpnId);
		
		JTextPane txtpnCdigo = new JTextPane();
		txtpnCdigo.setText("CÓDIGO");
		txtpnCdigo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnCdigo.setEditable(false);
		txtpnCdigo.setBounds(676, 115, 71, 20);
		contentPane.add(txtpnCdigo);

	}
	
		private void RegistrarCompra() {
		
			String nome_produto, nome_cliente, cpf_cliente, data, quant;
		
			nome_produto = txtProdutoNome.getText();
			nome_cliente = txtNomeCliente.getText();
			cpf_cliente = txtCPFNome.getText();
			data = txtDataNome.getText();
			quant = txtQuant.getText();
		
			relatorioDTO objrelatoriodto = new relatorioDTO();
			objrelatoriodto.setCodigo_produto(nome_produto);
			objrelatoriodto.setNome_cliente(nome_cliente);
			objrelatoriodto.setCpf_cliente(cpf_cliente);
			objrelatoriodto.setData_compra(data);
			objrelatoriodto.setQuant_produto(quant);

		
		RelatorioDAO objrelatoriodao = new RelatorioDAO();
		objrelatoriodao.cadastrarRelatorio(objrelatoriodto);
	}

	
	private void BuscarCliente() {
		try {
			ClienteDAO objclientedao = new ClienteDAO();
			
			DefaultTableModel model = (DefaultTableModel) tableCliente1.getModel();
			model.setNumRows(0);
			
			ArrayList<cadastroDTO> lista = objclientedao.ListarCliente();
			
			for(int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] {
					lista.get(num).getId_cliente(),
					lista.get(num).getNome_cliente(),
					lista.get(num).getCpf_cliente(),
					lista.get(num).getEmail_cliente(),
					lista.get(num).getTelefone_cliente(),
				});
			}
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Listar Cliente VIEW: " + erro);
		}
	}
	
	private void MostrarProduto() {
		try {
			ProdutoDAO objproduto = new ProdutoDAO();
			
			DefaultTableModel model = (DefaultTableModel) tableProduto1.getModel();
			model.setNumRows(0);
			
			ArrayList<produtoDTO> lista = objproduto.ListarProduto();
			
			for(int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] {
					lista.get(num).getCodigo_produto(),
					lista.get(num).getNome_produto(),
					lista.get(num).getRegistro_produto(),
					lista.get(num).getDataf_produto(),
					lista.get(num).getDatav_produto(),
					lista.get(num).getPreco_produto(),
					lista.get(num).getPrecod_produto(),
					lista.get(num).getQuant1_produto(),
				});
			}
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Listar Produto VIEW: " + erro);
		}
	}
	
	private void setarCamposCliente() {
		int set = tableCliente1.getSelectedRow();
		
		txtIDCliente.setText(tableCliente1.getModel().getValueAt(set, 0).toString());
	}
	
	private void setarCamposProduto() {
		int set = tableProduto1.getSelectedRow();
		
		txtCodigoProduto.setText(tableProduto1.getModel().getValueAt(set, 0).toString());
	}
	
	private void setarPrecoProduto() {
		int set = tableProduto1.getSelectedRow();
		
		txtTotal.setText(tableProduto1.getModel().getValueAt(set, 5).toString());
	}
	
	private void setarPrecoProdutoDesconto() {
		int set = tableProduto1.getSelectedRow();
		
		txtDesconto.setText(tableProduto1.getModel().getValueAt(set, 7).toString());
	}
	
	private void somarIntegral() {
		double num1 = Double.parseDouble(txtTotal.getText());
		double num2 = Double.parseDouble(txtQuant.getText());
		
		double resultado = num1 * num2;
		
		txtTotal1.setText(""+resultado);
	}
	
	private void somarDesconto() {
		double num1 = Double.parseDouble(txtDesconto.getText());
		double num2 = Double.parseDouble(txtQuant.getText());
		
		double resultado = num1 * num2;
		
		txtTotal1.setText(""+resultado);
	}
	
	private void GerarRelatorio() {
		int set = tableCliente1.getSelectedRow();
		int get = tableProduto1.getSelectedRow();
		
		txtNomeCliente.setText(tableCliente1.getModel().getValueAt(set, 1).toString());
		txtCPFNome.setText(tableCliente1.getModel().getValueAt(set,2).toString());
		txtProdutoNome.setText(tableProduto1.getModel().getValueAt(get, 1).toString());
		txtEstoque.setText(tableProduto1.getModel().getValueAt(get, 7).toString());
		txtDataNome.setText(getName());
	}

	

}
