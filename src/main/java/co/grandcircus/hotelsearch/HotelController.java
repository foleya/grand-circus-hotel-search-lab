package co.grandcircus.hotelsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	List<Integer> maxPriceOptions = new ArrayList<Integer>(Arrays.asList(50, 100, 150, 200, 250, 300, 350));

	@RequestMapping("/hotel-search")
	public ModelAndView showHotelSearch() {
		ModelAndView mav = new ModelAndView("hotel-search");
		mav.addObject("cities", hotelDao.findDistinctCities());
		mav.addObject("prices", maxPriceOptions);
		return mav;
	}

	@PostMapping("/hotel-search")
	public ModelAndView showHotelSearchResults(String city, Integer maxPrice) {
		ModelAndView mav = new ModelAndView("hotel-search");
		mav.addObject("cities", hotelDao.findDistinctCities());
		mav.addObject("prices", maxPriceOptions);

		if (maxPrice != null) {
			mav.addObject("hotels", hotelDao.findByCityAndPricePerNightLessThanEqualOrderByPricePerNight(city, maxPrice));
		} else {
			mav.addObject("hotels", hotelDao.findByCityOrderByPricePerNight(city));
		}

		return mav;
	}

}
