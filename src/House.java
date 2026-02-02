import java.util.Random;

public class House {
    public String message = "A7#q 9mA$%2mn!!8my@4mt^6mh&1mi*3mn(0mgZ9m 4wfymt@7mh# 5ma$2mt!8m mmma%3mk^4me&6ms*1m Q12mm &2-me#7m mc$9mu!5mt@8m 6hM.mt^4mh&6me *3m R7mc@2mh#9me$5me!832ms^4me&6m.";
//Anything
    mouseFood[] mousePantry = new mouseFood[18];
    public static void main(String[] args) {
        new House();
    }

    public House() {
        System.out.println("Hello, mouse! Get out of my house!");
        for (int i = 0; i < mousePantry.length; i++) {
            Random rand = new Random();
            mousePantry[i] = new mouseFood(rand.nextInt(200)+1, rand.nextInt(491)+10);
        }
        displayMousePantry();
        decipher(message);
        System.out.println(decipher(message));
        System.out.println("testing make smells");
        makeSmells();
        checkServings();
        checkSmell();
        if (checkServings()){
            System.out.println("there were matching servings");
        }
        else{
            System.out.println("there were not matching servings");
        }
        if (checkSmell()){
            System.out.println("there were matching smells");
        }
        else{
            System.out.println("there were not matching smells");
        }
        displayMousePantry();
    }


    public void displayMousePantry() {
        for (int i=0; i < mousePantry.length;i++){
            mousePantry[i].printInfo();
        }
    }

    public void makeSmells() {
        boolean unique = true;
        for (int i = 0; i < mousePantry.length+1; i++){
            for (int j = i+1; j < mousePantry.length; j++){
                if (mousePantry[i].getSmellFactor() == mousePantry[j].getSmellFactor()){
                    unique = false;
                    Random rand = new Random();
                    mousePantry[j] = new mouseFood(rand.nextInt(200)+1, rand.nextInt(491)+10);
                    System.out.println("changed one!");
                    i=0;
                    j=0;
                    System.out.println("back to zero!");
                    unique = true;
                }
            }
        }
    }

    public boolean checkServings() {

        for(int i = 0; i < mousePantry.length; i++){
            for(int j = i+1; j < mousePantry.length; j++){
                if (mousePantry[i].getServings() == mousePantry[j].getServings()){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSmell() {

        for(int i = 0; i < mousePantry.length; i++){
            for(int j = i+1; j < mousePantry.length; j++){
                if (mousePantry[i].getSmellFactor() == mousePantry[j].getSmellFactor()){
                    return true;
                }
            }
        }
        return false;
    }

    public String decipher(String hidden) {
        String hiddenmessage = "";
        int index = hidden.indexOf("m");

        while (index != -1) {
            hiddenmessage += (hidden.charAt(index + 1));
            index = hidden.indexOf("m", index + 2);
        }
        return(hiddenmessage);
    }

     public class mouseFood {
        private int servings = 0;
        private int smellFactor = 0;

        public mouseFood(int servings, int smellFactor) {
            this.servings = servings;
            this.smellFactor = smellFactor;
        }
         public int getServings() {
             return servings;
         }

         public void setServings(int servings) {
             this.servings = servings;
         }

         public int getSmellFactor() {
             return smellFactor;
         }

         public void setSmellFactor(int smellFactor) {
             this.smellFactor = smellFactor;
         }

         public void printInfo() {
             System.out.println("smellFactor is: " + smellFactor);
             System.out.println("servings is: " + servings);
         }
     }

}