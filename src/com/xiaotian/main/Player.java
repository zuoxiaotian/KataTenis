package com.xiaotian.main;

public class Player {
	private int point;
	private int setPoint;

	public enum Status {
		DEUCE, ADVANTAGE, NORMAL, WIN;
	}

	Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Player() {
		initMatchScore();
		initSetScore();
	}

	public void initMatchScore() {
		point = 0;
		setPoint = 0;
		status = Status.NORMAL;
	}

	public void initSetScore() {
		point = 0;
		status = Status.NORMAL;
	}

	public void winPoint() {
		if (point == 0) {
			point = 15;
		} else if (point == 15) {
			point = 30;
		} else if (point == 30) {
			point = 40;
		} else {
			status = Status.WIN;
		}
	}

	public void lossPoint() {
		if (point == 40 && status == Status.ADVANTAGE) {
			status = Status.DEUCE;
		}
	}

	public void winSet() {
		initSetScore();
		status = Status.NORMAL;
		setPoint += 1;

	}

	public void lossSet() {
		initSetScore();
		status = Status.NORMAL;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public void setSetPoint(int setPoint) {
		this.setPoint = setPoint;
	}

	public int getPoint() {
		return point;
	}

	public int getSetPoint() {
		return setPoint;
	}
}
