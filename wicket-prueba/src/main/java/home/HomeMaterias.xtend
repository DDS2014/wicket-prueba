package home

import domain.Materia
import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.utils.Observable
import java.util.ArrayList

@Observable
class HomeMaterias extends CollectionBasedHome<Materia>
{
	new() {
		this.init
	}
	
	def void init() {
		this.create("Matemática Discreta", 2012, "Pepe", true)
		this.create("Análisis Matemático I", 2013, "Juan", false)
		this.create("Álgebra", 2014, "Jose", true)
	}
	
	def void create(String nombre, int anioCursada, String profesor, Boolean finalAprobado){
		var materia = new Materia
		materia.nombre=nombre
		materia.anioCursada = anioCursada
		materia.profesor = profesor
		materia.finalAprobado = finalAprobado
		this.create(materia)
	}

	override def getCriterio(Materia example) {
		null
	}
	
	override def createExample() {
		var materia = new Materia
		materia.notas = new ArrayList()
		return materia
	}
	
	override def getEntityType() {
		typeof(Materia)
	}
	
	def refresh(){
		return allInstances.toList
	}
}