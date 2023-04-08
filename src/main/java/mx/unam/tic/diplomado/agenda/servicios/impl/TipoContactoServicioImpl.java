package mx.unam.tic.diplomado.agenda.servicios.impl;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.dao.TipoContactoDAO;
import mx.unam.tic.diplomado.agenda.modelo.dao.impl.TipoContactoDAOImpl;
import mx.unam.tic.diplomado.agenda.modelo.entidades.TipoContacto;
import mx.unam.tic.diplomado.agenda.servicios.TipoContactoServicio;

public class TipoContactoServicioImpl implements TipoContactoServicio {
	
	private static TipoContactoServicioImpl instance;
	private static TipoContactoDAO tipoContactoDAO = TipoContactoDAOImpl.getInstance();
	
	private TipoContactoServicioImpl() {
		
	}
	
	public static TipoContactoServicioImpl getInstance() {
		if (instance == null) {
			instance = new TipoContactoServicioImpl();
		}
		return instance;
	}
	
	@Override
	public List<TipoContacto> cargaTiposContacto() {
		return tipoContactoDAO.cargaTiposContacto();
	}
	
	@Override
	public TipoContacto cargaTipoContactoPorId(Integer id) {
		return tipoContactoDAO.cargaTipoContactoPorId(id);
	}

	@Override
	public Boolean guardaTipoContacto(TipoContacto tipoContacto) {
		return tipoContactoDAO.guardaTipoContacto(tipoContacto);
	}
	
	@Override
	public Boolean actualizaTipoContacto(TipoContacto tipoContacto) {
		return tipoContactoDAO.actualizaTipoContacto(tipoContacto);
	}
	
	@Override
	public Boolean eliminaTipoContacto(TipoContacto tipoContacto) {
		return tipoContactoDAO.eliminaTipoContacto(tipoContacto);
	}
}
