package com.studyMate.controller.user

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.springframework.stereotype.Service
import java.io.*
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

@Service
class KakaoLoginService {

    fun getAccessToken(authorizeCode: String, redirectName:String): String {
        var accessToken = ""
        var refreshToken = ""
        val requestURL = "https://kauth.kakao.com/oauth/token"

        try {
            val url = URL(requestURL)
            var connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "POST"
            connection.doOutput = true

            val bw = BufferedWriter(OutputStreamWriter(connection.outputStream))

            var sb = StringBuilder("grant_type=authorization_code&client_id=d8a07bcf4f4992d4a841f569e9e68f57&redirect_uri=http://localhost:3000/$redirectName&code=$authorizeCode")
            bw.write(sb.toString())
            bw.flush()

            val br = BufferedReader(InputStreamReader(connection.inputStream))

            var result = ""

            do{
                result += (br.readLine())
            }while(br.readLine() != null)

            var parser = JsonParser()
            val element: JsonElement = parser.parse(result)

            accessToken = element.asJsonObject.get("access_token").asString
            refreshToken = element.asJsonObject.get("refresh_token").asString

            br.close()
            bw.close()

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return accessToken
    }

    fun getUserInfo(accessToken: String): HashMap<String, String>? {
        val requestURL = "https://kapi.kakao.com/v2/user/me"
        var userInfo: HashMap<String, String>? = null

        try {
            val url: URL = URL(requestURL)
            var connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "POST"
            connection.setRequestProperty("Authorization", "Bearer $accessToken")

            val br = BufferedReader(InputStreamReader(connection.inputStream))
            var result = ""

            do{
                result += (br.readLine())
            }while(br.readLine() != null)

            var parser = JsonParser()
            val element: JsonElement = parser.parse(result)

            val kakaoAccount: JsonObject = element.asJsonObject.get("kakao_account").asJsonObject

            val id: String = element.asJsonObject.get("id").asString
            var email: String?
            if (kakaoAccount.asJsonObject.get("email") != null) {
                email = kakaoAccount.asJsonObject.get("email").asString
                userInfo = hashMapOf("id" to id, "email" to email)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return userInfo
    }
}
