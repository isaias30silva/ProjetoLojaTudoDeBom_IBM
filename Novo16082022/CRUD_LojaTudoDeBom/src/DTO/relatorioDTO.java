package DTO;

public class relatorioDTO {
	
	private String codigo_produto, nome_cliente, cpf_cliente, data_compra, quant_produto;
	
	public String getCodigo_produto() {
		return codigo_produto;
	}

	public String getQuant_produto() {
		return quant_produto;
	}

	public void setQuant_produto(String quant_produto) {
		this.quant_produto = quant_produto;
	}

	public void setCodigo_produto(String codigo_produto) {
		this.codigo_produto = codigo_produto;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public String getData_compra() {
		return data_compra;
	}

	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}


}
