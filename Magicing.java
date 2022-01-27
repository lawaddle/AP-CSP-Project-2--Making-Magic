//player actions
//player spells and stats
//game ends if spells run out of uses or player runs out of hp
import java.util.Scanner;

public class Magicing
{
  private int hp = 400;
  private final int MAXHP = 400;
  private int def = 100;
  private int atk = 100;
  private boolean dead = false;
  private Maker make = new Maker();
  private Scanner scan = new Scanner(System.in);
  private Monster mon =  null;

  public Magicing() {}


//method that combines all other major method together (with a bit of extra logic), the method that goes into the Main class, named ahh because I am very worried this program may stop working
  public void ahh()
  {
    make.starter();
    System.out.println("Defeat as many monsters as you can. The game ends when you run out of hp or when you run out of uses for all of your spells.");
    makeMon();
    System.out.println();
    while(gameStop() == false)
    {
      if(mon.getMonHp() == 0) //why isn't this work =(
      {
        makeMon();
        System.out.println();
      }
      mainMenu();
    }
    endGame();

  }
//menu for game, Option to display spells, player stats, and monster stats, or play a turn
  public void mainMenu()
  {
    boolean lop = true;
    while(lop)
    {
      System.out.println("Do you want to: \nShow (S)pells \nShow (P)layer info \nShow (M)onster info \nor Play Your (T)urn");
      String picked = scan.nextLine();
      picked = picked.toLowerCase();
      if(picked.equals("s") || picked.equals("spells"))
      {
        printSpells(make.getSpells());
        System.out.println();
        lop = false;
      } else if(picked.equals("p") || picked.equals("player"))
      {
        System.out.println(showPlayerStats());
        System.out.println();
        lop = false;
      } else if(picked.equals("m") || picked.equals("monster"))
      {
        System.out.println(mon);
        System.out.println();
        lop = false;
      } else if(picked.equals("t") || picked.equals("turn"))
      {
        spellMenu();
        System.out.println();
        lop = false;
      } else
      {
        System.out.println("Invaild Option. Please pick again.");
      }
    }
  }

//menu and logic to choose a spell
  public void spellMenu()
  {
    Spell[] spells = make.getSpells();
    boolean loo = true;
    while(loo)
    {
      System.out.println("Choose what Spell to use: ");
      for (int i = 0; i < spells.length; i++) {
        System.out.println("Spell " + (i + 1) + ": " + spells[i].getName());
      }
      String notNum = scan.nextLine();
      if(notNum.equals("1") || notNum.equals("2") || notNum.equals("3") || notNum.equals("4"))
      {
        loo = false;
        int realNum = Integer.parseInt(notNum);
        realNum--;
        turnGO(realNum);
      } else
      {
        System.out.println("Invaild Option. Please pick again.");
      }
    }
  }

//determines if any spell has uses left
  public boolean anySpellLeft(Spell[] spells) //why does this not work
  {
    for (int i = 0; i < spells.length; i++) {
      if (spells[i].isUsable()) {
        return true;
      }
    }
    System.out.println("You can't use any more of your spells.");
    return false;

  }

//checks to see if the game should end(this happens if the player dies or they run out of spell uses)
  public boolean gameStop() //why does this not work
  {
    if (dead == true || anySpellLeft(make.getSpells()) == false) 
    {
       return true;
    }
    else{
      return false;
    }
  }

  public boolean isDead()
  {
    if (dead == true)
    {
      System.out.println("You died.");
      return true;
    } else
    {
      return false;
    }
  }


//logic and menus to make a monster 
  public void makeMon()
  {
    int monHP = 0;
    int monDef = 0;
    int monAtk = 0;
    boolean ah = true;
    while(ah)
    {
      System.out.println("Do you want to make \na (S)trong monster- with low defense and high attack, \na (T)anky monster- with low attack and high defense, \na (B)aby monster-with low attack and defense, or \na (M)ega monster-with high attack and defense");
      String choice = scan.nextLine();
      choice = choice.toLowerCase();
      if(choice.equals("s") || choice.equals("strong"))
      {
        ah = false;
        monAtk = 70;
        monDef = 50;
        monHP = 100;
        System.out.println("You will be fighting a strong monster.");
      } else if(choice.equals("t") || choice.equals("tanky"))
      {
        ah = false;
        monAtk = 50;
        monDef = 70;
        monHP = 100;
        System.out.println("You will be fighting a tanky monster.");
      } else if(choice.equals("b") || choice.equals("baby"))
      {
        ah = false;
        monAtk = 35;
        monDef = 35;
        monHP = 50;
        System.out.println("You will be fighting a baby monster.");
      } else if(choice.equals("m") || choice.equals("mega"))
      {
        ah = false;
        monAtk = 85;
        monDef = 85;
        monHP = 200;
        System.out.println("You will be fighting a mega monster.");
      } else
      {
        System.out.println("Invaild Option. Please pick again.");
      }
    }

    
    mon = new Monster(monHP, monDef, monAtk);
  }

//logic and math for each turn
  public void turnGO(int choice)
  {
    doSpell(choice);
    int hpOld = hp;
    int monDam = (int) (((70*(mon.getMonAtk()/def)/25) + 1));
    if(monDam <= 0)
    {
      monDam = 1;
    }
    hp -= monDam;
    if(hp <= 0)
    {
      hp = 0;
      dead = true;
    }
    System.out.println("The monster attacked and " + (hpOld-hp) + " amount of damage was done to you.");
  }

//logic for each spell to be done
  public void doSpell(int choice)
  {
    Spell choSpell = make.getSpell(choice);
    if(choSpell.isUsable())
    {
      int rep = 1;
      if(choSpell.getEffect().getEffect().equals("multi-hit"))
      {
        rep = (int) choSpell.getEffect().getPower();
      }
      for (int i = 1; i <= rep; i++) {
        int dam;
        dam = (int) ((((choSpell.getPower()* (atk/mon.getMonDef()))/25) + 1) * typeTriChange(choSpell.getType()));
        if(dam <= 0)
        {
          dam = 1;
        }
        mon.changeHp(dam);
        System.out.println("You used " + choSpell.getName() + ". It did " + dam + " damage.");
        
      }
      if(rep > 1)
      {
        System.out.println("The spell hit " + rep + " times.");
      }
      useSpellEffect(choSpell.getEffect());
      choSpell.setUses(choSpell.getUses() - 1);
    } else
    {
      System.out.println("You have ran out of uses for this spell");
    }
  }

//uses logic from typeEffect method to set values in the doSpell method
  public double typeTriChange(SpellType type)
  {
    double change = 1.0;
    if(typeEffect(type) == TypeTri.STRONG)
    {
      change = 1.25;
    } else if (typeEffect(type) == TypeTri.RESIST)
    {
      change = 0.75;
    } else if (typeEffect(type) == TypeTri.NEUTRAL)
    {
      change = 1.0;
    }
    return change;
  }

//logic to check and see if a move will be effective based on it's and the monster's type
  public TypeTri typeEffect(SpellType type)
  {
    SpellType monType = mon.getMonType();
    if(((monType == SpellType.FLAME) && (type == SpellType.SPLASH)) || (((monType == SpellType.GROWTH) && (type == SpellType.FLAME))) || (((monType == SpellType.SPLASH) && (type == SpellType.GROWTH))))
    {
      return TypeTri.STRONG;
    } else if (((type == SpellType.FLAME) && (monType == SpellType.SPLASH)) || (((type == SpellType.GROWTH) && (monType == SpellType.FLAME))) || (((type == SpellType.SPLASH) && (monType == SpellType.GROWTH))))
    {
      return TypeTri.RESIST;
    } else
    {
      return TypeTri.NEUTRAL;
    }
  }

//logic for doing a spell effect
  public void useSpellEffect(SpellEffect effect)
  {
    String spellName = effect.getEffect();
    if(spellName.equals("ATK change"))
    {
      if(effect.getEffectTarget() == EffectTarget.PLAYER)
      {
        int oldAtk = atk;
        atk*=effect.getPower();
        System.out.println("Your attack increased by " + (atk-oldAtk));
      } else
      {
        int oldMonAtk = mon.getMonAtk();
        mon.setMonAtk((int)(mon.getMonAtk()*effect.getPower()));
        System.out.println("The monster attack decreased by " + (oldMonAtk - mon.getMonAtk()));
      }
    } else if(spellName.equals("DEF change"))
    {
      if(effect.getEffectTarget() == EffectTarget.PLAYER)
      {
        int oldDef = def;
        def*=effect.getPower();
        System.out.println("Your defense increased by " + (def-oldDef));
      } else
      {
        int oldMonDef = mon.getMonDef();
        mon.setMonDef((int)(mon.getMonDef()*effect.getPower()));
        System.out.println("The monster defense decreased by " + (oldMonDef - mon.getMonDef()));
      }
    } else if(spellName.equals("heal"))
    {
      int oldHp = hp;
      hp+=(int) effect.getPower();
      if(hp > MAXHP)
      {
        hp = MAXHP;
      }
      System.out.println("Your hp increased by " + (hp-oldHp));
    }
    
  }

  public String showPlayerStats()
  {
    String str = "";
    str+= make.getName() + "'s stats:\n";
    str+= "HP: " + hp + "\n";
    str+= "ATK: " + atk + "\n";
    str+= "DEF: " + def;
    return str;

  }

  public void printSpells(Spell[] spells)
  {
    for (int i = 0; i < spells.length; i++) {
      System.out.println("Spell " + (i+1) + ":");
      System.out.println(spells[i]);
      System.out.println();
    }

  }

  public void endGame()
  {
    System.out.println("Wow! You defeated " + Monster.getMonsKilled() + " monsters!");
    System.out.println("You did " + Monster.getTotalDamage() + " damage to all the monsters you fought.");
  }
  

  
}