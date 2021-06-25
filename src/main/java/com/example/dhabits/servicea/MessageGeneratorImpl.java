package com.example.dhabits.servicea;

import com.example.dhabits.serviceb.model.UserData;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static com.example.dhabits.utils.Utils.convertImgToJson;

@Slf4j
public class MessageGeneratorImpl implements MessageGenerator {

    private final String path = "photo" + File.separator + "photo.jpg";

    @Override
    public UserData generateData() {

        final UserData userData = new UserData();
        userData.setFio("Jane Doe");
        userData.setDateOfBirth(LocalDate.of(1995, 2, 17));
        userData.setContacts("+7 (495) 000-00-00");
        try {
            userData.setPhoto(convertImgToJson(path));
        } catch(IOException e) {
            e.printStackTrace();
        }
        userData.setId("234fre543gtrdfght");
        System.out.println(userData);

        return userData;
    }


}
