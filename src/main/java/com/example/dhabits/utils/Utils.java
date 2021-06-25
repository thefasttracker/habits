package com.example.dhabits.utils;

import com.example.dhabits.serviceb.model.UserData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Utils {
    public static String toJson(UserData params) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper.writeValueAsString(params);
    }

    public static String convertImgToJson(String filePath) throws IOException {
        File file = new File(filePath);
        byte[] fileContent = FileUtils.readFileToByteArray(file);
        return Base64.getEncoder().encodeToString(fileContent);
    }
}
