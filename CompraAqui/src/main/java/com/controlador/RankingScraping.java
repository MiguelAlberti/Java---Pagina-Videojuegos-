package com.controlador;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class RankingScraping {
	static RankingScraping[] JRanking = new RankingScraping[10];
	private String Nombre_Juego;
	private String Nota_Juego;

	public RankingScraping() {
		String Nombre_Juego;
		String Nota_Juego;
	}

	//le pasamos por parametro el año del raking que el usuario quiere y posteriormente obtenemos los juegos y la nota 
	public static void NombresRanking(String año) throws IOException {

		Document doc = (Document) getRanking(año);

		for (int i = 1; i < JRanking.length + 1; i++) {
			//seleccionamos el nombre del juego
			Element nombre = doc.select(
					"body > main > div.ct.ct-main > div:nth-child(2) > div > div:nth-child(3) > div > div:nth-child("
							+ i + ") > div.ga-inf > h2 > a")
					.first();
			//seleccionamos la nota
			Element nota = doc.select(
					"body > main > div.ct.ct-main > div:nth-child(2) > div > div:nth-child(3) > div > div:nth-child("
							+ i + ") > div.ga-art > div")
					.first();

			RankingScraping JR = new RankingScraping();
			JR.Nombre_Juego = nombre.html();
			JR.Nota_Juego = nota.html();
			JRanking[i - 1] = JR;
		}

	}

	public static Element getRanking(String año) throws IOException {
		Document doc = null;
		try {
			doc = Jsoup.connect("https://as.com/meristation/plataformas/computadora_personal/top/" + año)
					.userAgent("Mozilla").get();
		} catch (IOException ex) {
			System.out.println("Fallo consiguiendo el html" + ex.getMessage());
		}
		return doc;
	}

	public String getNombre_Juego() {
		return Nombre_Juego;
	}

	public void setNombre_Juego(String nombre_Juego) {
		Nombre_Juego = nombre_Juego;
	}

	public String getNota_Juego() {
		return Nota_Juego;
	}

	public void setNota_Juego(String nota_Juego) {
		Nota_Juego = nota_Juego;
	}
}
