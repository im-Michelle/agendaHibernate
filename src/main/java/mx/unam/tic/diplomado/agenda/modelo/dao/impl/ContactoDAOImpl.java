package mx.unam.tic.diplomado.agenda.modelo.dao.impl;

import java.util.List;

//import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import mx.unam.tic.diplomado.agenda.modelo.dao.ContactoDAO;
import mx.unam.tic.diplomado.agenda.modelo.entidades.Contacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;

public class ContactoDAOImpl implements ContactoDAO {

	private static ContactoDAOImpl instance;

	private ContactoDAOImpl() {
	}

	public static ContactoDAOImpl getInstance() {
		if (instance == null) {
			instance = new ContactoDAOImpl();
		}
		return instance;
	}

	@Override
	public Contacto cargaContactoPorId(Integer id) {
		Contacto contacto = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			contacto = session.get(Contacto.class, id);
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
	public List<Contacto> cargaContactos() {
		List<Contacto> catalogo = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			//catalogo = session.createQuery("FROM Contacto").list();
			catalogo = session.createQuery("FROM Contacto", Contacto.class).getResultList();
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
	public Boolean guardaContacto(Contacto contacto) {
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
	public Boolean actualizaContacto(Contacto contacto) {
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
	public Boolean eliminaContacto(Contacto contacto) {
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

	@Override
	public List<ContactoMedio> cargaContactosMedio(MedioContacto medioContacto) {
		List<ContactoMedio> contactosMedio = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			//contactosMedio = (List<ContactoMedio>) session
			//		.createQuery("SELECT cm FROM ContactoMedio cm WHERE cm.medioContacto.id =:idMedioContacto")
			//		.setParameter("idMedioContacto", medioContacto.getId()).list();
			contactosMedio = session.createQuery("SELECT cm FROM ContactoMedio cm WHERE cm.medioContacto.id =:idMedioContacto", 
					ContactoMedio.class).setParameter("idMedioContacto", medioContacto.getId()).getResultList();
			session.getTransaction().commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return contactosMedio;
	}
}
