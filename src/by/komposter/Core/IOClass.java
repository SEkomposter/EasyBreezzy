package by.komposter.Core;

import by.komposter.Notificator.Notificator;

import java.io.*;
import java.nio.file.FileSystemException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOClass {
    Map<String,String> params = new LinkedHashMap<String,String>();
    String filePath = "d:\\EasyBreezzy\\";
    IOClass(){

    }
    public void writeToIni(Map map){
        try {
            Set<String> tempS = new LinkedHashSet<String>();
            File ini = new File(filePath + "config.ini");
            BufferedWriter output = new BufferedWriter(new FileWriter(ini));
            try {

                if (ini.exists()) {
                    if (ini.canWrite()) {
                        tempS = map.keySet();
                        Iterator it = tempS.iterator();
                        String key;
                        while (it.hasNext()) {
                            key = (String) it.next();
                            output.write(key + "=" + map.get(key));
                            output.newLine();
                        }
                    }
                    else throw new FileSystemException("Can`t write");
                }
                else {
                    ini.createNewFile();
                    writeToIni(map);
                }
            } catch (Exception e) {
                Notificator.pushToScreenNlog(e, this.getClass());

            } finally {
                output.close();
            }
        }
        catch (FileNotFoundException e){
            Notificator.pushToScreenNlog(e, this.getClass(),"Ini not found. Recreated");
        }
        catch (IOException e){
            Notificator.pushToScreenNlog(e,this.getClass());
        }

    }
    public Map<String,String> readFromIni(){
        try {
            File ini = new File(filePath + "config.ini");
            BufferedReader input = new BufferedReader(new FileReader(ini));

            try {
                String s1;
                Pattern pat = Pattern.compile("(\\w+)(=)(\\w*[:\\\\\\w\\W]*)", Pattern.CASE_INSENSITIVE);
                Matcher mat;

                while ((s1 = input.readLine()) != null) {
                    mat = pat.matcher(s1);
                    if (mat.find()) {
                        params.put(mat.group(1), mat.group(3));
                        //System.out.println(mat.group(1));
                    }
                }
                input.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                input.close();
            }
        }
        catch (Exception e){
            Notificator.pushToScreenNlog(e,this.getClass(),"Ini not found. Recreated");
        }
        return params;
    }
}
