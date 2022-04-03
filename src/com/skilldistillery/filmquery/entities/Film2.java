package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film2 {

	private int filmId;
	private String title;
	private int releaseYear;
	private String rating;
	private String description;
	private String language;
	private List<Actor> cast;
	private List<Film2> films;
	private Actor actor;

	public Film2() {
		super();
	}

	public Film2(int filmId, String title, int releaseYear, String rating, String description, String language,
			List<Actor> cast, List<Film2> films, Actor actor) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.description = description;
		this.language = language;
		this.cast = cast;
		this.films = films;
		this.actor = actor;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public List<Film2> getFilms() {
		return films;
	}

	public void setFilms(List<Film2> films) {
		this.films = films;
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

	@Override
	public int hashCode() {
		return Objects.hash(actor, cast, description, filmId, films, language, rating, releaseYear, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film2 other = (Film2) obj;
		return Objects.equals(actor, other.actor) && Objects.equals(cast, other.cast)
				&& Objects.equals(description, other.description) && filmId == other.filmId
				&& Objects.equals(films, other.films) && Objects.equals(language, other.language)
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& Objects.equals(title, other.title);
	}

}
