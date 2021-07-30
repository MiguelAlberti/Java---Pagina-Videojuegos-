package com.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Main", urlPatterns = { "/Main" })
public class MainServlet extends HttpServlet {

	SteamAPI SApi = new SteamAPI();
	RankingScraping RS = new RankingScraping();
	InstantGamingScraping InstantGS = new InstantGamingScraping();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// recojo el año que el usuario ha pasado por parámetro
		String año_busqueda = request.getParameter("opciones");
		// recojo los datos de los juegos del año que indica el usuario
		RS.NombresRanking(año_busqueda);
		// conseguimos los precios de InstantGaming mediante webscraping
		InstantGS.InstantGaming(RS.JRanking);
		// conseguimos los precios de Steam a partir de su API
		SApi.getPrecioSteam(RS.JRanking);

		// Enviamos el año del ranking
		request.setAttribute("ano", año_busqueda);

		// Enviamos los nombres de los juegos
		request.setAttribute("N1", RS.JRanking[0].getNombre_Juego());
		request.setAttribute("N2", RS.JRanking[1].getNombre_Juego());
		request.setAttribute("N3", RS.JRanking[2].getNombre_Juego());
		request.setAttribute("N4", RS.JRanking[3].getNombre_Juego());
		request.setAttribute("N5", RS.JRanking[4].getNombre_Juego());
		request.setAttribute("N6", RS.JRanking[5].getNombre_Juego());
		request.setAttribute("N7", RS.JRanking[6].getNombre_Juego());
		request.setAttribute("N8", RS.JRanking[7].getNombre_Juego());
		request.setAttribute("N9", RS.JRanking[8].getNombre_Juego());
		request.setAttribute("N10", RS.JRanking[9].getNombre_Juego());

		// Enviamos las notas de los juegos
		request.setAttribute("No1", RS.JRanking[0].getNota_Juego());
		request.setAttribute("No2", RS.JRanking[1].getNota_Juego());
		request.setAttribute("No3", RS.JRanking[2].getNota_Juego());
		request.setAttribute("No4", RS.JRanking[3].getNota_Juego());
		request.setAttribute("No5", RS.JRanking[4].getNota_Juego());
		request.setAttribute("No6", RS.JRanking[5].getNota_Juego());
		request.setAttribute("No7", RS.JRanking[6].getNota_Juego());
		request.setAttribute("No8", RS.JRanking[7].getNota_Juego());
		request.setAttribute("No9", RS.JRanking[8].getNota_Juego());
		request.setAttribute("No10", RS.JRanking[9].getNota_Juego());

		// Enviamos los precios de la API de steam
		request.setAttribute("S1", SApi.PrecioSteam[0]);
		request.setAttribute("S2", SApi.PrecioSteam[1]);
		request.setAttribute("S3", SApi.PrecioSteam[2]);
		request.setAttribute("S4", SApi.PrecioSteam[3]);
		request.setAttribute("S5", SApi.PrecioSteam[4]);
		request.setAttribute("S6", SApi.PrecioSteam[5]);
		request.setAttribute("S7", SApi.PrecioSteam[6]);
		request.setAttribute("S8", SApi.PrecioSteam[7]);
		request.setAttribute("S9", SApi.PrecioSteam[8]);
		request.setAttribute("S10", SApi.PrecioSteam[9]);

		// Enviamos los precios de instantGaming
		request.setAttribute("I1", InstantGS.PrecioInstantG[0]);
		request.setAttribute("I2", InstantGS.PrecioInstantG[1]);
		request.setAttribute("I3", InstantGS.PrecioInstantG[2]);
		request.setAttribute("I4", InstantGS.PrecioInstantG[3]);
		request.setAttribute("I5", InstantGS.PrecioInstantG[4]);
		request.setAttribute("I6", InstantGS.PrecioInstantG[5]);
		request.setAttribute("I7", InstantGS.PrecioInstantG[6]);
		request.setAttribute("I8", InstantGS.PrecioInstantG[7]);
		request.setAttribute("I9", InstantGS.PrecioInstantG[8]);
		request.setAttribute("I10", InstantGS.PrecioInstantG[9]);

		//indicamos el destino de todos los datos enviados
		request.getRequestDispatcher("Seleccion.jsp").forward(request, response);

	}

}
