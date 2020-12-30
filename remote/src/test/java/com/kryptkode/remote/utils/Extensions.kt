package com.kryptkode.remote.utils

import com.kryptkode.remote.utils.MockDataFactory.getJson
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

fun MockWebServer.mockHttpResponse(fileName: String, responseCode: Int) = enqueue(
        MockResponse()
                .setResponseCode(responseCode)
                .setBody(getJson(fileName))
)
