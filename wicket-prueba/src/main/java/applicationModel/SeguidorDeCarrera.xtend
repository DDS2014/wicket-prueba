package applicationModel


import home.HomeMaterias //por que no me deja importarlo static?????
import domain.Materia
import domain.Nota
import java.util.Date
import java.util.ArrayList

//TODO arreglar esta clase
class SeguidorDeCarrera 
{
	HomeMaterias homeMaterias;
	@Property Materia materiaSeleccionada;
	@Property ArrayList<Materia> materiasDisponibles;
	@Property Nota notaSeleccionada
	
	new()
	{
		homeMaterias = new HomeMaterias();
	}
	
	
	
//	
//	def void search()
//	{
//		materiasDisponibles = new ArrayList<Materia>
//		
//	}
//	def void removerNotaSeleccionada() {
//		materiaSeleccionada.notas.remove(notaSeleccionada)
//	}
	
	def agregarNota() {
		var notaNueva = new Nota
		notaNueva.fecha = new Date
		notaNueva.descripcion = "TP"
		notaNueva.aprobado = true
		materiaSeleccionada.notas.add(notaNueva)
	}
	
//	def HomeMaterias getHomeMaterias()
//	{
//		ApplicationContext.instance.getSingleton(typeof(Materia))
//	}
	
	
}