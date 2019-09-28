package io.github.abhishekbhartiprojects.hindi_ted

import com.google.gson.Gson
import io.github.abhishekbhartiprojects.hindi_ted.model.SearchResultResponse
import io.reactivex.Single

class DummyResponse {
    var response: String = "{\n" +
            "  \"success\": true,\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"hindi_word\": \"फूल\",\n" +
            "      \"search_term\": \"फूल, कुसुम, सुमन, ful, kusum, suman, Ful, Kusum, Suman\",\n" +
            "\t  \"dictionary\": \"1. फूल \\n\\n 2. सुमन \\n\\n 3. कुसुम \\n\\n 4. मंजरी \\n\\n 5. प्रसून \\n\\n 6. गुल\",\n" +
            "      \"levels\": [\n" +
            "        {\n" +
            "          \"level\": 1,\n" +
            "          \"word\": \"फूल\",\n" +
            "          \"example\": \"यह फूलों का बाग है \",\n" +
            "          \"word_type\": \"संज्ञा\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"level\": 2,\n" +
            "          \"word\": \"कुसुम\",\n" +
            "          \"example\": \"कुसुम मन को अच्छे लगते हैं \",\n" +
            "          \"word_type\": \"संज्ञा\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"level\": 3,\n" +
            "          \"word\": \"सुमन\",\n" +
            "          \"example\": \"ये खिले हुए सुमन कितने सुन्दर हैं\",\n" +
            "          \"word_type\": \"संज्ञा\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"english_word\": \"Flower\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"hindi_word\": \"भगवान\",\n" +
            "      \"search_term\": \"भगवान, ईश्वर, परमात्मा, Bhagwan, Ishwar, Parmatma\",\n" +
            "\t  \"dictionary\" : \"1.ईश्वर \\n\\n 2. परमात्मा \\n\\n3.प्रभु \\n\\n 4. ईश \\n\\n 5.जगदीश \\n\\n 6.भगवान\\n\\n 7.परमेश्वर \\n\\n 8. जगदीश्वर \\n\\n 9. विधाता\",\n" +
            "      \"levels\": [\n" +
            "        {\n" +
            "          \"level\": 1,\n" +
            "          \"word\": \"भगवान\",\n" +
            "          \"example\": \"भगवान बहुत दयालु है\",\n" +
            "          \"word_type\": \"संज्ञा\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"level\": 2,\n" +
            "          \"word\": \"ईश्वर\",\n" +
            "          \"example\": \"ईश्वर मनोकामना पूरी करता है\",\n" +
            "          \"word_type\": \"संज्ञा\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"level\": 3,\n" +
            "          \"word\": \"परमात्मा\",\n" +
            "          \"example\": \"आत्मा का परमात्मा से मिलन परम-योग कहलाता है\",\n" +
            "          \"word_type\": \"संज्ञा\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"english_word\": \"God\"\n" +
            "    },\n" +
            "\t{\n" +
            "      \"hindi_word\": \"\",\n" +
            "      \"search_term\": \"अग्नि, आग, अनल, Agni, Aag, Anal\",\n" +
            "\t  \"dictionary\" : \"यह हिंदी का संज्ञा-स्त्रीलिंग शब्द है\\n\\n\\n\\n1. जो ताप और प्रकाश देता है\\n\\n 2.अग्नि \\n\\n3. {लाक्षणिक अर्थ} जलन, डाह, संताप\\n\\n4. {लाक्षणिक अर्थ} कामाग्नि, अंतर्दाह\\n\\n5. {मुहावरा} आग-धधकना : असंतोष फैलना\\n\\n6. {मुहावरा} आग-बबूला होना : बहुत गुस्से में होना\\n\\n7. {मुहावरा} आग-लगना : गुस्से से लाल हो जाना\",\n" +
            "      \"levels\": [\n" +
            "        {\n" +
            "          \"level\": 1,\n" +
            "          \"word\": \"आग\",\n" +
            "          \"example\": \"जंगल में आग लग गई है\",\n" +
            "          \"word_type\": \"संज्ञा\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"level\": 2,\n" +
            "          \"word\": \"अग्नि\",\n" +
            "          \"example\": \"हवन में अग्नि तेज है\",\n" +
            "          \"word_type\": \"संज्ञा\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"level\": 3,\n" +
            "          \"word\": \"अनल\",\n" +
            "          \"example\": \"धरती के अस्तित्व में अनल का योगदान है\",\n" +
            "          \"word_type\": \"संज्ञा\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"english_word\": \"Fire\"\n" +
            "    },\n" +
            "\t{\n" +
            "      \"hindi_word\": \"\",\n" +
            "      \"search_term\": \"मेहमान, अतिथि, आगन्तुक, Mehman, Atithi, agantuk\",\n" +
            "\t  \"dictionary\": \"1. मेहमान एक फारसी शब्द है, जो संज्ञा एवं पुल्लिंग है \\n\\n 2. अतिथि\\n\\n 3. मेहमान\\n\\n 4.आगन्तुक\\n\\n 5.पहुना -देशी हिंदी का शब्द है\\n\\n 6.आमंत्रित जन \\n\\n\",\n" +
            "      \"levels\": [\n" +
            "        {\n" +
            "          \"level\": 1,\n" +
            "          \"word\": \"मेहमान\",\n" +
            "          \"example\": \"घर में मेहमान आए हैं\",\n" +
            "          \"word_type\": \"संज्ञा\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"level\": 2,\n" +
            "          \"word\": \"अतिथि\",\n" +
            "          \"example\": \" भारत में अतिथि का स्वागत किया जाता है\",\n" +
            "          \"word_type\": \"संज्ञा\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"level\": 3,\n" +
            "          \"word\": \"आगन्तुक\",\n" +
            "          \"example\": \"कोई भी आगन्तुक भगवान के समान होता है\",\n" +
            "          \"word_type\": \"संज्ञा\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"english_word\": \"Guest\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"message\": \"This is msg\"\n" +
            "}"


    fun getDummyResponse(jsonString: String): Single<SearchResultResponse>{
        val gson = Gson()
        val response = gson.fromJson(jsonString, SearchResultResponse::class.java)
        return Single.just(response)
    }
}