package by.komposter.Services;

import by.komposter.objectFactory.Host;
import by.komposter.objectFactory.Node;

public class Initializer {
    static Node nd;
    static Host host;
    static ItemService itemService;
    static {
        itemService = new ItemService();
        nd = new Node();
        nd.setId(0);
        nd.setNodeName("None");
        host = new Host();
        host.setId(0);
        host.setHostName("None");
        host.setNode(nd);
        nd.getSetHosts().add(host);
    }
    public static void makeFirstInit() throws Exception{

        itemService.createItem(nd);
       // itemService.createItem(host);

    }
}
