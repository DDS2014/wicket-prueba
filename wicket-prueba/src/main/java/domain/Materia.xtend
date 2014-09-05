package domain



import java.util.ArrayList


class Materia

{
	new()
	{
		this.notas = new ArrayList();
	}
	
	@Property String nombre;
	@Property int anio_cursada;
	@Property String profesor;
	@Property boolean final_aprobado;
	@Property String ubicacion;
	@Property ArrayList<Nota> notas;	

	override toString()
	{
		return this.nombre
	}
	
	def agregarNota(Nota nota)
	{
		this.notas.add(nota)
	}
	
	
}