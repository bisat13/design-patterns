package patterns.structural.proxy;

public class Main {
  public static void main(String[] args) {
    RealVideoService realService = new RealVideoService();
    ProxyVideoService proxyService = new ProxyVideoService(realService);
    // Free user trying to watch a video
    proxyService.playVideo("free", "Free Video 1");
    // Premium user trying to watch a video
    proxyService.playVideo("premium", "Premium Video 1");
    // Unauthorized user
    proxyService.playVideo("guest", "Video 1");
    // Too many requests
    for (int i = 0; i < 6; i++) {
      proxyService.playVideo("free", "Free Video 2");
    }
  }
}


/*
Types of Proxy Pattern
1. Virtual Proxy
Delays object creation
Example: Lazy loading images
2. Protection Proxy
Controls access based on permissions
if (!user.isAdmin()) {
    throw new SecurityException();
}
3. Remote Proxy
Represents an object in another JVM or system
Used in RMI, REST clients
4. Caching Proxy
Stores results to avoid repeated expensive calls
 */