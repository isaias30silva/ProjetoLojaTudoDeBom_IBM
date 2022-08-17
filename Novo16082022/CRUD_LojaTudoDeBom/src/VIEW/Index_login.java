package VIEW;

import java.awt.BorderLayout;
import Administrator.Administrador;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Index_login extends JFrame {
	Administrador adm = new Administrador("admin", "admin");
	
	
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index_login frame = new Index_login();
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
	public Index_login() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 481);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnSistemaDeGerenciamento = new JTextPane();
		txtpnSistemaDeGerenciamento.setEditable(false);
		txtpnSistemaDeGerenciamento.setBounds(213, 69, 417, 25);
		txtpnSistemaDeGerenciamento.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnSistemaDeGerenciamento.setText("SISTEMA DE GERENCIAMENTO - LOJA TUDO DE BOM ");
		contentPane.add(txtpnSistemaDeGerenciamento);
		
		JTextPane txtpnAutenticao = new JTextPane();
		txtpnAutenticao.setEditable(false);
		txtpnAutenticao.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnAutenticao.setText("AUTENTICAÇÃO");
		txtpnAutenticao.setBounds(347, 147, 136, 20);
		contentPane.add(txtpnAutenticao);
		
		JTextPane txtpnLogin = new JTextPane();
		txtpnLogin.setEditable(false);
		txtpnLogin.setText("LOGIN");
		txtpnLogin.setBounds(245, 211, 47, 20);
		contentPane.add(txtpnLogin);
		
		JTextPane txtpnAutenticao_1_1 = new JTextPane();
		txtpnAutenticao_1_1.setEditable(false);
		txtpnAutenticao_1_1.setText("SENHA");
		txtpnAutenticao_1_1.setBounds(245, 259, 44, 20);
		contentPane.add(txtpnAutenticao_1_1);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(302, 211, 239, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String login = txtLogin.getText();
				String senha = String.valueOf(txtSenha.getPassword());
				
				if(login.equals(adm.getSenha()) && senha.equals(adm.getSenha())) {
					Escolha es = new Escolha();
					Index_login.this.dispose();
					es.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(Index_login.this, "Login ou senha incorreto");
				}
			}
		});
		btnEntrar.setBounds(452, 290, 89, 23);
		contentPane.add(btnEntrar);
		
		JTextPane txtpnDesenvolvidoPorGrupo = new JTextPane();
		txtpnDesenvolvidoPorGrupo.setEditable(false);
		txtpnDesenvolvidoPorGrupo.setText("DESENVOLVIDO POR GRUPO 9 - SMART SOLUTIONS");
		txtpnDesenvolvidoPorGrupo.setBounds(498, 411, 265, 20);
		contentPane.add(txtpnDesenvolvidoPorGrupo);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(302, 259, 239, 20);
		contentPane.add(txtSenha);
	}
}
