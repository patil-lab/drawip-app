package exception;

public class InvalidParamsException	extends RuntimeException {

	private final String	instruction;

	public InvalidParamsException(String	msg,String	ins){
		super(msg);
		instruction=ins;
	}

	public String	getInstruction(){
		return instruction;
	}
}
