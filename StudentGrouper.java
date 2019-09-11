import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class StudentGrouper extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private static List<String> students = new ArrayList<>();
	
	private static List<JCheckBox> ticks = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentGrouper frame = new StudentGrouper();
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
	public StudentGrouper() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Enter Students", null, scrollPane, null);
		
		JTextPane txtpnOneStudentPer = new JTextPane();
		txtpnOneStudentPer.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		txtpnOneStudentPer.setText("One student per line...");
		scrollPane.setViewportView(txtpnOneStudentPer);
		
		JButton btnSetStudentList = new JButton("Set Student List");
		
		JPanel selStu = new JPanel();
		JScrollPane scroll = new JScrollPane(selStu);
		
		Box verticalBox = Box.createVerticalBox();
		selStu.add(verticalBox);
		tabbedPane.addTab("Select Students", null, scroll, null);
		
		btnSetStudentList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				students = Arrays.asList(txtpnOneStudentPer.getText().split("\n"));
				ticks.clear();
				verticalBox.removeAll();
				for(String student : students)
				{
					JCheckBox newCheck = new JCheckBox(student);
					verticalBox.add(newCheck);
					newCheck.setSelected(true);
					ticks.add(newCheck);
				}
			}
		});
		btnSetStudentList.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		scrollPane.setColumnHeaderView(btnSetStudentList);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Pick Random", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnSelectRandomStudents = new JButton("Select Random Student");
		GridBagConstraints gbc_btnSelectRandomStudents = new GridBagConstraints();
		gbc_btnSelectRandomStudents.insets = new Insets(0, 0, 5, 5);
		gbc_btnSelectRandomStudents.gridx = 0;
		gbc_btnSelectRandomStudents.gridy = 0;
		panel.add(btnSelectRandomStudents, gbc_btnSelectRandomStudents);
		
		JLabel randStudent = new JLabel("STUDENT");
		GridBagConstraints gbc_randStudent = new GridBagConstraints();
		gbc_randStudent.insets = new Insets(0, 0, 5, 5);
		gbc_randStudent.gridx = 1;
		gbc_randStudent.gridy = 0;
		panel.add(randStudent, gbc_randStudent);
		
		JButton btnMakeGroupsOf = new JButton("Make Groups");

		GridBagConstraints gbc_btnMakeGroupsOf = new GridBagConstraints();
		gbc_btnMakeGroupsOf.insets = new Insets(0, 0, 5, 5);
		gbc_btnMakeGroupsOf.gridx = 0;
		gbc_btnMakeGroupsOf.gridy = 1;
		panel.add(btnMakeGroupsOf, gbc_btnMakeGroupsOf);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.anchor = GridBagConstraints.EAST;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 1;
		panel.add(spinner, gbc_spinner);
		
		JLabel lblStudentsPerGroup = new JLabel("students per group");
		GridBagConstraints gbc_lblStudentsPerGroup = new GridBagConstraints();
		gbc_lblStudentsPerGroup.insets = new Insets(0, 0, 5, 0);
		gbc_lblStudentsPerGroup.anchor = GridBagConstraints.WEST;
		gbc_lblStudentsPerGroup.gridx = 2;
		gbc_lblStudentsPerGroup.gridy = 1;
		panel.add(lblStudentsPerGroup, gbc_lblStudentsPerGroup);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		DefaultListModel<String> groups = new DefaultListModel<String>();
		JList<String> list = new JList<String>(groups);
		scrollPane_1.setViewportView(list);
		
		btnMakeGroupsOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if((Integer)spinner.getValue() > 1 && (Integer)spinner.getValue() < 10)
				{
					List<JCheckBox> tickedTicks = new ArrayList<>();
					for(int j = 0; j < ticks.size(); j++)
					{
						if(ticks.get(j).isSelected())
						{
							tickedTicks.add(ticks.get(j));
						}
					}
					for(int k = 0; k < Math.floor(tickedTicks.size()/(Integer)spinner.getValue()); k++)
					{
						String groupStr = "";
						for(int i = 0; i < (Integer)spinner.getValue(); i++)
						{
							JCheckBox studentGroup = tickedTicks.get((int)(Math.random()*tickedTicks.size()));
							groupStr += studentGroup.getText();
							tickedTicks.remove(studentGroup);
						}
						groups.add(0, groupStr);
					}
				}
			}
		});
		
		btnSelectRandomStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				boolean ticked = false;
				while(!ticked)
				{
					JCheckBox randtick = ticks.get((int)(Math.random()*ticks.size()));
					ticked = randtick.isSelected();
					randStudent.setText(randtick.getText());
				}
			}
		});
	}

}
