package br.edu.faculdadedelta.modelo;

import java.util.Date;

public class FinanceiroWanderson {
	
	/*Descrição do procedimento (Caixa de Texto)
	•	Data início do procedimento (Caixa de Texto)
	•	Data fim do procedimento (Caixa de Texto)
	•	Paciente (Caixa de Texto)
	•	Quantidade de exames (Caixa de Texto)
	•	Valor do procedimento (Caixa de Texto)*/
	
	private Long id;
	private String descProcedimento;
	private Date dataInicio;
	private Date dataFim;
	private String paciente;
	private int quantidadeExame;
	private Double valorProc;
	
	public FinanceiroWanderson() {
	}

	public FinanceiroWanderson(Long id, String descProcedimento, Date dataInicio, Date dataFim, String paciente,
			int quantidadeExame, Double valorProc) {
		this.id = id;
		this.descProcedimento = descProcedimento;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.paciente = paciente;
		this.quantidadeExame = quantidadeExame;
		this.valorProc = valorProc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescProcedimento() {
		return descProcedimento;
	}

	public void setDescProcedimento(String descProcedimento) {
		this.descProcedimento = descProcedimento;
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

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public int getQuantidadeExame() {
		return quantidadeExame;
	}

	public void setQuantidadeExame(int quantidadeExame) {
		this.quantidadeExame = quantidadeExame;
	}

	public Double getValorProc() {
		return valorProc;
	}

	public void setValorProc(Double valorProc) {
		this.valorProc = valorProc;
	}
	
	
	public double getValorTotal() {
			if(valorProc>2000) {
			return (valorProc * quantidadeExame)-((valorProc * quantidadeExame)*0.015);
		}else {
			return valorProc * quantidadeExame;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinanceiroWanderson other = (FinanceiroWanderson) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
