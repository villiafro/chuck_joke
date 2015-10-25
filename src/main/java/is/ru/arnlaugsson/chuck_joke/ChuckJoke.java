package is.arnlaugsson.chuck_joke;

import static spark.Spark.*;


public class ChuckJoke {

    public static void main(String[] args) {
        String port = System.getenv("PORT");
        if (port != null) {
            setPort(Integer.valueOf(port));
        }

        Chuck chuck = new Chuck();    
        get("/random", (req, res) -> chuck.random());
    }

}
