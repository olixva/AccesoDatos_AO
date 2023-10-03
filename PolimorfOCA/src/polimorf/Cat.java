package polimorf;

public class Cat extends Mammal {
    private int lifes = 7;

    public Cat(String tipo) {
        super(tipo);
    }

    public Cat() {
        super("Gato");
    }

    @Override
    public String aCadena() {
        String exit = super.aCadena();
        exit += " Numero de vidas: " + this.lifes;

        return exit;
    }
}
