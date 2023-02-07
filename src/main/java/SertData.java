import org.testng.annotations.DataProvider;

public class SertData {
    @DataProvider
    public Object [][] gerSert(){
        return new Object[][]{
                {"valid"},
                {"notvalid"},
                {"notvalid1"},
                {"allnulls"},
                {"allletters"}
        };
    }
}
