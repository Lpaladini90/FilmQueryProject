package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Test;
import com.skilldistillery.filmquery.entities.Film2;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	private String user;
	private String password;
	ResultSet rs;
	Connection conn;
	String sqltxt;
	Scanner sc;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Driver not found");
			throw new RuntimeException("Can't load driver class!");

		}
	}

	@Override
	public Test findFilmById(int filmId) {
		Test test = null;

		user = "student";
		password = "student";

		try (Connection conn = DriverManager.getConnection(URL, user, password);
				PreparedStatement stmt = createPreparedStatement(conn, filmId);
				ResultSet rs = stmt.executeQuery();) {

			if (rs.next()) {
				test = new Test();
				test.setId(rs.getInt(filmId));
				test.setTitle(rs.getString("title"));
				test.setDescription(rs.getString("description"));
				test.setReleaseYear(rs.getInt("release_year"));
				test.setLanguageId(rs.getInt("language_id"));
				test.setRentalDuration(rs.getInt("rental_duration"));
				test.setRentalRate(rs.getDouble("rental_rate"));
				test.setLength(rs.getInt("length"));
				test.setReplacementCost(rs.getDouble("replacement_cost"));
				test.setRating(rs.getString("rating"));
				test.setSpecialFeatures(rs.getString("special_features"));
				test.setCast(findActorsByFilmId(filmId));

			} else if (!rs.next()) {
				System.out.println("There is no film under that ID number");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return test;
	}

	private PreparedStatement createPreparedStatement(Connection conn2, int filmId) throws SQLException {
		sqltxt = "SELECT * FROM film WHERE id = ?";
		PreparedStatement stmt = conn2.prepareStatement(sqltxt);
		stmt.setInt(1, filmId);
		return stmt;

	}

	public Film2 findFilmByIdSpecific(int filmId) {
		Film2 film2 = null;

		user = "student";
		password = "student";

		try (Connection conn = DriverManager.getConnection(URL, user, password);
				PreparedStatement stmt = createPreparedStatement3(conn, filmId);
				ResultSet rs = stmt.executeQuery();) {

			if (rs.next()) {
				film2 = new Film2();
				film2.setTitle(rs.getString("title"));
				film2.setReleaseYear(rs.getInt("release_year"));
				film2.setRating(rs.getString("rating"));
				film2.setDescription(rs.getString("description"));
				film2.setLanguage(rs.getString("language.name"));
				film2.setCast(findActorsByFilmId(filmId));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film2;
	}

	private PreparedStatement createPreparedStatement3(Connection conn3, int filmId) throws SQLException {
		sqltxt = " SELECT title, release_year,rating,description, language.name " + " FROM film " + " JOIN language "
				+ " ON film.language_id = language.id " + " WHERE film.id = ? ";
		PreparedStatement stmt = conn3.prepareStatement(sqltxt);
		stmt.setInt(1, filmId);
		return stmt;

	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;

		user = "student";
		password = "student";

		try (Connection conn = DriverManager.getConnection(URL, user, password);
				PreparedStatement stmt = createPreparedStatement2(conn, actorId);
				ResultSet rs = stmt.executeQuery();) {

			if (rs.next()) {
				actor = new Actor();
				actor.setId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actor;
	}

	private PreparedStatement createPreparedStatement2(Connection conn2, int actorId) throws SQLException {
		sqltxt = "SELECT * FROM actor WHERE id = ?";
		PreparedStatement stmt = conn2.prepareStatement(sqltxt);
		stmt.setInt(1, actorId);
		return stmt;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		Actor actor;

		user = "student";
		password = "student";
		sqltxt = "SELECT actor.id 'Actor ID', actor.first_name, actor.last_name " + "FROM actor " + "JOIN film_actor "
				+ "ON actor.id = film_actor.actor_id " + "WHERE film_actor.film_id = ? ";
		try {
			conn = DriverManager.getConnection(URL, user, password);
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, filmId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				actor = new Actor();
				actor.setId(rs.getInt("Actor ID"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));

				actors.add(actor);

			}
			rs.close();
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actors;
	}

	@Override
	public List<Film2> findFilmByKeyword(String keyword) {
		List<Film2> films = new ArrayList<>();
		Film2 film;

		user = "student";
		password = "student";

		PreparedStatement stmt;
		ResultSet rs;

		try {
			conn = DriverManager.getConnection(URL, user, password);

			String sqltxt = "SELECT title, description, release_year, rating "
					+ " FROM film "
					+ " WHERE title like ? or description like ? ";
			System.out.println(sqltxt);
			stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1,"%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			rs = stmt.executeQuery();
			
			while (rs.next()) {

				film = new Film2();
				film.setTitle(rs.getString("title"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setRating(rs.getString("rating"));
				film.setDescription(rs.getString("description"));
				

				films.add(film);

			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

//@Override
//public List<Film2> getFilmByKeyword(String keyword) {
//	
//		
//		List<Film2> films = new ArrayList<>();
//		Film2 film = null;
//		Actor actor = null;
//		user = "student";
//		password = "student";
//		

//		
//		Connection conn = DriverManager.getConnection(URL, user, password);
//		PreparedStatement stmt = conn.prepareStatement(sql);
//		
//		ResultSet rs = stmt.executeQuery();
//		while(rs.next()) {
//			film = new Film2();
////			film2.setFilmId(rs.getString("id"));
//	        film.setTitle(rs.getString("title"));
//	        film.setDescription(rs.getString("description"));
//	        film.setRating(rs.getString("rating"));
////	        film2.setCast(findActorsByFilmId(filmId));
//	        
//	       
//		}
//		
//		rs.close();
//		stmt.close();
//		conn.close();
//		return films;
//
//}

//	@Override
//	public Actor findActorById(int actorId) {
//		if(actorId > 0) {
//			user = "student";
//			password = "student";
//		
//	    PreparedStatement stmt;
//		ResultSet rs;
//		
//		try {
//			conn = DriverManager.getConnection(URL, user, password);
//
//			sqltxt = "SELECT id, first_name, last_name FROM actor WHERE actor_id = ?";
//			stmt = conn.prepareStatement(sqltxt);
//			stmt.setInt(1, actorId);
//			rs = stmt.executeQuery();
//			while (rs.next()) {
//			  System.out.println(rs.getString("id") + " " +
//			      rs.getString("first_name") + " " +
//			      rs.getString("last_name"));
//			}
//			rs.close();
//		    stmt.close();
//		    conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    
//		}
//	  
//		return null;
//	}
//
//	@Override
//	public List<Actor> findActorsByFilmId(int filmId) {
//		user= "student";
//		password = "student";
//		List<Actor> actorIdByFilm = new ArrayList<>();
//		
//		conn = DriverManager.getConnection(URL,user,password);
//		sqltxt = "SELECT film.id 'Test ID', actor.id 'Actor Id', actor.first_name, actor.last_name";
//		PreparedStatement stmt = conn.prepareStatement(sqltxt);
//		rs = stmt.executeQuery();
//		while(rs.next()) {
//			actorIdByFilm.add(rs.getString());
//			return actorIdByFilm;
//		}
//		
//		
//		return null;
//	}

}
