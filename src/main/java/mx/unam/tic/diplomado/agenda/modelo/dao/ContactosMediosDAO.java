package mx.unam.tic.diplomado.agenda.modelo.dao;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;

public interface ContactosMediosDAO {
	ContactoMedio cargaContactoMedioPorId(Integer id);
	List<ContactoMedio> cargaContactosMedios();
	Boolean guardaContactoMedio(ContactoMedio contacto);
	Boolean actualizaContactoMedio(ContactoMedio contacto);
	Boolean eliminaContactoMedio(ContactoMedio contacto);
	List<ContactoMedio> cargaContactosMediosPorContacto(Integer id);
}
