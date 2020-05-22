package br.com.logsmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pacote {
	
	@Id
	private String codigo;
	private String destino;
	private String origem;
	private String docRemetente;
	private String docDestinatario;
	private String destinatario;
	private String remetente;
	
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDocRemetente() {
		return docRemetente;
	}
	public void setDocRemetente(String docRemetente) {
		this.docRemetente = docRemetente;
	}
	public String getDocDestinatario() {
		return docDestinatario;
	}
	public void setDocDestinatario(String docDestinatario) {
		this.docDestinatario = docDestinatario;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getRemetente() {
		return remetente;
	}
	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}
	
	

}
