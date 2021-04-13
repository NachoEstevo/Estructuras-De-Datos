package HorseMovement;

import DataStructures.Stacks.DynamicStack;
import java.util.Random;

public class Horse {
public Position position;
private Position[] possiblePositions;
int moveCounter = 0;
int maxMoves = 4;

    public Horse(Position initialPosition){
        this.position = initialPosition;
    }

    public Horse(){ }

    public void setInitialPosition(Position pos){
        this.position = pos;
    }

    public String move() throws OutOfMovesException { //Perform a random move out of the possible ones
        if (moveCounter < maxMoves){
            int pickAMove = (int) ((Math.random() * (getPossibleMoves().getSize())));
            this.position = possiblePositions[pickAMove]; //We updated the previous position with a random valid new one
        }
        else{ throw new OutOfMovesException("Your horse has already moved 4 times");}

        moveCounter++;
        return this.position.getPosition();
    }

    public DynamicStack<Position> getPossibleMoves(){
        possiblePositions = new Position[8];
        DynamicStack<Position> possibleMoves = new DynamicStack<>();

        possiblePositions[0] = new Position(position.getRow() -2, position.getColumn() +1);
        possiblePositions[1] = new Position(position.getRow() -2, position.getColumn() -1);
        possiblePositions[2] = new Position(position.getRow() -1, position.getColumn() +2);
        possiblePositions[3] = new Position(position.getRow() +1, position.getColumn() -2);
        possiblePositions[4] = new Position(position.getRow() +1, position.getColumn() +2);
        possiblePositions[5] = new Position(position.getRow() -1, position.getColumn() -2);
        possiblePositions[6] = new Position(position.getRow() +2, position.getColumn() +1);
        possiblePositions[7] = new Position(position.getRow() +2, position.getColumn() -1);

        for (int i = 0; i < 8; i++) {
            if(possiblePositions[i].isValid()){
                possibleMoves.push(possiblePositions[i]);
            }
        }
        return possibleMoves;
    }

    public String getCurrentPosition(){
        return this.position.getPosition();
    }
    public Position getPosition(){ return this.position;}

    public int getMoveCounter() {
        return moveCounter;
    }
}
