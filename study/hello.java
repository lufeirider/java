import java.io.*;

class test  
{
  public static class Fighter {
    public String name;
    public int health, damagePerAttack;
    public Fighter(String name, int health, int damagePerAttack) 
    {
      this.name = name;
      this.health = health;
      this.damagePerAttack = damagePerAttack;
    }
  }

  public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
  // Your code goes here. Have fun!
    while(true)
    {
      fighter2.health = fighter2.health - fighter1.damagePerAttack;
      if(fighter2.health<=0)
        return fighter1.name;
      fighter1.health = fighter1.health - fighter2.damagePerAttack;
      if(fighter1.health<=0)
        return fighter2.name;
     }
  }
  

  
	public static void main (String[] args) throws java.lang.Exception
	{

    String test = declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew");
    System.out.println(test);
    System.out.println("hi");
	}
}
