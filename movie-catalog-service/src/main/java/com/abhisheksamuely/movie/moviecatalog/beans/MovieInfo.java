package com.abhisheksamuely.movie.moviecatalog.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieInfo {

	private String movieId;
	private String name;
	private String description;
}
