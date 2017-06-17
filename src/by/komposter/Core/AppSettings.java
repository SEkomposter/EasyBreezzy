package by.komposter.Core;

import java.util.*;

public class AppSettings {

    private String message = "parameter not found";
    private Map.Entry<String,String> parameter;
    private Map<String,String> paramSet;
    public AppSettings(){
        paramSet = new LinkedHashMap<>();
    }
    public String getParamVal(String pname){
        IOClass ioc = new IOClass();
        paramSet = ioc.readFromIni();
        Set<String> tempG = new LinkedHashSet<String>();
        tempG = paramSet.keySet();
        for (String key: tempG){
            if (key.equalsIgnoreCase(pname)) return paramSet.get(key);
        }
        return message;
    }
    public Map<String,String> getListParams(){
        IOClass readAll = new IOClass();
        return readAll.readFromIni();
    }
    public void setParam(String pname, String val){
        paramSet = getListParams();
        LinkedHashMap<String,String> tempM = new LinkedHashMap<String,String>();
        tempM.putAll(paramSet);
        Set<String> tempS = new LinkedHashSet<String>();
        tempS = tempM.keySet();
        IOClass iniWriter = new IOClass();
        for (String key: tempS){
            if (key.equalsIgnoreCase(pname)) {
                tempM.replace(key,val);
                iniWriter.writeToIni(tempM);
                return;
            }
        }
        tempM.put(pname,val);
        iniWriter.writeToIni(tempM);
    }
}

