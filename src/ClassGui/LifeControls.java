package ClassGui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;

public class LifeControls extends JPanel {

	private JFrame owner;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 * @return 
	 */
	public LifeControls(JFrame o) {
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		owner = o;
		setLayout(new GridLayout(13, 1, 0, 0));

		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Start");
				if (owner instanceof LifeApp) {
					LifeApp ma = (LifeApp) owner;
					ma.getGraphicspanel().startTimer();
					ma.getGraphicspanel().setCcolor(false);
					ma.getGraphicspanel().repaint();
				}
			}
		});
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Stop");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Stop");
				if (owner instanceof LifeApp) {
					LifeApp ma = (LifeApp) owner;
					ma.getGraphicspanel().stopTimer();
					ma.getGraphicspanel().setCcolor(true);
					ma.getGraphicspanel().repaint();
				}
			}
		});

		JButton btnNewButton_4 = new JButton("Load Preset");
		add(btnNewButton_4);

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (owner instanceof LifeApp) {
					LifeApp ma = (LifeApp) owner;
					ma.getGraphicspanel().loadPreset();
					ma.getGraphicspanel().repaint();
				}
			}
		});
		add(btnNewButton_1);

		JButton btnSlower = new JButton("Slower");
		btnSlower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (owner instanceof LifeApp) {
					LifeApp ma = (LifeApp) owner;
					ma.getGraphicspanel().slower();
					ma.getGraphicspanel().repaint();
				}
			}
		});

		JButton btnNewButton_5 = new JButton("Faster");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (owner instanceof LifeApp) {
					LifeApp ma = (LifeApp) owner;
					ma.getGraphicspanel().faster();
					ma.getGraphicspanel().repaint();
				}
			}
		});
		add(btnNewButton_5);

		JButton btnClear = new JButton("Clear");
		add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (owner instanceof LifeApp) {
					LifeApp ma = (LifeApp) owner;
					ma.getGraphicspanel().clear();
					ma.getGraphicspanel().repaint();
				}
			}
		});
		add(btnSlower);

		JButton btnNewButton_3 = new JButton("Step");
		add(btnNewButton_3);

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (owner instanceof LifeApp) {
					LifeApp ma = (LifeApp) owner;
					ma.getGraphicspanel().Step();
					ma.getGraphicspanel().repaint();
				}
			}
		});

		JButton btnNewButton_7 = new JButton("Save");
		add(btnNewButton_7);
		JButton btnNewButton_6 = new JButton("Load");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (owner instanceof LifeApp) {
					ObjectInputStream ois;
					LifeApp ma = (LifeApp) owner;
					String line = null;
					JFileChooser fileChooser = new JFileChooser();
				      int returnValue = fileChooser.showOpenDialog(null);
				      if (returnValue == JFileChooser.APPROVE_OPTION) 
				      {
				        File selectedFile = fileChooser.getSelectedFile();
				        try
						{
							java.awt.Desktop.getDesktop().open(new File(System.getProperty("user.home")));
						} catch (IOException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				        
					      try {
					            // FileReader reads text files in the default encoding.
					            FileReader fileReader = 
					                new FileReader(selectedFile);

					            // Always wrap FileReader in BufferedReader.
					            BufferedReader bufferedReader = 
					                new BufferedReader(fileReader);

					            while((line = bufferedReader.readLine()) != null) {
					               // System.out.println(line);
					                String [] str = line.split(",");
					            }   

					            // Always close files.
					            bufferedReader.close();         
					        }
					        catch(FileNotFoundException ex) {
					            System.out.println(
					                "Unable to open file '" + 
					                selectedFile + "'");                
					        }
					        catch(IOException ex) {
					            System.out.println(
					                "Error reading file '" 
					                + selectedFile + "'");                  
					            // Or we could just do this: 
					            // ex.printStackTrace();
					        }
					ma.getGraphicspanel().repaint();
				}
			}
			}
		});

		JButton btnNewButton_2 = new JButton("Resize Cells");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int x = Integer.parseInt(textField.getText());
					if (owner instanceof LifeApp) {
						LifeApp ma = (LifeApp) owner;
						ma.getGraphicspanel().setCellsize(x);
						ma.getGraphicspanel().repaint();
					}
				} catch (NumberFormatException e1) {
					System.out.println("Only Letters Allowed In Text Field");
				}
			}
		});

		add(btnNewButton_2);

		add(btnNewButton_6);

		btnNewButton_7.addActionListener(new ActionListener() {
			private ObjectOutputStream oos;

			public void actionPerformed(ActionEvent arg0) {

				if (owner instanceof LifeApp) {
					LifeApp ma = (LifeApp) owner;
					JFileChooser fileChooser = new JFileChooser();
				      int returnValue = fileChooser.showSaveDialog(null);
				      if (returnValue == JFileChooser.APPROVE_OPTION) 
				      {
				        File selectedFile = fileChooser.getSelectedFile();
				        try
						{
							java.awt.Desktop.getDesktop().open(new File(System.getProperty("user.home")));
						} catch (IOException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					ma.getGraphicspanel().repaint();
				}
			}
			}
		});

		textField = new JTextField("50");
		add(textField);
		textField.setColumns(10);

		JRadioButton rdbtnConway = new JRadioButton("Conway");
		rdbtnConway.setSelected(true);
		buttonGroup.add(rdbtnConway);
		add(rdbtnConway);
		rdbtnConway.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (owner instanceof LifeApp) {
					System.out.println("Set Conways");
					LifeApp ma = (LifeApp) owner;
					ma.getGraphicspanel().setConways();
					ma.getGraphicspanel().repaint();
				}
			}
		});

		JCheckBox chckbxWrapped = new JCheckBox("Wrapped");
		chckbxWrapped.setSelected(true);
		add(chckbxWrapped);
		chckbxWrapped.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (owner instanceof LifeApp) {
					System.out.println("Set Wrapped");
					LifeApp ma = (LifeApp) owner;
					ma.getGraphicspanel().setWrapped();
					ma.getGraphicspanel().repaint();
				}
			}
		});

		JRadioButton rdbtnCustom = new JRadioButton("Custom");
		buttonGroup.add(rdbtnCustom);
		add(rdbtnCustom);
		rdbtnCustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (owner instanceof LifeApp) {
					System.out.println("Set Custom");
					LifeApp ma = (LifeApp) owner;
					ma.getGraphicspanel().setCustom();
					ma.getGraphicspanel().repaint();
				}
			}
		});
	}

}
