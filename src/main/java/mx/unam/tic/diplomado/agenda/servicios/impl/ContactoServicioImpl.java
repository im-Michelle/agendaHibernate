package mx.unam.tic.diplomado.agenda.servicios.impl;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.dao.ContactoDAO;
import mx.unam.tic.diplomado.agenda.modelo.dao.impl.ContactoDAOImpl;
import mx.unam.tic.diplomado.agenda.modelo.entidades.Contacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;
import mx.unam.tic.diplomado.agenda.servicios.ContactoServicio;

public class ContactoServicioImpl implements ContactoServicio {
	
	private static ContactoServicioImpl instance;
	private static ContactoDAO contactoDAO = ContactoDAOImpl.getInstance();
	
	private ContactoServicioImpl() {}
	
	public static ContactoServicioImpl getInstance() {
		if (instance == null) {
			instance = new ContactoServicioImpl();
		}
		return instance;
	}

	@Override
	public Contacto cargaContactoPorId(Integer id) {
		return contactoDAO.cargaContactoPorId(id);
	}

	@Override
	public List<Contacto> cargaContactos() {
		return contactoDAO.cargaContactos();
	}

	@Override
	public Boolean guardaContacto(Contacto contacto) {
		return contactoDAO.guardaContacto(contacto);
	}

	@Override
	public Boolean actualizaContacto(Contacto contacto) {
		return contactoDAO.actualizaContacto(contacto);
	}

	@Override
	public Boolean eliminaContacto(Contacto contacto) {
		return contactoDAO.eliminaContacto(contacto);
	}
	
	@Override
	public List<ContactoMedio> cargaContactosMedio(MedioContacto medioContacto) {
		return contactoDAO.cargaContactosMedio(medioContacto);
	}

}
