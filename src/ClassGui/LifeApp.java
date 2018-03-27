package ClassGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class LifeApp extends JFrame {

	private JPanel contentPane;
	private LifeControls controlpanel;
	private LifePanel graphicspanel;

	public LifeControls getControlpanel() {
		return controlpanel;
	}

	public LifePanel getGraphicspanel() {
		return graphicspanel;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LifeApp frame = new LifeApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LifeApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		controlpanel = new LifeControls(this);
		contentPane.add(controlpanel, BorderLayout.WEST);

		graphicspanel = new LifePanel(this);
		contentPane.add(graphicspanel, BorderLayout.CENTER);
	}
}
