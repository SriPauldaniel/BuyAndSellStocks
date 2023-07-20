import java.util.Scanner;
public class BuyAndSell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findProfit(arr, n));
        sc.close();
    }

    static int findProfit(int[] arr,int n) {
        int profit = 0,maxProfit = 0;
        int buy = 0,sell = 0;
        for(int i=1;i<n;i++) {
            
            if(arr[i] > arr[i-1]) {
                buy = arr[i-1];
            }
            for(int j=i;j<n;j++) {
                if(buy == 0) {
                    break;
                }
                if(j == n-1) {
                    sell = arr[j];
                } else if(arr[j]>arr[j+1]) {
                    sell = arr[j];
                    break;
                }
            }
            profit = sell - buy;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}