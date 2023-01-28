package homework4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class TriangleTest {
    public static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    void testCalcTriangle() throws MyExсeption {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(14.696938456699069, triangle.triangle(5, 6, 7));
        logger.info("Позитивный тест. Результат совпадает с ожиданием.");
    }

    @Test
    void testNegativeValue() throws MyExсeption {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyExсeption.class, ()->triangle.triangle(5, 6, -7));
        logger.info("Негатиный тест. Одно из значений отрицательное.");
    }

    @Test
    void testZeroValue() throws MyExсeption {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyExсeption.class, ()-> triangle.triangle(5, 6, 0));
        logger.info("Негатиный тест. Одно из значений равно нулю.");
    }

    @Test
    void testSumTwoSides() throws MyExсeption {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyExсeption.class, ()-> triangle.triangle(20, 6, 7));
        logger.info("Негатиный тест. Одно из значений больше или равно сумме двух сторон.");
    }
}
