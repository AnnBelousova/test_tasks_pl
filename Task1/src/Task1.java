import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        System.out.println(n +" , " + m);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(arr[0]);
        for (int i = m-1; i < n; i = (i + m - 1) % n) {
            if(i==0){
                break;
            }else
                arr2.add(arr[i]);
        }
        for (int i = 0; i < arr2.size(); i++) {
            System.out.print(arr2.get(i));
        }
    }
}