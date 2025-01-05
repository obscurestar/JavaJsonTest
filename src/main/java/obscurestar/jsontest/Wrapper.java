package obscurestar.jsontest;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Wrapper {
	@JsonProperty("primitives")
	public ArrayList<Primitive> mPrims = new ArrayList<Primitive>();
	@JsonProperty("wrapper_name")
	private String mWrapperName;
	//public String mPublicString; //Gets serialized because public.
	
	public Wrapper()
	{
		mWrapperName = "Wrapped";
		//mPublicString ="I get saved";
		
		//Add the default constructed primitive
		mPrims.add( new Primitive() );
		
		//Add a second primitive.
		Primitive prim = new Primitive();
		prim.setName("Second");
		prim.mValue = 5;
		mPrims.add( prim );
	}
	
	@JsonProperty("wrapper_name")
	public void setName(String name)
	{
		mWrapperName=name;
	}
}
