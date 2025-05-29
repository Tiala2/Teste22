package br.edu.unichristus.recantorsc.model;

import org.junit.jupiter.api.Test;
import projeto.edu.unichristus.java.model.Vacina;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class VacinaTest {
    @Test
    void testConstrutorEGetters() {
        LocalDate data = LocalDate.of(2024, 3, 15);
        Vacina vacina = new Vacina(1, "Influenza", data);
        assertEquals(1, vacina.getId());
        assertEquals("Influenza", vacina.getNome());
        assertEquals(data, vacina.getDataOcorrencia());
    }

    @Test
    void testSetters() {
        Vacina vacina = new Vacina();
        vacina.setId(2);
        vacina.setNome("Covid-19");
        LocalDate data = LocalDate.of(2024, 4, 10);
        vacina.setDataOcorrencia(data);
        assertEquals(2, vacina.getId());
        assertEquals("Covid-19", vacina.getNome());
        assertEquals(data, vacina.getDataOcorrencia());
    }
}
