package com;

import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;
import java.util.Date;

public class ScheduledTask extends TimerTask {

	// Add your task here
	int max, min, randomNum;
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	Robot robot;

	public void intiate() throws AWTException {
		System.out.println("sss");
		robot = new Robot();
		max = gd.getDisplayMode().getWidth();
		min = 0;
	}

	public void run() {
		try {
			randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			robot.mouseMove(randomNum, randomNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
