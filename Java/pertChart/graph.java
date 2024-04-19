package pertChart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class graph {

    static int pathNumber = 0;

    public static void main(String args[]) {

        HashMap<Integer, Node> works = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of works:");
        int noOfNodes = sc.nextInt();
        Node[] workList = new Node[noOfNodes];

        for (int i = 0; i < noOfNodes; i++) {
            ArrayList<Node> dependsOnList = new ArrayList<>();
            System.out.printf("Enter workId & time for work%d's:", i + 1);
            int workId = sc.nextInt();
            int time = sc.nextInt();
            System.out.printf("Enter works on which work%d depends:", i + 1);
            String dependsOn = sc.next();
            if (dependsOn.equals("-1")) {

            } else {
                int[] nodes;
                if (dependsOn.contains(",")) {
                    nodes = Arrays.stream(dependsOn.split(",")).mapToInt((n) -> Integer.parseInt(n)).toArray();
                    for (int j = 0; j < nodes.length; j++)
                        dependsOnList.add(works.get(nodes[j]));
                } else {
                    dependsOnList.add(works.get(Integer.parseInt(dependsOn)));
                }

            }

            Node work = new Node(workId, time, dependsOnList);
            works.put(workId, work);
            workList[i] = work;

        }

        System.out.println("Table:");
        for (Node work : workList) {
            System.out.println(work.toString());
        }
        System.out.println("\nPaths:");
        findPath(findStart(workList), findEnd(workList), findStart(workList).getWorkId() + "");

    }

    public static Node findStart(Node[] works) {
        for (Node work : works) {
            if (work.getDependsOn().isEmpty())
                return work;
        }

        return null;
    }

    public static Node findEnd(Node[] works) {
        for (Node work : works) {
            if (work.getChildren().isEmpty())
                return work;
        }

        return null;
    }

    public static void findPath(Node start, Node end, String path) {
        // System.out.println("Start:"+start.toString());
        // System.out.println("End:"+end.toString());

        if (start.equals(end)) {
            System.out.println("Path" + (++pathNumber) + ": " + path);
            return;
        }

        start.getChildren().forEach((child) -> {
            String p = path + "->" + child.getWorkId();
            findPath(child, end, p);

        });
        // Either of the two for loops will work
        // for(Node child : start.getChildren())
        // {
        //
        // String p = path +"->"+child.getWorkId();
        // findPath(child,end,p);
        // }

    }
}

class Node {
    private int workId;
    private int time;
    private ArrayList<Node> children;
    private ArrayList<Node> dependsOn;

    public Node(int workId, int time, ArrayList<Node> dependsOn) {
        this.workId = workId;
        this.time = time;
        this.children = new ArrayList<Node>();
        this.dependsOn = new ArrayList<Node>(dependsOn);
        this.dependsOn.forEach((parent) -> updateParent(parent));
    }

    public int getWorkId() {
        return this.workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public ArrayList<Node> getChildren() {
        return this.children;
    }

    public void setChild(Node node) {
        this.children.add(node);
    }

    public ArrayList<Node> getDependsOn() {
        return this.dependsOn;
    }

    public void setDependsOn(ArrayList<Node> dependsOn) {
        this.dependsOn = dependsOn;
    }

    private void updateParent(Node node) {
        node.setChild(this);
    }

    public boolean equals(Node node) {
        if (this.workId == node.getWorkId())
            return true;
        else
            return false;
    }

    public String toString() {
        String dependStr = "[";
        String childStr = "[";
        for (int i = 0; i < this.dependsOn.size(); i++)
            dependStr += this.dependsOn.get(i).getWorkId() + ",";

        if (dependStr.length() > 1)
            dependStr = dependStr.substring(0, dependStr.length() - 1);

        dependStr += "]";

        for (int i = 0; i < this.children.size(); i++)
            childStr += this.children.get(i).getWorkId() + ",";

        if (childStr.length() > 1)
            childStr = childStr.substring(0, childStr.length() - 1);

        childStr += "]";

        return ("WorkId:" + workId + " time:" + time + " Depends on:" + dependStr + " Child:" + childStr);
    }
}