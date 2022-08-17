package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import DTO.produtoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<produtoDTO> lista = new ArrayList<>();
	
	public void cadastrarProduto(produtoDTO objproduto) {
		String sql = "insert into produto (codigo_produto,nome_produto,registro_produto,dataf_produto,datav_produto,preco_produto, precod_produto, quant1_produto) values (?, ?, ?, ?, ?, ?, ?,?)";
		
		conn = new ConexaoDAO1().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objproduto.getCodigo_produto());
			pstm.setString(2, objproduto.getNome_produto());
			pstm.setString(3, objproduto.getRegistro_produto());
			pstm.setString(4, objproduto.getDataf_produto());
			pstm.setString(5, objproduto.getDatav_produto());
			pstm.setString(6, objproduto.getPreco_produto());
			pstm.setString(7, objproduto.getPrecod_produto());
			pstm.setString(8, objproduto.getQuant1_produto());
			
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ProdutoDAO Cadastrar" + erro);
		}
		
	}
	
	public ArrayList<produtoDTO> ListarProduto() {
		String sql = "select*from produto";
		
		conn = new ConexaoDAO1().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				produtoDTO objprodutoDTO = new produtoDTO();
				objprodutoDTO.setCodigo_produto(rs.getString("codigo_produto"));
				objprodutoDTO.setNome_produto(rs.getString("nome_produto"));
				objprodutoDTO.setRegistro_produto(rs.getString("registro_produto"));
				objprodutoDTO.setDataf_produto(rs.getString("dataf_produto"));
				objprodutoDTO.setDatav_produto(rs.getString("datav_produto"));
				objprodutoDTO.setPreco_produto(rs.getString("preco_produto"));
				objprodutoDTO.setPrecod_produto(rs.getString("precod_produto"));
				objprodutoDTO.setQuant1_produto(rs.getString("quant1_produto"));
				
				lista.add(objprodutoDTO);
			}
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ProdutoDAO Listar:" + erro);
		}
		return lista;
	}	
	
}
