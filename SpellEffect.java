//String for all types of spell effects (attack change, defense change, multi-hit, heal)
//int for level of power for spell effect (maybe)
//boolean for who the spell will be targeting
public class SpellEffect
{
  String effect;
  EffectTarget target;
  double power;
  EffectStrength strength; //power but in words

  public SpellEffect(String effect, EffectTarget target, double power,EffectStrength strength)
  {
    this.effect = effect;
    this.target = target;
    this.power = power;
    this.strength = strength;
  }

  public String getEffect()
  {
    return effect;
  }

  public EffectTarget getEffectTarget()
  {
    return target;
  }

  public double getPower()
  {
    return power;
  }

  public EffectStrength getStrength()
  {
    return strength;
  }

  public String toString()
  {
      return "Spell effect of " + effect + " targets the " + target + " with a power of " + power + "";

  }

  
  

  
}