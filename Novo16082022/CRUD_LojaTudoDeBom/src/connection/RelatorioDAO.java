package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import DTO.relatorioDTO;
import DTO.produtoDTO;
import DTO.cadastroDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import connection.ConexaoDAO;
import connection.ConexaoDAO1;

public class RelatorioDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<relatorioDTO> lista = new ArrayList<>();
	
	public void cadastrarRelatorio(relatorioDTO objrelatorio) {
		String sql = "insert into relatorio (codigo_produto,nome_cliente,cpf_cliente,data_compra,quant_produto) values (?, ?, ?,?, ?)";
		
		conn = new ConexaoDAO2().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objrelatorio.getCodigo_produto());
			pstm.setString(2, objrelatorio.getNome_cliente());
			pstm.setString(3, objrelatorio.getCpf_cliente());
			pstm.setString(4, objrelatorio.getData_compra());
			pstm.setString(5, objrelatorio.getQuant_produto());
			
			
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "RelatorioDAO Cadastrar" + erro);
		}
		
	}
	
	public ArrayList<relatorioDTO> GerarRelatorio() {
		String sql = "select*from relatorio";
		
		conn = new ConexaoDAO2().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				relatorioDTO objrelatorioDTO = new relatorioDTO();
				objrelatorioDTO.setCodigo_produto(rs.getString("codigo_produto"));
				objrelatorioDTO.setNome_cliente(rs.getString("nome_cliente"));
				objrelatorioDTO.setCpf_cliente(rs.getString("cpf_cliente"));				
				objrelatorioDTO.setData_compra(rs.getString("data_compra"));
				objrelatorioDTO.setQuant_produto(rs.getString("quant_produto"));

				lista.add(objrelatorioDTO);
			}
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "RelatorioDAO Gerar:" + erro);
		}
		return lista;
	}	
	
}

