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
		//LATER
	}
	
	public void flip() {
		//LATER
	}


}
