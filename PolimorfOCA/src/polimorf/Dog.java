package polimorf;

public class Dog extends Mammal{
    private String size;

    public Dog(String size) {
        super("Perro");
        this.size = size;
    }

    @Override
    public String aCadena() {
        String exit = super.aCadena();
        exit += " Talla: " + this.size;

        return exit;
    }
}
