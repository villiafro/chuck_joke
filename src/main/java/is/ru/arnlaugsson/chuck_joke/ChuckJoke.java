package is.arnlaugsson.chuck_joke;

import static spark.Spark.*;


public class ChuckJoke {
    public static void main(String[] args) {
        Chuck chuck = new Chuck();    
        get("/random", (req, res) -> chuck.random());
    }
}
