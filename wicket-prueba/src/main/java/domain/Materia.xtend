package domain


import org.uqbar.commons.utils.Observable
import java.util.ArrayList
import org.uqbar.commons.model.Entity

@Observable
class Materia extends Entity
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
	
	
}