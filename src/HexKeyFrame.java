import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiDevice.Info;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class HexKeyFrame extends JFrame implements KeyListener {
	private NotePlayer player;
	
	private int baseNote = 60;
	
	private String[] keyList = {
		"`1234567890-=\b ",
		" qwertyuiop[]\\ ",
		"  asdfghjkl;'\n ",
		"  zxcvbnm,./   "
	};

	private int offsetX = 0;
	private int offsetY = 0;
	
	private List<Integer> keysPressed = new ArrayList<>();

	private class KeyPosition {
		int x;
		int y;

		KeyPosition(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "" + x + ", " + y;
		}

		public KeyPosition shift(int x, int y) {
			return new KeyPosition(this.x + x, this.y + y);
		}
	}
	
	private KeyPosition[] keyPositions;

	private void setupKeyPositions() {
		keyPositions = new KeyPosition[255];

		int y = 0;
		for (String s : keyList) {
			int x = 0;
			for (char c : s.toCharArray()) {
				if(c != ' ') {
					KeyPosition pos = new KeyPosition(x, y);
					keyPositions[c] = pos;
				}

				x++;
			}

			y++;
		}
	}

	private KeyPosition getKeyPosition(KeyEvent k) {
		KeyPosition pos = null;
		try {
			pos = keyPositions[Character.toLowerCase(k.getKeyChar())];
			if(pos != null)
				return pos;
		} catch (ArrayIndexOutOfBoundsException e) { }
		
		int code = k.getKeyCode();
		int location = k.getKeyLocation();
		
		if(code == KeyEvent.VK_SHIFT) {
			if(location == KeyEvent.KEY_LOCATION_LEFT)
				return new KeyPosition(1,3);
			if(location == KeyEvent.KEY_LOCATION_RIGHT)
				return new KeyPosition(12,3);
		}
		if(code == KeyEvent.VK_CONTROL) {
			if(location == KeyEvent.KEY_LOCATION_LEFT)
				return new KeyPosition(1,4);
			if(location == KeyEvent.KEY_LOCATION_RIGHT)
				return new KeyPosition(13,4);
		}
		if(code == KeyEvent.VK_ALT) {
			if(location == KeyEvent.KEY_LOCATION_LEFT)
				return new KeyPosition(3,4);
			if(location == KeyEvent.KEY_LOCATION_RIGHT)
				return new KeyPosition(10,4);
		}
		if(code == KeyEvent.VK_WINDOWS) {
			if(location == KeyEvent.KEY_LOCATION_LEFT)
				return new KeyPosition(2,4);
			if(location == KeyEvent.KEY_LOCATION_RIGHT)
				return new KeyPosition(11,4);
		}
		if(code == KeyEvent.VK_CONTEXT_MENU) {
			return new KeyPosition(12,4);
		}
		if(code == KeyEvent.VK_CAPS_LOCK) {
			return new KeyPosition(1,2);
		}
		
		return null;
	}
	
	private int getNoteAtPosition(KeyPosition position) {
		if (position == null)
			return -1;
		position = position.shift(offsetX, offsetY);

		int note = baseNote;
		
		note += position.x * 2;
		
		int y = position.y;
		note += -y * 2 + (y % 2);
		
		return note;
	}
	
	//Listeners
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyPressed(KeyEvent e) {
		if(keysPressed.contains(e.getKeyCode()))
			return;
		int note = getNoteAtPosition(getKeyPosition(e));
		player.playNote(note);
		keysPressed.add(e.getKeyCode());
	}
	
	public void keyReleased(KeyEvent e) {
		int note = getNoteAtPosition(getKeyPosition(e));
		player.stopNote(note);
		keysPressed.remove((Integer)e.getKeyCode());
	}
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		int count = 0;
		for(Info i : MidiSystem.getMidiDeviceInfo()) {
			System.out.println(++count + ": " + i.toString());
		}
		
		System.out.println("Enter a device number from the list above...");
		Scanner scanner = new Scanner(System.in);
		int input;
		while(true) {
			try {
				input = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number");
			}
		}
		
		scanner.close();
		
		final MidiDevice device;
		try {
			device = MidiSystem.getMidiDevice(
					MidiSystem.getMidiDeviceInfo()[input-1]
			);
		} catch (MidiUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HexKeyFrame frame = new HexKeyFrame(device);
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
	public HexKeyFrame(MidiDevice device) {
		setupKeyPositions();
		addKeyListener(this);
		player = new MidiNotePlayer(device, 1);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 100, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
