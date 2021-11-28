package task;

public class ArmorDestroyer extends BattleUnitBase{
    public ArmorDestroyer (String name, int maxHealth, int baseStrength, int maxArmor){
        super(name, maxHealth, baseStrength, maxArmor);
    }
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam){
        int maxarmor = 0;
        BattleUnit battleunit = enemyTeam[0];
        for (int i = 0; i < enemyTeam.length; ++i){
            if (enemyTeam[i].maxArmor() > maxarmor && enemyTeam[i].health() > 0){
                maxarmor = enemyTeam[i].maxArmor();
                battleunit = enemyTeam[i];
            }
        }
        if (battleunit.armor() > 0){
            battleunit.damageArmor(strength() * 2);
        }
        else{
            battleunit.takeDamage(strength() / 4);
        }
    }
    public void attack(BattleUnit other){
        if (other.armor() > 0) {
            if(strength() / 4 > 0){
                other.takeDamage(strength() / 4);
            }
            else{
                other.takeDamage(1);
            }
            if(strength() > 0){
                other.damageArmor(strength());
            }
            else{
                other.takeDamage(1);
            }
        }
        else{
            other.takeDamage(strength() / 2);
        }
    }
}
