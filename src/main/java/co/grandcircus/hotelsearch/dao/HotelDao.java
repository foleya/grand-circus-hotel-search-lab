package co.grandcircus.hotelsearch.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.grandcircus.hotelsearch.entity.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Long> {

	@Query("SELECT DISTINCT city FROM Hotel")
	public List<String> findDistinctCities();
	
	List<Hotel> findByCityOrderByPricePerNight(String city);
}
