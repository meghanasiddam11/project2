import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class LinkShortener {

    private Map<String, String> urlMap;
    private Random random;
    private String characters;

    public LinkShortener() {
        this.urlMap = new HashMap<>();
        this.random = new Random();
        this.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    }

    public String shortenURL(String originalURL) {
        String shortURL = generateShortURL();
        urlMap.put(shortURL, originalURL);
        return shortURL;
    }

    public String getOriginalURL(String shortURL) {
        return urlMap.get(shortURL);
    }

    private String generateShortURL() {
        StringBuilder shortURL = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            shortURL.append(characters.charAt(random.nextInt(characters.length())));
        }
        return shortURL.toString();
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();

        String originalURL = "https://www.example.com/very/long/url";
        String shortURL = linkShortener.shortenURL(originalURL);
        System.out.println("Short URL: " + shortURL);

        String retrievedOriginalURL = linkShortener.getOriginalURL(shortURL);
        System.out.println("Original URL: " + retrievedOriginalURL);
    }
}
