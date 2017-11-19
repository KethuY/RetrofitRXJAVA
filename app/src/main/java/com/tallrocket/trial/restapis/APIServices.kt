package com.tallrocket.trial.restapis


import com.tallrocket.trial.models.Comment

import io.reactivex.Observable
import retrofit2.http.GET

interface APIServices {
    @GET(APIConstants.GET_COMMENTS)
    fun getComments(): Observable<List<Comment>>
}
