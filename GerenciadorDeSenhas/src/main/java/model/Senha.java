package model;

import java.util.Date;

public class Senha {

	private Long id;
	private String cdSenha;
	private Integer nrSenha;
	private String tipoSenha;
	public Date dtHrGeracao;
	public Date dtHrChamada;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCdSenha() {
		return cdSenha;
	}
	public void setCdSenha(String cdSenha) {
		this.cdSenha = cdSenha;
	}
	public Integer getNrSenha() {
		return nrSenha;
	}
	public void setNrSenha(Integer nrSenha) {
		this.nrSenha = nrSenha;
	}
	public String getTipoSenha() {
		return tipoSenha;
	}
	public void setTipoSenha(String tipoSenha) {
		this.tipoSenha = tipoSenha;
	}
	public Date getDtHrGeracao() {
		return dtHrGeracao;
	}
	public void setDtHrGeracao(Date dtHrGeracao) {
		this.dtHrGeracao = dtHrGeracao;
	}
	public Date getDtHrChamada() {
		return dtHrChamada;
	}
	public void setDtHrChamada(Date dtHrChamada) {
		this.dtHrChamada = dtHrChamada;
	}
	
}
