import excepciones.ExcepcionRuedaPinchada;

public class E06_Camion extends E05_Coche {
    private int tara;
    private int pma;

    E03_Rueda[] ra;

    public E06_Camion(E04_Motor motor, E03_Rueda[] ruedas, int tara, int pma, E03_Rueda[] ra) {
        super(motor, ruedas);
        this.tara = tara;
        this.pma = pma;
        this.ra = ra;
    }

    public E06_Camion(E04_Motor motor, E03_Rueda[] ruedas) {
        super(motor, ruedas);
    }

    @Override
    public void rodar(int km) {
        super.rodar(km);
        for (int i = 0; i < ra.length; i++) {
            try {
                ra[i].rodar(km);
            } catch (ExcepcionRuedaPinchada e) {
                System.out.println(e.getMessage());
                ;
            }
        }
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Datos de las ruedas adiccionales: ");
        for (int i = 0; i < ra.length; i++) {
            ra[i].println();
        }
    }

    @Override
    public void println() {
        print();
        System.out.println();
    }

    public static void main(String[] args) {
        // Crear una instancia de E04_Motor para el camión
        E04_Motor motorCamion = new E04_Motor(3000, 250);

        // Crear un array de E03_Rueda para las ruedas del camión
        E03_Rueda[] ruedasCamion = new E03_Rueda[6];
        for (int i = 0; i < 6; i++) {
            ruedasCamion[i] = new E03_Rueda("Marca" + (i + 1), 22, 300, 70);
        }

        // Crear un array adicional de E03_Rueda para las ruedas adicionales del camión
        E03_Rueda[] ruedasAdicionales = new E03_Rueda[2];
        for (int i = 0; i < 2; i++) {
            ruedasAdicionales[i] = new E03_Rueda("Marca" + (i + 7), 22, 300, 70);
        }

        // Crear una instancia de E06_Camion con el motor, las ruedas y las ruedas
        // adicionales
        E06_Camion camion = new E06_Camion(motorCamion, ruedasCamion, 8000, 15000, ruedasAdicionales);

        // Probar el método rodar para el camión
        camion.rodar(20000);

        // Probar el método print para el camión
        camion.print();

        // Pinchar una rueda adicional para provocar la excepción
        ruedasAdicionales[1].pinchar();
        camion.rodar(5000); // Debería lanzar ExcepcionRuedaPinchada

    }

}
