package br.edu.unichristus.recantorsc.model;

import org.junit.jupiter.api.Test;
import projeto.edu.unichristus.java.model.ProntuarioMedico;
import projeto.edu.unichristus.java.model.Idosa;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ProntuarioMedicoTest {
    @Test
    void testConstrutorEGetters() {
        Idosa idosa = new Idosa(1, "Maria", "12345678900", null, "Ana", "99999999999", null);
        LocalDateTime dataHora = LocalDateTime.of(2024, 5, 1, 10, 0);
        ProntuarioMedico prontuario = new ProntuarioMedico(1, dataHora, idosa, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        assertEquals(1, prontuario.getId());
        assertEquals(dataHora, prontuario.getDataHoraIdosa());
        assertEquals(idosa, prontuario.getIdosa());
        assertNotNull(prontuario.getConsultas());
        assertNotNull(prontuario.getPrescricoes());
        assertNotNull(prontuario.getVacinas());
        assertNotNull(prontuario.getEventosSentinela());
    }

    @Test
    void testSetters() {
        ProntuarioMedico prontuario = new ProntuarioMedico();
        prontuario.setId(2);
        LocalDateTime dataHora = LocalDateTime.of(2024, 6, 1, 8, 30);
        prontuario.setDataHoraIdosa(dataHora);
        Idosa idosa = new Idosa();
        prontuario.setIdosa(idosa);
        assertEquals(2, prontuario.getId());
        assertEquals(dataHora, prontuario.getDataHoraIdosa());
        assertEquals(idosa, prontuario.getIdosa());
    }
}
