package interactions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeAndSave {

    //Método para tomar pantallazos, se manda el driver y el nombre del archivo como argumentos. Se guarda en la carpeta screenshots en el paquete test.
    public void screenshot(WebDriver driver,String name) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\src\\test\\java\\screenshots\\"+name+".jpg"), true);
    }
}
