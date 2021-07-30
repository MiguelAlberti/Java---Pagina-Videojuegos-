package com.controlador;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class InstantGamingScraping {

	static String[] PrecioInstantG = new String[10];

	// ------------------------------------------------------------------------------------------
	// método que con el html bajado seleciona el precio de X juego
	public void InstantGaming(RankingScraping JRanking[]) throws IOException {

		for (int i = 0; i < JRanking.length; i++) {
			Document doc = (Document) getInstantGaming(JRanking[i].getNombre_Juego());
			Element precio = doc.select("div[class=price]").first();
			String Precio = precio.html();

			if (Precio == null) {
				Precio = "Precio no encontrado ";
			}
			StringBuffer cadena = new StringBuffer();
			char[] aCaracteres = Precio.toCharArray();
			//eliminamos los simbolos que cogemos al seleccionar el juego
			for (int x = 0; x < aCaracteres.length; x++) {
				if (aCaracteres[x] == '€' || aCaracteres[x] == '$') {
					aCaracteres[x] = ' ';
				}
				cadena = cadena.append(aCaracteres[x]);

			}
			Precio = cadena.toString();
			PrecioInstantG[i] = Precio;
		}

	}

	// ------------------------------------------------------------------------------------------
	// método que gracias al nombre del juego descarga el html de la página de
	// instantgaming
	public Element getInstantGaming(String NombreJuego) throws IOException {
		Document doc = null;
		try {
			doc = Jsoup.connect("https://www.instant-gaming.com/es/busquedas/?q=" + NombreJuego).userAgent("Mozilla")
					.get();
		} catch (IOException ex) {
			System.out.println("Fallo consiguiendo el html" + ex.getMessage());
		}
		return doc;
	}

}
