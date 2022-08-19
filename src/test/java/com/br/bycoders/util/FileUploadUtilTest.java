package com.br.bycoders.util;

import com.br.bycoders.models.Movement;
import com.br.bycoders.models.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUploadUtilTest {
    FileUploadUtil FileUploadUtil;
    MockMultipartFile file;

    @BeforeEach
    public void inicializa() throws IOException {
        String path = "src/test/static/CNAB.txt";

        FileInputStream inputFile = new FileInputStream(path);
        this.file = new MockMultipartFile("file", "file", "multipart/form-data", inputFile);
    }

    @Test
    @DisplayName("Verifica se o metodo create  esta criando uma lista de  movimentação com 21 movimentações quando recebe um arquivo de texto")
    void DeveRetornarUmaListaDeMovimentacao() throws IOException {
        List<Movement> movements = this.FileUploadUtil.create(this.file);
        assertTrue(movements.size() == 21);
    }


    @Test
    @DisplayName("Verifica se o metodo create_movement  esta criando a movimentação quando recebe uma linha")
    void DeveRetornarUmaMovimentacao() {
        String line = "3201903010000014200096206760174753****3153153453JOÃO MACEDO   BAR DO JOÃO       ";

        Movement movementTest = createMovementTest();
        Movement movement = this.FileUploadUtil.create_movement(line);

        assertTrue(comparaMovementTest(movementTest, movement));
    }

    @Test
    @DisplayName("Verifica se o metodo getValue  esta dividindo o valor por 100")
    void DeveRetornarOValorDivididoPorCem() {
        BigDecimal value = this.FileUploadUtil.getValue("1000");
        assertEquals(new BigDecimal("10"), value);
    }

    @Test
    @DisplayName("Verifica se o metodo getDate esta retornando uma data valida")
    void DeveRetornarUmaDataValida() {
        LocalDate localDateAntigo = LocalDate.of(2019, 03, 01);
        LocalDate date = this.FileUploadUtil.getDate("20190301");
        assertTrue(localDateAntigo.isEqual(date));
    }

    @Test
    @DisplayName("Verifica se o metodo getHour esta retornando uma hora valida")
    void DeveRetornarUmaHoraValida() {
        String horaAntiga = "153453";
        String horaEsperada = "15:34:53";

        String hora = this.FileUploadUtil.getHour(horaAntiga);
        assertEquals(hora, horaEsperada);
    }

    private static Movement createMovementTest() {
        LocalDate date = LocalDate.of(2019, 03, 01);
        return new Movement(new Type(3), date, new BigDecimal("142"), "09620676017", "4753****3153", "15:34:53", "BAR DO JOÃO       ", "JOÃO MACEDO   ");
    }

    private static Boolean comparaMovementTest(Movement movement1, Movement movement2) {
        if (movement1.getCard().equals(movement2.getCard()) &&
                movement1.getCpf().equals(movement2.getCpf()) &&
                movement1.getOwner().equals(movement2.getOwner()) &&
                movement1.getStore().equals(movement2.getStore()) &&
                movement1.getDate().equals(movement2.getDate()) &&
                movement1.getValue().equals(movement2.getValue()) &&
                movement1.getType().getCod() != movement2.getType().getCod() &&
                movement1.getHour().equals(movement2.getHour()))
            return false;
        return true;
    }
}
