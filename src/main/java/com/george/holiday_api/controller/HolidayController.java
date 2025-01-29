package com.george.holiday_api.controller;

import com.george.holiday_api.model.Holiday;
import com.george.holiday_api.service.HolidayService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    public List<Map<String, String>> getLastThreeHolidays(@PathVariable String countryCode) {
        return holidayService.getLastThreeHolidays(countryCode);
    }

    @GetMapping("/{year}/public-holidays-count")
    public Map<String, Long> getPublicHolidaysCount(@PathVariable int year, @RequestParam List<String> countryCodes) {
        return holidayService.getPublicHolidaysCountWithoutWeekends(year, countryCodes);
    }

    @GetMapping("/{year}/common-holidays")
    public List<Map<String, String>> getCommonHolidays(@PathVariable int year,
            @RequestParam String countryCode1,
            @RequestParam String countryCode2) {
        return holidayService.getCommonHolidays(year, countryCode1, countryCode2);
    }
}
