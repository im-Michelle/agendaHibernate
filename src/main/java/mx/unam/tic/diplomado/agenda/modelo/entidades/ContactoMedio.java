package mx.unam.tic.diplomado.agenda.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_contactos_medios")
public class ContactoMedio {
	
	private Integer id;
	private String valor;
	private Contacto contacto;
	private MedioContacto medioContacto;
	
	@Id
	@Column(name = "id_contactos_medios")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "vc_valor", length = 300)
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_contacto")
	public Contacto getContacto() {
		return contacto;
	}
	
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_medio_contacto")
	public MedioContacto getMedioContacto() {
		return medioContacto;
	}
	
	public void setMedioContacto(MedioContacto medioContacto) {
		this.medioContacto = medioContacto;
	}

	@Override
	public String toString() {
		return "ContactoMedio [id=" + id + ", valor=" + valor + "]";
	}
}
