package com.clairvoyantcoding.weather.impl

import com.clairvoyantcoding.weather.WeatherService
import com.clairvoyantcoding.weather.models.GetWeatherResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpMethod
import org.springframework.retry.policy.SimpleRetryPolicy
import org.springframework.retry.support.RetryTemplate
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpServerErrorException.ServiceUnavailable
import org.springframework.web.client.RestOperations

@Service
class WeatherServiceImpl(
    private val restOperations: RestOperations,
    @Value("\${weather.apikey}") private val apikey: String
): WeatherService {

    override fun getWeatherDataByCity(city: String): GetWeatherResponse {
        val weather = restOperations.exchange("http://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apikey",
            HttpMethod.GET,
            null,
            GetWeatherResponse::class.java).body!!
        print(weather)
        return weather
    }

    override fun getWeatherDataByCoords(lat: String, lon: String): GetWeatherResponse {
        val weather = restOperations.exchange("http://api.openweathermap.org/data/2.5/weather?lat=$lat&lon=$lon&appid=$apikey",
            HttpMethod.GET,
            null,
            GetWeatherResponse::class.java).body!!
        print(weather)
        return weather
    }
}


//        val weather = restOperations.exchange("https://pokeapi.co/api/v2/pokemon/1",
//            HttpMethod.GET,
//            null,
//            Any::class.java)
