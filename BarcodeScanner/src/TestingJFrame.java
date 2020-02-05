import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TestingJFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private TestingJFrame() {
		super("Barcode Reader");
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		JButton button = new JButton("Click me");
		button.addActionListener(this);
		button.setActionCommand("button");
		
		JButton button1 = new JButton("button 2");
		button1.addActionListener(this);
		button1.setActionCommand("Click");
		
		JButton button3 = new JButton("Sound");
		button3.addActionListener(this);
		button3.setActionCommand("button3");
		
		add(button, BorderLayout.WEST);
		add(button1, BorderLayout.EAST);
		add(button3, BorderLayout.CENTER);
		
		
	}

	public static void main(String[] args) {
		new TestingJFrame().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name=e.getActionCommand();
		
		if (name.equals("button")) {
			System.out.println("Hello!");
		}else if (name.equals("Click")) {
			System.out.println("Hello!!!!");
		}
		
	}

}
