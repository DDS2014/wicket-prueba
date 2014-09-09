package applicationModel

import java.io.Serializable
import org.uqbar.commons.model.UserException

class NuevaMateria implements Serializable
{
	SeguidorDeCarrera seguidor;
	@Property String nombre;
	
	new(SeguidorDeCarrera seguidor)
	{
		this.seguidor = seguidor;
	}
	
	def agregarse()
	{
		this.validarNombre(nombre)
		seguidor.crearMateriaDefault(nombre);
	}
	
	def void validarNombre(String nombre) 
	{
		if (nombre == null)
		{
			throw new UserException("Debe especificar un nombre de materia.")
		}
	}
	
}