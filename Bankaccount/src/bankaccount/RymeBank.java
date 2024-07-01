package bankaccount;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;

public class RymeBank implements ActionListener {
	private Vector<Integer> Transactions;

	private JFrame Frame;
	private JLabel balanceLabel;
	private JTextField inputField;
	private JPanel Panel;
	private int balance = 0;
	private double value;
	private JList transactionsLabel;

	public static void main(String[] args) {
		new RymeBank();

	}

	public RymeBank() {
		Frame = new JFrame("Bank Application");
		Transactions = new Vector<Integer>();
		inputField = new JTextField(30);
		balanceLabel = new JLabel();
		transactionsLabel = new JList();
		transactionsLabel.setListData(Transactions);
		JButton depositButton = new JButton("Deposit");
		JButton withdrawButton = new JButton("Withdraw");

		Panel = new JPanel();
		Panel.add(inputField);
		Panel.add(depositButton);
		Panel.add(withdrawButton);
		Panel.add(balanceLabel);
		Panel.add(transactionsLabel);

		depositButton.addActionListener(this);
		withdrawButton.addActionListener(this);

		Frame.setVisible(true);
		Frame.setSize(600, 300);
		Frame.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Frame.setLayout(new FlowLayout());
		Frame.setContentPane(Panel);

		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int amount = Integer.parseInt(inputField.getText());
		if (e.getActionCommand().equals("Deposit")) {
			// balance += amount;
		} else {
		 amount = amount * -1;

		}
		updateBalance(amount);
		// TODO Auto-generated method stub

	}

	void updateBalance(int amount) {
		balance += amount;
		balanceLabel.setText("Remaining balance: " + balance);
		Transactions.insertElementAt(amount,0);
		if (Transactions.size() > 5) {
			Transactions.remove(Transactions.size() -1);
		}
		
		
		transactionsLabel.setListData(Transactions);

	}
}
