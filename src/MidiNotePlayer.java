import javax.sound.midi.*;
import javax.sound.midi.MidiDevice.Info;

public class MidiNotePlayer implements NotePlayer {

	private MidiDevice device;
	private Receiver receiver;

	private ShortMessage instrumentMessage;

	public MidiNotePlayer(MidiDevice d, int instrument) {
		try {
			device = d;
			
			device.open();
			receiver = device.getReceiver();
		} catch (MidiUnavailableException e) {
			System.err.println(e);
			return;
		}

		try {
			instrumentMessage = new ShortMessage();
			instrumentMessage.setMessage(ShortMessage.PROGRAM_CHANGE, 0,
					instrument, 0);
		} catch (InvalidMidiDataException e) {
			System.err.println(e);
			return;
		}

		receiver.send(instrumentMessage, -1);
		
		try {
			System.out.println("Latency: " + MidiSystem.getSynthesizer().getLatency());
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() {
		device.close();
	}

	public void playNote(int note) {
		if (note < 0)
			return;

		try {
			ShortMessage playMessage = new ShortMessage();
			playMessage.setMessage(ShortMessage.NOTE_ON, 0, note, 93);
			receiver.send(playMessage, -1);
		} catch (InvalidMidiDataException e) {
			System.err.println(e);
			return;
		}
		
		switch(note % 12) {
		case 0:
			System.out.print("C");
			break;
		case 1:
			System.out.print("C#");
			break;
		case 2:
			System.out.print("D");
			break;
		case 3:
			System.out.print("D#");
			break;
		case 4:
			System.out.print("E");
			break;
		case 5:
			System.out.print("F");
			break;
		case 6:
			System.out.print("F#");
			break;
		case 7:
			System.out.print("G");
			break;
		case 8:
			System.out.print("G#");
			break;
		case 9:
			System.out.print("A");
			break;
		case 10:
			System.out.print("A#");
			break;
		case 11:
			System.out.print("B");
			break;
		}
		
		System.out.print(" ");
		System.out.println(note/12 - 1);
	}

	public void stopNote(int note) {
		if (note < 0)
			return;

		try {
			ShortMessage stopMessage = new ShortMessage();
			stopMessage.setMessage(ShortMessage.NOTE_OFF, 0, note, 93);
			receiver.send(stopMessage, -1);
		} catch (InvalidMidiDataException e) {
			System.err.println(e);
			return;
		}
	}
}
