package by.komposter.DB;

import by.komposter.Core.AppSettings;
import by.komposter.Notificator.Notificator;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLFileReader {
    private String filePath;
    private String fileName;
    private String result = "";
    private AppSettings appS;
    private String s1;
    private ArrayList<String> cmds = new ArrayList<String>();
    BufferedReader input;

    public SQLFileReader() {
        appS = new AppSettings();
        this.filePath = appS.getParamVal("appdir");
        this.fileName = "DBScheme.sql";
        try {
            File sql = new File(this.filePath + this.fileName);
            if (!sql.exists()) {
                File sql2 = new File(this.filePath + "\\" + this.fileName);
                if (!sql2.exists()) throw new FileNotFoundException();
            }
        } catch (FileNotFoundException ex) {
            Notificator.pushToScreenNlog(ex);
        }
    }

    public ArrayList<String> read() throws IOException {
        Pattern p1 = Pattern.compile("\\s+\\S+$");
        Pattern p2 = Pattern.compile("^(-+.+$)");
        Matcher m1, m2;
        input = new BufferedReader(new FileReader(filePath + "" + fileName));
        while ((s1 = input.readLine()) != null) {
            m1 = p1.matcher(s1);
            m2 = p2.matcher(s1);
            if (m1.find() && !m2.find()) cmds.add(s1);
        }
        input.close();
        return cmds;
    }

    public ArrayList<String> changeSQLscript(ArrayList<String> queries, String newDB) {
        ArrayList<String> tempIn = new ArrayList<>();
        ArrayList<String> tempOut = new ArrayList<>();
        try {
            tempIn.addAll(queries);
            Iterator<String> it = tempIn.iterator();
            while (it.hasNext()) tempOut.add(it.next().replaceAll("EasyInv", newDB));
        } catch (Exception ex) {
            Notificator.pushToScreenNlog(ex);
        }
        return tempOut;
    }
}
/*
    public void write(ArrayList<String> lines) {
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(filePath + "" + fileName));
            try {
                Iterator it = lines.iterator();
                while (it.hasNext()) {
                    output.write(it.next().toString());
                    output.newLine();
                }
            } catch (Exception ex) {
                writeToLog(ex.getMessage());
            } finally {
                output.close();
            }
        } catch (IOException e) {
            writeToLog(e.getMessage());
        }
    }
    public String toString(){
        String s2 = "";
        StringBuilder sb = new StringBuilder(result);
        Iterator it = cmds.iterator();
        while (it.hasNext()){
            sb.append("\n");
            sb.append(it.next());}
        return sb.toString();
    }
*/
