package mx.unam.tic.diplomado.agenda.modelo.dao.impl;

import java.util.List;

//import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import mx.unam.tic.diplomado.agenda.modelo.dao.ContactosMediosDAO;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;

public class ContactosMediosDAOImpl implements ContactosMediosDAO {

	private static ContactosMediosDAOImpl instance;

	private ContactosMediosDAOImpl() {
	}

	public static ContactosMediosDAOImpl getInstance() {
		if (instance == null) {
			instance = new ContactosMediosDAOImpl();
		}
		return instance;
	}

	@Override
	public ContactoMedio cargaContactoMedioPorId(Integer id) {
		ContactoMedio contacto = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			contacto = session.get(ContactoMedio.class, id);
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return contacto;
	}

	@Override
	public List<ContactoMedio> cargaContactosMedios() {
		List<ContactoMedio> catalogo = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			//catalogo = session.createQuery("FROM Contacto").list();
			catalogo = session.createQuery("FROM ContactoMedio", ContactoMedio.class).getResultList();
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}

		return catalogo;
	}
	
	@Override
	public List<ContactoMedio> cargaContactosMediosPorContacto(Integer id) {
		List<ContactoMedio> catalogo = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			//catalogo = session.createQuery("FROM Contacto").list();
			catalogo = session.createQuery("SELECT u FROM ContactoMedio u WHERE u.contacto.id = :id", ContactoMedio.class)
					.setParameter("id", id)
					.getResultList();
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}

		return catalogo;
	}

	@Override
	public Boolean guardaContactoMedio(ContactoMedio contacto) {
		Boolean guardado = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			//session.save(contacto);
			session.persist(contacto);
			guardado = contacto.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return guardado;
	}

	@Override
	public Boolean actualizaContactoMedio(ContactoMedio contacto) {
		Boolean guardado = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			//session.update(contacto);
			session.merge(contacto);
			guardado = contacto.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return guardado;
	}

	@Override
	public Boolean eliminaContactoMedio(ContactoMedio contacto) {
		Boolean guardado = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.remove(contacto);
			guardado = contacto.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return guardado;
	}
}
