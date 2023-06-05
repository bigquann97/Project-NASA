package com.nasa.projectnasa.nasa;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApodService {

  @Value("${nasa.api-key}")
  private String apiKey;

  @Value("${nasa.apod-url}")
  private String apodUrl;

  public String getAopdUrl(String date) throws IOException {
    String requestUrl = apodUrl + "?date=" + date + "&api_key=" + apiKey;
    URL url = new URL(requestUrl);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    int responseCode = connection.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_OK) {
      BufferedReader reader = new BufferedReader(
          new InputStreamReader(connection.getInputStream()));
      String line;
      StringBuilder response = new StringBuilder();

      while ((line = reader.readLine()) != null) {
        response.append(line);
      }
      reader.close();

      // JSON을 APODResponse 객체로 변환
      Gson gson = new Gson();
      return response.toString();
    } else {
      return "NOTHING_FOUND";
    }
  }

}

