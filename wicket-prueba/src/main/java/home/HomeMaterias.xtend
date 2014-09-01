package home

import java.util.ArrayList
import domain.Materia


public class HomeMaterias 
{
	ArrayList<Materia> materias;
	
	
	def getMaterias()
	{
		return this.materias;
	}
	
	def void addMateria(String nombre, int anio_cursada, String profesor, boolean final_aprobado, String ubicacion)
	{
		var materia = new Materia()
		materia.nombre = nombre
		materia.anio_cursada = anio_cursada
		materia.profesor = profesor
		materia.final_aprobado = final_aprobado
		materia.ubicacion = ubicacion
		materia.notas = new ArrayList()	
		
		this.materias.add(materia)		
	}
}