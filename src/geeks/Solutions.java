package geeks;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solutions {

  public static void main(String [] args) throws IOException {
    System.out.println(calculateHoldingValue("20190506"));
  }

  public static Double calculateHoldingValue(String date) throws IOException {
    Gson gson = new Gson();

    String holdingUrl = "https://api.myjson.com/bins/1eleys";
    HttpURLConnection holdingConnection = getConnection(holdingUrl);
    int holdingResponseCode = holdingConnection.getResponseCode();
    HoldingRecord holdingRecord;
    String holdingResponse = getRecordJson(holdingConnection, holdingResponseCode);
    holdingRecord = gson.fromJson(holdingResponse, HoldingRecord.class);
    Map<String, Double> securityQuantity = getQuantityMap(date, holdingRecord);


    String pricingUrl = "https://api.myjson.com/bins/vf9ac";
    HttpURLConnection pricingConnection = getConnection(pricingUrl);
    int pricingResponseCode = pricingConnection.getResponseCode();
    PriceRecord priceRecord;
    String pricingJson = getRecordJson(pricingConnection, pricingResponseCode);
    priceRecord = gson.fromJson(pricingJson, PriceRecord.class);
    Map<String, Double> securityPrice = getPriceMap(date, priceRecord);

    return calculateTotalHoldingValue(securityQuantity, securityPrice);
  }

  private static Double calculateTotalHoldingValue(Map<String, Double> securityQuantity, Map<String, Double> securityPrice) {
    Double totalValue = 0.0;
    for(Entry<String, Double> entry : securityQuantity.entrySet()) {
      if(securityPrice.get(entry.getKey()) != null) {
        totalValue += entry.getValue() * securityPrice.get(entry.getKey());
      }
    }
    return totalValue;
  }


  private static Map<String, Double> getPriceMap(String date, PriceRecord priceRecord) {
    Map<String, Double> securityPrice = new HashMap<>();

    for(Price price : priceRecord.getData()) {
      if(price.date.equals(date)) {
        securityPrice.put(price.getSecurity(), price.getPrice());
      }
    }
    return securityPrice;
  }

  private static Map<String, Double> getQuantityMap(String date, HoldingRecord record) {
    Map<String, Double> securityQuantity = new HashMap<>();

    for(Holding holding : record.getData()) {
      if(holding.date.equals(date)) {
        securityQuantity.put(holding.getSecurity(), holding.getQuantity());
      }
    }
    return securityQuantity;
  }

  private static String getRecordJson(HttpURLConnection con, int responseCode)
      throws IOException {
    String readLine;
    StringBuffer response;
    if (responseCode == HttpURLConnection.HTTP_OK) {
      BufferedReader in = new BufferedReader(
          new InputStreamReader(con.getInputStream()));
      response = new StringBuffer();
      while ((readLine = in .readLine()) != null) {
        response.append(readLine);
      } in .close();
    } else {
      throw new IOException("Request Failed");
    }
    return response.toString();
  }

  private static HttpURLConnection getConnection(String url) throws IOException {
    URL obj = new URL(url);
    HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
    connection.setRequestMethod("GET");
    return connection;
  }


  public static class HoldingRecord {


    int           totalRecords;
    List<Holding> data;

    public int getTotalRecords() {
      return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
      this.totalRecords = totalRecords;
    }

    public List<Holding> getData() {
      return data;
    }

    public void setData(List<Holding> data) {
      this.data = data;
    }
  }

  public static class Holding {

    String date;
    String security;
    double quantity;
    String portfolio;

    public String getDate() {
      return date;
    }

    public void setDate(String date) {
      this.date = date;
    }

    public String getSecurity() {
      return security;
    }

    public void setSecurity(String security) {
      this.security = security;
    }

    public double getQuantity() {
      return quantity;
    }

    public void setQuantity(double quantity) {
      this.quantity = quantity;
    }

    public String getPortfolio() {
      return portfolio;
    }

    public void setPortfolio(String portfolio) {
      this.portfolio = portfolio;
    }
  }

  public static class PriceRecord {
    int totalRecords;
    List<Price> data;

    public int getTotalRecords() {
      return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
      this.totalRecords = totalRecords;
    }

    public List<Price> getData() {
      return data;
    }

    public void setData(List<Price> data) {
      this.data = data;
    }
  }

  public static class Price {
    String date;
    String security;
    Double price;

    public String getDate() {
      return date;
    }

    public void setDate(String date) {
      this.date = date;
    }

    public String getSecurity() {
      return security;
    }

    public void setSecurity(String security) {
      this.security = security;
    }

    public Double getPrice() {
      return price;
    }

    public void setPrice(Double price) {
      this.price = price;
    }
  }

}
