package mx.unam.tic.diplomado.agenda.modelo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import mx.unam.tic.diplomado.agenda.modelo.dao.MedioContactoDAO;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;

public class MedioContactoDAOImpl implements MedioContactoDAO {

	private static MedioContactoDAOImpl instance;

	private MedioContactoDAOImpl() {
	}

	public static MedioContactoDAOImpl getInstance() {
		if (instance == null) {
			instance = new MedioContactoDAOImpl();
		}
		return instance;
	}

	@Override
	public MedioContacto cargaMedioContactoPorId(Integer id) {
		MedioContacto medioContacto = null;
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();

			// se inicia una transaccion
			session.beginTransaction();
			medioContacto = session.get(MedioContacto.class, id);
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return medioContacto;
	}
	
	@Override
	public List<MedioContacto> cargaMediosContacto() {
		List<MedioContacto> catalogo = null;
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();

			// se inicia una transaccion
			session.beginTransaction();
			//catalogo = session.createQuery("SELECT t FROM MedioContacto t WHERE t.estatus = 'ACTIVO' ").list();
			catalogo = session.createQuery("SELECT t FROM MedioContacto t WHERE t.estatus = 'ACTIVO' ", MedioContacto.class).getResultList();
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
	public Boolean guardaMedioContacto(MedioContacto medioContacto) {
		Boolean guardado = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			// se inicia una transaccion
			session.beginTransaction();
			session.persist(medioContacto);
			guardado = medioContacto.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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
	public Boolean actualizaMedioContacto(MedioContacto medioContacto) {
		Boolean guardado = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			// se inicia una transaccion
			session.beginTransaction();
			session.merge(medioContacto);
			guardado = medioContacto.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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
	public Boolean eliminaMedioContacto(MedioContacto medioContacto) {
		Boolean eliminado = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.remove(medioContacto);
			eliminado = medioContacto.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return eliminado;
	}
}
