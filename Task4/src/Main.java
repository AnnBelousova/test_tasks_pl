import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String path1 = args[0];
        //String path1 = "C:/Users/user/Desktop/file4.txt";
        ArrayList<String> arr = new ArrayList<>();
        try (FileReader reader = new FileReader(path1);
             BufferedReader br = new BufferedReader(reader)) {

            String line;

            while ((line = br.readLine()) != null) {
                arr.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        int[] arrInt= new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arrInt[i] = Integer.parseInt(arr.get(i));
        }

        printMinOp(arrInt);
    }

    static void printMinOp(int arr[]) {
        int arrSum = 0;
        int average;

        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
        }
        average = arrSum / arr.length;
        int num;
        int min = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            num = Math.abs(average - arr[i]);
            temp.add(num);
            min = Collections.min(temp);
        }

        int numToWhichEqual = arr[temp.indexOf(min)];
        int k = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < numToWhichEqual) {
                do {
                    arr[j] = arr[j] + 1;
                    k++;
                } while (arr[j] != numToWhichEqual);

            } else if (arr[j] > numToWhichEqual) {
                do {
                    arr[j] = arr[j] - 1;
                    k++;
                } while (arr[j] != numToWhichEqual);
            }
        }
        System.out.println(k);
    }
}
