package mx.unam.tic.diplomado.agenda.servicios.impl;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.dao.ContactosMediosDAO;
import mx.unam.tic.diplomado.agenda.modelo.dao.impl.ContactosMediosDAOImpl;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;
import mx.unam.tic.diplomado.agenda.servicios.ContactoMedioServicio;

public class ContactoMedioServicioImpl implements ContactoMedioServicio {
	
	private static ContactoMedioServicioImpl instance;
	private static ContactosMediosDAO contactoDAO = ContactosMediosDAOImpl.getInstance();
	
	private ContactoMedioServicioImpl() {}
	
	public static ContactoMedioServicioImpl getInstance() {
		if (instance == null) {
			instance = new ContactoMedioServicioImpl();
		}
		return instance;
	}

	@Override
	public ContactoMedio cargaContactoMedioPorId(Integer id) {
		return contactoDAO.cargaContactoMedioPorId(id);
	}

	@Override
	public List<ContactoMedio> cargaContactosMedios() {
		return contactoDAO.cargaContactosMedios();
	}

	@Override
	public Boolean guardaContactoMedio(ContactoMedio contacto) {
		return contactoDAO.guardaContactoMedio(contacto);
	}

	@Override
	public Boolean actualizaContactoMedio(ContactoMedio contacto) {
		return contactoDAO.actualizaContactoMedio(contacto);
	}

	@Override
	public Boolean eliminaContactoMedio(ContactoMedio contacto) {
		return contactoDAO.eliminaContactoMedio(contacto);
	}
	
	@Override
	public List<ContactoMedio> cargaContactosMediosPorContacto(Integer id) {
		return contactoDAO.cargaContactosMediosPorContacto(id);
	}
}
