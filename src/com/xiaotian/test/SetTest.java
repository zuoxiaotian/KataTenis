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
	public void setTestSimple(){
		set.getPlayer1().setSetPoint(5);
		set.getPlayer2().setSetPoint(3);
		// 5 - 3
		
		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		assertEquals(set.getSetStatus(), SetStatus.Player1Win);
	}
	

	@Test
	public void setTestLeadBy2Test(){
		
		set.getPlayer1().setSetPoint(5);
		set.getPlayer2().setSetPoint(5);
		// 5 - 5

		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		// 6 - 5
		assertEquals(set.getSetStatus(), SetStatus.NotEnd);
		
		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		// 7 - 5
		System.out.println(set.getPlayer1().getSetPoint() + " " + set.getPlayer2().getSetPoint());
		assertEquals(set.getSetStatus(), SetStatus.Player1Win);
	}
	

	@Test
	public void lastGameTest(){
		
		set.getPlayer1().setSetPoint(5);
		set.getPlayer2().setSetPoint(5);
		// 5 - 5

		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		// 6 - 5
		assertEquals(set.getSetStatus(), SetStatus.NotEnd);
		
		set.player2WinPoint();
		set.player2WinPoint();
		set.player2WinPoint();
		set.player2WinPoint();
		// 6 - 6
		assertEquals(set.getSetStatus(), SetStatus.NotEnd);
		
		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		set.player2WinPoint();
		set.player2WinPoint();
		set.player2WinPoint();
		set.player2WinPoint();
		
		set.player1WinPoint();
		// 6 - 4
		assertEquals(set.getSetStatus(), SetStatus.Player1Win);
	}
	

	@Test
	public void lastGameTestLeadBy2(){
		
		set.getPlayer1().setSetPoint(5);
		set.getPlayer2().setSetPoint(5);
		// 5 - 5

		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		// 6 - 5
		assertEquals(set.getSetStatus(), SetStatus.NotEnd);
		
		set.player2WinPoint();
		set.player2WinPoint();
		set.player2WinPoint();
		set.player2WinPoint();
		// 6 - 6
		assertEquals(set.getSetStatus(), SetStatus.NotEnd);
		
		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		set.player1WinPoint();
		set.player2WinPoint();
		set.player2WinPoint();
		set.player2WinPoint();
		set.player2WinPoint();
		
		set.player2WinPoint();
		// 5 - 5
		assertEquals(set.getSetStatus(), SetStatus.NotEnd);
		
		set.player1WinPoint();
		// 6 - 5
		assertEquals(set.getSetStatus(), SetStatus.NotEnd);
		
		set.player1WinPoint();
		// 7 - 5
		assertEquals(set.getSetStatus(), SetStatus.Player1Win);
	}
	
}
