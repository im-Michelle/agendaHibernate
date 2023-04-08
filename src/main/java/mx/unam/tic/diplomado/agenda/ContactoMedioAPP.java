package mx.unam.tic.diplomado.agenda;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import mx.unam.tic.diplomado.agenda.servicios.MedioContactoServicio;
import mx.unam.tic.diplomado.agenda.servicios.ContactoServicio;
import mx.unam.tic.diplomado.agenda.servicios.impl.MedioContactoServicioImpl;
import mx.unam.tic.diplomado.agenda.servicios.impl.ContactoServicioImpl;

public class ContactoMedioAPP {

	public static void main(String[] args) {
		HibernateUtil.init();
		
		MedioContactoServicio medioContactoServicio = MedioContactoServicioImpl.getInstance();
		ContactoServicio contactoServicio = ContactoServicioImpl.getInstance();
		
		MedioContacto medioContacto = medioContactoServicio.cargaMedioContactoPorId(1);
		
		List<ContactoMedio> contactosMedio = contactoServicio.cargaContactosMedio(medioContacto);
		
		if (contactosMedio != null && ! contactosMedio.isEmpty()) {
			System.out.println("Los números de medio de contacto:" + medioContacto.getNombre());
			for (ContactoMedio contactoMedio : contactosMedio) {
				System.out.println("El número es:" 
						+ contactoMedio.getValor() 
						+ " y el nombre del contacto es:" + contactoMedio.getContacto().getNombre());
			}
		}
	}
}
