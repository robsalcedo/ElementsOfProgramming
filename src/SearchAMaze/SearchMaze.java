package SearchAMaze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchMaze {

    public static class Coordinate{
        public int x,y;
        public Coordinate(int _x, int _y){
            this.x = _x;
            this.y = _y;
        }

    @Override
    public boolean equals(Object o){
        if(this == o){
         return true;
        }
        if(o == null || o.getClass() != getClass()){
            return false;
        }
        Coordinate that = (Coordinate)o;
        if(x!= that.x || y != that.y){
            return false;
        }
        return true;
    }

    public enum Color{
            WHITE,
            BLACK
    }

    public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate start, Coordinate end){
            List<Coordinate> path = new ArrayList<>();
            searchMazeHelper(maze, start, end, path);
            return path;
    }

    private static boolean searchMazeHelper(List<List<Color>> maze, Coordinate current, Coordinate end, List<Coordinate> path) {
            if(current.x<0 || current.y<0 || current.x >= maze.size() || current.y>=maze.get(current.x).size() || maze.get(current.x).get(current.y)!=Color.WHITE){
                return false;
            }
            path.add(current);
            maze.get(current.x).set(current.y,Color.BLACK);
            if(current.equals(end)){
                return true;
            }
            for(Coordinate nextMove : Arrays.asList(new Coordinate(current.x, current.y + 1),
                    new Coordinate(current.x, current.y - 1),
                    new Coordinate(current.x + 1, current.y),
                    new Coordinate(current.x - 1, current.y))){
                if(searchMazeHelper(maze, nextMove, end, path)){
                    return true;
                }
            }
            path.remove(path.size()-1);
            return false;
        }


    }

}
