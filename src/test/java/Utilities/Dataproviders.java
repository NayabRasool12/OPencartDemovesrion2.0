package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {



    @DataProvider(name ="LoginData")
  public String[][] getdata() throws IOException {

        String path = ".\\testData\\opencarTestingdata.xlsx"; // creating path data excel

        Excelfileutility xlutil = new Excelfileutility(path); // creating object for utility

        int  totalrowcount =   xlutil.getRowCount("sheet1");
        int totalcolcount =   xlutil.getCellcount("sheet1", 1);

        String Logindata[][]  = new String[totalrowcount][totalcolcount];  // creating two dimentional array
      for (int i = 1; i <= totalrowcount; i++) {  // read the xl file data in storing in 2 dimenstional array
          for (int j = 0; j< totalcolcount; j++) {  // i is row j is col
          Logindata[i-1][j] = xlutil.getCellData("sheet1", i , j);
          }
       }
      return Logindata;
      }
    }

