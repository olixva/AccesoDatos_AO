import excepciones.ExcepcionLimiteKmExcedido;

public class E04_Motor {
    private int cubicajeCC;
    private int potenciaCV;

    private int limiteKm = 30000;
    private int rodaduraKm = 0;

    public E04_Motor(int cubicajeCC, int potenciaCV) {
        this.cubicajeCC = cubicajeCC;
        this.potenciaCV = potenciaCV;
    }

    public E04_Motor() {
    }

    public void rodar(int km) throws ExcepcionLimiteKmExcedido {

        for (int i = 0; i < km; i++) {
            this.rodaduraKm += 1;
            if (this.rodaduraKm > this.limiteKm) {
                throw new ExcepcionLimiteKmExcedido();
            }
        }

    }

    public void print() {
        String aux = ", ";
        if (this.rodaduraKm > this.limiteKm) {
            aux += "Ha excedido el limite de KM";
        } else
            aux += "Quedan " + (this.limiteKm - this.rodaduraKm) + "KM por rodar. ";

        System.out.println("Cubicaje CC = " + this.cubicajeCC + ", Potencia CV = " + aux);
    }

    public void println() {
        print();
        System.out.println();
    }

    public static void main(String[] args) {
        // Crear una instancia de E04_Motor utilizando el constructor con parámetros
        E04_Motor motor1 = new E04_Motor(2000, 150);

        // Crear una instancia de E04_Motor utilizando el constructor por defecto
        E04_Motor motor2 = new E04_Motor();

        try {
            // Probar el método rodar para motor1
            motor1.rodar(25000);
            motor1.rodar(4999);

            // Probar el método rodar para motor2
            motor2.rodar(28000);

            // Probar el método print para motor1
            motor1.print();

            // Probar el método println para motor2
            motor2.println();

            // Intentar rodar más allá del límite para provocar la excepción
            motor1.rodar(10000); // Debería lanzar ExcepcionLimiteKmExcedido
        } catch (ExcepcionLimiteKmExcedido e) {
            System.out.println(e.getMessage());
        }
    }

}
