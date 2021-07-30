package com.controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SteamAPI {

	static String[] PrecioSteam = new String[10];

	// ------------------------------------------------------------------------------------------
	// En este método realizaremos un bucle for para a partir de los 10 juegos
	// encontrar su precio
	public static void getPrecioSteam(RankingScraping JRanking[]) throws IOException {
		String Precio;
		for (int i = 0; i < JRanking.length; i++) {
			String steamId = getIdSteam(JRanking[i].getNombre_Juego());
			//si en el método anterior no hemos obtenido el id quiere decir que steam no tiene el juego 
			if (steamId.length() != 6) {
				Precio = "No disponible";
			} else {
				Precio = setSteamGameInfo(steamId);

			}
			PrecioSteam[i] = Precio;
		}
	}

	// ------------------------------------------------------------------------------------------
	// a partir del nombre del juego conseguimos el ID de steam
	public static String getIdSteam(String NombreJuego) throws IOException {
		String steamID;
		Document doc = (Document) getSteamResults(NombreJuego);
		steamID = setSteamID(doc.html());
		return steamID;

	}

	// ------------------------------------------------------------------------------------------
	// a partir del html del juego conseguimos el ID de steam
	private static String setSteamID(String html) {

		String steamID = "";
		String claveSteamID = "data-ds-appid=\"";
		int index = html.indexOf(claveSteamID);
		index += claveSteamID.length();

		while (html.charAt(index) != '"') {
			steamID += html.charAt(index);
			index++;
		}
		return steamID;
	}

	// ------------------------------------------------------------------------------------------
	// conseguimos el html del juego que se indique por parámetro
	static Element getSteamResults(String NombreJuego) throws IOException {
		Document doc = null;
		try {
			doc = Jsoup.connect("https://store.steampowered.com/search/?term=" + NombreJuego + "/").userAgent("Mozilla")
					.get();
		} catch (IOException ex) {
			System.out.println("Fallo consiguiendo el html" + ex.getMessage());
		}
		return doc;

	}

	// ------------------------------------------------------------------------------------------
	// Recibe como parametro el id de Steam de un juego y accediendo a la api se
	// consigue la información

	public static String setSteamGameInfo(String steamID) throws IOException {
		String s = null;
		// Crear peticion a la API de steam
		URL url = new URL("https://store.steampowered.com/api/appdetails?appids=" + steamID + "&cc=es&l=spanish");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// Recibir respuesta
		InputStreamReader input = new InputStreamReader(con.getInputStream(), "UTF-8");
		BufferedReader in = new BufferedReader(input);

		// Ponemos toda la información procedente de la APi dentro de un string
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			s += inputLine;
		}
		String preciosteam = SacarPrecio(s);
		return preciosteam;
	}

	// ------------------------------------------------------------------------------------------
	// Se calcula el precio del juego en Steam
	private static String SacarPrecio(String s) {
		String precioSteam = " ";
		String clave = "\"final\":";
		int index = s.indexOf(clave);

		if (index == -1) {
			precioSteam = "Gratis";
		} else {

			// Precio
			index += clave.length();
			while (s.charAt(index) != ',') {
				precioSteam += s.charAt(index);
				index++;
			}

			int indexEnt = precioSteam.length() - 2;
			precioSteam = precioSteam.substring(0, indexEnt) + "."
					+ precioSteam.substring(indexEnt, precioSteam.length());

		}
		return precioSteam;
	}

}
