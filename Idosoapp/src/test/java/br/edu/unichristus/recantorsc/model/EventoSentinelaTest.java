package br.edu.unichristus.recantorsc.model;

import org.junit.jupiter.api.Test;
import projeto.edu.unichristus.java.model.EventoSentinela;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class EventoSentinelaTest {
    @Test
    void testConstrutorEGetters() {
        LocalDate data = LocalDate.of(2024, 5, 10);
        EventoSentinela evento = new EventoSentinela(1, "Queda", data);
        assertEquals(1, evento.getId());
        assertEquals("Queda", evento.getTipo());
        assertEquals(data, evento.getDataOcorrencia());
    }

    @Test
    void testSetters() {
        EventoSentinela evento = new EventoSentinela();
        evento.setId(2);
        evento.setTipo("Infecção");
        LocalDate data = LocalDate.of(2024, 6, 1);
        evento.setDataOcorrencia(data);
        assertEquals(2, evento.getId());
        assertEquals("Infecção", evento.getTipo());
        assertEquals(data, evento.getDataOcorrencia());
    }
}
