package mx.unam.tic.diplomado.agenda.servicios;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;

public interface MedioContactoServicio {
	List<MedioContacto> cargaMediosContacto();
	MedioContacto cargaMedioContactoPorId(Integer id);
	Boolean guardaMedioContacto(MedioContacto medioContacto);
	Boolean actualizaMedioContacto(MedioContacto medioContacto);
	Boolean eliminaMedioContacto(MedioContacto medioContacto);
}
