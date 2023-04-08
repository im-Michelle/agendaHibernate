package mx.unam.tic.diplomado.agenda;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mx.unam.tic.diplomado.agenda.modelo.entidades.Contacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.TipoContacto;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import mx.unam.tic.diplomado.agenda.servicios.MedioContactoServicio;
import mx.unam.tic.diplomado.agenda.servicios.TipoContactoServicio;
import mx.unam.tic.diplomado.agenda.servicios.ContactoServicio;
import mx.unam.tic.diplomado.agenda.servicios.impl.MedioContactoServicioImpl;
import mx.unam.tic.diplomado.agenda.servicios.impl.TipoContactoServicioImpl;
import mx.unam.tic.diplomado.agenda.servicios.impl.ContactoServicioImpl;

public class Agenda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HibernateUtil.init();
		
		TipoContactoServicio tipoContactoServicio = TipoContactoServicioImpl.getInstance();
		MedioContactoServicio medioContactoServicio = MedioContactoServicioImpl.getInstance();
		ContactoServicio contactoServicio = ContactoServicioImpl.getInstance();
		
		
		/*List<TipoContacto> tiposContacto = tipoContactoServicio.cargaTiposContacto();
		for (TipoContacto tipoContacto : tiposContacto) {
			System.out.println("El tipo contacto es:" + tipoContacto.getNombre());
		}
		TipoContacto familiar = tipoContactoServicio.cargaTipoContactoPorId(1);
		System.out.println("El contacto familiar===" + familiar);
		List<MedioContacto> mediosContacto = medioContactoServicio.cargaMediosContacto();
		for (MedioContacto medioContacto : mediosContacto) {
			System.out.println("El medio contacto es:" + medioContacto.getNombre());
		}
		MedioContacto casa = medioContactoServicio.cargaMedioContactoPorId(1);
		System.out.println("El medio casa===" + casa);*/
		
		/*Contacto papa = new Contacto();//creacion de contacto
		papa.setNombre("Panchito");
		papa.setApellidos("Perez");
		papa.setDireccion("Calle de la Muerte");
		papa.setEdad(40);		//lenado de datos de contacto
		TipoContacto laboral = tipoContactoServicio.cargaTipoContactoPorId(3); //obtencion de catalogo tipo contacto
		papa.setTipoContacto(laboral); //relacionamos contacto con tipo contacto
		
		MedioContacto celular = medioContactoServicio.cargaMedioContactoPorId(3); //obtencion de catalogo de medio contacto
		ContactoMedio contactoMedio = new ContactoMedio(); //creacion de contacto medio
		contactoMedio.setValor("0445513264578"); //llenado de datos de contacto medio
		contactoMedio.setMedioContacto(celular); //relacionamos contacto medio con catalogo medio contacto
		contactoMedio.setContacto(papa); // relacionamos con contacto
		Set<ContactoMedio> contactosMedios = new HashSet<ContactoMedio>(); //generamos la coleccion
		contactosMedios.add(contactoMedio); //llenamos la coleccion
		papa.setContactosMedios(contactosMedios); //asignamos la coleccion al contacto
		
		contactoServicio.guardaContacto(papa); //guardamos al contacto*/
		
		List<Contacto> contactos = contactoServicio.cargaContactos();
		for (Contacto contacto : contactos) {
			System.out.println("El contacto es:" + contacto.getNombre());
			System.out.println("El tipo contacto es:" + contacto.getTipoContacto().getNombre());
			for(ContactoMedio m : contacto.getContactosMedios()) {
				System.out.println("m" + m.getValor());
			}
		}
	}

}
