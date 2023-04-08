package mx.unam.tic.diplomado.agenda.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c_medio_contacto")
public class MedioContacto {

	private Integer id;
	private String nombre;
	private String estatus;

	@Id
	@Column(name = "id_medio_contacto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "vc_nombre", length = 50, nullable = false)
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "vc_estatus", length = 50, nullable = false)
	public String getEstatus() {
		return estatus;
	}
	
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "MedioContacto [id=" + id + ", nombre=" + nombre + ", estatus=" + estatus + "]";
	}
}
