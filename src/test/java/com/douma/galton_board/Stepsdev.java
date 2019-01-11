package com.douma.galton_board;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class Stepsdev {

    private Integer numberOfTrays;
    private DropPolicyInterface dropPolicy;
    private Tray[] trays;

    @Given("I have {int} trays")
    public void i_have_trays(Integer int1) {
        this.numberOfTrays = int1;
    }

    @Given("the bullet will fall {string}")
    public void the_bullet_will_fall(String string) {
        dropPolicy = new DescriptiveDropPolicy(string);
    }

    @When("I drop the bullet")
    public void i_drop_the_bullet() throws Exception {
        Tray[] trays = Tray.listFromLength(this.numberOfTrays);
        Bullet[] bullets = Bullet.listFromLength(1);
        GaltonBoard galtonBoard = new GaltonBoard(trays, bullets, this.dropPolicy);
        galtonBoard = galtonBoard.dropBullets();
        this.trays = galtonBoard.getTrays();
    }

    @Then("The bullet should be in tray {int}")
    public void the_bullet_should_be_in_tray(Integer int1) throws Exception {
        Tray resultTray = this.trays[int1-1];
        if(resultTray.getNumberOfBullets() != 1)
        {
            throw new Exception("Bullet is not in tray " + int1);
        }
    }
}
