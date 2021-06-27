package com.example.dhabits.servicea;

import com.example.dhabits.servicea.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.dhabits.utils.Utils.toJson;

@Slf4j
@Service
public class MessageSenderImpl implements MessageSender{

    @Value("${app.url}")
    private String url;

    @Override
    public void sendData(Person data) throws Exception {

        System.out.println("url = " + url);

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        String jsonData = toJson(data);

        log.info("\nSending 'POST' request to URL : " + url);
        log.info("Post parameters : " + jsonData);

        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            wr.writeBytes(jsonData);
        }

        int responseCode = connection.getResponseCode();
        log.info("Response Code : " + responseCode);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            log.info("Response: " + response.toString());
        } catch (IOException e) {
            log.error(e.getMessage(), e.getCause());
        }
    }
}
