package GameTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get(
                "https://tbot.xyz/math/#eyJ1IjoxNTU1NTQ1LCJuIjoiTmF6aW0gU2hhYXppem92IiwiZyI6Ik1hdGhCYXR0bGUiLCJjaSI6Ii02NDg1NzQwNDM5NDAzMDMwMTI0IiwiaSI6IkFnQUFBTjg1QmdBWHNSZ1hldzZQSHE2azZOSSJ9YzRhYWE2NGQyNWJkODVjZjljNDNjM2EwZjU2OWMyZWM=&tgShareScoreUrl=tg%3A%2F%2Fshare_game_score%3Fhash%3Dfn4PbaJyLFbNp7xQltg4PyKv82CpO7TSK-vn3i6M1x8");

        driver.findElement(By.xpath("//div[@class = 'icon_play']")).click();

        for (int i = 0; i < 4000; i++) {

            String x = driver.findElement(By.id("task_x")).getText();

            Integer xInt = null;
            try {
                xInt = Integer.parseInt(x);
            } catch (NumberFormatException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            String op = driver.findElement(By.id("task_op")).getText();

            String y = driver.findElement(By.id("task_y")).getText();

            Integer yInt = null;
            try {
                yInt = Integer.parseInt(y);
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            String res = driver.findElement(By.id("task_res")).getText();

            String answer = answer(op, xInt, yInt);

            System.out.println(answer+"ans");

            System.out.println(res+"res");

            if (answer.equals(res)) {

                driver.findElement(By.id("button_correct")).click();

            } else {

                driver.findElement(By.id("button_wrong")).click();

            }
        }

    }

    public static String answer(String op, int x, int y) {

        if (op.equals("+")) {

            Integer ans = x + y;

            return ans.toString();

        } else if (op.equals("/")) {

            Integer ans = x / y;

            return ans.toString();

        } else if (op.equals("*")) {

            Integer ans = x * y;

            return ans.toString();

        } else {

            Integer ans = x - y;

            return ans.toString();

        }

    }
}
