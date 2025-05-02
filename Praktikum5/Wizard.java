package Praktikum5;

public class Wizard extends Hero {
    public Wizard(String name, int health, int attackPower){
        super(name, health, attackPower);
    }

    @Override
    public void attack(){
        System.out.println(this.getName() + " menegeluarkan sihir dengan kekuatan " + attackPower + "!");
    }
    
}
