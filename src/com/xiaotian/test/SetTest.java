package com.xiaotian.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xiaotian.main.Player;
import com.xiaotian.main.Player.Status;
import com.xiaotian.main.Set.SetStatus;
import com.xiaotian.main.Set;

public class SetTest {
	
	Player player1;
	Player player2;
	Set set;
	
	@Before
	public void setUp() throws Exception {
		player1 = new Player();
		player2 = new Player();
		set = new Set(player1, player2); 
	}

	@Test
	public void winPointTest() {
		set.player1WinPoint();
		assertEquals(set.getPlayer1().getPoint(), 15);
		set.player1WinPoint();
		assertEquals(set.getPlayer1().getPoint(), 30);
		set.player1WinPoint();
		assertEquals(set.getPlayer1().getPoint(), 40);
	}
	
	@Test
	public void winSetTest(){
		set.player1WinPoint();
		assertEquals(set.getPlayer1().getPoint(), 15);
		set.player1WinPoint();
		assertEquals(set.getPlayer1().getPoint(), 30);
		set.player1WinPoint();
		assertEquals(set.getPlayer1().getPoint(), 40);
		set.player1WinPoint();
		assertEquals(set.getPlayer1().getPoint(), 0);
		assertEquals(set.getPlayer1().getSetPoint(), 1);
	}
	

	@Test
	public void deuceAdvantageTest(){
		
		set.getPlayer1().setPoint(40);
		set.getPlayer2().setPoint(30);
		set.player2WinPoint();
		// player1 40:40 player2
		
		assertEquals(set.getPlayer2().getPoint(), 40);
		assertEquals(set.getPlayer1().getStatus(), Status.DEUCE);
		assertEquals(set.getPlayer2().getStatus(), Status.DEUCE);
		// deuce
		// player1 win 1 point, change game to player1 advantage
		set.player1WinPoint();
		assertEquals(set.getPlayer1().getPoint(), 40);
		assertEquals(set.getPlayer1().getStatus(), Status.ADVANTAGE);
		assertEquals(set.getPlayer2().getStatus(), Status.DEUCE);
		
		// player2 win 1 point, change game to deuce
		set.player2WinPoint();
		assertEquals(set.getPlayer1().getPoint(), 40);
		assertEquals(set.getPlayer1().getStatus(), Status.DEUCE);
		assertEquals(set.getPlayer2().getStatus(), Status.DEUCE);

		// player1 win 2 point, win this set
		set.player1WinPoint();
		set.player1WinPoint();
		assertEquals(set.getPlayer1().getPoint(), 0);
		assertEquals(set.getPlayer2().getPoint(), 0);
		assertEquals(set.getPlayer1().getSetPoint(), 1);
		assertEquals(set.getPlayer2().getSetPoint(), 0);
		assertEquals(set.getPlayer1().getStatus(), Status.NORMAL);
		assertEquals(set.getPlayer2().getStatus(), Status.NORMAL);
	}
	
	@Test
	public void setTest(){
		set.getPlayer1().winSet();
		set.getPlayer2().winSet();
		set.getPlayer1().winSet();
		set.getPlayer1().winSet();
		set.getPlayer2().winSet();
		set.getPlayer1().winSet();
		set.getPlayer2().winSet();
		set.getPlayer1().winSet();
		// 5 - 3
		
		set.getPlayer1().winSet();
		assertEquals(set.getSetStatus(), SetStatus.Player1Win);
		

		set.getPlayer1().winSet();
		set.getPlayer1().winSet();
		set.getPlayer1().winSet();
		set.getPlayer1().winSet();
		set.getPlayer1().winSet();
		set.getPlayer2().winSet();
		set.getPlayer2().winSet();
		set.getPlayer2().winSet();
		set.getPlayer2().winSet();
		set.getPlayer2().winSet();
		// 5 - 5

		set.getPlayer1().winSet();
		// 6 - 5
		assertEquals(set.getSetStatus(), SetStatus.NotEnd);
		set.getPlayer2().winSet();
		// 6 - 6
		assertEquals(set.getSetStatus(), SetStatus.NotEnd);
		set.getPlayer2().winSet();
		// 6 - 7
		assertEquals(set.getSetStatus(), SetStatus.Player2Win);
	}
	
	@Test
	public void tieBackTest(){
		set.getPlayer1().setSetPoint(6);
		set.getPlayer2().setSetPoint(6);
		
		set.getPlayer1().winPoint();
		set.getPlayer1().winPoint();
		set.getPlayer2().winPoint();
		set.getPlayer1().winPoint();
		set.getPlayer1().winPoint();
		set.getPlayer2().winPoint();
		set.getPlayer1().winPoint();
		set.getPlayer1().winPoint();
		// 6 - 2
		assertEquals(set.getPlayer1().getStatus(), Status.WIN);

		set.getPlayer1().winPoint();
		set.getPlayer1().winPoint();
		set.getPlayer2().winPoint();
		set.getPlayer1().winPoint();
		set.getPlayer1().winPoint();
		set.getPlayer2().winPoint();
		set.getPlayer1().winPoint();
		set.getPlayer2().winPoint();
		set.getPlayer2().winPoint();
		
		set.getPlayer2().winPoint();
		// 5 - 5
		assertEquals(set.getPlayer1().getStatus(), Status.NORMAL);
		assertEquals(set.getPlayer2().getStatus(), Status.NORMAL);

		set.getPlayer1().winPoint();
		// 6 - 5
		assertEquals(set.getPlayer1().getStatus(), Status.NORMAL);
		assertEquals(set.getPlayer2().getStatus(), Status.NORMAL);

		set.getPlayer2().winPoint();
		// 6 - 6
		assertEquals(set.getPlayer1().getStatus(), Status.NORMAL);
		assertEquals(set.getPlayer2().getStatus(), Status.NORMAL);

		set.getPlayer1().winPoint();
		// 7 - 6
		assertEquals(set.getPlayer1().getStatus(), Status.NORMAL);
		assertEquals(set.getPlayer2().getStatus(), Status.NORMAL);
		
		set.getPlayer1().winPoint();
		// 8 - 6
		assertEquals(set.getPlayer1().getStatus(), Status.WIN);

	}
 
}
