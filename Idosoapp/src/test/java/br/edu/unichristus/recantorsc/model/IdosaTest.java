package br.edu.unichristus.recantorsc.model;

import org.junit.jupiter.api.Test;
import projeto.edu.unichristus.java.model.Idosa;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class IdosaTest {
    @Test
    void testConstrutorEGetters() {
        LocalDate dataNasc = LocalDate.of(1950, 5, 10);
        LocalDate dataEntrada = LocalDate.of(2024, 1, 1);
        Idosa idosa = new Idosa(1, "Maria", "12345678900", dataNasc, "Ana", "99999999999", dataEntrada);
        assertEquals(1, idosa.getId());
        assertEquals("Maria", idosa.getNome());
        assertEquals("12345678900", idosa.getCpf());
        assertEquals(dataNasc, idosa.getDataNascimento());
        assertEquals("Ana", idosa.getNomeMae());
        assertEquals("99999999999", idosa.getCartaoSUS());
        assertEquals(dataEntrada, idosa.getDataEntrada());
    }

    @Test
    void testSetters() {
        Idosa idosa = new Idosa();
        idosa.setId(2);
        idosa.setNome("Joana");
        idosa.setCpf("98765432100");
        LocalDate dataNasc = LocalDate.of(1945, 8, 20);
        idosa.setDataNascimento(dataNasc);
        idosa.setNomeMae("Clara");
        idosa.setCartaoSUS("88888888888");
        LocalDate dataEntrada = LocalDate.of(2023, 12, 1);
        idosa.setDataEntrada(dataEntrada);
        assertEquals(2, idosa.getId());
        assertEquals("Joana", idosa.getNome());
        assertEquals("98765432100", idosa.getCpf());
        assertEquals(dataNasc, idosa.getDataNascimento());
        assertEquals("Clara", idosa.getNomeMae());
        assertEquals("88888888888", idosa.getCartaoSUS());
        assertEquals(dataEntrada, idosa.getDataEntrada());
    }
}
