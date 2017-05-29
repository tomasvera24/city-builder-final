
public class CityLayout {
	private int[][] map;
	
	public CityLayout() {
		this.map = new int[6][9];
        for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				map[row][col] = 0;
				
			}
		}
	}
	public int[][] getMap(int x) {
		int[][] output = new int[6][9];
		if (x == 0) {
			output[0][4] = 1;
			output[2][7] = 1;
			output[5][3] = 1;
			output[3][2] = 1;
			output[5][4] = 1;
			output[4][5] = 5;
			output[4][6] = 6;
			output[3][5] = 3;
			output[3][6] = 4;
		}
		if (x == 0) {
			output[0][4] = 1;
			output[2][7] = 1;
			output[5][3] = 1;
			output[3][2] = 1;
			output[5][4] = 1;
			output[4][5] = 5;
			output[4][6] = 6;
			output[3][5] = 3;
			output[3][6] = 4;
		}
		return output;
	}
}

/*
code key:
0 = grass
1 = trees
2 = water
3 = top right corner
4 = top left corner
5 = bottom right corner
6 = bottom left corner
*/