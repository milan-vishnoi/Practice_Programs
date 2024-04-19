package pertChart;
import java.util.ArrayList;
import java.util.Arrays;

public class graph {
    public static void main(String args[])
    {
       Node work1 = new Node(1,5,new ArrayList<Node>());
       Node work2 = new Node(2,10,new ArrayList<Node>(Arrays.asList(work1)));
       Node work3 = new Node(3,12,new ArrayList<Node>(Arrays.asList(work1)));
       Node work4 = new Node(4,10,new ArrayList<Node>(Arrays.asList(work1, work3)));
       Node work5 = new Node(5,10,new ArrayList<Node>(Arrays.asList(work2)));
       Node work6 = new Node(6,10,new ArrayList<Node>(Arrays.asList(work2,work3,work4)));
       Node work7 = new Node(7,10,new ArrayList<Node>(Arrays.asList(work4)));
       Node work8 = new Node(8,10,new ArrayList<Node>(Arrays.asList(work5,work6)));
       Node work9 = new Node(9,10,new ArrayList<Node>(Arrays.asList(work6,work7,work8)));

       Node[] works = {work1,work2,work3,work4,work5,work6,work7,work8,work9};

       findPath(findStart(works), findEnd(works));

    }

    public static Node findStart(Node[] works)
    {
        for(Node work : works)
        {
            if(work.dependsOn.isEmpty())
            return work;
        }

        return null;
    }

    public static Node findEnd(Node[] works)
    {
        for(Node work : works)
        {
            if(work.child.isEmpty())
            return work;
        }

        return null;
    }

    public static void findPath(Node start, Node end)
    {
        System.out.println("Start:"+start.toString());
        System.out.println("End:"+end.toString());

    }
}


class Node {
    int workId;
    int time;
    ArrayList<Node> child;
    ArrayList<Node> dependsOn;

    public Node(int workId,int time,ArrayList<Node> dependsOn)
    {
         this.workId = workId;
         this.time = time;
         this.child = new ArrayList<Node>();
         this.dependsOn = new ArrayList<Node>(dependsOn);
         this.dependsOn.forEach((parent) -> updateParent(parent)); 
    }

    private void updateParent(Node node)
    {   
        node.setChild(this);
    }

    public void setChild(Node node)
    {
        this.child.add(node);
    }

    public String toString()
    {   
        String dependStr = "["; 
        String childStr = "[";
        for(int i= 0;i<this.dependsOn.size() ;i++ )
        dependStr+=this.dependsOn.get(i).getWorkId()+",";
        
        if(dependStr.length()>1)
        dependStr = dependStr.substring(0,dependStr.length()-1);

        dependStr+="]";

        for(int i= 0;i<this.child.size() ;i++ )
        childStr+=this.child.get(i).getWorkId()+",";
        
        if(childStr.length()>1)
        childStr = childStr.substring(0,childStr.length()-1);

        childStr+="]";

        return("WorkId:"+workId+" time:"+time + " Depends on:"+dependStr+" Child:"+childStr);
    }

    public int getWorkId()
    {
       return this.workId;
    }


}