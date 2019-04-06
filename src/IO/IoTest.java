package IO;

import java.io.*;

public class IoTest {
    public int addApend(String t) throws Exception{
        File file = new File("c:"+File.separator+"spoartDep"+File.separator+"name.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
            Writer out = new FileWriter(file,true);
            out.write("名单列表");
            out.close();
        }
            Writer out = new FileWriter(file,true);
            out.write(t);
            out.close();
       return 1;
    }
    public int addOverride(String t) throws Exception{
        File file = new File("c:"+File.separator+"spoartDep"+File.separator+"name.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
            Writer out = new FileWriter(file);
            out.write("名单列表");
            out.close();
        }
        Writer out = new FileWriter(file);
        out.write(t);
        out.close();
        return 1;
    }
    public  String get() throws Exception{
        File file = new File("c:"+File.separator+"spoartDep"+File.separator+"name.txt");
        if(file.exists()){
            Reader in = new FileReader(file);
            char[] data = new char[1024];
            int len = in.read(data);
            in.close();
            return new String(data,0,len);
        }
        else
            return "没有数据";
    }
}
