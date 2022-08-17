package VIEW;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DTO.cadastroDTO;
import connection.ClienteDAO;
import DTO.produtoDTO;
import DTO.relatorioDTO;
import connection.RelatorioDAO;
import connection.ProdutoDAO;
import connection.ConexaoDAO;
import connection.ConexaoDAO1;
import connection.ConexaoDAO2;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Clientes1 extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtID;
	private JTable tableCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes1 frame = new Clientes1();
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
	public Clientes1() {
		
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setForeground(Color.WHITE);
		setTitle("Gestão de Clientes");
		setBounds(100, 100, 809, 503);
		getContentPane().setLayout(null);
		
		JTextPane txtpnCadastrarCliente = new JTextPane();
		txtpnCadastrarCliente.setBounds(10, 47, 149, 22);
		txtpnCadastrarCliente.setEditable(false);
		txtpnCadastrarCliente.setText("CADASTRAR CLIENTE");
		txtpnCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(txtpnCadastrarCliente);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setBounds(20, 80, 43, 20);
		txtpnNome.setEditable(false);
		txtpnNome.setText("Nome");
		getContentPane().add(txtpnNome);
		
		JTextPane txtpnNome_1 = new JTextPane();
		txtpnNome_1.setBounds(20, 111, 43, 20);
		txtpnNome_1.setEditable(false);
		txtpnNome_1.setText("CPF");
		getContentPane().add(txtpnNome_1);
		
		JTextPane txtpnNome_2 = new JTextPane();
		txtpnNome_2.setBounds(20, 140, 43, 20);
		txtpnNome_2.setEditable(false);
		txtpnNome_2.setText("Email");
		getContentPane().add(txtpnNome_2);
		
		JTextPane txtpnNome_3 = new JTextPane();
		txtpnNome_3.setBounds(20, 171, 59, 20);
		txtpnNome_3.setEditable(false);
		txtpnNome_3.setText("Telefone");
		getContentPane().add(txtpnNome_3);
		
		txtNome = new JTextField();
		txtNome.setBounds(84, 80, 271, 20);
		txtNome.setColumns(10);
		getContentPane().add(txtNome);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(84, 111, 271, 20);
		txtCpf.setColumns(10);
		getContentPane().add(txtCpf);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(84, 140, 271, 20);
		txtEmail.setColumns(10);
		getContentPane().add(txtEmail);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(84, 171, 271, 20);
		txtTelefone.setColumns(10);
		getContentPane().add(txtTelefone);
		
		JButton btnPesquisar = new JButton("LISTAR CLIENTES");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPesquisar.setBounds(20, 211, 139, 23);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarCliente();
			}
		});
		getContentPane().add(btnPesquisar);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCadastrar.setBounds(250, 211, 105, 23);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente();
				SetarCampos();
				BuscarCliente();
			}
		});
		getContentPane().add(btnCadastrar);
		
		JTextPane txtpnExcluirClientes = new JTextPane();
		txtpnExcluirClientes.setBounds(412, 140, 139, 22);
		txtpnExcluirClientes.setEditable(false);
		txtpnExcluirClientes.setText("EXCLUIR CLIENTES");
		txtpnExcluirClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(txtpnExcluirClientes);
		
		JTextPane txtpnListarClientes = new JTextPane();
		txtpnListarClientes.setBounds(412, 47, 139, 22);
		txtpnListarClientes.setEditable(false);
		txtpnListarClientes.setText("ALTERAR CLIENTES");
		txtpnListarClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(txtpnListarClientes);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.setBounds(461, 392, 142, 23);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(null, "Confirma a alteração de dados do Cliente?", "CONFIRMAÇÃO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					AlterarCliente();
					BuscarCliente();
					SetarCampos();
				}
			}
		});
		getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(621, 392, 142, 23);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(null, "Confirma a exclusão do Cliente?", "CONFIRMAÇÃO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					ExcluirCliente();
					SetarCampos();
					BuscarCliente();
				}
			}
		});
		getContentPane().add(btnExcluir);
		
		JTextPane txtpnParaAlterarUm = new JTextPane();
		txtpnParaAlterarUm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnParaAlterarUm.setBounds(412, 67, 351, 67);
		txtpnParaAlterarUm.setEditable(false);
		txtpnParaAlterarUm.setText("Para alterar um cadastro, clique no botão \"LISTAR CLIENTES\", clique sobre o cadastro desejado na tabela e depois no botão \"SELECIONAR\". Altere os campos da área \"CADASTRAR CLIENTE\" e clique em \"ALTERAR\" para confirmar.");
		getContentPane().add(txtpnParaAlterarUm);
		
		JTextPane txtpnParaExcluirUm = new JTextPane();
		txtpnParaExcluirUm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnParaExcluirUm.setBounds(412, 160, 351, 54);
		txtpnParaExcluirUm.setEditable(false);
		txtpnParaExcluirUm.setText("Para excluir um cadastro, clique no botão \"LISTAR CLIENTES\", clique sobre o cadastro desejado na tabela e depois no botão \"SELECIONAR\". Para finalizar, clique no botão \"EXCLUIR\". ");
		getContentPane().add(txtpnParaExcluirUm);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(717, 11, 46, 20);
		txtID.setEnabled(false);
		txtID.setColumns(10);
		getContentPane().add(txtID);
		
		JLabel lblIdCliente = new JLabel("ID CLIENTE");
		lblIdCliente.setBounds(635, 14, 72, 14);
		getContentPane().add(lblIdCliente);
		
		JButton btnSetar = new JButton("LIMPAR");
		btnSetar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSetar.setBounds(163, 211, 83, 23);
		btnSetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetarCampos();
			}
		});
		getContentPane().add(btnSetar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		scrollPane.setBounds(20, 245, 743, 136);
		getContentPane().add(scrollPane);
		
		tableCliente = new JTable();
		tableCliente.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		tableCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "CPF", "EMAIL", "TELEFONE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableCliente.getColumnModel().getColumn(0).setPreferredWidth(40);
		tableCliente.getColumnModel().getColumn(1).setPreferredWidth(172);
		tableCliente.getColumnModel().getColumn(3).setPreferredWidth(183);
		scrollPane.setViewportView(tableCliente);
		
		JButton btnSelecionar = new JButton("SELECIONAR");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Campos();
			}
		});
		btnSelecionar.setBounds(20, 392, 127, 23);
		getContentPane().add(btnSelecionar);

	}
	
	//MÉTODOS
	
	private void CadastrarCliente() {
		
		String nome, cpf, email, telefone;
		
		nome = txtNome.getText();
		cpf = txtCpf.getText();
		email = txtEmail.getText();
		telefone = txtTelefone.getText();
		
		cadastroDTO objcadastrodto = new cadastroDTO();
		objcadastrodto.setNome_cliente(nome);
		objcadastrodto.setCpf_cliente(cpf);
		objcadastrodto.setEmail_cliente(email);
		objcadastrodto.setTelefone_cliente(telefone);

		
		ClienteDAO objclientedao = new ClienteDAO();
		objclientedao.cadastrarCliente(objcadastrodto);
	}
	
	private void BuscarCliente() {
		try {
			ClienteDAO objclientedao = new ClienteDAO();
			
			DefaultTableModel model = (DefaultTableModel) tableCliente.getModel();
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
	
	private void Campos() {
		int set = tableCliente.getSelectedRow();
		
		txtID.setText(tableCliente.getModel().getValueAt(set, 0).toString());
		txtNome.setText(tableCliente.getModel().getValueAt(set, 1).toString());
		txtCpf.setText(tableCliente.getModel().getValueAt(set, 2).toString());
		txtEmail.setText(tableCliente.getModel().getValueAt(set, 3).toString());
		txtTelefone.setText(tableCliente.getModel().getValueAt(set, 4).toString());
	}
	
	private void SetarCampos() {
		txtID.setText("");
		txtNome.setText("");
		txtCpf.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		txtNome.requestFocus();
	}
	
	private void AlterarCliente() {
		int id_cliente;
		String nome_cliente,cpf_cliente,email_cliente,telefone_cliente;
		
		id_cliente = Integer.parseInt(txtID.getText());
		nome_cliente = txtNome.getText();
		cpf_cliente = txtCpf.getText();
		email_cliente = txtEmail.getText();
		telefone_cliente = txtTelefone.getText();
		
		cadastroDTO objcadastrodto = new cadastroDTO();
		objcadastrodto.setId_cliente(id_cliente);
		objcadastrodto.setNome_cliente(nome_cliente);
		objcadastrodto.setCpf_cliente(cpf_cliente);
		objcadastrodto.setEmail_cliente(email_cliente);
		objcadastrodto.setTelefone_cliente(telefone_cliente);
		
		ClienteDAO objclientedao = new ClienteDAO();
		objclientedao.alterarCliente(objcadastrodto);
	}
	
	
	private void ExcluirCliente() {
		int id_cliente;
		
		id_cliente = Integer.parseInt(txtID.getText());
		
		cadastroDTO objcadastroDTO = new cadastroDTO();
		objcadastroDTO.setId_cliente(id_cliente);
		
		ClienteDAO objclientedao = new ClienteDAO();
		objclientedao.excluirCliente(objcadastroDTO);
	}
}
