package cucamberTest;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.design_patterns.singleton.FastClickGame;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefFastClickGame {

    FastClickGame fastClickGame;
    @Before
    public void init(){
        fastClickGame = FastClickGame.getInstance();
    }

    public void run(double time){
        fastClickGame.ready();
        fastClickGame.run(e -> {});
        fastClickGame.clickAble(true);
        fastClickGame.clickWithTime(e-> {},time);
        fastClickGame.main();
    }

    @Given("player play a fastClickGame")
    public void player_play_game(){
        fastClickGame = FastClickGame.getInstance();
    }

    @When("player click as (.*) sec")
    public void player_click(double time){
        fastClickGame.clearPlayTimes();
        run(time);
    }

    @When("player clicks as (.*) sec")
    public void player_clicks(String times){
        fastClickGame.clearPlayTimes();
        String  s =times.replaceAll("\\[","").replaceAll("\\]","");
        String[] strings = s.split(", ");
        for (String s1: strings){
            run(Double.parseDouble(s1));
        }
    }

    @When("try again with (.*) sec")
    public void player_tryagain(double time){
        run(time);
    }

    @Then("time arrays contain (.*)")
    public void times_contain(double time){
        assertTrue(fastClickGame.getPlayTimes().contains(time));
    }

    @Then("time arrays contains (.*)")
    public void times_contains(String times){
        String  s =times.replaceAll("\\[","").replaceAll("\\]","");
        String[] strings = s.split(", ");
        for (String s1: strings){
            assertTrue(fastClickGame.getPlayTimes().contains(Double.parseDouble(s1)));
        }

    }

    @Then("time arrays not contain (.*)")
    public void times_not_contain(double time){
        System.out.println(fastClickGame.getPlayTimes());
        assertFalse(fastClickGame.getPlayTimes().contains(time));
    }

    @Then("fastest is (.*)")
    public void fastest(double d){
        assertEquals(d, fastClickGame.getFastestTime(), 1e-15);
    }

}
