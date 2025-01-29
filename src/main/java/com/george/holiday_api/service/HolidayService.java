package com.george.holiday_api.service;

import com.george.holiday_api.model.Holiday;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

@Service
public class HolidayService {

    private static final String API_URL = "https://date.nager.at/api/v3/PublicHolidays/{year}/{countryCode}";
    private final RestTemplate restTemplate;

    // * Constructor
    public HolidayService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private List<Holiday> fetchHolidaysForYear(int year, String countryCode) {
        return List.of();
    }

    private boolean isWeekend(LocalDate date) {
        return false;
    }

    public List<Holiday> getLastThreeHolidays(String countryCode) {
        return List.of();
    }

    public List<Long> getPublicHolidaysCountWithoutWeekends(int year, List<String> countryCodes) {
        return List.of();
    }

    public List<Holiday> getCommonHolidays(int year, String countryCode1, String countryCode2) {
        return List.of();
    }
}
