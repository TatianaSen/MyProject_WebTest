package homework4;

public class Triangle {
    public double triangle (int a, int b, int c) throws MyExсeption {
        if (checkValues(a, b, c));
        double p = (a + b + c) / 2;
        double s = Math.sqrt (p * (p - a) * (p - b) * (p - c));
        return s;
    }

    private static boolean checkValues(int a, int b, int c) throws MyExсeption {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new MyExсeption("Значение стороны треугольника должно быт положительным!");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new MyExсeption("Это не треугольник! Необходимо проверить значения");
        }
        return false;
    }
}
