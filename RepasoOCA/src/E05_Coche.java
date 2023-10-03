import excepciones.ExcepcionLimiteKmExcedido;
import excepciones.ExcepcionRuedaPinchada;

public class E05_Coche {
    private E04_Motor motor;
    private E03_Rueda[] ruedas;

    public E05_Coche(E04_Motor motor, E03_Rueda[] ruedas) {
        this.motor = motor;
        this.ruedas = ruedas;
    }

    public void rodar(int km) {
        try {
            motor.rodar(km);
            for (int i = 0; i < ruedas.length; i++) {
                ruedas[i].rodar(km);
            }
        } catch (ExcepcionLimiteKmExcedido e) {
            System.out.println(e.getMessage());
        } catch (ExcepcionRuedaPinchada e) {
            System.out.println(e.getMessage());
        }
    }

    public void print() {
        motor.print();
        for (int i = 0; i < ruedas.length; i++) {
            ruedas[i].println();
        }
    }

    public void println() {
        print();
        System.out.println();
    }

    public static void main(String[] args) {
        // Crear una instancia de E04_Motor para el coche
        E04_Motor motor = new E04_Motor(2000, 150);

        // Crear un array de E03_Rueda para las ruedas del coche
        E03_Rueda[] ruedas = new E03_Rueda[4];
        for (int i = 0; i < 4; i++) {
            ruedas[i] = new E03_Rueda("Marca" + (i + 1), 16, 205, 60);
        }

        // Crear una instancia de E05_Coche con el motor y las ruedas
        E05_Coche coche = new E05_Coche(motor, ruedas);

        // Probar el método rodar para el coche
        coche.rodar(25000);

        // Probar el método print para el coche
        coche.print();

        // Pinchar una rueda para provocar la excepción
        ruedas[2].pinchar();
        coche.rodar(5000); // Debería lanzar ExcepcionRuedaPinchada

        coche.rodar(10000); //Deberia lanzar ExcepcionLimiteKMExcedido

    }
}
