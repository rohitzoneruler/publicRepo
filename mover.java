package com;

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class mover {
	private void createWindow() throws AWTException, IOException {
		JFrame frame = new JFrame("Simple GUI");
		ClockLabel dateLable = new ClockLabel("date");
		ClockLabel timeLable = new ClockLabel("time");
		ClockLabel dayLable = new ClockLabel("day");
		JLabel textt = new JLabel("textt");
		frame.setTitle("Hold Here To Drag");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, screenSize.width, screenSize.height);
		frame.setLayout(new BorderLayout());
		timeLable.setBounds(0, (screenSize.height - 300), 300, 100);
		dayLable.setBounds(0, (screenSize.height - 250), 225, 200);
		dateLable.setBounds(226, (screenSize.height - 250), 350, 200);
		textt.setBounds(0, (screenSize.height - 480), 400, 200);

		textt.setText("Press Ctrl+Alt+Delete to unlock.");
		textt.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		textt.setForeground(Color.WHITE);
		textt.setHorizontalAlignment(SwingConstants.LEFT);

		frame.add(textt);
		frame.add(timeLable);
		frame.add(dayLable);
		frame.add(dateLable);

		frame.add(new JLabel(new ImageIcon(ImageIO.read(new File("images\\img4.jpg")))));

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);

		frame.setAlwaysOnTop(true);
		frame.setLocationByPlatform(true);
		 
		frame.setVisible(true);
		frame.isAlwaysOnTop();

		java.util.Timer time = new java.util.Timer(); // Instantiate Timer
														// Object
		ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask
		st.intiate();
		time.schedule(st, 0, 30000);
		frame.setCursor(frame.getToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB),
				new Point(), null));
	}

	public static void main(String[] args) throws AWTException, IOException {
		mover mv = new mover();
		mv.createWindow();
	}

}

class ClockLabel extends JLabel implements ActionListener {

	String type;
	SimpleDateFormat sdf;

	public ClockLabel(String type) {
		this.type = type;
		setForeground(Color.green);

		switch (type) {
		case "date":
			sdf = new SimpleDateFormat("MMMM dd");
			setFont(new Font("Segoe UI Light", Font.PLAIN, 50));
			setForeground(Color.WHITE);
			setHorizontalAlignment(SwingConstants.LEFT);
			break;
		case "time":
			sdf = new SimpleDateFormat("h:mm");
			setFont(new Font("Segoe UI Light", Font.PLAIN, 90));
			setForeground(Color.WHITE);
			setHorizontalAlignment(SwingConstants.LEFT);
			break;
		case "day":
			sdf = new SimpleDateFormat("EEEE,");
			setFont(new Font("Segoe UI Light", Font.PLAIN, 50));
			setForeground(Color.WHITE);
			setHorizontalAlignment(SwingConstants.LEFT);
			break;

		default:
			sdf = new SimpleDateFormat();
			break;
		}

		Timer t = new Timer(1000, this);
		t.start();
	}

	public void actionPerformed(ActionEvent ae) {
		Date d = new Date();
		setText(sdf.format(d));
	}
}
