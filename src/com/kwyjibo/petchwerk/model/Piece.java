package com.kwyjibo.petchwerk.model;

public class Piece {

	private int buttonCost;
	private int timeCost;
	private int buttonIncome;
	private boolean[][] shape;
	
	public Piece(int buttonCost, int timeCost, int buttonIncome, long bits) {
		this.buttonCost = buttonCost;
		this.timeCost = timeCost;
		this.buttonIncome = buttonIncome;
		this.shape = this.setFromBits(bits);
	}

	public int getButtonCost() {
		return buttonCost;
	}

	public int getTimeCost() {
		return timeCost;
	}
	
	public int getButtonIncome() {
		return this.buttonIncome;
	}
	
	public boolean[][] getShape() {
		return this.shape;
	}
	
	protected boolean[][] setFromBits(long bits) {
		shape = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int bit = i * 5 + j;
				long flag = (long) Math.pow(2, bit);
				if ((bits & flag) > 0) {
					shape[i][j] = true;
				}
			}
		}
		return shape;
	}
	
	public void rotate() {
		boolean[][] newBool = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (this.shape[i][j]) {
					newBool[j][i] = true;
				}
			}
		}
		this.shape = newBool;
		this.flip();
		this.corner();
	}
	
	public void flip() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 2; j++) {
				boolean temp = this.shape[i][j];
				this.shape[i][j] = this.shape[i][4-j];
				this.shape[i][4-j] = temp;
			}
		}
	}
	
	public void testAlg() {
		if (this.shape[0][0] == false &&
				this.shape[1][0] == false &&
				this.shape[2][0] == false &&
				this.shape[3][0] == false &&
				this.shape[4][0] == false) {
			System.out.println("1st column is empty");
		}
		else {
			System.out.println("1st column is not empty");
		}
	}
	
	public void corner() {
		while (this.shape[0][0] == false &&
				this.shape[1][0] == false &&
				this.shape[2][0] == false &&
				this.shape[3][0] == false &&
				this.shape[4][0] == false) {
			for (int i = 0; i < 5; i++) {
				boolean[] newBool = new boolean[5];
				newBool[0] = this.shape[i][1];
				newBool[1] = this.shape[i][2];
				newBool[2] = this.shape[i][3];
				newBool[3] = this.shape[i][4];
				this.shape[i] = newBool;
			}
		}
	}
	
	public void printMe() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (this.getShape()[i][j]) {
					System.out.print("[X]");
				}
				else System.out.print("[ ]");
			}
			System.out.println();
		}
	}


}
