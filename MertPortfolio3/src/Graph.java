import java.util.*;
import javafx.util.Pair;

public class Graph {
    private ArrayList<Vertex> Vertices = new ArrayList<>();

    public Vertex addvertex(String id) {
        Vertex newvertex = new Vertex(id);
        Vertices.add(newvertex);
        return newvertex;
    }

    public void addvertex(Vertex v) {
        Vertices.add(v);
    }
    public Vertex getvertex(String s)
    {
        for(Vertex v : Vertices )
        {
            if (v.Name==s)
                return v;
        }
        return null;
    }

    public void newedge(Vertex from, Vertex to, int dist, int tim) {
        Edge newedge=new Edge(from,to);
        newedge.distance=dist;
        newedge.time=tim;
    }
    public Pair<Integer, Map<Vertex,Vertex>> FastestDistance(Vertex source , Vertex zink){
        Map<Vertex,Vertex> PredecessorMap= new HashMap<>();
        Map<Vertex,Integer> TimeMap=new HashMap<>();
        Map<Vertex, Integer> StreamMap = new HashMap<>();

        for(Vertex v: Vertices)
        {
            TimeMap.put(v, Integer.MAX_VALUE);
            PredecessorMap.put(v, null);
        }
        TimeMap.put(source,0);

        for (int J = 0; J < Vertices.size(); J++) {

            Vertex v = getmin(TimeMap);
            for (int Z = 0; Z < v.getOutEdges().size(); Z++) {

                if (TimeMap.get(v.getOutEdges().get(Z).getTovertex()) > v.getOutEdges().get(Z).time + TimeMap.get(v)) {

                    PredecessorMap.put(v.getOutEdges().get(Z).getTovertex(), v);

                    TimeMap.put(v.getOutEdges().get(Z).getTovertex(),v.getOutEdges().get(Z).time + TimeMap.get(v));

                }
            }

            StreamMap.put(v, TimeMap.put(v, -1));


        }


        System.out.println("The fastest way from" + " " + source.Name + " " + "to" + " " +zink.Name + " is :");
        return (new Pair<Integer,Map<Vertex,Vertex>> (StreamMap.get(zink), PredecessorMap));
    }

    public Pair<Integer, Map<Vertex,Vertex> > ShortestDistance(Vertex source, Vertex zink)
    {
        Map<Vertex,Vertex> PredecessorMap= new HashMap<>();
        Map<Vertex,Integer> DistanceMap=new HashMap<>();
        // initialize arrays

        Map<Vertex, Integer> StreamMap = new HashMap<>();
//I created this Map because ı need to save data to somewhere
        for(Vertex v: Vertices)
        {
            DistanceMap.put(v, Integer.MAX_VALUE);
            PredecessorMap.put(v, null);
        }



        //implement Dijkstra
        DistanceMap.put(source, 0);

        for (int J = 0; J < Vertices.size(); J++) {

           Vertex v = getmin(DistanceMap);
            for (int Z = 0; Z < v.getOutEdges().size(); Z++) {

                if (DistanceMap.get(v.getOutEdges().get(Z).getTovertex()) > v.getOutEdges().get(Z).distance + DistanceMap.get(v)) {

                    PredecessorMap.put(v.getOutEdges().get(Z).getTovertex(), v);

                    DistanceMap.put(v.getOutEdges().get(Z).getTovertex(),v.getOutEdges().get(Z).distance + DistanceMap.get(v));

                }
            }

            StreamMap.put(v, DistanceMap.put(v, -1));


        }
        int distance= 0;

        System.out.println("The shortest way from" + " " + source.Name + " " + "to" + " " +zink.Name + " is :");
        return (new Pair<Integer,Map<Vertex,Vertex>> (StreamMap.get(zink), PredecessorMap));
    }
    public Vertex getmin(Map<Vertex,Integer> qmap){
        int x= Integer.MAX_VALUE;
        Vertex v= null;

        for (Map.Entry<Vertex, Integer> entry : qmap.entrySet()) {

            if (entry.getValue() < x && entry.getValue() !=-1) {
                v= entry.getKey();
                x= entry.getValue();


            }
        }
        // Your code
        return v;

    }
}



class Vertex{
    public String Name;
    public ArrayList<Edge> OutEdges = new ArrayList<>();
    public  Vertex(String id){
        Name=id;
    }
    public void addOutEdge(Edge outedge){
        OutEdges.add(outedge);
    }
    public ArrayList<Edge> getOutEdges(){return OutEdges;}
}

class Edge{
    private Vertex fromvertex;
    private Vertex tovertex;
    public int distance=0;
    public int time=0;
    public Vertex getFromvertex() {return fromvertex; }// ı added this getter method because ı needed to use this method

    public Vertex getTovertex() {
        return tovertex;
    }

    public Edge(Vertex from, Vertex to){
        fromvertex=from;
        tovertex=to;
        fromvertex.addOutEdge(this);
        //If not directional
        tovertex.addOutEdge(this);
    }
}