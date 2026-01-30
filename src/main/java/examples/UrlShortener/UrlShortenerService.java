package examples.UrlShortener;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Design and implement a URL shortener service similar to bit.ly
 *
 * Requirements:
 * 1. Shorten long URLs to 6-character codes
 * 2. Redirect short URLs to original URLs  
 * 3. Track click analytics (basic counting)
 * 4. Support custom aliases (if available)
 * 5. URL expiration (optional)
 * 6. Basic validation and error handling
 *
 * Focus on:
 * - Clean service architecture
 * - Proper separation of concerns  
 * - Data modeling
 * - Error handling
 * - Basic testing approach
 */

public class UrlShortenerService {

  // Define your data models
  public class ShortUrl {
    private String shortCode;
    private String originalUrl;
    private String customAlias;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private int clickCount;

    // Constructor, getters, setters

    public ShortUrl(String shortCode, String originalUrl, String customAlias,
        LocalDateTime expiresAt) {
      this.shortCode = shortCode;
      this.originalUrl = originalUrl;
      this.customAlias = customAlias;
      this.expiresAt = expiresAt;
      this.clickCount = 0;
    }

    public String getShortCode() {
      return shortCode;
    }

    public void setShortCode(String shortCode) {
      this.shortCode = shortCode;
    }

    public String getOriginalUrl() {
      return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
      this.originalUrl = originalUrl;
    }

    public String getCustomAlias() {
      return customAlias;
    }

    public void setCustomAlias(String customAlias) {
      this.customAlias = customAlias;
    }

    public LocalDateTime getCreatedAt() {
      return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
    }

    public boolean isExpired() {
      return expiresAt!=null && LocalDateTime.now().isAfter(expiresAt);
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
      this.expiresAt = expiresAt;
    }

    public int getClickCount() {
      return clickCount;
    }

    public void incrementClick() {
      clickCount++;
    }
  }

  // Service interface
  public interface UrlShortener {
    String shortenUrl(String originalUrl);
    String shortenUrl(String originalUrl, String customAlias);
    String getOriginalUrl(String shortCode);
    UrlAnalytics getAnalytics(String shortCode);
    boolean deleteShortUrl(String shortCode);
  }

  // Implement the service
  public class UrlShortenerServiceImpl implements UrlShortener {
    private final Map<String, ShortUrl> urlMappings;

    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6;
    private final Random random;
    public UrlShortenerServiceImpl() {
      this.random = new Random();
      this.urlMappings = new HashMap<>();
    }

    @Override
    public String shortenUrl(String originalUrl) {
      // Implement URL shortening logic
      // Generate 6-character code
      // Store mapping
      // Return short URL
      return shortenUrl(originalUrl, null);
    }

    @Override
    public String shortenUrl(String originalUrl, String customAlias) {
      // Implement with custom alias
      // Check if alias is available
      // Validate alias format
      validateUrl(originalUrl);
      String shortCode = (customAlias!=null) ? customAlias : generateShortCode();
      if (urlMappings.containsKey(shortCode)) {
        throw new IllegalArgumentException("Short Code already exists");
      }

      ShortUrl shortUrl = new ShortUrl(shortCode,originalUrl, customAlias, null);
      urlMappings.put(shortCode, shortUrl);
      return shortCode;
    }

    @Override
    public String getOriginalUrl(String shortCode) {
      // Implement URL retrieval and click tracking
      // Check expiration
      // Increment click count
      ShortUrl shortUrl = urlMappings.get(shortCode);

      if (shortUrl == null) {
        throw new IllegalArgumentException("Short URL not found");
      }
      if (shortUrl.isExpired()) {
        throw new IllegalStateException("URL has expired");
      }
      shortUrl.incrementClick();
      return shortUrl.getOriginalUrl();

    }

    private void validateUrl(String url) {
      if (url==null || !url.startsWith("http")) {
        throw new IllegalArgumentException("Invalid URL");
      }
    }

    private String generateShortCode() {
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<CODE_LENGTH;i++) {
        sb.append(BASE62.charAt(random.nextInt(BASE62.length())));
      }
      return sb.toString();
    }

    @Override
    public UrlAnalytics getAnalytics(String shortCode) {
      ShortUrl shortUrl = urlMappings.get(shortCode);
      if (shortUrl==null) {
        throw new IllegalArgumentException("Short URL not found");
      }

      return new UrlAnalytics(shortCode, shortUrl.getClickCount());
    }

    @Override
    public boolean deleteShortUrl(String shortCode) {
      return urlMappings.remove(shortCode)!=null;
    }


  }

  // Supporting classes
  public class UrlAnalytics {
    private String shortCode;
    private int totalClicks;

    public UrlAnalytics(String shortCode, int totalClicks) {
      this.shortCode = shortCode;
      this.totalClicks = totalClicks;
    }

    // Add more analytics fields as needed
  }
}