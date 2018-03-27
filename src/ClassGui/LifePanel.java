package ClassGui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.MouseMotionAdapter;

public class LifePanel extends JPanel {

	private boolean ccolor = false;
	private int cellsize = 50;
	private Timer timer;
	private boolean Started = false;
	private int timerSpeed = 500;
	private int shape = 3;
	public Grid Universe = new Grid(this.getWidth() / cellsize,
			this.getHeight() / cellsize, true, true);

	public void setConways() {
		Universe.setConways(true);
	}

	public void setCustom() {
		Universe.setConways(false);
	}

	public void setWrapped() {
		if (Universe.getWrapped()) {
			Universe.setWrapped(false);
		} else {
			Universe.setWrapped(true);
		}
	}

	public int getCellsize() {
		return cellsize;
	}

	public void setCellsize(int cellsize) {
		this.cellsize = cellsize;
	}

	public Timer getTimer() {
		return timer;
	}

	public void stopTimer() {
		Started = false;
		timer.stop();
	}

	public void Step() {
		Universe = (Grid)Universe.ApplyRule(Universe);
		repaint();
	}

	public void loadPreset() {
		Universe.clear();
		if (shape % 3 == 0) {
			Universe.setGridCell((this.getWidth() / cellsize) / 2,
					(this.getHeight() / cellsize) / 2, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 + 1,
					(this.getHeight() / cellsize) / 2, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 - 1,
					(this.getHeight() / cellsize) / 2, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 - 1,
					(this.getHeight() / cellsize) / 2 - 1, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2,
					(this.getHeight() / cellsize) / 2 - 2, true);
			shape++;
		} else if (shape % 3 == 1) {
			Universe.setGridCell((this.getWidth() / cellsize) / 2 + 1,
					(this.getHeight() / cellsize) / 2, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2,
					(this.getHeight() / cellsize) / 2, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 - 1,
					(this.getHeight() / cellsize) / 2, true);
			shape++;
		} else {
			Universe.setGridCell((this.getWidth() / cellsize) / 2,
					(this.getHeight() / cellsize) / 2, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 - 1,
					(this.getHeight() / cellsize) / 2, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 - 1,
					(this.getHeight() / cellsize) / 2 - 1, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2,
					(this.getHeight() / cellsize) / 2 - 1, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 - 1,
					(this.getHeight() / cellsize) / 2 - 2, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 - 1,
					(this.getHeight() / cellsize) / 2 - 3, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 - 1,
					(this.getHeight() / cellsize) / 2 - 4, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 + 1,
					(this.getHeight() / cellsize) / 2, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 + 1,
					(this.getHeight() / cellsize) / 2 - 1, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 + 1,
					(this.getHeight() / cellsize) / 2 - 2, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2,
					(this.getHeight() / cellsize) / 2 - 2, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 + 1,
					(this.getHeight() / cellsize) / 2 - 3, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 + 1,
					(this.getHeight() / cellsize) / 2 - 4, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2,
					(this.getHeight() / cellsize) / 2 + 3, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2,
					(this.getHeight() / cellsize) / 2 - 4, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2,
					(this.getHeight() / cellsize) / 2 + 1, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 - 1,
					(this.getHeight() / cellsize) / 2 + 1, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 - 1,
					(this.getHeight() / cellsize) / 2 + 2, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 - 1,
					(this.getHeight() / cellsize) / 2 + 3, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 + 1,
					(this.getHeight() / cellsize) / 2 + 1, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 + 1,
					(this.getHeight() / cellsize) / 2 + 2, true);
			Universe.setGridCell((this.getWidth() / cellsize) / 2 + 1,
					(this.getHeight() / cellsize) / 2 + 3, true);
			shape++;
		}
		repaint();
	}

	public void slower() {
		if (timerSpeed <= 1000) {
			timer.stop();
			timerSpeed = timerSpeed + 100;
			timer = new Timer(timerSpeed, new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Universe = (Grid)Universe.ApplyRule(Universe);
					repaint();
				}
			});
			timer.start();
		}
	}

	public void faster() {
		if (timerSpeed >= 200) {
			timer.stop();
			timerSpeed = timerSpeed - 100;
			timer = new Timer(timerSpeed, new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Universe = (Grid)Universe.ApplyRule(Universe);
					repaint();
				}
			});

			timer.start();
		}
	}

	public void clear() {
		Universe.clear();
	}

	public void startTimer() {
		if (!Started) {
			timer = new Timer(timerSpeed, new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Universe = (Grid)Universe.ApplyRule(Universe);
					repaint();
				}
			});
			Started = true;
			timer.start();
		}
	}

	public void setCcolor(boolean ccolor) {
		this.ccolor = ccolor;
	}

	public boolean getCcolor() {
		return this.ccolor;
	}

	private JFrame owner;

	/**
	 * Create the panel.
	 */
	public LifePanel(JFrame o) {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				setToolTipText("(" + arg0.getX()/cellsize + ", " + arg0.getY()/cellsize + ")");
			}
		});
		
		
		System.out.println("worked");
		owner = o;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Universe.setGridCell(arg0.getX() / cellsize, arg0.getY()
						/ cellsize);
				ccolor = !ccolor;
				repaint(); // DO NOT CALL paint() DIRECTLY!!!
			}
		});
		setBackground(Color.BLACK);
	}

	public void paint(Graphics g) {
		int tempHeight = this.getWidth();
		int tempWidth = this.getHeight();
		super.paint(g);
		Graphics2D g2d = null;
		if (g instanceof Graphics2D) {
			g2d = (Graphics2D) g;
		}

		try {
			if (tempHeight / cellsize > Universe.getHeight()) {
				Universe.setHeight(tempHeight / cellsize);
			}
			if (tempWidth / cellsize > Universe.getWidth()) {
				Universe.setWidth(tempWidth / cellsize);
			}
			if (ccolor) {
				g2d.setColor(Color.RED);
			} else {
				g2d.setColor(Color.BLUE);
			}
			g2d.setColor(Color.GREEN);
			for (int i = 0; i < this.getHeight(); i += cellsize) {
				g2d.drawLine(0, i, this.getWidth(), i);
			}
			for (int i = 0; i < this.getWidth(); i += cellsize) {
				g2d.drawLine(i, 0, i, this.getHeight());
			}
			for (int j = 0; j < Universe.getHeight(); j++) {
				for (int i = 0; i < Universe.getWidth(); i++) {
					if (Universe.getGridCell(j, i)) {
						g2d.fillRect(j * cellsize, i * cellsize, cellsize,
								cellsize);
					}
				}
			}
		} catch (NullPointerException e) {
			System.out.println("update your JVM");
		}
	}
}
