import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SquidGame {
	
	static ArrayList<ArrayList<String>> mem;
	
	public static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static int getSumOfArray(int[] arr){
		int sum = 0;
	    for (int value : arr) {
	        sum += value;
	    }
	    return sum;
	}
	
	public static String getMaxFromEachPath(String x, String y){
		if(!x.equals("") && !y.equals("") ){
			if(Integer.parseInt(x.split(";")[0]) - Integer.parseInt(y.split(";")[0]) > 0)
				return x + formatArrayV1("", Arrays.copyOfRange(y.split(";"), 1, y.split(";").length));
		}
		return y.split(";")[0] + ";" + 
		formatArrayV1("", Arrays.copyOfRange(x.split(";"), 1, x.split(";").length)) +
		formatArrayV1("", Arrays.copyOfRange(y.split(";"), 1, y.split(";").length));
	}
	
	public static String getMinFromAllPaths(String x, String y){
		if(!x.equals("") && !y.equals("") ){
			if(Integer.parseInt(x.split(";")[0]) - Integer.parseInt(y.split(";")[0]) < 0)
				return x;
		}
		
		return y;
	}
	
	public static String formatArrayV1(String x, String[] y) {
		for (int j = 0; j < y.length; j++) {
			x += y[j];
			x += ";";
		}
		return x;
	}
	
	public static String formatArrayV2(String x, int[] y) {
		for (int j = 0; j < y.length; j++) {
			x += y[j];
			if(j == y.length-1)
				x += ";";
			else
				x += ",";
		}
		return x;
	}
	
	public static String naiveHelper(int[] lands,
			int players, int playerNum, String maxOfEachPath) {
		if(players > lands.length){
			return ("Can't Assign Players To Lands Less Than Them");
		}
		int p = players - 1;
		String minSoFar = Integer.MAX_VALUE + ";";
		for (int i = 1; i <= lands.length-p; i++) {
			int[] subArray = Arrays.copyOfRange(lands, i, lands.length);
			if (p == 0) {
			    return getSumOfArray(lands) + ";" + formatArrayV2("", lands);
			} else if ((subArray.length >= p) && players != 0) {
				int n = playerNum;
				
				String currPath = getSumOfArray(Arrays.copyOfRange(lands, 0, i)) + ";" + formatArrayV2("", Arrays.copyOfRange(lands, 0, i));
				
				maxOfEachPath = getMaxFromEachPath(currPath, "" + naiveHelper(Arrays.copyOfRange(lands, i, lands.length), p, ++n, currPath));
				
				minSoFar = getMinFromAllPaths(minSoFar, maxOfEachPath);
			}
		}
		return minSoFar;
	}
	
	public static String efficientHelper(int[] lands,
			int players, int playerNum, String maxOfEachPath, int memPlayerIndex) {
		if(players > lands.length){
			return ("Can't Assign Players To Lands Less Than Them");
		}
		int p = players - 1;
		int pMemIndex = memPlayerIndex + 1;
		String minSoFar = Integer.MAX_VALUE + ";";
		for (int i = 1; i <= lands.length-p; i++) {
			int[] subArray = Arrays.copyOfRange(lands, i, lands.length);
			if (p == 0) {
				if(mem.get(pMemIndex).get(lands.length-1) != null){
					return mem.get(memPlayerIndex).get(lands.length);
				}
				mem.get(pMemIndex).set(lands.length-1, getSumOfArray(lands) + ";" + formatArrayV2("", lands));
			    return mem.get(pMemIndex).get(lands.length-1);
			} else if ((subArray.length >= p) && p != 0) {
				int n = playerNum;
				
				String currPath = "";
				currPath = getSumOfArray(Arrays.copyOfRange(lands, 0, i)) + ";" + formatArrayV2("", Arrays.copyOfRange(lands, 0, i));
				
				if(mem.get(pMemIndex).get(Arrays.copyOfRange(lands, i, lands.length).length) != null){
					maxOfEachPath = getMaxFromEachPath(currPath, "" + mem.get(pMemIndex).get(Arrays.copyOfRange(lands, i, lands.length).length));
				}
				else{
					mem.get(pMemIndex).set(Arrays.copyOfRange(lands, i, lands.length).length, 
							"" + efficientHelper(Arrays.copyOfRange(lands, i, lands.length), p, ++n, currPath, pMemIndex));
					maxOfEachPath = getMaxFromEachPath(currPath, mem.get(pMemIndex).get(Arrays.copyOfRange(lands, i, lands.length).length));
				}
				
				minSoFar = getMinFromAllPaths(minSoFar, maxOfEachPath);
			}
		}
		return minSoFar;
	}
	
	public static String naive (int k, int[] l) {
		return naiveHelper(l, k, 1, "");
	}
	
	public static String efficient (int k, int[] l){
		mem = new ArrayList<ArrayList<String>>(k);
		for (int i = 0; i < k; i++) {
			ArrayList<String> t = new ArrayList<String>(Collections.nCopies(l.length, null));
			mem.add(t);
		}
		return efficientHelper(l, k, 1, "",-1);
	}

	
	public static void main(String[] args) {
		int k7 = 9 ;
		int [] l7 = {281,50,120,252,152,17,87,123,141,141,93,73,137,128,181,192,106,240};
		
		System.out.println("Result: " + efficient(k7, l7));
	}
}