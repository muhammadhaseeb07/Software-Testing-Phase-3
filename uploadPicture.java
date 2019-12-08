/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaretesting;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author mians
 */
public class uploadPicture {
    public void mainFunction(){
        System.setProperty("webdriver.chrome.driver", 
                "D:\\FAST stuff\\Semester 7\\Software Testing\\Project\\chromedriver.exe");
        
        //file is going to save in user.dir which is NetBeansProject\SoftwareTesting at this moment
        WebDriver wb = new ChromeDriver();
        wb.navigate().to("http://slate.nu.edu.pk/portal/site/~l164206/tool/d47cb979-d7cb-43c3-9848-d3b718880500/profile?0");
        WebElement username = wb.findElement(By.id("eid"));
        WebElement pass = wb.findElement(By.id("pw"));
        WebElement login = wb.findElement(By.id("submit"));
        
        username.sendKeys("l164206");
        pass.sendKeys("123456");
        login.click();
        
        WebElement changePic = wb.findElement(By.xpath("//*[@id=\"id1\"]"));
        Actions actions = new Actions(wb);
        actions.moveToElement(changePic).click().build().perform();
        
        WebElement pic = wb.findElement(By.xpath("//*[@id=\"myPhoto\"]/img"));
        String t1 = pic.getText();
        
        for(int i = 0; i < 50000; i++){
            for(int j = 0; j < 5000; j++){
                for(int k = 0; k < 5000; k++){
                
                }
            }
        }
        
        WebElement choosePic = wb.findElement(By.xpath("//*[@id=\"pictureupload\"]"));
        choosePic.sendKeys("C:\\Users\\mians\\Desktop\\tom.jpg");
        
        WebElement uploadPic = wb.findElement(By.xpath("//*[@id=\"id1b\"]"));
        uploadPic.click();
        
        for(int i = 0; i < 50000; i++){
            for(int j = 0; j < 5000; j++){
                for(int k = 0; k < 5000; k++){
                    
                }
            }
        }
        
        String t2 = pic.getText();
        
        if(t2 != t1){
            System.out.println("Picture upload test passed");
        }
        else{
            System.out.println("Picture upload test failed");
        }
    }
}
