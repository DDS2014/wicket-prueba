package home

import java.util.ArrayList
import domain.Materia


public class HomeMaterias 
{
	static ArrayList<Materia> materias; //todo verificar si esto significa que todas las instancias de HomeMaterias acceden a la misma ArrayList
	
	
	def getMaterias()
	{
		return materias;
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
		
		materias.add(materia)		
	}
	
	def void addMateria(Materia materia)
	{
		materias.add(materia)
	}
	
	def Materia addMateriaDefault(String nombre)
	//crea una materia por default y la agrega a la home, con el único dato del nombre
	//devuelve una referencia a la materia recién creada
	{
		var materia = new Materia()
		materia.nombre = nombre;
		materia.anio_cursada = 0;
		materia.final_aprobado = false;
		materia.profesor = "nadie";
		materia.ubicacion = "?";
		materia.notas = new ArrayList();
		addMateria(materia);
		return materia;
	}
	
}