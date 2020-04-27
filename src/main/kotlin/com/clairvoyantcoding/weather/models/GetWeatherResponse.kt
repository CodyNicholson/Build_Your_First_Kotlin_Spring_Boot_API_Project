package com.clairvoyantcoding.weather.models

data class GetWeatherResponse(val coord: Coord = Coord(0.0, 0.0),
                              val weathers: List<Weather> = listOf(),
                              val base: String = "",
                              val main: Main = Main(0.0, 0.0, 0.0, 0.0, 0, 0),
                              val visibility: String = "",
                              val wind: Wind = Wind(0.0, 0, 0.0),
                              val clouds: Clouds = Clouds(0),
                              val dt: Long = 0,
                              val sys: Sys = Sys(0, 0, "", 0, 0),
                              val timezone: Int = 0,
                              val id: Int = 0,
                              val name: String = "",
                              val cod: Int = 0)