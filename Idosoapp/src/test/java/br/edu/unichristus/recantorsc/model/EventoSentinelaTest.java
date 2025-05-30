package br.edu.unichristus.recantorsc.model;

import org.junit.jupiter.api.Test;
import projeto.edu.unichristus.java.model.EventoSentinela;
import projeto.edu.unichristus.java.model.TipoEventoSentinela;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class EventoSentinelaTest {
    @Test
    void testConstrutorEGetters() {
        LocalDate data = LocalDate.of(2024, 5, 10);
        EventoSentinela evento = new EventoSentinela(1, TipoEventoSentinela.QUEDA, data);
        assertEquals(1, evento.getId());
        assertEquals(TipoEventoSentinela.QUEDA, evento.getTipo());
        assertEquals(data, evento.getDataOcorrencia());
    }

    @Test
    void testSetters() {
        EventoSentinela evento = new EventoSentinela();
        evento.setId(2);
        evento.setTipo(TipoEventoSentinela.INFECCAO);
        LocalDate data = LocalDate.of(2024, 6, 1);
        evento.setDataOcorrencia(data);
        assertEquals(2, evento.getId());
        assertEquals(TipoEventoSentinela.INFECCAO, evento.getTipo());
        assertEquals(data, evento.getDataOcorrencia());
    }
}
