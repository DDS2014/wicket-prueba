package domain;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Materia extends Entity {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private int _anioCursada;
  
  public int getAnioCursada() {
    return this._anioCursada;
  }
  
  public void setAnioCursada(final int anioCursada) {
    this._anioCursada = anioCursada;
  }
  
  private String _profesor;
  
  public String getProfesor() {
    return this._profesor;
  }
  
  public void setProfesor(final String profesor) {
    this._profesor = profesor;
  }
  
  private Boolean _finalAprobado;
  
  public Boolean getFinalAprobado() {
    return this._finalAprobado;
  }
  
  public void setFinalAprobado(final Boolean finalAprobado) {
    this._finalAprobado = finalAprobado;
  }
  
  private String _ubicacion;
  
  public String getUbicacion() {
    return this._ubicacion;
  }
  
  public void setUbicacion(final String ubicacion) {
    this._ubicacion = ubicacion;
  }
}
