package com.novelCheck.scraper.resource;

import com.novelCheck.scraper.model.NovelChap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/scrape")
public class NovelScrapper {

    @RequestMapping("/{seriaNazwa}")
    public NovelChap getNewChapScrape(@PathVariable("seriaNazwa") String seriaNazwa) {
        Document doc = null;

        try {
            doc = Jsoup.connect("https://www.novelupdates.com/series/"+seriaNazwa).get();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Elements content = doc.getElementsByClass("chp-release");//znajduje chaptery
        System.out.println(content);//do testu
        return new NovelChap(content.attr("title"),content.attr("href"));



    }
}

/*for (Element chapter : content) {//to mi wypisuje wszystkie a chyba tylko naj mi wystarczy
            String chapNum = chapter.attr("title");//wypisuje nr chapterów
            String chapLink = chapter.attr("href");//wypisuje wszystkie linki
        }*/
//System.out.println();
