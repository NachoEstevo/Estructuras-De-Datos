package HorseMovement;

import DataStructures.Stacks.DynamicStack;

public class Horse {
public Position position;
private Position[] possiblePositions;
int moveCounter = 0;
int maxMoves = 4;

    public Horse(Position initialPosition){
        this.position = initialPosition;
    }

    public Horse(){this.position = null; }

    public void setInitialPosition(Position pos){
        this.position = pos;
    }

    public String move(Position aPosition) throws OutOfMovesException, OutOfBoardException {//We couldnt get a random element from the stack so it wouldn't be repetitive.
        if (moveCounter < maxMoves){
            this.position = aPosition;
            //int pickAMove = (int) ((Math.random() * (getPossibleMoves().getSize())));
            //this.position = possiblePositions[pickAMove]; //We updated the previous position with a random valid new one
        }
        else{ throw new OutOfMovesException("Your horse has already moved 4 times");}
        moveCounter++;
        return this.position.getPosition();
    }

    public DynamicStack<Position> getPossibleMoves() {
        possiblePositions = new Position[8];
        DynamicStack<Position> possibleMoves = new DynamicStack<>();

        possiblePositions[0] = new Position(this.position.getColumn(), this.position.getColumn() +1);
        possiblePositions[1] = new Position(this.position.getColumn() -2, this.position.getRow() -1);
        possiblePositions[2] = new Position(this.position.getColumn() -1, this.position.getRow() +2);
        possiblePositions[3] = new Position(this.position.getColumn() +1, this.position.getRow() -2);
        possiblePositions[4] = new Position(this.position.getColumn() +1, this.position.getRow() +2);
        possiblePositions[5] = new Position(this.position.getColumn() -1, this.position.getRow() -2);
        possiblePositions[6] = new Position(this.position.getColumn() +2, this.position.getRow() +1);
        possiblePositions[7] = new Position(this.position.getColumn() +2, this.position.getRow() -1);

        for (int i = 0; i < 8; i++) {
            if(possiblePositions[i].isValid()){
                possibleMoves.push(possiblePositions[i]);
            }
        }
        return possibleMoves;
    }

    public String getCurrentPosition() throws OutOfBoardException {
        if (this.position != null) {
            return this.position.getPosition();
        }else{
            return "";
        }
    }
    public Position getPosition(){ return this.position;}

    public int getMoveCounter() {
        return moveCounter;
    }
}
