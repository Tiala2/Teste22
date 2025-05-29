package br.edu.unichristus.recantorsc.model;

import org.junit.jupiter.api.Test;
import projeto.edu.unichristus.java.model.Consulta;
import projeto.edu.unichristus.java.model.ProfissionalSaude;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class ConsultaTest {
    @Test
    void testConstrutorEGetters() {
        LocalDateTime dataHora = LocalDateTime.of(2024, 2, 20, 14, 0);
        ProfissionalSaude prof = new ProfissionalSaude(1, "Dr. Silva", "Clínico", "123456");
        Consulta consulta = new Consulta(1, dataHora, prof, "Rotina", "Dor de cabeça", "Sem observações");
        assertEquals(1, consulta.getId());
        assertEquals(dataHora, consulta.getDataHora());
        assertEquals(prof, consulta.getProfissional());
        assertEquals("Rotina", consulta.getTipo());
        assertEquals("Dor de cabeça", consulta.getMotivo());
        assertEquals("Sem observações", consulta.getDiagnostico());
    }

    @Test
    void testSetters() {
        Consulta consulta = new Consulta();
        consulta.setId(2);
        LocalDateTime dataHora = LocalDateTime.of(2024, 3, 5, 10, 30);
        consulta.setDataHora(dataHora);
        ProfissionalSaude prof = new ProfissionalSaude(2, "Dra. Maria", "Geriatra", "654321");
        consulta.setProfissional(prof);
        consulta.setTipo("Emergência");
        consulta.setMotivo("Febre");
        consulta.setDiagnostico("Infecção");
        assertEquals(2, consulta.getId());
        assertEquals(dataHora, consulta.getDataHora());
        assertEquals(prof, consulta.getProfissional());
        assertEquals("Emergência", consulta.getTipo());
        assertEquals("Febre", consulta.getMotivo());
        assertEquals("Infecção", consulta.getDiagnostico());
    }
}
