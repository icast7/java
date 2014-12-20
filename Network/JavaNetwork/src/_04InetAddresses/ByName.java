package _04InetAddresses;
 
import java.net.*;
 
public class ByName {
       public static void main(String[] args) {
              try {
                     System.out.println("============== getByName ===============");
                     InetAddress address1 = InetAddress.getByName("www.google.com");
                     System.out.println(address1);
                     System.out.println("========================================");
                     System.out.println("============== getByIP ===============");
                     InetAddress address2 = InetAddress.getByName("216.58.216.132");
                     System.out.println(address2.getHostName());
                     System.out.println("========================================");
                     System.out.println("============== getAllByName ===============");
                     InetAddress[] address3 = InetAddress.getAllByName("www.google.com");
                     for (InetAddress a : address3){
                           System.out.println(a);
                     }
                     System.out.println("========================================");
                     System.out.println("============== getLocalHost ===============");
                     InetAddress address4 = InetAddress.getLocalHost();
                     System.out.println(address4);
                     System.out.println("========================================");
              } catch (UnknownHostException ex) {
                     System.out.println(ex.toString() + ex.getMessage());
              }
       }
}