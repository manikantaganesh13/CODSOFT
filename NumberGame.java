import java.util.*;

class NumberGame{
    public static void main(String[] args){
        int play = 1;
        while(play != 0){
            Random rand = new Random();
            int rand_num = rand.nextInt(100);

            Scanner sc = new Scanner(System.in);

            int attempts = 0;

            while(true){
                System.out.println("Enter your guess number: ");
                int num = sc.nextInt();
                attempts++;
                if(num == rand_num){
                    System.out.println("Congratulations, your guess is correct");
                    System.out.println("You have guessed the number in "+attempts+" attempts");
                    System.out.println("Do you want to play again-->\nPress 1 to play again (or) Press 0 to end the game");
                    play = sc.nextInt();
                    if(play == 1)
                        break;

                    if(play == 0){
                        System.out.println("Exiting from the game....");
                        System.exit(0);
                    }
                }
                    
                else if(num < rand_num)
                    System.out.println("Your guess is too low");

                else if(num > rand_num)
                    System.out.println("Your guess is too high");
            }
        }
    }
}