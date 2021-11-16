package io.github.cisumer.wcfbin4j.exception;

public class NodeParseException extends RuntimeException{
	private int type;
	public NodeParseException(int type){
		super(String.format("类型：0x%02x解析错误！", type));
		this.type=type;
	}
	public NodeParseException(int type,Throwable e){
		super(String.format("类型：0x%02x解析错误！", type),e);
		this.type=type;
	}
	public int getType(){
		return type;
	}
}
