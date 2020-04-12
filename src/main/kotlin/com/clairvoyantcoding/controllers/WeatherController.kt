package com.clairvoyantcoding.controllers

import com.clairvoyantcoding.weather.WeatherService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/weather")
class WeatherController(private val weatherService: WeatherService) {
    @GetMapping("/bycity")
    @ResponseStatus(HttpStatus.OK)
    fun getWeatherByCity() {
        val r = weatherService.getWeatherDataByCity("Chicago")
        print(r.toString())
    }
}