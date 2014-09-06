package main;

import applicationModel.NuevaMateria;
import main.HomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;

@SuppressWarnings("all")
public class AgregarMateriaPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private final HomePage mainPage;
  
  private NuevaMateria nuevaMateria;
  
  public AgregarMateriaPage(final HomePage mainPage, final NuevaMateria nuevaMateria) {
    this.mainPage = mainPage;
    this.nuevaMateria = nuevaMateria;
    XButton botonVolver = new XButton("botonVolver");
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        AgregarMateriaPage.this.volver();
      }
    };
    botonVolver.setOnClick(_function);
    XButton botonAceptar = new XButton("botonAceptar");
    final Procedure0 _function_1 = new Procedure0() {
      public void apply() {
        AgregarMateriaPage.this.aceptar();
      }
    };
    botonAceptar.setOnClick(_function_1);
    CompoundPropertyModel<NuevaMateria> _compoundPropertyModel = new CompoundPropertyModel<NuevaMateria>(nuevaMateria);
    Form<NuevaMateria> materiaForm = new Form<NuevaMateria>("materiaForm", _compoundPropertyModel);
    TextField<String> _textField = new TextField<String>("nombre");
    this._wicketExtensionFactoryMethods.addChild(materiaForm, _textField);
    this._wicketExtensionFactoryMethods.addChild(materiaForm, botonVolver);
    this._wicketExtensionFactoryMethods.addChild(materiaForm, botonAceptar);
    this._wicketExtensionFactoryMethods.addChild(this, materiaForm);
  }
  
  public void aceptar() {
    this.nuevaMateria.agregarse();
    this.volver();
  }
  
  public void volver() {
    this.setResponsePage(this.mainPage);
  }
}
