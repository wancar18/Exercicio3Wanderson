package br.edu.faculdadedelta.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import br.edu.faculdadedelta.dao.FinanceiroDAO;
import br.edu.faculdadedelta.modelo.FinanceiroWanderson;


@ManagedBean
@SessionScoped

public class FinanceiroController {

	private FinanceiroWanderson financ = new FinanceiroWanderson();
	private FinanceiroDAO dao = new FinanceiroDAO();
	
	private Date dataInicio;
	private Date dataFim;

		
	private static final String PAGINA_CADASTRO = "cadastroProcedimento.xhtml"; 
	private static final String PAGINA_LISTA = "listarProcedimento.xhtml";
	
	public FinanceiroWanderson getFinanc() {
		return financ;
	}
	public void setFinanc(FinanceiroWanderson financ) {
		this.financ = financ;
	}
	public FinanceiroDAO getDao() {
		return dao;
	}
	public void setDao(FinanceiroDAO dao) {
		this.dao = dao;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public void limparCampos() {
		financ = new FinanceiroWanderson();
	}
	
	private void exibirMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public String salvar() {
		
		try {
			if(financ.getDataInicio().after(new Date()) /*&& financ.getDataFim().after(dataInicio)*/) {
				if(financ.getId()==null) {
					dao.incluir(financ);
						exibirMensagem("Inclusão realizada com Sucesso!");
						limparCampos();
				}else {
					dao.alterar(financ);
					exibirMensagem("Alteração realizada com Sucesso!");
				}
				
			}else {
				exibirMensagem("Data deve ser superior a data atual, menor que 01/01/2022 e menor que a data final");
			}
		}catch (ClassNotFoundException | SQLException e) {
			exibirMensagem("Erro ao realizar a operação. Tente novamente mais tarde. " + e.getMessage());
			e.printStackTrace();
		}
		return PAGINA_CADASTRO;
	}
	
	
	public List<FinanceiroWanderson> getLista() {
		List<FinanceiroWanderson> listaRetorno = new ArrayList<FinanceiroWanderson>();
		try {
			listaRetorno = FinanceiroDAO.listar();
		} catch (ClassNotFoundException | SQLException e) {
			exibirMensagem("Erro ao realizar a operação. "
					+ "Tente novamente mais tarde. " + e.getMessage());
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	
	public String editar() {
		return PAGINA_CADASTRO;
	}
	
	public String excluir() {
		try {
			dao.excluir(financ);
			exibirMensagem("Exclusão realizada com sucesso!");
			limparCampos();
		} catch (ClassNotFoundException | SQLException e) {
			exibirMensagem("Erro ao realizar a operação. Tente novamente mais tarde. " + e.getMessage());
			e.printStackTrace();
		}
		return PAGINA_LISTA;
	}
	

	
}
