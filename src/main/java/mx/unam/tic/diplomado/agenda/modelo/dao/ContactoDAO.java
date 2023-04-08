package mx.unam.tic.diplomado.agenda.modelo.dao;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.entidades.Contacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;

public interface ContactoDAO {

	Contacto cargaContactoPorId(Integer id);

	List<Contacto> cargaContactos();

	Boolean guardaContacto(Contacto contacto);

	Boolean actualizaContacto(Contacto contacto);

	Boolean eliminaContacto(Contacto contacto);
	
	List<ContactoMedio> cargaContactosMedio(MedioContacto medioContacto);
}
