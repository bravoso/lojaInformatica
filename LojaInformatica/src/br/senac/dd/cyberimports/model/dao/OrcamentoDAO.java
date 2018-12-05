package br.senac.dd.cyberimports.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senac.dd.cyberimports.model.bo.Banco;
import br.senac.dd.cyberimports.model.vo.OrcamentoVO;

public class OrcamentoDAO {
	
public int inserir(OrcamentoVO f) {
		
		int novoId = -1;
		
		String sql = " INSERT INTO ORCAMENTO (CLIENTE, FUNCIONARIO, STATUS_ORCAMENTO, DT_ORCAMENTO,VALOR,DESCRICAO) VALUES (?,?,?,?,?,?) ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
				prepStmt.setString(1, f.getCliente());
                prepStmt.setString(2, f.getVendedor());
				prepStmt.setString(3, f.getStatus_orcamento());
				prepStmt.setString(4, f.getDt_orcamento());
				prepStmt.setDouble(5, f.getValor());
				prepStmt.setString(6, f.getDescricao());
			
				prepStmt.execute();
				
				ResultSet generatedKeys = prepStmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					novoId = generatedKeys.getInt(1);
					JOptionPane.showMessageDialog(null, "Orçamento inserido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir o orçamento. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return novoId;
	}
	
	public boolean atualizar(OrcamentoVO f) {
		boolean sucessoUpdate = false;
		
		String sql = " UPDATE ORCAMENTO F SET VALOR=?, DT_ORCAMENTO=?, STATUS_ORCAMENTO=? WHERE F.IDORCAMENTO = ? ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
				prepStmt.setDouble(1, f.getValor());
				prepStmt.setString(2, f.getDt_orcamento());
				prepStmt.setString(3, f.getStatus_orcamento());
				prepStmt.setInt(5, f.getId());
				
				int codigoRetorno = prepStmt.executeUpdate();
				
				if(codigoRetorno == 1) {
					sucessoUpdate = true;
				}
				
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o orçamento" + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return sucessoUpdate;
		
	}
	
	//DELETE
		public boolean remover(int id){
			boolean sucessoDelete = false;

			String sql = " DELETE FROM ORCAMENTO "
					+ " WHERE IDORCAMENTO = ? ";

			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

			try {
				prepStmt.setInt(1, id);

				int codigoRetorno = prepStmt.executeUpdate();

				if(codigoRetorno == 1){//1 - sucesso na execução
					sucessoDelete = true;
				}

			} catch (SQLException e) {
				System.out.println("Erro ao remover o orçamento. Id = " + id);
			}finally{
				Banco.closePreparedStatement(prepStmt);
				Banco.closeConnection(conexao);
			}
			return sucessoDelete;
		}
		
		public ArrayList<OrcamentoVO> listarTodos(){
			String sql = " SELECT * FROM ORCAMENTO ";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			ArrayList<OrcamentoVO> orcamentos = new ArrayList<OrcamentoVO>();
			
			try {
				ResultSet result = prepStmt.executeQuery(sql);
				
				while(result.next()){
					OrcamentoVO o = new OrcamentoVO();
					
					//Obtendo valores pelo NOME DA COLUNA
					o.setId(result.getInt("IDORCAMENTO"));
					o.setValor(result.getDouble("VALOR"));
                    o.setDt_orcamento(result.getString("DT_ORCAMENTO"));
					o.setStatus_orcamento(result.getString("STATUS_ORCAMENTO"));
					o.setCliente(result.getString("CLIENTE"));
					o.setVendedor(result.getString("FUNCIONARIO"));
					
					//Outra forma de obter (POSICIONAL)
					// f.setNome(result.getString(4));
					// f.setSalario(result.getDouble(5));
                                        
					orcamentos.add(o);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return orcamentos;
		}
		
		/**
		 * Retorna um produto dado um id.
		 * 
		 * @param id o identificador do produto
		 * @return um produto caso o id exista na tabela Produto
		 * 		   null caso contrário
		 */
		public OrcamentoVO obterPorId(int id){
			String sql = " SELECT * FROM ORCAMENTO "
					+ " WHERE IDORCAMENTO=?";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			OrcamentoVO o = null;
			
			try {
				prepStmt.setInt(1, id);
				ResultSet result = prepStmt.executeQuery();
				
				while(result.next()){
					o = new OrcamentoVO();
					
					//Obtendo valores pelo NOME DA COLUNA
					o.setId(result.getInt("IDORCAMENTO"));
					o.setValor(result.getDouble("VALOR"));
                    o.setDt_orcamento(result.getString("DT_ORCAMENTO"));
					o.setStatus_orcamento(result.getString("STATUS_ORCAMENTO"));
					
					
					//Outra forma de obter (POSICIONAL)
					//f.setNome(result.getString(4));
					//f.setSalario(result.getDouble(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return o;
		}

}
