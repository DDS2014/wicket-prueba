package main;

import applicationModel.NuevaNota;
import domain.Nota;
import main.HomePage;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;

@SuppressWarnings("all")
public class AgregarNotaPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private HomePage mainPage;
  
  private boolean alta;
  
  private Nota nota;
  
  private NuevaNota nuevaNota;
  
  public MarkupContainer init(final HomePage mainPage, final Nota nota) {
    MarkupContainer _xblockexpression = null;
    {
      this.nota = nota;
      this.mainPage = mainPage;
      CompoundPropertyModel<Nota> _compoundPropertyModel = new CompoundPropertyModel<Nota>(nota);
      Form<Nota> notaForm = new Form<Nota>("notaForm", _compoundPropertyModel);
      this._wicketExtensionFactoryMethods.addChild(this, notaForm);
      TextField<Object> _textField = new TextField<Object>("descripcion");
      this._wicketExtensionFactoryMethods.addChild(notaForm, _textField);
      TextField<Object> _textField_1 = new TextField<Object>("fecha");
      this._wicketExtensionFactoryMethods.addChild(notaForm, _textField_1);
      CheckBox _checkBox = new CheckBox("aprobado");
      this._wicketExtensionFactoryMethods.addChild(notaForm, _checkBox);
      XButton botonVolver = new XButton("botonVolver");
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AgregarNotaPage.this.volver();
        }
      };
      botonVolver.setOnClick(_function);
      XButton botonAceptar = new XButton("botonAceptar");
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          AgregarNotaPage.this.aceptar();
        }
      };
      botonAceptar.setOnClick(_function_1);
      this._wicketExtensionFactoryMethods.addChild(notaForm, botonVolver);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(notaForm, botonAceptar);
    }
    return _xblockexpression;
  }
  
  public void aceptar() {
    if (this.alta) {
      this.nuevaNota.agregarse();
    }
    this.volver();
  }
  
  public void volver() {
    this.setResponsePage(this.mainPage);
  }
  
  public AgregarNotaPage(final HomePage mainPage, final NuevaNota nuevaNota) {
    this.alta = true;
    this.nuevaNota = nuevaNota;
    Nota _nota = nuevaNota.getNota();
    this.init(mainPage, _nota);
  }
  
  public AgregarNotaPage(final HomePage mainPage, final Nota nota) {
    this.alta = false;
    this.init(mainPage, nota);
  }
}
