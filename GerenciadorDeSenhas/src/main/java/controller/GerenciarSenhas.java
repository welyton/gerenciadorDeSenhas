package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.Senha;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

@ManagedBean
@ApplicationScoped
public class GerenciarSenhas {
	
	private String senha;
	private List<Senha> listaSenhasPreferenciais;
	private List<Senha> listaSenhasNormais;
	private Integer countSenhasNormais = 0;
	private Integer countSenhasPreferenciais = 0;
	private Senha proximaSenha;

	public void gerarSenhaNormal(ActionEvent actionEvent) {
		
		if(listaSenhasNormais == null){
			listaSenhasNormais = new ArrayList<Senha>();
		}
		
		Senha senha = new Senha();
		senha.setNrSenha(++countSenhasNormais);
		senha.setCdSenha("N"+StringUtils.leftPad(senha.getNrSenha().toString(), 4 , "0"));
		senha.setTipoSenha("Normal");
		senha.setDtHrGeracao(Calendar.getInstance(new Locale("pt","BR")).getTime());
		
		this.senha = senha.getCdSenha();
		listaSenhasNormais.add(senha);
	}
	
	public void gerarSenhaPreferencial(ActionEvent actionEvent){

		if(listaSenhasPreferenciais == null){
			listaSenhasPreferenciais = new ArrayList<Senha>();
		}
		
		Senha senha = new Senha();
		senha.setNrSenha(++countSenhasPreferenciais);
		senha.setCdSenha("P"+StringUtils.leftPad(senha.getNrSenha().toString(), 4 , "0"));
		senha.setTipoSenha("Preferencial");
		senha.setDtHrGeracao(Calendar.getInstance(new Locale("pt","BR")).getTime());
		
		this.senha = senha.getCdSenha();
		listaSenhasPreferenciais.add(senha);
	}
	
	public void zerarContadorSenhaNormal(ActionEvent actionEvent){
		countSenhasNormais = 0;
		addMessageInfo("Zerado Contador das Senhas Normais");
	}
	
	public void zerarContadorSenhaPreferencial(ActionEvent actionEvent){
		countSenhasPreferenciais = 0;
		addMessageInfo("Zerado Contador das Senhas Preferenciais");
	}
		
	public void chamarSenha(ActionEvent actionEvent){

		if(listaSenhasPreferenciais != null && listaSenhasPreferenciais.size() != 0){
			proximaSenha = listaSenhasPreferenciais.remove(0);
			RequestContext.getCurrentInstance().openDialog("chamarSenhaDialog");
		}
		else if(listaSenhasNormais != null && listaSenhasNormais.size() != 0){
			proximaSenha = listaSenhasNormais.remove(0);
			RequestContext.getCurrentInstance().openDialog("chamarSenhaDialog");
		}
		else {
			proximaSenha = null;
		}
	}
	
	public void addMessageInfo(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void addMessageWarn(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public String getSenha() {
		return senha;
	}

	public Senha getProximaSenha() {
		return proximaSenha;
	}

	public List<Senha> getListaSenhasPreferenciais() {
		return listaSenhasPreferenciais;
	}
	
	public List<Senha> getListaSenhasNormais() {
		return listaSenhasNormais;
	}

}
