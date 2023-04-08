package mx.unam.tic.diplomado.agenda.servicios;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.entidades.TipoContacto;

public interface TipoContactoServicio {
	TipoContacto cargaTipoContactoPorId(Integer id);
	List<TipoContacto> cargaTiposContacto();
	Boolean guardaTipoContacto(TipoContacto tipoContacto);
	Boolean actualizaTipoContacto(TipoContacto tipoContacto);
	Boolean eliminaTipoContacto(TipoContacto tipoContacto);
}
