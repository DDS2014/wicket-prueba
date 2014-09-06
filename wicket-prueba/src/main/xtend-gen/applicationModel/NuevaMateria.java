package applicationModel;

import applicationModel.SeguidorDeCarrera;
import com.google.common.base.Objects;
import java.io.Serializable;
import org.uqbar.commons.model.UserException;

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
    this.validarse();
    String _nombre = this.getNombre();
    this.seguidor.crearMateriaDefault(_nombre);
  }
  
  public void validarse() {
    boolean _or = false;
    String _nombre = this.getNombre();
    boolean _equals = Objects.equal(_nombre, "");
    if (_equals) {
      _or = true;
    } else {
      String _nombre_1 = this.getNombre();
      boolean _equals_1 = Objects.equal(_nombre_1, null);
      _or = _equals_1;
    }
    if (_or) {
      throw new UserException("Debe especificar un nombre de materia.");
    }
  }
}
