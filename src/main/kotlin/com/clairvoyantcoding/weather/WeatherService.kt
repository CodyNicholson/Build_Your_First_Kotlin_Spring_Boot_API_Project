package com.clairvoyantcoding.weather

import com.sun.net.httpserver.Headers
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpMethod
import org.springframework.retry.policy.SimpleRetryPolicy
import org.springframework.retry.support.RetryTemplate
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpServerErrorException.ServiceUnavailable
import org.springframework.web.client.RestOperations

@Service
class WeatherService(
    private val restOperations: RestOperations,
    @Value("\${weather.apikey}") private val apikey: String
) {

    private final val retryTemplate = RetryTemplate()

    init {
        val exceptionMap = hashMapOf<Class<out Throwable>, Boolean>(ServiceUnavailable::class.java to java.lang.Boolean.TRUE)
        val retryPolicy = SimpleRetryPolicy(2, exceptionMap)
        retryTemplate.setRetryPolicy(retryPolicy)
    }

    fun getWeatherDataByCity(city: String) {
        val weather = restOperations.exchange("http://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apikey",
            HttpMethod.GET,
            null,
            Any::class.java)
        print(weather)
    }
}

//        val weather = restOperations.exchange("https://pokeapi.co/api/v2/pokemon/1",
//            HttpMethod.GET,
//            null,
//            Any::class.java)
