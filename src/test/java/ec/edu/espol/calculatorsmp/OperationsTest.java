package ec.edu.espol.calculatorsmp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Grupo#2
 */
public class OperationsTest {
    
    public OperationsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testMakeFormula() {
        System.out.println("MakeFormula");
        String result = Operations.MakeFormula();
        assertNotNull(result, "La fórmula no debe ser nula.");
        assertFalse(result.isEmpty(), "La fórmula no debe estar vacía.");

        // Verifica que la fórmula tenga al menos un número
        assertTrue(result.matches(".*\\d.*"), "La fórmula debe contener al menos un número.");

        // Verifica que la fórmula contenga solo caracteres permitidos (dígitos y operadores)
        assertTrue(result.matches("[0-9+\\-*/]+"), "La fórmula debe contener solo dígitos y operadores.");
}


    @Test
    public void testSolve() {
        System.out.println("Solve");

        // Prueba con una operación simple
        assertEquals("5+3=8", Operations.Solve("5+3"), "Error al resolver 5+3");
        assertEquals("10-2=8", Operations.Solve("10-2"), "Error al resolver 10-2");
        assertEquals("4*7=28", Operations.Solve("4*7"), "Error al resolver 4*7");
        assertEquals("8/2=4", Operations.Solve("8/2"), "Error al resolver 8/2");

        // Prueba con múltiples operaciones y precedencia
        assertEquals("2+3*4=14", Operations.Solve("2+3*4"), "Error al resolver 2+3*4");
        assertEquals("6*3-2=16", Operations.Solve("6*3-2"), "Error al resolver 6*3-2");

        // Prueba de fórmula generada automáticamente
        String generatedFormula = Operations.MakeFormula();
        String solvedFormula = Operations.Solve(generatedFormula);
        assertTrue(solvedFormula.matches(generatedFormula + "=\\d+"), "Error al resolver fórmula generada: " + generatedFormula);

        // Prueba con una fórmula vacía (espera un fallo)
        Exception exception = assertThrows(Exception.class, () -> {
            Operations.Solve("");
        });
        assertNotNull(exception, "Debe lanzar una excepción al pasar una fórmula vacía.");

        // Prueba de división por cero (espera un fallo)
        exception = assertThrows(Exception.class, () -> {
            Operations.Solve("8/0");
        });
        assertNotNull(exception, "Debe lanzar una excepción al intentar dividir por cero.");
    }

    
}
