package com.xiaotian.main;

import com.xiaotian.main.Player.Status;

public class Set {
	Player player1;
	Player player2;
	SetStatus setStatus = SetStatus.NotEnd;

	public enum SetStatus {
		NotEnd, Player1Win, Player2Win;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Set(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public SetStatus getSetStatus() {
		return setStatus;
	}

	public void setSetStatus(SetStatus setStatus) {
		this.setStatus = setStatus;
	}

	public void player1WinPoint() {

		if (player1.getSetPoint() == 6 && player2.getSetPoint() == 6) {
			player1.winLastGamePoint();
			if (player1.getPoint() >= 6 && player1.getPoint() - player2.getPoint() >= 2) {
				player1.winSet();
				setStatus = SetStatus.Player1Win;
			}
		} else {

			if (player2.getStatus() == Status.ADVANTAGE) {
				player1.setStatus(Status.DEUCE);
				player2.setStatus(Status.DEUCE);
			} else if (player1.getStatus() == Status.ADVANTAGE) {
				player1.setStatus(Status.WIN);
			} else if (player1.getStatus() == Status.DEUCE) {
				player1.setStatus(Status.ADVANTAGE);
			} else {
				player1.winPoint();
				if (player2.getPoint() == 40 && player1.getPoint() == 40) {
					player1.setStatus(Status.DEUCE);
					player2.setStatus(Status.DEUCE);
				}
			}
			if (player1.getStatus() == Status.WIN) {
				player1.winSet();
				player2.lossSet();
				System.out.println(player1.getSetPoint());
				if (player1.getSetPoint() >= 6 && player1.getSetPoint() - player2.getSetPoint() >= 2) {
					setStatus = SetStatus.Player1Win;
				}
			}
		}
	}

	public void player2WinPoint() {
		if (player1.getSetPoint() == 6 && player2.getSetPoint() == 6) {
			player2.winLastGamePoint();
			if (player2.getPoint() >= 6 && player2.getPoint() - player1.getPoint() >= 2) {
				player2.winSet();
				setStatus = SetStatus.Player2Win;
			}
		} else {
			if (player1.getStatus() == Status.ADVANTAGE) {
				player1.setStatus(Status.DEUCE);
				player2.setStatus(Status.DEUCE);
			} else if (player2.getStatus() == Status.ADVANTAGE) {
				player2.setStatus(Status.WIN);
			} else if (player2.getStatus() == Status.DEUCE) {
				player2.setStatus(Status.ADVANTAGE);
			} else {
				player2.winPoint();
				if (player2.getPoint() == 40 && player1.getPoint() == 40) {
					player1.setStatus(Status.DEUCE);
					player2.setStatus(Status.DEUCE);
				}
			}
			if (player2.getStatus() == Status.WIN) {
				player2.winSet();
				player1.lossSet();

				if (player2.getSetPoint() >= 6 && player2.getSetPoint() - player1.getSetPoint() >= 2)
					setStatus = SetStatus.Player2Win;
			}

		}
	}

}
