package com.kwyjibo.petchwerk.model;

import java.util.Stack;

public class Player {
	
	private int buttons;
	private int time;
	private int buttonIncome;
	private PlayerBoard board;
	private Stack<Integer> paydays;
	
	public Player() {
		this.buttons = 5;
		this.time = 0;
		this.buttonIncome = 0;
		this.board = new PlayerBoard();
		this.paydays = new Stack<Integer>();
		paydays.push(53);
		paydays.push(47);
		paydays.push(41);
		paydays.push(35);
		paydays.push(29);
		paydays.push(23);
		paydays.push(17);
		paydays.push(11);
		paydays.push(5);
	}
	
	public int getButtons() {
		return this.buttons;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public PlayerBoard getBoard() {
		return this.board;
	}
	
	public void receiveIncome() {
		this.buttons += this.buttonIncome;
	}
	
	public void passOpponent(Player opponent) {
		int difference = opponent.getTime() - this.time;
		this.time += difference + 1;
		this.buttons += difference + 1;
	}
	
	public void placePiece(int x, int y, Piece piece) {
		//implement later
		this.time += piece.getTimeCost();
		this.buttons -= piece.getButtonCost();
		this.buttonIncome += piece.getButtonIncome();
		int top = paydays.peek();
		if (this.time >= top) {
			this.receiveIncome();
			paydays.pop();
		}
	}

}
