package test.com.kwyjibo.petchwerk.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kwyjibo.petchwerk.model.Piece;

public class ModelTests {

	@Test
	public void test() {
		Piece piece1 = new Piece(2, 2, 0, 1+2+4+64+128+256);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (piece1.getShape()[i][j]) {
					System.out.print("[X]");
				}
				else System.out.print("[ ]");
			}
			System.out.println();
		}
	}

}
