package com.clairvoyantcoding.iss

import com.clairvoyantcoding.iss.models.GetIssPositionResponse

interface IssTrackerService {
    fun getIssPosition(): GetIssPositionResponse
}