package main

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods

/**
 * 
 * @author ?
 */
class HomePage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods

	new() {

		this.addChild(new Label("prueba", "esto es un texto de prueba"))
		

		
		// TODO Add your page's components here
    }
}
