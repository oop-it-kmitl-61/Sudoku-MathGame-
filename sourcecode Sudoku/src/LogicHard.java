import java.util.Random;


class LogicHard {
	int[][] blockS = {{13, 1, 4, 14, 11, 16, 10, 9, 3, 6, 2, 12, 7, 8, 5, 15},
			{16, 9, 10, 6, 5, 7, 12, 13, 14, 15, 8, 4, 11, 2, 3, 1},
			{15, 12, 11, 2, 6, 3, 4, 8, 16, 7, 1, 5, 13, 14, 9, 10},
			{3, 7, 8, 5, 1, 2, 14, 15, 10, 9, 11, 13, 4, 6, 12, 16},
			{2, 14, 6, 1, 9, 5, 7, 4, 15, 13, 3, 16, 10, 11, 12, 8},
			{9, 4, 7, 15, 10, 11, 1, 3, 8, 14, 6, 12, 13, 16, 5, 2},
			{8, 13, 5, 16, 14, 2, 6, 12, 7, 4, 10, 11, 9, 1, 3, 15},
			{12, 11, 3, 10, 16, 15, 13, 8, 2, 5, 9, 1, 7, 4, 6, 14},
			{1, 7, 9, 10, 8, 2, 14, 13, 4, 15, 16, 6, 5, 12, 11, 3},
			{15, 5, 11, 14, 1, 12, 9, 7, 2, 3, 13, 8, 6, 10, 4, 16},
			{4, 8, 16, 3, 10, 5, 15, 6, 1, 11, 12, 7, 2, 9, 13, 14},
			{6, 13, 2, 12, 11, 3, 16, 4, 14, 10, 5, 9, 8, 1, 15, 7},
			{14, 3, 13, 7, 16, 9, 8, 5, 6, 10, 15, 11, 12, 4, 1, 2},
			{4, 6, 16, 10, 12, 1, 15, 11, 7, 13, 2, 5, 3, 8, 14, 9},
			{11, 15, 8, 9, 3, 10, 2, 4, 12, 16, 14, 1, 5, 6, 7, 13},
			{5, 12, 1, 2, 13, 14, 7, 6, 9, 8, 4, 3, 15, 16, 10, 11}};																		//set number 1-9 for each box

	Random R_num = new Random(); 																					// random numbers to exchange rows
	Random Grid_R_num = new Random();
	Random R_exnum = new Random();
	Random H_Rnum = new Random();

	int firstrow, secondrow, firstcol, secondcol, firstgrid, secondgrid, gc = 0;
	int carry[] = new int[16];
	int blockh[][] = new int[16][16];
	int blockc[][] = new int[16][16];


	int[][] generate() { 																							//switching the rows
							
		int x = 17 + R_num.nextInt(17);
		for (int y = 0; y < x; y++) {
			for (int a = 0; a < 4; a++) {

				if (a == 0) {
					firstrow = R_num.nextInt(4);
					secondrow = R_num.nextInt(4);
				}

				else if (a == 1) {
					firstrow = 4 + R_num.nextInt(4);
					secondrow = 4 + R_num.nextInt(4);
				}

				else if (a == 2) {
					firstrow = 8 + R_num.nextInt(4);
					secondrow = 8 + R_num.nextInt(4);
				}
				else if (a == 3) {
					firstrow = 12 + R_num.nextInt(4);
					secondrow = 12 + R_num.nextInt(4);
				}

				for (int i = 0; i < 16; i++) {
					carry[i] = blockS[firstrow][i];
					blockS[firstrow][i] = blockS[secondrow][i];
					blockS[secondrow][i] = carry[i];
				}
			}
																												// switching the rows complete

			for (int a = 0; a < 4; a++) {																		// switching the column
				
				if (a == 0) {
					firstcol = R_num.nextInt(4);
					secondcol = R_num.nextInt(4);
				}

				else if (a == 1) {
					firstcol = 4 + R_num.nextInt(4);
					secondcol = 4 + R_num.nextInt(4);
				}

				else if (a == 2) {
					firstcol = 8 + R_num.nextInt(4);
					secondcol = 8 + R_num.nextInt(4);
				}
				else if (a == 3) {
					firstcol = 12 + R_num.nextInt(4);
					secondcol = 12 + R_num.nextInt(4);
				}

				for (int i = 0; i < 16; i++) {
					carry[i] = blockS[i][firstcol];
					blockS[i][firstcol] = blockS[i][secondcol];
					blockS[i][secondcol] = carry[i];
				}
			}
		}
																												// Switchicng the column complete
		
																												// Switching the grids
		firstgrid = 1 + Grid_R_num.nextInt(4);
		secondgrid = 1 + Grid_R_num.nextInt(4);


		if ((firstgrid == 1 && secondgrid == 2) || (firstgrid == 2 && secondgrid == 1)) {
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 16; j++) {
					carry[j] = blockS[i][j];
					blockS[i][j] = blockS[i + 4][j];
					blockS[i + 4][j] = carry[j];
				}
		} else if ((firstgrid == 2 && secondgrid == 3) || (firstgrid == 3 && secondgrid == 2)) {
			for (int i = 4; i < 8; i++)
				for (int j = 0; j < 16; j++) {
					carry[j] = blockS[i][j];
					blockS[i][j] = blockS[i + 4][j];
					blockS[i + 4][j] = carry[j];
				}
		} else if ((firstgrid == 3 && secondgrid == 4) || (firstgrid == 4 && secondgrid == 3)) {
			for (int i = 8; i < 12; i++)
				for (int j = 0; j < 16; j++) {
					carry[j] = blockS[i][j];
					blockS[i][j] = blockS[i + 4][j];
					blockS[i + 4][j] = carry[j];
				}
		} else if ((firstgrid == 1 && secondgrid == 3) || (firstgrid == 3 && secondgrid == 1)) {
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 16; j++) {
					carry[j] = blockS[i][j];
					blockS[i][j] = blockS[i + 8][j];
					blockS[i + 8][j] = carry[j];
				}
		} else if ((firstgrid == 2 && secondgrid == 4) || (firstgrid == 4 && secondgrid == 2)) {
			for (int i = 4; i < 8; i++)
				for (int j = 0; j < 16; j++) {
					carry[j] = blockS[i][j];
					blockS[i][j] = blockS[i + 8][j];
					blockS[i + 8][j] = carry[j];
				}
		}
																																// Switching complete of tow grids
		
		int firstnum, secondnum, shuffle;																						// suffling the puzzle

		shuffle = 4 + R_num.nextInt(8);

		for (int k = 0; k < shuffle; k++) {
			firstnum = 1 + R_exnum.nextInt(16);
			secondnum = 1 + R_exnum.nextInt(16);
			
			for (int i = 0; i < 16; i++)
				for (int j = 0; j < 16; j++) {
					if (blockS[i][j] == firstnum) {
						blockS[i][j] = secondnum;
						continue;
					}

					if (blockS[i][j] == secondnum) blockS[i][j] = firstnum;
				}
		}
		return blockS;
	}

	int[][] save() {																											// will save the complete puzzle
		if (gc == 0) blockc = generate();

		gc = 1;

		return blockc;
	}

		int[][] hide() {																										// will hide number of puzzle
			for (int i = 0; i < 16; i++)
				for (int j = 0; j < 16; j++)
					blockh[i][j] = blockc[i][j];

			int row, column, hidingnum;

			hidingnum = 158 + R_num.nextInt(17);

			for (int i = 0; i < hidingnum; i++) {
				row = H_Rnum.nextInt(16);
				column = H_Rnum.nextInt(16);

				blockh[row][column] = 0;
			}
			return blockh;
		}
}