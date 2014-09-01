package domain;

import domain.Nota;
import java.util.ArrayList;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Materia extends Entity {
  public Materia() {
    ArrayList<Nota> _arrayList = new ArrayList<Nota>();
    this.setNotas(_arrayList);
  }
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private int _anio_cursada;
  
  public int getAnio_cursada() {
    return this._anio_cursada;
  }
  
  public void setAnio_cursada(final int anio_cursada) {
    this._anio_cursada = anio_cursada;
  }
  
  private String _profesor;
  
  public String getProfesor() {
    return this._profesor;
  }
  
  public void setProfesor(final String profesor) {
    this._profesor = profesor;
  }
  
  private boolean _final_aprobado;
  
  public boolean isFinal_aprobado() {
    return this._final_aprobado;
  }
  
  public void setFinal_aprobado(final boolean final_aprobado) {
    this._final_aprobado = final_aprobado;
  }
  
  private String _ubicacion;
  
  public String getUbicacion() {
    return this._ubicacion;
  }
  
  public void setUbicacion(final String ubicacion) {
    this._ubicacion = ubicacion;
  }
  
  private ArrayList<Nota> _notas;
  
  public ArrayList<Nota> getNotas() {
    return this._notas;
  }
  
  public void setNotas(final ArrayList<Nota> notas) {
    this._notas = notas;
  }
  
  public String toString() {
    return this.getNombre();
  }
}
