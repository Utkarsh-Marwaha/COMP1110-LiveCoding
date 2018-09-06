import java.util.Scanner;

/**
 * You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to reach
 * its destination i.e. maze[N-1][N-1]. Rat can move in any direction (right, left, top, bottom)
 *
 * Value of every cell in the maze can either be 0 or 1. Cells with a value 0 are blocked i.e. the rat cannot enter
 * those cells and the cells with a value 1 are open for the rat to enter
 */
public class RatInMaze {


    private static void printAllPaths(int maze[][], int n, int x, int y, int path[][]){
        // (x,y) represents the current position/cell of the rat in the maze
        // if the current cell is off-the maze
        if ((x < 0 || x>= n) || (y < 0 || y >=n)){
            // then we return
            return;
        }

        // if the rat has reached the destination i.e maze[N-1][N-1]
        if (x == n-1 && y == n-1){
            path[x][y] = 1; // reset the path
            // print the path travelled by the rat to reach the end
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(path[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            // then we should return true
            return;
        }

        // if the rat is one any valid cell (other than the destination)

        // if the cell is blocked for the rat to enter i.e. its value is 0
        // if the current cell is marked on our path i.e. it has already been traversed
        if (maze[x][y]==0 || path[x][y]==1){
            // then we should return
            return;
        }


        // Before we make the next moves in either direction, we should mark the
        // current position of the rat in our path matrix
        path[x][y] = 1;

        //Moving the rat one cell to the right , (col coordinate increments by 1)
        printAllPaths(maze,n,x,y+1,path);
        //Moving the rat one cell to the left , (col coordinate decrements by 1)
        printAllPaths(maze,n,x,y-1,path);
        //Moving the rat one cell to the Top , (row coordinate decrements by 1)
        printAllPaths(maze,n,x-1,y,path);
        //Moving the rat one cell to the bottom , (row coordinate increments by 1)
        printAllPaths(maze,n,x+1,y,path);

        // reset the path
        path[x][y] = 0;
    }


    // Time Complexity = O(2^N) -> exponential
    /**
     * @param maze configuration
     * @param n order of the maze
     * @param x current row of the rat's position
     * @param y current column of the rat's position
     * @param path path traversed by the rat till now
     * @return true if there exists a path for the rat to reach the end of the maze
     */
    private static boolean findPath(int maze[][], int n, int x, int y, int path[][]){
        // (x,y) represents the current position/cell of the rat in the maze
        // if the current cell is off-the maze
        if ((x < 0 || x>= n) || (y < 0 || y >=n)){
            // then we return false
            return false;
        }

        // if the rat has reached the destination i.e maze[N-1][N-1]
        if (x == n-1 && y == n-1){
            path[x][y] = 1; // reset the path
            // print the path travelled by the rat to reach the end
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(path[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            // then we should return true
            return true;
        }

        // if the rat is one any valid cell (other than the destination)

        // if the cell is blocked for the rat to enter i.e. its value is 0
        if (maze[x][y]==0){
            // then we should return false
            return false;
        }

        // if the current cell is marked on our path i.e. it has already been traversed
        if (path[x][y]==1){
            // then we should return false
            return false;
        }

        // Before we make the next moves in either direction, we should mark the current position of
        // the rat in our path matrix
        path[x][y] = 1;

        // if Moving the rat one cell to the right , (col coordinate increments by 1) return true
        if (findPath(maze,n,x,y+1,path)){
            path[x][y] = 0;
            return true;
        }
        // if Moving the rat one cell to the left , (col coordinate decrements by 1) return true
        if (findPath(maze,n,x,y-1,path)){
            path[x][y] = 0;
            return true;
        }
        // if Moving the rat one cell to the Top , (row coordinate decrements by 1) return true
        if (findPath(maze,n,x-1,y,path)){
            path[x][y] = 0;
            return true;
        }
        // if Moving the rat one cell to the bottom , (row coordinate increments by 1) return true
        if (findPath(maze,n,x+1,y,path)){
            path[x][y] = 0;
            return true;
        }

        // reset path back to 0
        path[x][y] = 0;
        return false;
    }

    /**
     *
     * @param maze configuration
     * @param n order of the maze
     * @return if there exists a path for the rat to successfully reach the end of the maze
     */
    private static boolean findPath(int maze[][],int n){
        // this matrix will keep track of the path we have already traversed from origin (in search of destination)
        int path[][] = new int[n][n];

        return findPath(maze,n,0,0,path); // (x,y) = (0,0) because the rat starts from (0,0)
    }

    private static void printAllPaths(int maze[][], int n){
        int path[][] = new int[n][n];

        printAllPaths(maze,n,0,0,path); // (x,y) = (0,0) because the rat starts from (0,0)
    }
    public static void main (String[] args) {
        // declaring a new Scanner object
        Scanner in = new Scanner(System.in);

        // Asking the user to enter the number of rows
        System.out.println("Enter the order of the maze: ");
        int n = in.nextInt();

        int [][] maze = new int[n][n];

        // Asking the user to enter the matrix elements
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n; j++){
                System.out.println("Enter the element"+i+", "+j);
                maze[i][j] = in.nextInt();
            }
        }

        int testMaze [][] = {{1,1,0},{1,1,0},{0,1,1}};
        // Displaying the result
        printAllPaths(testMaze,testMaze.length);
    }
}
