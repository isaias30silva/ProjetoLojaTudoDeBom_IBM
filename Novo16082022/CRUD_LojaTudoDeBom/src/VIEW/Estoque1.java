package VIEW;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DTO.cadastroDTO;
import DTO.produtoDTO;
import connection.ClienteDAO;
import connection.ProdutoDAO;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JScrollPane;

public class Estoque1 extends JInternalFrame {
	private JTextField txtNomeProduto;
	private JTextField txtCodigo;
	private JTable tableProduto;
	private JTextField txtRegistro;
	private JTextField txtPreco;
	private JTextField txtDataf;
	private JTextField txtDatav;
	private JTextField txtDesconto;
	private JTextField txtQuant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estoque1 frame = new Estoque1();
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
	public Estoque1() {
		setIconifiable(true);
		setMaximizable(true);
		setFocusable(false);
		setFocusTraversalKeysEnabled(false);
		setFocusCycleRoot(false);
		setClosable(true);
		setBounds(100, 100, 840, 495);
		getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(0, 0, 812, 464);
		getContentPane().add(contentPane);
		
		JTextPane txtpnGestoDeEstoque = new JTextPane();
		txtpnGestoDeEstoque.setEditable(false);
		txtpnGestoDeEstoque.setText("GESTÃO DE ESTOQUE");
		txtpnGestoDeEstoque.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnGestoDeEstoque.setBounds(10, 24, 251, 31);
		contentPane.add(txtpnGestoDeEstoque);
		
		JTextPane txtpnCadastrarProduto = new JTextPane();
		txtpnCadastrarProduto.setEditable(false);
		txtpnCadastrarProduto.setText("CADASTRAR PRODUTO");
		txtpnCadastrarProduto.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnCadastrarProduto.setBounds(10, 62, 185, 22);
		contentPane.add(txtpnCadastrarProduto);
		
		JTextPane txtpnCdigo = new JTextPane();
		txtpnCdigo.setEditable(false);
		txtpnCdigo.setText("Código");
		txtpnCdigo.setBounds(20, 95, 43, 20);
		contentPane.add(txtpnCdigo);
		
		JTextPane txtpnNome_1 = new JTextPane();
		txtpnNome_1.setEditable(false);
		txtpnNome_1.setText("Nome");
		txtpnNome_1.setBounds(20, 126, 43, 20);
		contentPane.add(txtpnNome_1);
		
		JTextPane txtpnNome_3 = new JTextPane();
		txtpnNome_3.setEditable(false);
		txtpnNome_3.setText("Data de Vencimento (00/00/0000)");
		txtpnNome_3.setBounds(374, 126, 185, 20);
		contentPane.add(txtpnNome_3);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setColumns(10);
		txtNomeProduto.setBounds(84, 126, 271, 20);
		contentPane.add(txtNomeProduto);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(84, 95, 64, 20);
		contentPane.add(txtCodigo);
		
		JButton btnCadastrarP = new JButton("CADASTRAR");
		btnCadastrarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarProduto();
				MostrarProdutos();
				LimparCampos();
				
			}
		});
		btnCadastrarP.setBounds(206, 188, 139, 22);
		contentPane.add(btnCadastrarP);
		
		JButton btnListarP = new JButton("LISTAR PRODUTOS");
		btnListarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarProdutos();
			}
		});
		btnListarP.setBounds(20, 188, 155, 22);
		contentPane.add(btnListarP);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 231, 770, 222);
		contentPane.add(scrollPane);
		
		tableProduto = new JTable();
		scrollPane.setViewportView(tableProduto);
		tableProduto.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		tableProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "PRODUTO", "REGISTRO/MS", "DATA FABR.", "DATA VENC.", "PRE\u00C7O", "PRE\u00C7O C/ DESC.", "QUANT."
			}
		));
		tableProduto.getColumnModel().getColumn(0).setPreferredWidth(52);
		tableProduto.getColumnModel().getColumn(1).setPreferredWidth(118);
		tableProduto.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JTextPane txtpnNome_2_1 = new JTextPane();
		txtpnNome_2_1.setEditable(false);
		txtpnNome_2_1.setText("Registro/MS");
		txtpnNome_2_1.setBounds(172, 95, 85, 20);
		contentPane.add(txtpnNome_2_1);
		
		txtRegistro = new JTextField();
		txtRegistro.setColumns(10);
		txtRegistro.setBounds(270, 95, 85, 20);
		contentPane.add(txtRegistro);
		
		JTextPane txtpnNome_3_1 = new JTextPane();
		txtpnNome_3_1.setEditable(false);
		txtpnNome_3_1.setText("Data de Fabricação (00/00/0000)");
		txtpnNome_3_1.setBounds(375, 95, 200, 20);
		contentPane.add(txtpnNome_3_1);
		
		JTextPane txtpnValorUnit = new JTextPane();
		txtpnValorUnit.setEditable(false);
		txtpnValorUnit.setText("VALOR UNIT. R$");
		txtpnValorUnit.setBounds(461, 157, 109, 20);
		contentPane.add(txtpnValorUnit);
		
		txtPreco = new JTextField();
		txtPreco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtPreco.setColumns(10);
		txtPreco.setBounds(591, 157, 86, 20);
		contentPane.add(txtPreco);
		
		txtDataf = new JTextField();
		txtDataf.setColumns(10);
		txtDataf.setBounds(579, 95, 98, 20);
		contentPane.add(txtDataf);
		
		txtDatav = new JTextField();
		txtDatav.setColumns(10);
		txtDatav.setBounds(579, 126, 98, 20);
		contentPane.add(txtDatav);
		
		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		txtDesconto.setBounds(591, 189, 86, 20);
		contentPane.add(txtDesconto);
		
		JButton btnGenerico = new JButton("Genéricos - 20% desconto");
		btnGenerico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aplicarDesconto();
			}
		});
		btnGenerico.setBounds(374, 188, 185, 23);
		contentPane.add(btnGenerico);
		
		txtQuant = new JTextField();
		txtQuant.setColumns(10);
		txtQuant.setBounds(416, 159, 35, 20);
		contentPane.add(txtQuant);
		
		JTextPane txtpnNome_3_2 = new JTextPane();
		txtpnNome_3_2.setText("Quant.");
		txtpnNome_3_2.setEditable(false);
		txtpnNome_3_2.setBounds(374, 159, 43, 20);
		contentPane.add(txtpnNome_3_2);

	}

	// Métodos
	
	private void CadastrarProduto() {
		
		String  nomeProduto, codigo, registro, dataf, datav, preco, desconto,quant;
		
		codigo = txtCodigo.getText();
		registro = txtRegistro.getText();
		dataf = txtDataf.getText();
		datav = txtDatav.getText();
		preco = txtPreco.getText();
		desconto = txtDesconto.getText();
		quant = txtQuant.getText();
		
		nomeProduto = txtNomeProduto.getText();
	
		
		produtoDTO objproduto = new produtoDTO();
		objproduto.setCodigo_produto(codigo);
		objproduto.setNome_produto(nomeProduto);
		objproduto.setRegistro_produto(registro);
		objproduto.setDataf_produto(dataf);
		objproduto.setDatav_produto(datav);
		objproduto.setPreco_produto(preco);
		objproduto.setPrecod_produto(desconto);
		objproduto.setQuant1_produto(quant);

		
		ProdutoDAO objprodutodao = new ProdutoDAO();
		objprodutodao.cadastrarProduto(objproduto);
	
	}
	
	private void LimparCampos() {
		txtCodigo.setText("");
		txtRegistro.setText("");
		txtNomeProduto.setText("");
		txtDataf.setText("");
		txtDatav.setText("");
		txtPreco.setText("");
		txtDesconto.setText("");
		txtQuant.setText("");
		txtCodigo.requestFocus();
	}
	
	private void MostrarProdutos() {
		try {
			ProdutoDAO objproduto = new ProdutoDAO();
			
			DefaultTableModel model = (DefaultTableModel) tableProduto.getModel();
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
	
	
	private void aplicarDesconto() {
		double num1 = Double.parseDouble(txtPreco.getText().replaceAll(",", "."));
		
		double resultado = num1 * 0.80;
		
		txtDesconto.setText(String.valueOf(resultado).format("%.2f", resultado));
	}
}