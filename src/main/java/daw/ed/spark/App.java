package daw.ed.spark;

import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.get;

public class App {

    public static void main(String[] args) {
        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "<h1>Esto es la raíz</h1>";
            }
        });
        
        get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                return "<h1>Hello Spark MVC Framework!</h1>";
            }
        });
        
        get(new Route("/test") {
            @Override
            public Object handle(Request request, Response response) {
                return "<h1>Esto es un test!</h1>";
            }
        });
        
        get(new Route("/hello/:name") {
            @Override
            public Object handle(Request request, Response response) {
                String name = request.params(":name");
                
                return String.format("<h1>Hello %s!</h1>",name);
            }
        });
        
        get(new Route("/request/info") {
            @Override
            public Object handle(Request request, Response response) {
                String fmt =  "<ul>" +                        
                        "<li>IP: %s</li>" +
                        "<li>Request Method: %s</li>" +
                        "<li>URL: %s</li>" +
                        "<li>User Agent: %s</li>" +
                        "<li>Host: %s</li>" +
                        "<li>Content Type: %s</li>" +
                        "<li>Content Lenght: %s</li>" +
                        "<li>Headers: %s</li>" +
                        "</ul>";
                return String.format(fmt,
                        request.ip(),
                        request.requestMethod(),
                        request.url(),
                        request.userAgent(),
                        request.host(),
                        request.contentType(),
                        request.contentLength(),
                        request.headers());
            }
        });
        
        get(new Route("/redirect") {
            @Override
            public Object handle(Request request, Response response) {
                response.redirect("http://www.google.com");
                return response;
            }
        });
        
        get(new Route("/protected") {
            @Override
            public Object handle(Request request, Response response) {
                halt(401,"Go Away!!!");
                return null;
            }
        });
    }
}
