package mx.unam.tic.diplomado.agenda.modelo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import mx.unam.tic.diplomado.agenda.modelo.dao.TipoContactoDAO;
import mx.unam.tic.diplomado.agenda.modelo.entidades.TipoContacto;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;

public class TipoContactoDAOImpl implements TipoContactoDAO {

	private static TipoContactoDAOImpl instance;

	private TipoContactoDAOImpl() {
	}

	public static TipoContactoDAOImpl getInstance() {
		if (instance == null) {
			instance = new TipoContactoDAOImpl();
		}
		return instance;
	}
	
	@Override
	public TipoContacto cargaTipoContactoPorId(Integer id) {
		TipoContacto tipoContacto = null;
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();

			// se inicia una transaccion
			session.beginTransaction();
			tipoContacto = session.get(TipoContacto.class, id);
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return tipoContacto;
	}
	
	@Override
	public List<TipoContacto> cargaTiposContacto() {
		List<TipoContacto> catalogo = null;
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();

			// se inicia una transaccion
			session.beginTransaction();
			//catalogo = session.createQuery("SELECT t FROM TipoContacto t WHERE t.estatus = 'ACTIVO' ").list();
			catalogo = session.createQuery("SELECT t FROM TipoContacto t WHERE t.estatus = 'ACTIVO' ", TipoContacto.class).getResultList();
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
	public Boolean guardaTipoContacto(TipoContacto tipoContacto) {
		Boolean guardado = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.persist(tipoContacto);
			guardado = tipoContacto.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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
	public Boolean actualizaTipoContacto(TipoContacto tipoContacto) {
		Boolean guardado = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.merge(tipoContacto);
			guardado = tipoContacto.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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
	public Boolean eliminaTipoContacto(TipoContacto tipoContacto) {
		Boolean eliminado = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.remove(tipoContacto);
			eliminado = tipoContacto.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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
