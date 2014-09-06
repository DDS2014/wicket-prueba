package applicationModel;

import applicationModel.SeguidorDeCarrera;
import java.io.Serializable;

@SuppressWarnings("all")
public class NuevaMateria implements Serializable {
  private SeguidorDeCarrera seguidor;
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  public NuevaMateria(final SeguidorDeCarrera seguidor) {
    this.seguidor = seguidor;
  }
  
  public void agregarse() {
    String _nombre = this.getNombre();
    this.seguidor.crearMateriaDefault(_nombre);
  }
}
