package VIEW;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import DTO.cadastroDTO;
import DTO.produtoDTO;
import DTO.relatorioDTO;

import connection.ConexaoDAO1;
import connection.ConexaoDAO2;
import connection.RelatorioDAO;
import connection.ConexaoDAO;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import VIEW.Compras1;
import VIEW.Clientes1;
import VIEW.Estoque1;
import connection.ClienteDAO;

public class Historico1 extends JInternalFrame {
	private JTable tableRelatorio1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Historico1 frame = new Historico1();
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
	public Historico1() {
		setMaximizable(true);
		setFocusTraversalKeysEnabled(false);
		setFocusCycleRoot(false);
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 842, 486);
		getContentPane().setLayout(null);
		
		JTextPane txtpnHistrico = new JTextPane();
		txtpnHistrico.setEditable(false);
		txtpnHistrico.setText("HISTÓRICO DE COMPRAS");
		txtpnHistrico.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnHistrico.setBounds(10, 11, 372, 40);
		getContentPane().add(txtpnHistrico);
		
		JTextPane txtpnConsulteAsCompras = new JTextPane();
		txtpnConsulteAsCompras.setEditable(false);
		txtpnConsulteAsCompras.setText("Consulte as compras realizadas pelos clientes clicando no botão \"PESQUISAR\".\r\nAs informações serão apresentadas na tabela logo abaixo.");
		txtpnConsulteAsCompras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnConsulteAsCompras.setBounds(10, 54, 519, 40);
		getContentPane().add(txtpnConsulteAsCompras);
		
		JButton btnNewButton = new JButton("PESQUISAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerarRelatorio();
			}
		});
		btnNewButton.setBounds(10, 100, 106, 34);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 156, 762, 276);
		getContentPane().add(scrollPane);
		
		tableRelatorio1 = new JTable();
		tableRelatorio1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PRODUTO", "CLIENTE", "CPF", "DATA", "QUANT."
			}
		));
		tableRelatorio1.getColumnModel().getColumn(0).setPreferredWidth(107);
		tableRelatorio1.getColumnModel().getColumn(1).setPreferredWidth(276);
		tableRelatorio1.getColumnModel().getColumn(2).setPreferredWidth(89);
		scrollPane.setViewportView(tableRelatorio1);
		tableRelatorio1.setBorder(new LineBorder(new Color(0, 0, 0)));

	}
	
	
	private void GerarRelatorio() {
		try {
			RelatorioDAO objrelatoriodao = new RelatorioDAO();
			
			DefaultTableModel model = (DefaultTableModel) tableRelatorio1.getModel();
			model.setNumRows(0);
			
			ArrayList<relatorioDTO> lista = objrelatoriodao.GerarRelatorio();
			
			for(int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] {
					lista.get(num).getCodigo_produto(),
					lista.get(num).getNome_cliente(),
					lista.get(num).getCpf_cliente(),
					lista.get(num).getData_compra(),
					lista.get(num).getQuant_produto(),
				});
			}
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Listar Produto VIEW: " + erro);
		}
	
}
	

}
