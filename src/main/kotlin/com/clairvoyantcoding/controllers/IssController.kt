package com.clairvoyantcoding.controllers

import com.clairvoyantcoding.iss.IssTrackerService
import com.clairvoyantcoding.iss.models.GetIssPositionResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/iss")
class IssController(private val issTrackerService: IssTrackerService) {
    @GetMapping("/position")
    @ResponseStatus(HttpStatus.OK)
    fun getIssPosition(): GetIssPositionResponse {
        val issPositionResponse = issTrackerService.getIssPosition()
        print(issPositionResponse.toString())
        return issPositionResponse
    }
}
