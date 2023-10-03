import excepciones.ExcepcionNumNoValido;

public class E02_TablaMult {
    public static void main(String[] args) {
        try {
            imprimirTablas(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void imprimirTablas(int n) throws Exception {
        if (n > 0 && n < 30001) {
            for (int i = 0; i <= 10; i++) {
                System.out.println(n + " * " + i + " = " + (n * i));
            }
        } else
            throw new ExcepcionNumNoValido();
    }
}
