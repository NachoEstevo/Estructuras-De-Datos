package SearchAlgorithms;

import SortingAlgorithms.MergeSort;

public class BinarySearch {

    //For ordered data structures
    //Returning the index as requested

    public static int search(int[] orderedSort, int toSearch){

        int middle = orderedSort.length%2;
        if (orderedSort[middle] == toSearch){
            return middle;
        }
        else if(orderedSort[middle] > toSearch){
            for (int i = middle - 1; i > 0; i--) {
                if (orderedSort[i] == toSearch){
                    return i;
                }
            }
        }
        else{
            for (int i = middle + 1; i < orderedSort.length; i++) {
                if (orderedSort[i] == toSearch){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arrToSearch = {1,2,41,44,68,120};
        int toSearch = 2;
        System.out.println("The number " + toSearch + " is in the index: " + search(arrToSearch,toSearch));
        long startTime = System.nanoTime();
        search(arrToSearch,toSearch);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);  //In Miliseconds
        System.out.println("Tiempo empleado: " + duration + " nanosegundos");
    }

}
