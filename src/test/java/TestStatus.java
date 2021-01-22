/*
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestStatus implements AfterTestExecutionCallback {
    WebDriver driver;

    public boolean isFailed;
    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        if (extensionContext.getExecutionException().isPresent()){
            isFailed = true;
        }
        else isFailed = false;
    }

    private String takeScreenshot(TestInfo info) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        LocalDateTime timeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        String path = "C:\\screenshots\\" + info.getDisplayName() + " " + formatter.format(timeNow) + ".png";
        FileHandler.copy(screenshot, new File(path));
        return path;
    }
}
*/
