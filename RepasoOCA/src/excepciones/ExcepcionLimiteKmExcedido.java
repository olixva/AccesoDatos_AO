package excepciones;

public class ExcepcionLimiteKmExcedido extends Exception {

    public ExcepcionLimiteKmExcedido() {
        super("El limite de KM ha sido excedido");
    }
}
