package mx.unam.tic.diplomado.agenda.servicios.impl;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.dao.MedioContactoDAO;
import mx.unam.tic.diplomado.agenda.modelo.dao.impl.MedioContactoDAOImpl;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;
import mx.unam.tic.diplomado.agenda.servicios.MedioContactoServicio;

public class MedioContactoServicioImpl implements MedioContactoServicio {
	
	private static MedioContactoServicioImpl instance;
	private static MedioContactoDAO medioContactoDAO = MedioContactoDAOImpl.getInstance();
	
	private MedioContactoServicioImpl() {
		
	}
	
	public static MedioContactoServicioImpl getInstance() {
		if (instance == null) {
			instance = new MedioContactoServicioImpl();
		}
		return instance;
	}
	
	@Override
	public List<MedioContacto> cargaMediosContacto() {
		return medioContactoDAO.cargaMediosContacto();
	}

	@Override
	public MedioContacto cargaMedioContactoPorId(Integer id) {
		return medioContactoDAO.cargaMedioContactoPorId(id);
	}
	
	@Override
	public Boolean guardaMedioContacto(MedioContacto medioContacto) {
		return medioContactoDAO.guardaMedioContacto(medioContacto);
	}
	
	@Override
	public Boolean actualizaMedioContacto(MedioContacto medioContacto) {
		return medioContactoDAO.actualizaMedioContacto(medioContacto);
	}
	
	@Override
	public Boolean eliminaMedioContacto(MedioContacto medioContacto) {
		return medioContactoDAO.eliminaMedioContacto(medioContacto);
	}
}
