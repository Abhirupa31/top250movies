package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Top250Movies {
    public static void main(String[] args) {
        // Set path to EdgeDriver
        System.setProperty("webdriver.edge.driver", "C:\\Users\\abhir\\Documents\\edgedriver_win32\\msedgedriver.exe");

        // Initialize EdgeDriver
        WebDriver driver = new EdgeDriver();

       // Navigate to IMDb website
       driver.get("https://www.imdb.com/chart/top");

       // Find the list of top rated movies
       List<WebElement> movieElements = driver.findElements(By.xpath("//td[@class='titleColumn']"));

       // Loop through each movie element to extract data
       for (WebElement movieElement : movieElements) {
           // Extract movie title
           WebElement titleElement = movieElement.findElement(By.tagName("a"));
           String title = titleElement.getText().trim();

           // Extract movie rating
           WebElement ratingElement = movieElement.findElement(By.xpath("../td[@class='ratingColumn imdbRating']"));
           String rating = ratingElement.getText().trim();

           // Print movie title and rating
           System.out.println("Title: " + title + ", Rating: " + rating);
       }

       // Close the browser
       driver.quit();
    }
}
