import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int max = 1;

       for (int i = max; i <= n; i++) {
           ArrayList<Integer> partitions = new ArrayList<>();
           partitions.add(max);
           partitions.add(1);

           System.out.print(max + " ");
           System.out.print(decomposeNumber(n - max) + " ");

           for (int k = 0; k < partitions.size() - 1; k++) {

               if (k == 0 && partitions.size() > 2 && partitions.get(partitions.size() - 1) < partitions.get(partitions.size() - 2)) {
                   continue;
               }
               if (k == 1 && partitions.size() > 3 && partitions.get(partitions.size() - 1) < partitions.get(partitions.size() - 2)) {
                   continue;
               }
               if (k == 2 && partitions.size() > 4 && partitions.get(partitions.size() - 1) < partitions.get(partitions.size() - 2)) {
                   continue;
               }
               if (k == 3 && partitions.size() > 5 && partitions.get(partitions.size() - 1) < partitions.get(partitions.size() - 2)) {
                   continue;
               }
               if (k == 4 && partitions.size() > 6 && partitions.get(partitions.size() - 1) < partitions.get(partitions.size() - 2)) {
                   continue;
               }
               if (k == 5 && partitions.size() > 7 && partitions.get(partitions.size() - 1) < partitions.get(partitions.size() - 2)) {
                   continue;
               }
               if (k == 6 && partitions.size() > 8 && partitions.get(partitions.size() - 1) < partitions.get(partitions.size() - 2)) {
                   continue;
               }
               if (k == 7 && partitions.size() > 9 && partitions.get(partitions.size() - 1) < partitions.get(partitions.size() - 2)) {
                   continue;
               }
               if (k == 8 && partitions.size() > 10 && partitions.get(partitions.size() - 1) < partitions.get(partitions.size() - 2)) {
                   continue;
               }
               if (k == 9 && partitions.size() > 11 && partitions.get(partitions.size() - 1) < partitions.get(partitions.size() - 2)) {
                   continue;
               }
               if (k == 10 && partitions.size() > 12 && partitions.get(partitions.size() - 1) < partitions.get(partitions.size() - 2)) {
                   continue;
               }
               if (k == 11 && partitions.size() > 13 && partitions.get(partitions.size() - 1) < partitions.get(partitions.size() - 2)) {
                   continue;
               }
               if (partitions.get(k) + partitions.get(k + 1) < n && partitions.get(k) > partitions.get(k + 1)) {
                   if (k == 0 && partitions.size() > 2) {
                       for (int j = partitions.size(); j > 2; j--) {
                           partitions.remove(partitions.size() - 1);
                       }
                   }
                   partitions.set(k + 1, partitions.get(k + 1) + 1);
                   int temp = 0;
                   for (int j = 0; j < partitions.size(); j++) {
                       temp += partitions.get(j);
                   }
                   if (temp - 1 == n && partitions.get(partitions.size() - 1) == 1) {
                       temp--;
                       partitions.remove(partitions.size() - 1);
                   }


                   if (temp <= n) {
                       System.out.println();
                       for (int j = 0; j < partitions.size(); j++) {
                           System.out.print(partitions.get(j) + " ");
                       }
                       System.out.print(decomposeNumber(n - temp) + " ");
                       partitions.add(1);
                       temp++;

                   }
                   if (temp > n && partitions.get(0) >= partitions.get(1)) {
                       if (partitions.get(partitions.size() - 1) == 1) {
                           partitions.remove(partitions.size() - 1);

                       }
                       if (temp - 1 == n && partitions.get(partitions.size() - 1) == partitions.get(partitions.size() - 2)) {
                           partitions.remove(partitions.size() - 1);
                       }

                           k = -1;

                       while (partitions.size() > 2 && partitions.get(partitions.size() - 1) == partitions.get(partitions.size() - 2)) {
                           partitions.remove(partitions.size() - 1);
                       }
                  }
               }

           }
           max++;
           System.out.println();
       }

    }


    public static String decomposeNumber(int n) {
        if (n == 0)
            return "";
        if (n == 1) {
            return "1";
        }
        System.out.print("1 ");
        return decomposeNumber(n - 1);
    }

}