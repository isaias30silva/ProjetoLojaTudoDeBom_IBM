package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import DTO.cadastroDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<cadastroDTO> lista = new ArrayList<>();
	
	public void cadastrarCliente(cadastroDTO objcadastrodto) {
		String sql = "insert into cliente (nome_cliente, cpf_cliente, email_cliente, telefone_cliente) values (?,?,?,?)";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objcadastrodto.getNome_cliente());
			pstm.setString(2, objcadastrodto.getCpf_cliente());
			pstm.setString(3, objcadastrodto.getEmail_cliente());
			pstm.setString(4, objcadastrodto.getTelefone_cliente());
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ClienteDAO Cadastrar" + erro);
		}
		
	}
	
	public ArrayList<cadastroDTO> ListarCliente() {
		String sql = "select*from cliente";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				cadastroDTO objcadastroDTO = new cadastroDTO();
				objcadastroDTO.setId_cliente(rs.getInt("id_cliente"));
				objcadastroDTO.setNome_cliente(rs.getString("nome_cliente"));
				objcadastroDTO.setCpf_cliente(rs.getString("cpf_cliente"));
				objcadastroDTO.setEmail_cliente(rs.getString("email_cliente"));
				objcadastroDTO.setTelefone_cliente(rs.getString("telefone_cliente"));
				
				lista.add(objcadastroDTO);
			}
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ClienteDAO Listar:" + erro);
		}
		return lista;
	}	
	
		public void alterarCliente(cadastroDTO objcadastrodto) {
		String sql = "update cliente set nome_cliente = ?, cpf_cliente = ?, email_cliente = ?, telefone_cliente = ? where id_cliente = ?";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objcadastrodto.getNome_cliente());
			pstm.setString(2, objcadastrodto.getCpf_cliente());
			pstm.setString(3, objcadastrodto.getEmail_cliente());
			pstm.setString(4, objcadastrodto.getTelefone_cliente());
			pstm.setInt(5, objcadastrodto.getId_cliente());
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ClienteDAO Alterar" + erro);
		}
		
	}	
	public void excluirCliente(cadastroDTO objcadastrodto) {
		String sql = "delete from cliente where id_cliente = ?";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, objcadastrodto.getId_cliente());
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ClienteDAO Excluir" + erro);
		}
	
	}

}
