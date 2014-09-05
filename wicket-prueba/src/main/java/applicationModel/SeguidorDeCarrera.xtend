package applicationModel


import home.HomeMaterias //todo por que no me deja importarlo static?????
import domain.Materia
import domain.Nota
import java.util.ArrayList


class SeguidorDeCarrera 
{
	HomeMaterias homeMaterias;
	@Property Materia materiaSeleccionada;
	@Property ArrayList<Materia> materiasDisponibles;
	@Property Nota notaSeleccionada
	@Property ArrayList<Nota> notas;
	
	@Property String nombre;
	@Property int anio_cursada;
	@Property boolean final_aprobado;
	@Property String profesor;
	@Property String ubicacion;	
	
	
	new()
	{
		homeMaterias = new HomeMaterias();
	}
	
	
	
	def cargarDatosMateria() //para refrescar los datos de la materia seleccionada cuando le doy editar a una materia
	{
		this.nombre = materiaSeleccionada.nombre;
		this.anio_cursada = materiaSeleccionada.anio_cursada;
		this.final_aprobado = materiaSeleccionada.final_aprobado;
		this.profesor = materiaSeleccionada.profesor;
		this.ubicacion = materiaSeleccionada.ubicacion;
		this.notas = materiaSeleccionada.notas; 
	} //esto de última se puede pasar a la ui si está de más
	
	def guardarDatosMateria() //para tocar el modelo cuando le doy el OK a la modificación
	{
		materiaSeleccionada.nombre = this.nombre;
		materiaSeleccionada.anio_cursada = this.anio_cursada;
		materiaSeleccionada.final_aprobado = this.final_aprobado;
		materiaSeleccionada.profesor = this.profesor;
		materiaSeleccionada.ubicacion = this.ubicacion;
		materiaSeleccionada.notas = this.notas;
		
	} //esto de última se puede pasar a la ui si está de más
	
	def crearMateriaDefault(String nombre)
	//esto tiene que llamarse desde el diálogo de "agregar nueva materia"
	//este diálogo me va a dar el nombre de la nueva materia
	//este method la crea y me la deja seleccionada para editarla en el panel derecho
	{
		
		materiaSeleccionada = homeMaterias.addMateriaDefault(nombre); //esto crea una materia default mediante la abastracción que me da mi home
		this.cargarDatosMateria(); //y esto refresca el panel derecho para que refleje la materia seleccionada.
		//por ahí el cargarDatosMateria() que refresca el panel derecho podría llamarse desde el setter de la materia seleccionada
	}
	
	
//	
//	def void search()
//	{
//		materiasDisponibles = new ArrayList<Materia>
//		
//	}

	def void agregarNota(Nota nota)
	{
		materiaSeleccionada.agregarNota(nota);
	} //la ventana de nota debería bindear con una nota nueva y llamar a este method cuando se le da aceptar

	def void removerNotaSeleccionada() 
	{
		materiaSeleccionada.notas.remove(notaSeleccionada)
	}
	
//	def agregarNota() {
//		var notaNueva = new Nota
//		notaNueva.fecha = new Date
//		notaNueva.descripcion = "TP"
//		notaNueva.aprobado = true
//		materiaSeleccionada.notas.add(notaNueva)
//	}
	

	
}