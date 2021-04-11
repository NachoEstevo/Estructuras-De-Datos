package HorseMovement;

import DataStructures.Stacks.DynamicStack;

public class Horse {
String initialPosition;
Board aBoard = new Board();
int moveCounter = 0;
int maxMoves = 4;

    public Horse(String initialPosition){
        this.initialPosition = initialPosition;
    }
    public Horse(){ }

    public void setInitialPosition(String pos){
        this.initialPosition = pos;
    }

    public String move() throws OutOfMovesException {
        if (moveCounter < maxMoves){
            DynamicStack<String> possibleMoves = aBoard.moves(initialPosition);
        }
        else{ throw new OutOfMovesException("Your horse has already moved 4 times");}

        moveCounter++;
        return "todo";
    }


}
