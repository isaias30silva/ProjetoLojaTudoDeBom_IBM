package VIEW;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

import javax.swing.JDesktopPane;

public class Escolha extends JFrame {

	private JPanel telaEscolha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Escolha frame = new Escolha();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Escolha() {
		setTitle("SISTEMA DE GERENCIAMENTO - LOJA TUDO DE BOM ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 495);
		telaEscolha = new JPanel();
		telaEscolha.setBackground(Color.WHITE);
		telaEscolha.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaEscolha);
		telaEscolha.setLayout(null);
		
		JDesktopPane escolher = new JDesktopPane();
		escolher.setBackground(Color.WHITE);
		escolher.setBounds(0, 0, 800, 456);
		telaEscolha.add(escolher);
		
		JButton btnNewButton = new JButton("GESTÃO DE CLIENTES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes1 objCliente = new Clientes1();
				escolher.add(objCliente);
				objCliente.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 193, 189, 70);
		escolher.add(btnNewButton);
		
		JEditorPane dtrpnCadastroDe = new JEditorPane();
		dtrpnCadastroDe.setEditable(false);
		dtrpnCadastroDe.setText("- Cadastrar Clientes\r\n- Listar Clientes\r\n- Atualizar Clientes\r\n- Excluir Clientes");
		dtrpnCadastroDe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dtrpnCadastroDe.setBounds(20, 274, 156, 84);
		escolher.add(dtrpnCadastroDe);
		
		JButton btnRegistroDeCompra = new JButton("REGISTRO DE COMPRA");
		btnRegistroDeCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compras1 objCompras = new Compras1();
				escolher.add(objCompras);
				objCompras.setVisible(true);
			}
		});
		btnRegistroDeCompra.setBounds(209, 193, 183, 70);
		escolher.add(btnRegistroDeCompra);
		
		JEditorPane dtrpnTabelaDe = new JEditorPane();
		dtrpnTabelaDe.setEditable(false);
		dtrpnTabelaDe.setText("- Registrar compras\r\n- Consultar Tabela de \r\n  Produtos ");
		dtrpnTabelaDe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dtrpnTabelaDe.setBounds(219, 274, 156, 60);
		escolher.add(dtrpnTabelaDe);
		
		JButton btnNewButton_1_1 = new JButton("HISTÓRICO");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historico1 objHistorico = new Historico1();
				escolher.add(objHistorico);
				objHistorico.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(402, 193, 183, 70);
		escolher.add(btnNewButton_1_1);
		
		JEditorPane dtrpnConsultarCompras = new JEditorPane();
		dtrpnConsultarCompras.setEditable(false);
		dtrpnConsultarCompras.setText("- Consultar compras \r\n   realizadas\r\n- Histórico de compras \r\n   por cliente");
		dtrpnConsultarCompras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dtrpnConsultarCompras.setBounds(402, 274, 156, 84);
		escolher.add(dtrpnConsultarCompras);
		
		JButton btnNewButton_1_1_1 = new JButton("GESTÃO DE ESTOQUE");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoque1 objEstoque = new Estoque1();
				escolher.add(objEstoque);
				objEstoque.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setBounds(591, 193, 199, 70);
		escolher.add(btnNewButton_1_1_1);
		
		JEditorPane dtrpnConsultarEstoque = new JEditorPane();
		dtrpnConsultarEstoque.setEditable(false);
		dtrpnConsultarEstoque.setText("- Consultar estoque\r\n- Histórico de cadastro \r\n- Itens mais vendidos");
		dtrpnConsultarEstoque.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dtrpnConsultarEstoque.setBounds(601, 274, 156, 84);
		escolher.add(dtrpnConsultarEstoque);
		
		JTextPane txtpnEscolhaUmaDas = new JTextPane();
		txtpnEscolhaUmaDas.setEditable(false);
		txtpnEscolhaUmaDas.setText("ESCOLHA UMA DAS OPÇÕES");
		txtpnEscolhaUmaDas.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnEscolhaUmaDas.setBounds(263, 74, 268, 36);
		escolher.add(txtpnEscolhaUmaDas);
	}
}
