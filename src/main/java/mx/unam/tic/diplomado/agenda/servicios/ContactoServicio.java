package mx.unam.tic.diplomado.agenda.servicios;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.entidades.Contacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;

public interface ContactoServicio {
	Contacto cargaContactoPorId(Integer id);
	List<Contacto> cargaContactos();
	Boolean guardaContacto(Contacto contacto);
	Boolean actualizaContacto(Contacto contacto);
	Boolean eliminaContacto(Contacto contacto);
	List<ContactoMedio> cargaContactosMedio(MedioContacto medioContacto);
}
