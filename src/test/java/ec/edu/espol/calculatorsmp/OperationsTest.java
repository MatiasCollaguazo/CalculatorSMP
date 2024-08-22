package ec.edu.espol.calculatorsmp;

import java.util.EmptyStackException;
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


    public void testSolve() {
        System.out.println("Solve");

        // Prueba con una operación simple
        assertEquals("5+3=8", Operations.Solve("5+3"), "Error al resolver 5+3");
        assertEquals("10-2=8", Operations.Solve("10-2"), "Error al resolver 10-2");
        assertEquals("4*7=28", Operations.Solve("4*7"), "Error al resolver 4*7");
        assertEquals("8/2=4", Operations.Solve("8/2"), "Error al resolver 8/2");

        // Prueba con múltiples operaciones y precedencia
        assertEquals("2+3*4=14", Operations.Solve("2+3*4"), "Error al resolver 2+3*4");
        assertEquals("99*99*99*99=9605960", Operations.Solve("2+3*4"), "Error al resolver 2+3*4");
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


    @Test
    public void testSolve1() {
        System.out.println("TS1");
        String formula = "5+3";
        String expResult = "5+3=8";
        String result = Operations.Solve(formula);
        // Prueba con una operación simple
        assertEquals(expResult, result, "Error al resolver "+formula);
    }


    @Test
    public void testSolve2() {
        System.out.println("TS2");
        String formula = "10-2";
        String expResult = "10-2=8";
        String result = Operations.Solve(formula);
        // Prueba con una operación simple
        assertEquals(expResult, result, "Error al resolver "+formula);
    }


    @Test
    public void testSolve3() {      
        System.out.println("TS3");
        String formula = "4*7";
        String expResult = "4*7=28";
        String result = Operations.Solve(formula);
        // Prueba con una operación simple
        assertEquals(expResult, result, "Error al resolver "+formula);
    }


    @Test
    public void testSolve4() {
        System.out.println("TS4");
        String formula = "8/2";
        String expResult = "8/2=4";
        String result = Operations.Solve(formula);
        // Prueba con una operación simple
        assertEquals(expResult, result, "Error al resolver "+formula);
    }
    
    @Test
    public void testSolve5() {
        System.out.println("TS5");
        String formula = "2+2/0";
        ArithmeticException expResult = new ArithmeticException();
        // Prueba con una operación simple
        assertThrows(expResult.getClass(), () -> {
            Operations.Solve(formula);
        });
    }
    
    
    // Prueba con múltiples operaciones y precedencia
    @Test
    public void testSolve6() {
        System.out.println("TS6");
        String formula = "2+3*4";
        String expResult = "2+3*4=14";
        String result = Operations.Solve(formula);
        // Prueba con una operación simple
        assertEquals(expResult, result, "Error al resolver "+formula);
    }

    @Test
    public void testSolve7() {
        System.out.println("TS7");
        String formula = "99*99*99*99";
        String expResult = "99*99*99*99=96059601";
        String result = Operations.Solve(formula);
        // Prueba con una operación simple
        assertEquals(expResult, result, "Error al resolver "+formula);
    }
    
    @Test
    public void testSolve8() {
        System.out.println("TS8");
        String formula = "6*3-2";
        String expResult = "6*3-2=16";
        String result = Operations.Solve(formula);
        // Prueba con una operación simple
        assertEquals(expResult, result, "Error al resolver "+formula);
    }
    
    @Test
    public void testSolve9() {
        System.out.println("TS9");
        String formula = "";
        EmptyStackException expResult = new EmptyStackException();
        assertThrows(expResult.getClass(), () -> {
            Operations.Solve(formula);
        });
    }
    
    @Test
    public void testSolve10() {
        System.out.println("TS10");
        String formula = "8/0";
        ArithmeticException expResult = new ArithmeticException();
        // Prueba de división por cero (espera un fallo)
        assertThrows(expResult.getClass(), () -> {
            String result = Operations.Solve(formula);
        });
    }
    
    @Test
    public void testSolve11() {
        System.out.println("TS11");
        String formula = "2+2";
        String expResult = "2+2=4";
        String result = Operations.Solve(formula);
        // Prueba con una operación simple
        assertEquals(expResult, result, "Error al resolver "+formula);
    }
    
    @Test
    public void testSolve12() {
        System.out.println("TS13");
        String formula = "4+4*4";
        String expResult = "4+4*4=20";
        String result = Operations.Solve(formula);
        // Prueba con una operación simple
        assertEquals(expResult, result, "Error al resolver "+formula);
    }
    
    @Test
    public void testSolve13() {
        System.out.println("TS13");
        String generatedFormula = Operations.MakeFormula();
        String result = Operations.Solve(generatedFormula);
        System.out.println("Generated Formula: " + generatedFormula);
        System.out.println("Result: " + result);

        // Extrae la parte de la fórmula antes del `=` y la parte numérica después del `=`
        String[] parts = result.split("=");

        // Verifica que el resultado coincide con la fórmula generada y que la parte después del `=` es un número
        assertTrue(parts.length == 2 && parts[0].equals(generatedFormula) && parts[1].matches("\\d+"),
            "Error al resolver fórmula generada: " + generatedFormula);
    }

    @Test
    public void testSolve14() {
        System.out.println("TS14");
        String formula = "3-7";
        String expResult = "3-7=-4";
        String result = Operations.Solve(formula);
        // Prueba con una operación que da un resultado negativo
        assertEquals(expResult, result, "Error al resolver "+formula);
    }

    @Test
    public void testSolve15() {
        System.out.println("TS15");
        String formula = "10+5*2-3";
        String expResult = "10+5*2-3=17";
        String result = Operations.Solve(formula);
        // Prueba con una operación que tiene múltiples operadores de diferentes tipos
        assertEquals(expResult, result, "Error al resolver "+formula);
}


}
