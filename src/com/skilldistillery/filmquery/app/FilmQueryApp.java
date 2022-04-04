package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();

		app.launch();
	}

	private void launch() {
		Scanner sc = new Scanner(System.in);

		startUserInterface(sc);

		sc.close();
	}

	private void startUserInterface(Scanner sc) {

		System.out.println("----------------------------------------");
		System.out.println("-Choose from the following menu options-");
		System.out.println("----------------------------------------");
		boolean menu = true;

		while (menu) {
			System.out.println("\n\n----------------------------------------");
			System.out.println("- 1. Look up a film by ID              -");
			System.out.println("- 2. Look up a film by keyword search  -");
			System.out.println("- 3. Exit                              -");
			System.out.println("----------------------------------------");

			int userInput = sc.nextInt();

			switch (userInput) {
			case 1:
				System.out.println("Enter a Test ID(number).");
				int filmId = sc.nextInt();
				Film film = db.findFilmById(filmId);
				if (film != null) {
					System.out.println(film.toString());
				} else {
					System.out.println("There is no film matching that id try again");
				}

				break;

			case 2:
				System.out.println("Enter a keyword for search.");
				String keyword = sc.next();
				film = new Film();
				List<Film> films = db.findFilmByKeyword(keyword);

				for (Film film2 : films) {

					System.out.println(film2.toString2());

				}

				break;

			case 3:
				System.out.println("Good-bye.");
				menu = false;
				break;

			default:
				System.out.println("That is not a valid choice please try again");
				break;
			}

		}

	}

}
