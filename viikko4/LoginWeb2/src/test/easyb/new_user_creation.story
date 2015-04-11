import ohtu.*
import ohtu.authentication.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


description """A new user account can be created 
              if a proper unused username 
              and a proper password are given"""

scenario "creation succesfull with correct username and password", {
    given 'user is on the registration page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090")
        element = driver.findElement(By.linkText("register new user"))      
        element.click();    
    }
 
    when 'a valid username and password are entered', {
        element = driver.findElement(By.name("username"))
        element.sendKeys("ppekka")
        element = driver.findElement(By.name("password"))
        element.sendKeys("11akkepp")
        element = driver.findElement(By.name("passwordConfirmation"))
        element.sendKeys("11akkepp")
        element = driver.findElement(By.name("add"))
        element.submit()
    }

    then 'new user is registered to system', {
        driver.getPageSource().contains("Welcome to Ohtu App!").shouldBe true
    }
}

scenario "can login with succesfully generated account", {
    given 'user is on the registration page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090")
        element = driver.findElement(By.linkText("register new user"))       
        element.click()
    }
 
    when 'a valid username and password are entered', {
        element = driver.findElement(By.name("username"))
        element.sendKeys("ppekka")
        element = driver.findElement(By.name("password"))
        element.sendKeys("11akkepp")
        element = driver.findElement(By.name("passwordConfirmation"))
        element.sendKeys("11akkepp")
        element = driver.findElement(By.name("add"))
        element.submit()
    }

    then  'new credentials allow logging in to system', {
        driver.get("http://localhost:8090/ohtu")
        element = driver.findElement(By.linkText("logout"));
        element.click();

        driver.get("http://localhost:8090")
         
        element = driver.findElement(By.linkText("login"));       
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("ppekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("11akkepp");
        element = driver.findElement(By.name("login"));
        element.submit();

        driver.getPageSource().contains("Welcome to Ohtu Application!").shouldBe true
    }

}
scenario "creation fails with correct username and too short password", {
    given 'user is on the registration page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090")
        element = driver.findElement(By.linkText("register new user"))       
        element.click()
    }
    when 'a valid username and too short password are entered', {
        element = driver.findElement(By.name("username"))
        element.sendKeys("ppekka")
        element = driver.findElement(By.name("password"))
        element.sendKeys("1kepp")
        element = driver.findElement(By.name("passwordConfirmation"))
        element.sendKeys("1kepp")
        element = driver.findElement(By.name("add"))
        element.submit()
    }
    then 'new user is not be registered to system', {
        driver.getPageSource().contains("Welcome to Ohtu App!").shouldBe false
    }
}
scenario "creation fails with correct username and password consisting of letters", {
    given 'user is on the registration page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090")
        element = driver.findElement(By.linkText("register new user"))       
        element.click()
    }
    when 'a valid username and a password consisting of letters are entered', {
        element = driver.findElement(By.name("username"))
        element.sendKeys("ppekka")
        element = driver.findElement(By.name("password"))
        element.sendKeys("kkeppppp")
        element = driver.findElement(By.name("passwordConfirmation"))
        element.sendKeys("kkeppppp")
        element = driver.findElement(By.name("add"))
        element.submit()
    }
    then 'new user is not be registered to system', {
        driver.getPageSource().contains("Welcome to Ohtu App!").shouldBe false
    }
}
scenario "creation fails with too short username and valid password", {
    given 'user is on the registration page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090")
        element = driver.findElement(By.linkText("register new user"))       
        element.click()
    }
    when 'a too short username and a valid password are entered', {
        element = driver.findElement(By.name("username"))
        element.sendKeys("p")
        element = driver.findElement(By.name("password"))
        element.sendKeys("kkeppppp1")
        element = driver.findElement(By.name("passwordConfirmation"))
        element.sendKeys("kkeppppp1")
        element = driver.findElement(By.name("add"))
        element.submit()
    }
    then 'new user is not be registered to system', {
        driver.getPageSource().contains("Welcome to Ohtu App!").shouldBe false
    }
}
scenario "creation fails with already taken username and valid password", {
    given 'user is on the registration page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090")
        element = driver.findElement(By.linkText("register new user"))       
        element.click()
    }
    when 'a taken username and a valid password are entered', {
        element = driver.findElement(By.name("username"))
        element.sendKeys("pekka")
        element = driver.findElement(By.name("password"))
        element.sendKeys("kkeppppp1")
        element = driver.findElement(By.name("passwordConfirmation"))
        element.sendKeys("kkeppppp1")
        element = driver.findElement(By.name("add"))
        element.submit()
    }
    then 'new user is not be registered to system', {
        driver.getPageSource().contains("Welcome to Ohtu App!").shouldBe false
    }
}

scenario "can not login with account that is not successfully created", {
    given 'user is on the registration page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090")
        element = driver.findElement(By.linkText("register new user"))       
        element.click()
    }
 
    when 'a invalid username/password are entered', {
        element = driver.findElement(By.name("username"))
        element.sendKeys("ppekka")
        element = driver.findElement(By.name("password"))
        element.sendKeys("akkepp")
        element = driver.findElement(By.name("passwordConfirmation"))
        element.sendKeys("akkepp")
        element = driver.findElement(By.name("add"))
        element.submit()
    }

    then  'new credentials do not allow logging in to system', {
        driver.get("http://localhost:8090")
         
        element = driver.findElement(By.linkText("login"));       
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("ppekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkepp");
        element = driver.findElement(By.name("login"));
        element.submit();

        driver.getPageSource().contains("Welcome to Ohtu Application!").shouldBe false
    }
}