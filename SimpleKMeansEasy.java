import java.util.*;
public class SimpleKMeansEasy {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Points: "); int n=sc.nextInt();
        System.out.print("Clusters: "); int k=sc.nextInt();
        double[][] pts=new double[n][2], centers=new double[k][2];
        for(int i=0;i<n;i++){ pts[i][0]=sc.nextDouble(); pts[i][1]=sc.nextDouble(); }
        for(int i=0;i<k;i++){ centers[i][0]=pts[i][0]; centers[i][1]=pts[i][1]; }
        int[] cluster=new int[n]; boolean changed;
        do{
            changed=false;
            for(int i=0;i<n;i++){
                double min=Double.MAX_VALUE; int idx=0;
                for(int j=0;j<k;j++){
                    double d=Math.pow(pts[i][0]-centers[j][0],2)+Math.pow(pts[i][1]-centers[j][1],2);
                    if(d<min){ min=d; idx=j; }
                }
                if(cluster[i]!=idx){ cluster[i]=idx; changed=true; }
            }
            double[][] newC=new double[k][2]; int[] count=new int[k];
            for(int i=0;i<n;i++){ newC[cluster[i]][0]+=pts[i][0]; newC[cluster[i]][1]+=pts[i][1]; count[cluster[i]]++; }
            for(int j=0;j<k;j++) if(count[j]!=0){ newC[j][0]/=count[j]; newC[j][1]/=count[j]; }
            centers=newC;
        }while(changed);
        System.out.println("\nFinal Centers:");
        for(int j=0;j<k;j++) System.out.printf("C%d:(%.2f,%.2f)%n",j+1,centers[j][0],centers[j][1]);
        System.out.println("\nAssignments:");
        for(int i=0;i<n;i++) System.out.printf("(%.1f,%.1f)->C%d%n",pts[i][0],pts[i][1],cluster[i]+1);
        sc.close();
    }
}
