/**
* <h1>GUIConfirmScreen</h1>
* <p>GUIConfirmScreen handles the confirmation aspect of the flight project</p>
*
* @author  Philip Woulfe
* @version 1.0
* @since   2016-03-21 
*/

package projFlight.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import projFlight.Event.GUIMainEvent;
import projFlight.IO.ReadWriteDB;
import projFlight.models.Flight;
import projFlight.models.User;

public class GUIConfirmScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtName;
	private JTextField txtSeat;
	private JTextField txtLeg1;
	private JTextField txtLeg2;
	private JTextField txtInsurance;
	private JTextField txtBookRef;

	private JButton btnConfirm;
	private JButton btnPrint;
	private JButton btnExit;
	private JButton btnHelp;
	
	private JLabel lblName;
	private JLabel lblSeatType;
	private JLabel lblLeg1;
	private JLabel lblLeg2;
	private JLabel lblInsurance;
	private JLabel lblBookingReference;
	
	/**
	 * Create the panel
	 * @param event For action Listeners
	 * @param u For populating user
	 * @param flight For storing flight details
	 */
	public GUIConfirmScreen(GUIMainEvent event, User u, Flight flight) {
		
		setLayout(null);

		btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 11));
		btnConfirm.setBounds(66, 360, 104, 23);
		btnConfirm.addActionListener(event);;
		add(btnConfirm);

		btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 11));
		btnPrint.setEnabled(false);
		btnPrint.setBounds(194, 360, 104, 23);
		btnPrint.addActionListener(event);
		add(btnPrint);

		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 11));
		btnExit.setBounds(321, 360, 104, 23);
		btnExit.addActionListener(event);
		add(btnExit);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 17));
		lblName.setBounds(66, 135, 113, 23);
		add(lblName);

		lblSeatType = new JLabel("Seat Type");
		lblSeatType.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 17));
		lblSeatType.setBounds(66, 171, 113, 23);
		add(lblSeatType);

		lblLeg1 = new JLabel("Leg 1");
		lblLeg1.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 17));
		lblLeg1.setBounds(66, 207, 113, 23);
		add(lblLeg1);

		lblLeg2 = new JLabel("Leg 2");
		lblLeg2.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 17));
		lblLeg2.setBounds(66, 241, 113, 23);
		add(lblLeg2);

		lblInsurance = new JLabel("Insurance");
		lblInsurance.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 17));
		lblInsurance.setBounds(66, 277, 113, 23);
		add(lblInsurance);

		lblBookingReference = new JLabel("Booking Ref");
		lblBookingReference.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 17));
		lblBookingReference.setBounds(66, 313, 113, 23);
		add(lblBookingReference);

		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.TRAILING);
		txtName.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 14));
		txtName.setEditable(false);
		txtName.setBounds(312, 135, 113, 25);
		add(txtName);
		txtName.setColumns(10);

		txtSeat = new JTextField();
		txtSeat.setHorizontalAlignment(SwingConstants.TRAILING);
		txtSeat.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 14));
		txtSeat.setEditable(false);
		txtSeat.setColumns(10);
		txtSeat.setBounds(312, 171, 113, 25);
		add(txtSeat);

		txtLeg1 = new JTextField();
		txtLeg1.setHorizontalAlignment(SwingConstants.TRAILING);
		txtLeg1.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 14));
		txtLeg1.setEditable(false);
		txtLeg1.setColumns(10);
		txtLeg1.setBounds(312, 205, 113, 25);
		add(txtLeg1);

		txtLeg2 = new JTextField();
		txtLeg2.setHorizontalAlignment(SwingConstants.TRAILING);
		txtLeg2.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 14));
		txtLeg2.setEditable(false);
		txtLeg2.setColumns(10);
		txtLeg2.setBounds(312, 241, 113, 25);
		add(txtLeg2);

		txtInsurance = new JTextField();
		txtInsurance.setHorizontalAlignment(SwingConstants.TRAILING);
		txtInsurance.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 14));
		txtInsurance.setEditable(false);
		txtInsurance.setColumns(10);
		txtInsurance.setBounds(312, 277, 113, 25);
		add(txtInsurance);

		txtBookRef = new JTextField();
		txtBookRef.setHorizontalAlignment(SwingConstants.TRAILING);
		txtBookRef.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 14));
		txtBookRef.setEditable(false);
		txtBookRef.setColumns(10);
		txtBookRef.setBounds(312, 313, 113, 23);
		add(txtBookRef);
		
		btnHelp = new JButton("Help");
		btnHelp.setBounds(365, 101, 60, 23);
		btnHelp.addActionListener(event);
		add(btnHelp);
		
		setTxtName(u.getFirstName() + " " + u.getLastName());

		setTxtLeg1(ReadWriteDB.getCodeForAirport(flight.getDeptLeg1Airport()) + " To " + ReadWriteDB.getCodeForAirport(flight.getDestLeg1Airport()));
		
		// if there is a second eg in the flight
		if (!flight.getDeptLeg2Airport().equals("")) {
			
			// set from and to airport codes
			setTxtLeg2(ReadWriteDB.getCodeForAirport(flight.getDeptLeg2Airport()) + " To " + ReadWriteDB.getCodeForAirport(flight.getDestLeg2Airport()));
		}
		
		setTxtSeat(flight.getLeg1SeatType());
		setTxtBookRef(flight.getBookingRef() + "");
		
		
		if (flight.isHasInsurance()) {
			setTxtInsurance("Yes");
		} else {
			setTxtInsurance("No");
		}
	}
	
	/**
	 * get name
	 * @return returns string name
	 */
	public JTextField getTxtName() {
		return txtName;
	}

	/** 
	 * set name
	 * @param name For setting name
	 */
	public void setTxtName(String name) {
		txtName.setText(name);
	}

	/**
	 * set seat
	 * @param seatType Sets Seat type 
	 */
	public void setTxtSeat(String seatType) {
		this.txtSeat.setText(seatType);;
	}

	
	/**
	 * set leg 1
	 * @param leg1 Sets leg 1 details
	 */
	public void setTxtLeg1(String leg1) {
		this.txtLeg1.setText(leg1);
	}


	/** 
	 * set leg 2
	 * @param leg2 Sets leg 2 details
	 */
	public void setTxtLeg2(String leg2) {
		this.txtLeg2.setText(leg2);;
	}

	/**
	 * set insurance
	 * @param insurance  set values for insurance
	 */
	public void setTxtInsurance(String insurance) {
		this.txtInsurance.setText(insurance);
	}

	/**
	 * get booking ref
	 * @return returns booking ref
	 */
	public String getTxtBookRef() {
		return txtBookRef.getText();
	}

	/**
	 * set booking ref
	 * @param bookRef sets booking reference
	 */
	public void setTxtBookRef(String bookRef) {
		this.txtBookRef.setText(bookRef);
	}

	/**
	 * confirm clicked
	 * @param source for action listeners
	 * @return if this button is the source
	 */
	public boolean isSourceBtnConfirm(Object source) {
		return source == btnConfirm;
	}
	
	/**
	 * enable/disable confirm button
	 * @param enabled enable or disable confirm button
	 */
	public void enableBtnConfirm(boolean enabled) {
		btnConfirm.setEnabled(enabled);
	}
	
	/**
	 * print clicked
	 * @param source for action listeners
	 * @return if this button is the source
	 */
	public boolean isSourceBtnPrint(Object source) {
		return source == btnPrint;
	}
	
	/**
	 * exit clicked
	 * @param source for action listeners
	 * @return if this button is the source
	 */
	public boolean isSourceBtnExit(Object source) {
		return source == btnExit;
	}
	
	/**
	 * help clicked
	 * @param source for action listeners
	 * @return if this button is the source
	 */
	public boolean isSourceBtnHelp(Object source) {
		return source == btnHelp;
	}
	
	/**
	 * enable/disable leg 2
	 * @param enabled set leg 2 enabled/disabled
	 */
	public void enableLeg2(boolean enabled) {
		txtLeg2.setEnabled(enabled);
		lblLeg2.setEnabled(enabled);
	}
	
	/**
	 * enable disable print button
	 * @param enabled sets print button enabled or disabled
	 */
	public void enableBtnPrint(boolean enabled) {
		btnPrint.setEnabled(enabled);
	}
}
