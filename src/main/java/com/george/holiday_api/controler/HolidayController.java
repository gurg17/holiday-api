package com.george.holiday_api.controler;

import com.george.holiday_api.model.Holiday;
import com.george.holiday_api.service.HolidayService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/holidays")
public class HolidayController {
    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping("/{countryCode}/last-three")
    public List<Holiday> getLastThreeHolidays(@PathVariable String countryCode) {
        return holidayService.getLastThreeHolidays(countryCode);
    }

    @GetMapping("/count/{year}")
    public List<Long> getPublicHolidaysCount(@PathVariable int year, @RequestParam List<String> countryCodes) {
        return holidayService.getPublicHolidaysCountWithoutWeekends(year, countryCodes);
    }

    @GetMapping("/common/{year}")
    public List<Holiday> getCommonHolidays(@PathVariable int year,
            @RequestParam String countryCode1,
            @RequestParam String countryCode2) {
        return holidayService.getCommonHolidays(year, countryCode1, countryCode2);
    }
}
