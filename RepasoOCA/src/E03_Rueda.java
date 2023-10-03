import excepciones.ExcepcionRuedaPinchada;

public class E03_Rueda {
    private String marca;
    private int diametroPulgadas;
    private int anchuraNominal;
    private int ratioAspectoPc;

    private boolean pinchada;
    private boolean cambiar;

    private int limiteKm = 60000;
    private int rodaduraKm = 0;

    public E03_Rueda(String marca, int diametroPulgadas, int anchuraNominal, int ratioAspectoPc) {
        this.marca = marca;
        this.diametroPulgadas = diametroPulgadas;
        this.anchuraNominal = anchuraNominal;
        this.ratioAspectoPc = ratioAspectoPc;
        this.pinchada = false;
        this.cambiar = false;
    }

    public E03_Rueda() {
        this.pinchada = false;
        this.cambiar = false;
    }

    public void pinchar() {
        this.pinchada = true;
    }

    public void reparar() {
        this.pinchada = false;
    }

    public void rodar(int km) throws ExcepcionRuedaPinchada {

        if (!this.pinchada) {
            for (int i = 0; i < km; i++) {
                rodaduraKm += 1;
                if (rodaduraKm > limiteKm) {
                    cambiar = true;
                }
            }
        } else
            throw new ExcepcionRuedaPinchada();
    }

    public void print() {
        String aux = ", ";
        if (this.cambiar) {
            aux += "Ha excedido en " + (this.rodaduraKm - this.limiteKm) + "KM el limite. ";
        } else
            aux += "Quedan " + (this.limiteKm - this.rodaduraKm) + "KM por rodar. ";

        System.out.print("Marca = " + this.marca + ", Diametro Pulgadas = " + this.diametroPulgadas + ", Anchura Nominal = "
                + this.anchuraNominal+  ", Ratio Aspecto Pc = " + this.ratioAspectoPc + aux);
    }

    public void println() {
        print();
        System.out.println();
    }

    public static void main(String[] args) {

        // Crear una instancia utilizando el constructor por parametizado
        E03_Rueda rueda1 = new E03_Rueda("Marca1", 16, 205, 60);

        // Crear una instancia utilizando el constructor por defecto
        E03_Rueda rueda2 = new E03_Rueda();

        try {
            // Probar el método rodar con rueda1 (sin pinchar)
            rueda1.rodar(10000);
            rueda1.rodar(20000);

            // Probar el método rodar con rueda2 (pinchada) comentado para poder comprobar que funciona el resto
            //rueda2.pinchar();
            rueda2.rodar(5000); // Debería lanzar ExcepcionRuedaPinchada

            // Probar el método reparar para rueda2
            rueda2.reparar();
            rueda2.rodar(100000);

            // Probar el método print
            rueda1.print();
            rueda2.print();

            // Probar el método println
            rueda1.println();
            rueda2.println();
        } catch (ExcepcionRuedaPinchada e) {
            System.out.println(e.getMessage());
        }
    }

}
