import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String path1 = args[0];
        String path2 = args[1];
        /*String path1 = "C:/Users/user/Desktop/file1.txt";
        String path2 = "C:/Users/user/Desktop/file2.txt";*/
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
        ArrayList<Float> arr2 = new ArrayList<>();
        String[] st = arr.get(0).split(" ");
        for (int i = 0; i < st.length; i++) {
            arr2.add(Float.valueOf(st[i]));
        }


        //points
        ArrayList<String> arr_ = new ArrayList<>();
        try (FileReader reader = new FileReader(path2);
             BufferedReader br = new BufferedReader(reader)) {

            String line2;

            while ((line2 = br.readLine()) != null) {
                arr_.add(line2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str="";
        char[] ch= new char[arr_.size()*3];
        ArrayList<String> arr2_ = new ArrayList<>();
        for (int i = 0; i < arr_.size(); i++) {
            str += arr_.get(i).replace(" ","");
            ch = str.toCharArray();
        }


        float x0 = arr2.get(0);
        float y0 = arr2.get(1);
        String rad = arr.get(1);
        ArrayList<String> x = new ArrayList<>();
        ArrayList<String> y = new ArrayList<>();
        float radius = Float.parseFloat(rad);
        for (int i = 0; i < ch.length; i++) {

            if (i%2 != 0){
                x.add(String.valueOf(ch[i]));

            }
            if (i%2 == 0){
                y.add(String.valueOf(ch[i]));
            }
        }
        for (int i = 0; i < ch.length/2; i++) {
            float res = (Integer.parseInt(x.get(i))-x0) * (Integer.parseInt(x.get(i))-x0) + (Integer.parseInt(y.get(i)) - y0)*(Integer.parseInt(y.get(i))-y0);
            if(res > radius*radius){
                System.out.println(2);
            } else if (res < radius*radius) {
                System.out.println(1);
            }else if(res == radius*radius){
                System.out.println(0);
            }
        }


    }
}