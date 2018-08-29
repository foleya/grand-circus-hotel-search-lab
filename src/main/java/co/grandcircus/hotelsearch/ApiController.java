package co.grandcircus.hotelsearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.grandcircus.hotelsearch.dao.HotelDao;
import co.grandcircus.hotelsearch.entity.Hotel;

@RestController
public class ApiController {

	@Autowired
	private HotelDao hotelDao;
	
	@RequestMapping("/hotels")
	public List<Hotel> listHotels(@RequestParam(value="city", required=false) String city) {
		
		if (city != null && !city.isEmpty()) {
			return hotelDao.findByCityContaining(city);
		}
		
		return hotelDao.findAllByOrderByPricePerNight();
	}
	
	@RequestMapping("/hotels/{id}")
	public Hotel getProduct(@PathVariable("id") Integer id) {
		return hotelDao.findById(id);
	}
}
