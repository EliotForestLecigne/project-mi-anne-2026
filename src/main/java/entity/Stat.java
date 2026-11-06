package entity;

public class Stat {
    private int maxHP;
    private int maxMP;
    private int strength;
    private int defence;
    private int agility;
    private int evasionRate;
    private int luck;


    public Stat(){ //used for tempStat
        this.maxHP = 0;
        this.maxMP = 0;
        this.strength = 0;
        this.defence = 0;
        this.agility = 0;
        this.evasionRate = 0;
        this.luck = 0;
    }

    public Stat(int maxHP, int maxMP, int strength, int defence, int agility, int evasionRate, int luck) {
        this.maxHP = maxHP;
        this.maxMP = maxMP;
        this.strength = strength;
        this.defence = defence;
        this.agility = agility;
        this.evasionRate = evasionRate;
        this.luck = luck;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getEvasionRate() {
        return evasionRate;
    }

    public void setEvasionRate(int evasionRate) {
        this.evasionRate = evasionRate;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getDefence() {
        return defence;
    }

    public void addStat(int maxHP, int maxMP, int strength, int defence, int agility, int evasionRate){
        this.maxHP += maxHP;
        this.maxMP += maxMP;
        this.strength += strength;
        this.defence += defence;
        this.agility += agility;
        this.evasionRate += evasionRate;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
}
