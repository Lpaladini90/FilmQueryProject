package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {

	private int id;
	private String title;
	private int releaseYear;
	private String rating;
	private String description;
	private String language;
	private List<Actor> cast;
	private List<Film> films;
	

	public Film() {
		super();
	}



	public Film(int id, String title, int releaseYear, String rating, String description, String language) {
		super();
		this.id = id;
		this.title = title;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.description = description;
		this.language = language;
		
	}



	public List<Film> getFilms() {
		return films;
	}



	public void setFilms(List<Film> films) {
		this.films = films;
	}



	public int getId() {
		return id;
	}

	public void setId(int filmId) {
		this.id = filmId;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Actor> getCast() {
		return cast;
	}

	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}

	@Override
	public String toString() {
		String output = "\n\nFilm: \n\nTitle: " + title + "\n\nRelease Year: " + releaseYear + "\n\nFilm Rting: "
				+ rating + "\n\nDescription: " + description + "\n\nLanguage: " + language + "\n\nFilm Cast: "
				+ getCast();

		return output;

	}
	
	public String toString2() {
		String output = "\n\nFilm: \n\nTitle: " + title + "\n\nRelease Year: " + releaseYear + "\n\nFilm Rting: "
				+ rating + "\n\nDescription: " + description + "\n\nLanguage: " + language;
		return output;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cast, description, films, id, language, rating, releaseYear, title);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(cast, other.cast) && Objects.equals(description, other.description)
				&& Objects.equals(films, other.films) && id == other.id && Objects.equals(language, other.language)
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& Objects.equals(title, other.title);
	}


}
