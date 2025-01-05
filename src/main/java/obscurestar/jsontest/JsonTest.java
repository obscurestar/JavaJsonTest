package obscurestar.jsontest;

/**
 * Hello world!
 *
 */
public class JsonTest 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        DataManager data = new DataManager();
        
        data.write();
        DataManager result = DataManager.read();
        System.out.println("Got: " + result.getLocalPrimitive().getName());
    }
}
