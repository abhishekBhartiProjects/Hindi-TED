package io.github.abhishekbhartiprojects.hindi_ted

import com.google.gson.Gson
import io.github.abhishekbhartiprojects.hindi_ted.model.SearchResultResponse
import io.reactivex.Single

class DummyResponse {
    var response: String = "{\n" +
            "  \"success\": true,\n" +
            "  \"data\": {\n" +
            "    \"hindi_word\": \"Phool\",\n" +
            "    \"levels\": [\n" +
            "      {\n" +
            "        \"level\": 1,\n" +
            "        \"word\": \"Phool\",\n" +
            "        \"example\": \"Yeh PHOOL ka baag hai\",\n" +
            "        \"word_type\": \"noun\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"level\": 2,\n" +
            "        \"word\": \"Kusum\",\n" +
            "        \"example\": \"KUSUM man ko ramniye lagte hai\",\n" +
            "        \"word_type\": \"noun\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"level\": 3,\n" +
            "        \"word\": \"Suman\",\n" +
            "        \"example\": \"Suman ki mahak se baag sundar hai\",\n" +
            "        \"word_type\": \"noun\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"english_word\": \"Flower\"\n" +
            "  },\n" +
            "  \"message\": \"This is msg\"\n" +
            "}"


    fun getDummyResponse(jsonString: String): Single<SearchResultResponse>{
        var gson = Gson()
        var response = gson.fromJson(jsonString, SearchResultResponse::class.java)
        return Single.just(response)
    }
}