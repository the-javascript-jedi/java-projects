package com.embarkx.FirstSpring;

// Imports all Spring web annotations (@RestController, @GetMapping, @PostMapping,
// @RequestBody, @PathVariable, ...). Like importing a bunch of decorators in TS.
import org.springframework.web.bind.annotation.*;

/**
 * @RestController = "this class handles HTTP requests, and whatever each method
 * returns is written straight into the response body" (as text or JSON).
 * JS analogy: an Express router file where every handler does res.send(...) / res.json(...).
 * Spring finds this class automatically (component scan) and registers its routes.
 */
@RestController
public class HelloController {

    // GET /hello  ->  responds with plain text "Hello World!"
    // JS analogy: app.get('/hello', (req, res) => res.send('Hello World!'))
    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    // POST /hello  ->  plain text in, plain text out.
    // @RequestBody takes the raw request body and puts it in `name`.
    // Example: body "Nithin" -> response "Hello Nithin!"
    // JS analogy: const name = req.body
    @PostMapping("/hello")
    public String helloPost(@RequestBody String name){
        return "Hello "+ name +"!";
    }


    // GET /helloJson  ->  returns a JSON object.
    // Returning an object (HelloResponse) makes Spring auto-convert it to JSON
    // (via Jackson), e.g. {"message":"Hello world"} (field name depends on HelloResponse).
    // JS analogy: res.json({ message: 'Hello world' })
    @GetMapping("/helloJson")
    public HelloResponse helloJson(){
        return new HelloResponse("Hello world");
    }

    // POST /helloJson  ->  body is read as a raw String, response is JSON.
    // Note: @RequestBody String gives the WHOLE body as text (even if you send JSON,
    // you'd get the raw JSON string). To read a JSON field, use a class as the parameter type.
    @PostMapping("/helloJson")
    public HelloResponse helloPostJson(@RequestBody String name){
        return new HelloResponse( "Hello "+ name +"!");
//        return "Hello "+ name +"!";   // old version that returned plain text instead of JSON
    }

    // GET /hello/{name}  ->  dynamic URL segment (path variable).
    // Example: GET /hello/Sam -> "Hello Dynamic Sam"
    // @PathVariable binds {name} from the URL to the `name` parameter
    // (the names must match). JS analogy: req.params.name  for  app.get('/hello/:name', ...)
    @GetMapping("hello/{name}")
    public HelloResponse greetName(@PathVariable String name){
        return new HelloResponse("Hello Dynamic "+name);
    }

}
