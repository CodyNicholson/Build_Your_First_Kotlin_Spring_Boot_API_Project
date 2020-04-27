package com.clairvoyantcoding.iss.impl

import com.clairvoyantcoding.iss.IssTrackerService
import com.clairvoyantcoding.iss.models.GetIssPositionResponse
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestOperations

@Service
class IssTrackerServiceImpl(private val restOperations: RestOperations): IssTrackerService {

    override fun getIssPosition(): GetIssPositionResponse {
        val issPositionResponse = restOperations.exchange("http://api.open-notify.org/iss-now.json",
            HttpMethod.GET,
            null,
            GetIssPositionResponse::class.java).body!!
        print(issPositionResponse)
        return issPositionResponse
    }
}