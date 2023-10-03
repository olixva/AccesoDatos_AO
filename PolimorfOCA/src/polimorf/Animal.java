package polimorf;

public class Animal {
    private int health = 100;
    private String tipo;

    public Animal(String tipo) {
        this.tipo = tipo;
    }

    public Animal() {
        this.tipo = "Animal";
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String aCadena() {
        String exit = "";

        exit += this.getClass().getName() + " Tipo: " + this.tipo + " Salud: " + this.health;
        return exit;
    }

    public void visualiza() {
        System.out.println(this.aCadena());
    }
}
