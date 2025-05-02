package Praktikum5;

public class Fighter extends Hero {
    public Fighter(String name, int health, int attackPower){
        super(name, health, attackPower);
    }

    @Override
    public void attack(){
        System.out.println(this.getName() + " ba pukul dengan kekuatan " + attackPower + "!");
    }
    
}
