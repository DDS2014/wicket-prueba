package main

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import domain.Nota
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.markup.html.form.Form

class AgregarNotaPage extends WebPage 

{
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	private final HomePage mainPage

	
	new(HomePage mainPage, Nota nota) 
	{
		this.mainPage = mainPage
		var notaForm = new Form<Nota>("notaForm", new CompoundPropertyModel<Nota>(nota))
		
		this.addChild(notaForm)
		
	}
	
}