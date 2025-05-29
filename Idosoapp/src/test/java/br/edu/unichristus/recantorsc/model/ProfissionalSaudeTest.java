package br.edu.unichristus.recantorsc.model;

import org.junit.jupiter.api.Test;
import projeto.edu.unichristus.java.model.ProfissionalSaude;
import static org.junit.jupiter.api.Assertions.*;

class ProfissionalSaudeTest {
    @Test
    void testConstrutorEGetters() {
        ProfissionalSaude prof = new ProfissionalSaude(1, "João", "Enfermeiro", "123456");
        assertEquals(1, prof.getId());
        assertEquals("João", prof.getNome());
        assertEquals("Enfermeiro", prof.getEspecialidade());
        assertEquals("123456", prof.getRegistroProfissional());
    }

    @Test
    void testSetters() {
        ProfissionalSaude prof = new ProfissionalSaude();
        prof.setId(2);
        prof.setNome("Maria");
        prof.setEspecialidade("Médica");
        prof.setRegistroProfissional("654321");
        assertEquals(2, prof.getId());
        assertEquals("Maria", prof.getNome());
        assertEquals("Médica", prof.getEspecialidade());
        assertEquals("654321", prof.getRegistroProfissional());
    }
}
