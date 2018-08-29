package co.grandcircus.hotelsearch.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.grandcircus.hotelsearch.entity.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Long> {

	//FOR WEBSITE
	@Query("SELECT DISTINCT city FROM Hotel")
	public List<String> findDistinctCities();
	
	@Query("SELECT DISTINCT pricePerNight FROM Hotel ORDER BY pricePerNight")
	public List<Integer> findDistinctPricesPerNight();
	
	List<Hotel> findByCityOrderByPricePerNight(String city);
	
	List<Hotel> findByCityAndPricePerNightLessThanEqualOrderByPricePerNight(String city, Integer price);
	
	//FOR API
	List<Hotel> findAllByOrderByPricePerNight();
	
	Hotel findById(Integer id);
	
	public List<Hotel> findByCityContaining(String city);
}
