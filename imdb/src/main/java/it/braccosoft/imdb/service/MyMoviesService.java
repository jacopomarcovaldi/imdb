package it.braccosoft.imdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import it.braccosoft.imdb.bean.MyMovies;

@Component
public class MyMoviesService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<MyMovies> findAll() {
		return jdbcTemplate.query(
				"SELECT * FROM "+MyMovies.TABLE_NAME,
				(rs, rowNum) -> new MyMovies(rs.getInt(MyMovies.ID_COLUMN),
						rs.getString(MyMovies.TITLE_COLUMN), rs.getString(MyMovies.IMDB_LINK_COLUMN),
						rs.getString(MyMovies.COVER_LINK_COLUMN), rs.getDate(MyMovies.DATE_COLUMN)));
	}
//	public void update(Customer customer) {
//		jdbcTemplate.update(
//				"UPDATE customers SET first_name=?, last_name=? WHERE id=?",
//				customer.getFirstName(), customer.getLastName(), customer.getId());
//	}

}
