public class Ant extends Insects{

    String ant_type;

    public Ant(String ant_type, String type, int legs, boolean wings, int health, int attack, int defense) {
        super(type, legs, wings, health, attack, defense);
        this.set_ant_type(ant_type);
    }

    public void set_ant_type(String ant_type) {
        this.ant_type = ant_type;
    }
}
