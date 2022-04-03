package com.skilldistillery.filmquery.database;

import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Test;
import com.skilldistillery.filmquery.entities.Film2;

public interface DatabaseAccessor {
	public Test findFilmById(int filmId);

	public Film2 findFilmByIdSpecific(int filmdId);

	public Actor findActorById(int actorId);

	public List<Actor> findActorsByFilmId(int filmId);

	public List<Film2> findFilmByKeyword(String keyword);
//
}
