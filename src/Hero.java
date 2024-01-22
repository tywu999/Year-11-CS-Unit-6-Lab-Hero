public class Hero {
    private String name;
    private int hitPoints;
    public Hero (String name){
        this.hitPoints = 100;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getHitPoints(){
        return hitPoints;
    }
    public String toString(){
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }
    public void attack(Hero opponent){
        double randomNum = Math.random()*100;
        if(randomNum < 50){
            this.hitPoints = hitPoints - 10;
        }
        else{
            opponent.hitPoints = opponent.hitPoints - 10;
        }
    }
    public void senzuBean(){
        hitPoints = 100;
    }
    private void fightUntilTheDeathHelper(Hero opponent){
        while(hitPoints> 0 && opponent.hitPoints > 0){
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent){
        opponent.hitPoints = 100;
        hitPoints = 100;
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + "      " + opponent.name + ": " + opponent.hitPoints;
    }
    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int[] record = new int[n];
        for(int i = 0; i < n; i++){
            fightUntilTheDeath(opponent);
            if(hitPoints > 0){
                record[i] = 1;
            }
            else{
                record[i] = 0;
            }
            hitPoints = 100;
            opponent.hitPoints = 100;
        }
        return record;
    }
    public String nFightsToTheDeath(Hero opponent, int n){
        int[] record = nFightsToTheDeathHelper(opponent, n);
        int opps = 0;
        int me = 0;
        for(int i = 0; i < n; i++){
            if(record[i] == 0){
                opps++;
            }
            else{
                me++;
            }
        }
        String a;
        if(me > opps){
            a = name;
        }
        else{
            a = opponent.name;
        }
        return name + ": " + me + " wins" + "/n" + opponent.name + ": " + opps + " wins" + "/n" + a + " wins!";
    }
    public void dramaticFightToTheDeath(Hero opponent){
        opponent.hitPoints = 100;
        hitPoints = 100;
        while(hitPoints> 0 && opponent.hitPoints > 0){
            attack(opponent);
            System.out.println(name + ": " + hitPoints + "     " + opponent.name + ": " + opponent.hitPoints);
        }
        if(opponent.hitPoints == 0){
            System.out.println(name + " wins!");
        }
        else{
            System.out.println(opponent.name + " wins!");
        }
    }


}
