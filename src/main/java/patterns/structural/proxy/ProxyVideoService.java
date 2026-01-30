package patterns.structural.proxy;

import java.util.*;

public class ProxyVideoService implements VideoServiceInterface{

  private RealVideoService realVideoService;
  private Map<String, String> cachedVideos = new HashMap<>();
  private Map<String, Integer> requestCounts = new HashMap<>();
  public ProxyVideoService(RealVideoService realVideoService) {
    this.realVideoService = realVideoService;
  }

  @Override
  public void playVideo(String userType, String videoName) {
    if (!userType.equals("premium") && videoName.startsWith("premium")){
      System.out.println("Access denied: Premium video requires a premium account.");
      return;
    }

    // Limit requests
    requestCounts.put(userType, requestCounts.getOrDefault(userType, 0) + 1);
    if (requestCounts.get(userType) > 5) {
      System.out.println("Access denied: Too many requests.");
      return;
    }

    // Caching logic
    if (cachedVideos.containsKey(videoName)) {
      System.out.println("Streaming cached video: " + videoName);
    } else {
      realVideoService.playVideo(userType, videoName);
      cachedVideos.put(videoName, videoName);
    }
  }
}
