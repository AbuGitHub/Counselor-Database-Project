import java.awt.EventQueue;
import java.sql.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Scrollbar;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JScrollBar;
import javax.swing.Box;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JInternalFrame;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

//MAIN CLASS
public class CounselorApp {
	
//CONNECTION>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	
	ResultSet rs = null;
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

//DECLARATIONS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private JFrame frmCounselingApp;
	private static JTable PatientTable;
	private JTextField CoupleName_textField;
	private JTextField PatientFirstName_textField;
	private JTextField PatientLastName_textField;
	private JTextField PatientGender_textField;
	private JTextField PatientDOB_textField;
	private JTextField PatientJob_textField;
	private JTextField Initiate_textField;
	private JTextField SpouseFirstName_textField;
	private JTextField SpouseLastName_textField;
	private JTextField SpouseGender_textField;
	private JTextField SpouseDOB_textField;
	private JTextField SpouseJob_textField;
	private JTextField PatientPastMeds_textField;
	private JTextField PatientCurrMeds_textField;
	private JTextField Contact_textField;
	private JTextField NumChild_textField;
	private JTextField SpousePastMeds_textField;
	private JTextField SpouseCurrMeds_textField;
	private JTextField Address_textField;
	private JTextField Reason_textField;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private final Action action = new SwingAction();
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
//GET CONNECTION FUNCTION >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
public static Connection getConnection() throws Exception{
	try{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/patients?autoReconnect=true&useSSL=false";
		String username = "root";
		String password = "1234";
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connected");
		return con;
	}catch (Exception e){
		System.out.println(e);
	}
return null;
}
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	


public static ResultSet givedata() throws Exception{
	try{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/patients?autoReconnect=true&useSSL=false";
		String username = "root";
		String password = "1234";
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connected");
		
		PreparedStatement statement = con.prepareStatement("Select * FROM patients WHERE id=5");
		ResultSet result = statement.executeQuery();
		result.next();
		System.out.println(result.getString("id"));
		System.out.println(result.getString("couple"));
		System.out.println(result.getString("firstname1"));
		System.out.println(result.getString("lastname1"));
		//EditPane.add(textField_20);
		JTextField textField_20 = new JTextField(result.getString("couple"));
		
	}catch (Exception e){
		System.out.println(e);
	}
	return null;
}
	
//MAIN >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getConnection();
					givedata();
					CounselorApp window = new CounselorApp();
					window.frmCounselingApp.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
//Initializer >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public CounselorApp() {
		initialize();
		
	}
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
//Initialize the contents of the frame. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private void initialize() {
		frmCounselingApp = new JFrame();
		frmCounselingApp.setResizable(false);
		frmCounselingApp.setTitle("Counseling App");
		frmCounselingApp.setBounds(100, 100, 655, 418);
		frmCounselingApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCounselingApp.getContentPane().setLayout(null);
		
		JTabbedPane MaintabbedPane = new JTabbedPane(JTabbedPane.TOP);
		MaintabbedPane.setBorder(null);
		MaintabbedPane.setBounds(0, 0, 639, 380);
		frmCounselingApp.getContentPane().add(MaintabbedPane);


// COUNSELOR TAB >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		JDesktopPane CounselorPane = new JDesktopPane();
		CounselorPane.setBackground(Color.WHITE);
		CounselorPane.setToolTipText("");
		MaintabbedPane.addTab("Counselor", null, CounselorPane, null);
		CounselorPane.setLayout(null);
		
		JList<String> list = new JList<String>();
		list.setBounds(10, 44, 165, 297);
		list.setBackground(Color.LIGHT_GRAY);
		CounselorPane.add(list);

// NOTES + ASSESSMENT + RECC  TABS  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		JTabbedPane CounselorInsideTabs = new JTabbedPane(JTabbedPane.TOP);
		CounselorInsideTabs.setBounds(185, 39, 443, 269);
		CounselorPane.add(CounselorInsideTabs);
		

		final JTextPane NotesTab = new JTextPane();
		NotesTab.setBackground(new Color(250, 250, 210));
		CounselorInsideTabs.addTab("Notes", null, NotesTab, null);
		
		
		final JTextPane AssessmentTab = new JTextPane();
		CounselorInsideTabs.addTab("Assessment", null, AssessmentTab, null);
		
		final JTextPane RecTab = new JTextPane();
		CounselorInsideTabs.addTab("Recommendations", null, RecTab, null);
		
		final JFormattedTextField VisitDateField = new JFormattedTextField();
		CounselorInsideTabs.addTab("Visit Date", null, VisitDateField, null);
		
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		JLabel PatientSelectorLabel = new JLabel("Patient Selector");
		PatientSelectorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PatientSelectorLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		PatientSelectorLabel.setBounds(10, 17, 165, 25);
		CounselorPane.add(PatientSelectorLabel);
		
		Button SaveButton = new Button("Save");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String sql = "INSERT INTO patients" + "(notes, assessment, recommend, dateofvisit)" + "VALUES (?,?,?,?)";
					Connection con = getConnection();
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,NotesTab.getText());
					pst.setString(2,AssessmentTab.getText());
					pst.setString(3,RecTab.getText());
					pst.setString(4,VisitDateField.getText());
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserted Successfully");
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		SaveButton.setBounds(181, 314, 145, 22);
		CounselorPane.add(SaveButton);
		
		Button CancelButton = new Button("Cancel");
		CancelButton.setBounds(333, 314, 144, 22);
		CounselorPane.add(CancelButton);
		
		Button ExitButton = new Button("Exit");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		ExitButton.setBounds(483, 314, 145, 22);
		CounselorPane.add(ExitButton);
		
		Label Viewinglabel = new Label("Viewing:");
		Viewinglabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		Viewinglabel.setBackground(Color.WHITE);
		Viewinglabel.setBounds(185, 10, 73, 22);
		CounselorPane.add(Viewinglabel);
		
		TextField textField = new TextField();
		textField.setBackground(new Color(224, 255, 255));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(264, 10, 360, 22);
		CounselorPane.add(textField);
// END OF 		COUNSELOR TAB >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		
// PATINET INFO TAB >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		JDesktopPane PatientsInfoPane = new JDesktopPane();
		PatientsInfoPane.setBackground(Color.WHITE);
		MaintabbedPane.addTab("Patients Info", null, PatientsInfoPane, null);
		
		
		
		PatientTable = new JTable();
		PatientTable.setColumnSelectionAllowed(true);
		PatientTable.setCellSelectionEnabled(true);
		PatientTable.setBackground(new Color(230, 230, 250));
		PatientTable.setBounds(10, 11, 614, 298);
		PatientsInfoPane.add(PatientTable);
		
		Button RefreshButton = new Button("Refresh");

		RefreshButton.setBounds(10, 315, 154, 22);
		PatientsInfoPane.add(RefreshButton);
// END OF PATIENTS INFO TAB >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
//CALENDAR TAB	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		JDesktopPane CalPane = new JDesktopPane();
		CalPane.setBackground(Color.WHITE);
		MaintabbedPane.addTab("Calendar", null, CalPane, null);
		
		JButton MSCalbtn = new JButton("Launch Microsoft Calendar");
		MSCalbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI("http://login.microsoftonline.com"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		MSCalbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		MSCalbtn.setBounds(188, 122, 271, 79);
		CalPane.add(MSCalbtn);
// END OF 		CALENDAR TAB>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
// EMAIL TAB	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		JDesktopPane EmailPane = new JDesktopPane();
		EmailPane.setBackground(Color.WHITE);
		MaintabbedPane.addTab("Email", null, EmailPane, null);
		
		JButton btnLaunchMicrosoftEmail = new JButton("Launch Microsoft Email ");
		btnLaunchMicrosoftEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI("https://outlook.office.com/owa"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			}
		});
		btnLaunchMicrosoftEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLaunchMicrosoftEmail.setBounds(148, 118, 348, 85);
		EmailPane.add(btnLaunchMicrosoftEmail);
// END OF 	EMAIL TAB	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>		

		
// LOGS TAB >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		JDesktopPane LogsPane = new JDesktopPane();
		LogsPane.setBackground(Color.WHITE);
		MaintabbedPane.addTab("Logs", null, LogsPane, null);
// END OF LOGS TAB >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

// ADD PATIENTS TAB >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		JDesktopPane AddPane = new JDesktopPane();
		AddPane.setBackground(Color.WHITE);
		MaintabbedPane.addTab("Add Patients", null, AddPane, null);
		
		
//ADD PATIENTS TEXT FIELDS  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		CoupleName_textField = new JTextField();
		CoupleName_textField.setBackground(new Color(224, 255, 255));
		CoupleName_textField.setBounds(114, 10, 176, 20);
		AddPane.add(CoupleName_textField);
		CoupleName_textField.setColumns(10);
		
		PatientFirstName_textField = new JTextField();
		PatientFirstName_textField.setBackground(new Color(224, 255, 255));
		PatientFirstName_textField.setColumns(10);
		PatientFirstName_textField.setBounds(114, 34, 176, 20);
		AddPane.add(PatientFirstName_textField);
		
		PatientLastName_textField = new JTextField();
		PatientLastName_textField.setBackground(new Color(224, 255, 255));
		PatientLastName_textField.setColumns(10);
		PatientLastName_textField.setBounds(114, 58, 176, 20);
		AddPane.add(PatientLastName_textField);
		
		PatientGender_textField = new JTextField();
		PatientGender_textField.setBackground(new Color(224, 255, 255));
		PatientGender_textField.setColumns(10);
		PatientGender_textField.setBounds(114, 83, 176, 20);
		AddPane.add(PatientGender_textField);
		
		PatientDOB_textField = new JTextField();
		PatientDOB_textField.setBackground(new Color(224, 255, 255));
		PatientDOB_textField.setColumns(10);
		PatientDOB_textField.setBounds(114, 108, 176, 20);
		AddPane.add(PatientDOB_textField);
		
		PatientJob_textField = new JTextField();
		PatientJob_textField.setBackground(new Color(224, 255, 255));
		PatientJob_textField.setColumns(10);
		PatientJob_textField.setBounds(114, 133, 176, 20);
		AddPane.add(PatientJob_textField);
		
		Initiate_textField = new JTextField();
		Initiate_textField.setColumns(10);
		Initiate_textField.setBackground(new Color(224, 255, 255));
		Initiate_textField.setBounds(448, 10, 176, 20);
		AddPane.add(Initiate_textField);
		
		SpouseFirstName_textField = new JTextField();
		SpouseFirstName_textField.setColumns(10);
		SpouseFirstName_textField.setBackground(new Color(224, 255, 255));
		SpouseFirstName_textField.setBounds(448, 34, 176, 20);
		AddPane.add(SpouseFirstName_textField);
		
		SpouseLastName_textField = new JTextField();
		SpouseLastName_textField.setColumns(10);
		SpouseLastName_textField.setBackground(new Color(224, 255, 255));
		SpouseLastName_textField.setBounds(448, 58, 176, 20);
		AddPane.add(SpouseLastName_textField);
		
		SpouseGender_textField = new JTextField();
		SpouseGender_textField.setColumns(10);
		SpouseGender_textField.setBackground(new Color(224, 255, 255));
		SpouseGender_textField.setBounds(448, 83, 176, 20);
		AddPane.add(SpouseGender_textField);
		
		SpouseDOB_textField = new JTextField();
		SpouseDOB_textField.setColumns(10);
		SpouseDOB_textField.setBackground(new Color(224, 255, 255));
		SpouseDOB_textField.setBounds(448, 108, 176, 20);
		AddPane.add(SpouseDOB_textField);
		
		SpouseJob_textField = new JTextField();
		SpouseJob_textField.setColumns(10);
		SpouseJob_textField.setBackground(new Color(224, 255, 255));
		SpouseJob_textField.setBounds(448, 133, 176, 20);
		AddPane.add(SpouseJob_textField);
// END OF 	ADD PATIENTS TEXT FIELDS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

// ADD PAETIENTS TAB LABELS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		JLabel PatientGender_label = new JLabel("Patient's Gender");
		PatientGender_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		PatientGender_label.setBounds(10, 83, 103, 19);
		AddPane.add(PatientGender_label);
		
		JLabel SpouseGender_label = new JLabel("Spouse's Gender");
		SpouseGender_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		SpouseGender_label.setBounds(310, 84, 103, 19);
		AddPane.add(SpouseGender_label);
		
		JLabel LastName_label = new JLabel("Patient's LastName");
		LastName_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		LastName_label.setBounds(10, 59, 103, 19);
		AddPane.add(LastName_label);
		
		JLabel CoupleName_label = new JLabel("Couple's Name");
		CoupleName_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CoupleName_label.setBounds(10, 11, 103, 19);
		AddPane.add(CoupleName_label);
		
		JLabel SpouseFirstName_label = new JLabel("Spouse First Name");
		SpouseFirstName_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		SpouseFirstName_label.setBounds(310, 35, 103, 19);
		AddPane.add(SpouseFirstName_label);
		
		JLabel InitiateDate_label = new JLabel("Initiation Date");
		InitiateDate_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		InitiateDate_label.setBounds(310, 11, 103, 19);
		AddPane.add(InitiateDate_label);
		
		JLabel SpouseLastName_label = new JLabel("Spouse Last Name");
		SpouseLastName_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		SpouseLastName_label.setBounds(310, 59, 103, 19);
		AddPane.add(SpouseLastName_label);
		
		JLabel label_5 = new JLabel("Patient's First Name");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(10, 35, 103, 19);
		AddPane.add(label_5);
		
		JLabel PatientDOB_label = new JLabel("Patient's DOB");
		PatientDOB_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		PatientDOB_label.setBounds(10, 109, 103, 19);
		AddPane.add(PatientDOB_label);
		
		JLabel SpouseDOB_label = new JLabel("Spouse's DOB");
		SpouseDOB_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		SpouseDOB_label.setBounds(310, 109, 103, 19);
		AddPane.add(SpouseDOB_label);
		
		JLabel PatientJob_label = new JLabel("Patient's Job");
		PatientJob_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		PatientJob_label.setBounds(10, 134, 103, 19);
		AddPane.add(PatientJob_label);
		
		JLabel SpouseJob_label = new JLabel("Spouse's Job");
		SpouseJob_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		SpouseJob_label.setBounds(310, 134, 103, 19);
		AddPane.add(SpouseJob_label);
		
		JLabel PatientPastMed_label = new JLabel("Patient's Past Meds");
		PatientPastMed_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		PatientPastMed_label.setBounds(10, 159, 103, 19);
		AddPane.add(PatientPastMed_label);
		
		JLabel PatientCurrentMed_label = new JLabel("Patient's Curr. Meds");
		PatientCurrentMed_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		PatientCurrentMed_label.setBounds(10, 188, 103, 19);
		AddPane.add(PatientCurrentMed_label);
		
		JLabel Contact_label = new JLabel("Contact Number");
		Contact_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Contact_label.setBounds(10, 214, 103, 19);
		AddPane.add(Contact_label);
		
		JLabel NumberChild_label = new JLabel("Number Of Children");
		NumberChild_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		NumberChild_label.setBounds(10, 241, 103, 19);
		AddPane.add(NumberChild_label);
		
		JLabel SpousePastMed_label = new JLabel("Spouse's Past Meds");
		SpousePastMed_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		SpousePastMed_label.setBounds(310, 159, 103, 19);
		AddPane.add(SpousePastMed_label);
		
		JLabel SpouseCurrentMeds_label = new JLabel("Spouse's Curr. Meds");
		SpouseCurrentMeds_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		SpouseCurrentMeds_label.setBounds(310, 185, 103, 19);
		AddPane.add(SpouseCurrentMeds_label);
		
		JLabel Address_label = new JLabel("Patient's Address");
		Address_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Address_label.setBounds(310, 211, 103, 19);
		AddPane.add(Address_label);
		
		JLabel VisitReason_label = new JLabel("Visit Reason");
		VisitReason_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		VisitReason_label.setBounds(310, 239, 103, 19);
		AddPane.add(VisitReason_label);

//END OF      ADD PATIENT TAB LABELS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		PatientPastMeds_textField = new JTextField();
		PatientPastMeds_textField.setColumns(10);
		PatientPastMeds_textField.setBackground(new Color(224, 255, 255));
		PatientPastMeds_textField.setBounds(114, 159, 176, 20);
		AddPane.add(PatientPastMeds_textField);
		
		PatientCurrMeds_textField = new JTextField();
		PatientCurrMeds_textField.setColumns(10);
		PatientCurrMeds_textField.setBackground(new Color(224, 255, 255));
		PatientCurrMeds_textField.setBounds(114, 185, 176, 20);
		AddPane.add(PatientCurrMeds_textField);
		
		Contact_textField = new JTextField();
		Contact_textField.setColumns(10);
		Contact_textField.setBackground(new Color(224, 255, 255));
		Contact_textField.setBounds(114, 211, 176, 20);
		AddPane.add(Contact_textField);
		
		NumChild_textField = new JTextField();
		NumChild_textField.setColumns(10);
		NumChild_textField.setBackground(new Color(224, 255, 255));
		NumChild_textField.setBounds(114, 238, 176, 20);
		AddPane.add(NumChild_textField);
		
		SpousePastMeds_textField = new JTextField();
		SpousePastMeds_textField.setColumns(10);
		SpousePastMeds_textField.setBackground(new Color(224, 255, 255));
		SpousePastMeds_textField.setBounds(448, 159, 176, 20);
		AddPane.add(SpousePastMeds_textField);
		
		SpouseCurrMeds_textField = new JTextField();
		SpouseCurrMeds_textField.setColumns(10);
		SpouseCurrMeds_textField.setBackground(new Color(224, 255, 255));
		SpouseCurrMeds_textField.setBounds(448, 185, 176, 20);
		AddPane.add(SpouseCurrMeds_textField);
		
		Address_textField = new JTextField();
		Address_textField.setColumns(10);
		Address_textField.setBackground(new Color(224, 255, 255));
		Address_textField.setBounds(448, 211, 176, 20);
		AddPane.add(Address_textField);
		
		Reason_textField = new JTextField();
		Reason_textField.setColumns(10);
		Reason_textField.setBackground(new Color(224, 255, 255));
		Reason_textField.setBounds(448, 238, 176, 20);
		AddPane.add(Reason_textField);
		
		
		
// ADD PATIENTS TAB BUTTONS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

//SAVE BUTTON >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					String sql = "INSERT INTO patients" + "(couple, firstname1, lastname1, firstname2, lastname2, gender1, gender2, initiatedate, dob1, dob2, job1, job2, numberchild, pastmedic1, pastmedic2, currentmedic1, currentmedic2, reason, address, contact)" 
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patients?autoReconnect=true&useSSL=false", "root", "1234");
					Connection con = getConnection();
					PreparedStatement pst = con.prepareStatement(sql);
					//pst = con.prepareStatement(sql);
					pst.setString(1,CoupleName_textField.getText());
					pst.setString(2,PatientFirstName_textField.getText());
					pst.setString(3,PatientLastName_textField.getText());
					
					pst.setString(4,SpouseFirstName_textField.getText());
					pst.setString(5,SpouseLastName_textField.getText());
					pst.setString(6,PatientGender_textField.getText());
					pst.setString(7,SpouseGender_textField.getText());
					pst.setString(8,Initiate_textField.getText());
					pst.setString(9,PatientDOB_textField.getText());
					pst.setString(10,SpouseDOB_textField.getText());
					pst.setString(11,PatientJob_textField.getText());
					pst.setString(12,SpouseJob_textField.getText());
					pst.setString(13,NumChild_textField.getText());
					pst.setString(14,PatientPastMeds_textField.getText());
					pst.setString(15,SpousePastMeds_textField.getText());
					pst.setString(16,PatientCurrMeds_textField.getText());
					pst.setString(17,SpouseCurrMeds_textField.getText());
					pst.setString(18,Reason_textField.getText());
					pst.setString(19,Address_textField.getText());
					pst.setString(20,Contact_textField.getText());
										
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Inserted Successfully");
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null,ex);
				}
			}
		});
		btnSave.setBounds(10, 279, 200, 50);
		AddPane.add(btnSave);
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(220, 279, 200, 50);
		AddPane.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(424, 279, 200, 50);
		AddPane.add(btnExit);
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
// END OF ADD PATIENT TAB>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		
		
		
		
		
		
//  EDIT PATIENTS TAB>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		JDesktopPane EditPane = new JDesktopPane();
		EditPane.setBackground(Color.WHITE);
		MaintabbedPane.addTab("Edit Patients", null, EditPane, null);

// EDIT PAGE TAB LABELS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		JLabel label = new JLabel("Spouse's Gender");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(310, 123, 103, 19);
		EditPane.add(label);
		
		JLabel label_1 = new JLabel("Patient's LastName");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(10, 98, 103, 19);
		EditPane.add(label_1);
		
		JLabel label_2 = new JLabel("Couple's Name");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(10, 50, 103, 19);
		EditPane.add(label_2);
		
		JLabel label_3 = new JLabel("Spouse First Name");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(310, 74, 103, 19);
		EditPane.add(label_3);
		
		JLabel label_4 = new JLabel("Initiation Date");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(310, 50, 103, 19);
		EditPane.add(label_4);
		
		JLabel label_6 = new JLabel("Spouse Last Name");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_6.setBounds(310, 98, 103, 19);
		EditPane.add(label_6);
		
		JLabel label_7 = new JLabel("Patient's First Name");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(10, 74, 103, 19);
		EditPane.add(label_7);
		
		JLabel label_8 = new JLabel("Patient's Gender");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_8.setBounds(10, 122, 103, 19);
		EditPane.add(label_8);
		
		JLabel label_9 = new JLabel("Patient's DOB");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setBounds(10, 148, 103, 19);
		EditPane.add(label_9);
		
		JLabel label_10 = new JLabel("Spouse's DOB");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_10.setBounds(310, 148, 103, 19);
		EditPane.add(label_10);
		
		JLabel label_11 = new JLabel("Patient's Job");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_11.setBounds(10, 173, 103, 19);
		EditPane.add(label_11);
		
		JLabel label_12 = new JLabel("Spouse's Job");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_12.setBounds(310, 173, 103, 19);
		EditPane.add(label_12);
		
		JLabel label_13 = new JLabel("Patient's Past Meds");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_13.setBounds(10, 198, 103, 19);
		EditPane.add(label_13);
		
		JLabel label_14 = new JLabel("Patient's Curr. Meds");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_14.setBounds(10, 227, 103, 19);
		EditPane.add(label_14);
		
		JLabel label_15 = new JLabel("Contact Number");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_15.setBounds(10, 253, 103, 19);
		EditPane.add(label_15);
		
		JLabel label_16 = new JLabel("Number Of Children");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_16.setBounds(10, 280, 103, 19);
		EditPane.add(label_16);
		
		JLabel label_17 = new JLabel("Spouse's Past Meds");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_17.setBounds(310, 198, 103, 19);
		EditPane.add(label_17);
		
		JLabel label_18 = new JLabel("Spouse's Curr. Meds");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_18.setBounds(310, 224, 103, 19);
		EditPane.add(label_18);
		
		JLabel label_19 = new JLabel("Patient's Address");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_19.setBounds(310, 250, 103, 19);
		EditPane.add(label_19);
		
		JLabel label_20 = new JLabel("Visit Reason");
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_20.setBounds(310, 278, 103, 19);
		EditPane.add(label_20);
		
		JLabel SelectPatientLabel = new JLabel("Select Patient");
		SelectPatientLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		SelectPatientLabel.setBounds(10, 11, 98, 28);
		EditPane.add(SelectPatientLabel);

// END OF EDIT TAB LABELS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
// EDIT TAB TEXT FIELDS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBackground(new Color(224, 255, 255));
		textField_20.setBounds(114, 49, 176, 20);
		EditPane.add(textField_20);
		textField_20.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String input = textField_20.getText();
				textField_21.setText("input");
			}
		});
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBackground(new Color(224, 255, 255));
		textField_21.setBounds(114, 73, 176, 20);
		EditPane.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBackground(new Color(224, 255, 255));
		textField_22.setBounds(114, 97, 176, 20);
		EditPane.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBackground(new Color(224, 255, 255));
		textField_23.setBounds(114, 122, 176, 20);
		EditPane.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBackground(new Color(224, 255, 255));
		textField_24.setBounds(114, 147, 176, 20);
		EditPane.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBackground(new Color(224, 255, 255));
		textField_25.setBounds(114, 172, 176, 20);
		EditPane.add(textField_25);		
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBackground(new Color(224, 255, 255));
		textField_26.setBounds(448, 49, 176, 20);
		EditPane.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBackground(new Color(224, 255, 255));
		textField_27.setBounds(448, 73, 176, 20);
		EditPane.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBackground(new Color(224, 255, 255));
		textField_28.setBounds(448, 97, 176, 20);
		EditPane.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBackground(new Color(224, 255, 255));
		textField_29.setBounds(448, 122, 176, 20);
		EditPane.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBackground(new Color(224, 255, 255));
		textField_30.setBounds(448, 147, 176, 20);
		EditPane.add(textField_30);
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBackground(new Color(224, 255, 255));
		textField_31.setBounds(448, 172, 176, 20);
		EditPane.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBackground(new Color(224, 255, 255));
		textField_32.setBounds(114, 198, 176, 20);
		EditPane.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBackground(new Color(224, 255, 255));
		textField_33.setBounds(114, 224, 176, 20);
		EditPane.add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBackground(new Color(224, 255, 255));
		textField_34.setBounds(114, 250, 176, 20);
		EditPane.add(textField_34);
		
		textField_35 = new JTextField();
		textField_35.setColumns(10);
		textField_35.setBackground(new Color(224, 255, 255));
		textField_35.setBounds(114, 277, 176, 20);
		EditPane.add(textField_35);
		
		textField_36 = new JTextField();
		textField_36.setColumns(10);
		textField_36.setBackground(new Color(224, 255, 255));
		textField_36.setBounds(448, 198, 176, 20);
		EditPane.add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setColumns(10);
		textField_37.setBackground(new Color(224, 255, 255));
		textField_37.setBounds(448, 224, 176, 20);
		EditPane.add(textField_37);
		
		textField_38 = new JTextField();
		textField_38.setColumns(10);
		textField_38.setBackground(new Color(224, 255, 255));
		textField_38.setBounds(448, 250, 176, 20);
		EditPane.add(textField_38);
		
		textField_39 = new JTextField();
		textField_39.setColumns(10);
		textField_39.setBackground(new Color(224, 255, 255));
		textField_39.setBounds(448, 277, 176, 20);
		EditPane.add(textField_39);
		
// END OF    EDIT TAB TEXT FIELDS ^>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		
// EDIT TAB BUTTONS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		JButton button = new JButton("Save");
		button.setBounds(10, 310, 200, 37);
		EditPane.add(button);
		
		JButton button_1 = new JButton("Clear");
		button_1.setBounds(214, 310, 200, 37);
		EditPane.add(button_1);
		
		JButton button_2 = new JButton("Exit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});	
// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		button_2.setBounds(424, 310, 200, 34);
		EditPane.add(button_2);
		
		JMenuBar listBar = new JMenuBar();
		JMenu lst = new JMenu("list");
		JMenuItem open = new JMenuItem("Open");
		list.add(open);
		listBar.add(list);
		listBar.setBounds(114, 11, 107, 22);
		EditPane.add(listBar);
		
		JButton display_btn = new JButton("Display");
		display_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						String input = textField_20.getText();
						textField_21.setText("input");
						//list_1.setText("input");
					}
				});
	
		display_btn.setBounds(410, 14, 89, 23);
		EditPane.add(display_btn);
		

		

		
		
		
		frmCounselingApp.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmCounselingApp.getContentPane(), MaintabbedPane, CounselorPane, list}));
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
	}

//  END OF  EDIT PATIENTS TAB    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
//END OF         Initialize the contents of the frame. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	
	
//SWING ACTION >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}


