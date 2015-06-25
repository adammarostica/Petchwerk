package test.com.kwyjibo.petchwerk.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kwyjibo.petchwerk.model.Piece;
import com.kwyjibo.petchwerk.model.PlayerBoard;

public class ModelTests {
	
	
	/*@Test
	public void testRotate() {
		//create a piece, print and rotate
		System.out.println("Create, print, rotate.");
		Piece piece1 = new Piece(2, 2, 0, 1+2+64+128+4096);
		piece1.printMe();
		System.out.println("Rotate.");
		piece1.rotate();
		piece1.printMe();
		System.out.println("Rotate.");
		piece1.rotate();
		piece1.printMe();
		System.out.println("Rotate.");
		piece1.rotate();
		piece1.printMe();
	}*/
	
	@Test
	public void testPlayerBoard() {
		PlayerBoard pb1 = new PlayerBoard();
		Piece piece1 = new Piece(2, 2, 0, 1+2+64+128+4096);
		piece1.rotate();
		piece1.rotate();
		pb1.placePiece(piece1, 1, 0);
		piece1.rotate();
		piece1.rotate();
		pb1.placePiece(piece1, 10, 0);
		pb1.printMe();
	}

}
