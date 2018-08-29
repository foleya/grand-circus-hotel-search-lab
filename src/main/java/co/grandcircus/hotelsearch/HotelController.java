package co.grandcircus.hotelsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.hotelsearch.dao.HotelDao;

@Controller
public class HotelController {

	@Autowired
	private HotelDao hotelDao;
	
	@RequestMapping("/hotel-search")
	public ModelAndView showHotelSearch() {
		ModelAndView mav = new ModelAndView("hotel-search");
		mav.addObject("cities", hotelDao.findDistinctCities());
		mav.addObject("prices", hotelDao.findDistinctPricesPerNight());
		return mav;
	}
	
	@PostMapping("/hotel-search")
	public ModelAndView showHotelSearchResults(String city, Integer price) {
		ModelAndView mav = new ModelAndView("hotel-search");
		mav.addObject("cities", hotelDao.findDistinctCities());
		mav.addObject("prices", hotelDao.findDistinctPricesPerNight());
		
		if (price != null) {
			mav.addObject("hotels", hotelDao.findByCityAndPricePerNightLessThanEqualOrderByPricePerNight(city, price));
		} else {
			mav.addObject("hotels", hotelDao.findByCityOrderByPricePerNight(city));
		}
		
		return mav;
	}
	
}
