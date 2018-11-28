package br.senac.dd.cyberimports.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senac.dd.cyberimports.model.bo.Banco;
import br.senac.dd.cyberimports.model.vo.ClienteVO;

public class ClienteDAO {
	
public int inserir(ClienteVO f) {
		
		int novoId = -1;
		
		String sql = " INSERT INTO CLIENTE (NOME, CPF, ENDEREÇO, TELEFONE) VALUES (?,?,?,?) ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
				prepStmt.setString(1, f.getNome());
                prepStmt.setString(2, f.getCpf());
				prepStmt.setString(3, f.getTelefone());
				prepStmt.setString(4, f.getEndereço());
			
				prepStmt.execute();
				
				ResultSet generatedKeys = prepStmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					novoId = generatedKeys.getInt(1);
					JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir o cliente. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return novoId;
	}
	
	public boolean atualizar(ClienteVO f) {
		boolean sucessoUpdate = false;
		
		String sql = " UPDATE CLIENTE F SET NOME=?, CPF=?, TELEFONE=?, ENDEREÇO=? WHERE F.IDCLIENTE = ? ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
				prepStmt.setString(1, f.getNome());
				prepStmt.setString(2, f.getCpf());
				prepStmt.setString(3, f.getTelefone());
				prepStmt.setString(4, f.getEndereço());
				prepStmt.setInt(5, f.getId());
				
				int codigoRetorno = prepStmt.executeUpdate();
				
				if(codigoRetorno == 1) {
					sucessoUpdate = true;
				}
				
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o cliente" + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return sucessoUpdate;
		
	}
	
	//DELETE
		public boolean remover(int id){
			boolean sucessoDelete = false;

			String sql = " DELETE FROM CLIENTE "
					+ " WHERE ID = ? ";

			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

			try {
				prepStmt.setInt(1, id);

				int codigoRetorno = prepStmt.executeUpdate();

				if(codigoRetorno == 1){//1 - sucesso na execução
					sucessoDelete = true;
				}

			} catch (SQLException e) {
				System.out.println("Erro ao remover cliente. Id = " + id);
			}finally{
				Banco.closePreparedStatement(prepStmt);
				Banco.closeConnection(conexao);
			}
			return sucessoDelete;
		}
		
		public ArrayList<ClienteVO> listarTodos(){
			String sql = " SELECT * FROM CLIENTE ";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
			
			try {
				ResultSet result = prepStmt.executeQuery(sql);
				
				while(result.next()){
					ClienteVO c = new ClienteVO();
					
					//Obtendo valores pelo NOME DA COLUNA
					c.setId(result.getInt("IDCLIENTE"));
					c.setNome(result.getString("NOME"));
                    c.setCpf(result.getString("CPF"));
					c.setTelefone(result.getString("TELEFONE"));
					c.setEndereço(result.getString("ENDEREÇO"));
					
					//Outra forma de obter (POSICIONAL)
					// f.setNome(result.getString(4));
					// f.setSalario(result.getDouble(5));
                                        
					clientes.add(c);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return clientes;
		}
		
		/**
		 * Retorna um produto dado um id.
		 * 
		 * @param id o identificador do produto
		 * @return um produto caso o id exista na tabela Produto
		 * 		   null caso contrário
		 */
		public ClienteVO obterPorId(int id){
			String sql = " SELECT * FROM CLIENTE "
					+ " WHERE ID=?";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			ClienteVO c = null;
			
			try {
				prepStmt.setInt(1, id);
				ResultSet result = prepStmt.executeQuery();
				
				while(result.next()){
					c = new ClienteVO();
					
					//Obtendo valores pelo NOME DA COLUNA
					c.setId(result.getInt("IDCLIENTE"));
					c.setNome(result.getString("NOME"));
                    c.setCpf(result.getString("CPF"));
					c.setTelefone(result.getString("TELEFONE"));
					c.setEndereço(result.getString("ENDEREÇO"));
					
					//Outra forma de obter (POSICIONAL)
					//f.setNome(result.getString(4));
					//f.setSalario(result.getDouble(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return c;
		}
	}
