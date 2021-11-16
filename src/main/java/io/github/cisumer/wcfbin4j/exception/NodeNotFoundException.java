package io.github.cisumer.wcfbin4j.exception;

public class NodeNotFoundException extends RuntimeException{
	private int type;
	public NodeNotFoundException(int type){
		super(String.format("类型：0x%02x没有找到", type));
		this.type=type;
	}
	public NodeNotFoundException(int type,Throwable e){
		super(String.format("类型：0x%02x没有找到", type),e);
		this.type=type;
	}
	public NodeNotFoundException(Class<?> cls){
		super(String.format("节点[%s]没有找到！", cls.getName()));
	}
	public int getType(){
		return type;
	}
}
