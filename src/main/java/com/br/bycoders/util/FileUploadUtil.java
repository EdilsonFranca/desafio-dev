package com.br.bycoders.util;

import com.br.bycoders.models.Movement;
import com.br.bycoders.models.Type;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUploadUtil {
    public static List<Movement> create(MultipartFile file) throws IOException {

        List movements     = new ArrayList();
        Reader inputStream = new InputStreamReader(file.getInputStream());
        BufferedReader inputBuffer = new BufferedReader(inputStream);

        String line;
        while ((line = inputBuffer.readLine()) != null) {
            Movement movement = create_movement(line);
            movements.add(movement);
        }

        inputBuffer.close();

        return movements;
    }

    public static Movement create_movement(String line) {
        Type type    = new Type(Integer.parseInt(line.substring(0, 1)));
        String date  = line.substring(1, 9);
        String value = line.substring(9, 19);
        String cpf   = line.substring(19,30);
        String card  = line.substring(30,42);
        String hour  = line.substring(42,48);
        String owner = line.substring(48,62);
        String store = line.substring(62,80);

        return new Movement(type, getDate(date), getValue(value), cpf, card, getHour(hour), store, owner);
    }

    public static BigDecimal getValue(String value) {
        return new BigDecimal(value).divide(BigDecimal.valueOf(100));
    }

    public static LocalDate getDate(String date) {
        return LocalDate.parse(date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8));
    }

    public static String getHour(String hour) {
        return hour.substring(0, 2) + ":" + hour.substring(2, 4) + ":" + hour.substring(4, 6);
    }
}
