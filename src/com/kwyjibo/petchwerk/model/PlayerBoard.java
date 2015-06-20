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
	
}
