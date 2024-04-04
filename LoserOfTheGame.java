import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LoserOfTheGame {
    public static int[] circularGameLosers(int n, int k) {
        if(n==1) return new int[0];
        int[] nums = new int[n];
        int pos = 1;
        List<Integer> temp = new ArrayList<>();
        temp.add(1);

        for(int i=1; i<=n; i++){
            int index = i*k;
            pos += index;
            if(pos > n){
                pos %= n;
            }
            if (pos == 0) {
                pos = n;
            }
            if(temp.contains(pos)){
                break;
            }else{
                temp.add(pos);
            }
        }

        Collections.sort(temp);
        int[] out = new int[n-temp.size()];
        int j = 0;
        for(int i=1; i<=n; i++){
            if(!temp.contains(i)){
                out[j++] = i;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(circularGameLosers(5,3)));
    }
}
