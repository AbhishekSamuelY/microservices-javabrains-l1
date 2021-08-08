package com.abhisheksamuely.movie.moviecatalog.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public @Data class MovieCatalog {

	private String name;
	private String description;
	private double rating;
}
