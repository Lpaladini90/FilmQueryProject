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
import com.skilldistillery.filmquery.entities.Film;

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
  public Film findFilmById(int filmId) {
		Film film = null;
		
			user = "student";
			password = "student";
			
			try (Connection conn = DriverManager.getConnection(URL, user, password); 
				PreparedStatement stmt= createPreparedStatement(conn,filmId);
				ResultSet rs = stmt.executeQuery();) {
				
				if(rs.next()) {
					film = new Film();
					film.setId(rs.getInt(filmId));
					film.setTitle(rs.getString("title"));
					film.setDescription(rs.getString("description"));
					film.setReleaseYear(rs.getInt("release_year"));
					film.setLanguageId(rs.getInt("language_id"));
					film.setRentalDuration(rs.getInt("rental_duration"));
					film.setRentalRate(rs.getDouble("rental_rate"));
					film.setLength(rs.getInt("length"));
					film.setReplacementCost(rs.getDouble("replacement_cost"));
					film.setRating(rs.getString("rating"));
					film.setSpecialFeatures(rs.getString("special_features"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
			
		return film;
  }

	private PreparedStatement createPreparedStatement(Connection conn2, int actorId) throws SQLException {
		sqltxt = "SELECT * FROM actor WHERE id = ?";
		PreparedStatement stmt = conn2.prepareStatement(sqltxt);
		stmt.setInt(1, actorId );
		return stmt;

	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		
		user = "student";
		password = "student";
		
		try (Connection conn = DriverManager.getConnection(URL, user, password); 
			PreparedStatement stmt= createPreparedStatement2(conn,actorId);
			ResultSet rs = stmt.executeQuery();) {
			
			if(rs.next()) {
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
	stmt.setInt(1, actorId );
	return stmt;

}

@Override
public List<Actor>findActorsByFilmId(int filmId) {
	List<Actor> actorList = null;
	user = "student";
	password = "student";
	sqltxt = "SELECT film.id, actor.id, actor.first_name, actor.last_name "
			+ "FROM actor "
			+ "JOIN film_actor "
			+ "ON actor.id = film_actor.actor_id "
			+ "JOIN film "
			+ "ON film.id = film_actor.film_id"
			+ "WHERE film.id = ?";
	try {
		conn = DriverManager.getConnection(URL, user, password); 
		PreparedStatement stmt= conn.prepareStatement(sqltxt);
		stmt.setInt(1, filmId );
			rs = stmt.executeQuery(); 
		 
		if(rs.next()) {
			actorList = new ArrayList<>();
			actorList.add(rs.getInt("film.id"));
			
			
		}
	}
	 catch (SQLException e) {
		e.printStackTrace();
	}
	 
	
return actorList;
}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
//		sqltxt = "SELECT film.id 'Film ID', actor.id 'Actor Id', actor.first_name, actor.last_name";
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
