package br.edu.unichristus.recantorsc.model;

import org.junit.jupiter.api.Test;
import projeto.edu.unichristus.java.model.Prescricao;
import static org.junit.jupiter.api.Assertions.*;

class PrescricaoTest {
    @Test
    void testConstrutorEGetters() {
        Prescricao prescricao = new Prescricao(1, "Dipirona", "8/8h", "5 dias", "Sem observações");
        assertEquals(1, prescricao.getId());
        assertEquals("Dipirona", prescricao.getMedicamento());
        assertEquals("8/8h", prescricao.getPosologia());
        assertEquals("5 dias", prescricao.getDuracao());
        assertEquals("Sem observações", prescricao.getObservacoes());
    }

    @Test
    void testSetters() {
        Prescricao prescricao = new Prescricao();
        prescricao.setId(2);
        prescricao.setMedicamento("Paracetamol");
        prescricao.setPosologia("12/12h");
        prescricao.setDuracao("7 dias");
        prescricao.setObservacoes("Tomar após as refeições");
        assertEquals(2, prescricao.getId());
        assertEquals("Paracetamol", prescricao.getMedicamento());
        assertEquals("12/12h", prescricao.getPosologia());
        assertEquals("7 dias", prescricao.getDuracao());
        assertEquals("Tomar após as refeições", prescricao.getObservacoes());
    }
}
