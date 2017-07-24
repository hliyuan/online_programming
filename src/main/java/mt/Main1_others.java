package mt;

/**
 * Created by liyuan on 2017/6/19.
 */
import java.util.Scanner;

public class Main1_others {


        static long cnt[]=new long[11];

        static long get_sum(int l,int r,int x){
            long ans = 0;
            r = Math.min(r,x);
            int k=x/r;
            while(true)
            {
                k = x/r;
                int d=x/(k+1);
                if(d<l) break;
                ans+=k*(r-d);
                r=d;



            }
            ans+=(r-l+1)*k;
            return ans;



        }
        static void work(int x,int v){
            for(int i=1;i<10;i++){
                int rode = 1;
                while((long)1*i*rode<=x){
                    int rr = i*rode+rode-1;
                    cnt[i] += v*get_sum(i*rode,rr,x);
                    rode*=10;
                }
            }
        }
        public static void main(String[] args) {

            Scanner in=new Scanner(System.in);
            while(in.hasNext()){
                int n=in.nextInt();
                int m=in.nextInt();
                work(m,1);
                work(n-1,-1);
                for(int i=1;i<10;i++)
                    System.out.println(cnt[i]);


            }

        }



}
