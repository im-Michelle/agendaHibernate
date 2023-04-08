package mx.unam.tic.diplomado.agenda.modelo.dao;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.entidades.TipoContacto;

public interface TipoContactoDAO {
	TipoContacto cargaTipoContactoPorId(Integer id);
	List<TipoContacto> cargaTiposContacto();
	Boolean guardaTipoContacto(TipoContacto tipoContacto);
	Boolean actualizaTipoContacto(TipoContacto tipoContacto);
	Boolean eliminaTipoContacto(TipoContacto tipoContacto);
}
