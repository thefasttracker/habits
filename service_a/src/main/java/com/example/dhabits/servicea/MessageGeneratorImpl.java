package com.example.dhabits.servicea;

import com.example.dhabits.servicea.model.Passport;
import com.example.dhabits.servicea.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static com.example.dhabits.utils.Utils.convertImgToJson;

@Slf4j
@Service
public class MessageGeneratorImpl implements MessageGenerator {

    private final String path = "photo" + File.separator + "photo.jpg";

    @Override
    public Person generateData() {

        final Person person = new Person();
        final Passport passport = new Passport();
        person.setFio("Jane Doe");
        person.setDateOfBirth(LocalDate.of(1995, 2, 17));
        person.setContacts("+7 (495) 000-00-00");
        passport.setIssueDate(LocalDate.of(2010, 3, 18));
        passport.setIssuedBy("UVD Moscow");
        passport.setNumberAndSeries(123456789);
        person.setPassport(passport);
        try {
            person.setPhoto(convertImgToJson(path));
        } catch(IOException e) {
            e.printStackTrace();
        }
        person.setId("234fre543gtrdfght");
        log.info("generateData: " + person);

        return person;
    }


}
