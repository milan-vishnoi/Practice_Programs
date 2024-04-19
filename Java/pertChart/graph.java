package pertChart;
import java.util.ArrayList;
import java.util.Arrays;

public class graph {

    static int pathNumber = 0;
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

       for(Node work : works)
       {
        System.out.println(work.toString());
       }

       findPath(findStart(works), findEnd(works), findStart(works).getWorkId()+"");

    }

    public static Node findStart(Node[] works)
    {
        for(Node work : works)
        {
            if(work.getDependsOn().isEmpty())
            return work;
        }

        return null;
    }

    public static Node findEnd(Node[] works)
    {
        for(Node work : works)
        {
            if(work.getChildren().isEmpty())
            return work;
        }

        return null;
    }

    public static void findPath(Node start, Node end, String path)
    {
        // System.out.println("Start:"+start.toString());
        // System.out.println("End:"+end.toString());

        if(start.equals(end))
        {
            System.out.println("Path"+(++pathNumber)+": "+path);
            return;
        }
        
        // start.getChildren().forEach((child) -> {
        //     String p = path+"->"+child.getWorkId();
        //     findPath(child,end,p);

        // });
        for(Node child : start.getChildren())
        {
            //  System.out.println(child.toString());
             String p = path +"->"+child.getWorkId();
             findPath(child,end,p);

        }

    }
}


class Node {
    private int workId;
    private int time;
    private ArrayList<Node> children;
    private ArrayList<Node> dependsOn;

    public Node(int workId,int time,ArrayList<Node> dependsOn)
    {
         this.workId = workId;
         this.time = time;
         this.children = new ArrayList<Node>();
         this.dependsOn = new ArrayList<Node>(dependsOn);
         this.dependsOn.forEach((parent) -> updateParent(parent)); 
    }

    public int getWorkId()
    {
       return this.workId;
    }

    public void setWorkId(int workId)
    {
       this.workId =  workId;
    }

    public int getTime()
    {
        return this.time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }


    public ArrayList<Node> getChildren()
    {
        return this.children;
    }

    public void setChild(Node node)
    {
        this.children.add(node);
    }

    public ArrayList<Node> getDependsOn()
    {
        return this.dependsOn;
    }

    public void setDependsOn(ArrayList<Node> dependsOn)
    {
        this.dependsOn = dependsOn;
    }



    private void updateParent(Node node)
    {   
        node.setChild(this);
    }

    public boolean equals(Node node)
    {
         if(this.workId == node.getWorkId())
         return true;
         else
         return false;
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

        for(int i= 0;i<this.children.size() ;i++ )
        childStr+=this.children.get(i).getWorkId()+",";
        
        if(childStr.length()>1)
        childStr = childStr.substring(0,childStr.length()-1);

        childStr+="]";

        return("WorkId:"+workId+" time:"+time + " Depends on:"+dependStr+" Child:"+childStr);
    }




}