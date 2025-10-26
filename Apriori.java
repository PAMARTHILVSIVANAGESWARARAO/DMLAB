import java.util.*;
public class Apriori {
    static Map<Set<String>, Integer> findL1(List<Set<String>> T, int min) {
        Map<String,Integer> c = new HashMap<>();
        for(Set<String> t:T) for(String i:t) c.put(i,c.getOrDefault(i,0)+1);
        Map<Set<String>,Integer> L=new HashMap<>();
        for(var e:c.entrySet()) if(e.getValue()>=min) L.put(Set.of(e.getKey()),e.getValue());
        return L;
    }
    static Set<Set<String>> aprioriGen(Set<Set<String>> Lprev) {
        Set<Set<String>> C=new HashSet<>();
        List<Set<String>> l=new ArrayList<>(Lprev);
        for(int i=0;i<l.size();i++) for(int j=i+1;j<l.size();j++){
            Set<String> s=new HashSet<>(l.get(i)); s.addAll(l.get(j));
            if(s.size()==l.get(i).size()+1) C.add(s);
        }
        return C;
    }
    static Map<Set<String>,Integer> getFreq(Set<Set<String>> C,List<Set<String>> T,int min){
        Map<Set<String>,Integer> F=new HashMap<>();
        for(Set<String> c:C){
            int count=0;
            for(Set<String> t:T) if(t.containsAll(c)) count++;
            if(count>=min) F.put(c,count);
        }
        return F;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Transactions: "); int n=sc.nextInt(); sc.nextLine();
        List<Set<String>> T=new ArrayList<>();
        for(int i=0;i<n;i++){ System.out.print("T"+(i+1)+": ");
            T.add(new HashSet<>(Arrays.asList(sc.nextLine().split(" ")))); }
        System.out.print("Min support: "); int min=sc.nextInt();

        Map<Set<String>,Integer> L=findL1(T,min); System.out.println("L1: "+L);
        int k=2;
        while(!L.isEmpty()){
            Set<Set<String>> C=aprioriGen(L.keySet());
            L=getFreq(C,T,min);
            if(!L.isEmpty()) System.out.println("L"+k+": "+L); k++;
        }
    }
}
