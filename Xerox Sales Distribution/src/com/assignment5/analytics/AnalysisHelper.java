/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.analytics;

import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 *
 * @author neera
 */
public class AnalysisHelper {

    Map<Integer, Integer> prodquants = new HashMap<Integer, Integer>();
    Map<Integer, Integer> custquants = new HashMap<Integer, Integer>();

    public void generateQuantity() {
        Map<Integer, Order> orders = DataStore.getInstance().getOrderMap();

        for (Order order : orders.values()) {
            int total = 0, temp = 0, temp1 = 0;
            int quant = order.getItem().getQuantity();
            if (prodquants.containsKey(order.getItem().getProductId())) {
                temp = prodquants.get(order.getItem().getProductId());
            }
            if (custquants.containsKey(order.getCustomerId())) {
                temp1 = custquants.get(order.getCustomerId());
            }
            temp1 += quant;
            temp += quant;
            custquants.put(order.getCustomerId(), temp1);
            prodquants.put(order.getItem().getProductId(), temp);

        }
//            System.out.println("----------------------------------------");
//          System.out.println("Quantttt"+prodquants);
    }

    public void top3Products() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                  QUESTION 1                                                               ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
       // System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("TOP 3 PRODUCTS ");
        Map<Integer, Integer> topThreeProd = new HashMap<Integer, Integer>();

        Map<Integer, Order> orders = DataStore.getInstance().getOrderMap();
        // Map<Integer, Double> minPriceMap = DataStore.getInstance().getMinPriceMap();
        Map<Integer, Double> targetPrice = DataStore.getInstance().getTargetPriceMap();

        for (Order order : orders.values()) {
            int productId = order.getItem().getProductId();
            double targetPriceVal = targetPrice.get(productId);
            int quantity = order.getItem().getQuantity();
            double diff = order.getItem().getSalesPrice() - targetPriceVal;
            //double revenue = (order.getItem().getQuantity()) * profit;
            int temp = 0;
            if (diff > 0) {
                if (topThreeProd.containsKey(order.getItem().getProductId())) {
                    temp = topThreeProd.get(order.getItem().getProductId());
                }
                temp += quantity;
                topThreeProd.put(order.getItem().getProductId(), temp);
            }
        }

        LinkedHashMap<Integer, Integer> sortedMap
                = topThreeProd.entrySet().stream().
                        sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));

        LinkedHashMap<Integer, List<Integer>> sortedMap1 = sortedMap.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet().stream()
                .filter(e -> e.getValue().size() >= 1).sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        // .forEach(System.out::println);

//        System.out.println("Sorted" + sortedMap);
//        System.out.println("Sorted Map with products:" + sortedMap1);
//        
        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(sortedMap1.entrySet());

        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            if (i < 3) {
                System.out.println("Number of Quantity Sold:   " + list.get(i).getKey() + "  List of Products with Same Quantities:  " + list.get(i).getValue());
            }
        }

    }

    public void top3Customers() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                  QUESTION 2                                                               ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
 //       System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Top 3 Customer for organization are: ");
        Map<Integer, Double> topThreeBestCustomer = new HashMap<Integer, Double>();

        Map<Integer, Order> orders = DataStore.getInstance().getOrderMap();
        Map<Integer, Double> targetPrice = DataStore.getInstance().getTargetPriceMap();

        for (Order order : orders.values()) {
            int customerId = order.getCustomerId();
            int productId = order.getItem().getProductId();
            double targetPriceVal = targetPrice.get(productId);
            double profit = Math.abs(order.getItem().getSalesPrice() - targetPriceVal);
            //  double revenue = (order.getItem().getQuantity()) * profit;
            double netrevenue = 0;
            if (topThreeBestCustomer.containsKey(order.getCustomerId())) {
                netrevenue = topThreeBestCustomer.get(order.getCustomerId());
            }
            netrevenue += profit;

            topThreeBestCustomer.put(order.getCustomerId(), netrevenue);
        }

        LinkedHashMap<Integer, Double> sortedMap
                = topThreeBestCustomer.entrySet().stream().
                        sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));

        LinkedHashMap<Double, List<Integer>> sortedMap1 = sortedMap.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet().stream()
                .filter(e -> e.getValue().size() >= 1).sorted(Map.Entry.comparingByKey()).limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        // .forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------Customers who bought about Target Price ( ASCENDING ORDER )-------------------------------");
        //System.out.println("Sorted" + sortedMap);
        //  System.out.println("Sorted Map with products:" + sortedMap1);

        List<Map.Entry<Double, List<Integer>>> list = new ArrayList<>(sortedMap1.entrySet());

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            if (i < 3) {
                System.out.println("Price Value   " + list.get(i).getKey() + "  List of Customers with Same Price:  " + list.get(i).getValue());
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------Customers who bought far from Target Price ( DESCENDING ORDER )-------------------------------");

        LinkedHashMap<Double, List<Integer>> sortedMap2 = sortedMap.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet().stream()
                .filter(e -> e.getValue().size() >= 1).sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        // .forEach(System.out::println);

        //   System.out.println("Sorted" + sortedMap);
        // System.out.println("Sorted Map with products:" + sortedMap1);
        List<Map.Entry<Double, List<Integer>>> list1 = new ArrayList<>(sortedMap2.entrySet());

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < list1.size(); i++) {
            if (i < 3) {
                System.out.println("Price Value   " + list1.get(i).getKey() + "  List of Customers with Same Price:  " + list1.get(i).getValue());
            }
        }

        // System.out.println("Sorted" + sortedMap);
        /* for (Map.Entry<Integer, Double> mpd : sortedMap.entrySet()) {
            Integer count = custquants.get(mpd.getKey());
            
            System.out.println("Customer Id: " + mpd.getKey() + " - Profit: " + mpd.getValue());
        }*/
        //  System.out.println(topThreeBestCustomer);
    }

	public void top3Sales() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                  QUESTION 3                                                               ");
     //   System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" TOP 3 SALES ID ");
        Map<Integer, Double> topThreeBestCustomer = new HashMap<Integer, Double>();
        Map<Integer, Integer> topThreeBestCustomerQuant = new HashMap<Integer, Integer>();
        Map<Integer, Integer> prodcount = new HashMap<Integer, Integer>();

        Map<Integer, Order> orders = DataStore.getInstance().getOrderMap();
        // Map<Integer, Double> minPriceMap = DataStore.getInstance().getMinPriceMap();
        Map<Integer, Double> targetPrice = DataStore.getInstance().getTargetPriceMap();

        for (Order order : orders.values()) {
            int sales = order.getSupplierId();
            int productId = order.getItem().getProductId();
            double targetPriceVal = targetPrice.get(productId);
            int quantity = order.getItem().getQuantity();
            double profit = order.getItem().getSalesPrice() - targetPriceVal;
            double revenue = (order.getItem().getQuantity()) * profit;
            double temp = 0;
            if (profit > 0) {
                if (topThreeBestCustomer.containsKey(order.getSupplierId())) {
                    temp = topThreeBestCustomer.get(order.getSupplierId());
                }
                temp += revenue;
                topThreeBestCustomer.put(order.getItem().getProductId(), temp);
            }
        }

        LinkedHashMap<Integer, Double> sortedMap
                = topThreeBestCustomer.entrySet().stream().
                        sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(5).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));

        LinkedHashMap<Double, List<Integer>> sortedMap1 = sortedMap.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet().stream()
                .filter(e -> e.getValue().size() >= 1).sorted(Map.Entry.comparingByKey()).limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        // .forEach(System.out::println);

        System.out.println("-------------------------3 SALES ID WHO HAVE MOST PROFIT-------------------------------");
        //System.out.println("Sorted" + sortedMap);
        //  System.out.println("Sorted Map with products:" + sortedMap1);

        List<Map.Entry<Double, List<Integer>>> list = new ArrayList<>(sortedMap1.entrySet());

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            if (i < 3) {
                System.out.println("PROFIT   " + list.get(i).getKey() + "     List of SALES ID with Same Profit:  " + list.get(i).getValue());
            }
        }

    }

    public void totalRevenue() {
        Map<Integer, Order> orders = DataStore.getInstance().getOrderMap();
        Map<Integer, Double> targetPrice = DataStore.getInstance().getTargetPriceMap();
        double totalrev = 0.0;
        for (Order order : orders.values()) {

            int productId = order.getItem().getProductId();
            double targetPriceVal = targetPrice.get(productId);
            int quantity = order.getItem().getQuantity();
            double profit = order.getItem().getSalesPrice() - targetPriceVal;
            if (profit > 0) {
                double revenue = (order.getItem().getQuantity()) * profit;
                totalrev += revenue;
            }

        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                  QUESTION 4                                                               ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Total Revenue above expected target value in a fiscal year " + totalrev);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    
    public static void question5Static() throws IOException {
        Map<Integer, Double> averageSalesPrice = new HashMap<>();
        Map<Integer, Double> originalTargetPrice = new HashMap<>();
        Map<Integer, Double> modifiedTargetPrice = new HashMap<>();

        Map<Integer, Double> ogDifferenceSPTP = new HashMap<>();
        Map<Integer, Double> modDifferenceSPTP = new HashMap<>();

        Map<Integer, Double> ogProductLower = new HashMap<>();
        Map<Integer, Double> ogProductHigher = new HashMap<>();
        Map<Integer, Double> modProductLower = new HashMap<>();
        Map<Integer, Double> modProductHigher = new HashMap<>();

        List<List<String>> salesArr = new ArrayList<>();
        List<List<String>> prodArr = new ArrayList<>();
        String csvFile = "data/Sales.csv";
        String PcsvFile = "data/Product.csv";
        BufferedReader br = null;
        BufferedReader prod_br = null;
        String line = "";
        String cvsSplitBy = ",";
        System.out.println("Order-Id	Item-id	Product-Id	Quantity	Sales-Id	Customer-Id	Sales-Price-Per-Prod	Market-Segment");
        System.out.println(" Product-Id, Min-Price, Max-Price, Target-Price");

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] sales = line.split(cvsSplitBy);

                salesArr.add(Arrays.asList(sales));

            }

            prod_br = new BufferedReader(new FileReader(PcsvFile));
            while ((line = prod_br.readLine()) != null) {

                String[] product = line.split(cvsSplitBy);
                prodArr.add(Arrays.asList(product));

            }

            int prodId = 0;
            double targetVal = 0;
            String key = null;
            double sum = 0;
            double total_quant = 0;
            double avg = 0;
            double num = 0;
            double counter = 0;
            double check = 0, quantsum = 0;

            for (int k = 0; k < prodArr.size(); k++) {
                for (List<String> a : salesArr) {
                    key = Integer.toString(k);
                    if (a.get(2).equals(key)) {
                        double quant = Double.parseDouble(a.get(3));
                        double spp = Double.parseDouble(a.get(6));
                        check = quant * spp;
                        num = num + check;
                        quantsum += quant;
                        //  total_quant += quant;
                        counter++;
                    }
                }
                avg = Math.round(num / quantsum);

                averageSalesPrice.put(k, avg);
            }

            for (List<String> p : prodArr) {
                prodId = Integer.parseInt(p.get(0));
                targetVal = Double.parseDouble(p.get(3));
                originalTargetPrice.put(prodId, targetVal);

            }
            double difference = 0;

            for (int key1 : originalTargetPrice.keySet()) {
                if (averageSalesPrice.containsKey(key1) && originalTargetPrice.containsKey(key1)) {
                    difference = Math.round(averageSalesPrice.get(key1) - originalTargetPrice.get(key1));
                    ;
                    ogDifferenceSPTP.put(key1, difference);
                }
            }

            System.out.println("------Target Price---------");
            for (Entry<Integer, Double> mpd : originalTargetPrice.entrySet()) {
                System.out.println("Product ID: " + mpd.getKey() + " OG Target Price: " + mpd.getValue());
            }
            System.out.println(originalTargetPrice);
            System.out.println("-------Average SPP----------");
            for (Entry<Integer, Double> mpd : averageSalesPrice.entrySet()) {
                System.out.println("Product ID: " + mpd.getKey() + " Average Sale Price: " + mpd.getValue());
            }
            System.out.println(averageSalesPrice);
            System.out.println("------Difference-------------");
            for (Entry<Integer, Double> mpd : ogDifferenceSPTP.entrySet()) {
                System.out.println("Product ID: " + mpd.getKey() + " Difference Avg sales and TP: " + mpd.getValue());
            }
            System.out.println(ogDifferenceSPTP);

            double posFivePercent = 0;
            double negFivePercent = 0;
            double negnewAvgSP = 0;

            modifiedTargetPrice.putAll(originalTargetPrice);
            for (int keyset : modifiedTargetPrice.keySet()) {
                posFivePercent = (0.05 * averageSalesPrice.get(keyset)) + averageSalesPrice.get(keyset);
                negFivePercent = averageSalesPrice.get(keyset) - (0.05 * averageSalesPrice.get(keyset));

//                if (keyset == 6) {
//                    System.out.println("pos " + posFivePercent + " neg " + negFivePercent);
//                }
                if (originalTargetPrice.get(keyset) > posFivePercent) {
                    // System.out.println("---------------------------------------------------------"+ keyset);
                    negnewAvgSP = averageSalesPrice.get(keyset) + (averageSalesPrice.get(keyset) * 0.05);

                    modifiedTargetPrice.put(keyset, negnewAvgSP);
                } else {

                    negnewAvgSP = averageSalesPrice.get(keyset) - (averageSalesPrice.get(keyset) * 0.05);
                    modifiedTargetPrice.put(keyset, negnewAvgSP);
                }

            }

            double difference1 = 0;

            for (int key1 : modifiedTargetPrice.keySet()) {
                if (averageSalesPrice.containsKey(key1) && originalTargetPrice.containsKey(key1)) {
                    difference1 = Math.round(averageSalesPrice.get(key1) - modifiedTargetPrice.get(key1));
                    modDifferenceSPTP.put(key1, difference1);
                }
            }

            System.out.println("-------New Average SPP----------");
            for (Entry<Integer, Double> mpd : averageSalesPrice.entrySet()) {
                System.out.println("Product ID: " + mpd.getKey() + " New Average Sale Price: " + mpd.getValue());
            }

            System.out.println("-------New Target Price-----------");
            for (Entry<Integer, Double> mpd : modifiedTargetPrice.entrySet()) {
                System.out.println("Product ID: " + mpd.getKey() + " New Target Price " + mpd.getValue());
            }

            System.out.println("-------New Sales Difference----------");
            for (Entry<Integer, Double> mpd : modDifferenceSPTP.entrySet()) {
                System.out.println("Product ID: " + mpd.getKey() + " Difference of SP and TP " + mpd.getValue());
            }

            System.out.println("-------Error Margin----------");

            int count = 0;
            for (int i : modifiedTargetPrice.keySet()) {

                double targetPrice = modifiedTargetPrice.get(i);
                double avgSales = 0.0;
                if (averageSalesPrice.containsKey(i)) {
                    count++;
                    avgSales = averageSalesPrice.get(i);
                }

                double diff = targetPrice - avgSales;
                //   System.out.println("Average Sales "+avgSales+" diff "+ diff);
                double error = (diff) / avgSales;
                //     System.out.print("Error"+ error + "   ");
                System.out.format("Product ID: " + i + " Error Margin %.2f ", error * 100);
                System.out.println();
            }

            for (int key2 : originalTargetPrice.keySet()) {
                if (averageSalesPrice.get(key2) <= originalTargetPrice.get(key2)) {
                    ogProductLower.put(key2, averageSalesPrice.get(key2));
                } else {
                    ogProductHigher.put(key2, averageSalesPrice.get(key2));
                }
            }

            for (int key3 : originalTargetPrice.keySet()) {
                if (averageSalesPrice.get(key3) <= modifiedTargetPrice.get(key3)) {
                    modProductLower.put(key3, averageSalesPrice.get(key3));
                } else {
                    modProductHigher.put(key3, averageSalesPrice.get(key3));
                }
            }

            System.out.println(ogProductLower);
            System.out.println(ogProductHigher);
            System.out.println(originalTargetPrice);

            System.out.println("------------------------------------------");

            System.out.println(modifiedTargetPrice);
            System.out.println(modProductHigher);
            System.out.println(modProductLower);

            LinkedHashMap<Integer, Double> sortedMapOG
                    = ogDifferenceSPTP.entrySet().stream().
                            sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                            collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                    (e1, e2) -> e1, LinkedHashMap::new));

            System.out.println("---------------------------------------------------------------------");
            System.out.println("Sorted Difference between ORIGINAL SP and TP");
            for (Entry<Integer, Double> mpd : sortedMapOG.entrySet()) {
                System.out.println("Product ID: " + mpd.getKey() + " Difference of SP and TP " + mpd.getValue());
            }

            LinkedHashMap<Integer, Double> sortedMapMod
                    = modDifferenceSPTP.entrySet().stream().
                            sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                            collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                    (e1, e2) -> e1, LinkedHashMap::new));

            System.out.println("---------------------------------------------------------------------");
            System.out.println("Sorted Difference between MODIFIED SP and TP");
            for (Entry<Integer, Double> mpd : sortedMapMod.entrySet()) {
                System.out.println("Product ID: " + mpd.getKey() + " Difference of SP and TP " + mpd.getValue());
            }

            // System.out.println("Count : "+count);
//            System.out.println(modifiedTargetPrice);
//            
//            System.out.println(ogDiffSPTargetPrice);
//            System.out.println(modifiedSPTargetPrice);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void question5Dynamic() {

        Map<Integer, Double> averageSalesPrice = new HashMap<>();
        Map<Integer, Double> originalTargetPrice = new HashMap<>();
        Map<Integer, Double> modifiedTargetPrice = new HashMap<>();
        Map<Integer, Double> errorMap = new HashMap<>();
        Map<Integer, Double> ogDifferenceSPTP = new HashMap<>();
        Map<Integer, Double> modDifferenceSPTP = new HashMap<>();

        Map<Integer, Double> ogProductLower = new HashMap<>();
        Map<Integer, Double> ogProductHigher = new HashMap<>();
        Map<Integer, Double> modProductLower = new HashMap<>();
        Map<Integer, Double> modProductHigher = new HashMap<>();

        Map<Integer, Double> ogProductLower1 = new HashMap<>();
        Map<Integer, Double> ogProductHigher1 = new HashMap<>();
        Map<Integer, Double> modProductLower1 = new HashMap<>();
        Map<Integer, Double> modProductHigher1 = new HashMap<>();

        List<List<String>> salesArr = new ArrayList<>();
        List<List<String>> prodArr = new ArrayList<>();

        Map<Integer, Product> prod = DataStore.getInstance().getProductMap();

        Map<Integer, Order> order = DataStore.getInstance().getOrderMap();
        Map<Integer, Double> targetPriceMap = DataStore.getInstance().getTargetPriceMap();

        int productId = 0, prodId = 0;
        double targetPrice = 0, targetVal = 0, difference = 0;;
        double salesPrice = 0;
        double fullSalesPrice = 0;
        int quantity = 0;
        double avgSalesPrice = 0, total = 0, sumquant = 0;

        for (Product p : prod.values()) {

            for (Order o : order.values()) {
                if (p.getProductId() == o.getItem().getProductId()) {
                    productId = o.getItem().getProductId();
                    targetPrice = targetPriceMap.get(productId);
                    salesPrice = o.getItem().getSalesPrice();
                    quantity = o.getItem().getQuantity();

                    fullSalesPrice = quantity * salesPrice;
                    total += fullSalesPrice;
                    sumquant += quantity;
                }

            }
            avgSalesPrice = Math.round(total / sumquant);

            //  System.out.println("Product id: " + productId + " Sales " + total + " Quant " + sumquant);
            averageSalesPrice.put(productId, avgSalesPrice);
        }

        for (Product p : prod.values()) {
            prodId = p.getProductId();
            targetVal = p.getTargetPrice();
            originalTargetPrice.put(prodId, targetVal);

        }

        for (int targetKey : originalTargetPrice.keySet()) {
            if (averageSalesPrice.containsKey(targetKey) && originalTargetPrice.containsKey(targetKey)) {
                difference = Math.round(averageSalesPrice.get(targetKey) - Math.round(originalTargetPrice.get(targetKey)));
            }

            ogDifferenceSPTP.put(targetKey, difference);
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                  QUESTION 5                                                               ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("Product ID     Avg SP     Target SP               Difference SP- TP");
//        System.out.println("-----------------------------------------------------------------------------------------------");

        LinkedHashMap<Integer, Double> sortedMapOG
                = ogDifferenceSPTP.entrySet().stream().
                        sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));

        for (int key2 : originalTargetPrice.keySet()) {
            if (averageSalesPrice.get(key2) <= originalTargetPrice.get(key2)) {
                ogProductLower.put(key2, averageSalesPrice.get(key2));
            } else {
                ogProductHigher.put(key2, averageSalesPrice.get(key2));
            }
        }

        for (int ii : sortedMapOG.keySet()) {
            if (ogProductLower.containsKey(ii)) {
                ogProductLower1.put(ii, ogProductLower.get(ii));
            }

        }

        for (int ii : sortedMapOG.keySet()) {
            if (ogProductHigher.containsKey(ii)) {
                ogProductHigher1.put(ii, ogProductHigher.get(ii));
            }

        }

        System.out.println(sortedMapOG);

        Object arre1[] = sortedMapOG.keySet().toArray();
        Object arre2[] = ogProductLower1.keySet().toArray();
        Object arre3[] = ogProductHigher1.keySet().toArray();
        System.out.println("===============================================================================================");
        System.out.println("ORIGINAL TARGET PRICE TABLE");
        System.out.println("===============================================================================================");
        System.out.println("Product ID     Avg Selling Price        Original Target Price          Difference Selling- Target");

        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("AVERAGE PRICE LESS THAN ORIGINAL TARGET PRICE");
        for (Object i : arre1) {

// System.out.println();
            int productId1 = (int) i;
            double salesPrice1 = averageSalesPrice.get(i);
            double tp2 = originalTargetPrice.get(i);
            double diff4 = sortedMapOG.get(i);
            if (salesPrice1 < tp2) {
                System.out.println(productId1 + "\t\t\t" + salesPrice1 + "\t\t\t" + tp2 + "\t\t\t" + diff4);
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("AVERAGE PRICE GREATER THAN ORIGINAL TARGET PRICE");

        for (Object i : arre1) {

// System.out.println();
            int productId1 = (int) i;
            double salesPrice1 = averageSalesPrice.get(i);
            double tp2 = originalTargetPrice.get(i);
            double diff4 = sortedMapOG.get(i);
            if (salesPrice1 > tp2) {
                System.out.println(productId1 + "\t\t\t" + salesPrice1 + "\t\t\t" + tp2 + "\t\t\t" + diff4);
            }
        }

        double posFivePercent = 0;
        double negFivePercent = 0;
        double negnewAvgSP = 0;

        modifiedTargetPrice.putAll(originalTargetPrice);
        for (int keyset : modifiedTargetPrice.keySet()) {
            posFivePercent = (0.05 * averageSalesPrice.get(keyset)) + averageSalesPrice.get(keyset);
            negFivePercent = averageSalesPrice.get(keyset) - (0.05 * averageSalesPrice.get(keyset));
            //            if (keyset == 8) {
            //                System.out.println("pos " + posFivePercent + " neg " + negFivePercent);
            //            }

            if (Math.round(originalTargetPrice.get(keyset) - averageSalesPrice.get(keyset)) == 0) {
                modifiedTargetPrice.put(keyset, averageSalesPrice.get(keyset));
            } else if (originalTargetPrice.get(keyset) >= posFivePercent) {
                // System.out.println("---------------------------------------------------------"+ keyset);
                //   System.out.println("KEYSET   _________" + keyset);
                negnewAvgSP = averageSalesPrice.get(keyset) + (averageSalesPrice.get(keyset) * 0.05);

                modifiedTargetPrice.put(keyset, negnewAvgSP);
            } else {
                negnewAvgSP = averageSalesPrice.get(keyset) - (averageSalesPrice.get(keyset) * 0.05);
                // System.out.println("KEYSET   _________" + keyset);
                modifiedTargetPrice.put(keyset, negnewAvgSP);
            }

        }

        double difference1 = 0;

        for (int key1 : modifiedTargetPrice.keySet()) {
            if (averageSalesPrice.containsKey(key1) && originalTargetPrice.containsKey(key1)) {
                difference1 = Math.round(averageSalesPrice.get(key1) - modifiedTargetPrice.get(key1));
                modDifferenceSPTP.put(key1, difference1);
            }
        }

        int count = 0;
        for (int i : modifiedTargetPrice.keySet()) {

            double targetPrice1 = modifiedTargetPrice.get(i);
            double avgSales = 0.0;
            if (averageSalesPrice.containsKey(i)) {
                count++;
                avgSales = averageSalesPrice.get(i);
            }

            double diff = targetPrice1 - avgSales;
            //   System.out.println("Average Sales "+avgSales+" diff "+ diff);
            double error = (diff) / avgSales;
            //     System.out.print("Error"+ error + "   ");

            errorMap.put(i, error * 100);
            //   System.out.format("Product ID: " + i + " Error Margin %.2f ", error * 100);
            // System.out.println();
        }

        LinkedHashMap<Integer, Double> sortedMapMod
                = modDifferenceSPTP.entrySet().stream().
                        sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
        for (int key3 : originalTargetPrice.keySet()) {
            if (averageSalesPrice.get(key3) <= modifiedTargetPrice.get(key3)) {
                modProductLower.put(key3, averageSalesPrice.get(key3));
            } else {
                modProductHigher.put(key3, averageSalesPrice.get(key3));
            }
        }

        for (int io : sortedMapMod.keySet()) {
            if (modProductLower.containsKey(io)) {
                modProductLower1.put(io, modProductLower.get(io));
            }

        }

        for (int io : sortedMapMod.keySet()) {
            if (modProductHigher.containsKey(io)) {
                modProductHigher1.put(io, modProductHigher.get(io));
            }

        }

        System.out.println(sortedMapMod);

        Object arrr1[] = sortedMapMod.keySet().toArray();
        Object arrr2[] = modProductLower1.keySet().toArray();
        Object arrr3[] = modProductHigher1.keySet().toArray();

        System.out.println("=======================================================================================================================================");
        System.out.println("MODIFIED TARGET PRICE TABLE");
        System.out.println("=======================================================================================================================================");
        System.out.println("Product ID           Avg SP            Modified Target SP         Difference SP- modified TP         Error Margin");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("AVERAGE PRICE LESS THAN MODIFIED TARGET PRICE");

        for (Object i : arrr1) {
// System.out.println();
            int productId1 = (int) i;
            double salesPrice1 = averageSalesPrice.get(i);
            double tp2 = modifiedTargetPrice.get(i);
            double diff4 = sortedMapMod.get(i);
            double error1 = errorMap.get(i);
            if (salesPrice1 < tp2) {
                System.out.println(productId1 + "\t\t\t" + salesPrice1 + "\t\t\t" + tp2 + "\t\t\t" + diff4 + "\t\t\t" + errorMap.get(i));
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("AVERAGE PRICE GREATER THAN MODIFIED TARGET PRICE");
        for (Object i : arrr1) {
// System.out.println();
            int productId1 = (int) i;
            double salesPrice1 = averageSalesPrice.get(i);
            double tp2 = modifiedTargetPrice.get(i);
            double diff4 = sortedMapMod.get(i);
            double error1 = errorMap.get(i);
            if (salesPrice1 > tp2) {
                System.out.println(productId1 + "\t\t\t" + salesPrice1 + "\t\t\t" + tp2 + "\t\t\t" + diff4 + "\t\t\t" + errorMap.get(i));
            }

        }

    }


    }


