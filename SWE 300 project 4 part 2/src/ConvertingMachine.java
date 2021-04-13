import java.util.ArrayList;
import java.util.List;

/**
 * A finite state machine that parses a string containing a real number. Will
 * throw NumberFormatExcaption if the string doesn't not contain a legal
 * representation of a real number. Note: we are not dealing with scientific
 * notation
 * 
 * @author Merlin
 *
 */
public class ConvertingMachine
{

	private final Edge[] machine =
	{
			new Edge(State.START, new DigitInputVerifier(),
					new ValueIsDigitAction(), State.INTEGER),
			
			new Edge(State.START, new MinusInputVerifier(), new NegateAction(),
					State.INTEGER),
			
			new Edge(State.START, new PlusInputVerifier(), new NoAction(),
					State.INTEGER),
			
			new Edge(State.START, new PeriodInputVerifier(),
					new StartFraction(), State.DECIMAL),
			
			new Edge(State.INTEGER, new DigitInputVerifier(),
					new ContinuingIntegerAction(), State.INTEGER),
			
			new Edge(State.INTEGER, new PeriodInputVerifier(),
					new StartFraction(), State.DECIMAL),
			
			new Edge(State.DECIMAL, new DigitInputVerifier(),
					new ContinuingFactionAction(), State.DECIMAL)

	};

	public double parse(String text)
	{
		char[] c = new char[text.getBytes().length];
		System.out.println("Get Bytes returns: " + text.getBytes().length);
		text.getChars(0, text.getBytes().length, c, 0);
		Edge current = searchForEdge(State.START, c[0]);
		InterimResult x = new InterimResult(.1, 1, 0); 

		if(current == null) {
			throw new NumberFormatException();
		}
		
		x = current.action.execute(x, c[0]);
		
		
		for(int i = 1; i < text.getBytes().length; i++) {
			
			current = searchForEdge(current.nextState, c[i]);
			
			if(current == null) {
				throw new NumberFormatException();
			}
			
			x = current.action.execute(x, c[i]);
			
			
		}
		
		
		return x.getS() * x.getV();
		
	}

	private Edge searchForEdge(State currentState, char ch)
	{
		Edge edge = null;
		for(int i = 0; i < machine.length; i++) {
			
			if(currentState == machine[i].currentState) {
				if(machine[i].inputVerifier.meetsCriteria(ch) == true) {
					edge = machine[i];
					currentState = machine[i].nextState;
					System.out.println("current " + edge.currentState + " next: " + machine[i].nextState.toString());
					
				}
			}
			
		}
		
		return edge;
		
	}

	private class Edge
	{
		State currentState;
		InputVerifier inputVerifier;
		Action action;
		State nextState;

		public Edge(State currentState, InputVerifier inputVerifier,
				Action action, State nextState)
		{
			this.currentState = currentState;
			this.inputVerifier = inputVerifier;
			this.action = action;
			this.nextState = nextState;
		}
	}

	private enum State
	{
		START, INTEGER, DECIMAL, END
	}
}
