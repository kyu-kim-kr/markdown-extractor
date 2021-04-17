import io.github.furstenheim.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 96 + 1; i++) {
            String date = new DateGenerator().setRange(i);
            String url = "https://velog.io/@kyukim/" + date;
            Document doc = Jsoup.connect(url).get();

            OptionsBuilder optionsBuilder = OptionsBuilder.anOptions();
            Options options = optionsBuilder
                    .withHeadingStyle(HeadingStyle.ATX)
                    .withBulletListMaker("-")
                    .withCodeBlockStyle(CodeBlockStyle.FENCED)
                    .build();

            CopyDown converter = new CopyDown(options);
            String myHtml = doc.select(".sc-bbmXgH").toString();
            String markdown = converter.convert(myHtml);

            String pathName = date + ".md";
            File file = new File(pathName);
            FileWriter fw = new FileWriter(file);

            fw.write(markdown);
            fw.flush();
            fw.close();
        }

    }
}
