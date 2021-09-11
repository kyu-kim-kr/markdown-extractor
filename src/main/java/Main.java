import io.github.furstenheim.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
//        Date currentDate = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//        String formattedDate = format.format(currentDate);

        String url = "https://velog.io/@kyukim/" + 20210909;
        Document doc = Jsoup.connect(url).get();

        OptionsBuilder optionsBuilder = OptionsBuilder.anOptions();
        Options options = optionsBuilder
                .withHeadingStyle(HeadingStyle.ATX)
                .withBulletListMaker("-")
                .withCodeBlockStyle(CodeBlockStyle.FENCED)
                .build();

        CopyDown converter = new CopyDown(options);
        String myHtml = doc.select(".sc-hEsumM").toString();
        String markdown = converter.convert(myHtml);

        System.out.println(markdown);
        String pathName = 20210909 + ".md";
        File file = new File(pathName);
        FileWriter fw = new FileWriter(file);

        fw.write(markdown);
        fw.flush();
        fw.close();
    }
}
