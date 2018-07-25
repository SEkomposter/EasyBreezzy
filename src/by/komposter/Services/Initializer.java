package by.komposter.Services;

import by.komposter.objectFactory.Host;
import by.komposter.objectFactory.Node;

public class Initializer {
    static Node nd;
    static Host host;
    static NodeService nodeService;
    static {
        nodeService = new NodeService();
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

        nodeService.createItem(nd);
        nodeService.createItem(host);

    }
}
