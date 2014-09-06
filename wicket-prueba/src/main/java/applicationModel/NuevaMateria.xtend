package applicationModel

import java.io.Serializable

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
		seguidor.crearMateriaDefault(nombre);
	}
	
}