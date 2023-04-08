package mx.unam.tic.diplomado.agenda.servicios;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;

public interface ContactoMedioServicio {
	ContactoMedio cargaContactoMedioPorId(Integer id);
	List<ContactoMedio> cargaContactosMedios();
	Boolean guardaContactoMedio(ContactoMedio contacto);
	Boolean actualizaContactoMedio(ContactoMedio contacto);
	Boolean eliminaContactoMedio(ContactoMedio contacto);
	List<ContactoMedio> cargaContactosMediosPorContacto(Integer id);
}
