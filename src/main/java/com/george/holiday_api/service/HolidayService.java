package com.george.holiday_api.service;

import com.george.holiday_api.model.Holiday;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class HolidayService {

    private static final String API_URL = "https://date.nager.at/api/v3/PublicHolidays/{year}/{countryCode}";
    private final RestTemplate restTemplate;

    private List<Holiday> fetchHolidaysForYear(int year, String countryCode) {
        String url = API_URL.replace("{year}", String.valueOf(year)).replace("{countryCode}", countryCode);
        Holiday[] holidays = restTemplate.getForObject(url, Holiday[].class);
        return holidays != null ? Arrays.asList(holidays) : Collections.emptyList();
    }

    private boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7;
    }

    // * Constructor
    public HolidayService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Map<String, String>> getLastThreeHolidays(String countryCode) {
        int currentYear = LocalDate.now().getYear();
        int lastYear = currentYear - 1;

        List<Holiday> holidaysThisYear = new ArrayList<>(fetchHolidaysForYear(currentYear, countryCode));
        List<Holiday> holidaysLastYear = new ArrayList<>(fetchHolidaysForYear(lastYear, countryCode));

        holidaysThisYear.addAll(holidaysLastYear);

        return holidaysThisYear.stream()
                .filter(holiday -> holiday.getDate().isBefore(LocalDate.now()))
                .sorted(Comparator.comparing(Holiday::getDate).reversed())
                .limit(3)
                .map(holiday -> {
                    Map<String, String> holidayMap = new HashMap<>();
                    holidayMap.put("name", holiday.getName());
                    holidayMap.put("date", holiday.getDate().toString());
                    return holidayMap;
                })
                .collect(Collectors.toList());
    }

    public Map<String, Long> getPublicHolidaysCountWithoutWeekends(int year, List<String> countryCodes) {
        Map<String, Long> holidayCounts = new HashMap<>();

        for (String countryCode : countryCodes) {
            List<Holiday> holidays = fetchHolidaysForYear(year, countryCode);
            long count = holidays.stream()
                    .filter(holiday -> !isWeekend(holiday.getDate()))
                    .count();
            holidayCounts.put(countryCode, count);
        }

        return holidayCounts;
    }

    public List<Map<String, String>> getCommonHolidays(int year, String countryCode1, String countryCode2) {
        List<Holiday> holidaysCountry1 = fetchHolidaysForYear(year, countryCode1);
        List<Holiday> holidaysCountry2 = fetchHolidaysForYear(year, countryCode2);

        Map<LocalDate, Holiday> holidayMapCountry1 = holidaysCountry1.stream()
                .collect(Collectors.toMap(Holiday::getDate, holiday -> holiday));

        return holidaysCountry2.stream()
                .filter(holiday -> holidayMapCountry1.containsKey(holiday.getDate()))
                .map(holiday -> {
                    Map<String, String> commonHolidayMap = new HashMap<>();
                    LocalDate date = holiday.getDate();
                    commonHolidayMap.put("date", date.toString());
                    commonHolidayMap.put("name", holiday.getName());
                    commonHolidayMap.put("localName-" + countryCode1, holidayMapCountry1.get(date).getLocalName());
                    commonHolidayMap.put("localName-" + countryCode2, holiday.getLocalName());
                    return commonHolidayMap;
                })
                .collect(Collectors.toList());
    }
}
