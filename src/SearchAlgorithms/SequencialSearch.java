package SearchAlgorithms;

public class SequencialSearch {

    public static int seqSearch(int[] arrToSearch, int key) {

        for (int i = 0; i < arrToSearch.length; i++) {
            {
                if (arrToSearch[i] == key) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr =  {1,3,4,51,12,41,111};
        int key = 4;
        System.out.println("The index of " + key + " is: "+ seqSearch(arr,key));
    }
}

