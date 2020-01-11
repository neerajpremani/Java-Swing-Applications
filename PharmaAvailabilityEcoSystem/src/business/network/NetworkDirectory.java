/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.network;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author NEERAJ PREMANI
 */
public class NetworkDirectory {

    Map<String, Network> networkList;

    public NetworkDirectory() {
        this.networkList = new HashMap<>();
    }

    private boolean checkIfNetworkAlreadyExists(String name) {
        return networkList.containsKey(name);
    }

    public Network createAndAddNetwork(String name) {
        if (checkIfNetworkAlreadyExists(name)) {
            //network already exists
            return null;
        }

        Network network = new Network();
        network.setName(name);
        //left
        //Check if netwrok already exists
        networkList.put(network.getName(), network);
        return network;
    }

    public List<Network> getNetworkList() {

        return networkList.values().stream().collect(Collectors.toList());
    }

    public void setNetworkList(Map<String, Network> networkList) {
        this.networkList = networkList;
    }

    //left
    public void deleteNetwork(Network network) {
        networkList.remove(network.getName());

    }

    public void updateNetwork(Network network, String newName) {
        Network network1 = networkList.remove(network.getName());
        network1.setName(newName);
        networkList.put(newName, network1);
    }
}
