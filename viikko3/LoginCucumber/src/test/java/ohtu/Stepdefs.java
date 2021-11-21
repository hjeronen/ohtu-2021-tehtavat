package ohtu;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import ohtu.io.*;
import ohtu.data_access.*;
import ohtu.services.*;

public class Stepdefs {

    App app;
    StubIO io;
    UserDao userDao;
    AuthenticationService auth;
    List<String> inputLines;

    @Before
    public void setup() {
        userDao = new InMemoryUserDao();
        auth = new AuthenticationService(userDao);
        inputLines = new ArrayList<>();
    }

    @Given("^command login is selected$")
    public void commandLoginSelected() throws Throwable {
        inputLines.add("login");
    }
    
    @Given("^command new is selected$")
    public void commandNewSelected() throws Throwable {
        inputLines.add("new");
    }
    
    @Given("user {string} with password {string} is created")
    public void newUserIsCreated(String username, String password) throws Throwable {
        inputLines.add("new");
        inputLines.add(username);
        inputLines.add(password);
    }
    
    @When("username {string} and password {string} are entered")
    public void usernameAndPasswordAreEntered(String username, String password) {
        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        System.out.println("ohjelma tulosti seuraavat rivit "+io.getPrints());
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @When("wrong password is entered")
    public void cannotLoginWithIncorrectPassword() {
        inputLines.add("pekka");
        inputLines.add("wrong");

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }
    
    @When("wrong username is entered")
    public void cannotLoginWithNonexistingUsername() {
        inputLines.add("nonexisting");
        inputLines.add("wrong1");

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }
    
    @When("new username and proper password are entered")
    public void createNewUser() {
        inputLines.add("newUser");
        inputLines.add("properPassword1");

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }
    
    @When("given username is already taken")
    public void usernameIsTaken() {
        inputLines.add("pekka");
        inputLines.add("akkep1");

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }
    
    @When("too short username is given")
    public void usernameTooShort() {
        inputLines.add("p");
        inputLines.add("password1");

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }
    
    @When("too short password is given")
    public void passwordTooShort() {
        inputLines.add("Peksuli");
        inputLines.add("p1");

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }
    
    @When("password consists of only letters")
    public void passwordIsOnlyLetters() {
        inputLines.add("User");
        inputLines.add("kahdeksan");

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }
    
    @When("new user logs in")
    public void newUserLogsIn() {
        inputLines.add("eero");
        inputLines.add("salainen1");

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }
    
}
