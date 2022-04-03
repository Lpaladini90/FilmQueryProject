package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Film2;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();
	}

	private void test() {
//	
		Film film = db.findFilmById(1);
//    System.out.println(film);
//    System.out.println("");
//    Actor actor = db.findActorById(1);
//    System.out.println(actor);
		List<Actor> actors = db.findActorsByFilmId(1);
		System.out.println(actors);
		System.out.println(film.getCast());
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
				System.out.println("Enter a Film ID(number).");
				int filmId = sc.nextInt();
				Film2 film2 = db.findFilmByIdSpecific(filmId);
				if (film2 != null) {
					System.out.println(film2);
				} else {
					System.out.println("There is no film matching that id try again");
				}

				break;

			case 2:
				System.out.println("Enter a keyword for search.");
				String keyword = sc.next();
				List<Film2> films = db.findFilmByKeyword(keyword);
				if (films != null) {
					for (Film2 filmList : films) {
						System.out.println(filmList.toString());
					}
					
				} else {
					System.out.println("There are no titles descriptions matching ");
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
