//one attack
//type resists or weak to a spell type,
public class Monster
{
 private int hp;
 private int def;
 private int atk;
 private SpellType monsterType;
 private static int totalDamage = 0;
 private static int monstersKilled = 0;
 private boolean dead = false;

 public Monster(int hp, int def, int atk)
 {
   this.hp = hp;
   this.def = def;
   this.atk = atk;
   int rand = Spell.randomizer(3, 1);
   //type for the monster chosen randomly
   if(rand == 1)
   {
     monsterType = SpellType.SPLASH;
   } else if (rand == 2)
   {
     monsterType = SpellType.FLAME;
   } else
   {
     monsterType = SpellType.GROWTH;
   }
   
 }

 public SpellType getMonType()
 {
   return monsterType;
 }

 public int getMonHp()
 {
   return hp;
 }

 public int getMonAtk()
 {
   return atk;
 }

 public int getMonDef()
 {
   return def;
 }

 public boolean isDead()
 {
   return dead;
 }

 public static int getMonsKilled()
 {
   return monstersKilled;
 }

 public static int getTotalDamage()
 {
   return totalDamage;
 }

 public void setMonAtk(int newAtk)
 {
   atk = newAtk;
   if (atk <= 0)
   {
     atk = 1;
   }
 }

 public void setMonDef(int newDef)
 {
   def = newDef;
   if (def <= 0)
   {
     def = 1;
   }
 }

 public void changeHp(int damage)
 {
   int oldHp = hp;
   hp-= damage;
   if(hp <= 0)
   {
     hp = 0;
     dead = true;
     monstersKilled++;
     totalDamage+= oldHp;
   } else
   {
     totalDamage+= damage;
   }
 }

 public String toString()
 {
   String str = "";
    str+= "Monster HP: " + hp + "\n";
    str+= "Monster ATK: " + atk + "\n";
    str+= "Monster DEF: " + def + "\n";
    str+= "Monster Type: " + monsterType + "\n";
    str+= "Monster Dead: " + dead;
    return str;
 }


}