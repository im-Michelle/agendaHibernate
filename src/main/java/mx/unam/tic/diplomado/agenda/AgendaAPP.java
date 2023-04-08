package mx.unam.tic.diplomado.agenda;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import mx.unam.tic.diplomado.agenda.modelo.entidades.Contacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.TipoContacto;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import mx.unam.tic.diplomado.agenda.servicios.ContactoMedioServicio;
import mx.unam.tic.diplomado.agenda.servicios.ContactoServicio;
import mx.unam.tic.diplomado.agenda.servicios.MedioContactoServicio;
import mx.unam.tic.diplomado.agenda.servicios.TipoContactoServicio;
import mx.unam.tic.diplomado.agenda.servicios.impl.ContactoMedioServicioImpl;
import mx.unam.tic.diplomado.agenda.servicios.impl.ContactoServicioImpl;
import mx.unam.tic.diplomado.agenda.servicios.impl.MedioContactoServicioImpl;
import mx.unam.tic.diplomado.agenda.servicios.impl.TipoContactoServicioImpl;

public class AgendaAPP {
	private Scanner sn;
	private MedioContactoServicio medioContactoServicio = MedioContactoServicioImpl.getInstance();
	private TipoContactoServicio tipoContactoServicio = TipoContactoServicioImpl.getInstance();
	private ContactoServicio contactoServicio = ContactoServicioImpl.getInstance();
	private ContactoMedioServicio contactoMedioServicio = ContactoMedioServicioImpl.getInstance();

	public static void main(String[] args) {
		HibernateUtil.init(); 
		AgendaAPP catalogosAPP = new AgendaAPP();
		catalogosAPP.cargaMenu();
	}
	
	public void cargaMenu() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Catalogos");
            System.out.println("2. Contactos");
            System.out.println("3. Salir");
            try {
            	sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                    	System.out.println("-- Entrando menú catalogos --");
                    	cargaMenuCatalogos();
                        break;
                    case 2:
                        System.out.println("-- Entrando Contactos --");
                        cargaMenuContactos();
                        break;
                    case 3:
                    	salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir) ;
	}
	
	public void cargaMenuCatalogos() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Medio Contacto");
            System.out.println("2. Tipo Contacto");
            System.out.println("3. Salir");
            try {
            	sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                    	System.out.println("-- Entrando Catálogo Medio Contacto --");
                        cargaMenuMedioContacto();
                        break;
                    case 2:
                        System.out.println("-- Entrando Catálogo Tipo Contacto --");
                        cargaMenuTipoContacto();
                        break;
                    case 3:
                    	salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
	}
	
	public void cargaMenuMedioContacto() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Ver Medio Contacto por ID");
            System.out.println("2. Ver Medios Contactos");
            System.out.println("3. Insertar Medio Contacto");
            System.out.println("4. Actualizar Medio Contacto");
            System.out.println("5. Eliminar Medio Contacto");
            System.out.println("6. Salir");
            try {
            	sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                    	System.out.println("-- Entrando Ver Medio Contacto por ID --");
                        consultaMedioContactoRegistrosPorId();
                        break;
                    case 2:
                    	System.out.println("-- Entrando Ver Todos Medios Contactos --");
                        consultaMedioContactoRegistros();
                        break;
                    case 3:
                    	System.out.println("-- Entrando Crea Medio Contacto --");
                    	insertaMedioContactoRegistros();
                        break;
                    case 4:
                    	System.out.println("-- Entrando Actualiza Medio Contacto --");
                    	actualizaMedioContactoRegistros();
                        break;
                    case 5:
                    	System.out.println("-- Entrando Elimina Medio Contacto --");
                    	eliminaMedioContactoRegistros();
                        break;
                    case 6:
                    	salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
	}
	
	public void cargaMenuTipoContacto() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Ver Tipo Contacto por ID");
            System.out.println("2. Ver Tipos Contactos");
            System.out.println("3. Insertar Tipo Contacto");
            System.out.println("4. Actualizar Tipo Contacto");
            System.out.println("5. Eliminar Tipo Contacto");
            System.out.println("6. Salir");
            try {
            	sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                    	System.out.println("-- Entrando Ver Medio Contacto por ID --");
                        consultaTipoContactoRegistrosPorId();
                        break;
                    case 2:
                    	System.out.println("-- Entrando Ver Todos Medios Contactos --");
                        consultaTipoContactoRegistros();
                        break;
                    case 3:
                    	System.out.println("-- Entrando Crea Medio Contacto --");
                    	insertaTipoContactoRegistros();
                        break;
                    case 4:
                    	System.out.println("-- Entrando Actualiza Medio Contacto --");
                    	actualizaTipoContactoRegistros();
                        break;
                    case 5:
                    	System.out.println("-- Entrando Elimina Medio Contacto --");
                    	eliminaTipoContactoRegistros();
                        break;
                    case 6:
                    	salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
	}
	
	public void cargaMenuContactos() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
        	System.out.println("1. Ver Contacto por ID");
            System.out.println("2. Ver Contactos");
            System.out.println("3. Insertar Contacto");
            System.out.println("4. Actualizar Contacto");
            System.out.println("5. Eliminar Contacto");
            System.out.println("6. Salir");
            try {
            	sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                    	System.out.println("-- Entrando Ver Contacto por ID --");
                        consultaContactoRegistrosPorId();
                        break;
                    case 2:
                    	System.out.println("-- Entrando Ver Todos Contactos --");
                    	consultaContactoRegistros();
                        break;
                    case 3:
                    	System.out.println("-- Entrando Crea Contacto --");
                    	insertaContactoRegistros();
                        break;
                    case 4:
                    	System.out.println("-- Entrando Actualiza Contacto --");
                    	actualizaContactoRegistros();
                        break;
                    case 5:
                    	System.out.println("-- Entrando Elimina Contacto --");
                    	eliminaContactoRegistros();
                        break;
                    case 6:
                    	salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
	}
	
	public void consultaMedioContactoRegistros() {
		for (MedioContacto medioContacto : medioContactoServicio.cargaMediosContacto()) {
			System.out.println("Medio Contacto:" + medioContacto.toString());
		}
	}
	
	public void consultaMedioContactoRegistrosPorId() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dame el id a buscar:");
		int busca = scanner.nextInt();
		MedioContacto medioContacto = medioContactoServicio.cargaMedioContactoPorId(busca);
		if (medioContacto != null)
			System.out.println("Medio Contacto:" + medioContacto.toString());
		else 
			System.out.println("Medio Contacto no encontrado");
	}
	
	public void insertaMedioContactoRegistros() {
		Scanner scanner = new Scanner(System.in);
		MedioContacto nuevo = new MedioContacto();
		System.out.println("Dame nombre: ");
		nuevo.setNombre(scanner.nextLine());
		nuevo.setEstatus("ACTIVO");
		if (medioContactoServicio.guardaMedioContacto(nuevo))
			System.out.println("Insertado correctamente");
		else
			System.out.println("Error al insertar registro");
	}
	
	public void actualizaMedioContactoRegistros() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dame el id a actualizar:");
		int busca = scanner.nextInt();
		scanner.nextLine();//limpieza
		MedioContacto medioContacto = medioContactoServicio.cargaMedioContactoPorId(busca);
		if (medioContacto != null) {
			System.out.println("Medio Contacto:" + medioContacto.toString());
			System.out.println("Dame nombre: ");
			medioContacto.setNombre(scanner.nextLine());
			if (medioContactoServicio.actualizaMedioContacto(medioContacto))
				System.out.println("Actualizado correctamente");
			else
				System.out.println("Error al actualizar registro");
		} else 
			System.out.println("Medio Contacto no encontrado");
	}
	
	public void eliminaMedioContactoRegistros() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dame el id a eliminar:");
		int busca = scanner.nextInt();
		scanner.nextLine();//limpieza
		MedioContacto medioContacto = medioContactoServicio.cargaMedioContactoPorId(busca);
		if (medioContacto != null) {
			System.out.println("Medio Contacto:" + medioContacto.toString());
			if (medioContactoServicio.eliminaMedioContacto(medioContacto))
				System.out.println("Eliminado correctamente");
			else
				System.out.println("Error al eliminar registro");
		} else 
			System.out.println("Medio Contacto no encontrado");
	}
	
	
	public void consultaTipoContactoRegistros() {
		for (TipoContacto tipoContacto : tipoContactoServicio.cargaTiposContacto()) {
			System.out.println("Tipo Contacto:" + tipoContacto.toString());
		}
	}
	
	public void consultaTipoContactoRegistrosPorId() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dame el id a buscar:");
		int busca = scanner.nextInt();
		TipoContacto tipoContacto = tipoContactoServicio.cargaTipoContactoPorId(busca);
		if (tipoContacto != null)
			System.out.println("Tipo Contacto:" + tipoContacto.toString());
		else 
			System.out.println("Tipo Contacto no encontrado");
	}
	
	public void insertaTipoContactoRegistros() {
		Scanner scanner = new Scanner(System.in);
		TipoContacto nuevo = new TipoContacto();
		System.out.println("Dame nombre: ");
		nuevo.setNombre(scanner.nextLine());
		nuevo.setEstatus("ACTIVO");
		if (tipoContactoServicio.guardaTipoContacto(nuevo))
			System.out.println("Insertado correctamente");
		else
			System.out.println("Error al insertar registro");
	}
	
	public void actualizaTipoContactoRegistros() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dame el id a actualizar:");
		int busca = scanner.nextInt();
		scanner.nextLine();//limpieza
		TipoContacto tipoContacto = tipoContactoServicio.cargaTipoContactoPorId(busca);
		if (tipoContacto != null) {
			System.out.println("Medio Contacto:" + tipoContacto.toString());
			System.out.println("Dame nombre: ");
			tipoContacto.setNombre(scanner.nextLine());
			if (tipoContactoServicio.actualizaTipoContacto(tipoContacto))
				System.out.println("Actualizado correctamente");
			else
				System.out.println("Error al actualizar registro");
		} else 
			System.out.println("Medio Contacto no encontrado");
	}
	
	public void eliminaTipoContactoRegistros() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dame el id a eliminar:");
		int busca = scanner.nextInt();
		scanner.nextLine();//limpieza
		TipoContacto tipoContacto = tipoContactoServicio.cargaTipoContactoPorId(busca);
		if (tipoContacto != null) {
			System.out.println("Medio Contacto:" + tipoContacto.toString());
			if (tipoContactoServicio.eliminaTipoContacto(tipoContacto))
				System.out.println("Eliminado correctamente");
			else
				System.out.println("Error al eliminar registro");
		} else 
			System.out.println("Medio Contacto no encontrado");
	}
	
	public void consultaContactoRegistros() {
		for (Contacto contacto : contactoServicio.cargaContactos()) {
			System.out.println("Contacto:" + contacto.toString());
		}
	}
	
	public void consultaContactoRegistrosPorId() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dame el id a buscar:");
		int busca = scanner.nextInt();
		Contacto contacto = contactoServicio.cargaContactoPorId(busca);
		if (contacto != null)
			System.out.println("Contacto:" + contacto.toString());
		else 
			System.out.println("Contacto no encontrado");
	}
	
	public void insertaContactoRegistros() {
		Scanner scanner = new Scanner(System.in);
		Contacto nuevo = new Contacto();
		System.out.println("Dame nombre: ");
		nuevo.setNombre(scanner.nextLine());
		System.out.println("Dame apellidos: ");
		nuevo.setApellidos(scanner.nextLine());
		System.out.println("Dame edad: ");
		nuevo.setEdad(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Dame dirección: ");
		nuevo.setDireccion(scanner.nextLine());
		System.out.println("Tipos de Contactos a elegir: ");
		consultaTipoContactoRegistros();
		System.out.println("Dame ID Tipo Contacto: ");
		int busca = scanner.nextInt();
		scanner.nextLine();
		TipoContacto tipoContacto = tipoContactoServicio.cargaTipoContactoPorId(busca);
		if (tipoContacto != null)
			nuevo.setTipoContacto(tipoContacto);	
		else
			nuevo.setTipoContacto(null);
		System.out.println("Medios de Contactos a elegir: ");
		consultaMedioContactoRegistros();
		System.out.println("Dame ID Medio Contacto: ");
		busca = scanner.nextInt();
		scanner.nextLine();
		MedioContacto medio = medioContactoServicio.cargaMedioContactoPorId(busca); //obtencion de catalogo de medio contacto
		ContactoMedio contactoMedio = new ContactoMedio(); //creacion de contacto medio
		System.out.println("Dame numero de telefono: ");
		contactoMedio.setValor(scanner.nextLine()); //llenado de datos de contacto medio
		contactoMedio.setMedioContacto(medio); //relacionamos contacto medio con catalogo medio contacto
		contactoMedio.setContacto(nuevo); // relacionamos con contacto
		Set<ContactoMedio> contactosMedios = new HashSet<ContactoMedio>(); //generamos la coleccion
		contactosMedios.add(contactoMedio); //llenamos la coleccion
		nuevo.setContactosMedios(contactosMedios);
		if (contactoServicio.guardaContacto(nuevo))
			System.out.println("Insertado correctamente");
		else
			System.out.println("Error al insertar registro");
	}
	
	public void actualizaContactoRegistros() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dame el id a actualizar:");
		int busca = scanner.nextInt();
		scanner.nextLine();//limpieza
		Contacto nuevo = contactoServicio.cargaContactoPorId(busca);
		if (nuevo != null) {
			System.out.println("Dame nombre: ");
			nuevo.setNombre(scanner.nextLine());
			System.out.println("Dame apellidos: ");
			nuevo.setApellidos(scanner.nextLine());
			System.out.println("Dame edad: ");
			nuevo.setEdad(scanner.nextInt());
			scanner.nextLine();
			System.out.println("Dame dirección: ");
			nuevo.setDireccion(scanner.nextLine());
			System.out.println("Tipos de Contactos a elegir: ");
			consultaTipoContactoRegistros();
			System.out.println("Dame ID Tipo Contacto: ");
			busca = scanner.nextInt();
			scanner.nextLine();
			TipoContacto tipoContacto = tipoContactoServicio.cargaTipoContactoPorId(busca);
			if (tipoContacto != null)
				nuevo.setTipoContacto(tipoContacto);	
			else
				nuevo.setTipoContacto(null);
			
			//se eliminan los anteriores para evitar conflictos
			List<ContactoMedio> medios = contactoMedioServicio.cargaContactosMediosPorContacto(nuevo.getId());
			for (ContactoMedio medio : medios) {
				contactoMedioServicio.eliminaContactoMedio(medio);
			}
			//se procede a adjuntar uno nuevo
			System.out.println("Medios de Contactos a elegir: ");
			consultaMedioContactoRegistros();
			System.out.println("Dame ID Medio Contacto: ");
			busca = scanner.nextInt();
			scanner.nextLine();
			MedioContacto medio = medioContactoServicio.cargaMedioContactoPorId(busca); //obtencion de catalogo de medio contacto
			ContactoMedio contactoMedio = new ContactoMedio(); //creacion de contacto medio
			System.out.println("Dame numero de telefono: ");
			contactoMedio.setValor(scanner.nextLine()); //llenado de datos de contacto medio
			contactoMedio.setMedioContacto(medio); //relacionamos contacto medio con catalogo medio contacto
			contactoMedio.setContacto(nuevo); // relacionamos con contacto
			Set<ContactoMedio> contactosMedios = new HashSet<ContactoMedio>(); //generamos la coleccion
			contactosMedios.add(contactoMedio); //llenamos la coleccion
			nuevo.setContactosMedios(contactosMedios);
			if (contactoServicio.actualizaContacto(nuevo))
				System.out.println("Insertado correctamente");
			else
				System.out.println("Error al insertar registro");
		} else 
			System.out.println("Medio Contacto no encontrado");
	}
	
	public void eliminaContactoRegistros() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dame el id a eliminar:");
		int busca = scanner.nextInt();
		scanner.nextLine();//limpieza
		Contacto contacto = contactoServicio.cargaContactoPorId(busca);
		if (contacto != null) {
			System.out.println("Contacto:" + contacto.toString());
			//se hace forzado, puesto que cascade no funciona
			List<ContactoMedio> medios = contactoMedioServicio.cargaContactosMediosPorContacto(contacto.getId());
			for (ContactoMedio medio : medios) {
				contactoMedioServicio.eliminaContactoMedio(medio);
			}
			contacto.setContactosMedios(null);// se elimina, sino, falla
			if (contactoServicio.eliminaContacto(contacto))
				System.out.println("Eliminado correctamente");
			else
				System.out.println("Error al eliminar registro");
		} else 
			System.out.println("Contacto no encontrado");
	}
}
