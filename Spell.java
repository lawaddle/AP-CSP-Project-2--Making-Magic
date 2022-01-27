public class Spell
{
  private SpellType type;
  private SpellStrength grr;
  private String name;
  private SpellEffect effect;
  private int power;
  private int uses = 0;
  private boolean usable = true;
  

  public Spell(String name, SpellType type, SpellStrength grr, SpellEffect effect)
  {
    this.name = name;
    this.type = type;
    this.grr = grr;
    this.effect = effect;

    //spell power chosen randomly based on user input
    //spell uses chosen based on spell power and spell effect power
    if(this.grr == SpellStrength.STRONG)
    {
      uses+=5;
      power = randomizer(75, 60);
    } else if (this.grr == SpellStrength.MODERATE)
    {
      uses+=10;
      power = randomizer(50, 30);
    } else
    {
      uses+=15;
      power = randomizer(20, 5);
    }

    if(effect.getStrength() == EffectStrength.WEAK)
    {
      uses*=2;
    }
    
  
  }

  public SpellType getType()
  {
    return type;
  }

  public SpellStrength getStrength()
  {
    return grr;
  }

  public int getPower()
  {
    return power;
  }

  public String getName()
  {
    return name;
  }

  public SpellEffect getEffect()
  {
    return effect;
  }

  public int getUses()
  {
    return uses;
  }

  public void setUses(int newUses)
  {
    uses = newUses;
    if(uses <= 0)
    {
      usable = false;
    }
  }

  public boolean isUsable()
  {
    return usable;
  }



  public static int randomizer(int max, int min)
  {
    return (int)(Math.random()*(max-min+1)+min);
  }

  public String toString()
  {
    return "Spell Name: " + name + "\nSpell Type: " + type + "\nSpell Strength: " + grr + "\nEffect: " + effect + "\nPower: " + power + "\nUses: " + uses + "\nUsable: " + usable;
  }


}