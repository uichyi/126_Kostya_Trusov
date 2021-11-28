package task;

public class Alchemist extends BattleUnitBase{
    public Alchemist (String name, int maxHealth, int baseStrength, int maxArmor){
        super(name, maxHealth, baseStrength, maxArmor);
    }
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam){
        int minH = 1000;
        int maxH = 0;
        BattleUnit BUmin = ownTeam[0];
        BattleUnit BUmax = ownTeam[0];
        for (int i = 0; i < ownTeam.length; ++i){
            if (ownTeam[i].health() < minH && ownTeam[i].health() > 0){
                minH = ownTeam[i].health();
                BUmin = ownTeam[i];
            }
            else if (ownTeam[i].health() > maxH){
                maxH = ownTeam[i].health();
                BUmax = ownTeam[i];
            }
        }
        BUmin.heal(10);
        BUmax.setStrength(BUmax.strength() + 1);
    }
    public void attack(BattleUnit other){
        other.setStrength(other.strength() - 2);
        other.setMaxHealth(other.maxHealth() - 4);
    }
}
