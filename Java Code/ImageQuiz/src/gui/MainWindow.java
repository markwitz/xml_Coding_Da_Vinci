package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainWindow {

	private JFrame mainWindow;

	// TODO http://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.mainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainWindow = new JFrame();
		mainWindow.setBounds(100, 100, 1072, 544);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelText = new JPanel();
		panelText.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		JPanel panelImage = new JPanel();
		panelImage.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		GroupLayout groupLayout = new GroupLayout(mainWindow.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelImage, GroupLayout.PREFERRED_SIZE, 275, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelImage, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 472, Short.MAX_VALUE)
						.addComponent(panelText, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 472, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(MainWindow.class.getResource("/images/Gem\u00E4lde Beispiel 1.jpg")));
		GroupLayout gl_panelImage = new GroupLayout(panelImage);
		gl_panelImage.setHorizontalGroup(
			gl_panelImage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelImage.createSequentialGroup()
					.addGap(5)
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 254, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelImage.setVerticalGroup(
			gl_panelImage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelImage.createSequentialGroup()
					.addGap(5)
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 452, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelImage.setLayout(gl_panelImage);
		
		JPanel panelQuestion = new JPanel();
		
		JLabel lblNewLabel = new JLabel("Question");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		GroupLayout gl_panelQuestion = new GroupLayout(panelQuestion);
		gl_panelQuestion.setHorizontalGroup(
			gl_panelQuestion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelQuestion.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 696, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelQuestion.setVerticalGroup(
			gl_panelQuestion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelQuestion.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelQuestion.setLayout(gl_panelQuestion);
		
		JPanel panelAnswers = new JPanel();
		GridBagLayout gbl_panelAnswers = new GridBagLayout();
		gbl_panelAnswers.columnWidths = new int[]{360, 360, 0};
		gbl_panelAnswers.rowHeights = new int[]{100, 100, 0};
		gbl_panelAnswers.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelAnswers.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelAnswers.setLayout(gbl_panelAnswers);
		
		JButton btnAnswer1 = new JButton("Answer 1");
		btnAnswer1.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnAnswer1 = new GridBagConstraints();
		gbc_btnAnswer1.fill = GridBagConstraints.BOTH;
		gbc_btnAnswer1.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnswer1.gridx = 0;
		gbc_btnAnswer1.gridy = 0;
		panelAnswers.add(btnAnswer1, gbc_btnAnswer1);
		
		JButton btnAnswer2 = new JButton("Answer 2");
		btnAnswer2.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnAnswer2 = new GridBagConstraints();
		gbc_btnAnswer2.fill = GridBagConstraints.BOTH;
		gbc_btnAnswer2.insets = new Insets(0, 0, 5, 0);
		gbc_btnAnswer2.gridx = 1;
		gbc_btnAnswer2.gridy = 0;
		panelAnswers.add(btnAnswer2, gbc_btnAnswer2);
		
		JButton btnAnswer3 = new JButton("Answer 3");
		btnAnswer3.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnAnswer3 = new GridBagConstraints();
		gbc_btnAnswer3.fill = GridBagConstraints.BOTH;
		gbc_btnAnswer3.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnswer3.gridx = 0;
		gbc_btnAnswer3.gridy = 1;
		panelAnswers.add(btnAnswer3, gbc_btnAnswer3);
		
		JButton btnAnswer4 = new JButton("Answer 4");
		btnAnswer4.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnAnswer4 = new GridBagConstraints();
		gbc_btnAnswer4.fill = GridBagConstraints.BOTH;
		gbc_btnAnswer4.gridx = 1;
		gbc_btnAnswer4.gridy = 1;
		panelAnswers.add(btnAnswer4, gbc_btnAnswer4);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblSum = new JLabel("3 out of 10 answered questions were correct.");
		lblSum.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWindow.dispose();
			}
		});
		btnClose.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JLabel lblResult = new JLabel("Your last answer was correct!");
		lblResult.setForeground(new Color(0, 153, 51));
		lblResult.setBackground(new Color(0, 255, 102));
		lblResult.setFont(new Font("Verdana", Font.PLAIN, 14));
		GroupLayout gl_panelMenu = new GroupLayout(panelMenu);
		gl_panelMenu.setHorizontalGroup(
			gl_panelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelMenu.createSequentialGroup()
							.addComponent(lblSum)
							.addPreferredGap(ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
							.addComponent(btnClose))
						.addComponent(lblResult))
					.addContainerGap())
		);
		gl_panelMenu.setVerticalGroup(
			gl_panelMenu.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addGap(7)
					.addComponent(lblResult)
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMenu.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
							.addComponent(btnClose)
							.addContainerGap())
						.addGroup(gl_panelMenu.createSequentialGroup()
							.addGap(4)
							.addComponent(lblSum)
							.addContainerGap())))
		);
		panelMenu.setLayout(gl_panelMenu);
		GroupLayout gl_panelText = new GroupLayout(panelText);
		gl_panelText.setHorizontalGroup(
			gl_panelText.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelText.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelText.createParallelGroup(Alignment.LEADING)
						.addComponent(panelQuestion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelAnswers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelText.setVerticalGroup(
			gl_panelText.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelText.createSequentialGroup()
					.addGap(1)
					.addComponent(panelQuestion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(panelAnswers, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelText.setLayout(gl_panelText);
		mainWindow.getContentPane().setLayout(groupLayout);
	}
}
