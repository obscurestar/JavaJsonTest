package obscurestar.jsontest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Primitive {
	private String mName;	//Private data with get/set
	@JsonProperty("value")
	public int mValue;		//Public data with no get/set
	
	Primitive()
	{
		mName="Default";
		mValue = -1;
	}
	
	@JsonProperty("name")
	public void setName(String name)
	{
		mName = name;
	}
	
	@JsonProperty("name")
	public String getName()
	{
		return mName;
	}
}
