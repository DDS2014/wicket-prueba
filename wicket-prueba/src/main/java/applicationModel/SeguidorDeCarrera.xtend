package applicationModel


import home.HomeMaterias //todo por que no me deja importarlo static?????
import org.uqbar.commons.utils.ApplicationContext
import java.util.List
import java.io.Serializable
import domain.Materia

@org.uqbar.commons.utils.Observable
class SeguidorDeCarrera implements Serializable
{
	@Property List<Materia> materias;
	@Property Materia materiaSeleccionada;
	@Property List<String> ubicaciones;

	
	def HomeMaterias getHomeMaterias() {
		ApplicationContext::instance.getSingleton(typeof(Materia))
	}

	def refresh(){
		this.materias = getHomeMaterias().refresh()
		this.materiaSeleccionada = this.materias.get(0)

	}
	
	def seleccionarMateria(Materia materia){
		this.materiaSeleccionada = materia
	}
	
	def crearMateriaDefault(String nombre)
	{
		var materia = getHomeMaterias().createExample()
		materia.nombre = nombre
		getHomeMaterias.create(materia)
	}

}