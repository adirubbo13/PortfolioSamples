import java.util.Scanner; //imports scanner

public class NBARPG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerName;

        System.out.println("Welcome to the NBA RPG!");
        System.out.print("Enter your player name: ");
        playerName = scanner.nextLine();

        Player player = new Player(playerName);

        System.out.println("Hello, " + player.getName() + "! You are a rookie NBA player.");
        System.out.println("Your goal is to become the best player in the league.");

        while (true) { //sets up repeating menu
            System.out.println("\n--- Menu ---");
            System.out.println("1. Train");
            System.out.println("2. Play a Game");
            System.out.println("3. Play a Season");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    player.train();
                    break;
                case 2:
                    player.playGame();
                    break;
                case 3:
                    player.playSeason();
                    break;
                case 4:
                    System.out.println("Thank you for playing!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

class Player {
    private String name;
    private int skillLevel;

    public Player(String name) {
        this.name = name;
        this.skillLevel = (int)(Math.random() * 35)+65; //generates a random overall for a player synonymous with 2k ratings
    }

    public String getName() {
        return name;
    }

    public void train() {
        System.out.println(name + " is training hard.");
        //Two branches are made so that 99 is the max level a player can reach
        if (skillLevel >= 99){
            System.out.println("You have reached the maxmium skill level, you are the best player in the league!");
        }
        if (skillLevel < 99){
            skillLevel++;
            System.out.println("Your skill level is now " + skillLevel + ".");
        }
    }

    public void playGame() {
        int GameScore = (int)(Math.random() * 100);
        if (skillLevel > GameScore) { //you win the game if your skill is greater than game score
            System.out.println(name + " played a great game and won!");
            System.out.println("Congratulations, you are getting better!");
        } else { //you lose statement
            System.out.println(name + " played a game but needs more training.");
            System.out.println("Your skill level is too low to win.");
        }
    }

    public void playSeason() {
        int winTotal = 0; //setup win counter
        int lossTotal = 0; //setup loss counter
        
        for (int gameNumber = 1; gameNumber <=82; gameNumber ++) {
            int GameScore = (int)(Math.random() * 100);
            if (skillLevel > GameScore) { //you win the game if your skill is greater than game score
                winTotal++; //Add a win to the record
            } else { //you lose statement
                lossTotal++; //add a loss to the record
            }
        }

        System.out.println("You finish the season with " + winTotal + " wins and " + lossTotal + " losses"); //end of season message

    }
}
