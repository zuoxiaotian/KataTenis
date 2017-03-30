package com.xiaotian.main;

public class Player {
	private int point;
	private int setPoint;

	public void setPoint(int point) {
		this.point = point;
	}

	public void setSetPoint(int setPoint) {
		this.setPoint = setPoint;
	}

	public enum Status {
		DEUCE, ADVANTAGE, NORMAL;
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

	public int getPoint() {
		return point;
	}

	public int getSetPoint() {
		return setPoint;
	}

	public void winPoint() {

	}

	private void setEnd() {

	}

	private void matchEnd() {

	}

}
