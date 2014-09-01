package domain;

import java.util.Date;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Nota {
  private Date _fecha;
  
  public Date getFecha() {
    return this._fecha;
  }
  
  public void setFecha(final Date fecha) {
    this._fecha = fecha;
  }
  
  private String _descripcion;
  
  public String getDescripcion() {
    return this._descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this._descripcion = descripcion;
  }
  
  private boolean _aprobado;
  
  public boolean isAprobado() {
    return this._aprobado;
  }
  
  public void setAprobado(final boolean aprobado) {
    this._aprobado = aprobado;
  }
}
