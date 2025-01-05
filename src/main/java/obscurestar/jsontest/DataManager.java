package obscurestar.jsontest;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DataManager {
	@JsonIgnore
    private static final String filename = "test.json";
   // private ArrayList<ToneChord> mTunings 
	
	
	@JsonProperty("primitive")
	private Primitive mPrimitive;
	
	@JsonProperty("wrapper")
	private Wrapper mWrapper;
	
	@JsonProperty("wrapper_list")
	private ArrayList<Wrapper> mWrapperList;
	
	//@JsonProperty("primitive_list")
	//private ArrayList<Primitive> m

    public DataManager()
    {
		mPrimitive= new Primitive();
		mPrimitive.setName("DefaultPrimitive");
		mWrapper = new Wrapper();
		mWrapperList = new ArrayList<Wrapper>();
		
		Wrapper wrapper = new Wrapper();
		wrapper.setName("Bob");
		mWrapperList.add( wrapper );
		wrapper = new Wrapper();
		wrapper.setName("Smith");
		mWrapperList.add(wrapper);
		
    }
    
    
    /*Here we must either use JsonIgnore to 
     *populate the value from the class member 
     *definition OR use JsonProperty to override
     *the default get.
     */
    //@JsonProperty("primitive")
    @JsonIgnore
    public Primitive getLocalPrimitive()
    {
    	return mPrimitive;
    }
    
    /*This is overriding the default behavior 
     * of simply setting the member variable's data.
     * Use @JsonIgnore to disable.
     */
    @JsonProperty("primitive")
    public void setLocalPrimitive(Primitive primitive)
    {
    	mPrimitive = primitive;
    	mPrimitive.setName("SetterPrimitive");
    }
    
    
    public void write()
    {
    	mPrimitive.setName("SavedPrimitive");
        try
        {
            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert the object to JSON string
            String jsonString = objectMapper.writeValueAsString(this);

            // Specify the path to your JSON file
            File jsonFile = new File(filename);

            objectMapper.writeValue(new File(filename), this);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static DataManager read()
    {
        DataManager result = new DataManager();
        
        System.out.println("Before read: " + result.mPrimitive.getName());
        try
        {
            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Specify the path to your JSON file
            File jsonFile = new File(filename);

            // Read the JSON file and map it to a Java object
            result = objectMapper.readValue(jsonFile, DataManager.class);
            
            System.out.println("After read: " + result.mPrimitive.getName());

        }
        catch (IOException e)
        {
        	System.out.println("Exceptional!");
            e.printStackTrace();
        }
        return result;
    }
}
