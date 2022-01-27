import java.util.Scanner;

public class Maker
{

  private String makerName ="";
  private Spell[] spells = new Spell[4];
  
 
  private Scanner scan = new Scanner(System.in);

  public Maker()
  {

  }


  public void starter()
  {
    System.out.print("What's your name: ");
    makerName = scan.nextLine();

    multipleSpells();

  }

  //does the spellMaker method multiple times
  private void multipleSpells()
  {
    for (int i = 0; i < spells.length; i++) {
      System.out.println("Make spell #" + (i+1));
      spellMaker(i);
      System.out.println();
    }
  }

  //combines menu methods to make a spell
  private void spellMaker(int idx)
  {

    String name = makeSpellName();
    SpellType type = chooseType();
    SpellStrength grr = chooseStrength();
    SpellEffect effect = chooseEffect();


    Spell spell = new Spell(name, type, grr, effect);

    spells[idx] = spell;

  }

  private String makeSpellName()
  {
    System.out.print("Enter spell name: ");
    return scan.nextLine();

  }

  //menu to choose spell type for the spell
  private SpellType chooseType()
  {
    SpellType type = null;
    while(type == null)
    {
      System.out.println("Choose a type for the spell. \n(S)PLASH\n(F)LAME\n(G)ROWTH");
      String choice = scan.nextLine();
      choice = choice.toLowerCase();
      if(choice.equals("s") || choice.equals("splash"))
      {
        type = SpellType.SPLASH;
        System.out.println("The type you have chosen for your spell is " + type + ".");
      } else if(choice.equals("f") || choice.equals("flame"))
      {
        type = SpellType.FLAME;
        System.out.println("The type you have chosen for your spell is " + type + ".");
      } else if(choice.equals("g") || choice.equals("growth"))
      {
        type =  SpellType.GROWTH;
        System.out.println("The type you have chosen for your spell is " + type + ".");
      } else
      {
        System.out.println("Invaild Option. Please pick again.");
      }
    }
    return type;
  }

  //menu to choose strength for the spell
  private SpellStrength chooseStrength()
  {
    SpellStrength strength = null;
    while(strength == null)
    {
      System.out.println("Choose a strength for the spell. \n(S)TRONG \n(M)ODERATE \n(W)EAK");
      String choice = scan.nextLine();
      choice = choice.toLowerCase();
      if(choice.equals("s") || choice.equals("strong"))
      {
        strength = SpellStrength.STRONG;
        System.out.println("You have made your spell a " + strength + " spell. It will be quite powerful.");
      } else if(choice.equals("m") || choice.equals("moderate"))
      {
        strength = SpellStrength.MODERATE;
        System.out.println("You have given this spell a " + strength + " amount of power.");
      } else if(choice.equals("w") || choice.equals("weak"))
      {
        strength =  SpellStrength.WEAK;
        System.out.println("You have made your spell a " + strength + " spell. It won't be that strong.");
      } else
      {
        System.out.println("Invaild Option. Please pick again.");
      }
    }
    return strength;
  }
  
  //menu to choose effect for the spell
  private SpellEffect chooseEffect()
  {
    String effect = "";
    EffectTarget target = null;
    double power = 0;
    EffectStrength strength = null;

    while(effect.equals(""))
    {
      System.out.println("Choose an effect for the spell. \n(A)ttack Change \n(D)efense Change \n(H)eal \n(M)ulti-Hit");
      String choice = scan.nextLine();
      choice = choice.toLowerCase();
      if(choice.equals("a") || choice.equals("attack change"))
      {
        effect = "ATK change";
        while(target == null)
        {
          System.out.println("Do you want to improve the (p)layer's stats or lower the (e)nemy's?");
          String option = scan.nextLine();
          option = option.toLowerCase();
          if(option.equals("e") || option.equals("enemy"))
          {
            target = EffectTarget.ENEMY;
          } else if (option.equals("p") || option.equals("player"))
          {
            target = EffectTarget.PLAYER;
          } else 
          {
            System.out.println("Invaild Option. Please pick again.");
          }
        }
        while(power == 0)
        {
          System.out.println("Do you want the stat change to be by a (b)ig amount or a (s)mall amount?");
          String picker = scan.nextLine();
          picker = picker.toLowerCase();
          if(picker.equals("b") || picker.equals("big"))
          {
            if(target == EffectTarget.PLAYER)
            {
              power = 1.4;
            } else
            {
              power = 0.6;
            }
            strength = EffectStrength.STRONG;
          } else if (picker.equals("s") || picker.equals("small"))
          {
            if(target == EffectTarget.PLAYER)
            {
              power = 1.15;
            } else
            {
              power = 0.85;
            }
            strength = EffectStrength.WEAK;
          } else 
          {
            System.out.println("Invaild Option. Please pick again.");
          }
        }
        System.out.println("This spell will have the added effect of " + effect + " target the " + target + " and the effect's strength will be " + strength + ".");
      } else if (choice.equals("d") || choice.equals("defence change"))
      {
        effect = "DEF change";
        while(target == null)
        {
          System.out.println("Do you want to improve the (p)layer's stats or lower the (e)nemy's?");
          String option = scan.nextLine();
          option = option.toLowerCase();
          if(option.equals("e") || option.equals("enemy"))
          {
            target = EffectTarget.ENEMY;
          } else if (option.equals("p") || option.equals("player"))
          {
            target = EffectTarget.PLAYER;
          } else 
          {
            System.out.println("Invaild Option. Please pick again.");
          }
        }
        while(power == 0)
        {
          System.out.println("Do you want the stat change to be by a (b)ig amount or a (s)mall amount?");
          String picker = scan.nextLine();
          picker = picker.toLowerCase();
          if(picker.equals("b") || picker.equals("big"))
          {
            if(target == EffectTarget.PLAYER)
            {
              power = 1.4;
            } else
            {
              power = 0.6;
            }
            strength = EffectStrength.STRONG;
          } else if (picker.equals("s") || picker.equals("small"))
          {
            if(target == EffectTarget.PLAYER)
            {
              power = 1.15;
            } else
            {
              power = 0.85;
            }
            strength = EffectStrength.WEAK;
          } else 
          {
            System.out.println("Invaild Option. Please pick again.");
          }
        }
        System.out.println("This spell will have the added effect of " + effect + " target the " + target + " and the effect's strength will be " + strength + ".");
      } else if (choice.equals("h") || choice.equals("heal"))
      {
        effect = "heal";
        target = EffectTarget.PLAYER;
        while(power == 0)
        {
          System.out.println("Do you want to be healed a (b)ig amount or a (s)mall amount?");
          String option = scan.nextLine();
          option = option.toLowerCase();
          if(option.equals("b") || option.equals("big"))
          {
            power = 40;
            strength = EffectStrength.STRONG;
          } else if (option.equals("s") || option.equals("small"))
          {
            power = 20;
            strength = EffectStrength.WEAK;
          } else 
          {
            System.out.println("Invaild Option. Please pick again.");
          }
        }
        if(strength == EffectStrength.STRONG)
        {
          System.out.println("This spell will have the added effect of " + effect + ". The spell will heal the " + target + " a lot.");
        } else
        {
          System.out.println("This spell will have the added effect of " + effect + ". The spell will heal the " + target + " a small amount.");
        }
      } else if (choice.equals("m") || choice.equals("multi-hit"))
      {
        effect = "multi-hit";
        target = EffectTarget.ENEMY;
        while(power == 0)
        {
          System.out.println("Do you want the move to hit a (f)ew times or (m)any times?");
          String option = scan.nextLine();
          option = option.toLowerCase();
          if(option.equals("m") || option.equals("many"))
          {
            power = 4;
            strength = EffectStrength.STRONG;
          } else if (option.equals("f") || option.equals("few"))
          {
            power = 2;
            strength = EffectStrength.WEAK;
          } else 
          {
            System.out.println("Invaild Option. Please pick again.");
          }
        }
        if(strength == EffectStrength.STRONG)
        {
          System.out.println("This spell will have the added effect of " + effect + ". The spell will hit the " + target + " many times.");
        } else
        {
          System.out.println("This spell will have the added effect of " + effect + ". The spell will hit the " + target + " a few times.");
        }
      } else
      {
        System.out.println("Invaild Option. Please pick again.");
      }
    }

    SpellEffect effecting = new SpellEffect(effect, target, power, strength);

    return effecting;
    
    
  }

  public String getName()
  {
    return makerName;
  }

  public Spell[] getSpells()
  {
    return spells;
  }

  public Spell getSpell(int i)
  {
    return spells[i];
  }
  
}