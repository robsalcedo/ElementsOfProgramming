package DeadlockDetection;

import java.util.ArrayList;
import java.util.List;

public class GraphVertex {

    public enum Color{
        WHITE,
        GRAY,
        BLACK
    }

    public Color color;
    public List<GraphVertex> edges;

    public GraphVertex(){
        this.edges = new ArrayList<GraphVertex>();
        this.color = Color.WHITE;
    }

    public static boolean hasCycle(GraphVertex curr){
        if(curr.color == GraphVertex.Color.GRAY) return true;
        if(curr.edges.stream().anyMatch(
                child-> child.color!= Color.BLACK && hasCycle(child)
        )){
            return true;
        }
        return false;
    }

    public static boolean isDeadLocked(List<GraphVertex> graph){
        return graph.stream().anyMatch(
                edge -> edge.color== Color.WHITE && hasCycle(edge)
        );
    }
}
