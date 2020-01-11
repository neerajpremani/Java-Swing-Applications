/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.analytics;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author neera
 */
public class CheckStatic {

    public static void top3ProdStatic() throws IOException {
        Map<Integer, Integer> top3P = new HashMap<>();
        Map<Integer, Double> originalTargetPrice = new HashMap<>();
        Map<Integer, Double> modifiedTargetPrice = new HashMap<>();

        Map<Integer, Double> ogDifferenceSPTP = new HashMap<>();
        Map<Integer, Double> modDifferenceSPTP = new HashMap<>();

        Map<Integer, Double> ogProductLower = new HashMap<>();
        Map<Integer, Double> ogProductHigher = new HashMap<>();
        Map<Integer, Double> modProductLower = new HashMap<>();
        Map<Integer, Double> modProductHigher = new HashMap<>();
        Map<Integer, Double> targetPriceMap = DataStore.getInstance().getTargetPriceMap();
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
            List<String> itr = new ArrayList<>();
            double keyVal = 0;
            for (List<String> a : salesArr) {
                int k = Integer.parseInt(a.get(2));
                int tp1 = 0;
                for (int res = 0; res < prodArr.size(); res++) {
                    key = Integer.toString(k);
                    if (prodArr.get(res).equals(key)) {
                        itr = prodArr.get(3);
                        keyVal = Double.parseDouble(itr.get(0));
                        itr.clear();

                    }
                }
                // double targetprice = targetPriceMap.get(k);
                int quant = Integer.parseInt(a.get(3));
                double spp = Double.parseDouble(a.get(6));
                double diff = spp - keyVal;
                int temp = 0;
                if (diff > 0) {
                    if (top3P.containsKey(k)) {
                        temp = top3P.get(k);

                    }
                    quant += temp;
                    top3P.put(k, quant);
                }

            }

            LinkedHashMap<Integer, Integer> sortedMap
                    = top3P.entrySet().stream().
                            sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(5).
                            collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                    (e1, e2) -> e1, LinkedHashMap::new));
            System.out.println(sortedMap);

            int keys1 = 0;
            ArrayList<Integer> al1 = new ArrayList<>();
            LinkedHashMap<Integer, ArrayList<Integer>> lh1 = new LinkedHashMap<>();
            for (Map.Entry<Integer, Integer> val : sortedMap.entrySet()) {
                if (sortedMap.containsValue(val.getValue())) {
                    keys1 = val.getKey();
                    al1.add(keys1);
                   // System.out.println("ALLLLLLLL " + al1);

                }
                lh1.put(val.getValue(), al1);

            }
            al1.clear();

            System.out.println("BHVCYGHVJBKBVGHCF " + lh1);

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
}
