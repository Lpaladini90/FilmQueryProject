package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
    app.test();
//    app.launch();
  }

  private void test() {
	
    Film film = db.findFilmById(1);
    System.out.println(film);
//    System.out.println("");
//    Actor actor = db.findActorById(1);
//    System.out.println(actor);
//    List<Actor> actors = db.findActorsByFilmId(1);
//    System.out.println(actors);
    System.out.println(film.getActors());
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
    
  }

}
