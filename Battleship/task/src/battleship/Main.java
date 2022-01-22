package battleship;

import java.util.Scanner;

import static battleship.Player.promptEnterKey;

public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player player1 = new Player("Player 1");
        player1.setField();

        Player player2 = new Player("Player 2");
        player2.setField();


            while (player1.game.gameOver() || player2.game.gameOver()){
                player2.fog.print();
                System.out.println("---------------------");
                player1.field.print();
                System.out.printf("%s, it's your turn:\n",player1.name);
                player2.game.setShot(scanner.nextLine());
                player2.game.fire(player2.field, player2.fog);
                promptEnterKey();

                player1.fog.print();
                System.out.println("---------------------");
                player2.field.print();
                System.out.printf("%s, it's your turn:\n",player2.name);
                player1.game.setShot(scanner.nextLine());
                player1.game.fire(player1.field, player2.fog);
                promptEnterKey();

        }


    }
}
