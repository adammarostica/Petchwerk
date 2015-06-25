package com.kwyjibo.petchwerk.model;

public class PlayerBoard {
	
	private boolean[][] spots = new boolean[9][9];
	
	public PlayerBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				spots[i][j] = false;
			}
		}
	}
	
	public boolean[][] getSpots() {
		return this.spots;
	}
	
	public boolean checkPlacement(Piece piece, int x, int y) {
		boolean canPlace = true;
		try {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (piece.getShape()[i][j] == true &&
							this.spots[x+i][y+j] == true) {
								canPlace = false;
					}
				}
			}
		}
		finally {}
		return canPlace;
	}
	
	public void placePiece(Piece piece, int x, int y) throws ArrayIndexOutOfBoundsException {
		try {
			if (checkPlacement(piece, x, y)){
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (piece.getShape()[i][j] == true) {
							this.spots[x+i][y+j] = true;
						}
					}
				}
			}
			else System.out.println("Placement at " + x + ", " + y + " failed. Existing piece.");
		}
		catch (Exception e) {
			System.out.println("Placement at " + x + ", " + y + " failed. Out of bounds.");
		}
		finally {}
	}
	
	public void printMe() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (this.getSpots()[i][j]) {
					System.out.print("[X]");
				}
				else System.out.print("[ ]");
			}
			System.out.println();
		}
	}
}
