package br.edu.unichristus.recantorsc.model;

import org.junit.jupiter.api.Test;
import projeto.edu.unichristus.java.model.Relatorio;
import static org.junit.jupiter.api.Assertions.*;

class RelatorioTest {
    @Test
    void testConstrutorEGetters() {
        Relatorio relatorio = new Relatorio(1, "Relatório de saúde", "Anual");
        assertEquals(1, relatorio.getId());
        assertEquals("Relatório de saúde", relatorio.getDescricao());
        assertEquals("Anual", relatorio.getTipo());
    }

    @Test
    void testSetters() {
        Relatorio relatorio = new Relatorio();
        relatorio.setId(2);
        relatorio.setDescricao("Relatório atualizado");
        relatorio.setTipo("Mensal");
        assertEquals(2, relatorio.getId());
        assertEquals("Relatório atualizado", relatorio.getDescricao());
        assertEquals("Mensal", relatorio.getTipo());
    }
}
