package JdbcSwingMysql.Dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import JdbcSwingMysql.Dto.ProdutoDTO;
import JdbcSwingMysql.Util.ConexaoUtil;

public class ProdutoDAO {

	//Método para Cadastrar cadastro:
	public void Create(ProdutoDTO produtoDto) {
		Connection con = ConexaoUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("INSERT INTO Produtos (nome, quantidade, preco) VALUES (?, ?, ?)");
			stmt.setString(1, produtoDto.getNome());
			stmt.setInt(2, produtoDto.getQuantidade());
			stmt.setFloat(3, (float) produtoDto.getPreco()); // Conversão explícita para float;
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e);
		}finally {
			ConexaoUtil.closeConnection(con, stmt);
		}
	}
	
	
	public List<ProdutoDTO> Read(){
		Connection con = ConexaoUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProdutoDTO> lista = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT * FROM Produtos");
			rs = stmt.executeQuery();
			while(rs.next()) {
				ProdutoDTO produtoDto = new ProdutoDTO();
				produtoDto.setId(rs.getInt("id"));
				produtoDto.setNome(rs.getString("nome"));
				produtoDto.setQuantidade(rs.getInt("quantidade"));
				produtoDto.setPreco(rs.getFloat("preco"));
				lista.add(produtoDto);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar os produtos: " + e);
		}finally {
			ConexaoUtil.closeConnection(con, stmt, rs);
		}
		return lista;
	}
	
	//Método para Localizar cadastro (pelo Nome do produto):
	public List<ProdutoDTO> Search(String nomeProduto){
		Connection con = ConexaoUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProdutoDTO> lista = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT * FROM Produtos WHERE nome LIKE ?");
			stmt.setString(1, "%" + nomeProduto + "%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				ProdutoDTO produtoDto = new ProdutoDTO();
				produtoDto.setId(rs.getInt("id"));
				produtoDto.setNome(rs.getString("nome"));
				produtoDto.setQuantidade(rs.getInt("quantidade"));
				produtoDto.setPreco(rs.getFloat("preco"));
				lista.add(produtoDto);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao localizar produto: " + e);
		}finally {
			ConexaoUtil.closeConnection(con, stmt, rs);
		}
		return lista;
	}
	
	//Método para Atualizar cadastro:
	public void Update(ProdutoDTO produtoDto) {
		Connection con = ConexaoUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("UPDATE Produtos SET nome = ?, quantidade = ?, preco = ? WHERE id = ?");
			stmt.setString(1, produtoDto.getNome());
			stmt.setInt(2, produtoDto.getQuantidade());
			stmt.setFloat(3, (float) produtoDto.getPreco()); // Conversão explícita para float;
			stmt.setInt(4, produtoDto.getId());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e);
		}finally {
			ConexaoUtil.closeConnection(con, stmt);
		}
	}
	
	//Método para Excluir cadastro:
	public void Delete(ProdutoDTO produtoDto) {
		Connection con = ConexaoUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM Produtos WHERE id = ?");
			stmt.setInt(1, produtoDto.getId());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir produto: " + e);
		}finally {
			ConexaoUtil.closeConnection(con, stmt);
		}
	}
}
