package com.clairvoyantcoding.iss.models

data class GetIssPositionResponse(val timestamp: Long, val message: String, val iss_position: IssPosition)