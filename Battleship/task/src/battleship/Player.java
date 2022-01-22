package battleship;

import java.io.IOException;
import java.util.Scanner;

public class Player {

    Field field = new Field();
    Field fog = new Field();
    Game game = new Game();
    String name;


    public Player(String name){
        this.name = name;
    }

    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setField(){
        System.out.printf("%s, place your ships to the game field\n",name);
        field.print();
        for (Ship ship : Ship.values()) {
            field.setShip(ship);
            field.print();
        }
        promptEnterKey();
    }


    public void nextTurn(){
        Scanner scanner = new Scanner(System.in);
        fog.print();
        System.out.println("---------------------");
        field.print();
        System.out.printf("%s, it's your turn:\n",name);
        game.setShot(scanner.nextLine());
        game.fire(field, fog);
        promptEnterKey();
    }



}
