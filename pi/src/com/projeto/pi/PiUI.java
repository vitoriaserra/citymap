package com.projeto.pi;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapInfoWindow;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PiUI extends UI {
	private GoogleMap map;

	private GoogleMapMarker marcador = new GoogleMapMarker("Marcador x",
			new LatLon(-1.4570767729152327, -48.48618817773445), true, null);

	private GoogleMapInfoWindow infomarcadorwindow = new GoogleMapInfoWindow(
			"Teste de informações de mapa", marcador);

	private final String apiKey = "";

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = PiUI.class, widgetset = "com.projeto.pi.widgetset.PiWidgetset")
	public static class Servlet extends VaadinServlet {

	}

	@Override
	protected void init(VaadinRequest request) {
		HorizontalLayout content = new HorizontalLayout();
		content.setSizeFull();
		setContent(content);
		                                                                                                                                                                                 
		Panel panelui = new Panel();
		panelui.setHeight("500px");
		panelui.setWidth("900px"); 
		
		map = new GoogleMap(new LatLon(-1.4570767729152327, -48.48618817773445), 10.0, apiKey);
	     map.setSizeFull();
	          
	     marcador.setAnimationEnabled(false);
	     
	     map.addMarker(marcador);
	     map.setMinZoom(4.0);
	     map.setMaxZoom(16.0);
	    
	     infomarcadorwindow.setWidth("10px");
	     infomarcadorwindow.setHeight("400px");
	     
	    
		Label a = new Label("<fieldset ><legend style='color:white; background-color: #1E90FF;" +
				"'>Dados Preliminares Sobre o sistema:</legend>" +
				"<hr>Sistema de Mapeamento Interativo de Imóveis" +
				"<hr>EQUIPE:<hr>EVERTON MENDONÇA<hr>VITÓRIA SERRA<hr>FABIO ALBUQUERQUE<p><p><p><p><p><p><p><p>" +
					"</fieldset>",
					Label.CONTENT_XHTML);
		
		
	content.addComponent(a);
	panelui.setContent(map);

		 content.addComponent(panelui);

	      
	        
	        
	}

}