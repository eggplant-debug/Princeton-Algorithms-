package firstChapter;

public class QuickFind {
    private int[] id;
    private int count;
    public QuickFind(int N){
        count=N;
        id=new int[N];
        for(int i=0;i<id.length;i++){
            id[i]=i;
        }
    }
    public int getCount(){
        return count;
    }
    public int find(int p){
        return id[p];
    }
    public boolean connected(int p, int q){
        return find(p)==find(q);
    }
    public void uion(int p, int q){
        int pid=find(p);
        int qid=find(q);
        if(pid==qid){
            return;
        }
        else{
            for(int i=0;i<id.length;i++){
                if(id[i]==pid) {
                    id[i]=qid;
                }
            }
            count--;
        }
    }
}
