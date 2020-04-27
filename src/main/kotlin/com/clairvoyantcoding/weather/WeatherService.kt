package com.clairvoyantcoding.weather

import com.clairvoyantcoding.weather.models.GetWeatherResponse

interface WeatherService {
    fun getWeatherDataByCity(city: String): GetWeatherResponse
    fun getWeatherDataByCoords(lat: String, lon: String): GetWeatherResponse
}
