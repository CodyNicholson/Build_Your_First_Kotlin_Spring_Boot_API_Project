package com.clairvoyantcoding.controllers

import com.clairvoyantcoding.weather.WeatherService
import com.clairvoyantcoding.weather.models.GetWeatherResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/weather")
class WeatherController(private val weatherService: WeatherService) {
    @GetMapping("/city")
    @ResponseStatus(HttpStatus.OK)
    fun getWeatherByCity(): GetWeatherResponse {
        val r = weatherService.getWeatherDataByCity("Chicago")
        print(r.toString())
        return r
    }

    @GetMapping("/coords")
    @ResponseStatus(HttpStatus.OK)
    fun getWeatherByCoords(): GetWeatherResponse {
        val r = weatherService.getWeatherDataByCoords("14.598169", "120.983686")
        print(r.toString())
        return r
    }
}
