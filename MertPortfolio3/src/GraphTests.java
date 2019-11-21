import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;

public class GraphTests {

    public static void main(String[] args) {







        // Create graph
        GraphTests TestGraph= new GraphTests();
        Graph g = TestGraph.MakeSmallGraph();
        Vertex source = g.getvertex("A");
        Vertex zink = g.getvertex("E");
        Pair<Integer, Map<Vertex, Vertex>> results=g.ShortestDistance(source, zink);

        Vertex current =zink;
        ArrayList<Vertex> Path= new ArrayList<>();
        Path.add(zink);



        while ((current != source) && (results.getValue().get(current)!=null))
        {
            current=results.getValue().get(current);
            Path.add(0,current);
        }
       for(Vertex v : Path)
        {
            System.out.print( v.Name);
            if (v!=zink)
               System.out.print("->");
       }

System.out.println("");

        Pair<Integer, Map<Vertex, Vertex>> resultsTime=g.FastestDistance(source, zink);
        Vertex currentTime =zink;
        ArrayList<Vertex> PathTime= new ArrayList<>();
        PathTime.add(zink);
        while ((currentTime != source) && (resultsTime.getValue().get(currentTime)!=null))
        {
            currentTime=resultsTime.getValue().get(currentTime);
            PathTime.add(0,currentTime);
        }
        for(Vertex v : PathTime) {
            System.out.print(v.Name);
            if (v != zink)
                System.out.print("->");
        }


/*
        Graph Portofolio = TestGraph.GraphPortfolio();
        Vertex sourceP = Portofolio.getvertex("10");
        Vertex zinkP = Portofolio.getvertex("6");
        Pair<Integer, Map<Vertex, Vertex>>  resultsP=Portofolio.ShortestDistance(sourceP, zinkP);

        Vertex currentP =zink;
        ArrayList<Vertex> PathP= new ArrayList<>();
        Path.add(zink);



        while ((currentP != sourceP) && (resultsP.getValue().get(current)!=null))
        {
            currentP=resultsP.getValue().get(current);
            PathP.add(0,current);
        }
        for(Vertex v : PathP)
        {
            System.out.print( v.Name);
            if (v!=zinkP)
                System.out.print("->");
        }
        */
    }
    public Graph MakeSmallGraph()
    {
        Graph mygraph= new Graph();
        final Vertex A=mygraph.addvertex("A");
        final Vertex B= mygraph.addvertex("B");
        final Vertex C =mygraph.addvertex("C");
        final Vertex D = mygraph.addvertex("D");
        final Vertex E = mygraph.addvertex("E");
        final Vertex F = mygraph.addvertex("F");

        mygraph.newedge(A,B,1,2);
        mygraph.newedge(A,C, 5,1);
        mygraph.newedge(A,D, 4,6);
        mygraph.newedge(B,C, 3,2);
        mygraph.newedge(B,D, 2,3);
        mygraph.newedge(B,E, 2,4);
        mygraph.newedge(C,F, 1,8);
        mygraph.newedge(C,E, 2,2);
        mygraph.newedge(D,F, 2,7);
        mygraph.newedge(E,F, 3,6);


        return mygraph;

    }

    public Graph GraphPortfolio(){
        Graph graph = new Graph();

        final Vertex One=graph.addvertex("1");
        final Vertex Two= graph.addvertex("2");
        final Vertex Three =graph.addvertex("3");
        final Vertex Four = graph.addvertex("4");
        final Vertex Five = graph.addvertex("5");
        final Vertex Six = graph.addvertex("6");
        final Vertex Seven=graph.addvertex("7");
        final Vertex Eight= graph.addvertex("8");
        final Vertex Nine =graph.addvertex("9");
        final Vertex Ten = graph.addvertex("10");



        graph.newedge(One,Five,20,0);
        graph.newedge(One,Two, 10,0);
        graph.newedge(One,Four, 20,0);
        graph.newedge(One,Six, 5,0);
        graph.newedge(One,Seven, 15,0);
        graph.newedge(Two,Three, 5,0);
        graph.newedge(Two,Four, 10,0);
        graph.newedge(Three,Two, 15,0);
        graph.newedge(Three,Four, 5,0);
        graph.newedge(Four,Five, 10,0);
        graph.newedge(Five,Six,5,0);
        graph.newedge(Seven,Six, 10,0);
        graph.newedge(Eight,One, 5,0);
        graph.newedge(Eight,Two, 20,0);
        graph.newedge(Eight,Seven, 5,0);
        graph.newedge(Nine,Two, 15,0);
        graph.newedge(Nine,Eight, 20,0);
        graph.newedge(Nine,Ten, 10,0);
        graph.newedge(Ten,Two,5,0);
        graph.newedge(Ten,Three, 15,0);

        return graph;
    }
}
