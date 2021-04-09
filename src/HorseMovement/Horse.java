package HorseMovement;

import DataStructures.Stacks.EmptyStackException;
import DataStructures.Stacks.StaticStack;

public class Horse {
    private StaticStack<Cell> stack1;
    private StaticStack<Cell> stack2;
    private StaticStack<Cell> stack3;
    private StaticStack<Cell> stack4;
    private Cell initialCell;
    public Horse() {
        stack1 = new StaticStack<>(8);
        stack2 = new StaticStack<>(8);
        stack3 = new StaticStack<>(8);
        stack4 = new StaticStack<>(8);
        this.initialCell = new Cell(1,'A');
        stack1.push(initialCell);
       /*this.initialCell = initialCell;
       try{
           if(!isValid(initialCell)){
               throw new RuntimeException();
           }
       }catch(Exception e){
           System.out.println("Your cell is out of reach");
       }*/
    }

    public boolean isValid(Cell cell){
        if(cell.getRow() > 0 &&  cell.getRow() < 9 && (int) cell.getCol() > 64 && (int) cell.getCol() < 73){
            return true;
        }
        return false;
    }

    public void horseMovement(Cell cell, int moveRow, int moveCol) throws EmptyStackException {
        Cell newCell = new Cell(cell.getRow(), cell.getCol());
        newCell.sumRow(moveRow);
        newCell.sumCol(moveCol);
        if (isValid(newCell)) {
            if (!newCell.equals(initialCell) && cell.equals(initialCell)) {
                stack1.push(newCell);
            }
            else if (cell.equals(stack1.peek()) && !newCell.equals(stack1.peek())) {
                stack2.push(newCell);
            }
            else if (cell.equals(stack2.peek()) && !newCell.equals(stack2.peek()) && !newCell.equals(stack1.peek())) {
                stack3.push(newCell);
            }
            else if (cell.equals(stack3.peek()) && !newCell.equals(stack3.peek())&& !newCell.equals(stack2.peek())) {
                stack4.push(newCell);
            }

        }
    }
    public void fillStacks(Cell cell) throws EmptyStackException {
        horseMovement(cell, 2, 1);
        horseMovement(cell, 2, -1);
        horseMovement(cell, 1,2);
        horseMovement(cell, 1,-2);
        horseMovement(cell, -2, -1);
        horseMovement(cell, -2, 1);
        horseMovement(cell, -1,-2);
        horseMovement(cell, -1,2);

    }
    public void fillStacks() throws EmptyStackException {
        fillStacks(initialCell);
        for (int i = 0; i < 3; i++) {
            fillStacks(stackIndex(i).peek());
        }
    }
    public StaticStack<Cell> stackIndex(int index) {
        if (index == 0) {
            return stack1;
        }
        if (index == 1) {
            return stack2;
        }
        if (index == 2) {
            return stack3;
        }
        return null;
    }
    public void printMovements() throws EmptyStackException {
        System.out.println(stack1.peek().toString() + stack2.peek().toString() + stack3.peek().toString() + stack4.peek().toString());
    }
    public void show4Movements() throws EmptyStackException {
        for (int i = 0; i < 10; i++) {
            if (!stack4.isEmpty()){
                printMovements();
                stack4.pop();
            }
            else if (i == 0){
                fillStacks(stack3.peek());
                i=0;
            }

            else if (!stack3.isEmpty()){
                stack3.pop();
                if (stack3.peek()!=null) {
                    fillStacks(stack3.peek());
                    i = 0;
                }
            }
            else if (!stack2.isEmpty()){
                stack2.pop();
                if (stack2.peek()!=null) {
                    fillStacks(stack2.peek());
                    i = 0;
                }
            }else if (!stack1.isEmpty()){
                stack1.pop();
                if (stack1.peek()!=null) {
                    fillStacks(stack1.peek());
                    i = 0;
                }
            }
        }
    }
}
