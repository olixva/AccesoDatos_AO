package polimorf;

public class TestPolimorf {

    public static void main(String[] args) {
        Cat c3;
        Animal elefante = new Mammal("Elefante");
        
        Cat c = new Cat();
        c.visualiza();

        Dog d = new Dog("Gigante");
        d.visualiza();

        Cat c2 = new Cat();
        c2.visualiza();

        Mammal m = c2;
        c3 = (Cat) m;
        m.visualiza();
        c3.visualiza();

        c2.setHealth(60);
        c2.visualiza();

        elefante.visualiza();


    }

}
