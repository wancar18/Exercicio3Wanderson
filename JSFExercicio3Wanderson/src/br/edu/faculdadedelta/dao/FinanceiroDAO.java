package br.edu.faculdadedelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadedelta.modelo.FinanceiroWanderson;
import br.edu.faculdadedelta.util.Conexao;

public class FinanceiroDAO {

	public void incluir (FinanceiroWanderson financ) throws ClassNotFoundException, SQLException {
		Connection conn = Conexao.conectarNoBanco();
		String sql = "INSERT INTO procedimentos("
				+ "paciente_desc, procedimento_desc, valor_procedimento, data_inicio_procedimento, "
				+ "data_fim_procedimento, quantidade_exame_procedimento)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, financ.getPaciente().trim());
				ps.setString(2, financ.getDescProcedimento().trim());
				ps.setDouble(3, financ.getValorProc());
				ps.setDate(4, new java.sql.Date(financ.getDataInicio().getTime()));
				ps.setDate(5, new java.sql.Date(financ.getDataFim().getTime()));
				ps.setInt(6, financ.getQuantidadeExame());
				
				ps.executeUpdate();
				Conexao.fecharConexao(ps, conn, null);
	}
	
	public void alterar (FinanceiroWanderson financ) throws ClassNotFoundException, SQLException {
		Connection conn = Conexao.conectarNoBanco();
		String sql = "UPDATE procedimentos "
				+ "SET paciente_desc=?, procedimento_desc=?, "
				+ "valor_procedimento=?, data_inicio_procedimento=?, data_fim_procedimento=?, "
				+ "quantidade_exame_procedimento=?"
				+ "WHERE id_procedimento=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, financ.getPaciente().trim());
				ps.setString(2, financ.getDescProcedimento().trim());
				ps.setDouble(3, financ.getValorProc());
				ps.setDate(4, new java.sql.Date(financ.getDataInicio().getTime()));
				ps.setDate(5, new java.sql.Date(financ.getDataFim().getTime()));
				ps.setInt(6, financ.getQuantidadeExame());
				ps.setLong(7, financ.getId());
				
				ps.executeUpdate();
				Conexao.fecharConexao(ps, conn, null);
	}
	
	public void excluir (FinanceiroWanderson financ) throws ClassNotFoundException, SQLException {
		Connection conn = Conexao.conectarNoBanco();
		String sql ="DELETE FROM procedimentos\n"
				+ "	WHERE id_procedimento=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, financ.getId());
		
		ps.executeUpdate();
		
		Conexao.fecharConexao(ps, conn, null);
	}
	
	public static List <FinanceiroWanderson> listar() throws ClassNotFoundException, SQLException {
		Connection conn = Conexao.conectarNoBanco();
		String sql = "SELECT id_procedimento, paciente_desc, procedimento_desc, valor_procedimento, "
				+ "data_inicio_procedimento, data_fim_procedimento, quantidade_exame_procedimento"
				+ "	FROM procedimentos";
		PreparedStatement ps = conn.prepareStatement(sql);
		List<FinanceiroWanderson> listaRetorno = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			FinanceiroWanderson financ = new FinanceiroWanderson();
			financ.setId(rs.getLong("id_procedimento"));
			financ.setPaciente(rs.getString("paciente_desc").trim());
			financ.setDescProcedimento(rs.getString("procedimento_desc").trim());
			financ.setValorProc(rs.getDouble("valor_procedimento"));
			financ.setDataInicio(rs.getDate("data_inicio_procedimento"));
			financ.setDataFim(rs.getDate("data_fim_procedimento"));
			financ.setQuantidadeExame(rs.getInt("quantidade_exame_procedimento"));
			listaRetorno.add(financ);
			
		}
		Conexao.fecharConexao(ps, conn, rs);
		
		return listaRetorno;
	}
	
	
}
