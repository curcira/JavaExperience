
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This is an assignment to review and use the concepts of GUI and Java Swing.
 * 
 * @author rachelcurci
 */

public class HW4 extends JFrame {

    private static final long serialVersionUID = 1L;
    private static JLabel label1 = new JLabel();
    private static JLabel label2 = new JLabel();
    private static JLabel output = new JLabel();
    private static JTextField textField1 = new JTextField();
    private static JTextField textField2 = new JTextField();
    private static JButton button1 = new JButton();
    private static JButton button2 = new JButton();

    /**
     * Method to set up the Frame.
     */
    private void setupFrame() {
        this.setPreferredSize(new Dimension(420, 420));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

        this.setLayout(null);

        Color color = new Color(125, 50, 250);
        this.getContentPane().setBackground(color);
    }

    /**
     * Method to set up the Labels.
     */
    private void setupLabels() {
        label1.setBounds(10, 20, 100, 20);
        label1.setText("Loan Amount");

        label2.setBounds(10, 70, 100, 20);
        label2.setText("Interest Rate");

        output.setBounds(125, 220, 300, 50);
        output.setForeground(Color.WHITE);
        output.setText("");

        this.add(label1);
        this.add(label2);
        this.add(output);
    }

    /**
     * Method to set up the Text Boxes for user input.
     */
    private void setupTextFields() {
        textField1.setBounds(150, 10, 150, 40);
        textField1.setText("");

        textField2.setBounds(150, 60, 150, 40);
        textField2.setText("");

        this.add(textField2);
        this.add(textField1);
    }

    /**
     * Method to set up buttons.
     */
    private void setupButtons() {
        button1.setBounds(140, 150, 80, 50);
        button1.setText("print");

        button2.setBounds(220, 150, 80, 50);
        button2.setText("clear");
        button2.setEnabled(false);

        button1.addActionListener(e -> action1());

        button2.addActionListener(e -> action2());

        this.add(button1);
        this.add(button2);
    }

    /**
     * Method for the action if user chooses the "clear" button.
     */
    private void action2() {
        output.setText("");
        textField1.setText("");
        textField2.setText("");
        button2.setEnabled(false);
        button1.setEnabled(true);
    }

    /**
     * Method for the action if user chooses the "print" button.
     */
    private void action1() {
        long loanAmt = Long.parseLong(textField1.getText());
        int interest = Integer.parseInt(textField2.getText());
        double monthly = (loanAmt + (loanAmt * interest / 100.0)) / 12.0;
        String formattedMonthly = String.format("%.2f", monthly);

        output.setText("Your monthly payment is: " + formattedMonthly);
        button1.setEnabled(false);
        button2.setEnabled(true);

    }

    /**
     * Constructor Method.
     */
    public HW4() {
        super("My Payments Calculator");

        setupFrame();

        setupLabels();

        setupTextFields();

        setupButtons();
    }

    public static void main(String[] args) {
        // creating object to run the visual.
        HW4 myGui = new HW4();

        myGui.pack();
        myGui.setVisible(true);

    }

}
