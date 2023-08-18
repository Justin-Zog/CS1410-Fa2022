public class Insects {

    private String type;
    private int legs;
    private boolean wings;
    private int health;
    private int attack;
    private int defense;

    public Insects(String type, int legs, boolean wings, int health, int attack, int defense) {
        this.setType(type);
        this.setLegs(legs);
        this.setWings(wings);
        this.setHealth(health);
        this.setAttack(attack);
        this.setDefense(defense);
    }

    public int getLegs() {
        return legs;
    }

    public boolean isWings() {
        return wings;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setWings(boolean wings) {
        this.wings = wings;
    }

    @Override
    public String toString() {

        return "This is a " + this.getType() + " it has " + this.getHealth() + " health, "
                + this.getAttack() + " attack, and " + this.getDefense() + " defense.";
    }

}
