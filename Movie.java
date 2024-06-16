package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Movie {
    public static void main(String[] args) {
        // Set the path to the EdgeDriver executable
        System.setProperty("webdriver.edge.driver", "C:\\Users\\abhir\\Documents\\edgedriver_win32\\msedgedriver.exe");

        // Initialize EdgeDriver
        WebDriver driver = new EdgeDriver();

        // Navigate to IMDb website
        driver.get("https://www.imdb.com/");

        // Search for a movie (e.g., "The Shawshank Redemption")
        WebElement searchBox = driver.findElement(By.id("suggestion-search"));
        searchBox.sendKeys("Fighter");
        searchBox.submit();

        // Click on the first search result
        WebElement firstResult = driver.findElement(By.cssSelector(".findResult.odd:nth-child(1) .result_text a"));
        firstResult.click();

        // Extract movie rating
        WebElement ratingElement = driver.findElement(By.cssSelector(".ratingValue span[itemprop='ratingValue']"));
        String rating = ratingElement.getText();
        System.out.println("The rating of the movie is: " + rating);

        // Close the browser
        driver.quit();
    }
}
