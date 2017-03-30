package com.xiaotian.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.xiaotian.main.Player;
import com.xiaotian.main.Player.Status;

public class PlayerTest {

	Player player;
	
	@Before
	public void setUp() throws Exception {
		player = new Player();
		
	}

	@Test
	public void winPointTest() {
		player.winPoint();
		assertEquals(player.getPoint(), 15);
		player.winPoint();
		assertEquals(player.getPoint(), 30);
		player.winPoint();
		assertEquals(player.getPoint(), 40);
	}


	@Test
	public void winSetTest() {
		player.winPoint();
		assertEquals(player.getPoint(), 15);
		player.winPoint();
		assertEquals(player.getPoint(), 30);
		player.winPoint();
		assertEquals(player.getPoint(), 40);
		player.winPoint();
		assertEquals(player.getStatus(), Status.WIN);
	}
	
	@Test
	public void initSetScoreTest() {
		player.winPoint();
		player.winPoint();
		player.winPoint();
		player.initSetScore();
		assertEquals(player.getPoint(), 0);
		assertEquals(player.getStatus(), Status.NORMAL);
	}

	@Test
	public void initMatchScoreTest() {
		player.winPoint();
		player.winPoint();
		player.winPoint();
		player.winPoint();
		player.winPoint();
		player.initMatchScore();
		assertEquals(player.getPoint(), 0);
		assertEquals(player.getSetPoint(), 0);
	}


}
