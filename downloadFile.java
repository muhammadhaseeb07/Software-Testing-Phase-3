/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaretesting;

import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author mians
 */
public class downloadFile {
    public void mainFunction(){
        System.setProperty("webdriver.chrome.driver", 
                "D:\\FAST stuff\\Semester 7\\Software Testing\\Project\\chromedriver.exe");
        
        //file is going to save in user.dir which is NetBeansProject\SoftwareTesting at this moment
        WebDriver wb = new ChromeDriver();
        wb.navigate().to("http://slate.nu.edu.pk/portal/site/LHREE204FALL2019CS/tool/LHREE204FALL2019CS310");
        WebElement username = wb.findElement(By.id("eid"));
        WebElement pass = wb.findElement(By.id("pw"));
        WebElement login = wb.findElement(By.id("submit"));
        
        username.sendKeys("l164206");
        pass.sendKeys("123456");
        login.click();
        
        List<WebElement> list = wb.findElements(By.name("asnActionLink"));
        list.get(0).click();
        
        WebElement fileLink = wb.findElement(By.cssSelector("div.portletBody>ul>li>a"));
        fileLink.click();
        
        File folder = new File("C:\\Users\\mians\\Downloads\\Documents");
        File[] listOfFiles = folder.listFiles();
        
        while(listOfFiles.length == 0){
            listOfFiles = folder.listFiles();
        }
        
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
               String fileName = listOfFile.getName();
               System.out.println("File " + listOfFile.getName());
               if (fileName.matches("Assignment 3.pdf")) {
                   System.out.println("Test passed!");
                   return;
                }
            }
        }
        System.out.println("Test Failed!");
        wb.close();
        wb.quit();
    }
}
