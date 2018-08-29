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
		return mav;
	}
	
	@PostMapping("/hotel-search")
	public ModelAndView showHotelSearchResults(String city) {
		ModelAndView mav = new ModelAndView("hotel-search");
		mav.addObject("cities", hotelDao.findDistinctCities());
		mav.addObject("hotels", hotelDao.findByCityOrderByPricePerNight(city));
		return mav;
	}
	
}
