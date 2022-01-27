# Problem Description

It’s now time for the final game. In this game, the remaining
player is placed in an m × n grid-shaped maze. A cell in the maze can either contain
only one of the player or an obstacle. The player is allowed to move in the four directions
up, down, left and right given that the cell he will be moving to does not contain an
obstacle. Your task is to use the discussed search algorithms in class to output a valid
path for the player from his starting position to a given destination position

# Techniques Used
- Breadth First Search
- Depth First Search

# Methods
- public static String bfs (String grid) that implements breadth-first search
to solve the problem.
- public static String dfs (String grid) that implements depth-first search to
solve the problem.
------------
Both methods take a String representing the grid formatted as follows:
    m, n; rowStart, colStart; o1r, o2c, . . . , okr, okc; rowEnd, colEnd
    
Where:
• m, n represent the dimensions of the grid. m is the total number of rows and n is
the total number of columns.
• rowStart, colEnd is the row number and column number respectively of the starting position of the player.
• oir and oic represent the row and column number of the position of obstacle i for
all 1 ≤ i ≤ k.
• rowEnd, colEnd is the row number and column number respectively of the end
position of the player.
------------
Both methods return a string encoding solution, if one exists, formatted as follows:
step1, . . . , stepl ; stepsNum

Where:
• step1, . . . , steps are the steps the player should follow to reach the end position
from the start position without running into any obstacles.
• stepsNum is the number of returned steps.
1
If no solution exists (there is no path between the start and the end positions due to
obstacles), both methods should return No Solution.
------------

# Sample Input/Output
grid = "3,3;0,0;0,1,1,1;0,2"
Output by BFS:down,down,right,right,up,up;6
Output by DFS: down,down,right,right,up,up;6
grid = "3,3;0,0;0,1,1,1,2,1;0,2"
Output by BFS: No Solution
Output by DFS: No Solution
grid = "10,10;1,6;2,4,5,8,0,8,0,9,9,1,7,2,2,5,2,6,5,9,6,4;4,9"
Output by BFS: right,down,down,down,right,right;6
Output by DFS: right,right,right,down,left,left,down,right,right,down;10
