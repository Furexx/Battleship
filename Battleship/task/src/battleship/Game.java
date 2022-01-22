package battleship;


public class Game {

    private String shot;

    private int result;


    public void setShot(String shot) {
        this.shot = shot;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }


    public void fire(Field field,Field fog) {
        boolean isShotValid = false;
        int[] shotArr;

        while (!isShotValid ) {
            shotArr = toDigitShot(shot);
            try {
                isShotValid = validateShot(field, shotArr);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage() + " Try again");
            }
            if (isHit(field, shotArr, fog)) {
                int counter = 0;
                for (int i = 0; i < field.field.length; i++) {
                    for (int j = 0; j < field.field[i].length; j++) {
                        if (field.field[i][j] == 'O') {
                            counter++;
                        }
                    }
                }
                if (counter == 0) {

                    System.out.println("You sank the last ship. You won. Congratulations!");
                    setResult(2);
                    break;
                } else {
                    if (!isSank(field, shotArr)) {

                        System.out.println("You sank a ship! Specify a new target:");
                        setResult(1);

                    } else {

                        System.out.println("You hit a ship!");
                        setResult(1);
                    }

                }
            } else {

                System.out.println("You missed!");
                setResult(1);
            }
        }

    }

    private int[] toDigitShot(String shot){
        int[] result = new int[2];
        result[0] = shot.split(" ")[0].charAt(0)-65;
        result[1] = Integer.parseInt(shot.split(" ")[0].substring(1))-1;
        return result;
    }



    private boolean validateShot(Field field, int[] shot)throws ArrayIndexOutOfBoundsException{
        boolean isValid = true;
        if ((field.field.length < shot[0]) || (field.field.length <= shot[1])){
            throw new ArrayIndexOutOfBoundsException("Error! You entered the wrong coordinates!");
        }
        return isValid;
    }

    private static boolean isHit(Field field, int[] shot,Field fog){
        if(field.field[shot[0]][shot[1]] == 'O' || field.field[shot[0]][shot[1]] == 'X'){
            field.field[shot[0]][shot[1]] = 'X';
            fog.field[shot[0]][shot[1]] = 'X';
            return true;
        }else {
            field.field[shot[0]][shot[1]] = 'M';
            fog.field[shot[0]][shot[1]] = 'M';
            return false;
        }
    }

    private static boolean isSank(Field field, int[] shot) {
        int row = shot[0];
        int col = shot[1];
        if (col > 0) {
            if (field.field[row][col - 1] == 'O'){
                return true;
            }
            if (row > 0){
                if (field.field[row - 1][col] == 'O'){
                    return true;
                }
                if (field.field[row-1][col-1] == 'O'){
                    return true;
                }
            }

        }
        if (col < 9){
            if (field.field[row][col + 1] == 'O'){
                return true;
            }
            if (row > 0){
                if (field.field[row - 1][col] == 'O'){
                    return true;
                }
                if (field.field[row - 1][col+1] == 'O'){
                    return true;
                }
            }
            if (row < 9) {
                if (field.field[row +1][col] == 'O'){
                    return true;
                }
                return field.field[row + 1][col + 1] == 'O';
            }

        }
        return false;
    }
    public boolean gameOver(){
        return getResult() != 2;
    }
}
