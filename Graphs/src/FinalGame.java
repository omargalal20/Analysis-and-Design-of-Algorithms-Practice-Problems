import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FinalGame {
	
	public static String bfs (String path){
		String [] splittedPath = path.split(";");
		Queue<Cell> bfs = new LinkedList<Cell>();
		
		String[] gridSize = splittedPath[0].split(",");
		
		int [][] grid = new int[Integer.parseInt(gridSize[0])][Integer.parseInt(gridSize[1])];
		
		Cell start = new Cell(Integer.parseInt(splittedPath[1].split(",")[0]),
				Integer.parseInt(splittedPath[1].split(",")[1]), "");
		
		grid[Integer.parseInt(splittedPath[1].split(",")[0])][Integer.parseInt(splittedPath[1].split(",")[1])] = 1;
		
		grid[Integer.parseInt(splittedPath[ splittedPath.length - 1 ].split(",")[0])]
				[Integer.parseInt(splittedPath[ splittedPath.length - 1 ].split(",")[1])] = 1;
		
		if(start.x == Integer.parseInt(splittedPath[ splittedPath.length - 1 ].split(",")[0]) 
				&& start.y == Integer.parseInt(splittedPath[ splittedPath.length - 1 ].split(",")[1])){
			return ";0";
		}
		
		bfs.add(start);
		
		for(int i = 0; i < splittedPath[2].split(",").length;){
			grid[Integer.parseInt(splittedPath[2].split(",")[i])][Integer.parseInt(splittedPath[2].split(",")[i+1])] = -1;
			i++;
			i++;
		}
		
		boolean noSolution = true;
		
		String resultPath= "";
		
		while(!bfs.isEmpty()){
			Cell curr = bfs.poll();
			grid[curr.x][curr.y] = -1;
			
			if(curr.x == Integer.parseInt(splittedPath[ splittedPath.length - 1 ].split(",")[0]) 
					&& curr.y == Integer.parseInt(splittedPath[ splittedPath.length - 1 ].split(",")[1])){
				noSolution = false;
				resultPath += curr.path + ";" + curr.path.split(",").length;
				break;
			}
			//Down
			if(curr.x - 1 >= 0 
					&& (grid[curr.x - 1][curr.y] != -1)){
				if(curr.path == "")
					bfs.add(new Cell(curr.x - 1, curr.y, curr.path + "up"));
				else
					bfs.add(new Cell(curr.x - 1, curr.y, curr.path + ",up"));
			}
			//Up
			if(curr.x + 1 < Integer.parseInt(gridSize[0]) 
					&& (grid[curr.x + 1][curr.y] != -1)){
				if(curr.path == "")
					bfs.add(new Cell(curr.x + 1, curr.y, curr.path + "down"));
				else
					bfs.add(new Cell(curr.x + 1, curr.y, curr.path + ",down"));
			}
			//Left
			if(curr.y - 1 >= 0 
					&& (grid[curr.x][curr.y - 1] != -1)){
				if(curr.path == "")
					bfs.add(new Cell(curr.x, curr.y - 1, curr.path + "left"));
				else
					bfs.add(new Cell(curr.x, curr.y - 1, curr.path + ",left"));
			}
			//Right
			if(curr.y + 1 < Integer.parseInt(gridSize[1]) 
					&& (grid[curr.x][curr.y + 1] != -1)){
				if(curr.path == "")
					bfs.add(new Cell(curr.x, curr.y + 1, curr.path + "right"));
				else
					bfs.add(new Cell(curr.x, curr.y + 1, curr.path + ",right"));
			}
		}
		
		if(noSolution){
			resultPath += "No Solution";
		}
		return resultPath;
	}
	
	public static String dfs (String path){
		String [] splittedPath = path.split(";");
		Stack<Cell> dfs = new Stack<Cell>();
		
		String[] gridSize = splittedPath[0].split(",");
		
		int [][] grid = new int[Integer.parseInt(gridSize[0])][Integer.parseInt(gridSize[1])];
		
		Cell start = new Cell(Integer.parseInt(splittedPath[1].split(",")[0]),
				Integer.parseInt(splittedPath[1].split(",")[1]), "");
		
		grid[Integer.parseInt(splittedPath[1].split(",")[0])]
				[Integer.parseInt(splittedPath[1].split(",")[1])] = 1;
		
		grid[Integer.parseInt(splittedPath[ splittedPath.length - 1 ].split(",")[0])]
				[Integer.parseInt(splittedPath[ splittedPath.length - 1 ].split(",")[1])] = 1;
		
		if(start.x == Integer.parseInt(splittedPath[ splittedPath.length - 1 ].split(",")[0]) 
				&& start.y == Integer.parseInt(splittedPath[ splittedPath.length - 1 ].split(",")[1])){
			return ";0";
		}
		
		dfs.push(start);
		
		for(int i = 0; i < splittedPath[2].split(",").length;){
			grid[Integer.parseInt(splittedPath[2].split(",")[i])][Integer.parseInt(splittedPath[2].split(",")[i+1])] = -1;
			i++;
			i++;
		}
		
		boolean noSolution = true;
		
		String resultPath= "";
		
		while(!dfs.isEmpty()){
			Cell curr = dfs.pop();
			grid[curr.x][curr.y] = -1;
			
			if(curr.x == Integer.parseInt(splittedPath[ splittedPath.length - 1 ].split(",")[0]) && 
					curr.y == Integer.parseInt(splittedPath[ splittedPath.length - 1 ].split(",")[1])){
				noSolution = false;
				resultPath += curr.path + ";" + curr.path.split(",").length;
				break;
			}
			//Down
			if(curr.x - 1 >= 0 
					&& (grid[curr.x - 1][curr.y] != -1)){
				if(curr.path == "")
					dfs.push(new Cell(curr.x - 1, curr.y, curr.path + "up"));
				else
					dfs.push(new Cell(curr.x - 1, curr.y, curr.path + ",up"));
			}
			//Up
			if(curr.x + 1 < Integer.parseInt(gridSize[0]) 
					&& (grid[curr.x + 1][curr.y] != -1)){
				if(curr.path == "")
					dfs.push(new Cell(curr.x + 1, curr.y, curr.path + "down"));
				else
					dfs.push(new Cell(curr.x + 1, curr.y, curr.path + ",down"));
			}
			//Left
			if(curr.y - 1 >= 0 
					&& (grid[curr.x][curr.y - 1] != -1)){
				if(curr.path == "")
					dfs.push(new Cell(curr.x, curr.y - 1, curr.path + "left"));
				else
					dfs.push(new Cell(curr.x, curr.y - 1, curr.path + ",left"));
			}
			//Right
			if(curr.y + 1 < Integer.parseInt(gridSize[1]) 
					&& (grid[curr.x][curr.y + 1] != -1)){
				if(curr.path == "")
					dfs.push(new Cell(curr.x, curr.y + 1, curr.path + "right"));
				else
					dfs.push(new Cell(curr.x, curr.y + 1, curr.path + ",right"));
			}
		}
		
		if(noSolution){
			resultPath += "No Solution";
		}
		return resultPath;
	}
	
	public static void main(String[] args) {
		System.out.println(bfs("10,10;1,6;2,4,5,8,0,8,0,9,9,1,7,2,2,5,2,6,5,9,6,4;4,9"));
	}
}
