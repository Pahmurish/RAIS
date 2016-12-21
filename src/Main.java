import org.apache.commons.cli.*;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws ParseException {
        Option ren = new Option("r", "rename", true, "rename file");
        ren.setOptionalArg(false);
        Options posixOptions = new Options();
        posixOptions.addOption(ren);
        PosixParser parser = new PosixParser();
        CommandLine commandLine = parser.parse(posixOptions, args);
        if (commandLine.hasOption("r")) {
            String[] arguments = commandLine.getOptionValues("r");
            NewName newName = new NewName();
            String s = NewName.readThisName();
            File[] filesList;
            File filesPath = new File ("C:\\Problema\\New Application 2\\jpg");
            filesList = filesPath.listFiles();
            File MostOldFile =null;

           for (int i=filesList.length-1; i>=0; i--){
               for (int j=0; j<i; j++) {
                   if (filesList[j].isFile() && filesList[j+1].isFile() && (filesList[j].lastModified() < filesList[j+1].lastModified())) {
                       MostOldFile = filesList[j];
                       filesList[j] = filesList[j+1];
                       filesList[j+1] = MostOldFile;
                   }
               }
            }

            int st=0;
            for (int i=0; i<filesList.length; i++) {
                String buf = filesList[i].getName();
                if (buf.endsWith(".jpg")) {
                    st=st+1;
                    Pattern p = Pattern.compile(".+\\.jpg");
                    Matcher m = p.matcher(buf);
                    buf = m.replaceAll( s+"_"+st);
                    filesList[i].renameTo(new File("C:\\Problema\\New Application 2\\jpg\\"+buf+".jpg"));

                }
            }

        }

    }
}